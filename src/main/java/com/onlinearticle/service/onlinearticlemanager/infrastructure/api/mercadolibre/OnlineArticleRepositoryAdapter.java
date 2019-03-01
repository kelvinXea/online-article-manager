package com.onlinearticle.service.onlinearticlemanager.infrastructure.api.mercadolibre;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlinearticle.service.onlinearticlemanager.domain.model.ArticleRequest;
import com.onlinearticle.service.onlinearticlemanager.domain.model.OnlineArticle;
import com.onlinearticle.service.onlinearticlemanager.domain.model.OnlineResult;
import com.onlinearticle.service.onlinearticlemanager.domain.model.enums.Market;
import com.onlinearticle.service.onlinearticlemanager.domain.model.enums.Shipping;
import com.onlinearticle.service.onlinearticlemanager.domain.port.OnlineArticleRepository;
import com.onlinearticle.service.onlinearticlemanager.infrastructure.api.mercadolibre.manager.MercadoLibreApiManager;
import com.onlinearticle.service.onlinearticlemanager.infrastructure.api.mercadolibre.object.MercadoLibreItemObject;
import com.onlinearticle.service.onlinearticlemanager.infrastructure.api.mercadolibre.object.MercadoLibreResultObject;

@Repository
public class OnlineArticleRepositoryAdapter implements OnlineArticleRepository {

	@Autowired
	private MercadoLibreApiManager mercadoLibreApiManager;

	@Override
	public OnlineArticle getOnlineArticle(String id, Market market) {
		if (market.equals(Market.MCO)) {
			MercadoLibreItemObject mco = mercadoLibreApiManager.getMercadoLibreItem(id);

			return mercadoLibreToOnlineObject(mco);

		}
		return null;
	}

	@Override
	public OnlineResult getOnlineResult(ArticleRequest articleRequest) {
		if (articleRequest.getMarket().equals(Market.MCO)) {

			MercadoLibreResultObject mco = mercadoLibreApiManager.getMercadoLibreResultItems(
					articleRequest.getMarket().toString(), articleRequest.getSearch(),
					((articleRequest.getPage() - 1) * articleRequest.getResultQuantity()), articleRequest.getResultQuantity());

			return mercadoLibreResultToOnlineResult(mco);

		}
		return null;
	}

	private OnlineArticle mercadoLibreToOnlineObject(MercadoLibreItemObject mco) {

		OnlineArticle oa = new OnlineArticle();
		oa.setCurrency(mco.getCurrencyId());
		oa.setId(mco.getId());
		oa.setTitle(mco.getTitle());
		oa.setAddress(
				mco.getCountryName().concat(" ").concat(mco.getStateName()).concat(" ").concat(mco.getCityName()));
		oa.setPrice(mco.getPrice());
		oa.setOriginalURL(mco.getPermalink());
		oa.setImageUrl(mco.getThumbnail());
		oa.setRating(mco.getRatingAverage());
		oa.setQuantity(mco.getAvailableQuantity());
		oa.setShipping(mco.isFreeShipping() ? Shipping.FREE : Shipping.REGULAR);
		oa.setMarket(Market.valueOf(mco.getSiteId()));
		return oa;

	}

	private OnlineResult mercadoLibreResultToOnlineResult(MercadoLibreResultObject mcro) {

		List<OnlineArticle> results = new ArrayList<>();

		mcro.getResultList().forEach(item -> results.add(mercadoLibreToOnlineObject(item)));
		int totalPages = (int) Math.ceil( mcro.getTotal() / (double) mcro.getLimit());

		return new OnlineResult((mcro.getOffset() / mcro.getLimit()) + 1, totalPages, results);
	}

	@Override
	public List<OnlineArticle> getNewOnlineArticleList(List<OnlineArticle> oldList) {
		//VALIDAR MARKET (FUTURA UPDATE)
		List<String> ids = oldList.stream().map(OnlineArticle::getId).collect(Collectors.toList());
		List<MercadoLibreItemObject> lista = mercadoLibreApiManager.getMercadoLibreItems(ids);
		
		List<OnlineArticle> listaOnlineArticle = new ArrayList<>();
		
		lista.forEach(v -> listaOnlineArticle.add(mercadoLibreToOnlineObject(v)));
		
		return listaOnlineArticle;
	}

}

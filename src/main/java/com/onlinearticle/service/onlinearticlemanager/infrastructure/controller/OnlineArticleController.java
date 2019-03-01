package com.onlinearticle.service.onlinearticlemanager.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlinearticle.service.onlinearticlemanager.domain.model.ArticleRequest;
import com.onlinearticle.service.onlinearticlemanager.domain.model.OnlineArticle;
import com.onlinearticle.service.onlinearticlemanager.domain.model.OnlineResult;
import com.onlinearticle.service.onlinearticlemanager.domain.model.enums.Market;
import com.onlinearticle.service.onlinearticlemanager.domain.service.OnlineArticleService;

@RestController
public class OnlineArticleController {

	@Autowired
	private OnlineArticleService onlineArticleService;

	@GetMapping()
	public OnlineArticle getOnlineArticle(@RequestParam("id") String id, @RequestParam("market") Market market) {
		return onlineArticleService.getOnlineArticleById(id, market);
	}

	@GetMapping("/search")
	public OnlineResult searchOnlineResult(@RequestParam("query") String query, @RequestParam("market") Market market,
			@RequestParam("resultQuantity") Integer resultQuantity, @RequestParam("page") Integer page) {

		ArticleRequest ar = new ArticleRequest();

		ar.setMarket(market);
		ar.setSearch(query);
		ar.setPage(page);
		ar.setResultQuantity(resultQuantity);

		return onlineArticleService.getOnlineResult(ar);
	}

}

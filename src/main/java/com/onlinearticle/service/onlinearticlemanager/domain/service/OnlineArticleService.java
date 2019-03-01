package com.onlinearticle.service.onlinearticlemanager.domain.service;

import java.util.List;

import com.onlinearticle.service.onlinearticlemanager.domain.model.ArticleRequest;
import com.onlinearticle.service.onlinearticlemanager.domain.model.OnlineArticle;
import com.onlinearticle.service.onlinearticlemanager.domain.model.OnlineResult;
import com.onlinearticle.service.onlinearticlemanager.domain.model.enums.Market;
import com.onlinearticle.service.onlinearticlemanager.domain.port.OnlineArticleRepository;

public class OnlineArticleService {
	
	private OnlineArticleRepository onlineArticleRepository;
	
	
	public OnlineArticleService (OnlineArticleRepository onlineArticleRepository) {
		this.onlineArticleRepository = onlineArticleRepository;
	}
	
	public OnlineArticle getOnlineArticleById(String id, Market market) {
		return onlineArticleRepository.getOnlineArticle(id, market);
	}
	
	public OnlineResult getOnlineResult(ArticleRequest articleRequest) {
		return onlineArticleRepository.getOnlineResult(articleRequest);
	}
	
	public List<OnlineArticle> getNewOnlineArticleList(List<OnlineArticle> oldList){
		return onlineArticleRepository.getNewOnlineArticleList(oldList);
	}

}

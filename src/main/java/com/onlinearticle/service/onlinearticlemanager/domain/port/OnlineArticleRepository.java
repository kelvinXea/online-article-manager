package com.onlinearticle.service.onlinearticlemanager.domain.port;

import java.util.List;

import com.onlinearticle.service.onlinearticlemanager.domain.model.ArticleRequest;
import com.onlinearticle.service.onlinearticlemanager.domain.model.OnlineArticle;
import com.onlinearticle.service.onlinearticlemanager.domain.model.OnlineResult;
import com.onlinearticle.service.onlinearticlemanager.domain.model.enums.Market;

public interface OnlineArticleRepository {
	
	public OnlineArticle getOnlineArticle(String id, Market market);
	
	public OnlineResult getOnlineResult(ArticleRequest articleRequest);
	
	public List<OnlineArticle> getNewOnlineArticleList(List<OnlineArticle> oldList);

}

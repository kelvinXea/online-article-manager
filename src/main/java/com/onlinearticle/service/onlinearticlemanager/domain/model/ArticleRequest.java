package com.onlinearticle.service.onlinearticlemanager.domain.model;

import com.onlinearticle.service.onlinearticlemanager.domain.model.enums.Market;

public class ArticleRequest {
	
	private String search;
	private String category;
	private Integer resultQuantity;
	private Integer page;
	private Market market;
	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getResultQuantity() {
		return resultQuantity;
	}
	public void setResultQuantity(Integer resultQuantity) {
		this.resultQuantity = resultQuantity;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Market getMarket() {
		return market;
	}
	public void setMarket(Market market) {
		this.market = market;
	}
	
	
	
	

}

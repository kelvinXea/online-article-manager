package com.onlinearticle.service.onlinearticlemanager.domain.model;

import java.util.List;

public class OnlineResult {
	
	private int page;
	private int maxPages;
	private int resultQuantity;
	private List<OnlineArticle> results;

	public OnlineResult(int page, int maxPages, List<OnlineArticle> results) {
		this.page = page;
		this.maxPages = maxPages;
		this.results = results;
		this.resultQuantity = results.size();
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getMaxPages() {
		return maxPages;
	}
	public void setMaxPages(int maxPages) {
		this.maxPages = maxPages;
	}
	public List<OnlineArticle> getResults() {
		return results;
	}
	public void setResults(List<OnlineArticle> results) {
		this.results = results;
		this.resultQuantity = results.size();
	}
	public int getResultQuantity() {
		return resultQuantity;
	}
	
	

}

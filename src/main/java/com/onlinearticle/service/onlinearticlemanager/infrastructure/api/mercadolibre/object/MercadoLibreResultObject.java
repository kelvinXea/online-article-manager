package com.onlinearticle.service.onlinearticlemanager.infrastructure.api.mercadolibre.object;

import java.util.List;

public class MercadoLibreResultObject {
	
	private Integer total;
	private Integer offset;
	private Integer limit;
	private List<MercadoLibreItemObject> resultList;
	
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public List<MercadoLibreItemObject> getResultList() {
		return resultList;
	}
	public void setResultList(List<MercadoLibreItemObject> resultList) {
		this.resultList = resultList;
	}
	
	

}

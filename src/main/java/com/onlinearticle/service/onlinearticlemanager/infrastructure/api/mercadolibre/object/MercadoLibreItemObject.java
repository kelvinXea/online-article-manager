package com.onlinearticle.service.onlinearticlemanager.infrastructure.api.mercadolibre.object;

public class MercadoLibreItemObject {
	
	private String id;
	private String siteId;
	private String title;
	private long price;
	private long originalPrice;
	private String currencyId;
	private String categoryId;
	private String condition;
	private int availableQuantity;
	private int soldQuantity;
	private float ratingAverage;
	private boolean freeShipping;
	private String permalink;
	private String thumbnail;
	private String stateName;
	private String cityName;
	private String countryName;
	private String status;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public long getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(long originalPrice) {
		this.originalPrice = originalPrice;
	}
	public String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public long getSoldQuantity() {
		return soldQuantity;
	}
	public void setSoldQuantity(int soldQuantity) {
		this.soldQuantity = soldQuantity;
	}
	public float getRatingAverage() {
		return ratingAverage;
	}
	public void setRatingAverage(float ratingAverage) {
		this.ratingAverage = ratingAverage;
	}
	public boolean isFreeShipping() {
		return freeShipping;
	}
	public void setFreeShipping(boolean freeShipping) {
		this.freeShipping = freeShipping;
	}
	public String getPermalink() {
		return permalink;
	}
	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	
	
	

}

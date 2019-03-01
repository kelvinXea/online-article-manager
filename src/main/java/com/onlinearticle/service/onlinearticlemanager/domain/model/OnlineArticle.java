package com.onlinearticle.service.onlinearticlemanager.domain.model;

import com.onlinearticle.service.onlinearticlemanager.domain.model.enums.Market;
import com.onlinearticle.service.onlinearticlemanager.domain.model.enums.Shipping;

public class OnlineArticle {
	
	private String id;
	private Long price;
	private String currency;
	private String title;
	private String imageUrl;
	private Integer quantity;
	private Shipping shipping;
	private String address;
	private Float rating;
	private String originalURL;
	private Market market;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Shipping getShipping() {
		return shipping;
	}
	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getOriginalURL() {
		return originalURL;
	}
	public void setOriginalURL(String originalURL) {
		this.originalURL = originalURL;
	}
	public Market getMarket() {
		return market;
	}
	public void setMarket(Market market) {
		this.market = market;
	}
	
	
	

}

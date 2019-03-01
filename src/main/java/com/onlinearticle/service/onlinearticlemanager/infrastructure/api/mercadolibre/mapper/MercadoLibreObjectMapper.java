package com.onlinearticle.service.onlinearticlemanager.infrastructure.api.mercadolibre.mapper;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.onlinearticle.service.onlinearticlemanager.infrastructure.api.mercadolibre.object.MercadoLibreItemObject;
import com.onlinearticle.service.onlinearticlemanager.infrastructure.api.mercadolibre.object.MercadoLibreResultObject;

@Component
public class MercadoLibreObjectMapper {

	public MercadoLibreResultObject toResultObject(JSONObject json) {
		MercadoLibreResultObject mlro = new MercadoLibreResultObject();
		JSONObject pagin = json.getJSONObject("paging");

		mlro.setLimit(pagin.getInt("limit"));
		mlro.setOffset(pagin.getInt("offset"));
		mlro.setTotal(pagin.getInt("total"));

		JSONArray arrayList = json.getJSONArray("results");
		List<MercadoLibreItemObject> resultList = new ArrayList<>();

		arrayList.forEach(item -> 
			resultList.add(toItemObject((JSONObject) item))
		);

		mlro.setResultList(resultList);
		return mlro;

	}

	public MercadoLibreItemObject toItemObject(JSONObject json) {
		MercadoLibreItemObject mco = new MercadoLibreItemObject();
		
		if(json.has("rating_average")) {
			mco.setRatingAverage(json.getFloat("rating_average"));
		}
		else if(!json.getJSONObject("reviews").isEmpty()){
			mco.setRatingAverage(json.getJSONObject("reviews").getFloat("rating_average"));
		}else {
			mco.setRatingAverage(0);
		}
		
		JSONObject address = json.getJSONObject("seller_address");

		mco.setId(json.getString("id"));
		mco.setSiteId(json.getString("site_id"));
		mco.setCategoryId(json.getString("category_id"));
		mco.setTitle(json.getString("title"));
		mco.setPrice(json.getLong("price"));
		mco.setOriginalPrice(json.optLong("original_price"));
		mco.setCurrencyId(json.getString("currency_id"));
		mco.setAvailableQuantity(json.getInt("available_quantity"));
		mco.setSoldQuantity(json.getInt("sold_quantity"));
		mco.setCondition(json.getString("condition"));
		mco.setPermalink(json.getString("permalink"));
		mco.setThumbnail(json.getString("thumbnail"));
		if(json.has("status")) {
			mco.setStatus(json.getString("status"));
		}else {
			mco.setStatus("active");
		}
		mco.setFreeShipping(json.getJSONObject("shipping").getBoolean("free_shipping"));
		mco.setStateName(address.getJSONObject("state").getString("name"));
		mco.setCityName(address.getJSONObject("city").getString("name"));
		mco.setCountryName(address.getJSONObject("country").getString("name"));

		return mco;

	}

}

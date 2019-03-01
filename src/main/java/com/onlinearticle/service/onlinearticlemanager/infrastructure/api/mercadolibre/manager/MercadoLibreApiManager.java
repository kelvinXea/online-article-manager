package com.onlinearticle.service.onlinearticlemanager.infrastructure.api.mercadolibre.manager;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.internal.util.logging.formatter.ArrayOfClassesObjectFormatter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.onlinearticle.service.onlinearticlemanager.infrastructure.api.mercadolibre.mapper.MercadoLibreObjectMapper;
import com.onlinearticle.service.onlinearticlemanager.infrastructure.api.mercadolibre.object.MercadoLibreItemObject;
import com.onlinearticle.service.onlinearticlemanager.infrastructure.api.mercadolibre.object.MercadoLibreResultObject;

@Component
public class MercadoLibreApiManager {
//TODO Implemetar un refresh token
	private static final String APP_ID = "3433230854313597";
	private static final String SECRET_KEY = "jyhejgKnGP3kyeZtyrkzA7yMRs1xSKWQ";
	private static final String BASE_URL = "https://api.mercadolibre.com";
	private static final String SITE_URL = "/sites/%s";
	private static final String SEARCH_URL = "/search";
	private static final String REVIEWS_URL = "/reviews";
	private static final String ITEMS_URL = "/items";
	private static final String ITEM_URL = "/item";
	private static final String QUERY_PARAM = "?q=%s";
	private static final String OFFSET_PARAM = "&offset=%s";
	private static final String LIMIT_PARAM = "&limit=%s";
	private static final String ACCESS_TOKEN_PARAM = "&access_token=%s";
	private static final String ID_PARAM = "/%s";
	private static final String IDS_PARAM = "?ids=";
	private static final String ACCESS_TOKEN = "APP_USR-3433230854313597-022809-dbd24ec6ed89edc165dd9f3ae934f1cb-396675663";
	private static final int MAX_IDS = 20;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private MercadoLibreObjectMapper mlom;

	public MercadoLibreItemObject getMercadoLibreItem(String id) {
		StringBuilder sb = new StringBuilder();

		final String urlToCall = sb.append(BASE_URL).append(ITEMS_URL).append(String.format(ID_PARAM, id)).toString();



		MercadoLibreItemObject mco = null;
		try {

			JSONObject review = getReview(id);
			JSONObject item = new JSONObject(restTemplate.getForObject(urlToCall, String.class));
			item.put("rating_average", review.getFloat("rating_average"));
			mco = mlom.toItemObject(item);

		} catch (RestClientException | JSONException e) {
			e.printStackTrace();
		}

		return mco;

	}

	public List<MercadoLibreItemObject> getMercadoLibreItems(List<String> ids) {
		List<MercadoLibreItemObject> lista = new ArrayList<>();
		String baseURL = new StringBuilder().append(BASE_URL).append(ITEMS_URL).append(IDS_PARAM).toString();
		int count = 0;
		StringBuilder sb = new StringBuilder();
		System.out.println("LLAMADOO "+ids.size());
		for (int i = 0; i < ids.size()+1; i++) {
			if(count == MAX_IDS || i == ids.size()) {
				String urloCall = sb.insert(0, baseURL).toString();
				System.out.println(urloCall);
				JSONArray result = new JSONArray(restTemplate.getForObject(urloCall, String.class));

				result.forEach( v -> {
					JSONObject item = ((JSONObject)v).getJSONObject("body");
					JSONObject review = getReview(item.getString("id"));
					item.put("rating_average", review.getFloat("rating_average"));
					lista.add(mlom.toItemObject(item));
				}
				);
				sb = new StringBuilder();
				count = 0;
				
			}else {
				sb.append(ids.get(i)).append(",");
				count++; 
			}
		}
		
		return lista;
		

	}

	public MercadoLibreResultObject getMercadoLibreResultItems(String site, String query, int offsetvalue, int limit) {
		StringBuilder sb = new StringBuilder();

		final String urlToCall = sb.append(BASE_URL).append(String.format(SITE_URL, site)).append(SEARCH_URL)
				.append(String.format(QUERY_PARAM, query)).append(String.format(OFFSET_PARAM, offsetvalue))
				.append(String.format(LIMIT_PARAM, limit)).append(String.format(ACCESS_TOKEN_PARAM, ACCESS_TOKEN))
				.toString();

		System.out.println(urlToCall);

		JSONObject result = new JSONObject(restTemplate.getForObject(urlToCall, String.class));

		return mlom.toResultObject(result);

	}
	
	private JSONObject getReview(String id) {
		StringBuilder sb = new StringBuilder();
		
		final String reviewURL = sb.append(BASE_URL).append(REVIEWS_URL).append(ITEM_URL)
				.append(String.format(ID_PARAM, id)).toString();
		return new JSONObject(restTemplate.getForObject(reviewURL, String.class));
		
	}

}

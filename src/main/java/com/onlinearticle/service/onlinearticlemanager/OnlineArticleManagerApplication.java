package com.onlinearticle.service.onlinearticlemanager;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.onlinearticle.service.onlinearticlemanager.domain.port.OnlineArticleRepository;
import com.onlinearticle.service.onlinearticlemanager.domain.service.OnlineArticleService;

@SpringBootApplication
public class OnlineArticleManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineArticleManagerApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public OnlineArticleService onlineArticleService(OnlineArticleRepository onlineArticleRepository) {
		return new OnlineArticleService(onlineArticleRepository);
	}

}

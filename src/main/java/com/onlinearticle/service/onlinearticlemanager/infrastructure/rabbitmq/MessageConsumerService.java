package com.onlinearticle.service.onlinearticlemanager.infrastructure.rabbitmq;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.onlinearticle.service.onlinearticlemanager.domain.model.OnlineArticle;
import com.onlinearticle.service.onlinearticlemanager.domain.service.OnlineArticleService;

public class MessageConsumerService {
	
	@Autowired
	private OnlineArticleService onlineArticleService;
	
	@RabbitListener(queues = "onlineArticleQueue", containerFactory = "jsonFactory")
	public List<OnlineArticle> consumer(List<OnlineArticle> loa) {
		return onlineArticleService.getNewOnlineArticleList(loa);
	}

}

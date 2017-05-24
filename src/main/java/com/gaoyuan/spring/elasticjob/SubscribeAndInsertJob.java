package com.gaoyuan.spring.elasticjob;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.gaoyuan.spring.dto.ProductCollect;
import com.gaoyuan.spring.service.IProductCollectService;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class SubscribeAndInsertJob implements SimpleJob{

	private static final String EXCHANGE_NAME = "product_collect";
	@Autowired
	private IProductCollectService collectService;
	
	public void execute(ShardingContext shardingContext){
//		// TODO 这是一种做法，需要启动多次任务，或者把插入放在consumer的方法里面，启动一次即可
//		List<ProductCollect> list = subscribeData();
//		collectService.insertList(list);
		
		ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("10.10.45.33");
		factory.setUsername("test");
		factory.setPassword("test");
		try {
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();

		    channel.exchangeDeclare(EXCHANGE_NAME, "direct");
		    String queueName = channel.queueDeclare().getQueue();
		    
		    channel.queueBind(queueName, EXCHANGE_NAME, "test");
		    Consumer consumer = new DefaultConsumer(channel) {
		      @Override
		      public void handleDelivery(String consumerTag, Envelope envelope,
		                                 AMQP.BasicProperties properties, byte[] body) throws IOException {
		        String message = new String(body, "UTF-8");
		        List<ProductCollect> list = JSON.parseArray(message,ProductCollect.class);
		        int i = collectService.insertList(list);
		        if (i > 0) {
					System.out.println("在 "+ new Date() +" 插入了：" + i + " 条");
				}
		      }
		    };
		    channel.basicConsume(queueName, true, consumer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
		

	private List<ProductCollect> subscribeData() {
		// TODO Auto-generated method stub
		return null;
	}

	
}

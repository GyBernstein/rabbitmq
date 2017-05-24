package com.gaoyuan.spring.rabbitmq;

import java.io.IOException;
import java.util.Random;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class ReceiveLogsTopic {

	private static final String EXCHANGE_NAME = "topic_logs";
	
	public static void main(String[] args) throws Exception{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("10.10.45.33");
		factory.setUsername("test");
		factory.setPassword("test");
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();

	    channel.exchangeDeclare(EXCHANGE_NAME, "topic");
	    String queueName = channel.queueDeclare().getQueue();

	    String[] argv = new String[5];
		argv[0] = "black";
		argv[1] = "orange";
		argv[2] = "green";
		argv[3] = "coffee";
		argv[4] = "sugar";
		
		String[] bindArray = new String[2];
		for (int i = 0; i < 2; i++) {
			bindArray[i] = getRouting(argv);
		}

	    for (String bindingKey : bindArray) {
	      channel.queueBind(queueName, EXCHANGE_NAME, bindingKey);
	    }

	    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

	    Consumer consumer = new DefaultConsumer(channel) {
	      @Override
	      public void handleDelivery(String consumerTag, Envelope envelope,
	                                 AMQP.BasicProperties properties, byte[] body) throws IOException {
	        String message = new String(body, "UTF-8");
	        System.out.println(" [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
	      }
	    };
	    channel.basicConsume(queueName, true, consumer);
	}
	
	private static String getRouting(String[] strings){
		int length = strings.length;
	    if (length < 1)
	        return "black.orange.coffee";
	    StringBuffer stringBuffer = new StringBuffer();
	    stringBuffer.append(strings[new Random().nextInt(length)]).append(".*.*");
	    
	    return stringBuffer.toString();
	}
}

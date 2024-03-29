package com.gaoyuan.spring.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Worker {

	private final static String QUEUE_NAME = "hello";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("10.10.45.33");
		factory.setUsername("test");
		factory.setPassword("test");
	    Connection connection = factory.newConnection();
	    final Channel channel = connection.createChannel();

	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
	    
	    channel.basicQos(1);// accept only one unack-ed message at a time (see below)
	    
	    final Consumer consumer = new DefaultConsumer(channel) {
	    	  @Override
	    	  public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
	    	    String message = new String(body, "UTF-8");

	    	    System.out.println(" [x] Received '" + message + "'");
	    	    try {
	    	      doWork(message);
	    	    } catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
	    	      System.out.println(" [x] Done");
	    	      channel.basicAck(envelope.getDeliveryTag(), false);
	    	    }
	    	  }
	    	};
    	boolean autoAck = false; // acknowledgment is covered below
    	channel.basicConsume(QUEUE_NAME, autoAck, consumer);
	}
	
	private static void doWork(String task) throws InterruptedException {
	    for (char ch: task.toCharArray()) {
	        if (ch == '.') Thread.sleep(1000);
	    }
	} 
}

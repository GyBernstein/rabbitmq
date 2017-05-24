package com.gaoyuan.spring.rabbitmq;

import java.util.Random;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitLogTopic {

	private static final String EXCHANGE_NAME = "topic_logs";

	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("10.10.45.33");
		factory.setUsername("test");
		factory.setPassword("test");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        String[] argv = new String[5];
		argv[0] = "black";
		argv[1] = "orange";
		argv[2] = "green";
		argv[3] = "coffee";
		argv[4] = "sugar";
		for(int i = 0; i < 100; i++) {
			String routingKey = getRouting(argv);
	        String message = getMessage(argv);

	        channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
	        System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");
		}

        connection.close();
	}
	
	private static String getRouting(String[] strings){
		int length = strings.length;
	    if (length < 1)
	        return "black.orange.coffee";
	    StringBuffer stringBuffer = new StringBuffer();
	    for(int i = 0; i < 2; i++) {
	    	stringBuffer.append(strings[new Random().nextInt(length)]).append(".");
	    }
	    stringBuffer.append(strings[new Random().nextInt(length)]);
	    
	    return stringBuffer.toString();
	}
    
    private static String getMessage(String[] strings){
	    if (strings.length < 1)
	        return "Hello World!";
	    return joinStrings(strings, " ");
	}

	private static String joinStrings(String[] strings, String delimiter) {
	    int length = strings.length;
	    if (length == 0) return "";
	    StringBuilder words = new StringBuilder(strings[0]);
	    for (int i = 1; i < length; i++) {
	        words.append(delimiter).append(strings[i]);
	    }
	    return words.toString();
	}
}

package com.gaoyuan.spring.rabbitmq;

import java.util.Random;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitLogDirect {

	 private static final String EXCHANGE_NAME = "direct_logs";

	    public static void main(String[] args)
	                  throws Exception {

	        ConnectionFactory factory = new ConnectionFactory();
	        factory.setHost("10.10.45.33");
			factory.setUsername("test");
			factory.setPassword("test");
	        Connection connection = factory.newConnection();
	        Channel channel = connection.createChannel();

	        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

	        String[] argv = new String[3];
			argv[0] = "black";
			argv[1] = "orange";
			argv[2] = "green";
	        String severity = getSeverity(argv);
	        String message = getMessage(argv);

	        channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes());
	        System.out.println(" [x] Sent '" + severity + "':'" + message + "'");

	        channel.close();
	        connection.close();
	    }
	    
	    private static String getSeverity(String[] strings){
		    if (strings.length < 1)
		        return "black";
		    int i = new Random().nextInt(3);
		    return strings[i];
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

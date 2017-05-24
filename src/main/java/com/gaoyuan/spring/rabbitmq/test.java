package com.gaoyuan.spring.rabbitmq;

import java.util.Random;

public class test {

	public static void main(String[] args) {
		for(int i=0; i<100000;i++){
			int j = new Random().nextInt(3);
			if (j==0) {
				System.err.println("___");
				break;
			}
		}
	}
}

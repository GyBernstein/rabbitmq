package com.gaoyuan.spring.elasticjob;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.gaoyuan.spring.dto.ProductCollect;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class PostAndPublishJob implements SimpleJob{
	private static final String EXCHANGE_NAME = "product_collect";

	public void execute(ShardingContext shardingContext) {
		// TODO 请求数据并发送到rabbitmq
		switch (shardingContext.getShardingItem()) {
		case 1:
			// 这里先造假数据
			List<ProductCollect> list = fakePost();
			//然后发布到rabbitmq
			try {
				publishData(list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
		
	}

	private void publishData(List<ProductCollect> list) throws Exception{
		// TODO Auto-generated method stub
		ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("10.10.45.33");
		factory.setUsername("test");
		factory.setPassword("test");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        String message = getListString(list);

        channel.basicPublish(EXCHANGE_NAME, "test", null, message.getBytes());
        System.out.println(" [x] Sent '" + "test" + "':'" + message + "'");

        channel.close();
        connection.close();
	}

	private String getListString(List<ProductCollect> list) {
		// TODO Auto-generated method stub
		return JSON.toJSONString(list);
	}

	private List<ProductCollect> fakePost() {
		List<ProductCollect> list = new ArrayList<ProductCollect>();
		
		for(int i = 0; i < 10; i++ ) {
			ProductCollect productCollect = new ProductCollect();
			productCollect.setBuzType("OnLine");
			productCollect.setClassGroupCode("CG0"+i);
			productCollect.setClassGroupName("班组0"+i);
			productCollect.setClassLevelCode("CL0"+i);
			productCollect.setClassLevelName("班次0"+i);
			productCollect.setOperateTime(new Date());
			productCollect.setProductCode("PC0"+i);
			productCollect.setOrderCode("OC0"+i);
			productCollect.setQualityResult("1");
			productCollect.setOperatorName("操作员0"+i);
			productCollect.setWorkUnitCode("WU0"+i);
			productCollect.setWorkUnitName("工作单元0"+i);
			list.add(productCollect);
		}
			
		return list;
	}

}

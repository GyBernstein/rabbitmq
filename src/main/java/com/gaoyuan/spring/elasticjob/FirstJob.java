package com.gaoyuan.spring.elasticjob;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

public class FirstJob implements SimpleJob {

	public void execute(ShardingContext context) {
		// TODO Auto-generated method stub
		switch (context.getShardingItem()) {
        case 0: 
            // do something by sharding item 0
        	System.out.println("JobName: "+context.getJobName());
        	System.out.println("JobParameter: "+context.getJobParameter());
        	System.out.println("ShardingItem: "+context.getShardingItem());
        	System.out.println("ShardingParameter: "+context.getShardingParameter());
        	System.out.println("~TotalCount: "+context.getShardingTotalCount());
        	System.out.println("TaskId: "+context.getTaskId());
        	System.out.println("changed");
            break;
        case 1: 
            // do something by sharding item 1
            break;
        case 2: 
            // do something by sharding item 2
            break;
        // case n: ...
    }
	}

}

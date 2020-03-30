package com.wangjinyin.study.distributedID;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wangjinyin.study.distributedID.service.RedisOrderIdService;
import com.wangjinyin.study.distributedID.service.SnowFlakeService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DistributedIDTest {
	
	@Qualifier("snowFlakeServiceImpl")
	@Autowired
	private SnowFlakeService snowFlakeService;
	
	@Qualifier("redisOrderIdServiceImpl")
	@Autowired
	private RedisOrderIdService redisOrderIdService;
	
	private static final int THREAD_NUM = 100;
	
	private static final CountDownLatch countDownLatch = new CountDownLatch(1);
 
    @Test
    public void test1(){
    	
    	for (int i = 0; i < THREAD_NUM; i++) {
			
    		new Thread(new OrderThread()).start();
		}
    	countDownLatch.countDown(); //当线程THREAD_NUM - 1 =0 唤醒所有线程
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    class OrderThread implements Runnable {
    	
		@Override
		public void run() {
			 try {
				 countDownLatch.await();  //让线程等待
			} catch (Exception e) {
				e.printStackTrace();
			}
			 snowFlakeService.orderId();
		}
    }
}

package com.wangjinyin.study.distributedID.serviceImpl;

import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Service;

import com.wangjinyin.study.distributedID.service.DistributeService;

@Service
public class DistributeServiceImpl implements DistributeService{
	
     private static final int THREAD_NUM = 100;
     
     private static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(1);
    		 
     

}

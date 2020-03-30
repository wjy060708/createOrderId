package com.wangjinyin.study.distributedID.serviceImpl;

import org.springframework.stereotype.Service;

import com.wangjinyin.study.distributedID.service.SnowFlakeService;
import com.wangjinyin.study.distributedID.utils.SnowFlakeUtils;

@Service
public class SnowFlakeServiceImpl implements SnowFlakeService{

	
	private static SnowFlakeUtils snowFlakeUtils = null;
	
	static {
		snowFlakeUtils = new SnowFlakeUtils(1, 1, 1);
	}
	
	@Override
	public long orderId() {
		
		Long orderIds = snowFlakeUtils.nextId();
		System.out.println(orderIds);
		return orderIds;
	}
	
	
}

package com.wangjinyin.study.distributedID.serviceImpl;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangjinyin.study.distributedID.config.RedisUtil;
import com.wangjinyin.study.distributedID.service.RedisOrderIdService;

import redis.clients.jedis.Jedis;

@Service
public class RedisOrderIdServiceImpl implements RedisOrderIdService{

	@Autowired
	private RedisUtil redisUtil;
	
	@Override
	public String createOrderId() {
		Jedis jedis = redisUtil.getJedis();
		
		String key = "study:order:id";
		String prefix = getPrefix(new Date(0));
		
		Long id = jedis.incr(key);
		System.out.println(id + ":orderId");
		jedis.expire(key, -1);
		
		System.out.println(prefix + String.format("%1$05d", id));
		jedis.close();
		return prefix + String.format("%1$05d", id);
	}

	public String getPrefix(Date date) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		int year = calendar.get(Calendar.YEAR);
		int day = calendar.get(Calendar.DAY_OF_YEAR);
		int houre = calendar.get(Calendar.HOUR_OF_DAY);
		
		String dayFmt = String.format("%1$03d", day); //第一个整型参数输出3位宽度，不足补0
		String houreFmt = String.format("%1$03d", houre);
		
		System.out.println((year - 2000) + dayFmt + houreFmt);
		return (year - 2000) + dayFmt + houreFmt;
	}
	
}

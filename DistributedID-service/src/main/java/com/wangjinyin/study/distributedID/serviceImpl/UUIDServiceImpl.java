package com.wangjinyin.study.distributedID.serviceImpl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.wangjinyin.study.distributedID.service.UUIDService;

/***
 * 通过uuid来生成订单id
 * @author wang
 *
 */
@Service
public class UUIDServiceImpl implements UUIDService{

	@Override
	public String getOrderId() {
		String orderId = UUID.randomUUID().toString();
		System.out.println(orderId);
		return orderId;
	}
}

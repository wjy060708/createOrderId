package com.wangjinyin.study.distributedID.utils;

import java.util.UUID;

public class UUIDUtils {

	//返回唯一主键16位
	public static String returnUUID() {
		
		return UUID.randomUUID().toString();
	}
	
	public static void main(String[] args) {
		System.out.println(returnUUID());
	}
}

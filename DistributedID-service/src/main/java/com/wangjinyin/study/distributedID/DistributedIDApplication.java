package com.wangjinyin.study.distributedID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DistributedIDApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributedIDApplication.class, args);
	}
}

package com.wangjinyin.study.distributedID.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping("index")
	public String index() {
		return "hello world";
	}
}

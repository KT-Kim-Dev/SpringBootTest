package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "ExampleApiV1")

public class ExampleApiV1 {

	@RequestMapping(value="/hello", method = RequestMethod.GET)
	@ApiOperation(value = "ABCD", notes="ZZZZZ")
	public String getHelloWorld() {
		return "HelloWorld~~";
	}
	
	@RequestMapping(value="/returnConversation", method = RequestMethod.POST)
	public String conversation(String name) {
		Gson gson = new Gson();
		return "Hello ~ " + name;
	}
	
}

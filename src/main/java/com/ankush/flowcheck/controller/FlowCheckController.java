package com.ankush.flowcheck.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ankush.flowcheck.Service.FlowCheckServiceImpl;
import com.ankush.flowcheck.model.UserInput;

@RestController
public class FlowCheckController {
	
	@Autowired
	private FlowCheckServiceImpl service;
	
	@PostMapping(value="/flowCheck")
	public HashMap<String, String> flowCheck(@RequestBody UserInput userInput){
		return service.flowCheck(userInput);
		
	}
}

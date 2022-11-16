package com.ankush.flowcheck.Service;

import java.util.HashMap;

import com.ankush.flowcheck.model.UserInput;

public interface FlowCheckService {
	
	public HashMap<String,String> flowCheck(UserInput userInput);
}

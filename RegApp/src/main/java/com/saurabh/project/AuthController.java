package com.saurabh.project;

import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ResponseBody
public class AuthController {
	
	@Autowired
	private DatabaseController database_controller;
	
	@RequestMapping("/auth")
	public ModelAndView authenticate(@RequestParam HashMap<String, String> request_body) {
		String name=request_body.get("name");
		String password= request_body.get("password");
		String username= request_body.get("username");
		String phone= request_body.get("phone");
		String birthday= request_body.get("birthday");
		String address=request_body.get("address");
		final String uri = String.format("https://2factor.in/API/V1/%s/SMS/+91%s/AUTOGEN", "cdd89795-c11e-11eb-8089-0200cd936042", phone);

	    RestTemplate restTemplate = new RestTemplate();
	    ModelAndView model = new ModelAndView("/auth");
	    try {
		    String result = restTemplate.getForObject(uri, String.class);
		    JSONObject obj = new JSONObject(result);
		    String session_id = obj.getString("Details");
		    model.addObject("name", name);
		    model.addObject("password", password);
		    model.addObject("username", username);
		    model.addObject("phone", phone);
		    model.addObject("birthday", birthday);
		    model.addObject("address", address);
		    model.addObject("session_id", session_id);
	    }
	    catch (Exception e) {
			System.out.println(e);
		}
	    
	    
		return model;
	}
}

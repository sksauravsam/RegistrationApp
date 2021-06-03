package com.saurabh.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ResponseBody
public class DatabaseController {

	@RequestMapping("/save")
	public ModelAndView saveToDatabase(@RequestParam HashMap<String, String> request_body) {
		String status = "";
		ModelAndView model = new ModelAndView("/result");
		ModelAndView model_otp = new ModelAndView("/invalidOtp");
		try {
			String otp = request_body.get("otp");
			String session_id = request_body.get("session_id");
			System.out.println(otp);
			
			
			RestTemplate restTemplate = new RestTemplate();
			String uri = String.format("https://2factor.in/API/V1/%s/SMS/VERIFY/%s/%s", "cdd89795-c11e-11eb-8089-0200cd936042", session_id, otp);
			String result = restTemplate.getForObject(uri, String.class);
		    JSONObject obj = new JSONObject(result);
		    status = obj.getString("Status");
			System.out.println(status);
			
			
			if(status != "Error") {
				String name=request_body.get("name");
				String password= request_body.get("password");
				String username= request_body.get("username");
				String phone= request_body.get("phone");
				String birthday= request_body.get("birthday");
				String address=request_body.get("address");
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "admin", "admin");
				Statement stmt = con.createStatement();
				String insert_part = "insert into users (name, password, username, mobile_no, birthdate, address) values ";
				String values_part = String.format("('%s', '%s', '%s', '%s', '%s', '%s')", name, password, username, phone, birthday, address);
				System.out.println(insert_part + values_part);
				int rs = stmt.executeUpdate(insert_part + values_part);
				System.out.printf("Inserted %d records into the table...", rs);
				con.close();
				
				model.addObject("name", name);
			    model.addObject("password", password);
			    model.addObject("phone", phone);
			    model.addObject("birthday", birthday);
			    model.addObject("address", address);
			}else {
				System.out.println("Invalid OTP");
				return model_otp;
				
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e);
			return model_otp;
		}
		return model;
	}
}

package com.saurabh.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginSucessController {
	
	@RequestMapping("/loginsuccess")
	public ModelAndView register(@RequestParam HashMap<String, String> request_body) {
		ModelAndView model = new ModelAndView("/loginsuccess");
		ModelAndView model_bad = new ModelAndView("/badCredentials");
		String password= request_body.get("password");
		String username= request_body.get("username");
		System.out.println("Response from Login : " +request_body.toString());
		
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "admin", "admin");
			Statement statement = con.createStatement();
			String sql ="select * from users";
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				
				String usernameFromDB = resultSet.getString("username");
				String passwordFromDB = resultSet.getString("password");
				System.out.println(usernameFromDB + "-"+ username + " : "+ passwordFromDB+"-"+password );
				
				if(username.equals(usernameFromDB) && password.equals(passwordFromDB)) {
					System.out.println("Match Found : -" + usernameFromDB + "-"+ username + " : "+ passwordFromDB+"-"+password );
					return model;
					
				}
				
			}
			
			con.close();
			} catch (Exception e) {
			e.printStackTrace();
			}
		
		
		return model_bad;
	}
}

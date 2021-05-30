package com.saurabh.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class DatabaseController {

	@RequestMapping("/save")
	public String saveToDatabase(@RequestParam HashMap<String, String> request_body) {
		try {
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
		} catch (Exception e) {
			System.out.println(e);
		}
		return "/result";
	}
}

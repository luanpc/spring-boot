package com.laptrinhjavaweb.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //tu class -> web service
public class NewAPI {
	@GetMapping("/test")  // Nhan request
	public String testAPI() {
		return "success";
	}
}
package org.yuan.demo.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
//@EnableAutoConfiguration
public class SampleController {

	@RequestMapping("/")
	public String index() {
		return "Hello Spring Boot!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SampleController.class, args);
	}

}

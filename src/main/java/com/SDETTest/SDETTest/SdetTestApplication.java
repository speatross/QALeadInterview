package com.SDETTest.SDETTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;

@SpringBootApplication
public class SdetTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdetTestApplication.class, args);
	}

	@Controller //note - this is a spring-boot controller, not @RestController
	@ApiIgnore 
	public class HomeController {
		@RequestMapping ("/")
		public String home() {
			return "redirect:/swagger-ui.html";
		}
	}

}

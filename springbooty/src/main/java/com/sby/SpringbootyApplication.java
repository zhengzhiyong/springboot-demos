package com.sby;

import com.sby.bean.BookBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootyApplication{
	@Autowired
	private BookBean bookBean;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootyApplication.class, args);
	}

	@RequestMapping("/")
	public String index(){
		return "Hello Spring Boot!" + bookBean.toString();
	}
}

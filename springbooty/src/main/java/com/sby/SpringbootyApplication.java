package com.sby;

import com.sby.bean.BookBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

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

	@RequestMapping(value = "/see/push", produces = "text/event-stream;charset=UTF-8")
	public @ResponseBody
	String push() {
		Random r = new Random();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//SSE返回数据格式是固定的以data:开头，以\n\n结束
		return "data:Testing 1,2,3" + r.nextInt() + "\n\n";
	}
}

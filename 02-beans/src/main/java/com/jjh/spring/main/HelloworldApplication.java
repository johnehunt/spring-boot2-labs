package com.jjh.spring.main;

import com.jjh.spring.beans.DateService;
import com.jjh.spring.beans.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.jjh.spring.beans")
public class HelloworldApplication {

	public static void main(String[] args) {
		System.out.print(("Main - Starting the application"));
		ApplicationContext ctx = SpringApplication.run(HelloworldApplication.class, args);

		System.out.println("Main - requesting MessageService");
		MessageService service = ctx.getBean(MessageService.class);
		System.out.println(service.getMessage());

		System.out.println("Main - requesting DateService");
		DateService ds1 = ctx.getBean(DateService.class);
		System.out.println(ds1.getDate());

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Main - requesting DateService (again)");
		DateService ds2 = ctx.getBean(DateService.class);
		System.out.println(ds2.getDate());

		System.out.print(("Main - Application startup completed"));
	}

}

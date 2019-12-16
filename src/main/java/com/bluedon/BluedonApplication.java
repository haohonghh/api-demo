package com.bluedon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class BluedonApplication {

	public static void main(String[] args) {
		SpringApplication.run(BluedonApplication.class, args);
	}

}

//外置 tomcat部署方式
/*@SpringBootApplication
public class BluedonApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		Long time=System.currentTimeMillis();
		SpringApplication.run(BluedonApplication.class);
		System.out.println("===应用启动耗时："+(System.currentTimeMillis()-time)+"===");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}
}*/
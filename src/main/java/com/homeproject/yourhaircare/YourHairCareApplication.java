package com.homeproject.yourhaircare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class YourHairCareApplication {

	public static void main(String[] args) {
		SpringApplication.run(YourHairCareApplication.class, args);
	}

}

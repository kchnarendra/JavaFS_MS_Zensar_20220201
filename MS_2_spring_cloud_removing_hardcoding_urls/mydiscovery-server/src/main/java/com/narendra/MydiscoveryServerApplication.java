package com.narendra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MydiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MydiscoveryServerApplication.class, args);
	}

}

package com.narendra.endpoints;

import java.util.Random;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

@Component
public class MyCustomHealthEndpoint extends AbstractHealthIndicator{

	@Override
	protected void doHealthCheck(Builder builder) throws Exception {

		Random random = new Random();
		int randomNumber = random.nextInt(100); // 0-99
		if(randomNumber % 2==0) {
			builder.up();
		}else {
			builder.down();
		}
	}

}
package com.narendra.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "my-end")
public class MyEndPoint {

	@ReadOperation
	public String helloEndPoint() {
		return "My Custom End Point";
	}
}

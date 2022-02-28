package com.narendra;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MyCommandLineRunner implements CommandLineRunner{
	
	@Override   //Callback 
	public void run(String... args) throws Exception {
		System.out.println(Arrays.toString(args));
		
	}

}
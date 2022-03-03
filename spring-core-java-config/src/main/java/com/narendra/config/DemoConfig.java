package com.narendra.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.narendra.beans,com.narendra")
@PropertySource("values.properties")
public class DemoConfig {

	/*
	 * @Bean public Item item() { return new Item("Laptop", 50000.0); }
	 */
	
	/*
	 * @Scope("prototype")
	 * 
	 * @Bean(name = "myOrder", initMethod = "myInit") public Order order() { return
	 * new Order(item(), "Purchase Laptop !!!"); }
	 */
}

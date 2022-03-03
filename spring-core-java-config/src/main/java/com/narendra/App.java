package com.narendra;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.narendra.beans.Order;
import com.narendra.config.DemoConfig;

public class App {
  public static void main(String[] args) {

	  ApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
	  
	 // Item item = context.getBean("item", Item.class);
	 // System.out.println(item);
	  
	 // Order order = context.getBean("myOrder", Order.class);
	 // System.out.println(order);
	  
  }
}

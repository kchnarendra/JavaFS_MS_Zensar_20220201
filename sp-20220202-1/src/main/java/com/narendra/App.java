package com.narendra;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("mycontext.xml");
		
		Item item = (Item) context.getBean("item");
		System.out.println(item);
	}
}

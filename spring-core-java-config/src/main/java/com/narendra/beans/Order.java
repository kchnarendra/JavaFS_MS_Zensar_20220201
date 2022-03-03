package com.narendra.beans;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myOrder")
public class Order implements BeanNameAware {

	@Autowired
	private Item item;
	
	@Value("${title}")
	private String title;
	
	@Override
	public void setBeanName(String name) {
		System.out.println("BeanNameAware  " + name);
	}
	
	public Order() {
		super();
	}
	public Order(Item item, String title) {
		super();
		this.item = item;
		this.title = title;
	}
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		System.out.println("Inside setTitle(String title)");
		this.title = title;
	}

	@Override
	public String toString() {
		return "Order [item=" + item + ", title=" + title + "]";
	}
}

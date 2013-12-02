package com.example.mbeans;

//MBean
public class Hello implements HelloMBean {
	
	private String name = "Reginald";
	private int cacheSize = DEFAULT_CACHE_SIZE;
	private static final int DEFAULT_CACHE_SIZE = 200;
	
	public String sayHello() {
		System.out.println("hello, world");
		return "hello, world";
	}

	public int add(int x, int y) {
		return x + y;
	}

	public void setName(String name){
		this.name = name;

		System.out.println("name now " + this.name);
	}
	
	public String getName() {
		return this.name;
	}

	public int getCacheSize() {
		return this.cacheSize;
	}

	public synchronized void setCacheSize(int size) {
		this.cacheSize = size;

		System.out.println("Cache size now " + this.cacheSize);
	}
	
	public String getInput(String inputValue){
		String value = inputValue;
		return value;
	}
}
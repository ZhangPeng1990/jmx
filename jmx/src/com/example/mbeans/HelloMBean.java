package com.example.mbeans;

public interface HelloMBean {

	// operations  
	  
    public String sayHello();  
    public int add(int x, int y);
  
    // attributes  
  
    // a read-only attribute called Name of type String  
    public String getName();  
    
    public void setName(String name);
  
    // a read-write attribute called CacheSize of type int  
    public int getCacheSize();
    public void setCacheSize(int size); 
    
    public String getInput(String inputValue);
}

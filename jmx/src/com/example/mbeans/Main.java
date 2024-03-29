package com.example.mbeans;

import java.lang.management.*;  
import javax.management.*;  
  
/**
 * ����
 * @author tyr
 *
 */
public class Main {  
    /* For simplicity, we declare "throws Exception".  Real programs 
       will usually want finer-grained exception handling.  */  
    public static void main(String[] args) throws Exception {  
    // Get the Platform MBean Server  
    MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();  
  
    // Construct the ObjectName for the MBean we will register  
    ObjectName name = new ObjectName("com.example.mbeans:type=Hello");  
  
    // Create the Hello World MBean  
    Hello mbean = new Hello();  
  
    // Register the Hello World MBean  
    mbs.registerMBean(mbean, name);  
  
    // Wait forever  
    System.out.println("Waiting forever...");  
    Thread.sleep(Long.MAX_VALUE);  
    }  
}  

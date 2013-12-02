package com.example.mbeans;

import java.lang.management.*;  
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.management.*;  
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

import com.sun.jdmk.comm.HtmlAdaptorServer;
  
/**
 * ´úÀí
 * @author tyr
 *
 */
public class Main2 {  
	
    
    public static void main(String[] args) throws Exception {  
    	
	int rmiPort = 1099;  
    String jmxServerName = "jxmServer";
    
	// jdkfolder/bin/rmiregistry.exe 9999         
    Registry registry = LocateRegistry.createRegistry(rmiPort);
    
    // Get the Platform MBean Server  
    MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();  
    
    
    
    HtmlAdaptorServer adapter = new HtmlAdaptorServer();  
    ObjectName adapterName;  
    adapterName = new ObjectName(jmxServerName + ":name=" + "htmladapter");  
    adapter.setPort(8082);  
    adapter.start();  
    
  
    // Construct the ObjectName for the MBean we will register  
    ObjectName name = new ObjectName("com.example.mbeans:type=Hello");  
  
    // Create the Hello World MBean  
    Hello mbean = new Hello();  
  
    // Register the Hello World MBean  
    mbs.registerMBean(mbean, name);  
    mbs.registerMBean(adapter, adapterName); 
  
    JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:" + rmiPort + "/" + jmxServerName);  
    System.out.println("JMXServiceURL: " + url.toString());  
    JMXConnectorServer jmxConnServer = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mbs);  
    jmxConnServer.start();  
    
    // Wait forever  
    System.out.println("Waiting forever...");  
    Thread.sleep(Long.MAX_VALUE);  
    }  
}  

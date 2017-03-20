package com.bit2017.aoptest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");
    
    	ProductService productService = ac.getBean(ProductService.class);
    	ProductVo vo = productService.find("TV");
    	System.out.println(vo);
    	
    	((ClassPathXmlApplicationContext)ac).close();
    }
}

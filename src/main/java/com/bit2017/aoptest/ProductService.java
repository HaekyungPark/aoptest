package com.bit2017.aoptest;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	public ProductVo find(String name){
		System.out.println("finding..."+name);
		
		/*if("camera".equals(name)){
			throw new RuntimeException("test");
		}*/
		
		return new ProductVo(name);
	}
}

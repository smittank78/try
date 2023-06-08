package com.medical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class lazyTryHandler {

	public lazyTryHandler() {
		super();
		System.out.println("lazyTryHandler cnstr called!!!");
	}
		@Autowired
	Integer firston;	
	
	@Autowired
	Integer seon;	

	@PostMapping("/test1")
	public Integer testLazyBean1() 
	{
		return this.seon;
	}

	@PostMapping("/test2")
	public Integer testLazyBean2() 
	{
		return this.seon;
	}
}
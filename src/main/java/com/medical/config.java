package com.medical;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy(true)
public class config {

	@Bean("firston")
	@Lazy(false)
	Integer integer()
	{
		Integer i = new Integer(0);
		System.out.println("1 initilized!!");
		return i;
	}
	@Bean("seon")
	@Lazy(true)
	Integer integer1()
	{
		Integer i = new Integer(2);
		System.out.println("2 initilized!!");		
		return i;
	}
	@Bean("third")
	@Lazy(true)
	Integer integer2()
	{
		Integer i = new Integer(3);
		System.out.println("3 initilized!!");
		return i;
	}
	
}

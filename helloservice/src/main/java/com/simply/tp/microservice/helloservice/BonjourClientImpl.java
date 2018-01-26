package com.simply.tp.microservice.helloservice;
import org.springframework.stereotype.Component;


@Component
public class BonjourClientImpl implements BonjourClient {
	public String sayBonjour(String name){
		return "just hello to "+name;
	}
}

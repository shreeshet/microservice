package com.simply.tp.microservice.helloservice;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.*;

@RestController
public class HelloController {

    protected Logger logger = LoggerFactory.getLogger(HelloController.class.getName());
	
    @Autowired
    private RestTemplate restTemplate;
 
    @Autowired
    private BonjourClient bonjourClient;
 
 
    @RequestMapping(value="/hello/{name}",method=RequestMethod.GET)
    public String sayHello(@PathVariable("name") String name){
        logger.debug("sayHello called with " + name);
	
	logger.debug("calling bonjour service ");
	
	String bRes = bonjourClient.sayBonjour(name);
	
	return "Helloo "+ name +" & " + bRes;
    }

}

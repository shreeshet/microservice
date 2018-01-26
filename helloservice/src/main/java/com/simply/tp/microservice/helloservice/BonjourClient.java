package com.simply.tp.microservice.helloservice;
  
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="bonjourservice",fallback=BonjourClientImpl.class)
public interface BonjourClient {

    @RequestMapping(value="/hello/{name}",method=RequestMethod.GET)
    public String sayBonjour(@PathVariable("name") String name);

}

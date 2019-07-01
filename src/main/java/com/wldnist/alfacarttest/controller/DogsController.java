package com.wldnist.alfacarttest.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DogsController {
	@RequestMapping("/dogs")
	public String dogs(){
		final String uri = "https://dog.ceo/api/breeds/list/all";

	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	    
		return result;
	}
	
	@RequestMapping("/dogs/{dogsname}")
	public String dogsSubs(@PathVariable String dogsname){
		final String uri = "https://dog.ceo/api/breed/"+dogsname+"/list";

	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	    
		return result;
	}	
	
}

package com.my.company.jenkins.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.my.company.jenkins.pojo.Address;

@RestController
@RequestMapping("/api")
public class MyFirstJenkinsController {
	
	@RequestMapping(value="/name/{name}", method=RequestMethod.GET)
	public String readData(@PathVariable String name){
		return "Hello "+name+" Welcome Back";
	}
	
	@RequestMapping(value="/id/{id}", method=RequestMethod.GET)
	public String readDetails(@PathVariable String id){
		return "Hello "+id+" belongs to Ravi Chappa";
	}
	
	@RequestMapping(value="/address/{id}", method=RequestMethod.GET)
	public Address readAddress(@PathVariable String id){
		return new Address("Mallory Cirlce", "Orlando", "FL", "USA");
	}

}

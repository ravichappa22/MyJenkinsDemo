package com.my.company.jenkins.controller;


import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.my.company.jenkins.pojo.Address;

@RestController
@RequestMapping("/api")
public class MyFirstJenkinsController {
	
	private static final String INDEX_PATTERN = "${vcap.application.instance_index:${spring.application.index:${server.port:${PORT:null}}}}";
	
	@Value("${spring.application.name}")
	private String name;
	
	@Autowired
	private ConfigurableEnvironment configurableEnvironment;
	
	@RequestMapping(value="/name/{name}", method=RequestMethod.GET)
	public String readData(@PathVariable String name){
		return "Hello "+name+" Welcome Back";
	}
	
	@RequestMapping(value="/id/{id}", method=RequestMethod.GET)
	public String readDetails(@PathVariable String id){
		return "Hello "+id+" belongs to Ravi Chappa" + " Context ID= " + this.getApplicationId(configurableEnvironment);
	}
	
	@RequestMapping(value="/address/{id}", method=RequestMethod.GET)
	public Address readAddress(@PathVariable String id){
		return new Address("Mallory Cirlce", "Orlando", "FL", "USA");
	}
	
	@RequestMapping(value="/address/update", method=RequestMethod.PUT)
	public Boolean updateAddress(@RequestBody Address address){
		return true;
	}
	
	@RequestMapping(value="/employee/dob/{id}", method=RequestMethod.GET)
	public String retrieveDob(@PathVariable String id){
		DateTimeFormatter format = DateTimeFormatter.ofPattern("d-MMM-uuuu");
		LocalDate dob = LocalDate.of(1981,Month.JULY,1);
		return dob.format(format);
		
	}
	
	
	private String getApplicationId(ConfigurableEnvironment environment) {
		String name = environment.resolvePlaceholders(this.name);
		String index = environment.resolvePlaceholders(this.INDEX_PATTERN);
		String profiles = StringUtils
				.arrayToCommaDelimitedString(environment.getActiveProfiles());
		if (StringUtils.hasText(profiles)) {
			name = name + ":" + profiles;
		}
		if (!"null".equals(index)) {
			name = name + ":" + index;
		}
		return name;
	}

	
}

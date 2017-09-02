package com.my.company.jenkins.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.my.company.jenkins.controller.MyFirstJenkinsController;
import com.netflix.discovery.converters.Auto;

@RunWith(MockitoJUnitRunner.class)
public class MyFirstJenkinsControllerTest {
	
		
	@Spy
	private  MyFirstJenkinsController myFirstJenkinsController;
	
	@Test
	public void testRetrieveDob(){
		String dob = myFirstJenkinsController.retrieveDob("1");
		System.out.println(dob);
		assertEquals("1-Jul-1981", dob);
	}
	
	/*@Test
	public void testReadDetails(){
		String details = myFirstJenkinsController.readDetails("1");
		System.out.println(details);
		assertNotNull(details);
		
	}*/

}

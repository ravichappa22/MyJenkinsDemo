package com.my.company.jenkins.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.my.company.jenkins.controller.MyFirstJenkinsController;

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

}

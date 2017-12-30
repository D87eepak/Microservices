package com.javainuse.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClientException;

import com.javainuse.Feignclient.EmployeeFeignClient;
import com.javainuse.model.Employee;

@Controller
public class ConsumerControllerClient {
	
	@Autowired
	private EmployeeFeignClient feignClient;
	@RequestMapping("/emp")
	public Employee getEmployee() throws RestClientException, IOException {
		
		Employee emp=feignClient.getData();
		return emp;
		//System.out.println(emp.toString());
	}


	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}
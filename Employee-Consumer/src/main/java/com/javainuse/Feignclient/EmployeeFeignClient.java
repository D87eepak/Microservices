package com.javainuse.Feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javainuse.model.Employee;

@FeignClient(name="employee-producer")
public interface EmployeeFeignClient {

	@RequestMapping(method=RequestMethod.GET, value="/employee")
	public Employee getData();
}

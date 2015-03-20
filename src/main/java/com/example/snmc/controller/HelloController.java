package com.example.snmc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.snmc.controller.dao.impl.JdbcCustomerDAO;
import com.example.snmc.controller.dao.impl.JdbcStaffDAO;
import com.example.snmc.controller.nodel.Customer;
import com.example.snmc.controller.nodel.Staff;

@Controller
@RequestMapping("/welcome")
public class HelloController {
	
	@Autowired
	public JdbcCustomerDAO jDao;
	
	@Autowired
	public JdbcStaffDAO sDao;
 
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
 
		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";
 
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String getMovie(@PathVariable String name, ModelMap model) {
 
		model.addAttribute("movie", name);
		return "list";
 
	}
	
	@RequestMapping(value = "/employeeDetails", method = RequestMethod.GET)
	public String addEmployee( @RequestParam(value = "id", required = false) String employeeId ,
			@RequestParam(value = "name", required = false) String employeeName ,
			@RequestParam(value = "mobile", required = false) String mobile ,
			ModelMap model) {
		
        Customer customer = new Customer(employeeId, employeeName,mobile);
		jDao.insert(customer);
        
		Customer customer1 = jDao.findByCustomerId(employeeId);
        
		model.addAttribute("movie", customer1.getName());
		return "list";
 
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Staff addEmployee( @RequestParam(value = "loginId", required = false) String username ,
			@RequestParam(value = "password", required = false) String password ,
			ModelMap model) {
		
        
		Staff staff = sDao.staffLoginVerification(username, password);
        System.out.println(staff.getFirstName() + staff.getLastName());
//		model.addAttribute("movie", staff.getFirstName() + staff.getLastName());
		return staff;
 
	}
 
}
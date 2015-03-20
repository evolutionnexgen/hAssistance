package com.example.snmc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.snmc.controller.dao.impl.JdbcStaffDAO;
import com.example.snmc.controller.nodel.Staff;
import com.example.snmc.controller.nodel.Timer;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	public JdbcStaffDAO sDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String printWelcome(ModelMap model) {
 
		System.out.println("Spring 3 MVC Hello World");
		return "MainController";
 
	}
 
	@RequestMapping(value = "/mainlogin", method = RequestMethod.GET)
	public @ResponseBody Staff addEmployee( @RequestParam(value = "loginId", required = false) String username ,
			@RequestParam(value = "password", required = false) String password ,
			ModelMap model) {
        
		Staff staff = sDao.staffLoginVerification(username, password);
        System.out.println(staff.getFirstName() + staff.getLastName());
		return staff;
 
	}
	
	@RequestMapping(value = "/getAllStaff", method = RequestMethod.GET)
	public @ResponseBody List<Staff> getAllStaff(ModelMap model) {
		return sDao.listStaff();
	}
	
	@RequestMapping(value = "/getTimer", method = RequestMethod.GET)
	public @ResponseBody List<Timer> getTimer(ModelMap model) {
		return sDao.getTimerList();
	}
 
}
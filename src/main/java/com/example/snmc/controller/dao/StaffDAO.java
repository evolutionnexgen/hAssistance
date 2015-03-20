package com.example.snmc.controller.dao;

import java.util.List;

import com.example.snmc.controller.nodel.Staff;
import com.example.snmc.controller.nodel.Timer;

public interface StaffDAO {
	
	public Staff staffLoginVerification(String username, String password);
	
	public Staff getStaffInfo(String staffId);
	
	public List<Staff> listStaff();
	
	public List<Timer> getTimerList();

}

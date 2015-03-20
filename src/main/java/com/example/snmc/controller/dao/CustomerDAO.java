package com.example.snmc.controller.dao;

import com.example.snmc.controller.nodel.Customer;

public interface CustomerDAO 
{
	public void insert(Customer customer);
	public Customer findByCustomerId(String custId);
}





package com.example.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


@Service
public class CustomerService {
	@Autowired
	CustomerDao cusDao;
	public String addCustomer(Customer c) {
		return cusDao.addCustomer(c);
	}
	
	public String addCus(List<Customer>cus) {
		return cusDao.addCus(cus);
	}
	
	public List<Customer> getCus(){
		return cusDao.getCus();
	}
	
	public Customer getvalue(int idnum) throws CustomerNotFoundException{
		return cusDao.getvalue(idnum);
	}
	
	public String update(Customer id) {
		return cusDao.update(id);
	}
	
	public String delete(Customer id) {
		return cusDao.delete(id);
	}

	public List<Customer> getTheListCustomer() {
		// TODO Auto-generated method stub
		return cusDao.getTheListCustomer();
	}

	public List<Customer> getCustomerByAge(int age) {
		// TODO Auto-generated method stub
		return cusDao.getCustomerByAge(age);
	}

}

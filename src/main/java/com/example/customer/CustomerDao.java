package com.example.customer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
	@Autowired
	CustomerRepo cusRepo;

	public String addCustomer(Customer c) {
		cusRepo.save(c);
		return "Successfully saved";
	}

	public String addCus(List<Customer> cus) {
		cusRepo.saveAll(cus);
		return "Success";
	}

	public List<Customer> getCus() {
		return cusRepo.findAll();
	}

	public Customer getvalue(int idnum) throws CustomerNotFoundException {
		
		return cusRepo.findById(idnum).orElseThrow(()-> new CustomerNotFoundException());
	}
	
	public String update(Customer id) {
		cusRepo.save(id);
		return "Successfully updated";
	}
	
	public String delete(Customer id) {
		cusRepo.delete(id);
		return "Successfully deleted";
	}

	public List<Customer> getTheListCustomer() {
		// TODO Auto-generated method stub
		return cusRepo.findAll();
	}

	public List<Customer> getCustomerByAge(int age) {
		
		return cusRepo.getByAge(age);
	}

}

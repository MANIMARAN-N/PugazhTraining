package com.example.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	@Query(value  = "select * from customer where age>=?",nativeQuery = true)
	public List<Customer> getByAge(int age);

}

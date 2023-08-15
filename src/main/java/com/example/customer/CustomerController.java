package com.example.customer;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	@Autowired
	CustomerService cuser;

	@PostMapping(value = "/addDetails")
	public String addCustomer(@RequestBody Customer c) {
		return cuser.addCustomer(c);
	}

	@PostMapping(value = "/add")
	public String addCus(@RequestBody List<Customer> cus) {
		return cuser.addCus(cus);
	}

	@GetMapping(value = "/getDetails")
	public List<Customer> getCus() {
		return cuser.getCus();
	}

	@GetMapping(value = "/id/{idnum}")
	public Customer getvalue(@PathVariable int idnum) throws CustomerNotFoundException {
		return cuser.getvalue(idnum);
	}

	@PutMapping(value = "/update/{id}")
	public String update(@RequestBody Customer id) {
		return cuser.update(id);
	}

	@DeleteMapping(value = "/delete/{id}")
	public String delete(@RequestBody Customer id) {
		return cuser.delete(id);
	}

	@GetMapping("/makeExcel")
	public String exportIntoExcelFile(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Customer exe" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);

		List<Customer> listOfStudents = cuser.getTheListCustomer();
		ExcelGenerator generator = new ExcelGenerator(listOfStudents);
		generator.generateExcelFile(response);
		return "your Excel Downloaded";
	}
	@GetMapping(value  = "/getByAge/{age}")
	public List<Customer> getCustomerByAge(@PathVariable int age) {
		return cuser.getCustomerByAge(age);
	}

}

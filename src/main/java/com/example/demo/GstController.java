package com.example.demo;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GstController {
	@Autowired
	GstRepository gstRepo;

	
	@GetMapping("/get/{hsn}")
	public int getByhsn(@PathVariable int hsn) {

		return gstRepo.getPriceByHsn(hsn);

	}

}

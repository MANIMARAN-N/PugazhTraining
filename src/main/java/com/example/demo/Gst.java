package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gst_api")
public class Gst {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int percentage;
	private int hsn;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	public int getHsn() {
		return hsn;
	}
	public void setHsn(int hsn) {
		this.hsn = hsn;
	}
	
}

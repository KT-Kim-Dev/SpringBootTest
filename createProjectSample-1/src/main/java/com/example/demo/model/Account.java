package com.example.demo.model;

import org.mapstruct.Mapper;

@Mapper
public class Account {

	private long id;
	private String email;
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Account(long id, String email) {
		this.id = id;
		this.email = email;
	}
	
	public Account(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Account [id = " + this.id + ", email = " + this.email + "]";
	}
}

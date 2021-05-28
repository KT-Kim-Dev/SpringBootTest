package com.example.demo.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Account;
import com.example.demo.model.MybatisAccountRepository;


public class MybatisAccountRepositoryTest {

	@Autowired
	MybatisAccountRepository accountRepository;
	
	String defaultEmail = "add@email.com";
	
	public void setUp() {
		accountRepository.deleteAll();		
	}
	
	public void count() {
		accountRepository.save(new Account("add1@email.com"));
		accountRepository.save(new Account("add2@email.com"));
		accountRepository.save(new Account("add3@email.com"));
	}
	
	public void saveAndFindAll() {
		accountRepository.save(new Account("add1@email.com"));
		accountRepository.save(new Account("add2@email.com"));
		accountRepository.save(new Account("add3@email.com"));
		
		List<Account> getAll = accountRepository.findAll();
	}
	
	public void saveAndFindById() {
		long resultId = accountRepository.save(new Account(defaultEmail));
		Account getAccount = accountRepository.findById(resultId);
		
	}
	
	public void saveAndFindByEmail() {
		accountRepository.save(new Account(defaultEmail));
		Account getAccount = accountRepository.findByEmail(defaultEmail);
		
	}
	
	public void update() {
		long resultId = accountRepository.save(new Account(defaultEmail));
		Account getAccount = accountRepository.findById(resultId);
		
		getAccount.setEmail("update@email.com");
		accountRepository.update(getAccount);
		Account updatedAccount = accountRepository.findById(resultId);
	}
	
	public void deleteById() {
		long resultId1 = accountRepository.save(new Account("add1@email.com"));
		long resultId2 = accountRepository.save(new Account("add2@email.com"));
		long resultId3 = accountRepository.save(new Account("add3@email.com"));
		
		accountRepository.deleteById(resultId2);
	}
}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Account;
import com.example.demo.model.MybatisAccountRepository;


@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	MybatisAccountRepository accountRepository;

	@GetMapping("/list") //목록 
	public String list(Model model) {
		
		model.addAttribute("accounts", accountRepository.findAll());
		model.addAttribute("count", accountRepository.count());
		
		return "account/list";
	}
	
	@GetMapping("/add") //추가 Form 
	public String add() {
		return "account/add";
	}
	
	@PostMapping("/add") //추가 처리 
	public String addProcess(String email){
		accountRepository.save(new Account(email));
		
		return "redirect:/account/list";
	}
	
	@GetMapping("/{id}") //상세보기 
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("account", accountRepository.findById(id));
		
		return "account/view";
	}
	
	@GetMapping("/{id}/modify") //수정 Form
	public String modify(@PathVariable Long id, Model model) {
		
		model.addAttribute("account", accountRepository.findById(id));
		
		return "account/modify";
	}
	
	@PostMapping("/{id}/modify") //수정 처리 
	public String modifyProcess(@PathVariable Long id, String email) {
		Account account = accountRepository.findById(id);
		account.setEmail(email);
		accountRepository.update(account);
		
		return String.format("redirect:/account/%d", id) ;
	}
	
	@PostMapping("/{id}/delete") //삭제 처리 
	public String deleteProcess(@PathVariable Long id) {
		accountRepository.deleteById(id);
		
		return "redirect:/account/list";
	}
	
	
}

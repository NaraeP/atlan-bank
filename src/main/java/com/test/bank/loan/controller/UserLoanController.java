package com.test.bank.loan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.bank.loan.service.LoanService;

@Controller
public class UserLoanController {

	@Autowired
	private LoanService service;

	@GetMapping(value="/loan/view.do")
	public String loan(Model model) {
		
		return "user/loan/view";
	}
	
}

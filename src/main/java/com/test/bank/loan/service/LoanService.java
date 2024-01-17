package com.test.bank.loan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bank.loan.repository.LoanDAO;

@Service
public class LoanService {

	@Autowired
	private LoanDAO dao;
	
}

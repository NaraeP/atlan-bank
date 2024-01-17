package com.test.bank.loan.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.bank.loan.mapper.LoanMapper;

@Repository
public class LoanDAOImpl implements LoanDAO {

	@Autowired
	LoanMapper mapper;
	
}

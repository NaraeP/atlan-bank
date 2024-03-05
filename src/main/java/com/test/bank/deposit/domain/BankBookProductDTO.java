package com.test.bank.deposit.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BankBookProductDTO {

//	private String bank_book_product_seq;
//	private String name;
//	private String sim_info;
//	private String type;
//	private String info;
//	private String join_info;
//	private String join_date_info;
//	private String join_fee;
	
	private String bankBookProductSeq;
	private String name;
	private String simInfo;
	private String type;
	private String info;
	private String joinInfo;
	private String joinDateInfo;
	private String joinFee;

	private String interestRate;
	
	
	
	
}

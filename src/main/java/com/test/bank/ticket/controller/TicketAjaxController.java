package com.test.bank.ticket.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.bank.ticket.domain.BankDTO;
import com.test.bank.ticket.domain.TicketWaitingStatusDTO;
import com.test.bank.ticket.domain.WorkListDTO;
import com.test.bank.ticket.service.TicketService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class TicketAjaxController {
	
	@Autowired
	TicketService service;
	
	@GetMapping("/ticket/{location}")
	public Map<String, List<BankDTO>> resJsonBody2(@PathVariable("location") String location) {
		//System.out.println("location: " + location);
		Map<String, List<BankDTO>> searchedBankList = new HashMap<>();
		List<BankDTO> result = service.searchedBankList(location);
		searchedBankList.put("data", result);
		//System.out.println(searchedBankList);
		return searchedBankList;
	}
	
	@GetMapping("/ticket/worklist/{bankSeq}/{type}")
	public Map<String, Map<String, List<String>>> getWorkList(@PathVariable("bankSeq") String bankSeq, @PathVariable("type") String type) {
		// Map<String, List<WorkListDTO>> workList = new HashMap<>();
		// List<WorkListDTO> result = service.getWorkList(bankSeq, type); 
		Map<String, Map<String, List<String>>> workList = new HashMap();
		Map<String, List<String>> result = service.getWorkList(bankSeq, type); 
		workList.put("data", result);
//		System.out.println("TicketAjaxController workList: " + workList);
		return workList;
	}
	
	@GetMapping("/ticket/waiting/{bankSeq}/{type}")
	public ResponseEntity<?> getWaitingNumber(@PathVariable("bankSeq") String bankSeq, @PathVariable("type") String type, HttpSession session) {
//		session.setAttribute("id", "test1");
		session.removeAttribute("id");
		String userId = (String) session.getAttribute("id");
		System.out.println("TicketAjaxController userId: " + userId);
		if (userId == null) {
			System.out.println("로그인 안함");
			return ResponseEntity.ok(false);
		}
		
		int number = service.getWaitingNumber(bankSeq, type);
		return ResponseEntity.ok(number);
	}
	
	
	
}

package com.test.bank.card.domain;

import java.util.List;

import lombok.Data;

@Data
public class CardDTO {

	private String cardSeq;
	private String type;
	private String category;
	private String name;
	private String info;
	private String img;
	private String orientation;
	
	//Card Annual Fee
	private List<CardAnnualFeeDTO> feeList;
	
	//Card Benefits
	private List<BenefitsDTO> benefitList;
	
	//Card Usage Guide
	private List<CardUsageGuideDTO> cardUsageGuideList;
}

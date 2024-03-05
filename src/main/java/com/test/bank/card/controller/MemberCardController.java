package com.test.bank.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.bank.card.domain.MemberCardHistoryDTO;
import com.test.bank.card.service.CardService;
import com.test.bank.member.domain.MemberDTO;

@Controller
@RequestMapping(value = "/member/card")
public class MemberCardController {

	@Autowired
	private CardService service;
	
	@GetMapping(value = "/view.do")
	public String view(Model model, MemberDTO dto,Authentication auth) {
		
		//마이페이지 - 카드 초기화면(결제 예정 금액, 이름 표시) >> 일시불만 구현 예정
		//1. 로그인한 사용자의 이번달 결제 예정 금액(전월 결제내역) 가져오기
		dto.setMemberSeq("2"); //dto.setMemberSeq(((CustomUser)auth.getPrincipal()).getDto().getMember_seq());
		dto.setName("박나래"); //dto.setName(((CustomUser)auth.getPrincipal()).getDto().getName());
		
		List<MemberCardHistoryDTO> list = service.getPrevMonthCardHistory(dto.getMemberSeq());
		
		String thisMonthAmount = service.getThisMonthAmount(dto.getMemberSeq());
		
		//2. 결제내역 가져오기
		List<MemberCardHistoryDTO> historyList = service.getHistoryList(dto.getMemberSeq());
		
		model.addAttribute("dto", dto);
		model.addAttribute("list", list);
		model.addAttribute("thisMonthAmount", thisMonthAmount);
		model.addAttribute("historyList", historyList);
		
		return "member/card/view";
	}
	
	//3. 이번달 결제 내역은 결제내역 - 대금결제 내역 테이블간의 참조 컬럼이 있으면 결제 아니면 그 금액에 해당 날짜일 합산하여 금액이 뜬다.
	//4. 결제내역 조회 버튼 누르면 과거 ~ 현재 결제 내역 조회
	//5. 대금결제 버튼 누르면 결제예정금액에 포함되는 결제건이 뜨고 체크해서 결제
	//6. 하단에 선택 금액 합산 해주기
	
}

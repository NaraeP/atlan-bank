package com.test.bank.event.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.test.bank.event.domain.EventDTO;
import com.test.bank.event.domain.FranchiseDTO;

@Mapper
public interface EventMapper {

	int getTotalCount(Map<String, String> map);

	List<EventDTO> getEventsWithPaging(Map<String, String> map);

	List<EventDTO> getLatestEvents();

	EventDTO getEventBySeq(int eventSeq);

	FranchiseDTO getFranchiseBySeq(int franchiseSeq);
	
}
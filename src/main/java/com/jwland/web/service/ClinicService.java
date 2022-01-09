package com.jwland.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jwland.web.mapper.ClinicMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class ClinicService {

	private final ClinicMapper clinicMapper;
	
	
	public List<Map> loadClinicData(String date, String accountSequenceNo) {
		date = date.replaceAll("-", "").trim();
		Map<String, String> parameter = new HashMap<>();
		parameter.put("date", date);
		parameter.put("accountSequenceNo", accountSequenceNo);
		return clinicMapper.loadClinicData(parameter);
	}


	public List<Map> loadClinicList(String startDate, String endDate) {
		startDate = startDate.replaceAll("-", "").trim();
		endDate = endDate.replaceAll("-", "").trim();
		Map<String, String> parameter = new HashMap<>();
		parameter.put("startDate", startDate);
		parameter.put("endDate", endDate);
		return clinicMapper.loadClinicList(parameter);
	}

	
	
}

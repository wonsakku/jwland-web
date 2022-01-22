package com.jwland.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.jwland.domain.clinic.ClinicAccountMapDto;
import com.jwland.domain.clinic.EnrollClinicDto;
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


	public List<Map> getClinicTypes() {
		return clinicMapper.getClinicTypes();
	}


	public List<Map> getClassTypes(String accountSequenceNo) {
		return clinicMapper.getClassTypes(accountSequenceNo);
	}


	public int enrollClinic(@Valid EnrollClinicDto enrollClinicDto) {
		return clinicMapper.enrollClinic(enrollClinicDto);
	}


	public int applyClinic(@Valid ClinicAccountMapDto clinicAccountMapDto) {
		return clinicMapper.applyClinic(clinicAccountMapDto);
	}


	public int cancelClinic(@Valid ClinicAccountMapDto clinicAccountMapDto) {
		return clinicMapper.calcelClinic(clinicAccountMapDto);
	}

	
	
}

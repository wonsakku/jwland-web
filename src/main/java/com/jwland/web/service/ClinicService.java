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
	
	
	public List<Map> loadClinicData(String date) {
		return clinicMapper.loadClinicData(date.replaceAll("-", "").trim());
	}

	
	
}

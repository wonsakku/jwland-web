package com.jwland.web.mapper;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;

import com.jwland.domain.clinic.ClinicAccountMapDto;
import com.jwland.domain.clinic.EnrollClinicDto;

@Mapper
public interface ClinicMapper {

	List<Map> loadClinicData(Map<String, String> parameter);

	List<Map> loadClinicList(Map<String, String> parameter);

	List<Map> getClinicTypes();

	List<Map> getClassTypes(String accountSequenceNo);

	int enrollClinic(@Valid EnrollClinicDto enrollClinicDto);

	int applyClinic(@Valid ClinicAccountMapDto clinicAccountMapDto);

	int calcelClinic(@Valid ClinicAccountMapDto clinicAccountMapDto);

}

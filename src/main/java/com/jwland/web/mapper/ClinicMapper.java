package com.jwland.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClinicMapper {

	List<Map> loadClinicData(Map<String, String> parameter);

	List<Map> loadClinicList(Map<String, String> parameter);

}

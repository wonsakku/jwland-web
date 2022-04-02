package com.jwland.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jwland.dto.CommonCodeDto;

@Mapper
public interface CommonDataMapper {

	List<Map> getSchoolInfo();

	List<Map> getGradeInfo();

	List<CommonCodeDto> getCommonCode(String groupCode);

}


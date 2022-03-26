package com.jwland.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonDataMapper {

	List<Map> getSchoolInfo();

	List<Map> getGradeInfo();

}


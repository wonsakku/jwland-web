package com.jwland.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jwland.domain.classes.ClassDetailDto;
import com.jwland.domain.classes.ClassDomain;

@Mapper
public interface ClassMapper {

	void enrollClass(ClassDomain clz);

	ClassDomain findClassByClassName(String className);

	List<ClassDetailDto> getClassDetails(String open);
}

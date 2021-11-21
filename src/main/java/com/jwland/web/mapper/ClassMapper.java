package com.jwland.web.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.jwland.domain.classes.ClassDomain;

@Mapper
public interface ClassMapper {

	void enrollClass(ClassDomain clz);

	ClassDomain findClassByClassName(String className);
}

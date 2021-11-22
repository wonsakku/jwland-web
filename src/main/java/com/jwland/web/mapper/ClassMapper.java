package com.jwland.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jwland.domain.classes.ClassDetailDto;
import com.jwland.domain.classes.ClassDomain;
import com.jwland.domain.classes.EnrolledAccountsDto;

@Mapper
public interface ClassMapper {

	void enrollClass(ClassDomain clz);

	ClassDomain findClassByClassName(String className);

	List<ClassDetailDto> getClassDetails(String open);

	void deleteMapTableWithClassSequenceNo(int classSequenceNo);

	void enrollStudentToClass(Map<String, Integer> parameter);

	List<Integer> getEnrolledAccounts(int classSequenceNo);

	List<EnrolledAccountsDto> getEnrolledAccountInfos(int classSequenceNo);
}

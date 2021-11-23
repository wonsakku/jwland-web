package com.jwland.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jwland.domain.classes.ClassAttendanceManagementVO;
import com.jwland.domain.classes.ClassDetailDto;
import com.jwland.domain.classes.ClassDomain;
import com.jwland.domain.classes.EnrolledAccountsDto;
import com.jwland.domain.classes.PersonalClassAttendanceDto;

@Mapper
public interface ClassMapper {

	void enrollClass(ClassDomain clz);

	ClassDomain findClassByClassName(String className);

	List<ClassDetailDto> getClassDetails(String open);

	void deleteMapTableWithClassSequenceNo(int classSequenceNo);

	void enrollStudentToClass(Map<String, Integer> parameter);

	List<Integer> getEnrolledAccounts(int classSequenceNo);

	List<EnrolledAccountsDto> getEnrolledAccountInfos(int classSequenceNo);

	List<String> getClassDate(int classSequenceNo);

	void deleteClassAttendanceInfo(Map<String, String> parameter);

	void enrollAttendanceInfo(ClassAttendanceManagementVO vo);

	List<PersonalClassAttendanceDto> findAttendanceInfoByDate(Map<String, String> parameter);
}

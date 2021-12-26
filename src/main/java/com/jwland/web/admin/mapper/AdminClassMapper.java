package com.jwland.web.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jwland.domain.classes.ClassAttendanceManagementVO;
import com.jwland.domain.classes.ClassVO;
import com.jwland.domain.classes.dto.ClassDetailDto;
import com.jwland.domain.classes.dto.EnrolledAccountsDto;
import com.jwland.domain.classes.dto.PersonalClassAttendanceDto;

@Mapper
public interface AdminClassMapper {

	void enrollClass(ClassVO clz);

	ClassVO findClassByClassName(String className);

	List<ClassDetailDto> getClassDetails(String open);

	void deleteMapTableWithClassSequenceNo(int classSequenceNo);

	int enrollStudentToClass(Map<String, Integer> parameter);

	List<Integer> getEnrolledAccounts(int classSequenceNo);

	List<EnrolledAccountsDto> getEnrolledAccountInfos(int classSequenceNo);

	List<String> getClassDate(int classSequenceNo);

	void deleteClassAttendanceInfo(Map<String, String> parameter);

	void enrollAttendanceInfo(ClassAttendanceManagementVO vo);

	List<PersonalClassAttendanceDto> findAttendanceInfoByDate(Map<String, String> parameter);

	List<Map> getClassTypes();
}

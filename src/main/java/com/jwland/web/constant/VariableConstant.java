package com.jwland.web.constant;

public interface VariableConstant {

	// about join & login
	public static final String LOGIN_ATTRIBUTE_NAME = "loginInfo";
	public static final String JOIN_ACCOUNT_DTO = "joinAccountDto";
	public static final String FORM_LOGIN_DTO = "formLoginDto";

	// error & message
	public static final String ERROR = "error";
	public static final String MESSAGE = "msg";
	
	// role
	public static final String ADMIN = "ROLE_ADMIN";
	
	// etc message
	public static final String JOIN_SUCCESS_MESSAGE_SURFFIX = "님의 가입이 완료되었습니다."; 
	public static final String LOGIN_MESSAGE_SUFFIX = "님이 로그인하였습니다.";
	
	// class
	public static final String CLASS_ENROLL_SUCCESS = "강의 등록이 완료되었습니다.";
	public static final String ACCOUNT_ENROLL_CLASS_SUCCESS_SUFFIX = "명의 학생이 등록되었습니다.";
	public static final String ATTENDANCE_ENROLL_SUCCESS = "출석 등록을 완료하였습니다.";
	
	// 사용 승인 메세지
	public static final String USING_APPROVE_MESSAGE = "선택한 학생에 대한 사용 승인이 완료되었습니다.";
	
	
	// exam enroll message
	public static final String EXAM_ENROLL_SUCCESS_MESSAGE = "기출 등록이 완료되었습니다.";
	public static final String EXAM_UPDATE_SUCCESS = "기출 수정이 완료되었습니다.";
	public static final String EXAM_DELETE_SUCCESS = "기출 삭제가 완료되었습니다.";
	public static final String EXAM_ENROLL_WRONG_ANSWER_SUCCESS = "오답 등록이 완료되었습니다.";
	public static final String EXAM_UPDATE_WRONG_ANSWER_SUCCESS = "오답 수정이 완료되었습니다.";
	public static final String EXAM_DELETE_WRONG_ANSWER_SUCCESS = "오답 삭제가 완료되었습니다.";

	// 클리닉
	public static final String CLINIC_ENROLL_SUCCESS = "'클리닉 / 보충'이 등록되었습니다.\n '클리닉 / 보충' 신청을 진행해주시기 바랍니다.";
	public static final String CLINIC_APPLY_SUCCESS = "'클리닉 / 보충' 신청이 완료되었습니다.";
	public static final String CLINIC_CANCEL_SUCCESS = "'클리닉 / 보충' 신청이 취소되었습니다.";
	


}




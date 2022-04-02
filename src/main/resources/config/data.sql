-- 메뉴
insert into jwland.menu(menu_name, menu_priority, url, admin_page)
values('클리닉&보충', 1, '/clinic/page', 'N');

insert into jwland.menu(menu_name, menu_priority, url, admin_page)
values('고3 모의고사 체크', 2, '/exam-check/page', 'N');

insert into jwland.menu(menu_name, menu_priority, url, admin_page)
values('기출 및 문제 정오표', 3, '/errata/page', 'N');

insert into jwland.menu(menu_name, menu_priority, url, admin_page)
values('자료실', 4, '/board/page', 'N');

insert into jwland.menu(menu_name, menu_priority, url, admin_page)
values('공지사항', 5, '/notice/page', 'N');

insert into jwland.menu (menu_name, menu_priority, url, admin_page)
values('관리자 페이지', 6, '/admin/manage-page', 'Y');
--insert into jwland.menu(menu_name, menu_priority, url, admin_page)
--values('클리닉/보충', 8, , 'Y');

insert into jwland.menu (menu_name, menu_priority, url, admin_page)
values('내 계정 관리', 7, '/profile', 'N');



-- 시험 기관
insert into jwland.exam_organization(exam_organization_name) values('수능');
insert into jwland.exam_organization(exam_organization_name) values('평가원');
insert into jwland.exam_organization(exam_organization_name) values('교육청');
insert into jwland.exam_organization(exam_organization_name) values('대성');
insert into jwland.exam_organization(exam_organization_name) values('종로');

-- 시험 종류
-- 수능
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2021,11,1);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2020,11,1);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2019,11,1);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2018,11,1);
-- 평가원
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2021,9,2);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2021,6,2);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2020,9,2);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2020,6,2);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2019,9,2);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2019,6,2);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2018,9,2);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2018,6,2);
-- 교육청
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2021,10,3);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2021,7,3);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2021,4,3);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2021,3,3);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2020,10,3);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2020,7,3);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2020,4,3);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2020,3,3);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2019,10,3);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2019,7,3);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2019,4,3);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2019,3,3);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2018,10,3);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2018,7,3);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2018,4,3);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2018,3,3);

--사설
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2021,10,5);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2021,9,4);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2021,8,5);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2021,7,4);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2021,5,5);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2021,4,4);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2020,10,5);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2020,9,4);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2020,8,5);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2020,7,4);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2020,5,5);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2020,4,4);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2019,10,5);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2019,9,4);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2019,8,5);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2019,7,4);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2019,5,5); 
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2019,4,4);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2018,10,5);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2018,9,4);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2018,8,5);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2018,7,4);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2018,5,5);
insert into jwland.exam_type(year, month, exam_organization_sequence_no) values(2018,4,4);
 


-- 과목 종류
insert into jwland.exam_subject(subject)
values('생명과학1');
insert into jwland.exam_subject(subject)
values('화학1');
 

-- 회원 임시 데이터
insert into jwland.account(name, id, password, grade_code, school_code)
values('민준', 'test01', '1q1q1q', 'G0103', 'S0108');
insert into jwland.account(name, id, password, grade_code, school_code)
values('서준', 'test02','1q1q1q', 'G0102', 'S0107');
insert into jwland.account(name, id, password, grade_code, school_code)
values('예준', 'test03','1q1q1q', 'G0101', 'S0109');
insert into jwland.account(name, id, password, grade_code, school_code)
values('도윤', 'test04','1q1q1q', 'G0101', 'S0109');
insert into jwland.account(name, id, password, grade_code, school_code)
values('시우', 'test05','1q1q1q', 'G0102', 'S0106');
insert into jwland.account(name, id, password, grade_code, school_code)
values('주원', 'test06','1q1q1q', 'G0103', 'S0105');
insert into jwland.account(name, id, password, grade_code, school_code)
values('서연', 'test07','1q1q1q', 'G0104', 'S0104');
insert into jwland.account(name, id, password, grade_code, school_code)
values('서윤', 'test08','1q1q1q', 'G0104', 'S0103');
insert into jwland.account(name, id, password, grade_code, school_code)
values('지우', 'test09','1q1q1q', 'G0103', 'S0101');
insert into jwland.account(name, id, password, grade_code, school_code)
values('서현', 'test10','1q1q1q', 'G0102', 'S0102');
insert into jwland.account(name, id, password, grade_code, school_code)
values('민서', 'test11','1q1q1q', 'G0101', 'S0109');
insert into jwland.account(name, id, password, grade_code, role, school_code, approved)
values('admin', 'admin','0000', 'G0100', 'ROLE_ADMIN', 'S0100','Y');





-- exam_master 임시 데이터
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 1, 19, 1);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 1, 19, 2);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 1, 19, 3);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 1, 19, 4);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 1, 19, 5);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 1, 19, 6);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 1, 19, 7);

insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 2, 20, 1);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 2, 20, 3);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 2, 20, 5);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 2, 20, 6);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 2, 20, 7);

insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 1, 17, 1);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 1, 17, 3);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 1, 17, 7);

insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 1, 18, 1);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 1, 18, 6);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 1, 18, 7);

insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(2, 2, 20, 1);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(2, 2, 20, 2);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(2, 2, 20, 3);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(2, 2, 20, 4);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(2, 2, 20, 5);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(2, 2, 20, 6);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(2, 2, 20, 7);

insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(2, 1, 20, 1);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(2, 1, 20, 4);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(2, 1, 20, 5);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(2, 1, 20, 6);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(2, 1, 20, 7);

insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(2, 2, 16, 1);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(2, 2, 16, 4);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(2, 2, 16, 6);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(2, 2, 16, 7);

insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(3, 1, 13, 1);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(3, 1, 13, 7);

insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(3, 2, 15, 1);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(3, 2, 15, 5);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(3, 2, 15, 7);

insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(4, 1, 20, 1);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(4, 1, 20, 2);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(4, 1, 20, 3);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(4, 1, 20, 4);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(4, 1, 20, 5);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(4, 1, 20, 6);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(4, 1, 20, 7);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(4, 1, 20, 8);

insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(4, 2, 19, 1);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(4, 2, 19, 2);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(4, 2, 19, 3);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(4, 2, 19, 4);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(4, 2, 19, 5);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(4, 2, 19, 6);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(4, 2, 19, 7);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(4, 2, 19, 8);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(4, 2, 19, 9);



-- attendance status
insert into jwland.attendance_status values(1, '출석');
insert into jwland.attendance_status values(2, '지각');
insert into jwland.attendance_status values(3, '결석');

-- clinic type
insert into jwland.clinic_type values(1, '클리닉');
insert into jwland.clinic_type values(2, '보충');


-- school
INSERT INTO jwland.common_code_group VALUES('S01', '학교명');
INSERT INTO jwland.common_code_detail VALUES 
('S01', 'S0100', 'jwland'),
('S01', 'S0101', '영동고'),
('S01', 'S0102', '경기고'),
('S01', 'S0103', '청담고'),
('S01', 'S0104', '현대고'),
('S01', 'S0105', '진선여고'),
('S01', 'S0106', '숙명여고'),
('S01', 'S0107', '휘문고'),
('S01', 'S0108', '경기여고'),
('S01', 'S0109', '중학교');

-- class type
insert into jwland.class_type(class_type_name) values('중3 과학');
insert into jwland.class_type(class_type_name) values('고1 공통과학');
insert into jwland.class_type(class_type_name) values('고2 화학1');
insert into jwland.class_type(class_type_name) values('고2 생명과학1');
insert into jwland.class_type(class_type_name) values('고3 화학1');
insert into jwland.class_type(class_type_name) values('고3 생명과학1');

-- grades

INSERT INTO jwland.common_code_group VALUES('G01', '학년');
INSERT INTO jwland.common_code_detail VALUES 
('G01', 'G0100', 'jwland'),
('G01', 'G0101', '중3'),
('G01', 'G0102', '고1'),
('G01', 'G0103', '고2'),
('G01', 'G0104', '고3'),
('G01', 'G0105', 'N수생');


-- clinic data
insert into jwland.clinic_master(class_type_sequence_no, clinic_type_sequence_no, date, hour, minute) values(2, 1, '20211230', '12', '30');
insert into jwland.clinic_master(class_type_sequence_no, clinic_type_sequence_no, date, hour, minute) values(2, 1, '20211230', '13', '00');
insert into jwland.clinic_master(class_type_sequence_no, clinic_type_sequence_no, date, hour, minute) values(2, 1, '20211230', '13', '30');
insert into jwland.clinic_master(class_type_sequence_no, clinic_type_sequence_no, date, hour, minute) values(2, 1, '20211230', '14', '00');
insert into jwland.clinic_master(class_type_sequence_no, clinic_type_sequence_no, date, hour, minute) values(2, 1, '20211230', '14', '30');
insert into jwland.clinic_master(class_type_sequence_no, clinic_type_sequence_no, date, hour, minute) values(2, 1, '20211230', '15', '00');
insert into jwland.clinic_master(class_type_sequence_no, clinic_type_sequence_no, date, hour, minute) values(2, 1, '20211230', '15', '30');
insert into jwland.clinic_master(class_type_sequence_no, clinic_type_sequence_no, date, hour, minute) values(2, 1, '20211230', '16', '00');
insert into jwland.clinic_master(class_type_sequence_no, clinic_type_sequence_no, date, hour, minute) values(2, 1, '20211230', '16', '30');
insert into jwland.clinic_master(class_type_sequence_no, clinic_type_sequence_no, date, hour, minute) values(2, 1, '20211230', '17', '00');
insert into jwland.clinic_master(class_type_sequence_no, clinic_type_sequence_no, date, hour, minute) values(2, 1, '20211230', '17', '30');
insert into jwland.clinic_master(class_type_sequence_no, clinic_type_sequence_no, date, hour, minute) values(2, 1, '20211230', '18', '00');



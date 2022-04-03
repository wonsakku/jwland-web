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
INSERT INTO jwland.common_code_group VALUES('E01', '시험 주관 기관');
INSERT INTO jwland.common_code_detail VALUES 
('E01', 'E0101', '수능'),
('E01', 'E0102', '평가원'),
('E01', 'E0103', '교육청'),
('E01', 'E0104', '대성'),
('E01', 'E0105', '종로')
;


-- 시험 종류
-- 수능
insert into jwland.exam_type(year, month, exam_organization_code) values
(2021,11,'E0101'),
(2020,11,'E0101'),
(2019,11,'E0101'),
(2018,11,'E0101'),

-- 평가원
(2021,9,'E0102'),
(2021,6,'E0102'),
(2020,9,'E0102'),
(2020,6,'E0102'),
(2019,9,'E0102'),
(2019,6,'E0102'),
(2018,9,'E0102'),
(2018,6,'E0102'),

-- 교육청
(2021,10,'E0103'),
(2021,7,'E0103'),
(2021,4,'E0103'),
(2021,3,'E0103'),
(2020,10,'E0103'),
(2020,7,'E0103'),
(2020,4,'E0103'),
(2020,3,'E0103'),
(2019,10,'E0103'),
(2019,7,'E0103'),
(2019,4,'E0103'),
(2019,3,'E0103'),
(2018,10,'E0103'),
(2018,7,'E0103'),
(2018,4,'E0103'),
(2018,3,'E0103'),

--사설
(2021,10,'E0105'),
(2021,9,'E0104'),
(2021,8,'E0105'),
(2021,7,'E0104'),
(2021,5,'E0105'),
(2021,4,'E0104'),
(2020,10,'E0105'),
(2020,9,'E0104'),
(2020,8,'E0105'),
(2020,7,'E0104'),
(2020,5,'E0105'),
(2020,4,'E0104'),
(2019,10,'E0105'),
(2019,9,'E0104'),
(2019,8,'E0105'),
(2019,7,'E0104'),
(2019,5,'E0105'),
(2019,4,'E0104'),
(2018,10,'E0105'),
(2018,9,'E0104'),
(2018,8,'E0105'),
(2018,7,'E0104'),
(2018,5,'E0105'),
(2018,4,'E0104')
;
 


-- 과목 종류
INSERT INTO jwland.common_code_group VALUES('E02', '시험 과목');
INSERT INTO jwland.common_code_detail VALUES 
('E02', 'E0201', '생명과학1'),
('E02', 'E0202', '화학1')
;

 

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
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_code, problem_number, account_sequence_no) values
(1, 'E0201', 19, 1),
(1, 'E0201', 19, 2),
(1, 'E0201', 19, 3),
(1, 'E0201', 19, 4),
(1, 'E0201', 19, 5),
(1, 'E0201', 19, 6),
(1, 'E0201', 19, 7),

(1, 'E0202', 20, 1),
(1, 'E0202', 20, 3),
(1, 'E0202', 20, 5),
(1, 'E0202', 20, 6),
(1, 'E0202', 20, 7),

(1, 'E0201', 17, 1),
(1, 'E0201', 17, 3),
(1, 'E0201', 17, 7),

(1, 'E0201', 18, 1),
(1, 'E0201', 18, 6),
(1, 'E0201', 18, 7),

(2, 'E0202', 20, 1),
(2, 'E0202', 20, 2),
(2, 'E0202', 20, 3),
(2, 'E0202', 20, 4),
(2, 'E0202', 20, 5),
(2, 'E0202', 20, 6),
(2, 'E0202', 20, 7),

(2, 'E0201', 20, 1),
(2, 'E0201', 20, 4),
(2, 'E0201', 20, 5),
(2, 'E0201', 20, 6),
(2, 'E0201', 20, 7),

(2, 'E0202', 16, 1),
(2, 'E0202', 16, 4),
(2, 'E0202', 16, 6),
(2, 'E0202', 16, 7),

(3, 'E0201', 13, 1),
(3, 'E0201', 13, 7),

(3, 'E0202', 15, 1),
(3, 'E0202', 15, 5),
(3, 'E0202', 15, 7),

(4, 'E0201', 20, 1),
(4, 'E0201', 20, 2),
(4, 'E0201', 20, 3),
(4, 'E0201', 20, 4),
(4, 'E0201', 20, 5),
(4, 'E0201', 20, 6),
(4, 'E0201', 20, 7),
(4, 'E0201', 20, 8),

(4, 'E0202', 19, 1),
(4, 'E0202', 19, 2),
(4, 'E0202', 19, 3),
(4, 'E0202', 19, 4),
(4, 'E0202', 19, 5),
(4, 'E0202', 19, 6),
(4, 'E0202', 19, 7),
(4, 'E0202', 19, 8),
(4, 'E0202', 19, 9)
;



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
insert into jwland.common_code_group values
('C01', '수업 종류 코드');
insert into jwland.common_code_detail values
('C01', 'C0101', '중3 과학'),
('C01', 'C0102', '고1 공통과학'),
('C01', 'C0103', '고2 생명과학1'),
('C01', 'C0104', '고2 화학1'),
('C01', 'C0105', '고3 생명과학1'),
('C01', 'C0106', '고3 생명과학2')
;

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
insert into jwland.clinic_master(class_type_code, clinic_type_sequence_no, date, hour, minute) values
('C0101', 1, '20220405', '12', '30'),
('C0102', 1, '20220405', '13', '00'),
('C0103', 1, '20220405', '13', '30'),
('C0104', 1, '20220405', '14', '00'),
('C0105', 1, '20220405', '14', '30'),
('C0105', 1, '20220405', '15', '00'),
('C0104', 1, '20220405', '15', '30'),
('C0103', 1, '20220405', '16', '00'),
('C0102', 1, '20220405', '16', '30'),
('C0101', 1, '20220405', '17', '00'),
('C0102', 1, '20220405', '17', '30'),
('C0103', 1, '20220405', '18', '00')
;



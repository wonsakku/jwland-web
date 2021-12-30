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
insert into jwland.account(name, id, password, grade_sequence_no, school_sequence_no)
values('루피', '루피', '1q1q1q', 9, 9);
insert into jwland.account(name, id, password, grade_sequence_no, school_sequence_no)
values('조로', '조로','1q1q1q', 10, 7);
insert into jwland.account(name, id, password, grade_sequence_no, school_sequence_no)
values('나미', '나미','1q1q1q', 10, 8);
insert into jwland.account(name, id, password, grade_sequence_no, school_sequence_no)
values('상디', '상대','1q1q1q', 10, 7);
insert into jwland.account(name, id, password, grade_sequence_no, school_sequence_no)
values('비비', '비비','1q1q1q', 11, 8);
insert into jwland.account(name, id, password, grade_sequence_no, school_sequence_no)
values('블라디레나 밀리제', '블라디레나 밀리제','1q1q1q', 12, 7);
insert into jwland.account(name, id, password, grade_sequence_no, school_sequence_no)
values('신에이 노우젠', '신에이 노우젠','1q1q1q', 12, 6);
insert into jwland.account(name, id, password, grade_sequence_no, school_sequence_no)
values('라이덴 슈가', '라이덴 슈가','1q1q1q', 11, 5);
insert into jwland.account(name, id, password, grade_sequence_no, school_sequence_no)
values('세오토 릿카', '세오토 릿카','1q1q1q', 10, 4);
insert into jwland.account(name, id, password, grade_sequence_no, school_sequence_no)
values('앙쥬 에마', '앙쥬 에마','1q1q1q', 11, 3);
insert into jwland.account(name, id, password, grade_sequence_no, school_sequence_no)
values('크레나 쿠쿠밀라', '크루나 쿠쿠밀라','1q1q1q', 10, 1);
insert into jwland.account(name, id, password, grade_sequence_no, role, school_sequence_no, approved)
values('admin', 'admin','1q1q1q', 0, 'ROLE_ADMIN', 0,'Y');





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
insert into jwland.school(school_sequence_no, school_name) values(0, 'jwland');
insert into jwland.school(school_name) values('영동고');
insert into jwland.school(school_name) values('경기고');
insert into jwland.school(school_name) values('청담고');
insert into jwland.school(school_name) values('현대고');
insert into jwland.school(school_name) values('진선여고');
insert into jwland.school(school_name) values('숙명여고');
insert into jwland.school(school_name) values('휘문고');
insert into jwland.school(school_name) values('경기여고');
insert into jwland.school(school_name) values('중학교');

-- class type
insert into jwland.class_type(class_type_name) values('중3 과학');
insert into jwland.class_type(class_type_name) values('고1 공통과학');
insert into jwland.class_type(class_type_name) values('고2 화학1');
insert into jwland.class_type(class_type_name) values('고2 생명과학1');
insert into jwland.class_type(class_type_name) values('고3 화학1');
insert into jwland.class_type(class_type_name) values('고3 생명과학1');





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



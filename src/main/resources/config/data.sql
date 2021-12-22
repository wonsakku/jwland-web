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
insert into jwland.account(name, birth, nick_name)
values('루피', '0505', '밀집모자');
insert into jwland.account(name, birth, nick_name)
values('조로', '1111', '해적사냥꾼');
insert into jwland.account(name, birth, nick_name)
values('나미', '0703', '도둑고양이');
insert into jwland.account(name, birth, nick_name)
values('상디', '0302', '검은다리');
insert into jwland.account(name, birth, nick_name)
values('비비', '0202', '미스 웬즈데이');
insert into jwland.account(name, birth, nick_name)
values('블라디레나 밀리제', '0712', '선혈의 여왕');
insert into jwland.account(name, birth, nick_name)
values('신에이 노우젠', '0519', '언더테이커');
insert into jwland.account(name, birth, nick_name)
values('라이덴 슈가', '0825', '베어볼프(늑대인간)');
insert into jwland.account(name, birth, nick_name)
values('세오토 릿카', '0420', '래핑 폭스');
insert into jwland.account(name, birth, nick_name)
values('앙쥬 에마', '1002', '스노우 위치');
insert into jwland.account(name, birth, nick_name)
values('크레나 쿠쿠밀라', '0506', '건슬링거');
insert into jwland.account(name, birth, nick_name, approved, role)
values('admin', '0000', 'admin', 'Y', 'ROLE_ADMIN');





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




-- clinic type
insert into jwland.clinic_type values(1, '클리닉');
insert into jwland.clinic_type values(2, '보충');


-- school
insert into jwland.school(school_name) values('영동고');
insert into jwland.school(school_name) values('경기고');
insert into jwland.school(school_name) values('청담고');
insert into jwland.school(school_name) values('현대고');
insert into jwland.school(school_name) values('진선여고');
insert into jwland.school(school_name) values('숙명여고');
insert into jwland.school(school_name) values('휘문고');
insert into jwland.school(school_name) values('경기여고');



-- 







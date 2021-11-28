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
values('관리자 페이지', 6, '/admin/page', 'Y')
--insert into jwland.menu(menu_name, menu_priority, url, admin_page)
--values('클리닉/보충', 8, , 'Y');


-- 시험 종류
insert into jwland.exam_type(year, month, grade, exam_type)
values(2020,3,3,'전국 모의고사');

insert into jwland.exam_type(year, month, grade, exam_type)
values(2020,3,4,'대성');

insert into jwland.exam_type(year, month, grade, exam_type)
values(2020,4,3,'경기도 모의고사');

insert into jwland.exam_type(year, month, grade, exam_type)
values(2020,5,3,'종로');

insert into jwland.exam_type(year, month, grade, exam_type)
values(2020,6,3,'6월 평가원 모의고사');


-- 과목 종류
insert into jwland.exam_subject(subject)
values('생명과학1');
insert into jwland.exam_subject(subject)
values('생명과학2');
insert into jwland.exam_subject(subject)
values('화학1');
insert into jwland.exam_subject(subject)
values('화학2');



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





-- master 임시 데이터
-- 3월 전국모의고사 생1 19번
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 1, 19, 1);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 1, 19, 2);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 1, 19, 3);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 1, 19, 4);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 1, 19, 5);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 1, 19, 6);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 1, 19, 7);

-- 3월 전국모의고사 생2 18번
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 2, 18, 2);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 2, 18, 3);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 2, 18, 4);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 2, 18, 6);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(1, 2, 18, 7);

-- 6월 평가원 화1 20번
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(5, 3, 20, 1);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(5, 3, 20, 2);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(5, 3, 20, 3);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(5, 3, 20, 4);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(5, 3, 20, 5);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(5, 3, 20, 6);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(5, 3, 20, 7);

-- 4월 경기도 교육청 생2 16번
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(3, 2, 16, 2);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(3, 2, 16, 3);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(3, 2, 16, 5);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(3, 2, 16, 7);

-- 6월 평가원 생2 17번
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(5, 2, 17, 1);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(5, 2, 17, 2);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(5, 2, 17, 3);
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no) values(5, 2, 17, 4);






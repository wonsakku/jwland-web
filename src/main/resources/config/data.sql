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

insert into jwland.menu(menu_name, menu_priority, url, admin_page)
values('출결확인', 6, '/attendance/page', 'Y');

insert into jwland.menu(menu_name, menu_priority, url, admin_page)
values('클리닉 출결 확인', 7, '/clinic-attendance/page', 'Y');

insert into jwland.menu(menu_name, menu_priority, url, admin_page)
values('수업 관리', 8, '/class/manage-page', 'Y');

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
values('신에이 노우젠', '0519', '목없는 사신');
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
insert into jwland.exam_master(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no)
values(
	( select trunc(random() * (select count(*) from jwland.exam_type) ) + 1 ),
	( select trunc(random() * (select count(*) from jwland.exam_subject) ) + 1 ),
	( select trunc(random() * 21 )),
	( select trunc(random() * (select count(*) from jwland.account) ) + 1 )
);


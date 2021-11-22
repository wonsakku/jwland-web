--drop table
drop table if exists jwland.menu;
drop table if exists jwland.account;
drop table if exists jwland.exam_subject;
drop table if exists jwland.exam_type;
drop table if exists jwland.exam_master;
drop table if exists jwland.class;
drop table if exists jwland.account_class_map;



--drop sequence
drop sequence if exists jwland.menu_sequence;
drop sequence if exists jwland.account_sequence;
drop sequence if exists jwland.exam_subject_sequence;
drop sequence if exists jwland.exam_type_sequence;
drop sequence if exists jwland.exam_master_sequence;
drop sequence if exists jwland.class_sequence;




-- sequence
create sequence jwland.menu_sequence;
create sequence jwland.account_sequence;
create sequence jwland.exam_subject_sequence;
create sequence jwland.exam_type_sequence;
create sequence jwland.exam_master_sequence;
create sequence jwland.class_sequence;



-- table
create table jwland.menu(
	menu_sequence_no bigint DEFAULT NEXTVAL('jwland.menu_sequence'),
	menu_name varchar(50) not null unique,
	menu_priority int not null,
	url varchar(100) not null unique,
	admin_page varchar(1) not null default 'N',
	created_at TIMESTAMP not null default now(),
	modify_at TIMESTAMP not null default now(),
	constraint menu_primary_key PRIMARY KEY("menu_sequence_no")
);



create table jwland.account(
	account_sequence_no BIGINT DEFAULT NEXTVAL('jwland.account_sequence'),
	name varchar(20) not null,
	birth varchar(4) not null,
	nick_name varchar(20) not null unique,
	approved varchar(1) not null DEFAULT 'N',
	role varchar(20) not null default 'ROLE_STUDENT',
	created_at TIMESTAMP not null default now(),
	modify_at TIMESTAMP not null default now(),
	constraint account_primary_key PRIMARY KEY("account_sequence_no"),
	constraint account_unique_info_key UNIQUE(name, birth)
);




create table jwland.exam_subject(
	exam_subject_sequence_no int DEFAULT NEXTVAL('jwland.exam_subject_sequence'),
	subject varchar(10) NOT NULL UNIQUE,
	created_at TIMESTAMP NOT NULL DEFAULT now(),
	modify_at TIMESTAMP NOT NULL DEFAULT now(),
	constraint exam_subject_primary_key PRIMARY KEY("exam_subject_sequence_no")
);


create table jwland.exam_type(
	exam_type_sequence_no BIGINT DEFAULT NEXTVAL('jwland.exam_type_sequence'),
	year BIGINT NOT NULL,
	month BIGINT NOT NULL,
	grade VARCHAR(10) NOT NULL,
	exam_type VARCHAR(20) NOT NULL,
	created_at TIMESTAMP NOT NULL DEFAULT now(),
	modify_at TIMESTAMP NOT NULL DEFAULT now(),
	constraint exam_type_primary_key PRIMARY KEY("exam_type_sequence_no")
);


create table jwland.exam_master(
	exam_master_sequence_no BIGINT DEFAULT NEXTVAL('jwland.exam_master_sequence'),
	exam_type_sequence_no INT NOT NULL,
	exam_subject_sequence_no INT NOT NULL,
	problem_number SMALLINT NOT NULL CHECK(problem_number >= 1 AND problem_number <= 20),
	account_sequence_no BIGINT NOT NULL,
	created_at TIMESTAMP NOT NULL DEFAULT now(),
	modify_at TIMESTAMP NOT NULL DEFAULT now(),
	constraint exam_master_primary_key PRIMARY KEY("exam_master_sequence_no"),
	constraint exam_master_unique_info_key UNIQUE(exam_type_sequence_no, exam_subject_sequence_no, problem_number, account_sequence_no)	
);




create table jwland.class(
	class_sequence_no BIGINT DEFAULT NEXTVAL('jwland.class_sequence'),
	class_name varchar(100) NOT NULL,
	open_year varchar(4) NOT NULL,
	open_month varchar(2) NOT NULL,
	start_date varchar(8) NOT NULL,
	total_class_count SMALLINT NOT NULL,
	complete_class_count SMALLINT NOT NULL DEFAULT 0,
	open varchar(5) NOT NULL DEFAULT 'OPEN',
	created_at TIMESTAMP NOT NULL DEFAULT now(),
	create_account_id varchar(20) NOT NULL,
	modify_at TIMESTAMP NOT NULL DEFAULT now(),
	modify_account_id varchar(20) NOT NULL,
	constraint class_primary_key PRIMARY KEY("class_sequence_no")
);



create table jwland.account_class_map(
	class_sequence_no BIGINT,
	account_sequence_no BIGINT,
	constraint account_class_map_primary_key PRIMARY KEY("class_sequence_no", "account_sequence_no")
);









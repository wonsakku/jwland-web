--drop table
drop table if exists jwland.menu CASCADE;
drop table if exists jwland.account CASCADE;
drop table if exists jwland.exam_subject CASCADE;
drop table if exists jwland.exam_type CASCADE;
drop table if exists jwland.exam_master CASCADE;
drop table if exists jwland.exam_organization CASCADE;
drop table if exists jwland.class CASCADE;
drop table if exists jwland.account_class_map CASCADE;
drop table if exists jwland.class_attendance_management CASCADE;
drop table if exists jwland.clinic_master CASCADE;
drop table if exists jwland.school CASCADE;
drop table if exists jwland.class_type CASCADE;
drop table if exists jwland.clinic_type CASCADE;
drop table if exists jwland.clinic_account_map CASCADE;
drop table if exists jwland.grades CASCADE;
drop table if exists jwland.subject CASCADE;
drop table if exists jwland.attendance_status CASCADE;

--drop sequence
drop sequence if exists jwland.menu_sequence;
drop sequence if exists jwland.account_sequence;
drop sequence if exists jwland.exam_subject_sequence;
drop sequence if exists jwland.exam_type_sequence;
drop sequence if exists jwland.exam_master_sequence;
drop sequence if exists jwland.exam_organization_sequence;
drop sequence if exists jwland.class_sequence;
drop sequence if exists jwland.clinic_master_sequence;
drop sequence if exists jwland.school_sequence;
drop sequence if exists jwland.class_type_sequence;




-- sequence
create sequence jwland.menu_sequence;
create sequence jwland.account_sequence;
create sequence jwland.exam_subject_sequence;
create sequence jwland.exam_type_sequence;
create sequence jwland.exam_master_sequence;
create sequence jwland.exam_organization_sequence;
create sequence jwland.class_sequence;
create sequence jwland.clinic_master_sequence;
create sequence jwland.school_sequence;
create sequence jwland.class_type_sequence;




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
	id varchar(20) not null UNIQUE,
	name varchar(20) not null,
	password varchar(300) not null,
	grade_sequence_no SMALLINT not null,
	school_sequence_no BIGINT NOT NULL,
	approved varchar(1) not null DEFAULT 'N',
	role varchar(20) not null default 'ROLE_STUDENT',
	created_at TIMESTAMP not null default now(),
	modify_at TIMESTAMP not null default now(),
	constraint account_primary_key PRIMARY KEY("account_sequence_no")
);

create table jwland.grades(/*common_table*/
	grade_sequence_no INT NOT NULL,
	grade varchar(5) NOT NULL,
	CONSTRAINT grade_primary_key PRIMARY KEY("grade_sequence_no")
);


create table jwland.exam_subject(/*common_table*/
	exam_subject_sequence_no int DEFAULT NEXTVAL('jwland.exam_subject_sequence'),
	subject varchar(10) NOT NULL UNIQUE,
	created_at TIMESTAMP NOT NULL DEFAULT now(),
	modify_at TIMESTAMP NOT NULL DEFAULT now(),
	constraint exam_subject_primary_key PRIMARY KEY("exam_subject_sequence_no")
);


create table jwland.exam_organization(/*common_table*/
	exam_organization_sequence_no BIGINT DEFAULT NEXTVAL('jwland.exam_organization_sequence'),
	exam_organization_name VARCHAR(20) NOT NULL UNIQUE,
	created_at TIMESTAMP NOT NULL DEFAULT now(),
	modify_at TIMESTAMP NOT NULL DEFAULT now(),
	constraint exam_organization_primary_key PRIMARY KEY("exam_organization_sequence_no")
);


create table jwland.exam_type(
	exam_type_sequence_no BIGINT DEFAULT NEXTVAL('jwland.exam_type_sequence'),
	year BIGINT NOT NULL,
	month BIGINT NOT NULL,
	exam_organization_sequence_no BIGINT NOT NULL,
	created_at TIMESTAMP NOT NULL DEFAULT now(),
	modify_at TIMESTAMP NOT NULL DEFAULT now(),
	constraint exam_type_primary_key PRIMARY KEY("exam_type_sequence_no"),
	constraint exam_type_unique_info_key UNIQUE(year, month, exam_organization_sequence_no)	
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
	class_type_sequence_no BIGINT NOT NULL,
	start_date varchar(6) NOT NULL,
	open varchar(10) NOT NULL DEFAULT 'OPEN',
	created_at TIMESTAMP NOT NULL DEFAULT now(),
	create_account_id varchar(20) NOT NULL,
	modify_at TIMESTAMP NOT NULL DEFAULT now(),
	modify_account_id varchar(20) NOT NULL,
	constraint class_primary_key PRIMARY KEY("class_sequence_no")
);


create table jwland.class_type(/*common_table*/
	class_type_sequence_no BIGINT DEFAULT NEXTVAL('jwland.class_type_sequence'),
	class_type_name varchar(20) NOT NULL,
	CONSTRAINT class_type_primary_key PRIMARY KEY("class_type_sequence_no")	
);



create table jwland.account_class_map(
	class_sequence_no BIGINT,
	account_sequence_no BIGINT,
	constraint account_class_map_primary_key PRIMARY KEY("class_sequence_no", "account_sequence_no")
);


create table jwland.attendance_status(/*common_table*/
	attendance_status_sequence_no INT NOT NULL,
	attendance_status VARCHAR(2) NOT NULL,
	CONSTRAINT attendance_status_primary_key PRIMARY KEY("attendance_status_sequence_no")	
);

create table jwland.class_attendance_management(
	class_sequence_no BIGINT,
	account_sequence_no BIGINT,
	class_date varchar(8),
	attendance_status_sequence_no INT NOT NULL,
	created_at TIMESTAMP NOT NULL DEFAULT now(),
	create_account_id varchar(20) NOT NULL,
	modify_at TIMESTAMP NOT NULL DEFAULT now(),
	modify_account_id varchar(20) NOT NULL,
	constraint class_attendance_management_primary_key PRIMARY KEY("class_sequence_no", "account_sequence_no", "class_date")
);


create table jwland.clinic_master(
	clinic_master_sequence_no BIGINT DEFAULT NEXTVAL('jwland.clinic_master_sequence'),
	class_type_sequence_no BIGINT NOT NULL,
	clinic_type_sequence_no BIGINT NOT NULL,
	date varchar(8) NOT NULL,
	hour varchar(2) NOT NULL,
	minute varchar(2) NOT NULL,
	CONSTRAINT clinic_master_primary_key PRIMARY KEY("clinic_master_sequence_no"),
	CONSTRAINT clinic_master_unique_key UNIQUE("date", "hour", "minute")
);


create table jwland.clinic_type( /*common_table*/
	clinic_type_sequence_no BIGINT NOT NULL,
	clinic_type VARCHAR(3) NOT NULL,
	CONSTRAINT clinic_type_primary_key PRIMARY KEY("clinic_type_sequence_no")	
);


create table jwland.clinic_account_map(
	clinic_master_sequence_no BIGINT,
	account_sequence_no BIGINT,
	CONSTRAINT clinic_account_map_primary_key PRIMARY KEY("clinic_master_sequence_no", "account_sequence_no")
);


create table jwland.school(/*common_table*/
	school_sequence_no BIGINT DEFAULT NEXTVAL('jwland.school_sequence'),
	school_name varchar(10) NOT NULL UNIQUE,
	CONSTRAINT school_primary_key PRIMARY KEY("school_sequence_no")
);



create table jwland.subject(/*common_table*/
	subject_sequence_no INT NOT NULL,
	subject_name varchar(10) NOT NULL UNIQUE,
	CONSTRAINT subject_primary_key PRIMARY KEY("subject_sequence_no")
);










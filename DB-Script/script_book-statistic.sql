========예약정보테이블======== 
create table tb_book (
	no number(10) primary key,
	head_cnt varchar2(2) not null,
	member_id varchar2(50) not null,
	book_date date not null,
	book_start_time number(2) not null,
	book_end_time number(2) not null,
	room_name varchar2(1) not null,
	reg_date date default sysdate
	);

create sequence s_book_no;					
					
					
========방정보테이블======== 
create table tb_room_info (
	no number(10) primary key,
	img_save_path varchar2(100),
	max_head_cnt number(2),
	name varchar2(1)
	);
create sequence s_room_info_no;

insert into tb_room_info (	no,
							img_save_path,
							max_head_cnt,
							name ) 
					values( s_room_info_no.nextVal,
							'/mini2-team1/img/a.jpg',
							6,
							'a'
					);

========예약통계테이블======== 
create table tb_statistic (
	no number(10) primary key,
	book_date date not null,
	book_room_name varchar2(1),
	use_time number(2)
	);
						  
create sequence s_statistic_no;						  
	

===========03.08 업데이트==============
tb_book테이블 컬럼 mobile_no추가
tb_book테이블 컬럼 book_date 타입 varchar2(8)로 변경
tb_statistic 컬럼 book_date 타입 varchar2(8)로 변경
========예약정보테이블======== 
create table tb_book (
	no number(10) primary key,
	head_cnt varchar2(2) not null,
	member_id varchar2(50) not null,
	mobile_no varchar2(11) not null,
	book_date varchar2(8) not null,
	book_start_time number(2) not null,
	book_end_time number(2) not null,
	room_name varchar2(1) not null,
	reg_date date default sysdate
	);

create sequence s_book_no;					

insert into tb_book(
	no,
	head_cnt,
	member_id,
	mobile_no,
	book_date,
	book_start_time,
	book_end_time, 
	room_name
	) values(
	s_book_no.nextval, 
	6, 
	'flygil', 
	'01077775555',
	'20170307',
	12,
	14,
	'b');
					
========방정보테이블======== 
create table tb_room_info (
	no number(10) primary key,
	img_save_path varchar2(100),
	max_head_cnt number(2),
	name varchar2(1)
	);
create sequence s_room_info_no;

insert into tb_room_info (	no,
							img_save_path,
							max_head_cnt,
							name ) 
					values( s_room_info_no.nextVal,
							'/mini2-team1/img/a.jpg',
							6,
							'a'
					);

========예약통계테이블======== 
create table tb_statistic (
	no number(10) primary key,
	book_date varchar2(8) not null,
	book_room_name varchar2(1),
	use_time number(2)
	);
						  
create sequence s_statistic_no;						  
						
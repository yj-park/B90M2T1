========예약정보테이블======== 
create table tb_book {
						no number(10) primary key,
						head_cnt varchar2(2) not null,
						member_id varchar2(50) not null,
						book_date date not null,
						book_start_time number(2), not null,
						book_end_time number(2), not null,
						room_name varchar2(1) not null,
						reg_date date default sysdate
					};

create sequence s_book_no;					
					
					
========방정보테이블======== 
create table tb_room_info {
							no number(10) primary key,
							img_save_path varchar2(100),
							max_head_cnt number(2),
							name varchar2(1)
						};
create sequence s_room_info_no;

========예약통계테이블======== 
create table tb_statistic {
							no number(10) primary key,
							book_date date not null,
							book_room_name varchar2(1),
							use_time number(2)
						  };
						  
create sequence s_statistic_no;						  
						
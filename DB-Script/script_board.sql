============= 게시판 테이블 =====================================
create table tb_pboard (
  no number(10) primary key,
  member_id varchar2(50) not null,
  title varchar2(100) not null,
  content varchar2(3000) not null,
  view_cnt number(10) default 0,
  reg_date date default sysdate not null
);

desc tb_pboard;

create sequence s_pboard_no;

insert into tb_pboard (no, member_id, title, content)
values(s_pboard_no.nextVal, '티모', '안녕하세요', '티모입니다');

select * from tb_pboard;

===========================================================

============= 파일 테이블 =====================================

create table tb_file (

  NO NUMBER(10) PRIMARY KEY,
  SYSTEM_NAME VARCHAR2(50) NOT NULL,
  ORI_NAME VARCHAR(50) NOT NULL,
  SAVE_PATH VARCHAR(50) NOT NULL,
  BOARD_NO NUMBER(10) NOT NULL

);

CREATE SEQUENCE S_FILE_NO;

DESC TB_FILE;

SELECT * FROM TB_FILE;
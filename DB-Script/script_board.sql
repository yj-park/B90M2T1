============= 게시판 테이블 =====================================
create table tb_board (
  no number(10) primary key,
  member_id varchar2(50) not null,
  title varchar2(100) not null,
  content varchar2(3000) not null,
  view_cnt number(10) default 0,
  reg_date date default sysdate not null
);

desc tb_board;

create sequence s_board_no;

insert into tb_board (no, member_id, title, content)
values(s_board_no.nextVal, '티모', '안녕하세요', '티모입니다');

select * from tb_board;

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

===========================================================

============= 댓글 테이블 =====================================

CREATE TABLE TB_COMMENT (

  NO NUMBER(10) PRIMARY KEY,
  BOARD_NO NUMBER(10) NOT NULL,
  MEMBER_ID VARCHAR2(50) NOT NULL,
  CONTENT VARCHAR2(3000) NOT NULL,
  REG_DATE DATE DEFAULT SYSDATE NOT NULL

);

CREATE SEQUENCE S_COMMENT_NO;

DESC TB_COMMENT;

INSERT INTO TB_COMMENT (NO, BOARD_NO, MEMBER_ID, CONTENT )
VALUES ( S_COMMENT_NO.NEXTVAL, 284, '노원구에사는사람', '태연FINE 좋아요');
 
SELECT * FROM TB_COMMENT;







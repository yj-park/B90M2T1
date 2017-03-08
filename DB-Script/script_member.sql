create table tb_member (
	id varchar2(50) not null,
	password varchar2(20) not null,
   	name varchar2(20) not null,
   	mobile_no varchar2(11),
	reg_date date default sysdate
	constraint pk_member primary key (id))

select * from TB_MEMBER

insert into tb_member (
id,
password,
name,
mobile_no)
values(
'root@naver.com',
'1234',
'root',
01012345678)

desc tb_member
commit;

-- sample
create table sample (
    id varchar2(10),
    pw varchar2(50),
    point int default 0
);
select * from sample;
drop table sample;

-- sample_dummy
insert into sample(id, pw) values( 'admin', '1234' );
insert into sample(id, pw) values( 'lhy', '1111' );


-- board
create table vboard(
    vno int primary key,
    vtitle varchar2(100) not null,
    vcontent varchar2(2000) not null,
    id varchar2(50) not null,
    regdate date default sysdate,
    hits int default 0,
    moddate date
);
select * from vboard;
select to_char(sysdate, 'yyyy-MM-dd') from dual;
select vno, vtitle, vcontent, to_char(regdate,'yyyy-MM-dd'), hits from vboard;
alter table vboard drop column hits;
alter table vboard add hits int default 0;
alter table vboard add moddate date;
alter table vboard modify moddate date default sysdate;
update vboard set hits=hits+1 where vno=1;


-- board_sequence
create sequence vseq increment by 1 start with 1 maxvalue 1000;
alter sequence vseq maxvalue 99999;

-- board_dummy
insert into vboard values( vseq.nextval, '공지테스트 제목1입니다.', '공지테스트 내부에 저장되는 내용1입니다.', 'admin', sysdate );
insert into vboard values( vseq.nextval, '공지테스트 제목2입니다.', '공지테스트 내부에 저장되는 내용2입니다.', 'admin', sysdate );


-- user1(ajax) test
create table user1 (
    idm int primary key,
    id varchar2(100) not null,
    pw varchar2(1000) not null,
    name varchar2(50),
    email varchar2(200),
    regdate date default sysdate
);
select * from user1;
select * from user1 where (id='admin' and pw='1234');
alter table user1 add regdate date default sysdate;
drop table user1 cascade CONSTRAINTS;

-- user1_sequence
create sequence useq1 increment by 1 start with 1 maxvalue 1000;
drop sequence useq1;

-- user1_dummy
insert into user1 values( useq1.nextval, 'admin', '1234', '관리자');
insert into user1 values( useq1.nextval, 'lhy', '1111', '이하영' );
update user1 set email='dllgkdud@gmail.com' where id='admin';
update user1 set regdate=sysdate where id='admin';

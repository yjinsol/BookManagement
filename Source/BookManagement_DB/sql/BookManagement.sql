drop table t_book;
drop table t_user;
drop table t_rentInfo;
drop sequence seq_t_book_no;
drop sequence seq_t_user_no;

create table t_book(
    no number(5)  primary key  
    , title varchar2(1000)  not null
    , author varchar2(200) not null
    , reg_date date  default sysdate 
    , rent_flag number(1) default -1
    , rent_date varchar2(20) default null
);


create table t_user(
    no number(5) unique
    , id varchar2(200) primary key
    , passwd varchar2(500) not null
    , name varchar2(300) 
);



create table t_rentInfo(
    id varchar2(200) not null
    , book_no number(5) primary key
);


create sequence seq_t_book_no;
create sequence seq_t_user_no;

/*
select * from t_user;
select * from t_book;

select seq_t_book_no.nextval from dual;
select seq_t_user_no.nextval from dual;
*/
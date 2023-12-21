create sequence customer_seq start with 1 increment by 50;
create table customer (id bigint not null, firstname varchar(255), lastname varchar(255), primary key (id));


-- USER TABLE--
create sequence user_id
start  with 1 increment by 1;
CREATE TABLE user_gift(user_id number default user_id.nextval primary key,
user_name varchar2(30)not null,
user_Password varchar2(20)not null,
email varchar2(30) not null unique,
mobile_number number not null unique);

--PRODUCTS TABLE--
CREATE TABLE gproducts(product_id NUMBER PRIMARY KEY NOT NULL,
product_name VARCHAR2(32) NOT NULL,
description VARCHAR2 (40)NOT NULL,
standard_cost NUMBER NOT NULL,
category VARCHAR2 (32)NOT NULL,
quantity_onhand number);

--cart table--
create table gcart (image varchar2(300),
product_name varchar2(30),
p_type varchar2(30),
standard_cost number,
p_size varchar2(10),
quantity number);
ALTER TABLE gcart
ADD CONSTRAINT FK_pid
FOREIGN KEY (product_id) REFERENCES gproducts(product_id);

--ORDERS TABLE--
CREATE TABLE gorders
(user_id number not null,
product_name varchar2(20),
p_type varchar2 (20),
order_id NUMBER generated always as identity(start with 1 increment by 1),
order_date timestamp,
p_size varchar2(20),
total_price number,
quantity number,
status VARCHAR2(20) default 'ordered',
--constraint fk_userid
foreign key(user_id)references user_gift(user_id));
ALTER table gorders modify ORDER_DATE  DEFAULT sysdate;
SELECT order_id,order_date FROM gorders where user_id = 105 order by order_date desc fetch first rows only;

--ORDER ITEMS TABLE--
CREATE TABLE gorder_items1(order_id number,
user_name varchar2(30),
product_name varchar2(20)  not null,
quantity_ordered NUMBER NOT NULL,
Total_price number not null,
foreign key(user_id)references user_gift(user_id));
alter table gorder_items1
ADD CONSTRAINT FK_pidd
FOREIGN KEY (product_id) REFERENCES gproducts(product_id);
ALTER TABLE gorder_items1
ADD CONSTRAINT FK_uid
FOREIGN KEY (user_id) REFERENCES user_gift(user_id);

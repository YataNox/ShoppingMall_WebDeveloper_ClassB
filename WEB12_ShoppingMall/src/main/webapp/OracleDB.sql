
/* Drop Tables */

DROP TABLE member CASCADE CONSTRAINTS;
DROP TABLE product CASCADE CONSTRAINTS;
DROP TABLE worker CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE member
(
	id varchar2(20) NOT NULL UNIQUE,
	pwd varchar2(20) NOT NULL,
	name varchar2(20) NOT NULL,
	email varchar2(40) NOT NULL,
	zip_num varchar2(10) NOT NULL,
	address varchar2(100) NOT NULL,
	phone varchar2(20) NOT NULL,
	useyn char(1) DEFAULT 'y',
	indate date DEFAULT sysdate,
	PRIMARY KEY (id)
);


CREATE TABLE product
(
	pseq number(5) NOT NULL,
	name varchar2(100) NOT NULL,
	kind char(1) NOT NULL,
	price1 number(7),
	price2 number(7),
	price3 number(7),
	content varchar2(1000),
	image varchar2(50),
	useyn char(1) DEFAULT 'y',
	bestyn char(1) DEFAULT 'n',
	indate date DEFAULT sysdate,
	PRIMARY KEY (pseq)
);


-- 쇼핑몰 관리자 테이블
CREATE TABLE worker
(
	id varchar2(20) NOT NULL,
	pwd varchar2(20) NOT NULL,
	name varchar2(20) NOT NULL,
	phone varchar2(20) NOT NULL,
	PRIMARY KEY (id)
);



/* Comments */

COMMENT ON TABLE worker IS '쇼핑몰 관리자 테이블';




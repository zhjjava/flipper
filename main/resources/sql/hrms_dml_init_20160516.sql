INSERT INTO sys_department (depart_id, depart_name, depart_status, depart_num, depart_major, create_time, create_id, update_time, update_id) VALUES (1,'IT',1,'2090',1000,NULL,NULL,NULL,NULL);
INSERT INTO sys_department (depart_id, depart_name, depart_status, depart_num, depart_major, create_time, create_id, update_time, update_id) VALUES (2,'R&D',1,'9080',1010,NULL,NULL,NULL,NULL);
INSERT INTO sys_department (depart_id, depart_name, depart_status, depart_num, depart_major, create_time, create_id, update_time, update_id) VALUES (3,'HR',1,'9090',1000,NULL,NULL,NULL,NULL);

INSERT INTO CREDENTIALS(username, password,verifyPassword,enabled) values('admin','$2a$10$Hp6eNKFPZvmt0P92dObd9OdX1t1D7ncYYbCeouVXoYpXIDg5v3Nsa','$2a$10$Hp6eNKFPZvmt0P92dObd9OdX1t1D7ncYYbCeouVXoYpXIDg5v3Nsa',1);  	
INSERT INTO CREDENTIALS(username, password,verifyPassword,enabled) values('test1','$2a$10$Hp6eNKFPZvmt0P92dObd9OdX1t1D7ncYYbCeouVXoYpXIDg5v3Nsa','$2a$10$Hp6eNKFPZvmt0P92dObd9OdX1t1D7ncYYbCeouVXoYpXIDg5v3Nsa',1);
INSERT INTO CREDENTIALS(username, password,verifyPassword,enabled) values('test2','$2a$10$Hp6eNKFPZvmt0P92dObd9OdX1t1D7ncYYbCeouVXoYpXIDg5v3Nsa','$2a$10$Hp6eNKFPZvmt0P92dObd9OdX1t1D7ncYYbCeouVXoYpXIDg5v3Nsa',1);

INSERT INTO sys_user (USER_ID, memberid, FIRST_NAME, LAST_NAME, LOGIN_NAME, PASSWORD, SID, DEPART_ID, GENDER, ENTRY_DATE,PERSONAL_EMAIL, EDU_DEGREE, EDU_SCHOOL, EDU_MAJOR, CELL_PHONE, HOME_ADDR, BIRTH_DATE, ID_NUMBER, BANK_NAME, BANK_ACCOUNT, EMP_STATUS, QUIT_DATE, STATUS, POSITION_ID, SUPERIOR_USER_ID, USER_TYPE, NOTES, SEQ, CREATE_ID, CREATE_TIME, UPDATE_ID, UPDATE_TIME) 
VALUES (1000,'admin','Michael','Zhou','admin','123','0001',1,'Male','2010-01-01','zhjjava@126.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,1,NULL,NULL,'1',NULL,999,NULL,'2015-06-30 06:00:54',NULL,'2015-06-30 05:53:28');
INSERT INTO sys_user (USER_ID,memberid, FIRST_NAME, LAST_NAME, LOGIN_NAME, PASSWORD, SID, DEPART_ID, GENDER, ENTRY_DATE,PERSONAL_EMAIL, EDU_DEGREE, EDU_SCHOOL, EDU_MAJOR, CELL_PHONE, HOME_ADDR, BIRTH_DATE, ID_NUMBER, BANK_NAME, BANK_ACCOUNT, EMP_STATUS, QUIT_DATE, STATUS, POSITION_ID, SUPERIOR_USER_ID, USER_TYPE, NOTES, SEQ, CREATE_ID, CREATE_TIME, UPDATE_ID, UPDATE_TIME) 
VALUES (1010,'test1','Employee1','u1','test1','123','1',2,'Female','2010-01-01','congls2007@yahoo.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,1,1,NULL,'1',NULL,999,NULL,NULL,NULL,NULL);
INSERT INTO sys_user (USER_ID,memberid, FIRST_NAME, LAST_NAME, LOGIN_NAME, PASSWORD, SID, DEPART_ID, GENDER, ENTRY_DATE,PERSONAL_EMAIL, EDU_DEGREE, EDU_SCHOOL, EDU_MAJOR, CELL_PHONE, HOME_ADDR, BIRTH_DATE, ID_NUMBER, BANK_NAME, BANK_ACCOUNT, EMP_STATUS, QUIT_DATE, STATUS, POSITION_ID, SUPERIOR_USER_ID, USER_TYPE, NOTES, SEQ, CREATE_ID, CREATE_TIME, UPDATE_ID, UPDATE_TIME) 
VALUES (1020,'test2','Manager1','m1','test2','123','1',2,'Female','2010-01-01','333@333.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,1,1,NULL,'1',NULL,999,NULL,NULL,NULL,NULL);

INSERT INTO authority(username, authority,credentials_id) values('admin','ROLE_ADMIN','admin');
INSERT INTO authority(username, authority,credentials_id) values('test1','ROLE_MANAGER','test1');  	
INSERT INTO authority(username, authority,credentials_id) values('test2','ROLE_STAFF','test2');  	

INSERT INTO sys_locale (LOCALE_CODE, LOCALE_NAME, STATUS, SEQ) VALUES ('en_US','en_US',1,1),('zh_CN','zh_CN',1,1);
INSERT INTO sys_code_category (CATEGORY_ID, CATEGORY_NAME, STATUS, EDITABLE) VALUES (1000,'Test Category1',1,1),(2000,'Test Category2',1,1);
INSERT INTO sys_code (SYS_CODE_ID, CATEGORY_ID, LOCALE_CODE, THE_KEY, THE_VALUE, SEQ, STATUS) VALUES (1000,2000,'zh_CN','1000','test',99,1),(1001,2000,'en_US','1000','test11',23,0),(1002,1000,'EN_US','1000','test2',1,1),(1003,1000,'EN_US','1000','test3',1,1),(1004,1000,'EN_US','1000','test4',1,1),(1005,1000,'EN_US','1000','test5',1,1),(1006,1000,'EN_US','1000','test6',1,1),(1007,1000,'EN_US','1000','test7',1,1),(1009,1000,'EN_US','1000','test9',1,1),(1010,1000,'EN_US','1000','test10',1,1),(1088,1000,'EN_US','1000','test88',1,1);




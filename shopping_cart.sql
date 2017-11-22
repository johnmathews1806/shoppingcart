--------------------------------------------------------
--  File created - Wednesday-November-22-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence HIBERNATE_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "HIBERNATE_SEQUENCE"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 161 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table CONTACT_DETAILS
--------------------------------------------------------

  CREATE TABLE "CONTACT_DETAILS" 
   (	"CONTACT_ID" NUMBER(10,0), 
	"USER_ID" NUMBER(10,0), 
	"ADDRESS_1" VARCHAR2(100), 
	"ADDRESS_2" VARCHAR2(100), 
	"CITY" VARCHAR2(50), 
	"STATE" VARCHAR2(50), 
	"COUNTRY" VARCHAR2(50), 
	"EMAIL_ID" VARCHAR2(50), 
	"PHONE" VARCHAR2(20), 
	"MOBILE" VARCHAR2(20), 
	"CREATE_DATE" DATE, 
	"CREATE_USER" VARCHAR2(20), 
	"UPDATE_DATE" DATE, 
	"UPDATE_USER" VARCHAR2(20)
   ) ;
--------------------------------------------------------
--  DDL for Table ORDERS
--------------------------------------------------------

  CREATE TABLE "ORDERS" 
   (	"ORDER_ID" NUMBER(10,0), 
	"USER_ID" NUMBER(10,0), 
	"TOTAL" NUMBER(20,2), 
	"ORDER_DATE" DATE, 
	"PAID_FLAG" VARCHAR2(1), 
	"PAID_DATE" DATE, 
	"CANCEL_FLAG" VARCHAR2(1), 
	"CANCEL_DATE" DATE, 
	"REVERSED_FLAG" VARCHAR2(1), 
	"REVERSAL_DATE" DATE, 
	"DELIVERED_FLAG" VARCHAR2(1), 
	"DELIVERY_DATE" DATE, 
	"ORDER_STATUS" VARCHAR2(1)
   ) ;
--------------------------------------------------------
--  DDL for Table ORDERS_DETAILS
--------------------------------------------------------

  CREATE TABLE "ORDERS_DETAILS" 
   (	"ORDER_DETAILS_ID" NUMBER(10,0), 
	"ORDER_ID" NUMBER(10,0), 
	"PRODUCT_ID" NUMBER(10,0), 
	"QUANTITY" NUMBER(4,0), 
	"AMOUNT" NUMBER(20,2)
   ) ;
--------------------------------------------------------
--  DDL for Table PERMISSIONS
--------------------------------------------------------

  CREATE TABLE "PERMISSIONS" 
   (	"PERMISSION_ID" NUMBER(10,0), 
	"PERMISSION_NAME" VARCHAR2(30), 
	"PERMISSION_DESCRIPTION" VARCHAR2(100), 
	"STATUS" VARCHAR2(1)
   ) ;
--------------------------------------------------------
--  DDL for Table PRODUCTS
--------------------------------------------------------

  CREATE TABLE "PRODUCTS" 
   (	"PRODUCT_ID" NUMBER(10,0), 
	"PRODUCT_NAME" VARCHAR2(50), 
	"DESCRIPTION" VARCHAR2(200), 
	"PRICE" NUMBER(20,2), 
	"CREATE_DATE" DATE, 
	"CREATE_USER" VARCHAR2(20), 
	"UPDATE_DATE" DATE, 
	"UPDATE_USER" VARCHAR2(20), 
	"MANUFACTURER" VARCHAR2(50), 
	"LAUNCH_DATE" DATE, 
	"PRODUCT_CODE" VARCHAR2(20)
   ) ;
--------------------------------------------------------
--  DDL for Table ROLES
--------------------------------------------------------

  CREATE TABLE "ROLES" 
   (	"ROLE_ID" NUMBER(10,0), 
	"ROLE_NAME" VARCHAR2(20), 
	"ROLE_DESCRIPTION" VARCHAR2(200), 
	"STATUS" VARCHAR2(1)
   ) ;
--------------------------------------------------------
--  DDL for Table ROLE_PERMISSION
--------------------------------------------------------

  CREATE TABLE "ROLE_PERMISSION" 
   (	"ROLE_ID" NUMBER(10,0), 
	"PERMISSION_ID" NUMBER(10,0)
   ) ;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "USERS" 
   (	"USER_ID" NUMBER(10,0), 
	"LOGIN_ID" VARCHAR2(20), 
	"PASSWORD" VARCHAR2(100), 
	"FIRST_NAME" VARCHAR2(50), 
	"MIDDLE_NAME" VARCHAR2(50), 
	"LAST_NAME" VARCHAR2(50), 
	"DOB" DATE, 
	"CREATE_DATE" DATE, 
	"CREATE_USER" VARCHAR2(20), 
	"UPDATE_DATE" DATE, 
	"UPDATE_USER" VARCHAR2(20), 
	"ROLE_ID" NUMBER(10,0)
   ) ;
--------------------------------------------------------
--  DDL for Table USER_ROLE
--------------------------------------------------------

  CREATE TABLE "USER_ROLE" 
   (	"USER_ID" NUMBER(10,0), 
	"ROLE_ID" NUMBER(10,0)
   ) ;
REM INSERTING into CONTACT_DETAILS
SET DEFINE OFF;
Insert into CONTACT_DETAILS (CONTACT_ID,USER_ID,ADDRESS_1,ADDRESS_2,CITY,STATE,COUNTRY,EMAIL_ID,PHONE,MOBILE,CREATE_DATE,CREATE_USER,UPDATE_DATE,UPDATE_USER) values (5,1,'Global Axis EPIP','Whitefield','Bangalore','Karnataka','India','jm.john@gmail.com','80 49184562','80 49184562',to_date('16-OCT-17','DD-MON-RR'),'ADMIN',to_date('16-OCT-17','DD-MON-RR'),'ADMIN');
Insert into CONTACT_DETAILS (CONTACT_ID,USER_ID,ADDRESS_1,ADDRESS_2,CITY,STATE,COUNTRY,EMAIL_ID,PHONE,MOBILE,CREATE_DATE,CREATE_USER,UPDATE_DATE,UPDATE_USER) values (6,2,'Oracle Financial Services Software Ltd, Global Axis','EPIP Area, Whitefield, 560064','Bangalore','Karnataka','India','jm.john@gmail.com','80 49184562','80 49184562',to_date('17-OCT-17','DD-MON-RR'),'ADMIN',to_date('17-OCT-17','DD-MON-RR'),'ADMIN');
Insert into CONTACT_DETAILS (CONTACT_ID,USER_ID,ADDRESS_1,ADDRESS_2,CITY,STATE,COUNTRY,EMAIL_ID,PHONE,MOBILE,CREATE_DATE,CREATE_USER,UPDATE_DATE,UPDATE_USER) values (7,1,'Victorian View Layout, Borewell Road','Whitefield','Bangalore',null,'India','jm.john@gmail.com','80 49184562','80 49184562',to_date('16-OCT-17','DD-MON-RR'),'ADMIN',to_date('16-OCT-17','DD-MON-RR'),'ADMIN');
REM INSERTING into ORDERS
SET DEFINE OFF;
Insert into ORDERS (ORDER_ID,USER_ID,TOTAL,ORDER_DATE,PAID_FLAG,PAID_DATE,CANCEL_FLAG,CANCEL_DATE,REVERSED_FLAG,REVERSAL_DATE,DELIVERED_FLAG,DELIVERY_DATE,ORDER_STATUS) values (142,2,null,null,null,null,null,null,null,null,null,null,null);
Insert into ORDERS (ORDER_ID,USER_ID,TOTAL,ORDER_DATE,PAID_FLAG,PAID_DATE,CANCEL_FLAG,CANCEL_DATE,REVERSED_FLAG,REVERSAL_DATE,DELIVERED_FLAG,DELIVERY_DATE,ORDER_STATUS) values (88,1,null,null,null,null,null,null,null,null,null,null,null);
Insert into ORDERS (ORDER_ID,USER_ID,TOTAL,ORDER_DATE,PAID_FLAG,PAID_DATE,CANCEL_FLAG,CANCEL_DATE,REVERSED_FLAG,REVERSAL_DATE,DELIVERED_FLAG,DELIVERY_DATE,ORDER_STATUS) values (44,2,null,null,null,null,null,null,null,null,null,null,null);
Insert into ORDERS (ORDER_ID,USER_ID,TOTAL,ORDER_DATE,PAID_FLAG,PAID_DATE,CANCEL_FLAG,CANCEL_DATE,REVERSED_FLAG,REVERSAL_DATE,DELIVERED_FLAG,DELIVERY_DATE,ORDER_STATUS) values (90,2,null,null,null,null,null,null,null,null,null,null,null);
Insert into ORDERS (ORDER_ID,USER_ID,TOTAL,ORDER_DATE,PAID_FLAG,PAID_DATE,CANCEL_FLAG,CANCEL_DATE,REVERSED_FLAG,REVERSAL_DATE,DELIVERED_FLAG,DELIVERY_DATE,ORDER_STATUS) values (49,1,null,null,null,null,null,null,null,null,null,null,null);
Insert into ORDERS (ORDER_ID,USER_ID,TOTAL,ORDER_DATE,PAID_FLAG,PAID_DATE,CANCEL_FLAG,CANCEL_DATE,REVERSED_FLAG,REVERSAL_DATE,DELIVERED_FLAG,DELIVERY_DATE,ORDER_STATUS) values (81,1,null,null,null,null,null,null,null,null,null,null,null);
Insert into ORDERS (ORDER_ID,USER_ID,TOTAL,ORDER_DATE,PAID_FLAG,PAID_DATE,CANCEL_FLAG,CANCEL_DATE,REVERSED_FLAG,REVERSAL_DATE,DELIVERED_FLAG,DELIVERY_DATE,ORDER_STATUS) values (93,1,null,null,null,null,null,null,null,null,null,null,null);
Insert into ORDERS (ORDER_ID,USER_ID,TOTAL,ORDER_DATE,PAID_FLAG,PAID_DATE,CANCEL_FLAG,CANCEL_DATE,REVERSED_FLAG,REVERSAL_DATE,DELIVERED_FLAG,DELIVERY_DATE,ORDER_STATUS) values (98,1,null,null,null,null,null,null,null,null,null,null,null);
Insert into ORDERS (ORDER_ID,USER_ID,TOTAL,ORDER_DATE,PAID_FLAG,PAID_DATE,CANCEL_FLAG,CANCEL_DATE,REVERSED_FLAG,REVERSAL_DATE,DELIVERED_FLAG,DELIVERY_DATE,ORDER_STATUS) values (101,1,null,null,null,null,null,null,null,null,null,null,null);
Insert into ORDERS (ORDER_ID,USER_ID,TOTAL,ORDER_DATE,PAID_FLAG,PAID_DATE,CANCEL_FLAG,CANCEL_DATE,REVERSED_FLAG,REVERSAL_DATE,DELIVERED_FLAG,DELIVERY_DATE,ORDER_STATUS) values (103,2,null,null,null,null,null,null,null,null,null,null,null);
Insert into ORDERS (ORDER_ID,USER_ID,TOTAL,ORDER_DATE,PAID_FLAG,PAID_DATE,CANCEL_FLAG,CANCEL_DATE,REVERSED_FLAG,REVERSAL_DATE,DELIVERED_FLAG,DELIVERY_DATE,ORDER_STATUS) values (78,1,null,null,null,null,null,null,null,null,null,null,null);
Insert into ORDERS (ORDER_ID,USER_ID,TOTAL,ORDER_DATE,PAID_FLAG,PAID_DATE,CANCEL_FLAG,CANCEL_DATE,REVERSED_FLAG,REVERSAL_DATE,DELIVERED_FLAG,DELIVERY_DATE,ORDER_STATUS) values (121,2,null,null,null,null,null,null,null,null,null,null,null);
Insert into ORDERS (ORDER_ID,USER_ID,TOTAL,ORDER_DATE,PAID_FLAG,PAID_DATE,CANCEL_FLAG,CANCEL_DATE,REVERSED_FLAG,REVERSAL_DATE,DELIVERED_FLAG,DELIVERY_DATE,ORDER_STATUS) values (141,2,null,null,null,null,null,null,null,null,null,null,null);
REM INSERTING into ORDERS_DETAILS
SET DEFINE OFF;
Insert into ORDERS_DETAILS (ORDER_DETAILS_ID,ORDER_ID,PRODUCT_ID,QUANTITY,AMOUNT) values (89,88,1,1,43000);
Insert into ORDERS_DETAILS (ORDER_DETAILS_ID,ORDER_ID,PRODUCT_ID,QUANTITY,AMOUNT) values (91,90,2,1,65000);
Insert into ORDERS_DETAILS (ORDER_DETAILS_ID,ORDER_ID,PRODUCT_ID,QUANTITY,AMOUNT) values (143,142,1,1,43000);
Insert into ORDERS_DETAILS (ORDER_DETAILS_ID,ORDER_ID,PRODUCT_ID,QUANTITY,AMOUNT) values (45,44,1,3,120000);
Insert into ORDERS_DETAILS (ORDER_DETAILS_ID,ORDER_ID,PRODUCT_ID,QUANTITY,AMOUNT) values (46,44,2,3,165000);
Insert into ORDERS_DETAILS (ORDER_DETAILS_ID,ORDER_ID,PRODUCT_ID,QUANTITY,AMOUNT) values (92,90,3,6,390000);
Insert into ORDERS_DETAILS (ORDER_DETAILS_ID,ORDER_ID,PRODUCT_ID,QUANTITY,AMOUNT) values (50,49,1,3,129000);
Insert into ORDERS_DETAILS (ORDER_DETAILS_ID,ORDER_ID,PRODUCT_ID,QUANTITY,AMOUNT) values (51,49,2,4,260000);
Insert into ORDERS_DETAILS (ORDER_DETAILS_ID,ORDER_ID,PRODUCT_ID,QUANTITY,AMOUNT) values (52,49,3,5,325000);
Insert into ORDERS_DETAILS (ORDER_DETAILS_ID,ORDER_ID,PRODUCT_ID,QUANTITY,AMOUNT) values (53,49,4,5,225000);
Insert into ORDERS_DETAILS (ORDER_DETAILS_ID,ORDER_ID,PRODUCT_ID,QUANTITY,AMOUNT) values (82,81,2,1,65000);
Insert into ORDERS_DETAILS (ORDER_DETAILS_ID,ORDER_ID,PRODUCT_ID,QUANTITY,AMOUNT) values (83,81,3,1,65000);
Insert into ORDERS_DETAILS (ORDER_DETAILS_ID,ORDER_ID,PRODUCT_ID,QUANTITY,AMOUNT) values (84,81,4,4,180000);
Insert into ORDERS_DETAILS (ORDER_DETAILS_ID,ORDER_ID,PRODUCT_ID,QUANTITY,AMOUNT) values (94,93,1,4,172000);
Insert into ORDERS_DETAILS (ORDER_DETAILS_ID,ORDER_ID,PRODUCT_ID,QUANTITY,AMOUNT) values (95,93,2,4,260000);
Insert into ORDERS_DETAILS (ORDER_DETAILS_ID,ORDER_ID,PRODUCT_ID,QUANTITY,AMOUNT) values (96,93,3,6,390000);
Insert into ORDERS_DETAILS (ORDER_DETAILS_ID,ORDER_ID,PRODUCT_ID,QUANTITY,AMOUNT) values (97,93,4,5,225000);
Insert into ORDERS_DETAILS (ORDER_DETAILS_ID,ORDER_ID,PRODUCT_ID,QUANTITY,AMOUNT) values (79,78,1,1,43000);
Insert into ORDERS_DETAILS (ORDER_DETAILS_ID,ORDER_ID,PRODUCT_ID,QUANTITY,AMOUNT) values (80,78,2,1,65000);
Insert into ORDERS_DETAILS (ORDER_DETAILS_ID,ORDER_ID,PRODUCT_ID,QUANTITY,AMOUNT) values (99,98,2,1,65000);
Insert into ORDERS_DETAILS (ORDER_DETAILS_ID,ORDER_ID,PRODUCT_ID,QUANTITY,AMOUNT) values (102,101,1,1,43000);
Insert into ORDERS_DETAILS (ORDER_DETAILS_ID,ORDER_ID,PRODUCT_ID,QUANTITY,AMOUNT) values (104,103,2,1,65000);
Insert into ORDERS_DETAILS (ORDER_DETAILS_ID,ORDER_ID,PRODUCT_ID,QUANTITY,AMOUNT) values (122,121,2,3,195000);
Insert into ORDERS_DETAILS (ORDER_DETAILS_ID,ORDER_ID,PRODUCT_ID,QUANTITY,AMOUNT) values (144,141,1,1,43000);
REM INSERTING into PERMISSIONS
SET DEFINE OFF;
Insert into PERMISSIONS (PERMISSION_ID,PERMISSION_NAME,PERMISSION_DESCRIPTION,STATUS) values (1,'VIEW_PRODUCT','VIEW_PRODUCT','A');
Insert into PERMISSIONS (PERMISSION_ID,PERMISSION_NAME,PERMISSION_DESCRIPTION,STATUS) values (2,'VIEW_ORDER','VIEW_ORDER','A');
Insert into PERMISSIONS (PERMISSION_ID,PERMISSION_NAME,PERMISSION_DESCRIPTION,STATUS) values (3,'CREATE_ORDER','CREATE_ORDER','A');
Insert into PERMISSIONS (PERMISSION_ID,PERMISSION_NAME,PERMISSION_DESCRIPTION,STATUS) values (4,'VIEW_PROFILE','VIEW_PROFILE','A');
Insert into PERMISSIONS (PERMISSION_ID,PERMISSION_NAME,PERMISSION_DESCRIPTION,STATUS) values (5,'UPDATE_PROFILE','UPDATE_PROFILE','A');
Insert into PERMISSIONS (PERMISSION_ID,PERMISSION_NAME,PERMISSION_DESCRIPTION,STATUS) values (6,'DELETE_ORDER','DELETE_ORDER','A');
REM INSERTING into PRODUCTS
SET DEFINE OFF;
Insert into PRODUCTS (PRODUCT_ID,PRODUCT_NAME,DESCRIPTION,PRICE,CREATE_DATE,CREATE_USER,UPDATE_DATE,UPDATE_USER,MANUFACTURER,LAUNCH_DATE,PRODUCT_CODE) values (1,'One','Smart Phone',43000,to_date('17-OCT-17','DD-MON-RR'),'user1',to_date('17-OCT-17','DD-MON-RR'),'user1','HTC',to_date('01-OCT-16','DD-MON-RR'),'HTC201610');
Insert into PRODUCTS (PRODUCT_ID,PRODUCT_NAME,DESCRIPTION,PRICE,CREATE_DATE,CREATE_USER,UPDATE_DATE,UPDATE_USER,MANUFACTURER,LAUNCH_DATE,PRODUCT_CODE) values (2,'Galaxy S8','Smart Phone',65000,to_date('17-OCT-17','DD-MON-RR'),'ADMIN',to_date('17-OCT-17','DD-MON-RR'),'ADMIN','Samsung',to_date('01-MAR-17','DD-MON-RR'),'SAM201703');
Insert into PRODUCTS (PRODUCT_ID,PRODUCT_NAME,DESCRIPTION,PRICE,CREATE_DATE,CREATE_USER,UPDATE_DATE,UPDATE_USER,MANUFACTURER,LAUNCH_DATE,PRODUCT_CODE) values (3,'iPhone','Smart Phone',65000,to_date('17-OCT-17','DD-MON-RR'),'ADMIN',to_date('17-OCT-17','DD-MON-RR'),'ADMIN','Apple',to_date('01-SEP-17','DD-MON-RR'),'APP201709');
Insert into PRODUCTS (PRODUCT_ID,PRODUCT_NAME,DESCRIPTION,PRICE,CREATE_DATE,CREATE_USER,UPDATE_DATE,UPDATE_USER,MANUFACTURER,LAUNCH_DATE,PRODUCT_CODE) values (4,'Nexus 9','Smart Phone',45000,to_date('17-OCT-17','DD-MON-RR'),'ADMIN',to_date('17-OCT-17','DD-MON-RR'),'ADMIN','Google',to_date('01-JUL-17','DD-MON-RR'),'GGL201707');
REM INSERTING into ROLES
SET DEFINE OFF;
Insert into ROLES (ROLE_ID,ROLE_NAME,ROLE_DESCRIPTION,STATUS) values (2,'ROLE_USER','Full Access to own data','A');
Insert into ROLES (ROLE_ID,ROLE_NAME,ROLE_DESCRIPTION,STATUS) values (1,'ROLE_ADMIN','Full Access','A');
Insert into ROLES (ROLE_ID,ROLE_NAME,ROLE_DESCRIPTION,STATUS) values (3,'ROLE_VIEW','View Access','A');
REM INSERTING into ROLE_PERMISSION
SET DEFINE OFF;
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (3,1);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (3,2);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (3,4);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (2,1);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (2,2);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (2,4);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (1,1);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (1,3);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (1,4);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (1,5);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (1,2);
REM INSERTING into USERS
SET DEFINE OFF;
Insert into USERS (USER_ID,LOGIN_ID,PASSWORD,FIRST_NAME,MIDDLE_NAME,LAST_NAME,DOB,CREATE_DATE,CREATE_USER,UPDATE_DATE,UPDATE_USER,ROLE_ID) values (1,'AARON','asd','Aaron',null,'John',to_date('17-OCT-17','DD-MON-RR'),to_date('17-OCT-17','DD-MON-RR'),null,null,null,2);
Insert into USERS (USER_ID,LOGIN_ID,PASSWORD,FIRST_NAME,MIDDLE_NAME,LAST_NAME,DOB,CREATE_DATE,CREATE_USER,UPDATE_DATE,UPDATE_USER,ROLE_ID) values (2,'JOHN','Abcdef456','John','X','Mathews',to_date('17-OCT-17','DD-MON-RR'),to_date('17-OCT-17','DD-MON-RR'),null,null,null,1);
REM INSERTING into USER_ROLE
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index PK_CONTACT_DETAILS
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_CONTACT_DETAILS" ON "CONTACT_DETAILS" ("CONTACT_ID") 
  ;
--------------------------------------------------------
--  DDL for Index PK_ORDERS
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_ORDERS" ON "ORDERS" ("ORDER_ID") 
  ;
--------------------------------------------------------
--  DDL for Index PK_ORDERS_DETAILS
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_ORDERS_DETAILS" ON "ORDERS_DETAILS" ("ORDER_DETAILS_ID") 
  ;
--------------------------------------------------------
--  DDL for Index PK_PERMISIONS
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_PERMISIONS" ON "PERMISSIONS" ("PERMISSION_ID") 
  ;
--------------------------------------------------------
--  DDL for Index PK_PRODUCTS
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_PRODUCTS" ON "PRODUCTS" ("PRODUCT_ID") 
  ;
--------------------------------------------------------
--  DDL for Index PK_ROLES
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_ROLES" ON "ROLES" ("ROLE_ID") 
  ;
--------------------------------------------------------
--  DDL for Index PK_ROLE_PERMISSION
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_ROLE_PERMISSION" ON "ROLE_PERMISSION" ("ROLE_ID", "PERMISSION_ID") 
  ;
--------------------------------------------------------
--  DDL for Index PK_USERS
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_USERS" ON "USERS" ("USER_ID") 
  ;
--------------------------------------------------------
--  DDL for Index PK_USER_ROLE
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_USER_ROLE" ON "USER_ROLE" ("USER_ID", "ROLE_ID") 
  ;
--------------------------------------------------------
--  Constraints for Table CONTACT_DETAILS
--------------------------------------------------------

  ALTER TABLE "CONTACT_DETAILS" ADD CONSTRAINT "PK_CONTACT_DETAILS" PRIMARY KEY ("CONTACT_ID") ENABLE;
--------------------------------------------------------
--  Constraints for Table ORDERS
--------------------------------------------------------

  ALTER TABLE "ORDERS" ADD CONSTRAINT "PK_ORDERS" PRIMARY KEY ("ORDER_ID") ENABLE;
--------------------------------------------------------
--  Constraints for Table ORDERS_DETAILS
--------------------------------------------------------

  ALTER TABLE "ORDERS_DETAILS" ADD CONSTRAINT "PK_ORDERS_DETAILS" PRIMARY KEY ("ORDER_DETAILS_ID") ENABLE;
--------------------------------------------------------
--  Constraints for Table PERMISSIONS
--------------------------------------------------------

  ALTER TABLE "PERMISSIONS" ADD CONSTRAINT "PK_PERMISIONS" PRIMARY KEY ("PERMISSION_ID") ENABLE;
--------------------------------------------------------
--  Constraints for Table PRODUCTS
--------------------------------------------------------

  ALTER TABLE "PRODUCTS" ADD CONSTRAINT "PK_PRODUCTS" PRIMARY KEY ("PRODUCT_ID") ENABLE;
--------------------------------------------------------
--  Constraints for Table ROLES
--------------------------------------------------------

  ALTER TABLE "ROLES" ADD CONSTRAINT "PK_ROLES" PRIMARY KEY ("ROLE_ID") ENABLE;
--------------------------------------------------------
--  Constraints for Table ROLE_PERMISSION
--------------------------------------------------------

  ALTER TABLE "ROLE_PERMISSION" ADD CONSTRAINT "PK_ROLE_PERMISSION" PRIMARY KEY ("ROLE_ID", "PERMISSION_ID") ENABLE;
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "USERS" ADD CONSTRAINT "PK_USERS" PRIMARY KEY ("USER_ID") ENABLE;
--------------------------------------------------------
--  Constraints for Table USER_ROLE
--------------------------------------------------------

  ALTER TABLE "USER_ROLE" ADD CONSTRAINT "PK_USER_ROLE" PRIMARY KEY ("USER_ID", "ROLE_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CONTACT_DETAILS
--------------------------------------------------------

  ALTER TABLE "CONTACT_DETAILS" ADD CONSTRAINT "FK_CONTACT_DETAILS" FOREIGN KEY ("USER_ID")
	  REFERENCES "USERS" ("USER_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ORDERS
--------------------------------------------------------

  ALTER TABLE "ORDERS" ADD CONSTRAINT "FK_ORDERS1" FOREIGN KEY ("USER_ID")
	  REFERENCES "USERS" ("USER_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ORDERS_DETAILS
--------------------------------------------------------

  ALTER TABLE "ORDERS_DETAILS" ADD CONSTRAINT "FK_ORDER_DETAILS1" FOREIGN KEY ("ORDER_ID")
	  REFERENCES "ORDERS" ("ORDER_ID") ENABLE;
  ALTER TABLE "ORDERS_DETAILS" ADD CONSTRAINT "FK_ORDER_DETAILS2" FOREIGN KEY ("PRODUCT_ID")
	  REFERENCES "PRODUCTS" ("PRODUCT_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ROLE_PERMISSION
--------------------------------------------------------

  ALTER TABLE "ROLE_PERMISSION" ADD CONSTRAINT "FK_ROLE_PERMISSION1" FOREIGN KEY ("ROLE_ID")
	  REFERENCES "ROLES" ("ROLE_ID") ENABLE;
  ALTER TABLE "ROLE_PERMISSION" ADD CONSTRAINT "FK_ROLE_PERMISSION2" FOREIGN KEY ("PERMISSION_ID")
	  REFERENCES "PERMISSIONS" ("PERMISSION_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "USERS" ADD CONSTRAINT "FK_USERS1" FOREIGN KEY ("ROLE_ID")
	  REFERENCES "ROLES" ("ROLE_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USER_ROLE
--------------------------------------------------------

  ALTER TABLE "USER_ROLE" ADD CONSTRAINT "FK_USER_ROLE1" FOREIGN KEY ("USER_ID")
	  REFERENCES "USERS" ("USER_ID") ENABLE;
  ALTER TABLE "USER_ROLE" ADD CONSTRAINT "FK_USER_ROLE2" FOREIGN KEY ("ROLE_ID")
	  REFERENCES "ROLES" ("ROLE_ID") ENABLE;

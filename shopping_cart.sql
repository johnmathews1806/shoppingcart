--------------------------------------------------------
--  File created - Thursday-November-02-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence HIBERNATE_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "HIBERNATE_SEQUENCE"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 101 CACHE 20 NOORDER  NOCYCLE ;
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
	"UPDATE_USER" VARCHAR2(20)
   ) ;
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
--  DDL for Index PK_PRODUCTS
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_PRODUCTS" ON "PRODUCTS" ("PRODUCT_ID") 
  ;
--------------------------------------------------------
--  DDL for Index PK_USERS
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_USERS" ON "USERS" ("USER_ID") 
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
--  Constraints for Table PRODUCTS
--------------------------------------------------------

  ALTER TABLE "PRODUCTS" ADD CONSTRAINT "PK_PRODUCTS" PRIMARY KEY ("PRODUCT_ID") ENABLE;
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "USERS" ADD CONSTRAINT "PK_USERS" PRIMARY KEY ("USER_ID") ENABLE;
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

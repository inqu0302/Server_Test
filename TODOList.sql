CREATE TABLE "tbl_todo" (
	"td_seq"	number		NULL,
	"td_todo"	nVARCHAR2(100)		NULL,
	"td_date"	CHAR(10)		NULL,
	"td_time"	CHAR(8)		NULL,
	"td_place"	nVARCHAR2(50)		NULL
);

ALTER TABLE "tbl_todo" ADD CONSTRAINT "PK_TBL_TODO" PRIMARY KEY (
	"td_seq"
);


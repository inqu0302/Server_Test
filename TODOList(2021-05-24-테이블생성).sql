-- todo 접속
DROP TABLE tbl_todo;

CREATE TABLE tbl_todo (
	td_seq	NUMBER	PRIMARY KEY,
	td_todo	nVARCHAR2(100) NOT NULL,
	td_date	VARCHAR(10) NOT NULL,
	td_time	VARCHAR(10) NOT NULL,
	td_place nVARCHAR2(50)
);

CREATE SEQUENCE seq_todo
START WITH 1 
INCREMENT BY 1;

INSERT INTO tbl_todo
VALUES( seq_todo.NEXTVAL, '테스트', '2021-05-25', '10:30:00', '');

DROP VIEW view_해야할일;

CREATE VIEW view_해야할일 AS 
(
    SELECT
        td_seq 일련번호,
        td_todo 해야할일,
        td_date 작성일자,
        td_time 작성시간,
        td_place 장소
    
    FROM tbl_todo
    )ORDER BY td_date DESC;

SELECT * FROM view_해야할일;

SELECT * FROM tbl_todo
ORDER BY td_date DESC, td_time DESC;


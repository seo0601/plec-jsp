-- 사용자(회원) 정보를 저장할 테이블
CREATE TABLE users(
    id VARCHAR2(100) PRIMARY KEY,
    pwd VARCHAR2(100) NOT NULL,
    email VARCHAR2(100),
    profile VARCHAR2(100), --프로필 이미지 경로를 저장할 칼럼
    regdate DATE
    phone VARCHAR2(32),
    birth DATE
);

-- QNA_BOARD_QUESTION
CREATE TABLE QNA_BOARD_QUESTION(
    num NUMBER PRIMARY KEY, --글번호
    writer VARCHAR2(50) NOT NULL, --작성자 (로그인된 아이디)
    title VARCHAR2(50) NOT NULL, --제목
    content CLOB, --글 내용
    viewCount NUMBER, -- 조회수
    regdate DATE --글 작성일
);
-- QNA_BOARD_QUESTION 시퀀스
CREATE SEQUENCE QNA_BOARD_QUESTION_seq; 

-- QNA_BOARD_ANSWER
CREATE TABLE QNA_BOARD_ANSWER(
    num NUMBER PRIMARY KEY, --댓글의 글번호
    writer VARCHAR2(50), --댓글 작성자의 아이디
    content CLOB, -- 글 내용
    ref_group NUMBER, -- 질문의 번호
    regdate DATE -- 글 작성일
);
-- QNA_BOARD_ANSWER 시퀀스
CREATE SEQUENCE QNA_BOARD_ANSWER_seq;

-- QNA_USERS_QUESTION
CREATE TABLE QNA_USERS_QUESTION(
    num NUMBER PRIMARY KEY, --글번호
    writer VARCHAR2(50) NOT NULL, --작성자 (로그인된 아이디)
    title VARCHAR2(50) NOT NULL, --제목
    content CLOB, --글 내용
    viewCount NUMBER, -- 조회수
    regdate DATE --글 작성일
);
-- QNA_USERS_QUESTION 시퀀스
CREATE SEQUENCE QNA_USERS_QUESTION_seq; 

-- QNA_USERS_ANSWER
CREATE TABLE QNA_USERS_ANSWER(
    num NUMBER PRIMARY KEY, --댓글의 글번호
    writer VARCHAR2(50), --댓글 작성자의 아이디
    content CLOB, --댓글 내용
    target_id VARCHAR2(100), --댓글의 대상자 아이디
    ref_group NUMBER, -- 게시글 번호
    comment_group NUMBER, -- 답변그룹 번호
    deleted CHAR(3) DEFAULT 'no', -- 삭제여부
    regdate DATE -- 글 작성일
);
-- QNA_USERS_ANSWER 시퀀스
CREATE SEQUENCE QNA_USERS_ANSWER_seq;

-- QNA_FREE_QUESTION
CREATE TABLE QNA_FREE_QUESTION(
    num NUMBER PRIMARY KEY, --글번호
    writer VARCHAR2(50) NOT NULL, --작성자 (로그인된 아이디)
    title VARCHAR2(50) NOT NULL, --제목
    content CLOB, --글 내용
    viewCount NUMBER, -- 조회수
    regdate DATE, --글 작성일
    category Number -- 카테고리(스터디 구분)
);
-- QNA_FREE_QUESTION 시퀀스
CREATE SEQUENCE QNA_FREE_QUESTION_seq; 

-- QNA_FREE_ANSWER
CREATE TABLE QNA_FREE_ANSWER(
    num NUMBER PRIMARY KEY, --댓글의 글번호
    writer VARCHAR2(50), --댓글 작성자의 아이디
    content CLOB, --댓글 내용
    target_id VARCHAR2(100), --댓글의 대상자 아이디
    ref_group NUMBER, -- 게시글 번호
    comment_group NUMBER, -- 답변그룹번호
    deleted CHAR(3) DEFAULT 'no', -- 삭제여부
    regdate DATE -- 글 작성일
);
-- QNA_FREE_ANSWER 시퀀스
CREATE SEQUENCE QNA_FREE_ANSWER_seq;

-- NOTICE(공지사항)
CREATE TABLE NOTICE(
    num NUMBER PRIMARY KEY, --글번호
    title VARCHAR2(50) NOT NULL, --제목
    content CLOB, --글 내용
    viewCount NUMBER, -- 조회수
    regdate DATE --글 작성일
);
-- NOTICE 시퀀스
CREATE SEQUENCE NOTICE_seq;

-- FAQ(자주묻는질문)
CREATE TABLE FAQ(
    num NUMBER PRIMARY KEY, --글번호
    title VARCHAR2(50) NOT NULL, -- 제목
    question CLOB,
    content CLOB, --글 내용
    regdate DATE --글 작성일
);
-- FAQ 시퀀스
CREATE SEQUENCE FAQ_seq;

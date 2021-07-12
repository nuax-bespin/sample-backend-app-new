-- 사용자
CREATE TABLE `TB_NEWS` (
    `NEWS_NO`       INT(10)     NOT NULL    AUTO_INCREMENT, -- 번호
    `TITLE`         VARCHAR(100) NOT NULL, -- 제목
    `CONTENT`       VARCHAR(100) NOT NULL, -- 내용
    `USE_AT`        CHAR(1)      NOT NULL, -- 사용_여부
    `REGIST_USER`   CHAR(50)     NOT NULL, -- 등록자
    `REGIST_DT`     DATETIME    NOT NULL, -- 등록_일시
    `UPDT_DT`       DATETIME    NULL      -- 수정_일시
);

-- 사용자
ALTER TABLE `TB_NEWS`
    ADD CONSTRAINT `PK_TB_NEWS` -- 기본키
        PRIMARY KEY (
            `NEWS_NO` -- 번호
        );

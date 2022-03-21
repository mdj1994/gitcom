package com.union.construction_web.domain;

import lombok.Data;

@Data
public class Announcement {

    /* 공지사항 */
    private long announcement;          //공지사항 번호
    private String title;               //공지사항 제목
    private String contents;            //내용
    private String reg_date;            //등록일자
    private long reg_member_no;         //등록자
    private String state;               //상태값 (진행 중 : 0, 완료 : 1)
    private long comm_cnt;              //추천수
    private String update_date;         //수정일
    private String file_path;           //첨부파일 경로
}

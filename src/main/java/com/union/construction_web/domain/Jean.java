package com.union.construction_web.domain;

import lombok.Data;

@Data
public class Jean {

    /* 공개 제안 */
    private long jean_no;       //공개 제안 번호
    private String title;       //제목
    private String contents;    //내용
    private String reg_date;    //등록 일자
    private long reg_member_no; //등록된 회원 번호
    private String state;       //상태 값 (1 : 정상, 0 : 비정상)
    private long recom_cnt;     //의견 갯수
    private long comm_cnt;      //댓글 갯수
    private String file_path;   //파일 경로
}

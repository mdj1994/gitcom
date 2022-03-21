package com.union.construction_web.domain;

import lombok.Data;

@Data
public class Sinmungo {

    /* 신문고 게시판 */
    private long sinmungo_no;           //신문고 번호
    private String title;               //신문고 제목
    private String contents;            //신문고 내용
    private long branch_no;             //신문고 지점번호
    private String reg_date;            //신문고 등록일
    private long reg_member_no;         //신문고 등록자 번호
    private String transfer_state;      //부서 이관 여부
    private String state;               //게시글 상태값
    private String proc_dept_no;        //담당 부서
    private String publish_state;       //공개 여부
    private String transfer_date;       //이관일시
    private String file_path;           //파일 경로
    private long proc_member_no;        //신문고 담당자 번호?
    private String proc_state;          //게시글 처리상태 ( 0 : 대기, 1: 완료 )
    private String proc_mesg;           //처리 메세지
    private String proc_date;           //처리 날짜
}

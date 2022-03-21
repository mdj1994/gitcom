package com.union.construction_web.domain;

import lombok.Data;

@Data
public class Opinion {
    
    /* 게시판 옵션? */
    private long opinion_no;            //의견번호
    private String title;               //의견게시판 제목
    private String contents;            //의견게시판 내용
    private String reg_date;            //등록일
    private long reg_member_no;         //등록회원번호
    private String state;               //의견게시판 현재 진행상태
    private long in_cnt;                //의견 참여자 수
    private String poll_from_date;      //투표 시작일
    private String poll_to_date;        //투표 완료일
    private long comm_cnt;              //추천수
    private String update_date;         //수정일
    private int sel_item_cnt;          //투표 항목수
    private String item_text;           //문한 내용
    private long branch_no;             //대상 지부
    private String file_path;           //첨부파일경로
    
}

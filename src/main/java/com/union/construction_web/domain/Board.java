package com.union.construction_web.domain;

import lombok.Data;

@Data
public class Board extends Member {

    /* 게시판 공통값 */
    private long board_no;
    private String title;               //신문고 제목
    private String contents;            //신문고 내용
    private long sinmungo_branch_no;    //신문고 지점번호
    private String reg_date;            //신문고 등록일
    private long reg_member_no;         //신문고 등록자 번호
    private String state;               //게시판 현재 진행상태
}

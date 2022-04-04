package com.union.construction_web.domain;

import lombok.Data;

@Data
public class PushHist {

    /* Push 정보 */
    private long push_hist_no;      //푸쉬 메세지 발송 이력
    private String contents;        //내용
    private long send_member_no;    //발송자
    private String state;           //상태값 (1: 성공, 0 : 실패)
    private long send_cnt;          //발송 대상자 수
    private String rcv_group;       //발송 대상의 그룹 (0 : 회원 전체, 1 : 담당자 전체, 2 지부별 회원)
    private long branch_no;         //2 지부별 회월 경우에만
    private String send_date;       //발송 일시
}

package com.union.construction_web.domain;

import lombok.Data;

@Data
public class Poll_result {

    /* 투표 참여시, 참여자 목록 */
    private long poll_result_no;        //투표 견과 번호
    private long poll_item_no;          //선택된 의견번호
    private String etc_opinion;         //기타의견
    private long member_no;             //투표자 회원번호
    private long opinion_no;            //의견 번호
}

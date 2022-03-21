package com.union.construction_web.domain;

import lombok.Data;

@Data
public class Poll_item {

    /* 의견게시판, 투표 항목*/
    private long poll_item_no;          //투표 항목 번호
    private long opinion_no;            //의견 번호
    private String poll_item_title;     //투표 항목명
}


package com.union.construction_web.domain;

import lombok.Data;

@Data
public class Comment extends Member{

    /* 댓글관리 */
    
    private long comment_no;    //댓글번호
    private long reg_member_no; //회원번호
    private long jean_no;       //제안번호
    private String contents;    //내용
    private String reg_data;    //등록일
}

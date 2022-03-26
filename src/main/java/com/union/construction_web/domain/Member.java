package com.union.construction_web.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Member {

    //회원정보 관리

    private long member_no;        //회원번호
    private String member_nm;      //회원 명
    private String mobile_no;      //회원 핸드폰 번호
    private String member_id;      //로그안 아이디
    private String member_state;   //회원 상태값 (0 정지, 1 사용)
    private int member_branch_no;         //지부번호
    private String last_conn_date; //최종접속일자
    private String passwd;         //비밀번호
    private String gubun;          //회원 등급. (A: 총괄 관리자, M: 담당자, U: 일반사용자)
    private String os_type;        //사용자 구분. (A : 안드로이드, I : 아이폰, etc : 기타)
}

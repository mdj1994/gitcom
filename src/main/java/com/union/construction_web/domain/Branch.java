package com.union.construction_web.domain;

import lombok.Data;

@Data
public class Branch {

    /* 지부 관리 */

    private long branch_no;         //지부 번호
    private String branch_nm;       //지부 이름
    private String remark;          //비고
}

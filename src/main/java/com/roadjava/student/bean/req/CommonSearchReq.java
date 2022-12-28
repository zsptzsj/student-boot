package com.roadjava.student.bean.req;

import com.roadjava.student.bean.constants.Constants;
import lombok.Data;

@Data
public class CommonSearchReq {
    private Integer pageNow = Constants.DEFAULT_PAGE_NOW;
    private Integer pageSize = Constants.DEFAULT_PAGE_SIZE;

    private String searchWord;
}

package com.green.greengramver1.feed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.greengramver1.common.GlobalConst;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FeedGetReq {
    private int page;
    @JsonIgnore
    private int startIdx;
    @JsonIgnore
    private int len;

    public void setPage(int page) {
        this.page = (page <= 0) ?  1 :  page;
        this.len = GlobalConst.FEED_PAGE_ITEM_LEN;
        this.startIdx = (this.page - 1) * this.len;
    }
}

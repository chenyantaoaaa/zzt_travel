package com.cyt.music.interfaces.pojo.Pv;

import com.cyt.music.interfaces.pojo.common.PageInfo;

public class PvInfoDto extends PvInfo{
    private PageInfo pageInfo;

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
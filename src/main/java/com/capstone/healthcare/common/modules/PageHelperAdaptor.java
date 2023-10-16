package com.capstone.healthcare.common.modules;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.util.ObjectUtils;

import java.util.List;

public class PageHelperAdaptor {

    /***
     * 分页信息设置
     * @param pageInfo 分页信息
     * @return
     */
    public static Page preparePage(PageInfo pageInfo) {

        return preparePage(pageInfo, pageInfo.getIsCount());
    }

    /***
     * 分页信息设置
     * @param pageInfo 分页信息
     * @param count   null/false 不需要分页; true 需要分页
     * @return
     */
    public static Page preparePage(PageInfo pageInfo, Boolean count) {

        boolean isNeedCount = false;
        if (count != null) {
            isNeedCount = count;
        }

        if (!ObjectUtils.isEmpty(pageInfo.getOrderBy())) {
            Page page = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getOrderBy());
            page.setCount(isNeedCount);
            return page;
        } else {
            return PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize(), isNeedCount);
        }
    }

    public static void setPageResult(Page page, PageListResult pageListResult) {

        pageListResult.setTotal(Long.valueOf(page.getTotal()).intValue());
    }

    /**
     * 构建返回参数
     *
     * @param page
     * @param list
     * @param <T>
     * @return
     */
    public static <T> PageListResult<T> buildPageResult(Page page, List<T> list) {

        PageListResult<T> pageListResult = new PageListResult<>();

        pageListResult.setTotal(Long.valueOf(page.getTotal()).intValue());
        pageListResult.setPageNum(page.getPageNum());
        pageListResult.setPageSize(page.getPageSize());
        pageListResult.setList(list);
        return pageListResult;
    }
}

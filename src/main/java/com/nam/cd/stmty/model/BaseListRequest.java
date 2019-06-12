package com.nam.cd.stmty.model;

import com.nam.cd.stmty.common.CommonFunction;
import com.nam.cd.stmty.util.StringUtil;
import org.springframework.core.style.ToStringCreator;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class BaseListRequest {
    
    protected String sortField;
    protected String sortType;
    protected Integer pageNumber;
    protected Integer limitNumber;

    public String getSortField(String nameColumnId) {
        return StringUtil.isEmpty(sortField) ? nameColumnId : sortField;
    }

    public Sort.Direction getSortType() {
        return CommonFunction.getSortType(sortType);
    }

    public Integer getPageNumber() {
        return CommonFunction.getPageNumber(pageNumber);
    }

    public Integer getLimitNumber() {
        return CommonFunction.getLimitNumber(limitNumber);
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setLimitNumber(Integer limitNumber) {
        this.limitNumber = limitNumber;
    }

    public PageRequest createPageRequest(String defaultSortFieldName) {
        // modify the page info
        Sort.Direction direction = CommonFunction.getSortType(sortType);
        String returnSortField = StringUtil.isEmpty(this.sortField) ? defaultSortFieldName : this.sortField;
        Integer returnPageNumber = CommonFunction.getPageNumber(pageNumber);
        Integer returnLimitNumber = CommonFunction.getLimitNumber(limitNumber);
        return new PageRequest(returnPageNumber, returnLimitNumber, direction, returnSortField);
    }
    
    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("sortField", sortField)
                .append("sortType", sortType)
                .append("pageNumber", pageNumber)
                .append("limitNumber", limitNumber)
                .toString();
    }
}

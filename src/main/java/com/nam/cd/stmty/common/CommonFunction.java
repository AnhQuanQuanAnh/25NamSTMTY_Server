package com.nam.cd.stmty.common;

import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class CommonFunction {

    public static Sort.Direction getSortType(String sortType) {
        if (sortType == null || sortType.trim().toLowerCase().equals(CommonValue.SORT_TYPE_DESC)) {
            return Sort.Direction.DESC;
        }
        return Sort.Direction.ASC;
    }

    public static Integer getPageNumber(Integer pageNumber) {
        if (pageNumber == null) {
            pageNumber = CommonValue.START_PAGE_NUMBER;
        }
        return pageNumber;
    }

    public static Integer getLimitNumber(Integer limitNumber) {
        if (limitNumber == null || limitNumber == 0) {
            limitNumber = CommonValue.NUMBER_ITEMS_PER_PAGE;
        }
        return limitNumber;
    }

    public static boolean checkPattern(String inputString, String pattern) {
        Pattern validEmailPattern = Pattern.compile(pattern);
        return validEmailPattern.matcher(inputString).matches();
    }

    public static boolean checkLength(String inputString, Integer minNumber, Integer maxNumber) {
        if (inputString != null && !inputString.isEmpty()) {
            if (inputString.length() > maxNumber || inputString.length() < minNumber) {
                return false;
            }
        }
        return true;
    }

    public static Object[] appendValue(Object[] obj, Object o) {
        ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList(obj));
        temp.add(o);
        return temp.toArray();
    }

}

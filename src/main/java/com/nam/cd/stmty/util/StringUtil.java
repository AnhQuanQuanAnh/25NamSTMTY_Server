package com.nam.cd.stmty.util;

import org.springframework.util.StringUtils;

public class StringUtil extends StringUtils {

    /**
     * isEmpty.
     *
     * @param s
     *            a {@link String} object.
     * @return a boolean.
     */
    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }
}

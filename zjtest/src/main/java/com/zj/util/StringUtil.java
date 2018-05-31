package com.zj.util;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.util.StringUtils;

/**
 * Created by zhaojian on 2017/11/8.
 */
public class StringUtil extends StringUtils{

    /**
     *
     * @param str
     * @return
     */
    public static Boolean isNotEmpty(Object str){
        return !isEmpty(str);
    }
}

package com.xiao.programmer.entity;

import java.io.UnsupportedEncodingException;

/**
 * @author Henery
 * @date 2019/12/24 - 11:08
 */
public class EncodingTool {
    public static String encodeStr(String str) {
        try {
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}

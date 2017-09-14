package com.company.other;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public boolean isTel(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        //^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$
        //^1[3|4|5|8][0-9]\d{8}\s?$ ←\s?表示句末可以允许一个空格(暂时不用)
        //^1[3|4|5|8][0-9]\d{8}$
        p = Pattern.compile(
                "^1[3|4|5|8][0-9]\\d{8}$"); // 验证手机号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    public boolean isCar(String str) {
        /*
        1.常规车牌号：仅允许以汉字开头，后面可录入六个字符，由大写英文字母和阿拉伯数字组成。如：粤B12345；
        2.最后一个为汉字的车牌：允许以汉字开头，后面可录入六个字符，前五位字符，由大写英文字母和阿拉伯数字组成，而最后一个字符为汉字，汉字包括“挂”、“学”、“警”、“港”、“澳”。如：粤Z1234港。
        3.新军车牌：以两位为大写英文字母开头，后面以5位阿拉伯数字组成。如：BA12345。
         */
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile(
                "^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$"); // 验证车牌号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    public boolean isIdNo(String str) {
        /*
        身份证
        ^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$
        ^(\d{6})(18|19|20)?(\d{2})([01]\d)([0123]\d)(\d{3})(\d|X|x)?$
         */
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile(
                "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$"); // 验证身份证
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    public boolean isAllNum(String str){
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile(
                "^[0-9]+(.[0-9]{2})?$"); // 金额校验
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    public boolean isAge(String str){
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile(
                "^1?[0-9]{1}[0-9]{1}$"); // 年龄校验
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    public boolean isPhone(String str){
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile(
                "^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$"); // 验证固话
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    public boolean isCustomerNo(String str){
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile(
                "^C\\d{5}$"); // 验证客户号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }
}

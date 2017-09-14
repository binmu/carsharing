package com.company.other;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public boolean isTel(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        //^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$
        //^1[3|4|5|8][0-9]\d{8}\s?$ ��\s?��ʾ��ĩ��������һ���ո�(��ʱ����)
        //^1[3|4|5|8][0-9]\d{8}$
        p = Pattern.compile(
                "^1[3|4|5|8][0-9]\\d{8}$"); // ��֤�ֻ���
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    public boolean isCar(String str) {
        /*
        1.���泵�ƺţ��������Ժ��ֿ�ͷ�������¼�������ַ����ɴ�дӢ����ĸ�Ͱ�����������ɡ��磺��B12345��
        2.���һ��Ϊ���ֵĳ��ƣ������Ժ��ֿ�ͷ�������¼�������ַ���ǰ��λ�ַ����ɴ�дӢ����ĸ�Ͱ�����������ɣ������һ���ַ�Ϊ���֣����ְ������ҡ�����ѧ���������������ۡ������ġ����磺��Z1234�ۡ�
        3.�¾����ƣ�����λΪ��дӢ����ĸ��ͷ��������5λ������������ɡ��磺BA12345��
         */
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile(
                "^[�����弽ԥ���ɺ�����³������Ӷ���ʽ����¼���������ش�����ʹ��A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9��ѧ���۰�]{1}$"); // ��֤���ƺ�
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    public boolean isIdNo(String str) {
        /*
        ���֤
        ^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$
        ^(\d{6})(18|19|20)?(\d{2})([01]\d)([0123]\d)(\d{3})(\d|X|x)?$
         */
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile(
                "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$"); // ��֤���֤
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    public boolean isAllNum(String str){
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile(
                "^[0-9]+(.[0-9]{2})?$"); // ���У��
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    public boolean isAge(String str){
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile(
                "^1?[0-9]{1}[0-9]{1}$"); // ����У��
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    public boolean isPhone(String str){
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile(
                "^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$"); // ��֤�̻�
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    public boolean isCustomerNo(String str){
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile(
                "^C\\d{5}$"); // ��֤�ͻ���
        m = p.matcher(str);
        b = m.matches();
        return b;
    }
}

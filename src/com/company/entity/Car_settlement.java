package com.company.entity;

import java.sql.Timestamp;

public class Car_settlement {
    private String Customer_Name;//����
    private String Car_Id;       //���ƺ�
    private Integer Pre_Zujin;   //Ԥ�����
    private Integer OutTime_Fee1; //��ʱ�շ�
    private Integer Yanjin;      //Ѻ��
    private Integer Xianshi_licheng;//��ʱ���
    private Integer Zulin_Price; //���޼۸�
    private Integer Chaoshi_Fee1; //��ʻ�շ�
    private Timestamp Fache_Date;//��������
    private String Driver;       //��ʻԱ
    private Integer Start_Licheng;//�������
    private String Inner_id;     //�ڲ����
    private Timestamp Shouche_Date;//�ճ�����
    private Timestamp Shouche_Time;//�ճ�ʱ��
    private Integer Zulin_Qixian; //��������
    private Integer Yingshou_Zujin;//Ӧ�����
    private Integer End_Licheng;  //�ճ����
    private Integer Chaoshi_Licheng;//��ʻ���
    private Integer Chaoshi_Fee; //��ʻ�շ�
    private Integer Baogangjia;   //���ɼ�
    private Integer Chaoshi_Hour; //��ʱСʱ
    private Integer OutTime_Fee; //��ʱ�շ�
    private Integer Xiaoji_Fee;   //�շ�С��
    private Integer Gas_Fee;      //���ͷ�
    private Integer Daijia_Fee;   //���ݷ�
    private Integer Chaobaoyang_Fee;//��������
    private Integer Weiyuejin;    //ΥԼ��
    private Integer Repair_Fee;   //�����
    private Integer Baoxian_Fee;    //���շ�
    private Integer Chesun_Fee;   //�����
    private Integer Clean_Fee;    //����
    private Integer Yunche_Fee;   //�˳���
    private Integer Chaizhuang_Fee;//��װ��
    private Integer Yidihuanche_Fee;//��ػ���
    private Integer Other_Fee;    //�����շ�
    private Integer Peilian_Fee;  //������
    private Integer Fujia_Fee;    //���ӷ�
    private Double Yingshou_Jine; //Ӧ�ս��
    private Double Shishou_Jine; //ʵ�ս��
    private Double Yingshou_Zhangkuan;//Ӧ���˿�
    private Double Yingtui_Zhangkuan;//Ӧ���˿�
    private String Jiesuanren;   //������
    private String jiaokuanren;//�ɿ���
    private Timestamp Shoukuan_Date;//�տ�����
    private String Zhipiao_Id;//֧Ʊ��
    private String Demo;    //��ע

    public Integer getOutTime_Fee1() {
        return OutTime_Fee1;
    }

    public void setOutTime_Fee1(Integer outTime_Fee1) {
        OutTime_Fee1 = outTime_Fee1;
    }

    public Integer getChaoshi_Fee1() {
        return Chaoshi_Fee1;
    }

    public void setChaoshi_Fee1(Integer chaoshi_Fee1) {
        Chaoshi_Fee1 = chaoshi_Fee1;
    }

    public Car_settlement() {

    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    public String getCar_Id() {
        return Car_Id;
    }

    public void setCar_Id(String car_Id) {
        Car_Id = car_Id;
    }

    public Integer getPre_Zujin() {
        return Pre_Zujin;
    }

    public void setPre_Zujin(Integer pre_Zujin) {
        Pre_Zujin = pre_Zujin;
    }

    public Integer getOutTime_Fee() {
        return OutTime_Fee;
    }

    public void setOutTime_Fee(Integer outTime_Fee) {
        OutTime_Fee = outTime_Fee;
    }

    public Integer getYanjin() {
        return Yanjin;
    }

    public void setYanjin(Integer yanjin) {
        Yanjin = yanjin;
    }

    public Integer getXianshi_licheng() {
        return Xianshi_licheng;
    }

    public void setXianshi_licheng(Integer xianshi_licheng) {
        Xianshi_licheng = xianshi_licheng;
    }

    public Integer getZulin_Price() {
        return Zulin_Price;
    }

    public void setZulin_Price(Integer zulin_Price) {
        Zulin_Price = zulin_Price;
    }

    public Integer getChaoshi_Fee() {
        return Chaoshi_Fee;
    }

    public void setChaoshi_Fee(Integer chaoshi_Fee) {
        Chaoshi_Fee = chaoshi_Fee;
    }

    public Timestamp getFache_Date() {
        return Fache_Date;
    }

    public void setFache_Date(Timestamp fache_Date) {
        Fache_Date = fache_Date;
    }

    public String getDriver() {
        return Driver;
    }

    public void setDriver(String driver) {
        Driver = driver;
    }

    public Integer getStart_Licheng() {
        return Start_Licheng;
    }

    public void setStart_Licheng(Integer start_Licheng) {
        Start_Licheng = start_Licheng;
    }

    public String getInner_id() {
        return Inner_id;
    }

    public void setInner_id(String inner_id) {
        Inner_id = inner_id;
    }

    public Timestamp getShouche_Date() {
        return Shouche_Date;
    }

    public void setShouche_Date(Timestamp shouche_Date) {
        Shouche_Date = shouche_Date;
    }

    public Timestamp getShouche_Time() {
        return Shouche_Time;
    }

    public void setShouche_Time(Timestamp shouche_Time) {
        Shouche_Time = shouche_Time;
    }

    public Integer getZulin_Qixian() {
        return Zulin_Qixian;
    }

    public void setZulin_Qixian(Integer zulin_Qixian) {
        Zulin_Qixian = zulin_Qixian;
    }

    public Integer getYingshou_Zujin() {
        return Yingshou_Zujin;
    }

    public void setYingshou_Zujin(Integer yingshou_Zujin) {
        Yingshou_Zujin = yingshou_Zujin;
    }

    public Integer getEnd_Licheng() {
        return End_Licheng;
    }

    public void setEnd_Licheng(Integer end_Licheng) {
        End_Licheng = end_Licheng;
    }

    public Integer getChaoshi_Licheng() {
        return Chaoshi_Licheng;
    }

    public void setChaoshi_Licheng(Integer chaoshi_Licheng) {
        Chaoshi_Licheng = chaoshi_Licheng;
    }

    public Integer getBaogangjia() {
        return Baogangjia;
    }

    public void setBaogangjia(Integer baogangjia) {
        Baogangjia = baogangjia;
    }

    public Integer getChaoshi_Hour() {
        return Chaoshi_Hour;
    }

    public void setChaoshi_Hour(Integer chaoshi_Hour) {
        Chaoshi_Hour = chaoshi_Hour;
    }

    public Integer getXiaoji_Fee() {
        return Xiaoji_Fee;
    }

    public void setXiaoji_Fee(Integer xiaoji_Fee) {
        Xiaoji_Fee = xiaoji_Fee;
    }

    public Integer getGas_Fee() {
        return Gas_Fee;
    }

    public void setGas_Fee(Integer gas_Fee) {
        Gas_Fee = gas_Fee;
    }

    public Integer getDaijia_Fee() {
        return Daijia_Fee;
    }

    public void setDaijia_Fee(Integer daijia_Fee) {
        Daijia_Fee = daijia_Fee;
    }

    public Integer getChaobaoyang_Fee() {
        return Chaobaoyang_Fee;
    }

    public void setChaobaoyang_Fee(Integer chaobaoyang_Fee) {
        Chaobaoyang_Fee = chaobaoyang_Fee;
    }

    public Integer getWeiyuejin() {
        return Weiyuejin;
    }

    public void setWeiyuejin(Integer weiyuejin) {
        Weiyuejin = weiyuejin;
    }

    public Integer getRepair_Fee() {
        return Repair_Fee;
    }

    public void setRepair_Fee(Integer repair_Fee) {
        Repair_Fee = repair_Fee;
    }

    public Integer getBaoxian_Fee() {
        return Baoxian_Fee;
    }

    public void setBaoxian_Fee(Integer baoxian_Fee) {
        Baoxian_Fee = baoxian_Fee;
    }

    public Integer getChesun_Fee() {
        return Chesun_Fee;
    }

    public void setChesun_Fee(Integer chesun_Fee) {
        Chesun_Fee = chesun_Fee;
    }

    public Integer getClean_Fee() {
        return Clean_Fee;
    }

    public void setClean_Fee(Integer clean_Fee) {
        Clean_Fee = clean_Fee;
    }

    public Integer getYunche_Fee() {
        return Yunche_Fee;
    }

    public void setYunche_Fee(Integer yunche_Fee) {
        Yunche_Fee = yunche_Fee;
    }

    public Integer getChaizhuang_Fee() {
        return Chaizhuang_Fee;
    }

    public void setChaizhuang_Fee(Integer chaizhuang_Fee) {
        Chaizhuang_Fee = chaizhuang_Fee;
    }

    public Integer getYidihuanche_Fee() {
        return Yidihuanche_Fee;
    }

    public void setYidihuanche_Fee(Integer yidihuanche_Fee) {
        Yidihuanche_Fee = yidihuanche_Fee;
    }

    public Integer getOther_Fee() {
        return Other_Fee;
    }

    public void setOther_Fee(Integer other_Fee) {
        Other_Fee = other_Fee;
    }

    public Integer getPeilian_Fee() {
        return Peilian_Fee;
    }

    public void setPeilian_Fee(Integer peilian_Fee) {
        Peilian_Fee = peilian_Fee;
    }

    public Integer getFujia_Fee() {
        return Fujia_Fee;
    }

    public void setFujia_Fee(Integer fujia_Fee) {
        Fujia_Fee = fujia_Fee;
    }

    public Double getYingshou_Jine() {
        return Yingshou_Jine;
    }

    public void setYingshou_Jine(Double yingshou_Jine) {
        Yingshou_Jine = yingshou_Jine;
    }

    public Double getShishou_Jine() {
        return Shishou_Jine;
    }

    public void setShishou_Jine(Double shishou_Jine) {
        Shishou_Jine = shishou_Jine;
    }

    public Double getYingshou_Zhangkuan() {
        return Yingshou_Zhangkuan;
    }

    public void setYingshou_Zhangkuan(Double yingshou_Zhangkuan) {
        Yingshou_Zhangkuan = yingshou_Zhangkuan;
    }

    public Double getYingtui_Zhangkuan() {
        return Yingtui_Zhangkuan;
    }

    public void setYingtui_Zhangkuan(Double yingtui_Zhangkuan) {
        Yingtui_Zhangkuan = yingtui_Zhangkuan;
    }

    public String getJiesuanren() {
        return Jiesuanren;
    }

    public void setJiesuanren(String jiesuanren) {
        Jiesuanren = jiesuanren;
    }

    public String getJiaokuanren() {
        return jiaokuanren;
    }

    public void setJiaokuanren(String jiaokuanren) {
        this.jiaokuanren = jiaokuanren;
    }

    public Timestamp getShoukuan_Date() {
        return Shoukuan_Date;
    }

    public void setShoukuan_Date(Timestamp shoukuan_Date) {
        Shoukuan_Date = shoukuan_Date;
    }

    public String getZhipiao_Id() {
        return Zhipiao_Id;
    }

    public void setZhipiao_Id(String zhipiao_Id) {
        Zhipiao_Id = zhipiao_Id;
    }

    public String getDemo() {
        return Demo;
    }

    public void setDemo(String demo) {
        Demo = demo;
    }

}

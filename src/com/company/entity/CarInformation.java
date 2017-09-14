package com.company.entity;

import com.company.dao.Id;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class CarInformation {
    @Id
    public String Car_Id;
    public Timestamp Buy_Time;
    public String Car_Type;
    public String Car_Color;
    public String Chuchang_Id;
    public String Motor_Id;
    public String Dipan_Id;
    public String Chair_Num;
    public BigDecimal Buy_Price;
    public BigDecimal Buy_tax;
    public BigDecimal Shangpai_fee;
    public BigDecimal Zhuangshi;
    public String Chezhu_Name;
    public String Tel;
    public BigDecimal Start_Gongli;
    public BigDecimal Current_Gongli;
    public Timestamp YLF_Starttime;
    public Timestamp YLF_Endtime;
    public Timestamp NS_Starttime;
    public Timestamp NS_Endtime;
    public Timestamp BX_Starttime;
    public Timestamp BX_Endtime;
    public Timestamp CCS_Starttime;
    public Timestamp CCS_Endtime;
    public Timestamp LQP_Starttime;
    public Timestamp LQP_Endtime;
    public Timestamp YYZ_Starttime;
    public Timestamp YYZ_Endtime;
    public Timestamp YGF_Starttime;
    public Timestamp YGF_Endtime;
    public BigDecimal Erbaolicheng;
    public BigDecimal NextErbao;
//    public int isBlockUp;
//
//    public int getIsBlockUp() {
//        return isBlockUp;
//    }
//
//    public void setIsBlockUp(int isBlockUp) {
//        this.isBlockUp = isBlockUp;
//    }

    public String getCar_Id() {
        return Car_Id;
    }

    public void setCar_Id(String car_Id) {
        Car_Id = car_Id;
    }

    public Timestamp getBuy_Time() {
        return Buy_Time;
    }

    public void setBuy_Time(Timestamp buy_Time) {
        Buy_Time = buy_Time;
    }

    public String getCar_Type() {
        return Car_Type;
    }

    public void setCar_Type(String car_Type) {
        Car_Type = car_Type;
    }

    public String getCar_Color() {
        return Car_Color;
    }

    public void setCar_Color(String car_Color) {
        Car_Color = car_Color;
    }

    public String getChuchang_Id() {
        return Chuchang_Id;
    }

    public void setChuchang_Id(String chuchang_Id) {
        Chuchang_Id = chuchang_Id;
    }

    public String getMotor_Id() {
        return Motor_Id;
    }

    public void setMotor_Id(String motor_Id) {
        Motor_Id = motor_Id;
    }

    public String getDipan_Id() {
        return Dipan_Id;
    }

    public void setDipan_Id(String dipan_Id) {
        Dipan_Id = dipan_Id;
    }

    public String getChair_Num() {
        return Chair_Num;
    }

    public void setChair_Num(String chair_Num) {
        Chair_Num = chair_Num;
    }

    public BigDecimal getBuy_Price() {
        return Buy_Price;
    }

    public void setBuy_Price(BigDecimal buy_Price) {
        Buy_Price = buy_Price;
    }

    public BigDecimal getBuy_tax() {
        return Buy_tax;
    }

    public void setBuy_tax(BigDecimal buy_tax) {
        Buy_tax = buy_tax;
    }

    public BigDecimal getShangpai_fee() {
        return Shangpai_fee;
    }

    public void setShangpai_fee(BigDecimal shangpai_fee) {
        Shangpai_fee = shangpai_fee;
    }

    public BigDecimal getZhuangshi() {
        return Zhuangshi;
    }

    public void setCar_Zhuangshi(BigDecimal zhuangshi) {
        Zhuangshi = zhuangshi;
    }

    public String getChezhu_Name() {
        return Chezhu_Name;
    }

    public void setChezhu_Name(String chezhu_Name) {
        Chezhu_Name = chezhu_Name;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public BigDecimal getStart_Gongli() {
        return Start_Gongli;
    }

    public void setStart_Gongli(BigDecimal start_Gongli) {
        Start_Gongli = start_Gongli;
    }

    public BigDecimal getCurrent_Gongli() {
        return Current_Gongli;
    }

    public void setCurrent_Gongli(BigDecimal current_Gongli) {
        Current_Gongli = current_Gongli;
    }

    public Timestamp getYLF_Starttime() {
        return YLF_Starttime;
    }

    public void setYLF_Starttime(Timestamp YLF_Starttime) {
        this.YLF_Starttime = YLF_Starttime;
    }

    public Timestamp getYLF_Endtime() {
        return YLF_Endtime;
    }

    public void setYLF_Endtime(Timestamp YLF_Endtime) {
        this.YLF_Endtime = YLF_Endtime;
    }

    public Timestamp getNS_Starttime() {
        return NS_Starttime;
    }

    public void setNS_Starttime(Timestamp NS_Starttime) {
        this.NS_Starttime = NS_Starttime;
    }

    public Timestamp getNS_Endtime() {
        return NS_Endtime;
    }

    public void setNS_Endtime(Timestamp NS_Endtime) {
        this.NS_Endtime = NS_Endtime;
    }

    public Timestamp getBX_Starttime() {
        return BX_Starttime;
    }

    public void setBX_Starttime(Timestamp BX_Starttime) {
        this.BX_Starttime = BX_Starttime;
    }

    public Timestamp getBX_Endtime() {
        return BX_Endtime;
    }

    public void setBX_Endtime(Timestamp BX_Endtime) {
        this.BX_Endtime = BX_Endtime;
    }

    public Timestamp getCCS_Starttime() {
        return CCS_Starttime;
    }

    public void setCCS_Starttime(Timestamp CCS_Starttime) {
        this.CCS_Starttime = CCS_Starttime;
    }

    public Timestamp getCCS_Endtime() {
        return CCS_Endtime;
    }

    public void setCCS_Endtime(Timestamp CCS_Endtime) {
        this.CCS_Endtime = CCS_Endtime;
    }

    public Timestamp getLQP_Starttime() {
        return LQP_Starttime;
    }

    public void setLQP_Starttime(Timestamp LQP_Starttime) {
        this.LQP_Starttime = LQP_Starttime;
    }

    public Timestamp getLQP_Endtime() {
        return LQP_Endtime;
    }

    public void setLQP_Endtime(Timestamp LQP_Endtime) {
        this.LQP_Endtime = LQP_Endtime;
    }

    public Timestamp getYYZ_Starttime() {
        return YYZ_Starttime;
    }

    public void setYYZ_Starttime(Timestamp YYZ_Starttime) {
        this.YYZ_Starttime = YYZ_Starttime;
    }

    public Timestamp getYYZ_Endtime() {
        return YYZ_Endtime;
    }

    public void setYYZ_Endtime(Timestamp YYZ_Endtime) {
        this.YYZ_Endtime = YYZ_Endtime;
    }

    public Timestamp getYGF_Starttime() {
        return YGF_Starttime;
    }

    public void setYGF_Starttime(Timestamp YGF_Starttime) {
        this.YGF_Starttime = YGF_Starttime;
    }

    public Timestamp getYGF_Endtime() {
        return YGF_Endtime;
    }

    public void setYGF_Endtime(Timestamp YGF_Endtime) {
        this.YGF_Endtime = YGF_Endtime;
    }

    public BigDecimal getErbaolicheng() {
        return Erbaolicheng;
    }

    public void setErbaolicheng(BigDecimal erbaolicheng) {
        Erbaolicheng = erbaolicheng;
    }

    public BigDecimal getNextErbao() {
        return NextErbao;
    }

    public void setNextErbao(BigDecimal nextErbao) {
        NextErbao = nextErbao;
    }

    public String toString(){
        return Car_Id+"\t"+Buy_Time+"\t"+Car_Type+"\t"+Car_Color+"\t"+Motor_Id+"\t"+Chezhu_Name+"\t"+Tel;
    }

}

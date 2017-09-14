package com.company.entity;

import java.util.Date;

public class CarWeiZhang {

    private int weizhangNo;// 罚单号
    private String Car_Id;// 车牌号
    private String weizhangqingkuang;// 违章情况
    private int car_card_No;// 驾驶证扣分
    private int penalty;// 罚款
    private Date weizhangdate;// 违章时间
    private String remark;// 备注

    public CarWeiZhang() {
        super();
    }

    public int getWeizhangNo() {
        return weizhangNo;
    }

    public void setWeizhangNo(int weizhangNo) {
        this.weizhangNo = weizhangNo;
    }

    public String getCar_Id() {
        return Car_Id;
    }

    public void setCar_Id(String car_Id) {
        Car_Id = car_Id;
    }

    public String getWeizhangqingkuang() {
        return weizhangqingkuang;
    }

    public void setWeizhangqingkuang(String weizhangqingkuang) {
        this.weizhangqingkuang = weizhangqingkuang;
    }

    public int getCar_card_No() {
        return car_card_No;
    }

    public void setCar_card_No(int car_card_No) {
        this.car_card_No = car_card_No;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public Date getWeizhangdate() {
        return weizhangdate;
    }

    public void setWeizhangdate(Date weizhangdate) {
        this.weizhangdate = weizhangdate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

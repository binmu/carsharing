package com.company.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.company.dao.Id;

public class Tb_Cust_Yd {

	@Id
	private String Inner_Id;//�ڲ����      ����
	
	private String Customer_Id;//�ͻ���
	private String Customer_Name;//����
	private String Car_Id;//���ƺ�
	private String Zhixing;//ִ�����
	private BigDecimal Zulin_Price;//���޵���
	private BigDecimal Yanjin;//Ѻ��
	private BigDecimal Pre_Zujin;//Ԥ�����
	private BigDecimal Zulin_Qixian;//��������
	private BigDecimal Chaoshi_Fee;// ��ʻ�շ�
	private BigDecimal Licheng_Meitian;//ÿ����ʻ�����
	private BigDecimal OutTime_Fee;//��ʱ�շ�
	private String Jinbanren;//������
	private Date Yuding_Date;//Ԥ������
	private Date Yuding_Time;//Ԥ��ʱ��
	private String Demo;//��ע
	
	public Tb_Cust_Yd() {
		super();
	}

	public Tb_Cust_Yd(String inner_Id, String customer_Id, String customer_Name, String car_Id, String zhixing,
			BigDecimal zulin_Price, BigDecimal yanjin, BigDecimal pre_Zujin, BigDecimal zulin_Qixian,
			BigDecimal chaoshi_Fee, BigDecimal licheng_Meitian, BigDecimal outTime_Fee, String jinbanren,
			Date yuding_Date, Date yuding_Time, String demo) {
		super();
		Inner_Id = inner_Id;
		Customer_Id = customer_Id;
		Customer_Name = customer_Name;
		Car_Id = car_Id;
		Zhixing = zhixing;
		Zulin_Price = zulin_Price;
		Yanjin = yanjin;
		Pre_Zujin = pre_Zujin;
		Zulin_Qixian = zulin_Qixian;
		Chaoshi_Fee = chaoshi_Fee;
		Licheng_Meitian = licheng_Meitian;
		OutTime_Fee = outTime_Fee;
		Jinbanren = jinbanren;
		Yuding_Date = yuding_Date;
		Yuding_Time = yuding_Time;
		Demo = demo;
	}

	public String getInner_Id() {
		return Inner_Id;
	}

	public void setInner_Id(String inner_Id) {
		Inner_Id = inner_Id;
	}

	public String getCustomer_Id() {
		return Customer_Id;
	}

	public void setCustomer_Id(String customer_Id) {
		Customer_Id = customer_Id;
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

	public String getZhixing() {
		return Zhixing;
	}

	public void setZhixing(String zhixing) {
		Zhixing = zhixing;
	}

	public BigDecimal getZulin_Price() {
		return Zulin_Price;
	}

	public void setZulin_Price(BigDecimal zulin_Price) {
		Zulin_Price = zulin_Price;
	}

	public BigDecimal getYanjin() {
		return Yanjin;
	}

	public void setYanjin(BigDecimal yanjin) {
		Yanjin = yanjin;
	}

	public BigDecimal getPre_Zujin() {
		return Pre_Zujin;
	}

	public void setPre_Zujin(BigDecimal pre_Zujin) {
		Pre_Zujin = pre_Zujin;
	}

	public BigDecimal getZulin_Qixian() {
		return Zulin_Qixian;
	}

	public void setZulin_Qixian(BigDecimal zulin_Qixian) {
		Zulin_Qixian = zulin_Qixian;
	}

	public BigDecimal getChaoshi_Fee() {
		return Chaoshi_Fee;
	}

	public void setChaoshi_Fee(BigDecimal chaoshi_Fee) {
		Chaoshi_Fee = chaoshi_Fee;
	}

	public BigDecimal getLicheng_Meitian() {
		return Licheng_Meitian;
	}

	public void setLicheng_Meitian(BigDecimal licheng_Meitian) {
		Licheng_Meitian = licheng_Meitian;
	}

	public BigDecimal getOutTime_Fee() {
		return OutTime_Fee;
	}

	public void setOutTime_Fee(BigDecimal outTime_Fee) {
		OutTime_Fee = outTime_Fee;
	}

	public String getJinbanren() {
		return Jinbanren;
	}

	public void setJinbanren(String jinbanren) {
		Jinbanren = jinbanren;
	}

	public Date getYuding_Date() {
		return Yuding_Date;
	}

	public void setYuding_Date(Date yuding_Date) {
		Yuding_Date = yuding_Date;
	}

	public Date getYuding_Time() {
		return Yuding_Time;
	}

	public void setYuding_Time(Date yuding_Time) {
		Yuding_Time = yuding_Time;
	}

	public String getDemo() {
		return Demo;
	}

	public void setDemo(String demo) {
		Demo = demo;
	}
}

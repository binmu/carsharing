package com.company.entity;

import java.sql.Timestamp;

public class CustZL {
	private String Inner_Id;	//�ڲ����
	private String Customer_Id;	//�ͻ���
	private String Customer_Name;	//����
	private String Car_Id;	//���ƺ�
	private Integer Pre_Zujin;	//Ԥ�����
	private Integer Zulin_Price;	//���޵���
	private Integer Yanjin;	//Ѻ��
	private Integer Licheng_Meitian;	//ÿ����ʻ���
	private Integer Zulin_Qixian;	//��������
	private Integer Chaoshi_Fee;	//��ʱ�շ�
	private Integer Start_Licheng;	//������� 
	private Integer OutTime_Fee;	//��ʱ�շ�
	private String Jinbanren;	//������
	private Timestamp Fache_Date;	//��������
	private String Driver;	//��ʻԱ
	private String Fache_Id;	//��������
	private Integer Yingshou_Zujin;	//Ӧ�����
	private String Demo;	//��ע
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
	public Integer getPre_Zujin() {
		return Pre_Zujin;
	}
	public void setPre_Zujin(Integer pre_Zujin) {
		Pre_Zujin = pre_Zujin;
	}
	public Integer getZulin_Price() {
		return Zulin_Price;
	}
	public void setZulin_Price(Integer zulin_Price) {
		Zulin_Price = zulin_Price;
	}
	public Integer getYanjin() {
		return Yanjin;
	}
	public void setYanjin(Integer yanjin) {
		Yanjin = yanjin;
	}
	public Integer getLicheng_Meitian() {
		return Licheng_Meitian;
	}
	public void setLicheng_Meitian(Integer licheng_Meitian) {
		Licheng_Meitian = licheng_Meitian;
	}
	public Integer getZulin_Qixian() {
		return Zulin_Qixian;
	}
	public void setZulin_Qixian(Integer zulin_Qixian) {
		Zulin_Qixian = zulin_Qixian;
	}
	public Integer getChaoshi_Fee() {
		return Chaoshi_Fee;
	}
	public void setChaoshi_Fee(Integer chaoshi_Fee) {
		Chaoshi_Fee = chaoshi_Fee;
	}
	public Integer getStart_Licheng() {
		return Start_Licheng;
	}
	public void setStart_Licheng(Integer start_Licheng) {
		Start_Licheng = start_Licheng;
	}
	public Integer getOutTime_Fee() {
		return OutTime_Fee;
	}
	public void setOutTime_Fee(Integer outTime_Fee) {
		OutTime_Fee = outTime_Fee;
	}
	public String getJinbanren() {
		return Jinbanren;
	}
	public void setJinbanren(String jinbanren) {
		Jinbanren = jinbanren;
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
	public String getFache_Id() {
		return Fache_Id;
	}
	public void setFache_Id(String fache_Id) {
		Fache_Id = fache_Id;
	}
	public Integer getYingshou_Zujin() {
		return Yingshou_Zujin;
	}
	public void setYingshou_Zujin(Integer yingshou_Zujin) {
		Yingshou_Zujin = yingshou_Zujin;
	}
	public String getDemo() {
		return Demo;
	}
	public void setDemo(String demo) {
		Demo = demo;
	}
	@Override
	public String toString(){
		return getCustomer_Id();
	}
	public String toString1(){
		return getJinbanren();
	}
	public String toString3(){
		return getFache_Date()+"";
	}
	public String toString4(){
		return getDriver();
	}

}

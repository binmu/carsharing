package com.company.entity;

import com.company.dao.Id;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Customer {
	@Id
	private String cId;
	private Timestamp startTime;
	private Timestamp endTime;
	private String customerName;
	private String customerSex;
	private String customerType;
	private String customerPsd;
	private Timestamp lingZhengTime;
	private String zhunJiaType;
	private String creditId;
	private String officeTel;
	private String mobileTel;
	private String homeAddress;
	private String gongSiName;
	private String gongSiAddress;
	private BigDecimal yingShouFee;
	private BigDecimal shiShouFee;
	private int isBlockUp;

	public int getIsBlockUp() {
		return isBlockUp;
	}

	public void setIsBlockUp(int isBlockUp) {
		this.isBlockUp = isBlockUp;
	}

	public String getcId() {
		return cId;
	}
	public void setcId(String customerId) {
		this.cId = customerId;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerSex() {
		return customerSex;
	}
	public void setCustomerSex(String customerSex) {
		this.customerSex = customerSex;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getCustomerPsd() {
		return customerPsd;
	}
	public void setCustomerPsd(String customerPsd) {
		this.customerPsd = customerPsd;
	}
	public Timestamp getLingZhengTime() {
		return lingZhengTime;
	}
	public void setLingZhengTime(Timestamp lingZhengTime) {
		this.lingZhengTime = lingZhengTime;
	}
	public String getZhunJiaType() {
		return zhunJiaType;
	}
	public void setZhunJiaType(String zhunJiaType) {
		this.zhunJiaType = zhunJiaType;
	}
	public String getCreditId() {
		return creditId;
	}
	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}
	public String getOfficeTel() {
		return officeTel;
	}
	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}
	public String getMobileTel() {
		return mobileTel;
	}
	public void setMobileTel(String mobileTel) {
		this.mobileTel = mobileTel;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getGongSiName() {
		return gongSiName;
	}
	public void setGongSiName(String gongSiName) {
		this.gongSiName = gongSiName;
	}
	public String getGongSiAddress() {
		return gongSiAddress;
	}
	public void setGongSiAddress(String gongSiAddress) {
		this.gongSiAddress = gongSiAddress;
	}
	public BigDecimal getYingShouFee() {
		return yingShouFee;
	}
	public void setYingShouFee(BigDecimal yingShouFee) {
		this.yingShouFee = yingShouFee;
	}
	public BigDecimal getShiShouFee() {
		return shiShouFee;
	}
	public void setShiShouFee(BigDecimal shiShouFee) {
		this.shiShouFee = shiShouFee;
	}

	public String toString(){
		return cId+"\t"+startTime+"\t"+endTime+"\t"+customerName+"\t"+customerSex+"\t"+customerType+"\t"+customerPsd
				+"\t"+lingZhengTime+"\t"+zhunJiaType+"\t"+creditId+"\t"+officeTel+"\t"+mobileTel+"\t"+homeAddress+"\t"+gongSiName
				+gongSiAddress+"\t"+yingShouFee+"\t"+shiShouFee;
	}



}

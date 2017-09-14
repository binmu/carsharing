package com.company.entity;

import com.company.dao.Id;

import java.sql.Timestamp;

public class CarService {
	@Id
	public String Service_Id;// Ö÷¼ü
	public String Car_Id;
	public String Service_Location;
	public String Service_Status;
	public Timestamp WX_Starttime;
	public Timestamp WX_Endtime;
	
	public String getService_Id() {
		return Service_Id;
	}
	public void setService_Id(String service_Id) {
		Service_Id = service_Id;
	}
	public String getCar_Id() {
		return Car_Id;
	}
	public void setCar_Id(String car_Id) {
		Car_Id = car_Id;
	}
	public String getService_Location() {
		return Service_Location;
	}
	public void setService_Location(String service_Location) {
		Service_Location = service_Location;
	}
	public String getService_Status() {
		return Service_Status;
	}
	public void setService_Status(String service_Status) {
		Service_Status = service_Status;
	}
	public Timestamp getWX_Starttime() {
		return WX_Starttime;
	}
	public void setWX_Starttime(Timestamp wX_Starttime) {
		WX_Starttime = wX_Starttime;
	}
	public Timestamp getWX_Endtime() {
		return WX_Endtime;
	}
	public void setWX_Endtime(Timestamp wX_Endtime) {
		WX_Endtime = wX_Endtime;
	}
	

}

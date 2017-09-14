package com.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.entity.Customer;
import com.company.entity.Driver;

public class DriverDAO {
	public void add(Driver tbdri){
		Connection conn = DBTool.getInstance().getConnection();
		String sql = "" + " insert into tb_driver "
				+ " (driverName,driverSex,driverAge,driverType,driverId,driverPhone,cId) " + " values( "
				+ "?,?,?,?,?,?,?) ";
			PreparedStatement ptmt;
			try {
				ptmt = conn.prepareStatement(sql);
				ptmt.setString(1, tbdri.getDriverName());
				ptmt.setString(2, tbdri.getDriverSex());
				ptmt.setInt(3, tbdri.getDriverAge());
				ptmt.setString(4, tbdri.getDriverType());
				ptmt.setString(5, tbdri.getDriverId());
				ptmt.setString(6, tbdri.getDriverPhone());
				ptmt.setString(7, tbdri.getcId());
				ptmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void update(Driver tbdri){
		Connection conn = DBTool.getInstance().getConnection();
		String sql = "update tb_driver set driverName= ?,driverSex=?,driverAge=?,driverType=?,driverPhone=? where cId=? AND driverId=?";
			PreparedStatement ptmt;
			try {
				ptmt = conn.prepareStatement(sql);
				ptmt.setString(1, tbdri.getDriverName());
				ptmt.setString(2, tbdri.getDriverSex());
				ptmt.setInt(3, tbdri.getDriverAge());
				ptmt.setString(4, tbdri.getDriverType());
				ptmt.setString(5, tbdri.getDriverPhone());
				ptmt.setString(6, tbdri.getcId());
				ptmt.setString(7, tbdri.getDriverId());
				ptmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public List<Driver> getAllInfFormTb_driver(String tableName) {
        List<Driver> list = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer("SELECT * FROM ");
        stringBuffer.append(tableName);
        return new CommonDAOImpl().executeQuery(Driver.class, stringBuffer.toString(), null);
    }
}

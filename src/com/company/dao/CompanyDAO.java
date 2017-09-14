package com.company.dao;

import com.company.entity.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CompanyDAO {
	public void add(Company tbcom){
		Connection conn = DBTool.getInstance().getConnection();
		String sql = "" + " insert into tb_company "
				+ " (companyName,companyType,companyAddr,cId) " + " values( "
				+ "?,?,?,?) ";
			PreparedStatement ptmt;
			try {
				ptmt = conn.prepareStatement(sql);
				ptmt.setString(1, tbcom.getCompanyName());
				ptmt.setString(2, tbcom.getCompanyType());
				ptmt.setString(3, tbcom.getCompanyAddr());	
				ptmt.setString(4, tbcom.getcId());
				ptmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void update(Company tbcom){
		Connection conn = DBTool.getInstance().getConnection();
		String sql = "update tb_company set companyName=?,companyType=?,companyAddr=? where cId=?";
			PreparedStatement ptmt;
			try {
				ptmt = conn.prepareStatement(sql);
				ptmt.setString(1, tbcom.getCompanyName());
				ptmt.setString(2, tbcom.getCompanyType());
				ptmt.setString(3, tbcom.getCompanyAddr());	
				ptmt.setString(4,tbcom.getcId());
				ptmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public List<Company> getAllInfFormTb_company(String tableName) {
        List<Company> list = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer("SELECT * FROM ");
        stringBuffer.append(tableName);
        return new CommonDAOImpl().executeQuery(Company.class, stringBuffer.toString(), null);
    }
}

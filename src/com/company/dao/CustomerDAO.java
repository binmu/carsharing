package com.company.dao;

import com.company.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
	private Connection conn;
	public void add(Customer tbcus){
		conn = DBTool.getInstance().getConnection();
		String sql = "" + " insert into tb_customer "
				+ " (cId,startTime,endTime,customerName,customerSex,customerType,"
				+ " customerPsd,lingZhengTime,zhunJiaType,creditId,officeTel,mobileTel,"
				+ " homeAddress,gongSiName,gongSiAddress,yingShouFee,shiShouFee) " + " values( "
				+ " ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
			PreparedStatement ptmt;
			try {
				ptmt = conn.prepareStatement(sql);
				ptmt.setString(1, tbcus.getcId());
				ptmt.setTimestamp(2,tbcus.getStartTime());
				ptmt.setTimestamp(3, tbcus.getEndTime());
				ptmt.setString(4, tbcus.getCustomerName());
				ptmt.setString(5, tbcus.getCustomerSex());
				ptmt.setString(6, tbcus.getCustomerType());
				//System.out.println(tbcus.getCustomerPsd().toString());
				ptmt.setString(7, tbcus.getCustomerPsd());
				ptmt.setTimestamp(8, tbcus.getLingZhengTime());
				ptmt.setString(9, tbcus.getZhunJiaType());
				ptmt.setString(10, tbcus.getCreditId());
				ptmt.setString(11, tbcus.getOfficeTel());
				ptmt.setString(12, tbcus.getMobileTel());
				ptmt.setString(13, tbcus.getHomeAddress());
				ptmt.setString(14, tbcus.getGongSiName());
				ptmt.setString(15, tbcus.getGongSiAddress());
				ptmt.setBigDecimal(16, tbcus.getYingShouFee());
				ptmt.setBigDecimal(17, tbcus.getShiShouFee());
				ptmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void update(Customer tbcus){
		conn = DBTool.getInstance().getConnection();
		String sql = " update  tb_customer set"
				+ " startTime=?,endTime=?,customerName=?,customerSex=?,customerType=?,"
				+ " customerPsd=?,lingZhengTime=?,zhunJiaType=?,creditId=?,officeTel=?,mobileTel=?,"
				+ " homeAddress=?,gongSiName=?,gongSiAddress=?,yingShouFee=?,shiShouFee=? where cId=?"  ;
			PreparedStatement ptmt;
			try {
				ptmt = conn.prepareStatement(sql);			
				ptmt.setTimestamp(1,tbcus.getStartTime());
				ptmt.setTimestamp(2, tbcus.getEndTime());
				ptmt.setString(3, tbcus.getCustomerName());
				ptmt.setString(4, tbcus.getCustomerSex());
				ptmt.setString(5, tbcus.getCustomerType());
				//System.out.println(tbcus.getCustomerPsd().toString());
				ptmt.setString(6, tbcus.getCustomerPsd());
				ptmt.setTimestamp(7, tbcus.getLingZhengTime());
				ptmt.setString(8, tbcus.getZhunJiaType());
				ptmt.setString(9, tbcus.getCreditId());
				ptmt.setString(10, tbcus.getOfficeTel());
				ptmt.setString(11, tbcus.getMobileTel());
				ptmt.setString(12, tbcus.getHomeAddress());
				ptmt.setString(13, tbcus.getGongSiName());
				ptmt.setString(14, tbcus.getGongSiAddress());
				ptmt.setBigDecimal(15, tbcus.getYingShouFee());
				ptmt.setBigDecimal(16, tbcus.getShiShouFee());
				ptmt.setString(17, tbcus.getcId());
				ptmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public boolean searchColumn(String searchInf,String tableName,String columnName){
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> back=new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SElECT ");
        stringBuffer.append(columnName);
        stringBuffer.append(" AS inf FROM "+tableName);
        conn = DBTool.getInstance().getConnection();
        try {
            ps = conn.prepareStatement(stringBuffer.toString());
            rs = ps.executeQuery();
            while (rs.next()){
                back.add(rs.getString("inf"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (back.size() != 0) {
            for(String backinf : back){
                if (backinf.equals(searchInf)){
                    return true;
                }
            }
        }
        return false;
    }

	public List<Customer> getAllInfFormTb_customer(String tableName) {
        //TODO
        List<Customer> list = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer("SELECT * FROM ");
        stringBuffer.append(tableName);
        return new CommonDAOImpl().executeQuery(Customer.class, stringBuffer.toString(), null);
    }

}

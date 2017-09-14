package com.company.dao;

import com.company.entity.Bondsman;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BondsmanDAO {
	public void add(Bondsman tbbman){
		Connection conn = DBTool.getInstance().getConnection();
		String sql = "" + " insert into tb_bondsman "
				+ " (bondsmanName,bondsmanSex,bondsmanAge,bondsmanId,bondsmanPhone,cId) " + " values( "
				+ "?,?,?,?,?,?) ";
			PreparedStatement ptmt;
			try {
				ptmt = conn.prepareStatement(sql);
				ptmt.setString(1, tbbman.getBondsmanName());
				ptmt.setString(2, tbbman.getBondsmanSex());
				ptmt.setInt(3, tbbman.getBondsmanAge());
				ptmt.setString(4, tbbman.getBondsmanId());
				ptmt.setString(5, tbbman.getBondsmanPhone());
				ptmt.setString(6, tbbman.getcId());
				ptmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void update(Bondsman tbbman){
		Connection conn = DBTool.getInstance().getConnection();
		String sql = " update tb_bondsman set "
				+ "bondsmanName=?,bondsmanSex=?,bondsmanAge=?,bondsmanPhone=? where cId=? AND bondsmanId=? ";
			PreparedStatement ptmt;
			try {
				ptmt = conn.prepareStatement(sql);
				ptmt.setString(1, tbbman.getBondsmanName());
				ptmt.setString(2, tbbman.getBondsmanSex());
				ptmt.setInt(3, tbbman.getBondsmanAge());
				ptmt.setString(4, tbbman.getBondsmanPhone());
				ptmt.setString(5, tbbman.getcId());
				ptmt.setString(6, tbbman.getBondsmanId());
				ptmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public List<Bondsman> getAllInfFormTb_bondsman(String tableName) {
        //TODO
        List<Bondsman> list = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer("SELECT * FROM ");
        stringBuffer.append(tableName);
        return new CommonDAOImpl().executeQuery(Bondsman.class, stringBuffer.toString(), null);
    }
}

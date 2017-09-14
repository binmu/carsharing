package com.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.entity.Car_settlement;

public class Car_settlementDAO {
	public Car_settlement findById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Car_settlement d = null;
		try {
			conn = DBTool.getInstance().getConnection();
			ps = conn.prepareStatement("SELECT * FROM tb_car_zl WHERE Inner_id = ?");
			ps.setInt(1, id);
			System.out.println(ps.toString());
			rs = ps.executeQuery();
			while(rs.next()){
				d = new Car_settlement();
				d.setCustomer_Name(rs.getString("Customer_Name"));
				d.setCar_Id(rs.getString("Car_Id"));
				d.setPre_Zujin(rs.getInt("Pre_Zujin"));
				d.setOutTime_Fee(rs.getInt("OutTime_Fee"));
				d.setYanjin(rs.getInt("Yanjin"));
				d.setXianshi_licheng(rs.getInt("Xianshi_licheng"));
				d.setZulin_Price(rs.getInt("Zulin_Price"));
				d.setChaoshi_Fee(rs.getInt("Chaoshi_Fee"));
				d.setFache_Date(rs.getTimestamp("Fache_Date"));
				d.setDriver(rs.getString("Driver"));
				d.setStart_Licheng(rs.getInt("Start_Licheng"));				
				d.setShouche_Date(rs.getTimestamp("Shouche_Date"));
				d.setShouche_Time(rs.getTimestamp("Shouche_Time"));
				d.setZulin_Qixian(rs.getInt("Zulin_Qixian"));
				d.setYingshou_Zujin(rs.getInt("Yingshou_Zujin"));
				d.setEnd_Licheng(rs.getInt("End_Licheng"));
				d.setChaoshi_Licheng(rs.getInt("Chaoshi_Licheng"));
				d.setBaogangjia(rs.getInt("Baogangjia"));
				d.setChaoshi_Hour(rs.getInt("Chaoshi_Hour"));
				d.setXiaoji_Fee(rs.getInt("Xiaoji_Fee"));
				d.setGas_Fee(rs.getInt("Gas_Fee"));
				d.setDaijia_Fee(rs.getInt("Daijia_Fee"));
				d.setChaobaoyang_Fee(rs.getInt("Chaobaoyang_Fee"));
				d.setWeiyuejin(rs.getInt("Weiyuejin"));
				d.setRepair_Fee(rs.getInt("Repair_Fee"));
				d.setBaoxian_Fee(rs.getInt("Baoxian_Fee"));
				d.setChesun_Fee(rs.getInt("Chesun_Fee"));
				d.setClean_Fee(rs.getInt("Clean_Fee"));
				d.setYunche_Fee(rs.getInt("Yunche_Fee"));
				d.setChaizhuang_Fee(rs.getInt("Chaizhuang_Fee"));
				d.setYidihuanche_Fee(rs.getInt("Yidihuanche_Fee"));
				d.setOther_Fee(rs.getInt("Other_Fee"));
				d.setPeilian_Fee(rs.getInt("Peilian_Fee"));
				d.setFujia_Fee(rs.getInt("Fujia_Fee"));
				d.setYingshou_Jine(rs.getDouble("Yinshou_Jine"));
				d.setShishou_Jine(rs.getDouble("Shishou_Jine"));
				d.setYingshou_Zhangkuan(rs.getDouble("Yingshou_Zhangkuan"));
				d.setYingtui_Zhangkuan(rs.getDouble("Yingtui_Zhangkuan"));
				d.setJiesuanren(rs.getString("Jiesuanren"));
				d.setJiaokuanren(rs.getString("jiaokuanren"));
				d.setShoukuan_Date(rs.getTimestamp("Shoukuan_Date"));
				d.setZhipiao_Id(rs.getString("Zhipiao_Id"));
				d.setDemo(rs.getString("Demo"));
								
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBTool.closeAll(rs, ps, conn);
		}
		return d;
	}
}

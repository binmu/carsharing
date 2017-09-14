package com.company.test;

import com.company.dao.DBTool;

import java.io.*;
import java.sql.*;

public class pic {
    public static void main(String[] args) throws SQLException, IOException {
        String sql = "select content from image where id=1";//在我这里3.
        Connection con = DBTool.getInstance().getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);//将查询结果给rs
        if (rs.next()) {
            InputStream is = rs.getBinaryStream("content");
            //.getBinaryStream():a Java input stream that delivers the database column value as a stream of uninterpreted bytes
            FileOutputStream fos = new FileOutputStream("C:\\Users\\student\\Desktop\\back.jpg");
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);//将数据库的图片写出
            }
            System.out.println("下载成功！已下载至桌面，请查看");
        } else {
            System.out.println("图片不存在！");
        }
        con.close();
    }
}


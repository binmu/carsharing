package org.car.app.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.car.app.entity.Car_settlement;
import org.car.app.entity.CustZL;
import org.car.app.entity.Reckoner;
import org.car.app.ui.CarSettlement;

import com.mysql.jdbc.Field;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.car.app.dao.Car_settlementDAO;
import org.car.app.dao.CommonDAOImpl;
import org.car.app.entity.Dept;
import org.car.app.entity.Emp;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JScrollBar;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;

public class CarSettlement extends JDialog {

	private JPanel contentPane;
	private JLabel ok;
	private JLabel finish;
	private JTextField txtInner_Id;
	private JTextField Customer_Name;
	private JTextField Car_Id;
	private JTextField Pre_Zujin;
	private JTextField OutTime_Fee1;
	private JTextField Yanjin;
	private JTextField Xianshi_licheng;
	private JTextField Zulin_Price;
	private JTextField Chaoshi_Fee1;
	private JTextField Fache_Date;
	private JTextField Driver;
	private JTextField Start_Licheng;
	private JTextField Inner_id;
//	private JTextField textField_13;
//	private JTextField textField_14;
	private JTextField Zulin_Qixian;
	private JTextField Yingshou_Zujin;
	private JTextField End_Licheng;
	private JTextField Chaoshi_Licheng;
	private JTextField Chaoshi_Fee;
	private JTextField Baogangjia;
	private JTextField Chaoshi_Hour;
	private JTextField OutTime_Fee;
	private JTextField Xiaoji_Fee;
	private JTextField Gas_Fee;
	private JTextField Daijia_Fee;
	private JTextField Chaobaoyang_Fee;
	private JTextField Weiyuejin;
	private JTextField Repair_Fee;
	private JTextField Baoxian_Fee;
	private JTextField Chesun_Fee;
	private JTextField Clean_Fee;
	private JTextField Yunche_Fee;
	private JTextField Chaizhuang_Fee;
	private JTextField Yidihuanche_Fee;
	private JTextField Other_Fee;
	private JTextField Peilian_Fee;
	private JTextField Fujia_Fee;
	private JTextField Yingshou_Jine;
	private JTextField Shishou_Jine;
	private JTextField Yingshou_Zhangkuan;
	private JTextField Yingtui_Zhangkuan;
	private JTextField jiaokuanren;
//	private JTextField textField_15;
	private JTextField Zhipiao_Id;
	private JTextField Demo;

	  private JComboBox Jiesuanren;//结算人
	  private JTextField Shouche_Date;
	  private JTextField Shoukuang_Date;

	protected String[] args;
	private JTextField Shouche_Time;
	private Component jPanel;
	Car_settlement params = new Car_settlement();  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarSettlement frame = new CarSettlement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the ui.
	 */
	public CarSettlement() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel(null);
		panel.setBackground(SystemColor.control);
		panel.setForeground(SystemColor.control);
		panel.setBorder(BorderFactory.createLineBorder(Color.gray));//设置面板边框颜色  
		contentPane.add(panel, BorderLayout.CENTER);
		
		this.setResizable(false);
		
		JPanel panel_1 = new JPanel(null);
		panel_1.setBackground(SystemColor.control);
		panel_1.setForeground(SystemColor.control);
		panel_1.setBorder(BorderFactory.createLineBorder(Color.gray));//设置面板边框颜色  
		panel_1.setBounds(0, 97, 646, 114);
		panel.add(panel_1);
		
		JLabel label_12 = new JLabel("\u6536\u8F66\u65E5\u671F\uFF1A");
		label_12.setBounds(22, 10, 68, 15);
		panel_1.add(label_12);
		
		JLabel label_13 = new JLabel("\u6536\u8F66\u65F6\u95F4\uFF1A");
		label_13.setBounds(183, 10, 68, 15);
		panel_1.add(label_13);

		
		 JLabel label_14 = new JLabel("\u79DF\u8D41\u671F\u9650\uFF1A");
		label_14.setBounds(334, 10, 68, 15);
		panel_1.add(label_14);
		
		Zulin_Qixian = new JTextField();
		Zulin_Qixian.setEnabled(false);
		Zulin_Qixian.setHorizontalAlignment(SwingConstants.RIGHT);
		Zulin_Qixian.setBackground(Color.WHITE);
		Zulin_Qixian.setBounds(397, 7, 82, 21);
		panel_1.add(Zulin_Qixian);
		Zulin_Qixian.setColumns(10);
		
		Yingshou_Zujin = new JTextField();
		Yingshou_Zujin.setEnabled(false);
		Yingshou_Zujin.setHorizontalAlignment(SwingConstants.RIGHT);
		Yingshou_Zujin.setBounds(558, 7, 66, 21);
		panel_1.add(Yingshou_Zujin);
		Yingshou_Zujin.setColumns(10);
		
		JLabel label_15 = new JLabel("\u6536\u8F66\u91CC\u7A0B\uFF1A");
		label_15.setBounds(22, 45, 68, 15);
		panel_1.add(label_15);
		
		End_Licheng = new JTextField();
		End_Licheng.setHorizontalAlignment(SwingConstants.RIGHT);
		End_Licheng.setBounds(92, 42, 81, 21);
		panel_1.add(End_Licheng);
		End_Licheng.setColumns(10);
		
		JLabel label_16 = new JLabel("\u8D85\u9A76\u91CC\u7A0B\uFF1A");
		label_16.setBounds(183, 45, 68, 15);
		panel_1.add(label_16);
		
		Chaoshi_Licheng = new JTextField();
		Chaoshi_Licheng.setHorizontalAlignment(SwingConstants.RIGHT);
		Chaoshi_Licheng.setBounds(245, 42, 79, 21);
		panel_1.add(Chaoshi_Licheng);
		Chaoshi_Licheng.setColumns(10);
		
		JLabel label_17 = new JLabel("\u8D85\u9A76\u6536\u8D39\uFF1A");
		label_17.setBounds(334, 45, 68, 15);
		panel_1.add(label_17);
		
		Chaoshi_Fee = new JTextField();
		Chaoshi_Fee.setHorizontalAlignment(SwingConstants.RIGHT);
		Chaoshi_Fee.setBounds(397, 42, 82, 21);
		panel_1.add(Chaoshi_Fee);
		Chaoshi_Fee.setColumns(10);
		
		JLabel label_18 = new JLabel("\u5305\u5E72\u4EF7\uFF1A");
		label_18.setBounds(499, 45, 54, 15);
		panel_1.add(label_18);
		
		Baogangjia = new JTextField();
		Baogangjia.setHorizontalAlignment(SwingConstants.RIGHT);
		Baogangjia.setBounds(558, 42, 66, 21);
		panel_1.add(Baogangjia);
		Baogangjia.setColumns(10);
		
		JLabel label_19 = new JLabel("\u8D85\u65F6\u5C0F\u65F6\uFF1A");
		label_19.setBounds(22, 77, 68, 15);
		panel_1.add(label_19);
		
		Chaoshi_Hour = new JTextField();
		Chaoshi_Hour.setHorizontalAlignment(SwingConstants.RIGHT);
		Chaoshi_Hour.setBounds(92, 74, 81, 21);
		panel_1.add(Chaoshi_Hour);
		Chaoshi_Hour.setColumns(10);
		
		JLabel label_20 = new JLabel("\u8D85\u65F6\u6536\u8D39\uFF1A");
		label_20.setBounds(180, 77, 71, 15);
		panel_1.add(label_20);
		
		OutTime_Fee = new JTextField();
		OutTime_Fee.setHorizontalAlignment(SwingConstants.RIGHT);
		OutTime_Fee.setBounds(245, 74, 79, 21);
		panel_1.add(OutTime_Fee);
		OutTime_Fee.setColumns(10);
		
		JLabel label_21 = new JLabel("\u6536\u8D39\u5C0F\u8BA1\uFF1A");
		label_21.setBounds(489, 77, 67, 15);
		panel_1.add(label_21);
		
		Xiaoji_Fee = new JTextField();
		Xiaoji_Fee.setHorizontalAlignment(SwingConstants.RIGHT);
		Xiaoji_Fee.setBounds(558, 73, 66, 21);
		panel_1.add(Xiaoji_Fee);
		Xiaoji_Fee.setColumns(10);
		
		Shouche_Date = new JTextField();
		Shouche_Date.setHorizontalAlignment(SwingConstants.LEFT);
		Shouche_Date.setBounds(92, 7, 81, 21);
		Shouche_Date.addMouseListener(new MouseAdapter() {
	    	  public void mousePressed(MouseEvent e){
	    		  test(Shouche_Date,panel_1);
	    	  }
		});
		panel_1.add(Shouche_Date);
		Shouche_Date.setColumns(10);
		
		Shouche_Time = new JTextField();
		Shouche_Time.setHorizontalAlignment(SwingConstants.LEFT);
		Shouche_Time.setBounds(245, 7, 79, 21);
//		Shouche_Time.addMouseListener(new MouseAdapter() {
//	    	  public void mousePressed(MouseEvent e){
//	    		  test(Shouche_Time,panel_1);
//	    	  }
//		});
		panel_1.add(Shouche_Time);
		Shouche_Time.setColumns(10);
		
		JLabel label_46 = new JLabel("\u5E94\u6536\u79DF\u91D1\uFF1A");
		label_46.setBounds(490, 12, 62, 15);
		panel_1.add(label_46);
		
		
		
		JPanel panel_2 = new JPanel(null);
		panel_2.setBorder(BorderFactory.createLineBorder(Color.gray));//设置面板边框颜色
		panel_2.setBounds(0, 0, 646, 98);
		panel.add(panel_2);
		
		OutTime_Fee1 = new JTextField();
		OutTime_Fee1.setEnabled(false);
		OutTime_Fee1.setBounds(557, 10, 79, 21);
		panel_2.add(OutTime_Fee1);
		OutTime_Fee1.setHorizontalAlignment(SwingConstants.RIGHT);
		OutTime_Fee1.setColumns(10);
		
		Chaoshi_Fee1 = new JTextField();
		Chaoshi_Fee1.setEnabled(false);
		Chaoshi_Fee1.setBounds(557, 36, 79, 21);
		panel_2.add(Chaoshi_Fee1);
		Chaoshi_Fee1.setHorizontalAlignment(SwingConstants.RIGHT);
		Chaoshi_Fee1.setColumns(10);
		
		Inner_id = new JTextField();
		Inner_id.setBounds(557, 67, 79, 21);
		panel_2.add(Inner_id);
		Inner_id.setColumns(10);
		
		JLabel label_11 = new JLabel("\u5185\u90E8\u7F16\u53F7\uFF1A");
		label_11.setBounds(491, 70, 66, 15);
		panel_2.add(label_11);
		
		JLabel label_7 = new JLabel("\u8D85\u9A76\u6536\u8D39\uFF1A");
		label_7.setBounds(491, 39, 66, 15);
		panel_2.add(label_7);
		
		JLabel label_3 = new JLabel("\u8D85\u65F6\u6536\u8D39\uFF1A");
		label_3.setBounds(491, 13, 66, 15);
		panel_2.add(label_3);
		
		Pre_Zujin = new JTextField();
		Pre_Zujin.setEnabled(false);
		Pre_Zujin.setBounds(402, 10, 79, 21);
		panel_2.add(Pre_Zujin);
		Pre_Zujin.setHorizontalAlignment(SwingConstants.RIGHT);
		Pre_Zujin.setColumns(10);
		
		Zulin_Price = new JTextField();
		Zulin_Price.setEnabled(false);
		Zulin_Price.setBounds(402, 36, 79, 21);
		panel_2.add(Zulin_Price);
		Zulin_Price.setHorizontalAlignment(SwingConstants.RIGHT);
		Zulin_Price.setColumns(10);
		
		Start_Licheng = new JTextField();
		Start_Licheng.setEnabled(false);
		Start_Licheng.setBounds(402, 67, 79, 21);
		panel_2.add(Start_Licheng);
		Start_Licheng.setHorizontalAlignment(SwingConstants.RIGHT);
		Start_Licheng.setColumns(10);
		
		JLabel label_10 = new JLabel("\u53D1\u8F66\u91CC\u7A0B\uFF1A");
		label_10.setBounds(336, 70, 66, 15);
		panel_2.add(label_10);
		
		JLabel label_6 = new JLabel("\u79DF\u8D41\u5355\u4EF7\uFF1A");
		label_6.setBounds(336, 39, 72, 15);
		panel_2.add(label_6);
		
		JLabel label_2 = new JLabel("\u9884\u6536\u79DF\u91D1\uFF1A");
		label_2.setBounds(336, 13, 66, 15);
		panel_2.add(label_2);
		
		Driver = new JTextField();
		Driver.setEnabled(false);
		Driver.setBounds(245, 67, 81, 21);
		panel_2.add(Driver);
		Driver.setColumns(10);
		
		Xianshi_licheng = new JTextField();
		Xianshi_licheng.setEnabled(false);
		Xianshi_licheng.setBounds(245, 36, 81, 21);
		panel_2.add(Xianshi_licheng);
		Xianshi_licheng.setHorizontalAlignment(SwingConstants.RIGHT);
		Xianshi_licheng.setColumns(10);
		
		Car_Id = new JTextField();
		Car_Id.setEnabled(false);
		Car_Id.setBounds(245, 10, 81, 21);
		panel_2.add(Car_Id);
		Car_Id.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8F66\u724C\u53F7\uFF1A");
		label_1.setBounds(195, 13, 54, 15);
		panel_2.add(label_1);
		
		JLabel label_5 = new JLabel("\u9650\u9A76\u91CC\u7A0B\uFF1A");
		label_5.setBounds(182, 39, 65, 15);
		panel_2.add(label_5);
		
		JLabel label_9 = new JLabel("\u9A7E\u9A76\u5458\uFF1A");
		label_9.setBounds(195, 70, 54, 15);
		panel_2.add(label_9);
		
		Customer_Name = new JTextField();
		Customer_Name.setEnabled(false);
		Customer_Name.setBounds(93, 10, 79, 21);
		panel_2.add(Customer_Name);
		Customer_Name.setColumns(10);
		
		Yanjin = new JTextField();
		Yanjin.setEnabled(false);
		Yanjin.setBounds(93, 36, 79, 21);
		panel_2.add(Yanjin);
		Yanjin.setHorizontalAlignment(SwingConstants.RIGHT);
		Yanjin.setColumns(10);
		
		Fache_Date = new JTextField();
		Fache_Date.setFont(new Font("Arial", Font.PLAIN, 8));
		Fache_Date.setEnabled(false);
		Fache_Date.setHorizontalAlignment(SwingConstants.RIGHT);
		Fache_Date.setBounds(93, 67, 79, 21);
//		Fache_Date.addMouseListener(new MouseAdapter() {
//	    	  public void mousePressed(MouseEvent e){
//	    		  test(Fache_Date,panel_2);
//	    	  }
//		});
		panel_2.add(Fache_Date);
		Fache_Date.setColumns(10);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setBounds(47, 13, 54, 15);
		panel_2.add(label);
		
		JLabel label_4 = new JLabel("\u62BC\u91D1\uFF1A");
		label_4.setBounds(47, 39, 54, 15);
		panel_2.add(label_4);
		
		JLabel label_8 = new JLabel("\u53D1\u8F66\u65E5\u671F\uFF1A");
		label_8.setBounds(23, 70, 66, 15);
		panel_2.add(label_8);
		
		JPanel panel_3 = new JPanel(null);
		panel_3.setBorder(BorderFactory.createLineBorder(Color.gray));//设置面板边框颜色
		panel_3.setBounds(0, 210, 646, 138);
		panel.add(panel_3);
		
		JLabel label_22 = new JLabel("\u6C7D\u6CB9\u8D39\uFF1A");
		label_22.setBounds(33, 10, 54, 15);
		panel_3.add(label_22);
		
		Gas_Fee = new JTextField();
		Gas_Fee.setHorizontalAlignment(SwingConstants.RIGHT);
		Gas_Fee.setBounds(93, 7, 79, 21);
		panel_3.add(Gas_Fee);
		Gas_Fee.setColumns(10);
		
		JLabel label_23 = new JLabel("\u4EE3\u9A7E\u8D39\uFF1A");
		label_23.setBounds(194, 10, 54, 15);
		panel_3.add(label_23);
		
		Daijia_Fee = new JTextField();
		Daijia_Fee.setHorizontalAlignment(SwingConstants.RIGHT);
		Daijia_Fee.setBounds(247, 7, 75, 21);
		panel_3.add(Daijia_Fee);
		Daijia_Fee.setColumns(10);
		
		JLabel label_24 = new JLabel("\u8D85\u4FDD\u517B\u8D39\uFF1A");
		label_24.setBounds(332, 10, 66, 15);
		panel_3.add(label_24);
		
		Chaobaoyang_Fee = new JTextField();
		Chaobaoyang_Fee.setHorizontalAlignment(SwingConstants.RIGHT);
		Chaobaoyang_Fee.setBounds(396, 7, 79, 21);
		panel_3.add(Chaobaoyang_Fee);
		Chaobaoyang_Fee.setColumns(10);
		
		JLabel label_25 = new JLabel("\u8FDD\u7EA6\u91D1\uFF1A");
		label_25.setBounds(505, 10, 54, 15);
		panel_3.add(label_25);
		
		Weiyuejin = new JTextField();
		Weiyuejin.setHorizontalAlignment(SwingConstants.RIGHT);
		Weiyuejin.setBounds(558, 7, 66, 21);
		panel_3.add(Weiyuejin);
		Weiyuejin.setColumns(10);
		
		JLabel label_26 = new JLabel("\u4FEE\u7406\u8D39\uFF1A");
		label_26.setBounds(33, 40, 54, 15);
		panel_3.add(label_26);
		
		Repair_Fee = new JTextField();
		Repair_Fee.setHorizontalAlignment(SwingConstants.RIGHT);
		Repair_Fee.setBounds(93, 38, 78, 21);
		panel_3.add(Repair_Fee);
		Repair_Fee.setColumns(10);
		
		JLabel label_27 = new JLabel("\u4FDD\u9669\u8D39\uFF1A");
		label_27.setBounds(194, 40, 54, 15);
		panel_3.add(label_27);
		
		Baoxian_Fee = new JTextField();
		Baoxian_Fee.setHorizontalAlignment(SwingConstants.RIGHT);
		Baoxian_Fee.setBounds(247, 38, 75, 21);
		panel_3.add(Baoxian_Fee);
		Baoxian_Fee.setColumns(10);
		
		JLabel label_28 = new JLabel("\u8F66\u635F\u8D39\uFF1A");
		label_28.setBounds(342, 40, 54, 15);
		panel_3.add(label_28);
		
		Chesun_Fee = new JTextField();
		Chesun_Fee.setHorizontalAlignment(SwingConstants.RIGHT);
		Chesun_Fee.setBounds(396, 38, 79, 21);
		panel_3.add(Chesun_Fee);
		Chesun_Fee.setColumns(10);
		
		JLabel label_29 = new JLabel("\u6E05\u6D01\u8D39\uFF1A");
		label_29.setBounds(505, 40, 54, 15);
		panel_3.add(label_29);
		
		Clean_Fee = new JTextField();
		Clean_Fee.setHorizontalAlignment(SwingConstants.RIGHT);
		Clean_Fee.setBounds(558, 38, 66, 21);
		panel_3.add(Clean_Fee);
		Clean_Fee.setColumns(10);
		
		JLabel label_30 = new JLabel("\u8FD0\u8F66\u8D39\uFF1A");
		label_30.setBounds(33, 76, 54, 15);
		panel_3.add(label_30);
		
		Yunche_Fee = new JTextField();
		Yunche_Fee.setHorizontalAlignment(SwingConstants.RIGHT);
		Yunche_Fee.setBounds(93, 73, 79, 21);
		panel_3.add(Yunche_Fee);
		Yunche_Fee.setColumns(10);
		
		JLabel label_31 = new JLabel("\u62C6\u88C5\u8D54\u507F\u8D39\uFF1A");
		label_31.setFont(new Font("黑体", Font.PLAIN, 12));
		label_31.setBounds(175, 76, 73, 15);
		panel_3.add(label_31);
		
		Chaizhuang_Fee = new JTextField();
		Chaizhuang_Fee.setHorizontalAlignment(SwingConstants.RIGHT);
		Chaizhuang_Fee.setBounds(247, 73, 75, 21);
		panel_3.add(Chaizhuang_Fee);
		Chaizhuang_Fee.setColumns(10);
		
		JLabel label_32 = new JLabel("\u5F02\u5730\u8FD8\u8F66\uFF1A");
		label_32.setBounds(332, 76, 66, 15);
		panel_3.add(label_32);
		
		Yidihuanche_Fee = new JTextField();
		Yidihuanche_Fee.setHorizontalAlignment(SwingConstants.RIGHT);
		Yidihuanche_Fee.setBounds(396, 73, 79, 21);
		panel_3.add(Yidihuanche_Fee);
		Yidihuanche_Fee.setColumns(10);
		
		JLabel label_33 = new JLabel("\u5176\u4ED6\u6536\u8D39\uFF1A");
		label_33.setBounds(493, 76, 66, 15);
		panel_3.add(label_33);
		
		Other_Fee = new JTextField();
		Other_Fee.setHorizontalAlignment(SwingConstants.RIGHT);
		Other_Fee.setBounds(558, 73, 66, 21);
		panel_3.add(Other_Fee);
		Other_Fee.setColumns(10);
		
		JLabel label_34 = new JLabel("\u966A\u7EC3\u8D39\uFF1A");
		label_34.setBounds(33, 113, 54, 15);
		panel_3.add(label_34);
		
		Peilian_Fee = new JTextField();
		Peilian_Fee.setHorizontalAlignment(SwingConstants.RIGHT);
		Peilian_Fee.setBounds(93, 110, 79, 21);
		panel_3.add(Peilian_Fee);
		Peilian_Fee.setColumns(10);
		
		JLabel label_35 = new JLabel("\u9644\u52A0\u8D39\u5C0F\u8BA1\uFF1A");
		label_35.setBounds(480, 105, 84, 21);
		panel_3.add(label_35);
		
		Fujia_Fee = new JTextField();
		Fujia_Fee.setHorizontalAlignment(SwingConstants.RIGHT);
		Fujia_Fee.setBounds(558, 104, 66, 21);
		panel_3.add(Fujia_Fee);
		Fujia_Fee.setColumns(10);
		
		JPanel textField6 = new JPanel(null);
		textField6.setBorder(BorderFactory.createLineBorder(Color.gray));//设置面板边框颜色
		textField6.setBounds(0, 346, 646, 132);
		panel.add(textField6);
		
		JLabel label_36 = new JLabel("\u5E94\u6536\u91D1\u989D\uFF1A");
		label_36.setBounds(19, 10, 65, 15);
		textField6.add(label_36);
		
		Yingshou_Jine = new JTextField();
		Yingshou_Jine.setHorizontalAlignment(SwingConstants.RIGHT);
		Yingshou_Jine.setBounds(94, 7, 78, 21);
		textField6.add(Yingshou_Jine);
		Yingshou_Jine.setColumns(10);
		
		JLabel label_37 = new JLabel("\u5B9E\u6536\u91D1\u989D\uFF1A");
		label_37.setBounds(189, 10, 65, 15);
		textField6.add(label_37);
		
		Shishou_Jine = new JTextField();
		Shishou_Jine.setHorizontalAlignment(SwingConstants.RIGHT);
		Shishou_Jine.setBounds(249, 7, 73, 21);
		textField6.add(Shishou_Jine);
		Shishou_Jine.setColumns(10);
		
		Yingshou_Zhangkuan = new JTextField();
		Yingshou_Zhangkuan.setHorizontalAlignment(SwingConstants.RIGHT);
		Yingshou_Zhangkuan.setBounds(398, 7, 78, 21);
		textField6.add(Yingshou_Zhangkuan);
		Yingshou_Zhangkuan.setColumns(10);
		
		JLabel label_38 = new JLabel("\u5E94\u9000\u91D1\u989D\uFF1A");
		label_38.setBounds(494, 10, 65, 15);
		textField6.add(label_38);
		
		Yingtui_Zhangkuan = new JTextField();
		Yingtui_Zhangkuan.setHorizontalAlignment(SwingConstants.RIGHT);
		Yingtui_Zhangkuan.setBounds(558, 7, 65, 21);
		textField6.add(Yingtui_Zhangkuan);
		Yingtui_Zhangkuan.setColumns(10);
		
		JLabel label_39 = new JLabel("\u7ED3\u7B97\u4EBA\uFF1A");
		label_39.setBounds(29, 41, 54, 15);
		textField6.add(label_39);
		
		
		
		JLabel label_41 = new JLabel("\u4EA4\u6B3E\u4EBA\uFF1A");
		label_41.setBounds(200, 41, 54, 15);
		textField6.add(label_41);
		
		jiaokuanren = new JTextField();
		jiaokuanren.setEnabled(false);
		jiaokuanren.setBounds(249, 38, 73, 21);
		textField6.add(jiaokuanren);
		jiaokuanren.setColumns(10);
		
		JLabel label_42 = new JLabel("...\u6536\u6B3E\u65E5\u671F\uFF1A");
		label_42.setBounds(324, 41, 78, 15);
		textField6.add(label_42);
		
		JLabel label_40 = new JLabel("...");
		label_40.setBounds(184, 41, 31, 15);
		textField6.add(label_40);
		
		JLabel label_43 = new JLabel("...\u652F\u7968\u53F7\uFF1A");
		label_43.setBounds(491, 41, 78, 15);
		textField6.add(label_43);
		
		Shoukuang_Date = new JTextField();
		Shoukuang_Date.setHorizontalAlignment(SwingConstants.LEFT);
		Shoukuang_Date.setBounds(398, 38, 78, 21);
		Shoukuang_Date.addMouseListener(new MouseAdapter() {
	    	  public void mousePressed(MouseEvent e){
	    		 test(Shoukuang_Date,textField6);
	    	  }
		});		
		textField6.add(Shoukuang_Date);
		Shoukuang_Date.setColumns(10);
		
		Zhipiao_Id = new JTextField();
		Zhipiao_Id.setBounds(558, 38, 65, 21);
		textField6.add(Zhipiao_Id);
		Zhipiao_Id.setColumns(10);
		
		JLabel label_44 = new JLabel("\u5907\u6CE8\uFF1A");
		label_44.setBounds(42, 66, 54, 15);
		textField6.add(label_44);
		
		Demo = new JTextField();
		Demo.setBounds(94, 66, 529, 56);
		textField6.add(Demo);
		Demo.setColumns(10);
		//下拉框
		Jiesuanren = new JComboBox();
		Jiesuanren.addItem(" ");
		Jiesuanren.addItem("皮皮");
		Jiesuanren.addItem("皮小皮");
		Jiesuanren.addItem("李时珍皮");
		Jiesuanren.setBounds(94, 38, 78, 21);
		textField6.add(Jiesuanren);
		
		JLabel label_47 = new JLabel("\u5E94\u6536\u8D26\u6B3E\uFF1A");
		label_47.setBounds(332, 10, 78, 15);
		textField6.add(label_47);
		
		JCheckBox checkBox_1 = new JCheckBox("\u81EA\u52A8\u8BA1\u7B97");
		checkBox_1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			});
		checkBox_1.setBounds(675, 65, 89, 23);
		panel.add(checkBox_1);
		
		JPanel panel_5 = new JPanel(null);
		panel_5.setBorder(BorderFactory.createLineBorder(Color.gray));//设置面板边框颜色
		panel_5.setBounds(0, 482, 774, 20);
		panel.add(panel_5);
		
		JLabel label_45 = new JLabel("\u5982\u679C\u8D26\u6B3E\u5DF2\u7ECF\u7ED3\u6E05\uFF0C\u8BF7\u9009\u62E9\u8D26\u6B3E\u7ED3\u6E05\uFF01");
		label_45.setBounds(10, 1, 269, 15);
		panel_5.add(label_45);
		
		JButton print = new JButton("\u6253\u5370\u7ED3\u7B97\u5355");
		print.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
//				int i=1;
//				if(carList.isEmpty()){
//					JOptionPane.showMessageDialog(CarSettlement.this, "数据为空！");
//				}else{
					int i=0;
				    int n=0;
				    int j=0;
				    HSSFCell cell;				    
					// 第一步，创建一个webbook，对应一个Excel文件
			        HSSFWorkbook wb = new HSSFWorkbook();
			        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
			        HSSFSheet sheet = wb.createSheet("表一");
			        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
			        HSSFRow row = sheet.createRow((int) 0);
//			        // 创建单元格，并设置值表头 设置表头居中
//			        HSSFCellStyle style = wb.createCellStyle();
//			        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
			       
			        Car_settlement car=new Car_settlement();
			        java.lang.reflect.Field[] fields = params.getClass().getDeclaredFields();
					for (java.lang.reflect.Field field : fields)
					{
						field.setAccessible(true);
						String rsVal = field.getName();
						cell = row.createCell(i);
						cell.setCellValue(rsVal);
						i++;
					}
					JFileChooser jfc = new JFileChooser();
			         FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel文件(*.xls)", "xls");
			         jfc.setFileFilter(filter);
			         int option = jfc.showSaveDialog(CarSettlement.this);
			         if (option == JFileChooser.APPROVE_OPTION) {
			             File file = jfc.getSelectedFile();
			             String fname = jfc.getName(file);   //从文件名输入框中获取文件名
					// 第四步，创建单元格，并设置值
//					Iterator it = carList.iterator();
//			         while(it.hasNext())
			         {  
			        	row = sheet.createRow(n+1);			        	 
			        	int m=0;			            
//			            CarSettlement carInf = (CarSettlement)it.next();
			            for (java.lang.reflect.Field field1 : params.getClass().getDeclaredFields())
						{
			            	field1.setAccessible(true);
			            	try {
			            		row.createCell(m).setCellValue(field1.get(params)+"");
							} catch (IllegalArgumentException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IllegalAccessException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			            	m++;
						}
			            n++;
			         }
			         
			            
			             //假如用户填写的文件名不带我们制定的后缀名，那么我们给它添上后缀
			             if (fname.indexOf(".xls") == -1) {
			                 file = new File(jfc.getCurrentDirectory(), fname + ".xls");
			             }
			             try {
			                 FileOutputStream fout = new FileOutputStream(file);
			                 wb.write(fout);
			                 fout.close();
			             } catch (IOException e1) {
			                 e1.printStackTrace();
			             }
			         }
				}
//			}
		});

		print.setBounds(662, 272, 108, 23);
		panel.add(print);
		
		JButton desion = new JButton("\u8BBE\u8BA1\u7ED3\u7B97\u5355");
		desion.setBounds(662, 307, 108, 23);
		panel.add(desion);
		
		JButton count = new JButton("\u8BA1\u7B97 \uFF08C\uFF09");
		count.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count_settlement(Integer.parseInt(Inner_id.getText()));
				
			}
		});
		count.setBounds(662, 340, 108, 23);
		panel.add(count);
		
		JButton save = new JButton("\u5B58\u76D8 \uFF08S\uFF09");
		save.setBounds(662, 373, 108, 23);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save_settlement();				
			}
		});
		panel.add(save);
		
		JButton cannel = new JButton("\u53D6\u6D88 \uFF08C\uFF09");
		cannel.setBounds(662, 406, 108, 23);
		cannel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initDate();				
			}
		});
		panel.add(cannel);
		
		JButton exit = new JButton("\u8FD4\u56DE \uFF08R\uFF09");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				CarSettlement.this.dispose(); // 仅关闭当前窗口，如果该窗口是最后一个窗口，则程序退出				
			}
		});
		exit.setBounds(662, 439, 108, 23);
		panel.add(exit);		

		setTitle("汽车租赁结算单编辑");
		//退出框
		 this.addWindowListener(new WindowAdapter()  
         {  
            public void windowClosing(WindowEvent e)  
             {                    
                 closeFrame();  
             }              
         });  

	}
    protected void closeFrame() {
		// TODO Auto-generated method stub
    	int result = JOptionPane.showConfirmDialog(null, "是否要退出？", "退出确认", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);  
        if (result == JOptionPane.YES_OPTION)  
            this.dispose();  
        else ;

	}

	//存盘功能 插入到数据库
	protected void save_settlement() {
		// TODO Auto-generated method stub
		

		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss " );		
		String str = sdf.format(new Date()); 		
		
		params.setCustomer_Name(lin2(Customer_Name.getText()));		
        params.setCar_Id(lin2(Car_Id.getText()));
        
        params.setPre_Zujin(Integer.parseInt(lin(Pre_Zujin.getText()))); 
        
        params.setOutTime_Fee1(Integer.parseInt(lin(OutTime_Fee1.getText())));
        
        params.setYanjin(Integer.parseInt(lin(Yanjin.getText()))); 
        
        params.setXianshi_licheng(Integer.parseInt(lin(Xianshi_licheng.getText())));
        
        params.setZulin_Price(Integer.parseInt(lin(Zulin_Price.getText())));
        
        params.setChaoshi_Fee1(Integer.parseInt(lin(Chaoshi_Fee1.getText()))); 
        
        
        java.util.Date da=new java.util.Date();//取当前时间
        SimpleDateFormat sf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");        //转换时间格式
        String formatDa = sf.format(da);//
        params.setFache_Date( Timestamp.valueOf(formatDa));
        
        params.setDriver(lin2(Driver.getText()));
        params.setStart_Licheng(Integer.parseInt(lin(Start_Licheng.getText()))); 
       
        params.setInner_id(lin2(Inner_id.getText()));        
        
        java.util.Date da1=new java.util.Date();//取当前时间
        SimpleDateFormat sf1 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");        //转换时间格式
        String formatDa1 = sf1.format(da1);//
        params.setShouche_Date( Timestamp.valueOf(formatDa1));       
        
        java.util.Date da2=new java.util.Date();//取当前时间
        SimpleDateFormat sf2 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");        //转换时间格式
        String formatDa2 = sf2.format(da2);//
        params.setShouche_Time( Timestamp.valueOf(formatDa2));
        
        params.setZulin_Qixian(Integer.parseInt(lin(Zulin_Qixian.getText()))); 
        
        params.setYingshou_Zujin(Integer.parseInt(lin(Yingshou_Zujin.getText())));        
        params.setEnd_Licheng(Integer.parseInt(lin(End_Licheng.getText())));        
        params.setChaoshi_Licheng(Integer.parseInt(lin(Chaoshi_Licheng.getText())));        
        params.setChaoshi_Fee(Integer.parseInt(lin(Chaoshi_Fee.getText())));        
        params.setBaogangjia(Integer.parseInt(lin(Baogangjia.getText())));        
        params.setChaoshi_Hour(Integer.parseInt(lin(Chaoshi_Hour.getText())));        
        params.setOutTime_Fee(Integer.parseInt(lin(OutTime_Fee.getText())));        
        params.setXiaoji_Fee(Integer.parseInt(lin(Xiaoji_Fee.getText())));        
        params.setGas_Fee(Integer.parseInt(lin(Gas_Fee.getText())));        
        params.setDaijia_Fee(Integer.parseInt(lin(Daijia_Fee.getText())));        
        params.setChaobaoyang_Fee(Integer.parseInt(lin(Chaobaoyang_Fee.getText())));        
        params.setWeiyuejin(Integer.parseInt(lin(Weiyuejin.getText())));        
        params.setRepair_Fee(Integer.parseInt(lin(Repair_Fee.getText())));        
        params.setBaoxian_Fee(Integer.parseInt(lin(Baoxian_Fee.getText())));        
        params.setChesun_Fee(Integer.parseInt(lin(Chesun_Fee.getText())));        
        params.setClean_Fee(Integer.parseInt(lin(Clean_Fee.getText())));        
        params.setYunche_Fee(Integer.parseInt(lin(Yunche_Fee.getText())));        
        params.setChaizhuang_Fee(Integer.parseInt(lin(Chaizhuang_Fee.getText())));        
        params.setYidihuanche_Fee(Integer.parseInt(lin(Yidihuanche_Fee.getText())));        
        params.setOther_Fee(Integer.parseInt(lin(Other_Fee.getText())));        
        params.setPeilian_Fee(Integer.parseInt(lin(Peilian_Fee.getText())));        
        params.setFujia_Fee(Integer.parseInt(lin(Fujia_Fee.getText())));        
        params.setYingshou_Jine(Double.parseDouble(lin(Yingshou_Jine.getText())));        
        params.setShishou_Jine(Double.parseDouble(lin(Shishou_Jine.getText())));        
        params.setYingshou_Zhangkuan(Double.parseDouble(lin(Yingshou_Zhangkuan.getText())));        
        params.setYingtui_Zhangkuan(Double.parseDouble(lin(Yingtui_Zhangkuan.getText())));        
        params.setJiesuanren(String.valueOf(Jiesuanren.getSelectedItem()));        
        params.setJiaokuanren(lin2(jiaokuanren.getText()));         
        
        java.util.Date da3=new java.util.Date();//取当前时间
        SimpleDateFormat sf3 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");        //转换时间格式
        String formatDa3 = sf3.format(da3);//
        params.setShoukuan_Date(Timestamp.valueOf(formatDa3));
        
        params.setZhipiao_Id(Zhipiao_Id.getText());
        params.setDemo(Demo.getText());			
        int row = new CommonDAOImpl().add3(params);		   
		if(row>0) {
			JOptionPane.showMessageDialog(jPanel, "存盘成功", "标题",JOptionPane.WARNING_MESSAGE);  
		}
		else JOptionPane.showMessageDialog(jPanel, "存盘失败", "标题",JOptionPane.WARNING_MESSAGE);
	}
    

	//取消功能    清空
	protected void initDate() {
		// TODO Auto-generated method stub	
		int n = JOptionPane.showConfirmDialog(null, "确定要清空吗？", "标题",JOptionPane.YES_NO_OPTION);//返回的是按钮的index  i=0或者1  
		if(n==0)
		{
		Customer_Name.setText("");		
		Car_Id.setText("");
		Pre_Zujin.setText("");			
		OutTime_Fee1.setText("");
		Yanjin.setText("");
		Xianshi_licheng.setText("");
		Zulin_Price.setText("");
		Chaoshi_Fee1.setText("");
		Fache_Date.setText("");
		Driver.setText("");
		Start_Licheng.setText("");
		Inner_id.setText("");
		Shouche_Date.setText("");
		Shouche_Time.setText("");
		Zulin_Qixian.setText("");
		Yingshou_Zujin.setText("");
		End_Licheng.setText("");
		Chaoshi_Licheng.setText("");
		Chaoshi_Fee.setText("");
		Baogangjia.setText("");
		Chaoshi_Hour.setText("");		
		OutTime_Fee.setText("");
		Xiaoji_Fee.setText("");
		Gas_Fee.setText("");
		Daijia_Fee.setText("");
		Chaobaoyang_Fee.setText("");
		Weiyuejin.setText("");
		Repair_Fee.setText("");
		Baoxian_Fee.setText("");
		Chesun_Fee.setText("");
		Clean_Fee.setText("");
		Yunche_Fee.setText("");
		Chaizhuang_Fee.setText("");
		Yidihuanche_Fee.setText("");
		Other_Fee.setText("");
		Peilian_Fee.setText("");
		Fujia_Fee.setText("");
		Yingshou_Jine.setText("");
		Shishou_Jine.setText("");
		Yingshou_Zhangkuan.setText("");
		Yingtui_Zhangkuan.setText("");
		Jiesuanren.setSelectedItem(" ");
		jiaokuanren.setText("");
		Shoukuang_Date.setText("");
		Zhipiao_Id.setText("");
		Demo.setText("");
		}
		
	}

    //搜索第四张表的数据  计算
	protected void count_settlement(int id) {
		// TODO Auto-generated method stub
		List<Object> params = new ArrayList<>();
		params.add(id);			
		List<CustZL> carList =new CommonDAOImpl().executeQuery(CustZL.class, "SELECT * FROM tb_cust_zl WHERE Inner_Id=?", params);
		if (carList.size() >0) {			
			CustZL car = carList.get(0);
			// 绑定数据
			Customer_Name.setText(car.getCustomer_Name()+"");
			Car_Id.setText(car.getCar_Id()+"");
			Pre_Zujin.setText(car.getPre_Zujin()+"");
			OutTime_Fee1.setText(car.getOutTime_Fee()+"");
			Yanjin.setText(car.getYanjin() + "");
			Xianshi_licheng.setText(car.getLicheng_Meitian() + "");
			Zulin_Price.setText(car.getZulin_Price() + "");
			Chaoshi_Fee1.setText(car.getChaoshi_Fee() + "");
			Fache_Date.setText(car.getFache_Date().toString());
			Driver.setText(car.getDriver()+"");
			Start_Licheng.setText(car.getStart_Licheng() + "");
			Zulin_Qixian.setText(car.getZulin_Qixian()+"");
			Demo.setText(car.getDemo()+"");
			Jiesuanren.addItem(car.getJinbanren()+"");
			Jiesuanren.setSelectedItem(car.getJinbanren()+"");
			
			int i=count();
			
			
			if(i==0) JOptionPane.showMessageDialog(jPanel, "计算正确", "标题",JOptionPane.WARNING_MESSAGE);
			else ;
		} else {
			JOptionPane.showMessageDialog(CarSettlement.this, "没有这个编号");
		}	
	}
	//日历调用
	public  void test(JTextField t,JPanel p) {			        
	        t.setText("1900-01-01"); 
	        Chooser ser = Chooser.getInstance("yyyy-MM-dd");        
	        ser.register(t);        
	        p.add(t);	        
	        p.setVisible(true);        
    }
	//计算方法
	public int count()
	{	
		int i=0;
		int j=0;
		Regex r =new Regex();
        int flag=1;		
		Baogangjia.setText(lin(Baogangjia.getText()));
		 if(r.isAllNum(Baogangjia.getText())) ;
	        else j=1;		
		
		Gas_Fee.setText(lin(Gas_Fee.getText()));
		 if(r.isAllNum(Gas_Fee.getText())) ;
	        else j=1;
		Daijia_Fee.setText(lin(Daijia_Fee.getText()));
		 if(r.isAllNum(Daijia_Fee.getText())) ;
		 	else j=1;
		Chaobaoyang_Fee.setText(lin(Chaobaoyang_Fee.getText()));
		 if(r.isAllNum(Chaobaoyang_Fee.getText())) ;
		 	else j=1;
		Weiyuejin.setText(lin(Weiyuejin.getText()));
		 if(r.isAllNum(Weiyuejin.getText())) ;
		 	else j=1;
		Repair_Fee.setText(lin(Repair_Fee.getText()));
		 if(r.isAllNum(Repair_Fee.getText())) ;
		 	else j=1;
		Baoxian_Fee.setText(lin(Baoxian_Fee.getText()));
		 if(r.isAllNum(Baoxian_Fee.getText())) ;
		 	else j=1;
		Chesun_Fee.setText(lin(Chesun_Fee.getText()));
		 if(r.isAllNum(Chesun_Fee.getText())) ;
		 	else j=1;
		Clean_Fee.setText(lin(Clean_Fee.getText()));
		 if(r.isAllNum(Clean_Fee.getText())) ;
		 	else j=1;
		Yunche_Fee.setText(lin(Yunche_Fee.getText()));
		 if(r.isAllNum(Yunche_Fee.getText())) ;
		 	else j=1;
		Chaizhuang_Fee.setText(lin(Chaizhuang_Fee.getText()));
		 if(r.isAllNum(Chaizhuang_Fee.getText())) ;
		 	else j=1;
		Yidihuanche_Fee.setText(lin(Yidihuanche_Fee.getText()));
		 if(r.isAllNum(Yidihuanche_Fee.getText())) ;
		 	else j=1;
		Other_Fee.setText(lin(Other_Fee.getText()));
		 if(r.isAllNum(Other_Fee.getText())) ;
		 	else j=1;
		Peilian_Fee.setText(lin(Peilian_Fee.getText()));
		 if(r.isAllNum(Peilian_Fee.getText())) ;
		 	else j=1;
		Shishou_Jine.setText(lin(Shishou_Jine.getText()));
		 if(r.isAllNum(Shishou_Jine.getText())) ;
		 	else j=1; 
		 if(j==1) 
			{
			JOptionPane.showMessageDialog(jPanel, "输入不能为负值且类型为整型", "标题",JOptionPane.WARNING_MESSAGE);
			return 1;
			}
		 if(End_Licheng.getText().equals(""))
		 {
				JOptionPane.showMessageDialog(jPanel, "收车里程不能为空", "标题",JOptionPane.WARNING_MESSAGE);
				return 1;
				}
		 Chaoshi_Licheng.setText(Integer.valueOf(End_Licheng.getText())
					-Integer.valueOf(Start_Licheng.getText())
					-Integer.valueOf(Xianshi_licheng.getText())
					*Integer.valueOf(Zulin_Qixian.getText())+"");
			//收车里程比发车里程小报错
			if(Double.valueOf(End_Licheng.getText())<Double.valueOf(Start_Licheng.getText()))
			{
				JOptionPane.showMessageDialog(contentPane, "请填写正确收车里程", "消息提示",JOptionPane.WARNING_MESSAGE);
				i=1;
			}         
			
			Chaoshi_Fee.setText(Integer.valueOf(Chaoshi_Fee1.getText())
					*Integer.valueOf(Chaoshi_Licheng.getText())+"");
			
			Zulin_Price.setText(lin(Zulin_Price.getText()));
			Yingshou_Zujin.setText(Integer.valueOf(Zulin_Price.getText())
					*Integer.valueOf(Zulin_Qixian.getText())+"");
			
			   String str = Fache_Date.getText();  
			   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
			   java.sql.Date sdate = null; //初始化 
			   try {  
			       java.util.Date udate = sdf.parse(str);  
			       sdate = new java.sql.Date(udate.getTime());   
			   } catch (ParseException e) {  
			       e.printStackTrace();  
			   }
			   
			   String str2 = Shouche_Date.getText();  
			   SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");  
			   java.sql.Date sdate2 = null; //初始化 
			   try {  
			       java.util.Date udate2 = sdf2.parse(str2);  
			       sdate2 = new java.sql.Date(udate2.getTime());   
			   } catch (ParseException e) {  
				   JOptionPane.showMessageDialog(contentPane, "请填写收车日期", "消息提示",JOptionPane.WARNING_MESSAGE); 
				   i=1;
			   }		   
			 if((getIntervalDays(sdate, sdate2)>Integer.valueOf(Zulin_Qixian.getText())))
					 {
				 		if(getIntervalDays(sdate, sdate2)>1)
				 		{
				 			Chaoshi_Hour.setText((getIntervalDays(sdate, sdate2)-2)*24+(Integer.valueOf(Shouche_Time.getText().substring(0,2)))+24+"");
				 		}
				 		else Chaoshi_Hour.setText(Shouche_Time.getText().substring(0,2));
					 }		 
			 else Chaoshi_Hour.setText("0");      
	        
	        
		OutTime_Fee.setText(Integer.valueOf(Chaoshi_Hour.getText())
				*Integer.valueOf(OutTime_Fee1.getText())+""); 
		Xiaoji_Fee.setText(Integer.valueOf(Chaoshi_Fee.getText())
				+Integer.valueOf(Yingshou_Zujin.getText())
				+Integer.valueOf(Baogangjia.getText())
				+Integer.valueOf(OutTime_Fee.getText())+"");
		Fujia_Fee.setText(Integer.valueOf(Gas_Fee.getText())
				+Integer.valueOf(Daijia_Fee.getText())
				+Integer.valueOf(Chaobaoyang_Fee.getText())
				+Integer.valueOf(Weiyuejin.getText())
				+Integer.valueOf(Repair_Fee.getText())
				+Integer.valueOf(Baoxian_Fee.getText())
				+Integer.valueOf(Chesun_Fee.getText())
				+Integer.valueOf(Clean_Fee.getText())
				+Integer.valueOf(Yunche_Fee.getText())
				+Integer.valueOf(Chaizhuang_Fee.getText())
				+Integer.valueOf(Yidihuanche_Fee.getText())
				+Integer.valueOf(Other_Fee.getText())
				+Integer.valueOf(Peilian_Fee.getText())+"");
		
		Yingshou_Jine.setText(Double.valueOf(Xiaoji_Fee.getText())
				+Integer.valueOf(Fujia_Fee.getText())+"");
		
        
		Shishou_Jine.setText(lin(Shishou_Jine.getText()));		
		
		Yingshou_Zhangkuan.setText(Double.valueOf(Shishou_Jine.getText())
				>Double.valueOf(Yingshou_Jine.getText())
				?"0":(Double.valueOf(Yingshou_Jine.getText())
				-Double.valueOf(Shishou_Jine.getText())+""));
		Yingtui_Zhangkuan.setText(Double.valueOf(Yingshou_Jine.getText())
				>Double.valueOf(Shishou_Jine.getText())
				?"0":(Double.valueOf(Shishou_Jine.getText())
						-Double.valueOf(Yingshou_Jine.getText()))+"");

		if((Fache_Date.getText()).compareTo(Shouche_Date.getText())==1)
		{
			JOptionPane.showMessageDialog(contentPane, "请填写正确收车日期", "消息提示",JOptionPane.WARNING_MESSAGE);
			i=1;
		} 
		jiaokuanren.setText(Customer_Name.getText());
		Zhipiao_Id.setText(lin2(Zhipiao_Id.getText()));
		if((Shouche_Date.getText()).compareTo(Shoukuang_Date.getText())==1)
		{
			JOptionPane.showMessageDialog(contentPane, "请填写正确收款日期", "消息提示",JOptionPane.WARNING_MESSAGE);
			i=1;
		}  
		
		return i; 
		
	}
	//计算小时
	public int getIntervalDays(Date fDate, Date oDate) {
	       if (null == fDate || null == oDate) {
	           return -1;
	       }
	       long intervalMilli = oDate.getTime() - fDate.getTime();
	       return (int) (intervalMilli / (24 * 60 * 60 * 1000));

	    }

	private String lin2(String i) {
		// TODO Auto-generated method stub
    	if(i.equals("")) {i="null";return i;}
		else return i;
	}

	private String lin(String i) {
		// TODO Auto-generated method stub
		if(i.equals("")) {i="0";return i;}
		else if(i.compareTo("0")==1&&(i.compareTo("9999")==-1)) {i="-1";return i;}
		else return i;
	}
}

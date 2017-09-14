package com.company.ui;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

import com.company.dao.CommonDAOImpl;
import com.company.entity.CarInformation;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class CarService extends JDialog {
	private JPanel panel;
	private JTextField serviceId; // 维修单号
	private JTextField serviceLocation; // 维修地点

	private JComboBox licenseNumberComboBox; // 车牌号码
	private JComboBox serviceStatusComboBox; // 维修状态

	private JSpinner sTimeSpinner; // 开始维修时间
	private JSpinner eTimeSpinner; // 结束维修时间

	Date today = new Date(System.currentTimeMillis());

	com.company.entity.CarService serDao = new com.company.entity.CarService();
	CommonDAOImpl comDao = new CommonDAOImpl();

	public CarService() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/logo.png"));
		initFrame();
		initBody();
		getContentPane().add(panel);
	}

	public void initBody() {
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);// 指定为空布局
		panel.setBounds(0, 0, 664, 452);
		button();
		showInf();
	}

	public void button() {
		JButton button = new JButton("打印档案");
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		//button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Properties p = new Properties();
//				PrintJob jp = Toolkit.getDefaultToolkit().getPrintJob(CarService.this, "客户登记表编辑", p);
//				Graphics pg = jp.getGraphics();// Graphics打印图形的图形环境
//				if (pg != null) {
//					try {
//						CarService.this.printAll(pg); // 打印该窗体及其所有的组件
//					} finally {
//						pg.dispose(); // 注销图形环境
//					}
//				}
//				jp.end(); // 结束打印作业
//			}
		//});
		button.setBounds(472, 20, 120, 45);
		panel.add(button);

		JButton addButton = new JButton("增加");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comDao.searchClo(serviceId.getText(), "tb_service", "Service_Id")) {
					JOptionPane.showMessageDialog(CarService.this, "已有此维修单号，不能重复添加！");
				}else{
				new CommonDAOImpl().add2(getInfo(), "tb_service");
				JOptionPane.showMessageDialog(CarService.this, "添加成功！");
				}
			}
		});
		addButton.setFont(new Font("宋体", Font.PLAIN, 20));
		addButton.setBounds(472, 90, 120, 45);
		panel.add(addButton);

		JButton upDateButton = new JButton("更新");
		upDateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ((comDao.searchClo(serviceId.getText(), "tb_service", "Service_Id")) == false) {
					JOptionPane.showMessageDialog(CarService.this, "没有此订单，无法更新！");
				}else{
				new CommonDAOImpl().update2(getInfo(), "tb_service");
				JOptionPane.showMessageDialog(CarService.this, "更新成功！");
				}
			}
		});
		upDateButton.setFont(new Font("宋体", Font.PLAIN, 20));
		upDateButton.setBounds(472, 160, 120, 45);
		panel.add(upDateButton);

		JButton saveButton = new JButton("存盘");
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				saveASExcelWaringInf();
			}
		});
		saveButton.setFont(new Font("宋体", Font.PLAIN, 20));
		saveButton.setBounds(472, 230, 120, 45);
		panel.add(saveButton);

		JButton cancleButton = new JButton("取消");
		cancleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				serviceId.setText("");
				serviceLocation.setText("");
			}
		});
		cancleButton.setFont(new Font("宋体", Font.PLAIN, 20));
		cancleButton.setBounds(472, 300, 120, 45);
		panel.add(cancleButton);

		JButton returnButton = new JButton("返回");
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CarService.this.dispose();
			}
		});
		returnButton.setFont(new Font("宋体", Font.PLAIN, 20));
		returnButton.setBounds(472, 370, 120, 45);
		panel.add(returnButton);
	}

	public void showInf() {
		JLabel label = new JLabel("维修单号:");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(40, 30, 97, 24);
		panel.add(label);

		JLabel label_1 = new JLabel("车牌号码:");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(40, 100, 97, 24);
		panel.add(label_1);

		JLabel label_2 = new JLabel("维修地点:");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(40, 170, 97, 24);
		panel.add(label_2);

		JLabel label_3 = new JLabel("维修状态:");
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(40, 240, 97, 24);
		panel.add(label_3);

		JLabel label_4 = new JLabel("开始时间:");
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));
		label_4.setBounds(40, 310, 97, 24);
		panel.add(label_4);

		JLabel label_5 = new JLabel("结束时间:");
		label_5.setFont(new Font("宋体", Font.PLAIN, 20));
		label_5.setBounds(40, 380, 97, 24);
		panel.add(label_5);

		serviceId = new JTextField();
		serviceId.setBounds(147, 30, 257, 24);
		panel.add(serviceId);
		serviceId.setColumns(10);

		serviceLocation = new JTextField();
		serviceLocation.setColumns(10);
		serviceLocation.setBounds(147, 170, 257, 24);
		panel.add(serviceLocation);

		licenseNumberComboBox = new JComboBox();
		licenseNumberComboBox.setBounds(147, 99, 257, 24);
		List<CarInformation> List = new CommonDAOImpl().executeQuery(CarInformation.class,
				"SELECT * FROM tb_car where isBlockup = 1", null);
		for (CarInformation s : List) {
			licenseNumberComboBox.addItem(s.getCar_Id());
		}

		panel.add(licenseNumberComboBox);

		serviceStatusComboBox = new JComboBox();
		serviceStatusComboBox.setBounds(147, 240, 257, 24);
		serviceStatusComboBox.addItem("已修");
		serviceStatusComboBox.addItem("未修");
		panel.add(serviceStatusComboBox);

		sTimeSpinner = setJSpinner(sTimeSpinner, today, true);
		sTimeSpinner.setBounds(147, 310, 257, 24);
		panel.add(sTimeSpinner);

		eTimeSpinner = setJSpinner(eTimeSpinner, today, true);
		eTimeSpinner.setBounds(147, 380, 257, 24);
		panel.add(eTimeSpinner);
	}

	public void initFrame() {
		setSize(680, 490);
		setTitle("汽车维修编辑");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
//		try {
//			// UIManager.setLookAndFeel("com.whitenkov.darcula.DarculaLaf");
//			// DarculaLaf主题最后统一换
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (UnsupportedLookAndFeelException e) {
//			e.printStackTrace();
//		}
	}

	private com.company.entity.CarService getInfo() {
		com.company.entity.CarService tbser = new com.company.entity.CarService();
		tbser.setService_Id(serviceId.getText());
		tbser.setCar_Id((String) licenseNumberComboBox.getSelectedItem());
		tbser.setService_Location(serviceLocation.getText());
		tbser.setService_Status((String) serviceStatusComboBox.getSelectedItem());
		tbser.setWX_Starttime(new Timestamp(((Date) sTimeSpinner.getValue()).getTime()));
		tbser.setWX_Endtime(new Timestamp(((Date) eTimeSpinner.getValue()).getTime()));
		return tbser;
	}

	private JSpinner setJSpinner(JSpinner temp, Date tempDate, boolean isEditable) {
		SpinnerDateModel model = new SpinnerDateModel();
		temp = new JSpinner(model);
		temp.setValue(tempDate);
		JSpinner.DateEditor edit = new JSpinner.DateEditor(temp, "yyyy-MM-dd");
		edit.getTextField().setEditable(isEditable);
		DefaultFormatterFactory factory = (DefaultFormatterFactory) edit.getTextField().getFormatterFactory();
		DateFormatter formatter = (DateFormatter) factory.getDefaultFormatter();
		formatter.setAllowsInvalid(false);
		formatter.setOverwriteMode(true);
		temp.setEditor(edit);
		return temp;
	}

	private void saveASExcelWaringInf() {
		StringBuffer temp = new StringBuffer("将要导出数据库的全部信息，是否继续！！");
		int res = JOptionPane.showConfirmDialog(CarService.this, temp.toString(), "警告！", JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);
		if (res == JOptionPane.OK_OPTION) {			
				outputInf(saveInfo());		
		}
	}

   //存盘提示信息打印
	private void outputInf(int i) {
		switch (i) {
		case 0:
			JOptionPane.showMessageDialog(CarService.this, "导出成功！", "成功！", JOptionPane.WARNING_MESSAGE);
			break;
		case 1:
			JOptionPane.showMessageDialog(CarService.this, "导出失败！", "错误！", JOptionPane.ERROR_MESSAGE);
			break;
		default:
			break;
		}
	}
	
	public int saveInfo() {
		// 第一步，创建一个webbook,对应一个Excel文件
				HSSFWorkbook wb = new HSSFWorkbook();
				// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
				HSSFSheet sheet = wb.createSheet("汽车维修记录记录表");
				// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
				HSSFRow row = sheet.createRow((int) 0);
				// 第四步，创建单元格，并设置值表头 设置表头居中
				HSSFCellStyle style = wb.createCellStyle();
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 创建一个居中格式
				HSSFCell cell = row.createCell((short) 0);
				cell.setCellValue("维修单号");
				cell.setCellStyle(style);
				cell = row.createCell((short) 1);
				cell.setCellValue("车牌号码");
				cell.setCellStyle(style);
				cell = row.createCell((short) 2);
				cell.setCellValue("维修地点");
				cell.setCellStyle(style);
				cell = row.createCell((short) 3);
				cell.setCellValue("维修状态");
				cell.setCellStyle(style);
				cell = row.createCell((short) 4);
				cell.setCellValue("维修开始时间");
				cell.setCellStyle(style);
				cell = row.createCell((short) 5);
				cell.setCellValue("维修结束时间");
				cell.setCellStyle(style);
		// 存盘excel文件
		// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		// java.awt和java.util下都有list要声明正确
		List<com.company.entity.CarService> list = new CommonDAOImpl().executeQuery(com.company.entity.CarService.class,"select * from tb_service",null);
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow((int) i + 1);
			com.company.entity.CarService serInf = list.get(i);
			// 创建单元格，并设置值
			row.createCell(0).setCellValue(serInf.getService_Id());
			row.createCell(1).setCellValue(serInf.getCar_Id());
			row.createCell(2).setCellValue(serInf.getService_Location());
			row.createCell(3).setCellValue(serInf.getService_Status());
			row.createCell(4).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(serInf.getWX_Starttime()));
			row.createCell(5).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(serInf.getWX_Endtime()));
		}
		return saveFile(wb);
	}
	
	private int saveFile(HSSFWorkbook wb) {
		JFileChooser jfc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel文件(*.xls)", "xls");
		jfc.setFileFilter(filter);
		int option = jfc.showSaveDialog(CarService.this);
		if (option == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			String fname = jfc.getName(file); // 从文件名输入框中获取文件名
			// 假如用户填写的文件名不带我们制定的后缀名，那么我们给它添上后缀
			if (fname.indexOf(".xls") == -1) {
				file = new File(jfc.getCurrentDirectory(), fname + ".xls");
				// System.out.println("renamed");
				// System.out.println(file.getName());
			}
			try {
				FileOutputStream fout = new FileOutputStream(file);
				wb.write(fout);
				fout.close();
			} catch (IOException e1) {
				e1.printStackTrace();
				return 1;
			}
		} else if (option == JFileChooser.CANCEL_OPTION) {
			return 2;
		}
		return 0;
	}
}

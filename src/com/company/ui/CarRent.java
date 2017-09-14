package com.company.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.company.dao.newDAO.CommonDAO;
import com.company.dao.newDAO.CommonDAOImpl;
import com.company.entity.CarInformation;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CarRent extends JDialog {

	private JPanel contentPane;
	private JPanel panel1;
	private JPanel panel2;
	private JComboBox comboBox1;
	private JComboBox comboBox;
	private List<Object> carList = new ArrayList<>();

	/**
	 * Create the ui.
	 */
	public CarRent() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/logo.png"));
		setTitle("\u8F66\u8F86\u7EDF\u8BA1\u67E5\u8BE2");
		setSize(680, 490);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel1=new JPanel(null);
		panel1.setBorder(BorderFactory.createLineBorder(Color.gray));
		String[] s1={"小轿车","大卡车","中巴车"};
		comboBox1 = new JComboBox(s1);
		comboBox1.setBounds(80, 15, 130, 25);
		
		JLabel lblNewLabel = new JLabel("\u8F66\u578B\u9009\u62E9\uFF1A");
		lblNewLabel.setBounds(10, 0, 70, 55);
		panel1.add(lblNewLabel);
		
		panel1.setPreferredSize(lblNewLabel.getSize());
		panel1.add(comboBox1);
		contentPane.add(panel1,BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("\u72B6\u6001\u9009\u62E9\uFF1A");
		lblNewLabel_1.setBounds(270, 0, 70, 55);
		panel1.add(lblNewLabel_1);
		
		String[] s2={"停用中","使用中"};
		comboBox = new JComboBox(s2);
		comboBox.setBounds(340, 15, 130, 25);
		panel1.add(comboBox);
		
		JButton button=new JButton("查询");
		button.setBounds(0, 70,90, 100);
		
		JButton button1=new JButton("导出");
		button1.setBounds(0,230,90, 100);
		
		panel2=new JPanel(null);
		panel2.setBorder(BorderFactory.createLineBorder(Color.gray));
		panel2.add(button);
		panel2.add(button1);
		panel2.setPreferredSize(button.getSize());
		contentPane.add(panel2, BorderLayout.EAST);
		
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText(" ");
				String s1=(String)comboBox1.getSelectedItem();
				int s2=comboBox.getSelectedIndex();
				CommonDAO dao = new CommonDAOImpl();
				carList = dao.findByCondition(CarInformation.class, "SELECT * FROM tb_car WHERE Car_Type=? AND isBlockUp=?",s1,s2); //;
				if(carList.isEmpty()){
					JOptionPane.showMessageDialog(CarRent.this, "数据查询失败！");
				}else{
					 Iterator it = carList.iterator();
				          while(it.hasNext())
				          {
				        	  textArea.append(((CarInformation)it.next()).toString()+"\n");
				          }
				}
			}
		});

		button1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
//				int i=1;
				if(carList.isEmpty()){
					JOptionPane.showMessageDialog(CarRent.this, "数据为空！");
				}else{
					int i=0;
					int n=0;
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
					CarInformation car=new CarInformation();
					Field[] fields = CarInformation.class.getDeclaredFields();
					for (Field field : fields)
					{
						field.setAccessible(true);
						String rsVal = field.getName();
						cell = row.createCell(i);
						cell.setCellValue(rsVal);
						i++;
					}
					// 第四步，创建单元格，并设置值
					Iterator it = carList.iterator();
					while(it.hasNext())
					{
						int m=0;
						row = sheet.createRow(n + 1);
						CarInformation carInf = (CarInformation)it.next();
						for (Field field1 : carInf.getClass().getDeclaredFields())
						{
							field1.setAccessible(true);
							try {
								row.createCell(m).setCellValue(field1.get(carInf)+"");
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
					JFileChooser jfc = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel文件(*.xls)", "xls");
					jfc.setFileFilter(filter);
					int option = jfc.showSaveDialog(CarRent.this);
					if (option == JFileChooser.APPROVE_OPTION) {
						File file = jfc.getSelectedFile();
						String fname = jfc.getName(file);   //从文件名输入框中获取文件名
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
			}
		});


	}
}

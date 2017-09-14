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
	private JTextField serviceId; // ά�޵���
	private JTextField serviceLocation; // ά�޵ص�

	private JComboBox licenseNumberComboBox; // ���ƺ���
	private JComboBox serviceStatusComboBox; // ά��״̬

	private JSpinner sTimeSpinner; // ��ʼά��ʱ��
	private JSpinner eTimeSpinner; // ����ά��ʱ��

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
		panel.setLayout(null);// ָ��Ϊ�ղ���
		panel.setBounds(0, 0, 664, 452);
		button();
		showInf();
	}

	public void button() {
		JButton button = new JButton("��ӡ����");
		button.setFont(new Font("����", Font.PLAIN, 20));
		//button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Properties p = new Properties();
//				PrintJob jp = Toolkit.getDefaultToolkit().getPrintJob(CarService.this, "�ͻ��ǼǱ�༭", p);
//				Graphics pg = jp.getGraphics();// Graphics��ӡͼ�ε�ͼ�λ���
//				if (pg != null) {
//					try {
//						CarService.this.printAll(pg); // ��ӡ�ô��弰�����е����
//					} finally {
//						pg.dispose(); // ע��ͼ�λ���
//					}
//				}
//				jp.end(); // ������ӡ��ҵ
//			}
		//});
		button.setBounds(472, 20, 120, 45);
		panel.add(button);

		JButton addButton = new JButton("����");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comDao.searchClo(serviceId.getText(), "tb_service", "Service_Id")) {
					JOptionPane.showMessageDialog(CarService.this, "���д�ά�޵��ţ������ظ���ӣ�");
				}else{
				new CommonDAOImpl().add2(getInfo(), "tb_service");
				JOptionPane.showMessageDialog(CarService.this, "��ӳɹ���");
				}
			}
		});
		addButton.setFont(new Font("����", Font.PLAIN, 20));
		addButton.setBounds(472, 90, 120, 45);
		panel.add(addButton);

		JButton upDateButton = new JButton("����");
		upDateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ((comDao.searchClo(serviceId.getText(), "tb_service", "Service_Id")) == false) {
					JOptionPane.showMessageDialog(CarService.this, "û�д˶������޷����£�");
				}else{
				new CommonDAOImpl().update2(getInfo(), "tb_service");
				JOptionPane.showMessageDialog(CarService.this, "���³ɹ���");
				}
			}
		});
		upDateButton.setFont(new Font("����", Font.PLAIN, 20));
		upDateButton.setBounds(472, 160, 120, 45);
		panel.add(upDateButton);

		JButton saveButton = new JButton("����");
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				saveASExcelWaringInf();
			}
		});
		saveButton.setFont(new Font("����", Font.PLAIN, 20));
		saveButton.setBounds(472, 230, 120, 45);
		panel.add(saveButton);

		JButton cancleButton = new JButton("ȡ��");
		cancleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				serviceId.setText("");
				serviceLocation.setText("");
			}
		});
		cancleButton.setFont(new Font("����", Font.PLAIN, 20));
		cancleButton.setBounds(472, 300, 120, 45);
		panel.add(cancleButton);

		JButton returnButton = new JButton("����");
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CarService.this.dispose();
			}
		});
		returnButton.setFont(new Font("����", Font.PLAIN, 20));
		returnButton.setBounds(472, 370, 120, 45);
		panel.add(returnButton);
	}

	public void showInf() {
		JLabel label = new JLabel("ά�޵���:");
		label.setFont(new Font("����", Font.PLAIN, 20));
		label.setBounds(40, 30, 97, 24);
		panel.add(label);

		JLabel label_1 = new JLabel("���ƺ���:");
		label_1.setFont(new Font("����", Font.PLAIN, 20));
		label_1.setBounds(40, 100, 97, 24);
		panel.add(label_1);

		JLabel label_2 = new JLabel("ά�޵ص�:");
		label_2.setFont(new Font("����", Font.PLAIN, 20));
		label_2.setBounds(40, 170, 97, 24);
		panel.add(label_2);

		JLabel label_3 = new JLabel("ά��״̬:");
		label_3.setFont(new Font("����", Font.PLAIN, 20));
		label_3.setBounds(40, 240, 97, 24);
		panel.add(label_3);

		JLabel label_4 = new JLabel("��ʼʱ��:");
		label_4.setFont(new Font("����", Font.PLAIN, 20));
		label_4.setBounds(40, 310, 97, 24);
		panel.add(label_4);

		JLabel label_5 = new JLabel("����ʱ��:");
		label_5.setFont(new Font("����", Font.PLAIN, 20));
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
		serviceStatusComboBox.addItem("����");
		serviceStatusComboBox.addItem("δ��");
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
		setTitle("����ά�ޱ༭");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
//		try {
//			// UIManager.setLookAndFeel("com.whitenkov.darcula.DarculaLaf");
//			// DarculaLaf�������ͳһ��
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
		StringBuffer temp = new StringBuffer("��Ҫ�������ݿ��ȫ����Ϣ���Ƿ��������");
		int res = JOptionPane.showConfirmDialog(CarService.this, temp.toString(), "���棡", JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);
		if (res == JOptionPane.OK_OPTION) {			
				outputInf(saveInfo());		
		}
	}

   //������ʾ��Ϣ��ӡ
	private void outputInf(int i) {
		switch (i) {
		case 0:
			JOptionPane.showMessageDialog(CarService.this, "�����ɹ���", "�ɹ���", JOptionPane.WARNING_MESSAGE);
			break;
		case 1:
			JOptionPane.showMessageDialog(CarService.this, "����ʧ�ܣ�", "����", JOptionPane.ERROR_MESSAGE);
			break;
		default:
			break;
		}
	}
	
	public int saveInfo() {
		// ��һ��������һ��webbook,��Ӧһ��Excel�ļ�
				HSSFWorkbook wb = new HSSFWorkbook();
				// �ڶ�������webbook�����һ��sheet,��ӦExcel�ļ��е�sheet
				HSSFSheet sheet = wb.createSheet("����ά�޼�¼��¼��");
				// ����������sheet����ӱ�ͷ��0��,ע���ϰ汾poi��Excel����������������short
				HSSFRow row = sheet.createRow((int) 0);
				// ���Ĳ���������Ԫ�񣬲�����ֵ��ͷ ���ñ�ͷ����
				HSSFCellStyle style = wb.createCellStyle();
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// ����һ�����и�ʽ
				HSSFCell cell = row.createCell((short) 0);
				cell.setCellValue("ά�޵���");
				cell.setCellStyle(style);
				cell = row.createCell((short) 1);
				cell.setCellValue("���ƺ���");
				cell.setCellStyle(style);
				cell = row.createCell((short) 2);
				cell.setCellValue("ά�޵ص�");
				cell.setCellStyle(style);
				cell = row.createCell((short) 3);
				cell.setCellValue("ά��״̬");
				cell.setCellStyle(style);
				cell = row.createCell((short) 4);
				cell.setCellValue("ά�޿�ʼʱ��");
				cell.setCellStyle(style);
				cell = row.createCell((short) 5);
				cell.setCellValue("ά�޽���ʱ��");
				cell.setCellStyle(style);
		// ����excel�ļ�
		// ���岽��д��ʵ������ ʵ��Ӧ������Щ���ݴ����ݿ�õ���
		// java.awt��java.util�¶���listҪ������ȷ
		List<com.company.entity.CarService> list = new CommonDAOImpl().executeQuery(com.company.entity.CarService.class,"select * from tb_service",null);
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow((int) i + 1);
			com.company.entity.CarService serInf = list.get(i);
			// ������Ԫ�񣬲�����ֵ
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
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel�ļ�(*.xls)", "xls");
		jfc.setFileFilter(filter);
		int option = jfc.showSaveDialog(CarService.this);
		if (option == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			String fname = jfc.getName(file); // ���ļ���������л�ȡ�ļ���
			// �����û���д���ļ������������ƶ��ĺ�׺������ô���Ǹ������Ϻ�׺
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

package com.company.ui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.text.DateFormatter;

import com.company.dao.CommonDAOImpl;
import com.company.entity.CarInformation;
import com.company.entity.Customer;
import com.company.entity.LoginIdentity;
import com.company.entity.Tb_Cust_Yd;

public class ClientRegisterWindow extends JDialog implements ActionListener {

	private static final long serialVersionUID = 3945786951241769598L;
	private int idIdentify;
	private JPanel mainPane; // �����
	private JLabel labelNeiBuNo;
	private JTextField txtNeibubianhao; // �ڲ����
	private JLabel labelClientNo;
	private JComboBox textClientNo; // �ͻ����
	private JLabel labelClientName;
	private JTextField textField_ClientName; // �ͻ�����
	private JButton buttFindCilent; // ���ҿͻ�
	private JComboBox<String> comBoxCarNo; // ���ƺ�
	private JLabel labelCarNo;
	private JComboBox<String> comBoxIsExecute; // ִ�����
	private JLabel labelIsExecute;
	private JTextField txtPrice; // ���޵��ۣ�Ԫ/�죩
	private JLabel labelPrice;
	private JTextField txtAntecedentMoney; // Ѻ��
	private JLabel labelAntecedentMoney;
	private JTextField txtDepositReceived; // Ԥ�����
	private JLabel labelDepositReceived;
	private JTextField txtDeadline; // ��������
	private JLabel labelDeadline;
	private JTextField txtOverJourneyPrice; // ��ʻ�շѣ�Ԫ/���
	private JLabel labelOverJourneyPrice;
	private JTextField txtLimitJourney; // ÿ����ʻ���
	private JLabel labelLimitJourney;
	private JTextField txtOverHourPrice; // �����շѣ�Ԫ/Сʱ��
	private JLabel labelOverHourPrice;
	private JComboBox<String> comBoxOperator; // ������
	private JLabel labelOperator;
	private JSpinner txtDateTime; // Ԥ������
	private JLabel labelDateTime;
	private JLabel labelJspYudingTime; // Ԥ��ʱ��
	private JSpinner jspYudingTime;
	private JLabel labelRemark;
	private JTextArea txtAreaRemark; // ��ע

	private JButton buttAdd; // ����
	private JButton buttSave; // ����
	private JButton buttCancel; // ȡ��
	private JButton buttReturn; // ����

	public ClientRegisterWindow(int i) {
		idIdentify=i;
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/logo.png"));
		iniClientJFrame();
		labelNeiBuNo = new JLabel("�ڲ����:");
		labelNeiBuNo.setBounds(12, 25, 60, 20);
		txtNeibubianhao = new JTextField();
		txtNeibubianhao.setBounds(labelNeiBuNo.getX() + labelNeiBuNo.getWidth() + 5, labelNeiBuNo.getY() - 4, 120, 23);

		labelClientNo = new JLabel("�ͻ����:");
		labelClientNo.setBounds(txtNeibubianhao.getX() + txtNeibubianhao.getWidth() + 10, labelNeiBuNo.getY(), 60, 20);
		textClientNo = new JComboBox();
		textClientNo.setBounds(labelClientNo.getX() + labelClientNo.getWidth() + 5, txtNeibubianhao.getY(), 120, 23);
		List<Customer> List1 = new CommonDAOImpl().executeQuery(Customer.class, "SELECT * FROM tb_customer", null);
		for (Customer c : List1) {
			textClientNo.addItem(c.getcId());
		}

		labelClientName = new JLabel("�ͻ�����:");
		labelClientName.setBounds(textClientNo.getX() + textClientNo.getWidth() + 10, labelNeiBuNo.getY(), 60, 20);
		textField_ClientName = new JTextField();
		textField_ClientName.setBounds(labelClientName.getX() + labelClientName.getWidth() + 5, txtNeibubianhao.getY(),
				120, 23);

		buttFindCilent = new JButton("����");
		buttFindCilent.setBounds(610, textField_ClientName.getY(), 78, 23);
		buttFindCilent.addActionListener(this);

		labelCarNo = new JLabel("���ƺ�:");
		labelCarNo.setHorizontalAlignment(JLabel.RIGHT);
		labelCarNo.setBounds(15, 80, 120, 20);
		comBoxCarNo = new JComboBox<String>(); // ���ƺ�
		comBoxCarNo.setBounds(146, 80, 143, 23);
		List<String> temItem = new ArrayList<>();
		List<CarInformation> temItemssss = new ArrayList<>();
		temItemssss = new CommonDAOImpl().executeQuery(CarInformation.class, "select * from tb_car", null);
		temItemssss.forEach(a -> temItem.add(a.getCar_Id()));
		temItem.forEach(s -> comBoxCarNo.addItem(s));

		labelIsExecute = new JLabel("ִ�����:");
		labelIsExecute.setHorizontalAlignment(JLabel.RIGHT);
		labelIsExecute.setBounds(310, 80, 120, 20);
		comBoxIsExecute = new JComboBox<String>(); // ִ�����
		comBoxIsExecute.setBounds(441, 80, 143, 23);
		comBoxIsExecute.addItem("��");
		comBoxIsExecute.addItem("��");

		labelDateTime = new JLabel("Ԥ������:");
		labelDateTime.setHorizontalAlignment(JLabel.RIGHT);
		labelDateTime.setBounds(15, 126, 120, 20);
		SpinnerDateModel tempModel = new SpinnerDateModel();
		txtDateTime = new JSpinner(tempModel);
		JSpinner.DateEditor tempEditor = new JSpinner.DateEditor(txtDateTime, "yyyy-MM-dd");
		tempEditor.getTextField().setHorizontalAlignment(JTextField.RIGHT);
		DateFormatter tempFormatter = (DateFormatter) tempEditor.getTextField().getFormatter();
		tempFormatter.setAllowsInvalid(false);
		txtDateTime.setEditor(tempEditor);
		txtDateTime.setBounds(comBoxCarNo.getX(), comBoxCarNo.getY() + 46, 143, 23);

		labelAntecedentMoney = new JLabel("Ѻ��:");
		labelAntecedentMoney.setHorizontalAlignment(JLabel.RIGHT);
		labelAntecedentMoney.setBounds(310, 126, 120, 20);
		txtAntecedentMoney = new JTextField(); // Ѻ��
		txtAntecedentMoney.setBounds(comBoxIsExecute.getX(), comBoxIsExecute.getY() + 46, 143, 23);

		labelDepositReceived = new JLabel("Ԥ�����:");
		labelDepositReceived.setHorizontalAlignment(JLabel.RIGHT);
		labelDepositReceived.setBounds(15, 173, 120, 20);
		txtDepositReceived = new JTextField(); // Ԥ�����
		txtDepositReceived.setBounds(comBoxCarNo.getX(), txtDateTime.getY() + 46, 143, 23);

		labelDeadline = new JLabel("��������:");
		labelDeadline.setHorizontalAlignment(JLabel.RIGHT);
		labelDeadline.setBounds(310, 173, 120, 20);
		txtDeadline = new JTextField(); // ��������
		txtDeadline.setBounds(comBoxIsExecute.getX(), txtAntecedentMoney.getY() + 46, 143, 23);

		labelOverJourneyPrice = new JLabel("��ʻ�շѣ�Ԫ/km��:");
		labelOverJourneyPrice.setHorizontalAlignment(JLabel.RIGHT);
		labelOverJourneyPrice.setBounds(15, 219, 120, 20);
		txtOverJourneyPrice = new JTextField(); // ��ʻ�շѣ�Ԫ/���
		txtOverJourneyPrice.setBounds(comBoxCarNo.getX(), txtDepositReceived.getY() + 46, 143, 23);

		labelPrice = new JLabel("���޵��ۣ�Ԫ/�죩:");
		labelPrice.setHorizontalAlignment(JLabel.RIGHT);
		labelPrice.setBounds(310, 219, 120, 20);
		txtPrice = new JTextField(); // ���޵��ۣ�Ԫ/�죩
		txtPrice.setBounds(comBoxIsExecute.getX(), txtDeadline.getY() + 46, 143, 23);

		labelOverHourPrice = new JLabel("��ʱ�շѣ�Ԫ/h��:");
		labelOverHourPrice.setHorizontalAlignment(JLabel.RIGHT);
		labelOverHourPrice.setBounds(15, 265, 120, 20);
		txtOverHourPrice = new JTextField(); // ��ʱ�շѣ�Ԫ/Сʱ��
		txtOverHourPrice.setBounds(comBoxCarNo.getX(), txtOverJourneyPrice.getY() + 46, 143, 23);

		labelJspYudingTime = new JLabel("Ԥ��ʱ��:");
		labelJspYudingTime.setHorizontalAlignment(JLabel.RIGHT);
		labelJspYudingTime.setBounds(310, 265, 120, 20);
		SpinnerDateModel model = new SpinnerDateModel();
		jspYudingTime = new JSpinner(model);
		JSpinner.DateEditor editor = new JSpinner.DateEditor(jspYudingTime, "HH:mm:ss");
		editor.getTextField().setHorizontalAlignment(JTextField.RIGHT);
		DateFormatter formatter = (DateFormatter) editor.getTextField().getFormatter();
		formatter.setAllowsInvalid(false);
		jspYudingTime.setEditor(editor);
		jspYudingTime.setBounds(txtPrice.getX(), txtPrice.getY() + 46, 143, 23);

		labelLimitJourney = new JLabel("ÿ����ʻ���:");
		labelLimitJourney.setHorizontalAlignment(JLabel.RIGHT);
		labelLimitJourney.setBounds(15, 311, 120, 20);
		txtLimitJourney = new JTextField(); // ÿ����ʻ���
		txtLimitJourney.setBounds(comBoxCarNo.getX(), txtOverHourPrice.getY() + 46, 143, 23);

		labelOperator = new JLabel("������:");
		labelOperator.setHorizontalAlignment(JLabel.RIGHT);
		labelOperator.setBounds(310, 311, 120, 20);
		comBoxOperator = new JComboBox<>(); // ������
		comBoxOperator.setBounds(jspYudingTime.getX(), jspYudingTime.getY() + 46, 143, 23);
		List<LoginIdentity> List = new CommonDAOImpl().executeQuery(LoginIdentity.class, "SELECT * FROM user_customer where identify=1", null);
		for (LoginIdentity d : List) {
			comBoxOperator.addItem(d.getUser_id());
		}

		labelRemark = new JLabel("��ע:");
		labelRemark.setHorizontalAlignment(JLabel.RIGHT);
		labelRemark.setBounds(15, 362, 120, 20);
		txtAreaRemark = new JTextArea();
		txtAreaRemark.setBounds(txtLimitJourney.getX(), txtLimitJourney.getY() + 46, 440, 70);

		buttAdd = new JButton("����(A)"); // ����
		buttAdd.setBounds(610, 200, 78, 22);
		buttAdd.addActionListener(this);

		buttSave = new JButton("����(S)"); // ����
		buttSave.setBounds(610, 250, 78, 22);
		buttSave.addActionListener(this);

		buttCancel = new JButton("ȡ��(C)"); // ȡ��
		buttCancel.setBounds(610, 300, 78, 22);
		buttCancel.addActionListener(this);

		buttReturn = new JButton("����(R)"); // ����
		buttReturn.setBounds(610, 350, 78, 22);
		buttReturn.addActionListener(this);

		mainPane = new JPanel(null);
		mainPane.add(labelNeiBuNo);
		mainPane.add(txtNeibubianhao);
		mainPane.add(labelClientNo);
		mainPane.add(textClientNo);
		mainPane.add(labelClientName);
		mainPane.add(textField_ClientName);
		mainPane.add(buttFindCilent);
		mainPane.add(labelCarNo);
		mainPane.add(comBoxCarNo);
		mainPane.add(labelIsExecute);
		mainPane.add(comBoxIsExecute);
		mainPane.add(labelPrice);
		mainPane.add(txtPrice);
		mainPane.add(labelAntecedentMoney);
		mainPane.add(txtAntecedentMoney);
		mainPane.add(labelDepositReceived);
		mainPane.add(txtDepositReceived);
		mainPane.add(labelDeadline);
		mainPane.add(txtDeadline);
		mainPane.add(labelOverJourneyPrice);
		mainPane.add(txtOverJourneyPrice);
		mainPane.add(labelDateTime);
		mainPane.add(txtDateTime);

		mainPane.add(labelOverHourPrice);
		mainPane.add(txtOverHourPrice);
		mainPane.add(labelOperator);
		mainPane.add(comBoxOperator);
		mainPane.add(labelLimitJourney);
		mainPane.add(txtLimitJourney);
		mainPane.add(labelJspYudingTime);
		mainPane.add(jspYudingTime);
		mainPane.add(labelRemark);
		mainPane.add(txtAreaRemark);
		mainPane.add(buttAdd);
		mainPane.add(buttSave);
		mainPane.add(buttCancel);
		mainPane.add(buttReturn);
		this.add(mainPane);
	}

	private void iniClientJFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/logo.png"));
		this.setTitle("��������ϵͳ");
		this.setSize(710, 480);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
//		try {
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
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                int exitChoose=JOptionPane.showConfirmDialog(ClientRegisterWindow.this,"ȷ��Ҫ�˳���?","�˳���ʾ",JOptionPane.OK_CANCEL_OPTION);
                if(exitChoose==JOptionPane.OK_OPTION)
                {
//		        	Register.this.dispose(); //�˳�������
                    //System.exit(0);
                    dispose();
                }else{
                    return;
                }
            }
        });
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttFindCilent) {
			String query = "select * from tb_cust_yd where Inner_Id = ?";
			List<Object> tempList = new ArrayList<>();
			String tempInnerId = txtNeibubianhao.getText();
			if (null != tempInnerId) {
				int tempId = Integer.parseInt(tempInnerId);
				tempList.add(tempId);
				List<Tb_Cust_Yd> tempClientRe = new CommonDAOImpl().executeQuery(Tb_Cust_Yd.class, query, tempList);
				tempClientRe.forEach(a -> System.out.println(a.toString()));
				if (tempClientRe.size() > 0) {
					Tb_Cust_Yd tempT = tempClientRe.get(0);
					textClientNo.setSelectedItem(tempT.getCustomer_Id());
					textField_ClientName.setText(tempT.getCustomer_Name());
					comBoxCarNo.setSelectedItem(tempT.getCar_Id());
					comBoxIsExecute.setSelectedItem(tempT.getZhixing());
					txtPrice.setText("" + tempT.getZulin_Price());
					txtAntecedentMoney.setText("" + tempT.getYanjin());
					txtDepositReceived.setText("" + tempT.getPre_Zujin());
					txtDeadline.setText("" + tempT.getZulin_Qixian());
					txtOverJourneyPrice.setText("" + tempT.getChaoshi_Fee());
					txtLimitJourney.setText("" + tempT.getLicheng_Meitian());
					txtOverHourPrice.setText("" + tempT.getOutTime_Fee());
					comBoxOperator.setSelectedItem(tempT.getJinbanren());
					txtDateTime.setValue(tempT.getYuding_Date());
					jspYudingTime.setValue(tempT.getYuding_Time());
					txtAreaRemark.setText(tempT.getDemo());
				} else {
					JOptionPane.showMessageDialog(this, "ƥ��ʧ�ܣ�����", "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "�ڲ����벻��Ϊ�գ�����", "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if (e.getSource() == buttAdd) {
			Tb_Cust_Yd clientRegister = new Tb_Cust_Yd();
			clientRegister.setInner_Id(txtNeibubianhao.getText());
            System.out.println(clientRegister.getInner_Id());
            clientRegister.setCustomer_Id((String) textClientNo.getSelectedItem());
			clientRegister.setCustomer_Name(textField_ClientName.getText());
			clientRegister.setCar_Id((String) comBoxCarNo.getSelectedItem());
			clientRegister.setZhixing((String) comBoxIsExecute.getSelectedItem());
			clientRegister.setZulin_Price(new BigDecimal(txtPrice.getText()));
			clientRegister.setYanjin(new BigDecimal(txtAntecedentMoney.getText()));
			clientRegister.setPre_Zujin(new BigDecimal(txtDepositReceived.getText()));
			clientRegister.setZulin_Qixian(new BigDecimal(txtDeadline.getText()));
			clientRegister.setChaoshi_Fee(new BigDecimal(txtOverJourneyPrice.getText()));
			clientRegister.setLicheng_Meitian(new BigDecimal(txtLimitJourney.getText()));
			clientRegister.setOutTime_Fee(new BigDecimal(txtOverHourPrice.getText()));
			clientRegister.setJinbanren((String) comBoxOperator.getSelectedItem());
			clientRegister.setYuding_Date((Date) txtDateTime.getValue());
			clientRegister.setYuding_Time((Date) jspYudingTime.getValue());
			clientRegister.setDemo(txtAreaRemark.getText());
			int row = new CommonDAOImpl().add2(clientRegister,"tb_cust_yd");
			if (row > 0) {
				JOptionPane.showMessageDialog(this, "��ӳɹ�������", "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "���ʧ�ܣ�����", "��Ϣ", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == buttSave) {
			String tempInn = txtNeibubianhao.getText();
			if (null != tempInn) {
				Tb_Cust_Yd clientRegister = new Tb_Cust_Yd();
				clientRegister.setInner_Id(tempInn);
				clientRegister.setCustomer_Id((String) textClientNo.getSelectedItem());
				clientRegister.setCustomer_Name(textField_ClientName.getText());
				clientRegister.setCar_Id((String) comBoxCarNo.getSelectedItem());
				clientRegister.setZhixing((String) comBoxIsExecute.getSelectedItem());
				clientRegister.setZulin_Price(new BigDecimal(txtPrice.getText()));
				clientRegister.setYanjin(new BigDecimal(txtAntecedentMoney.getText()));
				clientRegister.setPre_Zujin(new BigDecimal(txtDepositReceived.getText()));
				clientRegister.setZulin_Qixian(new BigDecimal(txtDeadline.getText()));
				clientRegister.setChaoshi_Fee(new BigDecimal(txtOverJourneyPrice.getText()));
				clientRegister.setLicheng_Meitian(new BigDecimal(txtLimitJourney.getText()));
				clientRegister.setOutTime_Fee(new BigDecimal(txtOverHourPrice.getText()));
				clientRegister.setJinbanren((String) comBoxOperator.getSelectedItem());
				clientRegister.setYuding_Date((Date) txtDateTime.getValue());
				clientRegister.setYuding_Time((Date) jspYudingTime.getValue());
				clientRegister.setDemo(txtAreaRemark.getText());
				int row = new CommonDAOImpl().update(clientRegister);
				if (row > 0) {
					JOptionPane.showMessageDialog(this, "���³ɹ�������", "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this, "����ʧ�ܣ�����", "��Ϣ", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "�ڲ����벻��Ϊ�գ�����", "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if (e.getSource() == buttCancel) {
			textClientNo.setSelectedIndex(0);
			textField_ClientName.setText("");
			comBoxCarNo.setSelectedItem("");
			comBoxIsExecute.setSelectedItem("");
			txtPrice.setText("");
			txtAntecedentMoney.setText("");
			txtDepositReceived.setText("");
			txtDeadline.setText("");
			txtOverJourneyPrice.setText("");
			txtLimitJourney.setText("");
			txtOverHourPrice.setText("");
			comBoxOperator.setSelectedItem("");
			txtDateTime.setValue("");
			jspYudingTime.setValue("");
			txtAreaRemark.setText("");
		}
		if (e.getSource() == buttReturn) {
			this.dispose();
		}
	}

}

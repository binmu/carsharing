package com.company.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.company.dao.CommonDAOImpl;
import com.company.entity.*;

public class RegisterFrame extends JDialog {

    private JPanel contentPane;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JTextField textField1;
    private JTextField textField_2;
    private JTextField textField_4;
    private JTextField textField_6;
    private JTextField textField_8;
    private JTextField textField_10;
    private JTextField textField_11;
    private JTextField textField_3;
    private JTextField textField_5;
    private JTextField textField_7;
    private JTextField textField_9;
    private JTextField textField_12;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox_1;
    private JComboBox<String> comboBox_2;
    private JComboBox<String> comboBox_3;
    private JComboBox<String> comboBox_4;
    private JTextArea textArea;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Create the ui.
     */
    public RegisterFrame() {
        setModal(true);
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage("img/logo.png"));
        setTitle("\u6C7D\u8F66\u79DF\u8D41\u767B\u8BB0\u8868\u7F16\u8F91");
        setSize(680, 490);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0,0,0,0));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        panel1=new JPanel(null);
        panel2=new JPanel(null);
        panel3=new JPanel(null);

        JButton btnNewButton = new JButton("\u5BA2\u6237\u9884\u8BA2");
        btnNewButton.setBounds(0, 0, 90, 60);
        panel2.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("\u589E\u52A0(A)");
        btnNewButton_1.setBounds(0, 85, 90, 60);
        btnNewButton_1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                int row=addCustZL();
                if (row > 0) {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "添加完成");
                } else {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "添加出错！请更改编号重试");
                }
            }
        });
        panel2.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("\u5B58\u76D8(S)");
        btnNewButton_2.setBounds(0, 170, 90, 60);
        btnNewButton_2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub 存盘按钮
                //new CommonDAOImpl().commitBatch();
//				if (row > 0) {
//				//推荐更新成功后，刷新一下数据，也就是再查询一下
//					searchCustZL(Integer.parseInt(textField1.getText()));
//					JOptionPane.showMessageDialog(Register.this, "数据库添加成功");
//				} else {
//					JOptionPane.showMessageDialog(Register.this, "数据库添加失败！");
//				}
            }
        });
        panel2.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("\u53D6\u6D88(C)");
        btnNewButton_3.setBounds(0, 255, 90, 60);
        btnNewButton_3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                initData();
            }
        });
        panel2.add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("\u8FD4\u56DE(R)");
        btnNewButton_4.setBounds(0, 340, 90, 60);
        btnNewButton_4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub 返回按钮
//                int row=new CommonDAOImpl().rollbackBatch();
//                if (row > 0) {
//                    JOptionPane.showMessageDialog(Register.this, "数据已存盘，返回失败");
//                } else if(row==0){
//                    JOptionPane.showMessageDialog(Register.this, "数据已回滚");
//                }
            }
        });
        panel2.add(btnNewButton_4);

        textField1 = new JTextField();
        textField1.setBounds(65, 10, 100, 25);
        panel1.add(textField1);
        textField1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(425, 10, 100, 25);
        panel1.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel = new JLabel("\u5185\u90E8\u7F16\u53F7\uFF1A");
        lblNewLabel.setBounds(0, 0, 65, 45);
        panel1.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel(" \u5BA2\u6237\u53F7\uFF1A");
        lblNewLabel_1.setBounds(180, 0, 55, 45);
        panel1.add(lblNewLabel_1);

        ImageIcon background1 = new ImageIcon("img/3.png");
        JLabel label1 = new JLabel(background1);
        label1.setBounds(345, 10, 25, 25);
        panel1.add(label1);

        JLabel lblNewLabel_2 = new JLabel(" \u59D3\u540D\uFF1A");
        lblNewLabel_2.setBounds(385, 0, 45, 45);
        panel1.add(lblNewLabel_2);

        comboBox1 = new JComboBox();
        comboBox1.setBounds(235, 10, 105, 25);
        panel1.add(comboBox1);

        JLabel lblNewLabel_3 = new JLabel("\uFF08F2\u952E\u67E5\u627E\u7528\u6237\uFF09");
        lblNewLabel_3.setBounds(540, 0, 120, 45);
        panel1.add(lblNewLabel_3);
//		contentPane.add(panel2,BorderLayout.CENTER);
//		contentPane.add(panel3,BorderLayout.EAST);

        panel1.setPreferredSize(lblNewLabel.getSize());
        panel2.setPreferredSize(btnNewButton.getSize());
        panel3.setBorder(BorderFactory.createLineBorder(Color.gray));
        contentPane.add(panel1,BorderLayout.NORTH);
        contentPane.add(panel2,BorderLayout.EAST);
        contentPane.add(panel3,BorderLayout.CENTER);
        JLabel lbl = new JLabel(" 只有代驾时才能输入驾驶员！");
        lbl.setBorder(BorderFactory.createLineBorder(Color.gray));
        contentPane.add(lbl,BorderLayout.SOUTH);

        comboBox_1 = new JComboBox();
        comboBox_1.setBounds(140, 15, 130, 25);
        panel3.add(comboBox_1);

        textField_4 = new JTextField();
        textField_4.setBounds(140, 55, 130, 25);
        panel3.add(textField_4);
        textField_4.setColumns(10);

        textField_6 = new JTextField();
        textField_6.setBounds(140, 95, 130, 25);
        panel3.add(textField_6);
        textField_6.setColumns(10);

        textField_8 = new JTextField();
        textField_8.setBounds(140, 135, 130, 25);
        panel3.add(textField_8);
        textField_8.setColumns(10);

        textField_10 = new JTextField();
        textField_10.setBounds(140, 175, 130, 25);
        panel3.add(textField_10);
        textField_10.setColumns(10);

        textField_11 = new JTextField();
        textField_11.setBounds(140, 255, 130, 25);
        panel3.add(textField_11);
        textField_11.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(400, 15, 140, 25);
        panel3.add(textField_3);
        textField_3.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setBounds(400, 55, 140, 25);
        panel3.add(textField_5);
        textField_5.setColumns(10);

        textField_7 = new JTextField();
        textField_7.setBounds(400, 95, 140, 25);
        panel3.add(textField_7);
        textField_7.setColumns(10);

        textField_9 = new JTextField();
        textField_9.setBounds(400, 135, 140, 25);
        panel3.add(textField_9);
        textField_9.setColumns(10);

        textField_12 = new JTextField();
        textField_12.setBounds(400, 255, 140, 25);
        panel3.add(textField_12);
        textField_12.setColumns(10);

        comboBox_2 = new JComboBox();
        comboBox_2.setBounds(140, 215, 130, 25);
        //下拉框添加日历表选择日期
        Chooser ser = Chooser.getInstance();
        ser.register(comboBox_2);
        panel3.add(comboBox_2);

        comboBox_3 = new JComboBox();
        comboBox_3.setBounds(400, 175, 140, 25);
        panel3.add(comboBox_3);

        comboBox_4 = new JComboBox();
        comboBox_4.setBounds(400, 215, 140, 25);
        comboBox_4.setEnabled(false);
        panel3.add(comboBox_4);

        JCheckBox chckbxNewCheckBox = new JCheckBox("");
        chckbxNewCheckBox.setBounds(540, 215, 25, 25);
        chckbxNewCheckBox.setSelected(true);
        panel3.add(chckbxNewCheckBox);

        textArea = new JTextArea();
        textArea.setBounds(140, 300, 400, 75);
        textArea.setBorder(BorderFactory.createLineBorder(Color.gray));
        panel3.add(textArea);

        JLabel lblNewLabel_4 = new JLabel("\u8F66\u724C\u53F7\uFF1A");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_4.setBounds(59, 15, 82, 25);
        panel3.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("\u79DF\u8D41\u5355\u4EF7(\u5143/\u5929)\uFF1A");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_5.setBounds(10, 55, 131, 25);
        panel3.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("\u6BCF\u5929\u9650\u9A76\u91CC\u7A0B\uFF1A");
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6.setBounds(43, 95, 98, 25);
        panel3.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("\u8D85\u9A76\u6536\u8D39(\u5143/\u516C\u91CC)\uFF1A");
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_7.setBounds(10, 135, 131, 25);
        panel3.add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("\u8D85\u65F6\u6536\u8D39(\u5143/\u5C0F\u65F6)\uFF1A");
        lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_8.setBounds(10, 175, 132, 25);
        panel3.add(lblNewLabel_8);

        JLabel lblNewLabel_9 = new JLabel("\u53D1\u8F66\u65E5\u671F\uFF1A");
        lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_9.setBounds(43, 215, 98, 25);
        panel3.add(lblNewLabel_9);

        JLabel lblNewLabel_10 = new JLabel("\u53D1\u8F66\u5355\u53F7\uFF1A");
        lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_10.setBounds(59, 255, 82, 25);
        panel3.add(lblNewLabel_10);

        JLabel lblNewLabel_11 = new JLabel("\u5907\u6CE8\uFF1A");
        lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_11.setBounds(87, 299, 54, 25);
        panel3.add(lblNewLabel_11);

        JLabel lblNewLabel_12 = new JLabel("\u9884\u6536\u79DF\u91D1\uFF1A");
        lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_12.setBounds(323, 15, 77, 25);
        panel3.add(lblNewLabel_12);

        JLabel lblNewLabel_13 = new JLabel("\u62BC\u91D1\uFF1A");
        lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_13.setBounds(346, 55, 54, 25);
        panel3.add(lblNewLabel_13);

        JLabel lblNewLabel_14 = new JLabel("\u79DF\u8D41\u671F\u9650\uFF1A");
        lblNewLabel_14.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_14.setBounds(323, 95, 77, 25);
        panel3.add(lblNewLabel_14);

        JLabel lblNewLabel_15 = new JLabel("\u53D1\u8F66\u91CC\u7A0B\uFF1A");
        lblNewLabel_15.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_15.setBounds(323, 135, 77, 25);
        panel3.add(lblNewLabel_15);

        JLabel lblNewLabel_16 = new JLabel("\u7ECF\u529E\u4EBA\uFF1A");
        lblNewLabel_16.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_16.setBounds(346, 175, 54, 25);
        panel3.add(lblNewLabel_16);

        JLabel lblNewLabel_17 = new JLabel("\u9A7E\u9A76\u5458\uFF1A");
        lblNewLabel_17.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_17.setBounds(346, 215, 54, 25);
        panel3.add(lblNewLabel_17);

        JLabel lblNewLabel_18 = new JLabel("\u5E94\u6536\u79DF\u91D1\uFF1A");
        lblNewLabel_18.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_18.setBounds(323, 255, 77, 25);
        panel3.add(lblNewLabel_18);

        initData();//界面初始化

        textField1.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode()==KeyEvent.VK_F2){
                    searchCustZL(Integer.parseInt(textField1.getText()));
                }
            }
        });

        chckbxNewCheckBox.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(chckbxNewCheckBox.isSelected()){
                    comboBox_4.setEnabled(false);
                }else{
                    comboBox_4.setEnabled(true);
                }
            }
        });

        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                int exitChoose=JOptionPane.showConfirmDialog(RegisterFrame.this,"确定要退出吗?","退出提示",JOptionPane.OK_CANCEL_OPTION);
                if(exitChoose==JOptionPane.OK_OPTION)
                {
//		        	Register.this.dispose(); //退出本界面
                    //System.exit(0);
                    dispose();
                }else{
                    return;
                }
            }
        });

    }

    private void initData() {
        textField1.setText("");
        textField_2.setText("");
        textField_3.setText("");
        textField_4.setText("");
        textField_5.setText("");
        textField_6.setText("");
        textField_7.setText("");
        textField_8.setText("");
        textField_9.setText("");
        textField_10.setText("");
        textField_11.setText("");
        textField_12.setText("");
        comboBox1.setSelectedItem("");
        comboBox_1.setSelectedItem("");
        comboBox_2.setSelectedItem("");
        comboBox_3.setSelectedItem("");
        comboBox_4.setSelectedItem("");
        textArea.setText("");
        loadDept1();
        loadDept2();
        loadDept4();
        loadDept5();
    }

    private void loadDept1() {
        List<Customer> List = new CommonDAOImpl().executeQuery(Customer.class, "SELECT * FROM tb_customer", null);
        for (Customer c : List) {
            comboBox1.addItem(c.getcId());
        }
    }
    private void loadDept2() {//要根据其他表格实体修改,包括CommonDAOImp中的部分语句；
        List<CarInformation> List = new CommonDAOImpl().executeQuery(CarInformation.class, "SELECT * FROM tb_car where isBlockup = 1", null);
        for (CarInformation s : List) {
            comboBox_1.addItem(s.getCar_Id());
        }
    }

    private void loadDept4() {
        List<LoginIdentity> List = new CommonDAOImpl().executeQuery(LoginIdentity.class, "SELECT * FROM user_customer where identify=1", null);
        for (LoginIdentity d : List) {
            comboBox_3.addItem(d.getUser_id());
        }
    }
    private void loadDept5() {//要根据其他表格实体修改
        List<Driver> List = new CommonDAOImpl().executeQuery(Driver.class, "SELECT * FROM tb_driver", null);
        for (Driver s : List) {
            comboBox_4.addItem(s.getDriverName());
        }
    }

    private void searchCustZL(int id) {
        // Emp emp = new EmpDAO().findById(id);
        List<Object> params = new ArrayList<>();
        params.add(id);
        List<CustZL> czlList = new CommonDAOImpl().executeQuery(CustZL.class, "SELECT * FROM tb_cust_zl WHERE Inner_Id=?", params);
        if (czlList.size() > 0) {
            CustZL czl = czlList.get(0);
            // 绑定数据
            textField_2.setText(czl.getCustomer_Name());
            textField_3.setText(czl.getPre_Zujin()+"");
            textField_4.setText(czl.getZulin_Price()+"");
            textField_5.setText(czl.getYanjin()+"");
            textField_6.setText(czl.getLicheng_Meitian()+"");
            textField_7.setText(czl.getZulin_Qixian()+"");
            textField_8.setText(czl.getChaoshi_Fee()+"");
            textField_9.setText(czl.getStart_Licheng()+"");
            textField_10.setText(czl.getOutTime_Fee()+"");
            textField_11.setText(czl.getFache_Id()+"");
            textField_12.setText(czl.getYingshou_Zujin()+"");
            comboBox1.setSelectedItem(czl.getCustomer_Id()+"");
            comboBox_1.setSelectedItem(czl.getCar_Id());
            comboBox_3.setSelectedItem(czl.getJinbanren());
            comboBox_2.addItem(sdf.format(czl.getFache_Date()));
            comboBox_2.setSelectedItem(sdf.format(czl.getFache_Date()));
            comboBox_4.setSelectedItem(czl.getDriver());
            textArea.setText(czl.getDemo());
        } else {
            JOptionPane.showMessageDialog(RegisterFrame.this, "没有这个员工");
        }
    }

    private int addCustZL() {
        // Emp emp = new EmpDAO().findById(id)
        // 绑定数据
        CustZL czl=new CustZL();
        czl.setInner_Id(textField1.getText());
        czl.setCustomer_Name(textField_2.getText());
        czl.setPre_Zujin(Integer.parseInt(textField_3.getText()));
        czl.setZulin_Price(Integer.parseInt(textField_4.getText()));
        czl.setYanjin(Integer.parseInt(textField_5.getText()));
        czl.setLicheng_Meitian(Integer.parseInt(textField_6.getText()));
        czl.setZulin_Qixian(Integer.parseInt(textField_7.getText()));
        czl.setChaoshi_Fee(Integer.parseInt(textField_8.getText()));
        czl.setStart_Licheng(Integer.parseInt(textField_9.getText()));
        czl.setOutTime_Fee(Integer.parseInt(textField_10.getText()));
        czl.setFache_Id(textField_11.getText());
        czl.setYingshou_Zujin(Integer.parseInt(textField_12.getText()));
        czl.setCustomer_Id((String)comboBox1.getSelectedItem());
        czl.setCar_Id((String)comboBox_1.getSelectedItem());
        czl.setJinbanren((String)comboBox_3.getSelectedItem());
        StringBuilder sb=new StringBuilder();
        sb.append((String)comboBox_2.getSelectedItem());
        sb.append(" 00:00:00");
        czl.setFache_Date(Timestamp.valueOf(sb.toString()));
        czl.setDriver((String)comboBox_4.getSelectedItem());
        czl.setDemo(textArea.getText());

        CommonDAOImpl cdao=new CommonDAOImpl();
        int row=cdao.add2(czl,"tb_cust_zl");
        return row;
    }
}

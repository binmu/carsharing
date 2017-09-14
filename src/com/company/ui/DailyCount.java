package com.company.ui;


import java.awt.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.company.dao.CommonDAOImpl;
import com.company.entity.Car_settlement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DailyCount extends JDialog {

    private JPanel contentPane;
    private JTextField textStartDate;
    private JTextField textJieShuShiJian;
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane jsp;

    /**
     * Create the ui.
     */
    public DailyCount() {
        setModal(true);
        setTitle("�ռ���");
        setIconImage(Toolkit.getDefaultToolkit().getImage("img/logo.png"));
        setSize( 813, 419);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel(null);
        contentPane.add(panel, BorderLayout.CENTER);

        JPanel panel_1 = new JPanel(null);
        panel_1.setBounds(0, 0, 787, 45);
        panel.add(panel_1);

        JLabel label = new JLabel("\u8D77\u59CB\u65E5\u671F\uFF1A");
        label.setBounds(20, 10, 70, 22);
        panel_1.add(label);

        textStartDate = new JTextField();
        textStartDate.setBounds(86, 11, 151, 22);
        Chooser ser = Chooser.getInstance();
        ser.register(textStartDate);
        panel_1.add(textStartDate);
        textStartDate.setColumns(10);

        JLabel label_1 = new JLabel("\u622A\u6B62\u65E5\u671F\uFF1A");
        label_1.setBounds(286, 10, 70, 22);
        panel_1.add(label_1);

        textJieShuShiJian = new JTextField();
        textJieShuShiJian.setBounds(352, 11, 151, 21);
        Chooser ser2 = Chooser.getInstance();
        ser2.register(textJieShuShiJian);
        panel_1.add(textJieShuShiJian);
        textJieShuShiJian.setColumns(10);

        JButton button = new JButton("\u67E5\u8BE2");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tableModel.getRowCount() > 0) {
                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        tableModel.removeRow(i);
                    }
                    List<Object> tempParams = new ArrayList<>();
                    String startDate = textStartDate.getText();
                    String jieShuDate = textJieShuShiJian.getText();
                    tempParams.add(startDate);
                    tempParams.add(jieShuDate);
                    String query = "SELECT * FROM tb_car_zl WHERE DATE(Shoukuan_Date) BETWEEN ? AND ? ";
                    getDataToJTable(tempParams, query);
                } else {
                    List<Object> tempParams = new ArrayList<>();
                    String startDate = textStartDate.getText();
                    String jieShuDate = textJieShuShiJian.getText();
                    tempParams.add(startDate);
                    tempParams.add(jieShuDate);
                    String query = "SELECT * FROM tb_car_zl WHERE DATE(Shoukuan_Date) BETWEEN ? AND ?";
                    getDataToJTable(tempParams, query);
                }
            }
        });
        button.setBounds(542, 10, 70, 23);
        panel_1.add(button);

        table = new JTable();
        String[] header = {"�������", "��������", "�ͻ�����", "���ƺ�", "Ѻ��", "Ӧ�ս��", "ʵ�ս��", "Ӧ���˿�", "Ӧ�˽��", "������"};
        tableModel = (DefaultTableModel) table.getModel();
        // ��Ϊֻ��DefaultTableModel��addColumn�Ĺ��ܣ���table.getModel()���ص���һ��TableModel���͵Ķ���
        // �鿴API��DefaultTableModelʵ����TableModel�Ľӿڣ�Ϊ�˵���DefaultTableModel�ķ���������ǿ������ת��
        for (String h : header) {
            tableModel.addColumn(h);
        }
        // table.setBounds(0, 50, 645, 321);
        jsp = new JScrollPane(table);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jsp.setBounds(0, 46, 787, 325);
        iniJTableByDay();
        panel.add(jsp);
    }

    private void iniJTableByDay() {
        List<Object> tempParams = new ArrayList<>();
        Date date = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        String sDateSuffix = dateformat.format(date);
        tempParams.add(sDateSuffix);
        String query = "SELECT * FROM tb_car_zl WHERE DATE(Shoukuan_Date)=?";
        getDataToJTable(tempParams, query);
    }

    private void getDataToJTable(List<Object> tempParams, String query) {
        List<Car_settlement> tempCar_settlement = new ArrayList<>();
        tempCar_settlement = new CommonDAOImpl().executeQuery(Car_settlement.class, query, tempParams);
        if (!tempCar_settlement.isEmpty()) {
            for (Car_settlement car_settlement : tempCar_settlement) {
                String orderNo = car_settlement.getInner_id();// �������
                //new SimpleDateFormat("yyyy-MM-dd").format(car_settlement.getShoukuan_Date())
                String orderDay = new SimpleDateFormat("yyyy-MM-dd").format(car_settlement.getShoukuan_Date()) + "";// ��������
                String clientName = car_settlement.getCustomer_Name();// �ͻ�����
                String carId = car_settlement.getCar_Id();// ���ƺ�
                String yajin = car_settlement.getYanjin() + "";// Ѻ��
                String yingshoujine = car_settlement.getYingshou_Jine() + "";// Ӧ�ս��
                String shishoujine = car_settlement.getShishou_Jine() + "";// ʵ�ս��
                String yingshouzhagnkuan = car_settlement.getYingshou_Zhangkuan() + "";// Ӧ���˿�
                String yingtuijine = car_settlement.getYingtui_Zhangkuan() + "";// Ӧ�˽��
                String jiesuanren = car_settlement.getJiesuanren();// ������
                Object[] rows = {orderNo, orderDay, clientName, carId, yajin, yingshoujine, shishoujine,
                        yingshouzhagnkuan, yingtuijine, jiesuanren};
                for (int i = 0; i < rows.length; i++) {
                    System.out.println(rows);
                }
                tableModel.addRow(rows);
            }
        } else {
            Object[] rows = {null, null, null, null, null, null, null, null, null, null};
            tableModel.addRow(rows);
        }
    }
}

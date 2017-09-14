package com.company.ui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;

import com.company.dao.CommonDAOImpl;
import com.company.entity.CarInformation;
import com.company.entity.CarWeiZhang;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class WeiZhang extends JDialog {

    private static final long serialVersionUID = -6306209419729755327L;
    private JPanel contentPane;
    private JComboBox textFieldCarNo;
    private JTextField textField_DriverCard_No;
    private JTextField textField_penalty;
    private JTextField textField_fadanNo;

    /**
     * Create the ui.
     */
    public WeiZhang() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("img/logo.png"));
        setModal(true);
        setTitle("\u8F66\u8F86\u8FDD\u7AE0\u767B\u8BB0");
        setSize(406, 425);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel(null);
        contentPane.add(panel, BorderLayout.CENTER);

        JLabel label = new JLabel("\u8F66\u724C\u53F7\uFF1A");
        label.setBounds(22, 54, 70, 20);
        panel.add(label);

        textFieldCarNo = new JComboBox();
        List<CarInformation> List = new CommonDAOImpl().executeQuery(CarInformation.class, "SELECT * FROM tb_car ", null);
        for (CarInformation s : List) {
            textFieldCarNo.addItem(s.getCar_Id());
        }
        textFieldCarNo.setBounds(102, 53, 152, 23);
        panel.add(textFieldCarNo);
        //textFieldCarNo.setColumns(10);

        JLabel label_1 = new JLabel("\u8FDD\u7AE0\u60C5\u51B5\uFF1A");
        label_1.setBounds(22, 93, 70, 20);
        panel.add(label_1);

        JLabel label_2 = new JLabel("\u9A7E\u9A76\u8BC1\u6263\u5206\uFF1A");
        label_2.setBounds(22, 137, 82, 20);
        panel.add(label_2);

        textField_DriverCard_No = new JTextField();
        textField_DriverCard_No.setBounds(102, 137, 152, 23);
        panel.add(textField_DriverCard_No);
        textField_DriverCard_No.setColumns(10);

        JComboBox<String> comboBoxWeiZhangThings = new JComboBox<String>();
        comboBoxWeiZhangThings.addItem("人为因素");
        comboBoxWeiZhangThings.addItem("意外因素");
        comboBoxWeiZhangThings.setBounds(102, 92, 152, 23);
        panel.add(comboBoxWeiZhangThings);

        JLabel label_3 = new JLabel("\u7F5A\u6B3E\uFF1A");
        label_3.setBounds(22, 181, 70, 20);
        panel.add(label_3);

        textField_penalty = new JTextField();
        textField_penalty.setBounds(102, 178, 152, 23);
        panel.add(textField_penalty);
        textField_penalty.setColumns(10);

        JLabel label_4 = new JLabel("\u8FDD\u7AE0\u65F6\u95F4\uFF1A");
        label_4.setBounds(22, 228, 70, 20);
        panel.add(label_4);

        SpinnerDateModel tempModel = new SpinnerDateModel();
        JSpinner spinnerWeiZhangDate = new JSpinner(tempModel);
        JSpinner.DateEditor tempEditor = new JSpinner.DateEditor(spinnerWeiZhangDate, "yyyy-MM-dd");
        tempEditor.getTextField().setHorizontalAlignment(JTextField.RIGHT);
        DateFormatter tempFormatter = (DateFormatter) tempEditor.getTextField().getFormatter();
        tempFormatter.setAllowsInvalid(false);
        spinnerWeiZhangDate.setEditor(tempEditor);
        spinnerWeiZhangDate.setBounds(102, 225, 152, 23);
        panel.add(spinnerWeiZhangDate);

        JLabel label_5 = new JLabel("\u5907\u6CE8\uFF1A");
        label_5.setBounds(22, 268, 70, 20);
        panel.add(label_5);

        JButton button_Exit = new JButton("\u9000\u51FA");
        button_Exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WeiZhang.this.dispose();
            }
        });
        button_Exit.setBounds(284, 264, 70, 23);
        panel.add(button_Exit);

        JEditorPane editorPaneRemark = new JEditorPane();
        editorPaneRemark.setBounds(102, 268, 152, 86);
        panel.add(editorPaneRemark);

        JButton button_Add = new JButton("\u589E\u52A0");
        button_Add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!txtFieldIsNull()) {
                    CarWeiZhang carWeiZhang = new CarWeiZhang();
                    carWeiZhang.setWeizhangNo(Integer.parseInt(textField_fadanNo.getText()));
                    carWeiZhang.setCar_Id((String)textFieldCarNo.getSelectedItem());
                    carWeiZhang.setWeizhangqingkuang((String) comboBoxWeiZhangThings.getSelectedItem());
                    carWeiZhang.setCar_card_No(Integer.parseInt(textField_DriverCard_No.getText()));
                    carWeiZhang.setPenalty(Integer.parseInt(textField_penalty.getText()));
                    carWeiZhang.setWeizhangdate((Date) spinnerWeiZhangDate.getValue());
                    carWeiZhang.setRemark(editorPaneRemark.getText());
                    int row = new CommonDAOImpl().add(carWeiZhang);
                    if (row > 0) {
                        JOptionPane.showMessageDialog(WeiZhang.this, "添加成功！", "信息",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(WeiZhang.this, "添加失败！", "信息",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(WeiZhang.this, "添加内容不能为空！！！", "信息",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        button_Add.setBounds(284, 77, 70, 23);
        panel.add(button_Add);

        JButton button_Save = new JButton("\u4FDD\u5B58");
        button_Save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!txtFieldIsNull()) {
                    CarWeiZhang carWeiZhang = new CarWeiZhang();
                    carWeiZhang.setWeizhangNo(Integer.parseInt(textField_fadanNo.getText()));
                    carWeiZhang.setCar_Id((String)textFieldCarNo.getSelectedItem());
                    carWeiZhang.setWeizhangqingkuang((String) comboBoxWeiZhangThings.getSelectedItem());
                    carWeiZhang.setCar_card_No(Integer.parseInt(textField_DriverCard_No.getText()));
                    carWeiZhang.setPenalty(Integer.parseInt(textField_penalty.getText()));
                    carWeiZhang.setWeizhangdate((Date) spinnerWeiZhangDate.getValue());
                    carWeiZhang.setRemark(editorPaneRemark.getText());
                    int row = new CommonDAOImpl().update(carWeiZhang);
                    if (row > 0) {
                        JOptionPane.showMessageDialog(WeiZhang.this, "更新成功！", "信息",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(WeiZhang.this, "更新失败！", "信息",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(WeiZhang.this, "添加内容不能为空！！！", "信息",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        button_Save.setBounds(284, 121, 70, 23);
        panel.add(button_Save);

        JButton buttonFind = new JButton("\u67E5\u8BE2");
        buttonFind.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Object> tempParams = new ArrayList<>();
                String str = textField_fadanNo.getText();
                if (null != str) {
                    int tempNo = Integer.parseInt(str);
                    tempParams.add(tempNo);
                    List<CarWeiZhang> tempCarWeiZhang = new ArrayList<>();
                    tempCarWeiZhang = new CommonDAOImpl().executeQuery(CarWeiZhang.class,
                            "SELECT * FROM tb_car_weizhang WHERE weizhangNo = ?", tempParams);
                    if (!tempCarWeiZhang.isEmpty()) {
                        CarWeiZhang carWeiZhang = tempCarWeiZhang.get(0);
                        textFieldCarNo.setSelectedItem(carWeiZhang.getCar_Id());
                        comboBoxWeiZhangThings.setSelectedItem(carWeiZhang.getWeizhangqingkuang());
                        textField_DriverCard_No.setText("" + carWeiZhang.getCar_card_No());
                        textField_penalty.setText(carWeiZhang.getPenalty() + "");
                        spinnerWeiZhangDate.setValue(carWeiZhang.getWeizhangdate());
                        editorPaneRemark.setText(carWeiZhang.getRemark());
                    } else {
                        JOptionPane.showMessageDialog(WeiZhang.this, "没有找到该内容！", "信息",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(WeiZhang.this, "罚单号不能为空！！！", "信息",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        buttonFind.setBounds(284, 28, 70, 23);
        panel.add(buttonFind);

        JLabel label_6 = new JLabel("\u7F5A\u5355\u53F7\uFF1A");
        label_6.setBounds(22, 10, 70, 20);
        panel.add(label_6);

        textField_fadanNo = new JTextField();
        textField_fadanNo.setBounds(102, 9, 152, 23);
        panel.add(textField_fadanNo);
        textField_fadanNo.setColumns(10);
    }

    protected boolean txtFieldIsNull() {
        boolean result = true;
        result = ("".equals(textField_fadanNo.getText())) ||
                 ("".equals(textField_DriverCard_No.getText())) || ("".equals(textField_penalty.getText()));

        return result;
    }
}

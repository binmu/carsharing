package com.company.ui.changeSkin;

import javax.swing.*;

public class ShowSystemLookNFeelClass extends JFrame {
    public ShowSystemLookNFeelClass(){
        iniFrame();
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        JButton temp = new JButton("д╛хо");
        temp.setBounds(50,90,84,40);
        JLabel jLabel = new JLabel("д╛хо");
        jLabel.setBounds(15,97,100,20);
        JTextField jTextFieldCarNo = new JTextField();
        jTextFieldCarNo.setBounds(5, 30, 175, 20);
        jPanel.add(jTextFieldCarNo);
        JComboBox carClass = new JComboBox();
        carClass.setBounds(5, 60, 175, 22);
        jPanel.add(carClass);
        jPanel.add(jLabel);
        jPanel.add(temp);
        this.add(jPanel);
    }

    private void iniFrame() {
        this.setTitle("SystemLookNFeel");
        this.setSize(400,300);
        this.setLocationRelativeTo(null);
        try {
            UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}

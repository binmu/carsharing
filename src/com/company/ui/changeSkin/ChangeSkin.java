package com.company.ui.changeSkin;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ChangeSkin extends JDialog  {
    public static final int CANCEL_OPTION = 0;
    /**
     * 选择确定按钮的返回值
     */
    public static final int APPROVE_OPTION = 1;
    public boolean skin=true;
    private boolean temp =true;
    private JRadioButton normal;
    private JRadioButton darcula;
    private JPanel mainJPanel;
    private ButtonGroup group;
    private int returnValue = this.CANCEL_OPTION;

    public boolean returnSkinStyle() {
        return this.skin;
    }

    public ChangeSkin(boolean skinStyle) {
        this.skin=skinStyle;
        iniFrame();
        setMainJPanel();
        mainJPanel.revalidate();
        this.setContentPane(mainJPanel);
    }

    private void setMainJPanel(){
        mainJPanel = new JPanel();
        mainJPanel.setLayout(null);
        JPanel radioButtonPanel = new JPanel();
        radioButtonPanel.setLayout(new GridLayout());
        radioButtonPanel.setBounds(75, 150, 355, 30);

        normal = new JRadioButton("默认");
        normal.setBounds(75, 150, 80, 20);
        radioButtonPanel.add(normal);

        darcula = new JRadioButton("Darcula");
        darcula.setBounds(275, 150, 80, 20);
        radioButtonPanel.add(darcula);

        group = new ButtonGroup();
        group.add(normal);
        group.add(darcula);

        if (skin) {
            normal.setSelected(true);
        } else {
            darcula.setSelected(true);
        }

        mainJPanel.add(radioButtonPanel);
        setJButton();

        RadioButtonListener radioButtonListener =new RadioButtonListener();
        normal.addActionListener(radioButtonListener);
        darcula.addActionListener(radioButtonListener);

        JPanel imgPanel =new MyPanel();
        imgPanel.setBounds(0,0,400,150);
        mainJPanel.add(imgPanel);
    }

    private void setJButton(){
        JButton confirm = new JButton("确定");
        confirm.setBounds(95,200,84,40);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                skin=temp;
                returnValue = APPROVE_OPTION;
                setSkin();
                removeAll();
                dispose();
            }
        });
        JButton cancel = new JButton("取消");
        cancel.setBounds(204,200,84,40);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                dispose();
            }
        });

        mainJPanel.add(confirm);
        mainJPanel.add(cancel);
    }

    private void setSkin() {
        try {
            //Darcula主题与系统默认主题
            if (skin) {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } else {
                UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
            }
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    SwingUtilities.updateComponentTreeUI(ChangeSkin.this);
                }
            });
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

    public void iniFrame() {
        this.setTitle("换肤");
        this.setSize(400, 300);
        this.setResizable(false);
        setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSkin();
    }

    public final int showChangeSkin(JDialog jDialog){
        setLocationRelativeTo(jDialog);
        revalidate();
        setVisible(true);
        return returnValue;
    }
    public final int showChangeSkin(JFrame jFrame){
        setLocationRelativeTo(jFrame);
        revalidate();
        setVisible(true);
        return returnValue;
    }

    class MyPanel extends JPanel {
        Image image = null;
        Image image2 = null;

        public void paint(Graphics g) {
            try {
                image = ImageIO.read(new File("img/SystemLookNFeel.png"));
                image2 = ImageIO.read(new File("img/DarLookNFeel.png"));
                g.drawImage(image, 10, 10, 186, 131, null);
                g.drawImage(image2, 200, 10, 186, 131, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class RadioButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == normal) {
                temp = true;
            } else if (e.getSource() == darcula) {
                temp = false;
            }
        }
    }
}
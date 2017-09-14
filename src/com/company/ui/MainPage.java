package com.company.ui;

import com.company.dao.CommonDAOImpl;
import com.company.ui.changeSkin.ChangeSkin;
import com.company.ui.editCarInformation.EditCarInfPage;
import com.company.entity.LoginIdentity;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;

public class MainPage extends JFrame {
    private boolean skin;
    //todo 导入身份权限后的相应限制
    private static final long serialVersionUID = 4745675222291465223L;
    private JPanel contentPane;
    private CommonDAOImpl commonDAO;
    private LoginIdentity users;
    private int idIdentify;
    private ChangeSkin changeSkin;

    public MainPage(int inputidIdentify) {
        setTitle("主页面");
        setIconImage(Toolkit.getDefaultToolkit().getImage("img/logo.png"));
        idIdentify = inputidIdentify;
        skin = true;
        changeSkin();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 500);
        setResizable(false);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("系统维护(S)");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("数据初始化");
        mntmNewMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(MainPage.this, "是否要清空数据库！！", "警告！", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (res == JOptionPane.OK_OPTION) {
                    commonDAO.iniDB();
                    JOptionPane.showMessageDialog(MainPage.this, "初始化成功！");
                }
            }
        });
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("操作人员更改");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login().setVisible(true);
                dispose();
            }
        });
        mnNewMenu.add(mntmNewMenuItem_1);

        JMenu mnNewMenu_1 = new JMenu("日常业务(R)");
        menuBar.add(mnNewMenu_1);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("车辆档案管理");
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditCarInfPage(idIdentify).setVisible(true);
            }
        });
        mnNewMenu_1.add(mntmNewMenuItem_2);

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("客户资料管理");
        mntmNewMenuItem_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditCustomer(idIdentify).setVisible(true);
            }
        });
        mnNewMenu_1.add(mntmNewMenuItem_3);

        JMenuItem mntmNewMenuItem_4 = new JMenuItem("客户预订登记");
        mntmNewMenuItem_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClientRegisterWindow(idIdentify).setVisible(true);
            }
        });
        mnNewMenu_1.add(mntmNewMenuItem_4);

        JMenuItem mntmNewMenuItem_5 = new JMenuItem("汽车租赁登记");
        mntmNewMenuItem_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterFrame().setVisible(true);
            }
        });
        mnNewMenu_1.add(mntmNewMenuItem_5);

        JMenuItem mntmNewMenuItem_6 = new JMenuItem("汽车租赁结算");
        mntmNewMenuItem_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CarSettlement().setVisible(true);
            }
        });
        mnNewMenu_1.add(mntmNewMenuItem_6);

        JMenu mnNewMenu_2 = new JMenu("其他业务(Q)");
        menuBar.add(mnNewMenu_2);

        JMenuItem mntmNewMenuItem_7 = new JMenuItem("车辆维修登记");
        mntmNewMenuItem_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CarService().setVisible(true);
            }
        });
        mnNewMenu_2.add(mntmNewMenuItem_7);

        JMenuItem mntmNewMenuItem_8 = new JMenuItem("车辆违章登记");
        mntmNewMenuItem_8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WeiZhang().setVisible(true);
            }
        });
        mnNewMenu_2.add(mntmNewMenuItem_8);

        JMenu mnNewMenu_3 = new JMenu("统计分析(T)");
        menuBar.add(mnNewMenu_3);

        JMenuItem mntmNewMenuItem_9 = new JMenuItem("车辆租赁统计");
        mntmNewMenuItem_9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CarRent().setVisible(true);
            }
        });
        mnNewMenu_3.add(mntmNewMenuItem_9);

        JMenuItem mntmNewMenuItem_10 = new JMenuItem("客户租赁统计");
        mntmNewMenuItem_10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerRent().setVisible(true);
            }
        });
        mnNewMenu_3.add(mntmNewMenuItem_10);

        JMenu mnNewMenu_4 = new JMenu("帮助(H)");
        menuBar.add(mnNewMenu_4);

        JMenuItem mntmNewMenuItem_11 = new JMenuItem("帮助");
        mntmNewMenuItem_11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO 需要升级成带超链接的网址链接 @2017年9月8日19:18:04
                JOptionPane.showMessageDialog(
                        MainPage.this,
                        "<html>" +
                                "<p><font size=\"4\">Thanks<br></br>thumbnailator<br></br>https://github.com/coobird/thumbnailator" +
                                "<br></br>Darcula Theme<br></br>https://github.com/bulenkov/Darcula" +
                                "<br></br>Apache POI<br></br>http://poi.apache.org/</font>" +
                                "<br></br>&copy; 2017 Group 13 .All rights reserved.&emsp;&emsp;</p>" +
                                "<html>");
            }
        });
        mnNewMenu_4.add(mntmNewMenuItem_11);

        JMenuItem mntmNewMenuItem_12 = new JMenuItem("换肤");
        mntmNewMenuItem_12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeSkin = new ChangeSkin(skin);
                int back = changeSkin.showChangeSkin(MainPage.this);
                if (back == changeSkin.APPROVE_OPTION) {
                    skin = changeSkin.returnSkinStyle();
                    changeSkin();
                    revalidate();
                }
            }
        });
        mnNewMenu_4.add(mntmNewMenuItem_12);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JToolBar toolBar = new JToolBar();
        contentPane.add(toolBar, BorderLayout.NORTH);

        JButton btnNewButton = new JButton("修改密码");
        btnNewButton.setIcon(new ImageIcon(
                "img/password_manager.png"));
        Border border = BorderFactory.createEmptyBorder(0, 0, 0, 0);
        btnNewButton.setBorder(border);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainPage.ChangePassword().setVisible(true);
            }
        });
        toolBar.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("车辆档案");
        btnNewButton_1.setIcon(
                new ImageIcon("img/carfile.png"));
        btnNewButton_1.setBorder(border);
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditCarInfPage(idIdentify).setVisible(true);
            }
        });
        toolBar.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("客户资料");
        btnNewButton_2.setIcon(
                new ImageIcon("img/customer.png"));
        btnNewButton_2.setBorder(border);
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditCustomer(idIdentify).setVisible(true);
            }
        });
        toolBar.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("客户预订");
        btnNewButton_3.setIcon(
                new ImageIcon("img/Order.png"));
        btnNewButton_3.setBorder(border);
        btnNewButton_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClientRegisterWindow(idIdentify).setVisible(true);
            }
        });
        toolBar.add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("租赁登记");
        btnNewButton_4.setIcon(
                new ImageIcon("img/register.png"));
        btnNewButton_4.setBorder(border);
        btnNewButton_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterFrame().setVisible(true);
            }
        });
        toolBar.add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("租赁结算");
        btnNewButton_5.setIcon(
                new ImageIcon("img/dollar.png"));
        btnNewButton_5.setBorder(border);
        btnNewButton_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CarSettlement().setVisible(true);
            }
        });
        toolBar.add(btnNewButton_5);

        JButton btnNewButton_6 = new JButton("日记账");
        btnNewButton_6.setIcon(
                new ImageIcon("img/accounting.png"));
        btnNewButton_6.setBorder(border);
        btnNewButton_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DailyCount().setVisible(true);
            }
        });
        toolBar.add(btnNewButton_6);

        JButton btnNewButton_7 = new JButton("提醒功能");
        btnNewButton_7.setIcon(
                new ImageIcon("img/remind.png"));
        btnNewButton_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO 需要升级成带超链接的网址链接 @2017年9月8日19:18:04
                JOptionPane.showMessageDialog(
                        MainPage.this,
                        "<html>" +
                                "<p><font size=\"4\">Thanks<br></br>thumbnailator<br></br>https://github.com/coobird/thumbnailator" +
                                "<br></br>Darcula Theme<br></br>https://github.com/bulenkov/Darcula" +
                                "<br></br>Apache POI<br></br>http://poi.apache.org/</font>" +
                                "<br></br>&copy; 2017 Group 13 .All rights reserved.&emsp;&emsp;</p>" +
                                "<html>");
            }
        });
        btnNewButton_7.setBorder(border);
        toolBar.add(btnNewButton_7);

        JButton btnNewButton_8 = new JButton("退出");
        btnNewButton_8.setIcon(
                new ImageIcon("img/sign_out.png"));
        btnNewButton_8.setBorder(border);
        btnNewButton_8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        toolBar.add(btnNewButton_8);

        JPanel panel_1 = new MyPanel();
        contentPane.add(panel_1, BorderLayout.CENTER);
    }

    class MyPanel extends JPanel {
        Image image = null;

        public void paint(Graphics g) {
            try {
                image = ImageIO.read(new File("img/carPanl.png"));
                g.drawImage(image, 10, 10, 715, 450, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class ChangePassword extends JDialog {
        public ChangePassword() {
            setTitle("修改密码");
            setLocationRelativeTo(null);
            setSize(250, 225);
            setResizable(false);
            setModal(true);
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(null);
            JLabel jLabel = new JLabel("用户名:");
            jLabel.setBounds(30, 30, 150, 25);
            mainPanel.add(jLabel);
            JLabel jLabelold = new JLabel("旧密码:");
            jLabelold.setBounds(30, 70, 150, 25);
            mainPanel.add(jLabelold);
            JLabel jLabelNew = new JLabel("新密码:");
            jLabelNew.setBounds(30, 110, 150, 25);
            mainPanel.add(jLabelNew);

            JTextField jTextFielduserName = new JTextField();
            jTextFielduserName.setBounds(75, 30, 150, 20);
            JPasswordField jTextFieldOldPassword = new JPasswordField();
            jTextFieldOldPassword.setBounds(75, 70, 150, 20);
            JPasswordField jTextFieldNewPassword = new JPasswordField();
            jTextFieldNewPassword.setBounds(75, 110, 150, 20);
            mainPanel.add(jTextFielduserName);
            mainPanel.add(jTextFieldOldPassword);
            mainPanel.add(jTextFieldNewPassword);

            JButton isConfirm = new JButton("确定");
            isConfirm.setBounds(75, 145, 84, 40);
            isConfirm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    commonDAO = new CommonDAOImpl();
                    if (!(commonDAO.searchClo(jTextFielduserName.getText(), "user_customer", "user_id"))) {
                        JOptionPane.showMessageDialog(ChangePassword.this, "没有此用户！", "提示！", JOptionPane.ERROR_MESSAGE);
                        return;
                    } else if (commonDAO.isPasswordRight(new String(jTextFieldOldPassword.getPassword()), jTextFielduserName.getText())) {
                        if (commonDAO.updatePassword(new String(jTextFieldNewPassword.getPassword()), jTextFielduserName.getText()) != 0) {
                            JOptionPane.showMessageDialog(ChangePassword.this, "修改成功！", "提示！", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(ChangePassword.this, "修改失败！", "提示！", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(ChangePassword.this, "密码错误！", "提示！", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            mainPanel.add(isConfirm);
            this.add(mainPanel);
        }
    }

    private void changeSkin() {
        try {
            if (!skin) {
                UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
            } else {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    SwingUtilities.updateComponentTreeUI(MainPage.this);
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
}

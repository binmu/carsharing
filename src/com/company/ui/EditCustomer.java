package com.company.ui;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

import com.company.dao.*;
import com.company.ui.editCarInformation.CropImage;
import com.company.entity.Bondsman;
import com.company.entity.Company;
import com.company.entity.Customer;
import com.company.entity.Driver;

import com.company.other.Regex;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;;

public class EditCustomer extends JDialog {
    /**
     * @author Irene
     * @2017年8月30日
     */
    private static final long serialVersionUID = -7683754515231853118L;
    private CommonDAOImpl commonDAO = new CommonDAOImpl();
    private JLabel warningInf;
    private JLabel warningBody;
    private int identify;
    private Regex regex = new Regex();
    private JTextField clientId;
    private JTextField clientName;
    private JPasswordField clientPassword;
    private JTextField clientIdentityCardId;
    private JTextField clientTel;
    private JTextField clientPhone;
    private JTextField clientHomeAdd;
    private JTextField clientWorkUnit;
    private JTextField clientUnitAdd;
    private JTextField yingShouMembershipFee;
    private JTextField shiShouMembershipFee;
    private JComboBox clientGenderComboBox;
    private JComboBox clientTypeComboBox;
    private JComboBox drivingType;
    private JComboBox driverGenderComboBox;
    private JComboBox driverTypeComboBox;
    private JComboBox bondsmanGenderComboBox;
    private JComboBox companyType;
    private JCheckBox stopUse;
    private JButton btnReturn;
    private JButton btnCancle;
    private JButton btnCunPan;
    private JButton btnAdd;
    private JButton btnReplace;
    private JButton btnDesign;
    private JButton btnPrint;
    //private JButton

    private JPanel panel;
    private JTabbedPane showInfo;
    private JPanel panel_5;
    private JLabel jLabel;
    private JLabel picLabel;
    private JComboBox choose;

    private JTextField driverName;
    private JTextField drivingAge;
    private JTextField driverIdentityCardId;
    private JTextField driverPhone;

    private JTextField bondsmanName;
    private JTextField bondsmanAge;
    private JTextField bondsmanIdentityCardId;
    private JTextField bondsmanPhone;

    private JTextField companyName;
    private JTextField companyAdd;

    private JSpinner sTime;
    private JSpinner eTime;
    private JSpinner linzhengTime;

    private String[] jTabbedPaneName = {"客户资料", "驾驶员资料", "担保人资料", "企业资料"};
    private String[] sex = {"男", "女"};
    private String[] jiaType = {"A1", "A2", "A3", "B1", "B2", "C1", "C2", "C3", "C4", "D", "E", "F"};

    Date today = new Date(System.currentTimeMillis());

    CustomerDAO cusDao = new CustomerDAO();
    DriverDAO driDao = new DriverDAO();
    BondsmanDAO bmanDao = new BondsmanDAO();
    CompanyDAO comDao = new CompanyDAO();

    public EditCustomer(int i) {
        identify = i;
        setModal(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage("img/logo.png"));
        initFrame();
        initBody();
        judgeId();
        getContentPane().add(panel);
    }

    public void initBody() {
        panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);// 指定为空布局
        top();
        button();
        showInf();
    }

    public void top() {
        JLabel lblNewLabel = new JLabel("客户号：");
        lblNewLabel.setBounds(10, 10, 73, 15);
        panel.add(lblNewLabel);

        clientId = new JTextField();
        clientId.setBounds(60, 7, 111, 21);
        panel.add(clientId);
        clientId.setColumns(10);

        JLabel label = new JLabel("起始日期：");
        label.setBounds(181, 10, 73, 15);
        panel.add(label);

        sTime = setJSpinner(sTime, today, true);
        sTime.setBounds(243, 7, 111, 21);
        panel.add(sTime);

        JLabel label_1 = new JLabel("终止日期：");
        label_1.setBounds(364, 10, 73, 15);
        panel.add(label_1);

        eTime = setJSpinner(eTime, today, true);
        eTime.setBounds(428, 7, 111, 21);
        panel.add(eTime);

        stopUse = new JCheckBox("停用");
        stopUse.setBounds(561, 6, 54, 23);
        stopUse.addItemListener(new ItemCheckBoxListener());
        panel.add(stopUse);
    }

    private void judgeId() {
        if (identify == 0) {
            btnCunPan.setEnabled(false);
            stopUse.setEnabled(false);
            warningInf.setText("客户不能保存excel文件");
            warningBody.setText("客户不能停用信息");
        }
    }

    //停用编辑界面
    class ItemCheckBoxListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            // TODO Auto-generated method stub
            if (stopUse.isSelected()) {
                clientId.setEnabled(false);
                sTime.setEnabled(false);
                eTime.setEnabled(false);
                clientName.setEnabled(false);
                clientGenderComboBox.setEnabled(false);
                clientTypeComboBox.setEnabled(false);
                clientPassword.setEnabled(false);
                linzhengTime.setEnabled(false);
                drivingType.setEnabled(false);
                clientIdentityCardId.setEnabled(false);
                clientTel.setEnabled(false);
                clientPhone.setEnabled(false);
                clientHomeAdd.setEnabled(false);
                clientWorkUnit.setEnabled(false);
                clientUnitAdd.setEnabled(false);
                yingShouMembershipFee.setEnabled(false);
                shiShouMembershipFee.setEnabled(false);

                showInfo.setEnabled(false);
                driverName.setEnabled(false);
                driverGenderComboBox.setEnabled(false);
                driverTypeComboBox.setEnabled(false);
                drivingAge.setEnabled(false);
                driverIdentityCardId.setEnabled(false);
                driverPhone.setEnabled(false);
                bondsmanName.setEnabled(false);
                bondsmanGenderComboBox.setEnabled(false);
                bondsmanAge.setEnabled(false);
                bondsmanIdentityCardId.setEnabled(false);
                bondsmanPhone.setEnabled(false);
                companyName.setEnabled(false);
                companyType.setEnabled(false);
                companyAdd.setEnabled(false);

                btnReturn.setEnabled(false);
                btnCancle.setEnabled(false);
                btnCunPan.setEnabled(false);
                btnAdd.setEnabled(false);
                btnReplace.setEnabled(false);
                btnDesign.setEnabled(false);
                btnPrint.setEnabled(false);
            } else {
                clientId.setEnabled(true);
                sTime.setEnabled(true);
                eTime.setEnabled(true);
                clientName.setEnabled(true);
                clientGenderComboBox.setEnabled(true);
                clientTypeComboBox.setEnabled(true);
                clientPassword.setEnabled(true);
                linzhengTime.setEnabled(true);
                drivingType.setEnabled(true);
                clientIdentityCardId.setEnabled(true);
                clientTel.setEnabled(true);
                clientPhone.setEnabled(true);
                clientHomeAdd.setEnabled(true);
                clientWorkUnit.setEnabled(true);
                clientUnitAdd.setEnabled(true);
                yingShouMembershipFee.setEnabled(true);
                shiShouMembershipFee.setEnabled(true);

                showInfo.setEnabled(true);
                driverName.setEnabled(true);
                driverGenderComboBox.setEnabled(true);
                driverTypeComboBox.setEnabled(true);
                drivingAge.setEnabled(true);
                driverIdentityCardId.setEnabled(true);
                driverPhone.setEnabled(true);
                bondsmanName.setEnabled(true);
                bondsmanGenderComboBox.setEnabled(true);
                bondsmanAge.setEnabled(true);
                bondsmanIdentityCardId.setEnabled(true);
                bondsmanPhone.setEnabled(true);
                companyName.setEnabled(true);
                companyType.setEnabled(true);
                companyAdd.setEnabled(true);
                btnReturn.setEnabled(true);
                btnCancle.setEnabled(true);
                btnCunPan.setEnabled(true);
                btnAdd.setEnabled(true);
                btnReplace.setEnabled(true);
                btnDesign.setEnabled(true);
                btnPrint.setEnabled(true);
            }
        }
    }

    //存盘
    private void saveASExcelWaringInf(int i) {
        StringBuffer temp = new StringBuffer("将要导出数据库");
        temp.append(jTabbedPaneName[i]);
        temp.append("的全部信息，是否继续！！");
        int res = JOptionPane.showConfirmDialog(EditCustomer.this, temp.toString(), "警告！", JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (res == JOptionPane.OK_OPTION) {
            switch (i) {
                case 0:
                    outputInf(cunClient());
                    break;
                case 1:
                    outputInf(cunDriver());
                    break;
                case 2:
                    outputInf(cunBondsman());
                    break;
                case 3:
                    outputInf(cunCompany());
                    break;
            }
        }
    }

    public void button() {
        warningInf = new JLabel();
        warningInf.setForeground(Color.RED);
        warningInf.setBounds(545, 100, 140, 30);
        panel.add(warningInf);
        warningBody = new JLabel();
        warningBody.setForeground(Color.RED);
        warningBody.setBounds(545, 120, 140, 30);
        panel.add(warningBody);

        btnReturn = new JButton("返回(R)");
        btnReturn.setToolTipText("返回上一页");
        btnReturn.setBounds(561, 397, 93, 45);
        btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditCustomer.this.dispose();
            }
        });
        panel.add(btnReturn);
        btnCancle = new JButton("取消(C)");
        btnCancle.setToolTipText("取消信息的输入");
        btnCancle.setBounds(561, 342, 93, 45);
        btnCancle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (showInfo.getSelectedIndex()) {
                    case 0:
                        cancleClient();
                        break;
                    case 1:
                        cancleDriver();
                        break;
                    case 2:
                        cancleBondsman();
                        break;
                    case 3:
                        cancleCompany();
                        break;
                }
            }
        });
        panel.add(btnCancle);
        btnCunPan = new JButton("存盘(S)");
        btnCunPan.setToolTipText("导出资料为Excel文件保存");
        btnCunPan.setBounds(561, 287, 93, 45);
        btnCunPan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveASExcelWaringInf(showInfo.getSelectedIndex());
                return;
            }
        });
        panel.add(btnCunPan);
        btnAdd = new JButton("增加(A)");
        btnAdd.setToolTipText("添加新客户的信息");
        btnAdd.setBounds(561, 232, 93, 45);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (showInfo.getSelectedIndex()) {
                    case 0:
                        if (!(judgeCustomerInputInf())) {
                            break;
                        }
                        if (cusDao.searchColumn(clientId.getText(), "tb_customer", "cId")) {
                            JOptionPane.showMessageDialog(EditCustomer.this, "有了！！");
                            break;
                        }
                        cusDao.add(getCustInf());
                        JOptionPane.showMessageDialog(EditCustomer.this, "添加成功！请继续填完驾驶员资料！");
                        break;
                    case 1:
                        if (!(judgedriverInputInf())) {
                            break;
                        }
                        if ((cusDao.searchColumn(clientId.getText(), "tb_customer", "cId")) == false) {
                            JOptionPane.showMessageDialog(EditCustomer.this, "没有对应的客户外键");
                            break;
                        }
                        if ((commonDAO.searchClo(driverIdentityCardId.getText(), "tb_driver", "driverId"))) {
                            JOptionPane.showMessageDialog(EditCustomer.this, "驾驶员身份证重复");
                            break;
                        }
                        driDao.add(getDriInf());
                        JOptionPane.showMessageDialog(EditCustomer.this, "添加成功！请继续填完担保人资料！");
                        break;
                    case 2:
                        if (!(judgeBoundsInputInf())) {
                            break;
                        }
                        if ((cusDao.searchColumn(clientId.getText(), "tb_customer", "cId")) == false) {
                            JOptionPane.showMessageDialog(EditCustomer.this, "没有对应的客户外键");
                            break;
                        }
                        if ((commonDAO.searchClo(bondsmanIdentityCardId.getText(), "tb_bondsman", "bondsmanId")) == false) {
                            JOptionPane.showMessageDialog(EditCustomer.this, "担保人身份证重复");
                            break;
                        }
                        bmanDao.add(getBonInf());
                        JOptionPane.showMessageDialog(EditCustomer.this, "添加成功！请继续填完企业资料！");
                        break;
                    case 3:
                        if (!(regex.isCustomerNo(clientId.getText()))) {
                            //JOptionPane.showMessageDialog(EditCustomer.this, "客户号格式不正确！");
                            showWarning("客户号格式不正确!", "正确格式如：C00000");
                            break;
                        }
                        if ((cusDao.searchColumn(clientId.getText(), "tb_customer", "cId")) == false) {
                            JOptionPane.showMessageDialog(EditCustomer.this, "没有客户，你尽管添加，能添加进去算我输");
                            break;
                        }
                        comDao.add(getComInf());
                        JOptionPane.showMessageDialog(EditCustomer.this, "添加成功！");
                        break;
                    case 4:
                        int res = 0;
                        String sql = "insert into image(name,content) values(?,?)";
                        Connection con = DBTool.getInstance().getConnection();
                        PreparedStatement ptmt = null;
                        try {
                            ptmt = con.prepareStatement(sql);
                            ptmt.setString(1, (String) choose.getSelectedItem());
                            InputStream is = null;
                            is = new FileInputStream("C:\\temp.jpg");
                            ptmt.setBinaryStream(2, is, is.available());
                            // 方法说明：PreparedStatement.setBinaryStream(int
                            // parameterIndex, InputStream x, int length)
                            res = ptmt.executeUpdate();
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        } finally {
                            if (res > 0) {
                                JOptionPane.showMessageDialog(EditCustomer.this, "成功！");
                            } else {
                                JOptionPane.showMessageDialog(EditCustomer.this, "失败！");
                            }
                        }
                }
            }
        });
        panel.add(btnAdd);
        btnReplace = new JButton("替换(T)");
        btnReplace.setToolTipText("更新旧客户的信息");
        btnReplace.setBounds(561, 177, 93, 45);
        btnReplace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                switch (showInfo.getSelectedIndex()) {
                    case 0:
                        if (!(judgeCustomerInputInf())) {
                            break;
                        }
                        if ((cusDao.searchColumn(clientId.getText(), "tb_customer", "cId")) == false) {
                            JOptionPane.showMessageDialog(EditCustomer.this, "没有写对应客户外键");
                            break;
                        }
                        cusDao.update(getCustInf());
                        JOptionPane.showMessageDialog(EditCustomer.this, "更新成功！");
                        break;
                    case 1:
                        if (!(judgedriverInputInf())) {
                            break;
                        }
                        if ((cusDao.searchColumn(clientId.getText(), "tb_customer", "cId")) == false) {
                            JOptionPane.showMessageDialog(EditCustomer.this, "没有写对应客户外键");
                            break;
                        }
                        driDao.update(getDriInf());
                        JOptionPane.showMessageDialog(EditCustomer.this, "更新成功！");
                        break;
                    case 2:
                        if (!(judgeBoundsInputInf())) {
                            break;
                        }
                        if ((cusDao.searchColumn(clientId.getText(), "tb_customer", "cId")) == false) {
                            JOptionPane.showMessageDialog(EditCustomer.this, "没有客户，无法对此进行更新！");
                            break;
                        }
                        bmanDao.update(getBonInf());
                        JOptionPane.showMessageDialog(EditCustomer.this, "更新成功！");
                        break;
                    case 3:
                        if (!(regex.isCustomerNo(clientId.getText()))) {
                            //JOptionPane.showMessageDialog(EditCustomer.this, "客户号格式不正确！");
                            showWarning("客户号格式不正确!", "正确格式如：C00000");
                            break;
                        }
                        if ((cusDao.searchColumn(clientId.getText(), "tb_customer", "cId")) == false) {
                            JOptionPane.showMessageDialog(EditCustomer.this, "没有客户，无法对此进行更新！");
                            break;
                        }
                        comDao.update(getComInf());
                        JOptionPane.showMessageDialog(EditCustomer.this, "更新成功！");
                        break;
                }
            }
        });
        panel.add(btnReplace);
//        btnPrint = new JButton("打印档案");
//        btnPrint.setBounds(550, 233, 93, 23);
//        btnPrint.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////				Properties p = new Properties();
////				PrintJob jp = Toolkit.getDefaultToolkit().getPrintJob(EditCustomer.this, "客户登记表编辑", p);
////				Graphics pg = jp.getGraphics();// Graphics打印图形的图形环境
////				if (pg != null) {
////					try {
////						EditCustomer.this.printAll(pg); // 打印该窗体及其所有的组件
////					} finally {
////						pg.dispose(); // 注销图形环境
////					}
////				}
////				jp.end(); // 结束打印作业
//            }
//        });
//        panel.add(btnPrint);
    }

    // 取消客户编辑界面的输入
    public void cancleClient() {
        clientId.setText("");
        clientName.setText("");
        clientPassword.setText("");
        clientIdentityCardId.setText("");
        clientTel.setText("");
        clientPhone.setText("");
        clientHomeAdd.setText("");
        clientWorkUnit.setText("");
        clientUnitAdd.setText("");
        yingShouMembershipFee.setText("");
        shiShouMembershipFee.setText("");
    }

    // 取消驾驶员编辑界面的输入
    public void cancleDriver() {
        driverName.setText("");
        drivingAge.setText("");
        driverIdentityCardId.setText("");
        driverPhone.setText("");
    }

    // 取消担保人编辑界面的输入
    public void cancleBondsman() {
        bondsmanName.setText("");
        bondsmanAge.setText("");
        bondsmanIdentityCardId.setText("");
        bondsmanPhone.setText("");
    }

    // 取消企业编辑界面的输入
    public void cancleCompany() {
        companyName.setText("");
        companyAdd.setText("");
    }

    // 增加更新客户信息
    private Customer getCustInf() {
        Customer tbcus = new Customer();
        tbcus.setcId(clientId.getText());
        tbcus.setStartTime(new Timestamp(((Date) sTime.getValue()).getTime()));
        tbcus.setEndTime(new Timestamp(((Date) eTime.getValue()).getTime()));
        tbcus.setCustomerName(clientName.getText());
        // System.out.println(clientGenderComboBox.getSelectedIndex());
        tbcus.setCustomerSex((String) clientGenderComboBox.getSelectedItem());// 可以不用String强转，在addDriver()有体现
        tbcus.setCustomerType((String) clientTypeComboBox.getSelectedItem());
        // System.out.println(clientPassword.getPassword());
        tbcus.setCustomerPsd(new String(clientPassword.getPassword()));
        tbcus.setLingZhengTime(new Timestamp(((Date) linzhengTime.getValue()).getTime()));
        tbcus.setZhunJiaType((String) drivingType.getSelectedItem());
        tbcus.setCreditId(clientIdentityCardId.getText());
        tbcus.setOfficeTel(clientTel.getText());
        tbcus.setMobileTel(clientPhone.getText());
        tbcus.setHomeAddress(clientHomeAdd.getText());
        tbcus.setGongSiName(clientWorkUnit.getText());
        tbcus.setGongSiAddress(clientUnitAdd.getText());
        tbcus.setYingShouFee(new BigDecimal(yingShouMembershipFee.getText()));
        tbcus.setShiShouFee(new BigDecimal(shiShouMembershipFee.getText()));
        return tbcus;
    }

    // 增加更新客户对应的驾驶员信息
    private Driver getDriInf() {
        Driver tbdri = new Driver();
        tbdri.setDriverName(driverName.getText());
        tbdri.setDriverSex(sex[driverGenderComboBox.getSelectedIndex()]);
        tbdri.setDriverAge(Integer.parseInt(drivingAge.getText()));
        tbdri.setDriverType((String) driverTypeComboBox.getSelectedItem());
        tbdri.setDriverId(driverIdentityCardId.getText());
        tbdri.setDriverPhone(driverPhone.getText());
        tbdri.setcId(clientId.getText());
        return tbdri;
    }

    // 增加更新客户对应的担保人信息
    private Bondsman getBonInf() {
        Bondsman tbbman = new Bondsman();
        tbbman.setBondsmanName(bondsmanName.getText());
        tbbman.setBondsmanSex(sex[bondsmanGenderComboBox.getSelectedIndex()]);
        tbbman.setBondsmanAge(Integer.parseInt(bondsmanAge.getText()));
        tbbman.setBondsmanId(bondsmanIdentityCardId.getText());
        tbbman.setBondsmanPhone(bondsmanPhone.getText());
        tbbman.setcId(clientId.getText());
        return tbbman;
    }

    // 增加更新客户对应的企业信息
    private Company getComInf() {
        Company tbcom = new Company();
        tbcom.setCompanyName(companyName.getText());
        tbcom.setCompanyType((String) companyType.getSelectedItem());
        tbcom.setCompanyAddr(companyAdd.getText());
        tbcom.setcId(clientId.getText());
        return tbcom;
    }

    public void showInf() {
        showInfo = new JTabbedPane(JTabbedPane.TOP);// 展示信息的复合窗体
        showInfo.setBounds(10, 47, 530, 395);
        clientInfo();
        driverInfo();
        bondsmanInfo();
        companyInfo();
        photo();
        panel.add(showInfo);
    }

    public void clientInfo() {
        JPanel panel_1 = new JPanel();
        showInfo.addTab("客户资料", null, panel_1, null);
        panel_1.setLayout(null);

        JLabel label_2 = new JLabel("姓名：");
        label_2.setHorizontalAlignment(SwingConstants.RIGHT);
        label_2.setBounds(10, 10, 96, 15);
        panel_1.add(label_2);

        clientName = new JTextField();
        clientName.setBounds(116, 7, 114, 21);
        panel_1.add(clientName);
        clientName.setColumns(10);

        JLabel label_3 = new JLabel("性别：");
        label_3.setHorizontalAlignment(SwingConstants.RIGHT);
        label_3.setBounds(240, 10, 73, 15);
        panel_1.add(label_3);

        clientGenderComboBox = new JComboBox(sex);
        clientGenderComboBox.setToolTipText("");
        clientGenderComboBox.setBounds(323, 7, 96, 21);
        panel_1.add(clientGenderComboBox);

        JLabel lblD = new JLabel("客户类型：");
        lblD.setHorizontalAlignment(SwingConstants.RIGHT);
        lblD.setBounds(10, 41, 96, 15);
        panel_1.add(lblD);

        clientTypeComboBox = new JComboBox();
        clientTypeComboBox.setBounds(116, 38, 114, 21);
        clientTypeComboBox.addItem("会员");
        clientTypeComboBox.addItem("非会员");
        panel_1.add(clientTypeComboBox);

        JLabel label_4 = new JLabel("密码：");
        label_4.setHorizontalAlignment(SwingConstants.RIGHT);
        label_4.setBounds(240, 41, 73, 15);
        panel_1.add(label_4);

        clientPassword = new JPasswordField();
        clientPassword.setBounds(323, 38, 97, 21);
        panel_1.add(clientPassword);

        JLabel label_5 = new JLabel("初次领证时间：");
        label_5.setHorizontalAlignment(SwingConstants.RIGHT);
        label_5.setBounds(10, 80, 96, 15);
        panel_1.add(label_5);

        linzhengTime = setJSpinner(linzhengTime, today, true);
        linzhengTime.setBounds(116, 77, 114, 21);
        panel_1.add(linzhengTime);

        JLabel label_6 = new JLabel("准驾类型：");
        label_6.setHorizontalAlignment(SwingConstants.RIGHT);
        label_6.setBounds(240, 80, 73, 15);
        panel_1.add(label_6);

        drivingType = new JComboBox(jiaType);
        drivingType.setBounds(323, 77, 96, 21);
        panel_1.add(drivingType);

        JLabel label_7 = new JLabel("身份证号：");
        label_7.setHorizontalAlignment(SwingConstants.RIGHT);
        label_7.setBounds(10, 119, 96, 15);
        panel_1.add(label_7);

        clientIdentityCardId = new JTextField();
        clientIdentityCardId.setBounds(116, 116, 303, 21);
        panel_1.add(clientIdentityCardId);
        clientIdentityCardId.setColumns(10);

        JLabel label_8 = new JLabel("联系电话：");
        label_8.setHorizontalAlignment(SwingConstants.RIGHT);
        label_8.setBounds(10, 154, 96, 15);
        panel_1.add(label_8);

        clientTel = new JTextField();
        clientTel.setBounds(116, 151, 303, 21);
        panel_1.add(clientTel);
        clientTel.setColumns(10);

        JLabel label_9 = new JLabel("移动电话：");
        label_9.setHorizontalAlignment(SwingConstants.RIGHT);
        label_9.setBounds(10, 192, 96, 15);
        panel_1.add(label_9);

        clientPhone = new JTextField();
        clientPhone.setBounds(116, 189, 303, 21);
        panel_1.add(clientPhone);
        clientPhone.setColumns(10);

        JLabel label_10 = new JLabel("家庭住址：");
        label_10.setHorizontalAlignment(SwingConstants.RIGHT);
        label_10.setBounds(10, 228, 96, 15);
        panel_1.add(label_10);

        clientHomeAdd = new JTextField();
        clientHomeAdd.setBounds(116, 225, 303, 21);
        panel_1.add(clientHomeAdd);
        clientHomeAdd.setColumns(10);

        JLabel label_11 = new JLabel("工作单位：");
        label_11.setHorizontalAlignment(SwingConstants.RIGHT);
        label_11.setBounds(10, 267, 96, 15);
        panel_1.add(label_11);

        clientWorkUnit = new JTextField();
        clientWorkUnit.setBounds(116, 264, 303, 21);
        panel_1.add(clientWorkUnit);
        clientWorkUnit.setColumns(10);

        JLabel label_12 = new JLabel("单位地址：");
        label_12.setHorizontalAlignment(SwingConstants.RIGHT);
        label_12.setBounds(10, 302, 96, 15);
        panel_1.add(label_12);

        clientUnitAdd = new JTextField();
        clientUnitAdd.setBounds(116, 299, 303, 21);
        panel_1.add(clientUnitAdd);
        clientUnitAdd.setColumns(10);

        JLabel label_13 = new JLabel("应收会费：");
        label_13.setHorizontalAlignment(SwingConstants.RIGHT);
        label_13.setBounds(10, 341, 96, 15);
        panel_1.add(label_13);

        yingShouMembershipFee = new JTextField();
        yingShouMembershipFee.setBounds(116, 338, 114, 21);
        panel_1.add(yingShouMembershipFee);
        yingShouMembershipFee.setColumns(10);

        JLabel label_14 = new JLabel("实收会费：");
        label_14.setHorizontalAlignment(SwingConstants.RIGHT);
        label_14.setBounds(240, 341, 73, 15);
        panel_1.add(label_14);

        shiShouMembershipFee = new JTextField();
        shiShouMembershipFee.setBounds(323, 338, 96, 21);
        panel_1.add(shiShouMembershipFee);
        shiShouMembershipFee.setColumns(10);
    }

    public void driverInfo() {
        JPanel panel_2 = new JPanel();
        showInfo.addTab("驾驶员资料", null, panel_2, null);
        panel_2.setLayout(null);

        JLabel label_2_1 = new JLabel("姓名：");
        label_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
        label_2_1.setBounds(65, 24, 96, 15);
        panel_2.add(label_2_1);

        driverName = new JTextField();
        driverName.setBounds(171, 21, 114, 21);
        panel_2.add(driverName);
        driverName.setColumns(10);

        JLabel label_3_1 = new JLabel("性别：");
        label_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
        label_3_1.setBounds(65, 70, 96, 15);
        panel_2.add(label_3_1);

        driverGenderComboBox = new JComboBox(sex);
        driverGenderComboBox.setBounds(173, 67, 114, 21);
        panel_2.add(driverGenderComboBox);

        JLabel lblD_1 = new JLabel("驾驶员类型：");
        lblD_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblD_1.setBounds(65, 159, 96, 15);
        panel_2.add(lblD_1);

        driverTypeComboBox = new JComboBox(jiaType);
        driverTypeComboBox.setBounds(171, 156, 114, 21);
        panel_2.add(driverTypeComboBox);

        JLabel label_5_1 = new JLabel("驾龄：");
        label_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
        label_5_1.setBounds(65, 115, 96, 15);
        panel_2.add(label_5_1);

        drivingAge = new JTextField();
        drivingAge.setColumns(10);
        drivingAge.setBounds(171, 112, 114, 21);
        panel_2.add(drivingAge);

        JLabel label_7_1 = new JLabel("身份证号：");
        label_7_1.setHorizontalAlignment(SwingConstants.RIGHT);
        label_7_1.setToolTipText("身份证号不可更改");
        label_7_1.setBounds(65, 206, 96, 15);
        panel_2.add(label_7_1);

        driverIdentityCardId = new JTextField();
        driverIdentityCardId.setBounds(171, 203, 303, 21);
        driverIdentityCardId.setToolTipText("身份证号不可更改");
        panel_2.add(driverIdentityCardId);
        driverIdentityCardId.setColumns(10);

        JLabel label_9_1 = new JLabel("移动电话：");
        label_9_1.setHorizontalAlignment(SwingConstants.RIGHT);
        label_9_1.setBounds(65, 254, 96, 15);
        panel_2.add(label_9_1);

        driverPhone = new JTextField();
        driverPhone.setBounds(171, 251, 303, 21);
        panel_2.add(driverPhone);
        driverPhone.setColumns(10);
    }

    public void bondsmanInfo() {
        JPanel panel_3 = new JPanel();
        showInfo.addTab("担保人资料", null, panel_3, null);
        panel_3.setLayout(null);

        JLabel label_2 = new JLabel("姓名：");
        label_2.setHorizontalAlignment(SwingConstants.RIGHT);
        label_2.setBounds(65, 24, 96, 15);
        panel_3.add(label_2);

        bondsmanName = new JTextField();
        bondsmanName.setBounds(171, 21, 114, 21);
        panel_3.add(bondsmanName);
        bondsmanName.setColumns(10);

        JLabel label_3 = new JLabel("性别：");
        label_3.setHorizontalAlignment(SwingConstants.RIGHT);
        label_3.setBounds(65, 70, 96, 15);
        panel_3.add(label_3);

        bondsmanGenderComboBox = new JComboBox(sex);
        bondsmanGenderComboBox.setBounds(171, 67, 114, 21);
        panel_3.add(bondsmanGenderComboBox);

        JLabel label_5 = new JLabel("年龄：");
        label_5.setHorizontalAlignment(SwingConstants.RIGHT);
        label_5.setBounds(65, 115, 96, 15);
        panel_3.add(label_5);

        bondsmanAge = new JTextField();
        bondsmanAge.setColumns(10);
        bondsmanAge.setBounds(171, 112, 114, 21);
        panel_3.add(bondsmanAge);

        JLabel label_7 = new JLabel("身份证号：");
        label_7.setHorizontalAlignment(SwingConstants.RIGHT);
        label_7.setBounds(65, 156, 96, 15);
        panel_3.add(label_7);

        bondsmanIdentityCardId = new JTextField();
        bondsmanIdentityCardId.setBounds(171, 153, 303, 21);
        panel_3.add(bondsmanIdentityCardId);
        bondsmanIdentityCardId.setColumns(10);

        JLabel label_9 = new JLabel("移动电话：");
        label_9.setHorizontalAlignment(SwingConstants.RIGHT);
        label_9.setBounds(65, 195, 96, 15);
        panel_3.add(label_9);

        bondsmanPhone = new JTextField();
        bondsmanPhone.setBounds(171, 192, 303, 21);
        panel_3.add(bondsmanPhone);
        bondsmanPhone.setColumns(10);
    }

    public void companyInfo() {
        JPanel panel_4 = new JPanel();
        showInfo.addTab("企业资料", null, panel_4, null);
        panel_4.setLayout(null);

        JLabel label_2 = new JLabel("企业名称：");
        label_2.setHorizontalAlignment(SwingConstants.RIGHT);
        label_2.setBounds(65, 24, 96, 15);
        panel_4.add(label_2);

        companyName = new JTextField();
        companyName.setBounds(171, 21, 150, 21);
        panel_4.add(companyName);
        companyName.setColumns(10);

        JLabel label_3 = new JLabel("企业类型：");
        label_3.setHorizontalAlignment(SwingConstants.RIGHT);
        label_3.setBounds(65, 70, 96, 15);
        panel_4.add(label_3);

        companyType = new JComboBox();
        companyType.setBounds(171, 67, 150, 21);
        companyType.addItem("国有企业");
        companyType.addItem("集体企业");
        companyType.addItem("股份合作企业");
        companyType.addItem("有限责任公司");
        companyType.addItem("股份有限公司");
        companyType.addItem("私营企业");
        companyType.addItem("外商投资企业");
        companyType.addItem("中外合资经营企业");
        companyType.addItem("港、澳、台商投资企业");
        companyType.addItem("其他企业");
        panel_4.add(companyType);

        JLabel label_5 = new JLabel("企业地址：");
        label_5.setHorizontalAlignment(SwingConstants.RIGHT);
        label_5.setBounds(65, 115, 96, 15);
        panel_4.add(label_5);

        companyAdd = new JTextField();
        companyAdd.setColumns(10);
        companyAdd.setBounds(171, 112, 150, 21);
        panel_4.add(companyAdd);
    }

    public void photo() {
        panel_5 = new JPanel();
        iniCarInputPanel();
        showInfo.addTab("照片", null, panel_5, null);
        panel_5.setLayout(null);

    }

    private void iniCarInputPanel() {
        panel_5.setLayout(null);
        jLabel = new JLabel("客户号：");
        jLabel.setBounds(10, 10, 104, 20);
        jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panel_5.add(jLabel);
        choose = new JComboBox();
        choose.setEditable(true);
        choose.setBounds(120, 10, 175, 20);
        List<Customer> List = new CommonDAOImpl().executeQueryTwo(Customer.class, "SELECT * FROM tb_customer ", null);
        for (Customer s : List) {
            choose.addItem(s.getcId());
        }
        panel_5.add(choose);
        jLabel = new JLabel("选择图片：");
        jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel.setBounds(10, 35, 104, 20);
        panel_5.add(jLabel);
        JButton inputPic = new JButton("选择图片");
        inputPic.setBounds(120, 35, 84, 40);
        inputPic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooserPic = new JFileChooser();
                chooserPic.setApproveButtonText("确定");
                chooserPic.setDialogTitle("选择文件");
                FileNameExtensionFilter pic = new FileNameExtensionFilter(
                        "图片文件(*.jpg)", "jpg");
                chooserPic.setFileFilter(pic);
                int res = chooserPic.showOpenDialog(EditCustomer.this);
                if (res == JFileChooser.APPROVE_OPTION) {
                    File file = chooserPic.getSelectedFile();
                    String fname = chooserPic.getName(file);   //从文件名输入框中获取文件名
                    if (fname.indexOf(".jpg") == -1) {
                        JOptionPane.showMessageDialog(EditCustomer.this, "文件格式不正确");
                        return;
                    }
                    new CropImage(file).setVisible(true);
                    Icon icon;
                    try {
                        icon = new ImageIcon(ImageIO.read(new File("C:\\temp2.jpg")));
                        picLabel.setIcon(icon);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        panel_5.add(inputPic);

        jLabel = new JLabel("预览：");
        jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel.setBounds(10, 80, 104, 20);
        panel_5.add(jLabel);

        picLabel = new JLabel();
        picLabel.setBackground(Color.white);
        picLabel.setBounds(120, 80, 350, 350);
        panel_5.add(picLabel);
    }

    public void initFrame() {
        this.setTitle("客户登记表编辑");
        this.setSize(680, 490);// 设置文本框大小
        this.setResizable(false);
        this.setLocationRelativeTo(null);
//        try {
//            // UIManager.setLookAndFeel("com.whitenkov.darcula.DarculaLaf");
//            // DarculaLaf主题最后统一换
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (UnsupportedLookAndFeelException e) {
//            e.printStackTrace();
//        }
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int exitChoose = JOptionPane.showConfirmDialog(EditCustomer.this, "确定要退出吗?", "退出提示", JOptionPane.OK_CANCEL_OPTION);
                if (exitChoose == JOptionPane.OK_OPTION) {
//		        	Register.this.dispose(); //退出本界面
                    //System.exit(0);
                    dispose();
                } else {
                    return;
                }
            }
        });
    }

    // 时间框设置
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

    // 客户表存盘
    public int cunClient() {
        // 第一步，创建一个webbook,对应一个Excel文件
        XSSFWorkbook wb = new XSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        XSSFSheet sheet = wb.createSheet("客户表");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        XSSFRow row = sheet.createRow((int) 0);
        XSSFCell cell = row.createCell((short) 0);
        cell.setCellValue("客户号");
        cell = row.createCell((short) 1);
        cell.setCellValue("起始日期");
        cell = row.createCell((short) 2);
        cell.setCellValue("终止日期");
        cell = row.createCell((short) 3);
        cell.setCellValue("姓名");
        cell = row.createCell((short) 4);
        cell.setCellValue("性别");
        cell = row.createCell((short) 5);
        cell.setCellValue("客户类型");
        cell = row.createCell((short) 6);
        cell.setCellValue("密码");
        cell = row.createCell((short) 7);
        cell.setCellValue("初次领证日期");
        cell = row.createCell((short) 8);
        cell.setCellValue("准驾类型");
        cell = row.createCell((short) 9);
        cell.setCellValue("身份证号");
        cell = row.createCell((short) 10);
        cell.setCellValue("联系电话");
        cell = row.createCell((short) 11);
        cell.setCellValue("移动电话");
        cell = row.createCell((short) 12);
        cell.setCellValue("家庭地址");
        cell = row.createCell((short) 13);
        cell.setCellValue("工作单位");
        cell = row.createCell((short) 14);
        cell.setCellValue("单位地址");
        cell = row.createCell((short) 15);
        cell.setCellValue("应收会费");
        cell = row.createCell((short) 16);
        cell.setCellValue("实收会费");
        // TODO 存盘excel文件
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
        // java.awt和java.util下都有list要声明正确
        java.util.List<Customer> list = new CustomerDAO().getAllInfFormTb_customer("tb_customer");
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow((int) i + 1);
            Customer cusInf = list.get(i);
            // 创建单元格，并设置值
            row.createCell(0).setCellValue(cusInf.getcId());
            row.createCell(1).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(cusInf.getStartTime()));
            row.createCell(2).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(cusInf.getEndTime()));
            row.createCell(3).setCellValue(cusInf.getCustomerName());
            row.createCell(4).setCellValue(cusInf.getCustomerSex());
            row.createCell(5).setCellValue(cusInf.getCustomerType());
            row.createCell(6).setCellValue(cusInf.getCustomerPsd());
            row.createCell(7).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(cusInf.getLingZhengTime()));
            row.createCell(8).setCellValue(cusInf.getZhunJiaType());
            row.createCell(9).setCellValue(cusInf.getCreditId());
            row.createCell(10).setCellValue(cusInf.getOfficeTel());
            row.createCell(11).setCellValue(cusInf.getMobileTel());
            row.createCell(12).setCellValue(cusInf.getHomeAddress());
            row.createCell(13).setCellValue(cusInf.getGongSiName());
            row.createCell(14).setCellValue(cusInf.getGongSiAddress());
            row.createCell(15).setCellValue(String.valueOf(cusInf.getYingShouFee()));
            row.createCell(16).setCellValue(String.valueOf(cusInf.getShiShouFee()));
        }
        return saveFile(wb);
    }

    // 驾驶员表存盘
    public int cunDriver() {
        // 第一步，创建一个webbook,对应一个Excel文件
        XSSFWorkbook wb = new XSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        XSSFSheet sheet = wb.createSheet("驾驶员表");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        XSSFRow row = sheet.createRow((int) 0);
//        // 第四步，创建单元格，并设置值表头 设置表头居中
//        HSSFCellStyle style = wb.createCellStyle();
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 创建一个居中格式
        XSSFCell cell = row.createCell((short) 0);
        cell.setCellValue("驾驶员姓名");
        //cell.setCellStyle(style);
        cell = row.createCell((short) 1);
        cell.setCellValue("驾驶员性别");
        //cell.setCellStyle(style);
        cell = row.createCell((short) 2);
        cell.setCellValue("驾龄");
        //cell.setCellStyle(style);
        cell = row.createCell((short) 3);
        cell.setCellValue("驾驶员类型");
        // cell.setCellStyle(style);
        cell = row.createCell((short) 4);
        cell.setCellValue("身份证号");
        //cell.setCellStyle(style);
        cell = row.createCell((short) 5);
        cell.setCellValue("移动电话");
        //cell.setCellStyle(style);
        cell = row.createCell((short) 6);
        cell.setCellValue("客户号");
        // cell.setCellStyle(style);
        // TODO 存盘excel文件
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
        // java.awt和java.util下都有list要声明正确
        java.util.List<Driver> list = new DriverDAO().getAllInfFormTb_driver("tb_driver");
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow((int) i + 1);
            Driver driInf = list.get(i);
            // 创建单元格，并设置值
            row.createCell(0).setCellValue(driInf.getDriverName());
            row.createCell(1).setCellValue(driInf.getDriverSex());
            row.createCell(2).setCellValue(driInf.getDriverAge());
            row.createCell(3).setCellValue(driInf.getDriverType());
            row.createCell(4).setCellValue(driInf.getDriverId());
            row.createCell(5).setCellValue(driInf.getDriverPhone());
            row.createCell(6).setCellValue(driInf.getcId());
        }
        return saveFile(wb);
    }

    // 担保人表存盘
    public int cunBondsman() {
        // 第一步，创建一个webbook,对应一个Excel文件
        XSSFWorkbook wb = new XSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        XSSFSheet sheet = wb.createSheet("担保人表");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        XSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        XSSFCell cell = row.createCell((short) 0);
        cell.setCellValue("担保人姓名");
        cell = row.createCell((short) 1);
        cell.setCellValue("担保人性别");
        cell = row.createCell((short) 2);
        cell.setCellValue("年龄");
        cell = row.createCell((short) 3);
        cell.setCellValue("身份证号");
        cell = row.createCell((short) 4);
        cell.setCellValue("移动电话");
        cell = row.createCell((short) 5);
        cell.setCellValue("客户号");
        // TODO 存盘excel文件
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
        // java.awt和java.util下都有list要声明正确
        java.util.List<Bondsman> list = new BondsmanDAO().getAllInfFormTb_bondsman("tb_bondsman");
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow((int) i + 1);
            Bondsman bonInf = list.get(i);
            // 创建单元格，并设置值
            row.createCell(0).setCellValue(bonInf.getBondsmanName());
            row.createCell(1).setCellValue(bonInf.getBondsmanSex());
            row.createCell(2).setCellValue(bonInf.getBondsmanAge());
            row.createCell(3).setCellValue(bonInf.getBondsmanId());
            row.createCell(4).setCellValue(bonInf.getBondsmanPhone());
            row.createCell(6).setCellValue(bonInf.getcId());
        }
        return saveFile(wb);
    }

    // 企业表存盘
    public int cunCompany() {
        // 第一步，创建一个webbook,对应一个Excel文件
        XSSFWorkbook wb = new XSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        XSSFSheet sheet = wb.createSheet("企业表");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        XSSFRow row = sheet.createRow((int) 0);
        XSSFCell cell = row.createCell((short) 0);
        cell.setCellValue("企业名称");
        cell = row.createCell((short) 1);
        cell.setCellValue("企业类型");
        cell = row.createCell((short) 2);
        cell.setCellValue("企业地址");
        cell = row.createCell((short) 3);
        cell.setCellValue("客户号");
        // TODO 存盘excel文件
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
        // java.awt和java.util下都有list要声明正确
        java.util.List<Company> list = new CompanyDAO().getAllInfFormTb_company("tb_company");
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow((int) i + 1);
            Company comInf = list.get(i);
            // 创建单元格，并设置值
            row.createCell(0).setCellValue(comInf.getCompanyName());
            row.createCell(1).setCellValue(comInf.getCompanyType());
            row.createCell(2).setCellValue(comInf.getCompanyAddr());
            row.createCell(3).setCellValue(comInf.getcId());
        }
        return saveFile(wb);
    }

    private int saveFile(XSSFWorkbook wb) {
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel 文件(*.xlsx)", "xlsx");
        jfc.setFileFilter(filter);
        int option = jfc.showSaveDialog(EditCustomer.this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            String fname = jfc.getName(file); // 从文件名输入框中获取文件名
            // 假如用户填写的文件名不带我们制定的后缀名，那么我们给它添上后缀
            if (fname.indexOf(".xlsx") == -1) {
                file = new File(jfc.getCurrentDirectory(), fname + ".xlsx");
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

    private void outputInf(int i) {
        switch (i) {
            case 0:
                JOptionPane.showMessageDialog(EditCustomer.this, "导出成功！", "成功！", JOptionPane.WARNING_MESSAGE);
                break;
            case 1:
                JOptionPane.showMessageDialog(EditCustomer.this, "导出失败！", "错误！", JOptionPane.ERROR_MESSAGE);
                break;
            default:
                break;
        }
    }

    private boolean judgeCustomerInputInf() {
        if (!(regex.isCustomerNo(clientId.getText()))) {
            //JOptionPane.showMessageDialog(EditCustomer.this, "客户号格式不正确！");
            showWarning("客户号格式不正确!", "正确格式如：C00000");
            return false;
        }
        if (!(regex.isIdNo(clientIdentityCardId.getText()))) {
            //JOptionPane.showMessageDialog(EditCustomer.this, "身份证格式不正确！");
            showWarning("身份证", "格式不正确！");
            return false;
        }
        if (!(regex.isPhone(clientTel.getText()))) {
            //JOptionPane.showMessageDialog(EditCustomer.this, "固话格式不正确！");
            showWarning("固话", "格式不正确！");
            return false;
        }
        if (!(regex.isTel(clientPhone.getText()))) {
            //JOptionPane.showMessageDialog(EditCustomer.this, "手机号格式不正确！");
            showWarning("手机号", "格式不正确！");
            return false;
        }
        if (!(regex.isAllNum(yingShouMembershipFee.getText()))) {
            //JOptionPane.showMessageDialog(EditCustomer.this, "应收会费不正确！");
            showWarning("应收会费", "格式不正确！");
            return false;
        }
        if (!(regex.isAllNum(shiShouMembershipFee.getText()))) {
            //JOptionPane.showMessageDialog(EditCustomer.this, "实收会费不正确！");
            showWarning("实收会费", "格式不正确！");
            return false;
        }
        return true;
    }

    private boolean judgedriverInputInf() {
        if (!(regex.isCustomerNo(clientId.getText()))) {
            //JOptionPane.showMessageDialog(EditCustomer.this, "客户号格式不正确！");
            showWarning("客户号格式不正确!", "正确格式如：C00000");
            return false;
        }
        if (!(regex.isIdNo(driverIdentityCardId.getText()))) {
            //JOptionPane.showMessageDialog(EditCustomer.this, "身份证格式不正确！");
            showWarning("身份证", "格式不正确！");
            return false;
        }
        if (!(regex.isTel(driverPhone.getText()))) {
            //JOptionPane.showMessageDialog(EditCustomer.this, "手机号格式不正确！");
            showWarning("手机号", "格式不正确！");
            return false;
        }
        if (!(regex.isAllNum(drivingAge.getText()))) {
            //JOptionPane.showMessageDialog(EditCustomer.this, "驾龄格式不正确！");
            showWarning("驾龄", "格式不正确！");
            return false;
        } else if (Integer.parseInt(drivingAge.getText()) > 50) {
            //JOptionPane.showMessageDialog(EditCustomer.this, "驾龄超过限制！");
            showWarning("驾龄", "超过限制！");
            return false;
        }
        return true;
    }

    private boolean judgeBoundsInputInf() {
        if (!(regex.isCustomerNo(clientId.getText()))) {
            //JOptionPane.showMessageDialog(EditCustomer.this, "客户号格式不正确！");
            showWarning("客户号格式不正确!", "正确格式如：C00000");
            return false;
        }
        if (!(regex.isIdNo(bondsmanIdentityCardId.getText()))) {
            //JOptionPane.showMessageDialog(EditCustomer.this, "身份证格式不正确！");
            showWarning("身份证", "格式不正确！");
            return false;
        }
        if (!(regex.isTel(bondsmanPhone.getText()))) {
            //JOptionPane.showMessageDialog(EditCustomer.this, "手机号格式不正确！");
            showWarning("手机号", "格式不正确！");
            return false;
        }

        if (!(regex.isAllNum(bondsmanAge.getText()))) {
            //JOptionPane.showMessageDialog(EditCustomer.this, "年龄格式不正确！");
            showWarning("年龄", "格式不正确！");
            return false;
        } else if (Integer.parseInt(bondsmanAge.getText()) > 100) {
            //JOptionPane.showMessageDialog(EditCustomer.this, "年龄超过限制！");
            showWarning("年龄", "超过限制！");
            return false;
        }
        return true;
    }

    private void showWarning(String Inf, String Body) {
        warningInf.setText(Inf);
        warningBody.setText(Body);
    }
}

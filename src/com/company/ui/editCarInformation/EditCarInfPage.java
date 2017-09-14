package com.company.ui.editCarInformation;

import com.company.ui.changeSkin.ChangeSkin;
import com.company.dao.CommonDAOImpl;
import com.company.dao.DBTool;
import com.company.entity.CarInformation;
import com.company.other.Regex;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

/**
 * @author student Ross
 * @2017��8��30��
 */
public class EditCarInfPage extends JDialog {
    private JLabel warningInf;
    private JLabel warningBody;
    private Regex regex = new Regex();
    private int idIdentify;
    private CommonDAOImpl commonDAO = new CommonDAOImpl();
    private ChangeSkin changeSkin;
    private boolean skin;
    private JPanel mianBody;
    private JTabbedPane jTabbedPane;
    private JPanel basicData;
    private JPanel carInf;
    private JPanel demo;
    private JCheckBox jCheckBox;
    private JButton jButtonPrint;
    private JButton jButtonAdd;
    private JButton jButtonSave;
    private JButton jButtonCancel;
    private JButton jButtonBack;
    private JButton jButtonChangeSkin;
    private JButton jButtonUpdate;

    private JTextField jTextFieldCarNo;
    private JTextField jTextFieldOutFactoryNo;
    private JTextField jTextFieldDIPANNo;
    private JTextField jTextFieldPrice;
    private JTextField jTextFieldGetCarNoFee;
    private JTextField jTextFieldCarOwnerName;
    private JTextField jTextFieldStartMils;
    private JTextField erBaoMils;
    private JTextField enginerNo;
    private JTextField purchaseTax;
    private JTextField decorationFee;
    private JTextField telNo;
    private JTextField nowMils;
    private JTextField nextErBao;
    private JComboBox carClass;
    private JComboBox color;
    private JComboBox seatNum;
    private JSpinner buyyingTime;//����ʱ��
    private JSpinner YLFTime;   //��·��
    private JSpinner YLFEndTime;
    private JSpinner NSTime;    //����
    private JSpinner NSEndTime;
    private JSpinner BXTime;    //����
    private JSpinner BXEndTime;
    private JSpinner CCSTime;   //����˰
    private JSpinner CCSEndTime;
    private JSpinner LQPTime;   //·��Ʊ
    private JSpinner LQPEndTime;
    private JSpinner YYZTime;   //��Ӫ֤
    private JSpinner YYZEndTime;
    private JSpinner GLFTime;   //�����
    private JSpinner GLFEndTime;
    private JLabel picLabel;
    private JComboBox choose;

    private JLabel jLabel;
    private String[] carTyle = {"С�γ�", "�аͳ�", "�󿨳�"};
    private String[] carColor = {"��", "��", "��"};
    private String[] carSeat = {"4", "5", "6", "7"};
    private String[] basicDateName = {
            "���ƺţ�", "���ͣ�", "������ţ�", "���̱�ţ�", "����۸�", "���Ʒѣ�", "����������", "��ʼ��������"
            , "��·�ѹ���ʱ�䣺", "����ʱ�䣺", "���չ���ʱ�䣺", "����˰����ʱ�䣺", "·��Ʊ����ʱ�䣺", "��Ӫ֤����ʱ�䣺", "��Ӫ֤����ʱ�䣺", "������̣�"
            , "����ʱ�䣺", "��ɫ��", "�������ţ�", "��λ����", "����˰��", "����װ�Σ�", "��ϵ�绰��", "��ǰ��������"
            , "��ֹʱ�䣺", "��ֹʱ�䣺", "��ֹʱ�䣺", "��ֹʱ�䣺", "��ֹʱ�䣺", "��ֹʱ�䣺", "��ֹʱ�䣺", "�´ζ�����"};
    private Date today;
    private Date nextyearToday;

    public EditCarInfPage(int i) {
        idIdentify = i;
        setModal(true);
        iniFrame();
        iniBody();
        judgeID();
        this.add(mianBody);
    }

    private void iniBody() {
        mianBody = new JPanel();
        mianBody.setLayout(null);
        jCheckBox = new JCheckBox("ͣ��");
        jCheckBox.setBounds(585, 50, 60, 20);
        jCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jCheckBox.isSelected()) {
                    StringBuffer stringBuffer = new StringBuffer("UPDATE tb_car SET isBlockUp = ");
                    String warning = new String();
                    if (!(commonDAO.searchClo(jTextFieldCarNo.getText(), "tb_car", "Car_Id"))) {
                        JOptionPane.showMessageDialog(EditCarInfPage.this, "û�иó��ƣ�", "����", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    stringBuffer.append(0);
                    stringBuffer.append(" WHERE Car_Id = '");
                    stringBuffer.append(jTextFieldCarNo.getText());
                    stringBuffer.append("' ");
                    if (commonDAO.executeUpdate(stringBuffer.toString(), null) > 0) {
                        warning = "ͣ�óɹ���";
                    } else {
                        warning = "ͣ��ʧ��";
                    }
                    JOptionPane.showMessageDialog(EditCarInfPage.this, warning);
                    return;
                } else {
                    StringBuffer stringBuffer = new StringBuffer("UPDATE tb_car SET isBlockUp = ");
                    String warning = new String();
                    if (!(commonDAO.searchClo(jTextFieldCarNo.getText(), "tb_car", "Car_Id"))) {
                        JOptionPane.showMessageDialog(EditCarInfPage.this, "û�иó��ƣ�", "����", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    stringBuffer.append(1);
                    stringBuffer.append(" WHERE Car_Id = '");
                    stringBuffer.append(jTextFieldCarNo.getText());
                    stringBuffer.append("' ");
                    if (commonDAO.executeUpdate(stringBuffer.toString(), null) > 0) {
                        warning = "�ָ����óɹ���";
                    } else {
                        warning = "�ָ�����ʧ��";
                    }
                    JOptionPane.showMessageDialog(EditCarInfPage.this, warning);
                    return;
                }
            }
        });

        warningInf = new JLabel();
        warningInf.setForeground(Color.RED);
        warningInf.setBounds(585, 100, 84, 30);
        mianBody.add(warningInf);
        warningBody = new JLabel();
        warningBody.setForeground(Color.RED);
        warningBody.setBounds(585, 120, 84, 30);
        mianBody.add(warningBody);

//        jButtonPrint = new JButton("��ӡ����");
//        jButtonPrint.setBounds(585, 210, 84, 40);
//        jButtonPrint.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
////                Properties p = new Properties();
////                PrintJob jp = Toolkit.getDefaultToolkit().getPrintJob(EditCarInfPage.this, "�ͻ��ǼǱ�༭", p);
////                Graphics pg = jp.getGraphics();//Graphics��ӡͼ�ε�ͼ�λ���
////                if (pg != null) {
////                    try {
////                        EditCarInfPage.this.printAll(pg); //��ӡ�ô��弰�����е����
////                    } finally {
////                        pg.dispose(); //ע��ͼ�λ���
////                    }
////                }
////                jp.end(); //������ӡ��ҵ
//            }
//        });

        jButtonAdd = new JButton("����(A)");
        jButtonAdd.setBounds(585, 250, 84, 40);
        jButtonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (jTabbedPane.getSelectedIndex()) {
                    case 0:
                        if (isInfRight()) {
                            if (commonDAO.searchClo(jTextFieldCarNo.getText(), "tb_car", "Car_Id")) {
                                JOptionPane.showMessageDialog(EditCarInfPage.this, "���˻���������û�б�����", "����", JOptionPane.WARNING_MESSAGE);
                                return;
                            }
                            if (commonDAO.add2(getPanelINf(), "tb_car") != 0) {
                                JOptionPane.showMessageDialog(EditCarInfPage.this, "��ӳɹ���", "�ɹ���", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                        break;
                    case 1:
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
                            //����˵����PreparedStatement.setBinaryStream(int parameterIndex, InputStream x, int length)
                            res = ptmt.executeUpdate();
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        } finally {
                            if (res > 0) {
                                JOptionPane.showMessageDialog(EditCarInfPage.this, "�ɹ���");
                            } else {
                                JOptionPane.showMessageDialog(EditCarInfPage.this, "ʧ�ܣ�");
                            }
                        }

                }
            }
        });
        jButtonUpdate = new JButton("����(U)");
        jButtonUpdate.setBounds(585, 290, 84, 40);
        jButtonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (jTabbedPane.getSelectedIndex()) {
                    case 0:
                        if (isInfRight()) {
                            if (!(commonDAO.searchClo(jTextFieldCarNo.getText(), "tb_car", "Car_Id"))) {
                                JOptionPane.showMessageDialog(EditCarInfPage.this, "û�����ݻ����£�������û�е������", "����", JOptionPane.WARNING_MESSAGE);
                                return;
                            }
                            if (commonDAO.update2(getPanelINf(), "tb_car") != 0) {
                                JOptionPane.showMessageDialog(EditCarInfPage.this, "���³ɹ���", "�ɹ���", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                        break;
                    case 1:
                        int res = 0;
                        String sql = "UPDATE image SET content=? where name=?";
                        Connection con = DBTool.getInstance().getConnection();
                        PreparedStatement ptmt = null;
                        try {
                            ptmt = con.prepareStatement(sql);
                            ptmt.setString(2, (String) choose.getSelectedItem());
                            InputStream is = null;
                            is = new FileInputStream("C:\\temp.jpg");
                            ptmt.setBinaryStream(1, is, is.available());
                            //����˵����PreparedStatement.setBinaryStream(int parameterIndex, InputStream x, int length)
                            res = ptmt.executeUpdate();
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        } finally {
                            if (res > 0) {
                                JOptionPane.showMessageDialog(EditCarInfPage.this, "�ɹ���");
                            } else {
                                JOptionPane.showMessageDialog(EditCarInfPage.this, "ʧ�ܣ�");
                            }
                        }
                }
            }
        });
        jButtonSave = new JButton("����(S)");
        jButtonSave.setBounds(585, 330, 84, 40);
        jButtonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(EditCarInfPage.this, "��Ҫ�������ݿ�ȫ��������Ϣ���Ƿ������", "���棡", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (res == JOptionPane.OK_OPTION) {
                    switch (saveASExcel()) {
                        case 0:
                            JOptionPane.showMessageDialog(EditCarInfPage.this, "�����ɹ���", "�ɹ���", JOptionPane.WARNING_MESSAGE);
                            break;
                        case 1:
                            JOptionPane.showMessageDialog(EditCarInfPage.this, "����ʧ�ܣ�", "����", JOptionPane.ERROR_MESSAGE);
                            break;
                        default:
                            break;
                    }
                }
                return;
            }
        });
        jButtonCancel = new JButton("ȡ��(C)");
        jButtonCancel.setBounds(585, 370, 84, 40);
        jButtonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextFieldCarNo.setText("");
                jTextFieldOutFactoryNo.setText("");
                jTextFieldDIPANNo.setText("");
                jTextFieldPrice.setText("");
                jTextFieldGetCarNoFee.setText("");
                jTextFieldCarOwnerName.setText("");
                jTextFieldStartMils.setText("");
                erBaoMils.setText("");
                enginerNo.setText("");
                purchaseTax.setText("");
                decorationFee.setText("");
                telNo.setText("");
                nowMils.setText("");
                nextErBao.setText("");
            }
        });
        jButtonBack = new JButton("����(R)");
        jButtonBack.setBounds(585, 410, 84, 40);
        jButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        iniTabbedPanel();

        jButtonChangeSkin = new JButton("����");
        jButtonChangeSkin.setBounds(585, 210, 84, 40);
        jButtonChangeSkin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeSkin = new ChangeSkin(skin);
                int back = changeSkin.showChangeSkin(EditCarInfPage.this);
                if (back == changeSkin.APPROVE_OPTION) {
                    skin = changeSkin.returnSkinStyle();
                    changeSkin();
                    revalidate();
                }
            }
        });

        mianBody.add(jButtonChangeSkin);
        mianBody.add(jCheckBox);
        //mianBody.add(jButtonPrint);
        mianBody.add(jButtonAdd);
        mianBody.add(jButtonSave);
        mianBody.add(jButtonCancel);
        mianBody.add(jButtonBack);
        mianBody.add(jTabbedPane);
        mianBody.add(jButtonUpdate);
    }

    private CarInformation getPanelINf() {
        CarInformation carInformation = new CarInformation();
        carInformation.setCar_Id(jTextFieldCarNo.getText());
        System.out.println(carTyle[carClass.getSelectedIndex()]);
        carInformation.setCar_Type(carTyle[carClass.getSelectedIndex()]);
        carInformation.setChuchang_Id(jTextFieldOutFactoryNo.getText());
        carInformation.setDipan_Id(jTextFieldDIPANNo.getText());
        carInformation.setBuy_Price(new BigDecimal(jTextFieldPrice.getText()));
        carInformation.setShangpai_fee(new BigDecimal(jTextFieldGetCarNoFee.getText()));
        carInformation.setChezhu_Name(jTextFieldCarOwnerName.getText());
        carInformation.setStart_Gongli(new BigDecimal(jTextFieldStartMils.getText()));

        carInformation.setYLF_Starttime(new Timestamp(((Date) YLFTime.getValue()).getTime()));
        carInformation.setNS_Starttime(new Timestamp(((Date) NSTime.getValue()).getTime()));
        carInformation.setBX_Starttime(new Timestamp(((Date) BXTime.getValue()).getTime()));
        carInformation.setCCS_Starttime(new Timestamp(((Date) CCSTime.getValue()).getTime()));
        carInformation.setLQP_Starttime(new Timestamp(((Date) LQPTime.getValue()).getTime()));
        carInformation.setYYZ_Starttime(new Timestamp(((Date) YYZTime.getValue()).getTime()));
        carInformation.setYGF_Starttime(new Timestamp(((Date) GLFTime.getValue()).getTime()));
        carInformation.setErbaolicheng(new BigDecimal(erBaoMils.getText()));

        carInformation.setBuy_Time(new Timestamp(((Date) buyyingTime.getValue()).getTime()));
        carInformation.setCar_Color((String) color.getSelectedItem());
        carInformation.setMotor_Id(enginerNo.getText());
        carInformation.setChair_Num((String) seatNum.getSelectedItem());
        carInformation.setBuy_tax(new BigDecimal(purchaseTax.getText()));
        System.out.println(new BigDecimal(decorationFee.getText()));
        carInformation.setCar_Zhuangshi(new BigDecimal(decorationFee.getText()));
        carInformation.setTel(telNo.getText());
        carInformation.setCurrent_Gongli(new BigDecimal(nowMils.getText()));

        carInformation.setYLF_Endtime(new Timestamp(((Date) YLFEndTime.getValue()).getTime()));
        carInformation.setNS_Endtime(new Timestamp(((Date) NSEndTime.getValue()).getTime()));
        carInformation.setBX_Endtime(new Timestamp(((Date) BXEndTime.getValue()).getTime()));
        carInformation.setCCS_Endtime(new Timestamp(((Date) CCSEndTime.getValue()).getTime()));
        carInformation.setLQP_Endtime(new Timestamp(((Date) LQPEndTime.getValue()).getTime()));
        carInformation.setYYZ_Endtime(new Timestamp(((Date) YYZEndTime.getValue()).getTime()));
        carInformation.setYGF_Endtime(new Timestamp(((Date) GLFEndTime.getValue()).getTime()));
        carInformation.setNextErbao(new BigDecimal(nextErBao.getText()));

        return carInformation;
    }

    //�������������ƣ���Ҫ����´���
    private void changeSkin() {
        try {
            if (!skin) {
                UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
            } else {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    SwingUtilities.updateComponentTreeUI(EditCarInfPage.this);
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

    private void iniTabbedPanel() {
        jTabbedPane = new JTabbedPane();
        jTabbedPane.setBounds(5, 5, 575, 452);
        basicData = new JPanel();
        basicData.setLayout(null);
        basicData.setBorder(BorderFactory.createEtchedBorder());
        iniBasicData();
        jTabbedPane.addTab("��������", null, basicData, "��������");
        carInf = new JPanel();
        carInf.setBorder(BorderFactory.createEtchedBorder());
        iniCarInputPanel();
        jTabbedPane.addTab("������Ƭ", null, carInf, "��Ƭ");
        demo = new JPanel();
        demo.setBorder(BorderFactory.createEtchedBorder());
        jTabbedPane.addTab("��ע", null, demo, "��ע");
    }

    private void iniCarInputPanel() {
        carInf.setLayout(null);
        jLabel = new JLabel("���ƺţ�");
        jLabel.setBounds(10, 10, 104, 20);
        jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        carInf.add(jLabel);
        choose = new JComboBox();
        choose.setEditable(true);
        choose.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!(regex.isCar((String) choose.getSelectedItem()))) {
                    showWarning("���ƺ�", "��ʽ����ȷ��");
                }
            }
        });
        choose.setBounds(120, 10, 175, 20);
        List<CarInformation> List = new CommonDAOImpl().executeQuery(CarInformation.class, "SELECT * FROM tb_car ", null);
        for (CarInformation s : List) {
            choose.addItem(s.getCar_Id());
        }
        carInf.add(choose);
        jLabel = new JLabel("ѡ��ͼƬ��");
        jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel.setBounds(10, 35, 104, 20);
        carInf.add(jLabel);
        JButton inputPic = new JButton("ѡ��ͼƬ");
        inputPic.setBounds(120, 35, 84, 40);
        inputPic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooserPic = new JFileChooser();
                chooserPic.setApproveButtonText("ȷ��");
                chooserPic.setDialogTitle("ѡ���ļ�");
                FileNameExtensionFilter pic = new FileNameExtensionFilter(
                        "ͼƬ�ļ�(*.jpg)", "jpg");
                chooserPic.setFileFilter(pic);
                int res = chooserPic.showOpenDialog(EditCarInfPage.this);
                if (res == JFileChooser.APPROVE_OPTION) {
                    File file = chooserPic.getSelectedFile();
                    String fname = chooserPic.getName(file);//���ļ���������л�ȡ�ļ���
                    if (fname.indexOf(".jpg") == -1) {
                        JOptionPane.showMessageDialog(EditCarInfPage.this, "�ļ���ʽ����ȷ");
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
        carInf.add(inputPic);

        jLabel = new JLabel("Ԥ����");
        jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel.setBounds(10, 80, 104, 20);
        carInf.add(jLabel);

        picLabel = new JLabel();
        picLabel.setBackground(Color.white);
        picLabel.setBounds(120, 80, 350, 350);
        carInf.add(picLabel);
    }

    private void iniBasicData() {
        Calendar calendar = Calendar.getInstance();
        today = new Date(System.currentTimeMillis());
        calendar.setTime(today);
//        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        calendar.add(Calendar.YEAR, 1);
        nextyearToday = (Date) calendar.getTime();
        for (int i = 0; i < basicDateName.length; i++) {
            basicData.add(setjLabel(basicDateName[i], i));
        }
        jTextFieldCarNo = new JTextField();
        jTextFieldCarNo.setBounds(120, 15, 175, 20);
        jTextFieldCarNo.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!(regex.isCar(jTextFieldCarNo.getText()))) {
                    //JOptionPane.showMessageDialog(EditCarInfPage.this, "���Ƹ�ʽ����ȷ��");
                    showWarning("���ƺ�", "��ʽ����ȷ��");
                }
            }
        });
        basicData.add(jTextFieldCarNo);
        jTextFieldOutFactoryNo = new JTextField();
        carClass = new JComboBox(carTyle);
        carClass.setBounds(120, 40, 175, 22);
        basicData.add(carClass);
        jTextFieldOutFactoryNo.setBounds(120, 65, 175, 20);
        basicData.add(jTextFieldOutFactoryNo);
        jTextFieldDIPANNo = new JTextField();
        jTextFieldDIPANNo.setBounds(120, 90, 175, 20);
        basicData.add(jTextFieldDIPANNo);
        jTextFieldPrice = new JTextField();
        jTextFieldPrice.setBounds(120, 115, 175, 20);
        jTextFieldPrice.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!(regex.isAllNum(jTextFieldPrice.getText()))) {
                    //JOptionPane.showMessageDialog(EditCarInfPage.this, "�۸��ʽ����ȷ��");
                    showWarning("�۸�", "��ʽ����ȷ��");
                }
            }
        });
        basicData.add(jTextFieldPrice);
        jTextFieldGetCarNoFee = new JTextField();
        jTextFieldGetCarNoFee.setBounds(120, 140, 175, 20);
        jTextFieldGetCarNoFee.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!(regex.isAllNum(jTextFieldGetCarNoFee.getText()))) {
                    //JOptionPane.showMessageDialog(EditCarInfPage.this, "���ƷѸ�ʽ����ȷ��");
                    showWarning("���Ʒ�", "��ʽ����ȷ��");
                }
            }
        });
        basicData.add(jTextFieldGetCarNoFee);
        jTextFieldCarOwnerName = new JTextField();
        jTextFieldCarOwnerName.setBounds(120, 165, 175, 20);
        basicData.add(jTextFieldCarOwnerName);
        jTextFieldStartMils = new JTextField();
        jTextFieldStartMils.setBounds(120, 190, 175, 20);
        jTextFieldStartMils.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!(regex.isAllNum(jTextFieldStartMils.getText()))) {
                    //JOptionPane.showMessageDialog(EditCarInfPage.this, "��ʼ��̸�ʽ����ȷ��");
                    showWarning("��ʼ���", "��ʽ����ȷ��");
                }
            }
        });
        basicData.add(jTextFieldStartMils);

        YLFTime = setJSpinner(YLFTime, today, true);
        YLFTime.setBounds(120, 215, 175, 22);
        basicData.add(YLFTime);
        NSTime = setJSpinner(NSTime, today, true);
        NSTime.setBounds(120, 240, 175, 22);
        basicData.add(NSTime);
        BXTime = setJSpinner(BXTime, today, true);
        BXTime.setBounds(120, 265, 175, 22);
        basicData.add(BXTime);
        CCSTime = setJSpinner(CCSTime, today, true);
        CCSTime.setBounds(120, 290, 175, 22);
        basicData.add(CCSTime);
        LQPTime = setJSpinner(LQPTime, today, true);
        LQPTime.setBounds(120, 315, 175, 22);
        basicData.add(LQPTime);
        YYZTime = setJSpinner(YYZTime, today, true);
        YYZTime.setBounds(120, 340, 175, 22);
        basicData.add(YYZTime);
        GLFTime = setJSpinner(GLFTime, today, true);
        GLFTime.setBounds(120, 365, 175, 22);
        basicData.add(GLFTime);
        erBaoMils = new JTextField();
        erBaoMils.setBounds(120, 390, 175, 20);
        erBaoMils.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!(regex.isAllNum(erBaoMils.getText()))) {
                    showWarning("�������", "��ʽ����ȷ��");
                }
            }
        });
        basicData.add(erBaoMils);

        buyyingTime = setJSpinner(buyyingTime, today, true);
        buyyingTime.setBounds(385, 15, 175, 22);
        basicData.add(buyyingTime);
        color = new JComboBox(carColor);
        color.setEditable(true);
        color.setBounds(385, 40, 175, 22);
        basicData.add(color);
        enginerNo = new JTextField();
        enginerNo.setBounds(385, 65, 175, 20);
        basicData.add(enginerNo);
        seatNum = new JComboBox(carSeat);
        seatNum.setEditable(true);
        seatNum.setBounds(385, 90, 175, 22);
        basicData.add(seatNum);
        purchaseTax = new JTextField();
        purchaseTax.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!(regex.isAllNum(purchaseTax.getText()))) {
                    showWarning("����˰", "��ʽ����ȷ��");
                }
            }
        });
        purchaseTax.setBounds(385, 115, 175, 20);
        basicData.add(purchaseTax);
        decorationFee = new JTextField();
        decorationFee.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!(regex.isAllNum(decorationFee.getText()))) {
                    showWarning("����װ�η�", "��ʽ����ȷ��");
                }
            }
        });
        decorationFee.setBounds(385, 140, 175, 20);
        basicData.add(decorationFee);
        telNo = new JTextField();
        telNo.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!(regex.isTel(telNo.getText()))) {
                    showWarning("��ϵ�绰(�ֻ�)", "��ʽ����ȷ��");
                }
            }
        });
        telNo.setBounds(385, 165, 175, 20);
        basicData.add(telNo);
        nowMils = new JTextField();
        nowMils.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!(regex.isAllNum(nowMils.getText()))) {
                    showWarning("��ǰ���", "��ʽ����ȷ��");
                }
            }
        });
        nowMils.setBounds(385, 190, 175, 20);
        basicData.add(nowMils);


        YLFEndTime = setJSpinner(YLFEndTime, nextyearToday, false);
        YLFEndTime.setBounds(385, 215, 175, 22);
        basicData.add(YLFEndTime);
        NSEndTime = setJSpinner(NSEndTime, nextyearToday, false);
        NSEndTime.setBounds(385, 240, 175, 22);
        basicData.add(NSEndTime);
        BXEndTime = setJSpinner(BXEndTime, nextyearToday, false);
        BXEndTime.setBounds(385, 265, 175, 22);
        basicData.add(BXEndTime);
        CCSEndTime = setJSpinner(CCSEndTime, nextyearToday, false);
        CCSEndTime.setBounds(385, 290, 175, 22);
        basicData.add(CCSEndTime);
        LQPEndTime = setJSpinner(LQPEndTime, nextyearToday, false);
        LQPEndTime.setBounds(385, 315, 175, 22);
        basicData.add(LQPEndTime);
        YYZEndTime = setJSpinner(YYZEndTime, nextyearToday, false);
        YYZEndTime.setBounds(385, 340, 175, 22);
        basicData.add(YYZEndTime);
        GLFEndTime = setJSpinner(GLFEndTime, nextyearToday, false);
        GLFEndTime.setBounds(385, 365, 175, 22);
        basicData.add(GLFEndTime);
        nextErBao = new JTextField();
        nextErBao.setBounds(385, 390, 175, 20);
        nextErBao.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!(regex.isAllNum(nextErBao.getText()))) {
                    //JOptionPane.showMessageDialog(EditCarInfPage.this, "�´ζ�����ʽ����ȷ��");
                    showWarning("�´ζ���", "��ʽ����ȷ��");
                }
            }
        });
        //nextErBao
        basicData.add(nextErBao);
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

    private JLabel setjLabel(String name, int i) {
        jLabel = new JLabel(name);
        jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel.setBounds(10 + 265 * (i / 16), 15 + 25 * (i % 16), 104, 20);
        return jLabel;
    }

    private int saveASExcel() {
        // ��һ��������һ��webbook����Ӧһ��Excel�ļ�
        XSSFWorkbook wb = new XSSFWorkbook();
        // �ڶ�������webbook�����һ��sheet,��ӦExcel�ļ��е�sheet
        XSSFSheet sheet = wb.createSheet("������Ϣ��");
        // ����������sheet����ӱ�ͷ��0��,ע���ϰ汾poi��Excel����������������short
        XSSFRow row = sheet.createRow((int) 0);
        // ���Ĳ���������Ԫ�񣬲�����ֵ��ͷ
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("���ƺ�");
        cell = row.createCell(1);
        cell.setCellValue("����ʱ��");
        cell = row.createCell(2);
        cell.setCellValue("����");
        cell = row.createCell(3);
        cell.setCellValue("��ɫ");
        cell = row.createCell(4);
        cell.setCellValue("�������");
        cell = row.createCell(5);
        cell.setCellValue("��������");
        cell = row.createCell(6);
        cell.setCellValue("���̱��");
        cell = row.createCell(7);
        cell.setCellValue("��λ��");
        cell = row.createCell(8);
        cell.setCellValue("����۸�");
        cell = row.createCell(9);
        cell.setCellValue("����˰");
        cell = row.createCell(10);
        cell.setCellValue("���Ʒ�");
        cell = row.createCell(11);
        cell.setCellValue("����װ��");
        cell = row.createCell(12);
        cell.setCellValue("��������");
        cell = row.createCell(13);
        cell.setCellValue("��ϵ�绰");
        cell = row.createCell(14);
        cell.setCellValue("��ʼ������");
        cell = row.createCell(15);
        cell.setCellValue("��ǰ������");
        cell = row.createCell(16);
        cell.setCellValue("��·�ѹ���ʱ��");
        cell = row.createCell(17);
        cell.setCellValue("��·�ѽ�ֹʱ��");
        cell = row.createCell(18);
        cell.setCellValue("����ʱ��");
        cell = row.createCell(19);
        cell.setCellValue("�����ֹʱ��");
        cell = row.createCell(20);
        cell.setCellValue("���չ���ʱ��");
        cell = row.createCell(21);
        cell.setCellValue("���ս�ֹʱ��");
        cell = row.createCell(22);
        cell.setCellValue("����˰����ʱ��");
        cell = row.createCell(23);
        cell.setCellValue("����˰��ֹʱ��");
        cell = row.createCell(24);
        cell.setCellValue("·��Ʊ����ʱ��");
        cell = row.createCell(25);
        cell.setCellValue("·��Ʊ��ֹʱ��");
        cell = row.createCell(26);
        cell.setCellValue("Ӫ��֤����ʱ��");
        cell = row.createCell(27);
        cell.setCellValue("Ӫ��֤��ֹʱ��");
        cell = row.createCell(28);
        cell.setCellValue("��Ӫ�ѹ���ʱ��");
        cell = row.createCell(29);
        cell.setCellValue("��Ӫ�ѽ�ֹʱ��");
        cell = row.createCell(30);
        cell.setCellValue("�������");
        cell = row.createCell(31);
        cell.setCellValue("�´ζ���");
        // ���岽��д��ʵ������ ʵ��Ӧ������Щ���ݴ����ݿ�õ���
        //java.awt��java.util�¶���listҪ������ȷ
        java.util.List<CarInformation> list = commonDAO.getAllInfFormTb_car("tb_car");
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow((int) i + 1);
            CarInformation carInf = list.get(i);
            // ���Ĳ���������Ԫ�񣬲�����ֵ
            row.createCell(0).setCellValue(carInf.getCar_Id());
            row.createCell(1).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getBuy_Time()));
            row.createCell(2).setCellValue(carInf.getCar_Type());
            row.createCell(3).setCellValue(carInf.getCar_Color());
            row.createCell(4).setCellValue(carInf.getChuchang_Id());
            row.createCell(5).setCellValue(carInf.getMotor_Id());
            row.createCell(6).setCellValue(carInf.getDipan_Id());
            row.createCell(7).setCellValue(carInf.getChair_Num());
            row.createCell(8).setCellValue(String.valueOf(carInf.getBuy_Price()));
            row.createCell(9).setCellValue(String.valueOf(carInf.getBuy_tax()));
            row.createCell(10).setCellValue(String.valueOf(carInf.getShangpai_fee()));
            row.createCell(11).setCellValue(String.valueOf(carInf.getZhuangshi()));
            row.createCell(12).setCellValue(carInf.getChezhu_Name());
            row.createCell(13).setCellValue(carInf.getTel());
            row.createCell(14).setCellValue(String.valueOf(carInf.getStart_Gongli()));
            row.createCell(15).setCellValue(String.valueOf(carInf.getCurrent_Gongli()));
            row.createCell(16).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getYLF_Starttime()));
            row.createCell(17).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getYLF_Endtime()));
            row.createCell(18).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getNS_Starttime()));
            row.createCell(19).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getNS_Endtime()));
            row.createCell(20).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getBX_Starttime()));
            row.createCell(21).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getBX_Endtime()));
            row.createCell(22).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getCCS_Starttime()));
            row.createCell(23).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getCCS_Endtime()));
            row.createCell(24).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getLQP_Starttime()));
            row.createCell(25).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getLQP_Endtime()));
            row.createCell(26).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getYYZ_Starttime()));
            row.createCell(27).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getYYZ_Endtime()));
            row.createCell(28).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getYGF_Starttime()));
            row.createCell(29).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(carInf.getYGF_Endtime()));
            row.createCell(30).setCellValue(String.valueOf(carInf.getErbaolicheng()));
            row.createCell(31).setCellValue(String.valueOf(carInf.getNextErbao()));
        }
        return saveFile(wb);
    }

    private int saveFile(XSSFWorkbook wb) {
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Excel ������(*.xlsx)", "xlsx");
        jfc.setFileFilter(filter);
        int option = jfc.showSaveDialog(EditCarInfPage.this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            String fname = jfc.getName(file);   //���ļ���������л�ȡ�ļ���
            //�����û���д���ļ������������ƶ��ĺ�׺������ô���Ǹ������Ϻ�׺
            if (fname.indexOf(".xlsx") == -1) {
                file = new File(jfc.getCurrentDirectory(), fname + ".xlsx");
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

    private void iniFrame() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("img/logo.png"));
        this.setTitle("���������༭");
        this.setSize(680, 490);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        skin = true;
        changeSkin();
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int exitChoose = JOptionPane.showConfirmDialog(EditCarInfPage.this, "ȷ��Ҫ�˳���?", "�˳���ʾ", JOptionPane.OK_CANCEL_OPTION);
                if (exitChoose == JOptionPane.OK_OPTION) {
                    dispose();
                } else {
                    return;
                }
            }
        });
    }


    private void judgeID() {
        if (idIdentify == 0) {
            warningInf.setText("�ͻ��޷��༭");
            jCheckBox.setEnabled(false);
            jTextFieldCarNo.setEnabled(false);
            jTextFieldOutFactoryNo.setEnabled(false);
            jTextFieldDIPANNo.setEnabled(false);
            jTextFieldPrice.setEnabled(false);
            jTextFieldGetCarNoFee.setEnabled(false);
            jTextFieldCarOwnerName.setEnabled(false);
            jTextFieldStartMils.setEnabled(false);
            erBaoMils.setEnabled(false);
            enginerNo.setEnabled(false);
            purchaseTax.setEnabled(false);
            decorationFee.setEnabled(false);
            telNo.setEnabled(false);
            nowMils.setEnabled(false);
            nextErBao.setEnabled(false);
            carClass.setEnabled(false);
            color.setEnabled(false);
            seatNum.setEnabled(false);
            buyyingTime.setEnabled(false);
            YLFTime.setEnabled(false);
            YLFEndTime.setEnabled(false);
            NSTime.setEnabled(false);
            NSEndTime.setEnabled(false);
            BXTime.setEnabled(false);
            BXEndTime.setEnabled(false);
            CCSTime.setEnabled(false);
            CCSEndTime.setEnabled(false);
            LQPTime.setEnabled(false);
            LQPEndTime.setEnabled(false);
            YYZTime.setEnabled(false);
            YYZEndTime.setEnabled(false);
            GLFTime.setEnabled(false);
            GLFEndTime.setEnabled(false);
            jButtonPrint.setEnabled(false);
            jButtonAdd.setEnabled(false);
            jButtonSave.setEnabled(false);
            jButtonCancel.setEnabled(false);
            jButtonBack.setEnabled(false);
            jButtonChangeSkin.setEnabled(false);
            jButtonUpdate.setEnabled(false);
            jTabbedPane.setEnabled(false);
        }
    }

    private boolean isInfRight() {
        if (!(regex.isCar(jTextFieldCarNo.getText()))) {
            //JOptionPane.showMessageDialog(EditCarInfPage.this, "���Ƹ�ʽ����ȷ��");
            showWarning("���ƺ�", "��ʽ����ȷ��");
            return false;
        }
        if (!(regex.isAllNum(jTextFieldPrice.getText()))) {
            //JOptionPane.showMessageDialog(EditCarInfPage.this, "�۸��ʽ����ȷ��");
            showWarning("�۸�", "��ʽ����ȷ��");
            return false;
        }
        if (!(regex.isAllNum(purchaseTax.getText()))) {
            //JOptionPane.showMessageDialog(EditCarInfPage.this, "����˰��ʽ����ȷ��");
            showWarning("����˰", "��ʽ����ȷ��");
            return false;
        }
        if (!(regex.isAllNum(jTextFieldGetCarNoFee.getText()))) {
            //JOptionPane.showMessageDialog(EditCarInfPage.this, "���ƷѸ�ʽ����ȷ��");
            showWarning("���Ʒ�", "��ʽ����ȷ��");
            return false;
        }
        if (!(regex.isAllNum(decorationFee.getText()))) {
            //JOptionPane.showMessageDialog(EditCarInfPage.this, "װ�ηѸ�ʽ����ȷ��");
            showWarning("����װ�η�", "��ʽ����ȷ��");
            return false;
        }
        if (!(regex.isTel(telNo.getText()))) {
            //JOptionPane.showMessageDialog(EditCarInfPage.this, "�ֻ��Ÿ�ʽ����ȷ��");
            showWarning("��ϵ�绰", "��ʽ����ȷ��");
            return false;
        }
        if (!(regex.isAllNum(jTextFieldStartMils.getText()))) {
            //JOptionPane.showMessageDialog(EditCarInfPage.this, "��ʼ��̸�ʽ����ȷ��");
            showWarning("��ʼ���", "��ʽ����ȷ��");
            return false;
        }
        if (!(regex.isAllNum(nowMils.getText()))) {
            //JOptionPane.showMessageDialog(EditCarInfPage.this, "��ǰ��������ʽ����ȷ��");
            showWarning("��ǰ������", "��ʽ����ȷ��");
            return false;
        }
        if (((Date) YLFTime.getValue()).getTime() > today.getTime()) {
            showWarning("��·�ѹ���ʱ��", "�����˽��죡");
            return false;
        }
        if (((Date) NSTime.getValue()).getTime() > today.getTime()) {
            showWarning("����ʱ��", "�����˽��죡");
            return false;
        }
        if (((Date) BXTime.getValue()).getTime() > today.getTime()) {
            showWarning("���չ���ʱ��", "�����˽��죡");
            return false;
        }
        if (((Date) CCSTime.getValue()).getTime() > today.getTime()) {
            showWarning("����˰����ʱ��", "�����˽��죡");
            return false;
        }if (((Date) LQPTime.getValue()).getTime() > today.getTime()) {
            showWarning("·��Ʊ����ʱ��", "�����˽��죡");
            return false;
        }if (((Date) YYZTime.getValue()).getTime() > today.getTime()) {
            showWarning("��Ӫ֤����ʱ��", "�����˽��죡");
            return false;
        }if (((Date) GLFTime.getValue()).getTime() > today.getTime()) {
            showWarning("��Ӫ֤����ʱ��", "�����˽��죡");
            return false;
        }
        if (((Date) YLFTime.getValue()).getTime() > ((Date) YLFEndTime.getValue()).getTime()) {
            showWarning("��·�ѽ�ֹʱ��", "��������ʱ�䣡");
            return false;
        }
        if (((Date) NSTime.getValue()).getTime() > ((Date) NSEndTime.getValue()).getTime()) {
            showWarning("�����ֹʱ��", "������ʼʱ�䣡");
            return false;
        }
        if (((Date) BXTime.getValue()).getTime() > ((Date) BXEndTime.getValue()).getTime()) {
            showWarning("���ս�ֹʱ��", "��������ʱ�䣡");
            return false;
        }
        if (((Date) CCSTime.getValue()).getTime() > ((Date) CCSEndTime.getValue()).getTime()) {
            showWarning("����˰��ֹʱ��", "��������ʱ�䣡");
            return false;
        }if (((Date) LQPTime.getValue()).getTime() >((Date) LQPEndTime.getValue()).getTime()) {
            showWarning("·��Ʊ��ֹʱ��", "��������ʱ�䣡");
            return false;
        }if (((Date) YYZTime.getValue()).getTime() > ((Date) YLFEndTime.getValue()).getTime()) {
            showWarning("��Ӫ֤��ֹʱ��", "��������ʱ�䣡");
            return false;
        }if (((Date) GLFTime.getValue()).getTime() > ((Date) YLFEndTime.getValue()).getTime()) {
            showWarning("��Ӫ֤��ֹʱ��", "��������ʱ�䣡");
            return false;
        }
        if (!(regex.isAllNum(erBaoMils.getText()))) {
            showWarning("�������", "��ʽ����ȷ��");
            return false;
        }
        if (!(regex.isAllNum(nextErBao.getText()))) {
            //JOptionPane.showMessageDialog(EditCarInfPage.this, "�´ζ�����ʽ����ȷ��");
            showWarning("�´ζ���", "��ʽ����ȷ��");
            return false;
        }
        return true;
    }

    private void showWarning(String Inf, String Body) {
        warningInf.setText(Inf);
        warningBody.setText(Body);
    }
}

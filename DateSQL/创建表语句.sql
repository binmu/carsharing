CREATE TABLE `tb_bondsman` (
  `bondsmanName` varchar(10) DEFAULT '' COMMENT '����������',
  `bondsmanSex` varchar(2) DEFAULT '' COMMENT '�������Ա�',
  `bondsmanAge` int(4) DEFAULT NULL COMMENT '����',
  `bondsmanId` varchar(18) NOT NULL COMMENT '���֤��',
  `bondsmanPhone` varchar(11) DEFAULT '' COMMENT '�ƶ��绰',
  `cId` varchar(8) NOT NULL,
  PRIMARY KEY (`bondsmanId`),
  KEY `Customer_Id` (`cId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `tb_car` (
  `Car_Id` varchar(10) NOT NULL COMMENT '���ƺ�',
  `Buy_Time` timestamp NULL DEFAULT NULL COMMENT '����ʱ��',
  `Car_Type` varchar(50) DEFAULT NULL COMMENT '����',
  `Car_Color` varchar(20) DEFAULT NULL COMMENT '��ɫ',
  `Chuchang_Id` varchar(10) DEFAULT NULL COMMENT '�������',
  `Motor_Id` varchar(10) DEFAULT NULL COMMENT '��������',
  `Dipan_Id` varchar(10) DEFAULT NULL COMMENT '���̱��',
  `Chair_Num` varchar(5) DEFAULT NULL COMMENT '��λ��',
  `Buy_Price` decimal(8,2) DEFAULT NULL COMMENT '����۸�',
  `Buy_tax` decimal(8,2) DEFAULT NULL COMMENT '����˰',
  `Shangpai_fee` decimal(8,2) DEFAULT NULL COMMENT '���Ʒ�',
  `Zhuangshi` decimal(8,0) DEFAULT NULL COMMENT '����װ��',
  `Chezhu_Name` varchar(10) DEFAULT NULL COMMENT '��������',
  `Tel` varchar(11) DEFAULT NULL COMMENT '��ϵ�绰',
  `Start_Gongli` decimal(8,1) DEFAULT NULL COMMENT '��ʼ������',
  `Current_Gongli` decimal(8,1) DEFAULT NULL COMMENT '��ǰ������',
  `YLF_Starttime` timestamp NULL DEFAULT NULL COMMENT '��·�ѹ���ʱ��',
  `YLF_Endtime` timestamp NULL DEFAULT NULL COMMENT '��·�ѽ�ֹʱ��',
  `NS_Starttime` timestamp NULL DEFAULT NULL COMMENT '����ʱ��',
  `NS_Endtime` timestamp NULL DEFAULT NULL COMMENT '�����ֹʱ��',
  `BX_Starttime` timestamp NULL DEFAULT NULL COMMENT '���չ���ʱ��',
  `BX_Endtime` timestamp NULL DEFAULT NULL COMMENT '���ս�ֹʱ��',
  `CCS_Starttime` timestamp NULL DEFAULT NULL COMMENT '����˰����ʱ��',
  `CCS_Endtime` timestamp NULL DEFAULT NULL COMMENT '����˰��ֹʱ��',
  `LQP_Starttime` timestamp NULL DEFAULT NULL COMMENT '·��Ʊ����ʱ��',
  `LQP_Endtime` timestamp NULL DEFAULT NULL COMMENT '·��Ʊ��ֹʱ��',
  `YYZ_Starttime` timestamp NULL DEFAULT NULL COMMENT 'Ӫ��֤����ʱ��',
  `YYZ_Endtime` timestamp NULL DEFAULT NULL COMMENT 'Ӫ��֤��ֹʱ��',
  `YGF_Starttime` timestamp NULL DEFAULT NULL COMMENT '��Ӫ֤����ʱ��',
  `YGF_Endtime` timestamp NULL DEFAULT NULL COMMENT '��Ӫ֤��ֹʱ��',
  `Erbaolicheng` decimal(8,0) DEFAULT NULL COMMENT '�������',
  `NextErbao` decimal(8,0) DEFAULT NULL COMMENT '�´ζ���',
  `isBlockUp` int(1) DEFAULT NULL COMMENT '�Ƿ�ͣ��',
  PRIMARY KEY (`Car_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `tb_car_zl` (
  `Customer_Name` varchar(10) DEFAULT NULL COMMENT '����',
  `Car_Id` varchar(10) DEFAULT NULL COMMENT '���ƺ�',
  `Pre_Zujin` int(4) DEFAULT NULL COMMENT 'Ԥ�����',
  `OutTime_Fee1` int(4) DEFAULT NULL COMMENT '��ʱ�շ�',
  `Yanjin` int(4) DEFAULT NULL COMMENT 'Ѻ��',
  `Xianshi_Licheng` int(4) DEFAULT NULL COMMENT '��ʻ���',
  `Zulin_Price` int(4) DEFAULT NULL COMMENT '���޵���',
  `Chaoshi_Fee1` int(4) DEFAULT NULL COMMENT '��ʻ�շ�',
  `Fache_Date` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp() COMMENT '��������',
  `Driver` varchar(10) DEFAULT NULL COMMENT '��ʻԱ',
  `Start_Licheng` int(4) DEFAULT NULL COMMENT '�������',
  `Inner_Id` varchar(8) NOT NULL COMMENT '�ڲ����',
  `Shouche_Date` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp() COMMENT '�ճ�����',
  `Shouche_Time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp() COMMENT '�ճ�ʱ��',
  `Zulin_Qixian` int(4) DEFAULT NULL COMMENT '��������',
  `Yingshou_Zujin` int(4) DEFAULT NULL COMMENT 'Ӧ�����',
  `End_Licheng` int(4) DEFAULT NULL COMMENT '�ճ����',
  `Chaoshi_Licheng` int(4) DEFAULT NULL COMMENT '��ʻ���',
  `Chaoshi_Fee` int(4) DEFAULT NULL COMMENT '��ʻ�շ�',
  `Baogangjia` int(4) DEFAULT NULL COMMENT '���ɼ�',
  `Chaoshi_Hour` int(4) DEFAULT NULL COMMENT '��ʱСʱ',
  `OutTime_Fee` int(4) DEFAULT NULL COMMENT '��ʱ�շ�',
  `Xiaoji_Fee` int(4) DEFAULT NULL COMMENT '�շ�С��',
  `Gas_Fee` int(4) DEFAULT NULL COMMENT '���ͷ�',
  `Daijia_Fee` int(4) DEFAULT NULL COMMENT '���ݷ�',
  `Chaobaoyang_Fee` int(4) DEFAULT NULL COMMENT '��������',
  `Weiyuejin` int(4) DEFAULT NULL COMMENT 'ΥԼ��',
  `Repair_Fee` int(4) DEFAULT NULL COMMENT '�����',
  `Baoxian_Fee` int(4) DEFAULT NULL COMMENT '���շ�',
  `Chesun_Fee` int(4) DEFAULT NULL COMMENT '�����',
  `Clean_Fee` int(4) DEFAULT NULL COMMENT '����',
  `Yunche_Fee` int(4) DEFAULT NULL COMMENT '�˳���',
  `Chaizhuang_Fee` int(4) DEFAULT NULL COMMENT '��װ�⳥��',
  `Yidihuanche_Fee` int(4) DEFAULT NULL COMMENT '��ػ���',
  `Other_Fee` int(4) DEFAULT NULL COMMENT '�����շ�',
  `Peilian_Fee` int(4) DEFAULT NULL COMMENT '������',
  `Fujia_Fee` int(4) DEFAULT NULL COMMENT '���ӷ�С��',
  `Yingshou_Jine` decimal(8,0) DEFAULT NULL COMMENT 'Ӧ�ս��',
  `Shishou_Jine` decimal(8,0) DEFAULT NULL COMMENT 'ʵ�ս��',
  `Yingshou_Zhangkuan` decimal(8,0) DEFAULT NULL COMMENT 'Ӧ���˿�',
  `Yingtui_Zhangkuan` decimal(8,0) DEFAULT NULL COMMENT 'Ӧ���˿�',
  `Jiesuanren` varchar(8) DEFAULT NULL COMMENT '������',
  `jiaokuanren` varchar(8) DEFAULT NULL COMMENT '�ɿ���',
  `Shoukuan_Date` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp() COMMENT '�տ�����',
  `Zhipiao_Id` varchar(8) DEFAULT NULL COMMENT '֧Ʊ��',
  `Demo` varchar(100) DEFAULT NULL COMMENT '��ע',
  PRIMARY KEY (`Inner_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `tb_company` (
  `companyName` varchar(20) DEFAULT '' COMMENT '��ҵ����',
  `companyType` varchar(10) DEFAULT '' COMMENT '��ҵ����',
  `companyAddr` varchar(30) DEFAULT '' COMMENT '��ҵ��ַ',
  `cId` varchar(8) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `tb_cust_yd` (
  `Inner_Id` varchar(10) NOT NULL,
  `Customer_Id` varchar(8) DEFAULT '' COMMENT '�ͻ���',
  `Customer_Name` varchar(10) DEFAULT '' COMMENT '����',
  `Car_Id` varchar(10) DEFAULT '' COMMENT '���ƺ�',
  `Zhixing` varchar(2) NOT NULL DEFAULT '' COMMENT 'ִ�����',
  `Zulin_Price` decimal(4,0) unsigned DEFAULT NULL COMMENT '���޵���',
  `Yanjin` decimal(4,0) DEFAULT NULL COMMENT 'Ѻ��',
  `Pre_Zujin` decimal(4,0) DEFAULT NULL COMMENT 'Ԥ�����',
  `Zulin_Qixian` decimal(4,0) DEFAULT NULL COMMENT '��������',
  `Chaoshi_Fee` decimal(4,0) DEFAULT NULL COMMENT '��ʻ�շ�',
  `Licheng_Meitian` decimal(4,0) DEFAULT NULL COMMENT 'ÿ����ʻ���',
  `OutTime_Fee` decimal(4,0) DEFAULT NULL COMMENT '��ʱ�շ�',
  `Jinbanren` varchar(8) DEFAULT '' COMMENT '������',
  `Yuding_Date` timestamp NULL DEFAULT NULL COMMENT 'Ԥ������',
  `Yuding_Time` timestamp NULL DEFAULT NULL COMMENT 'Ԥ��ʱ��',
  `Demo` varchar(100) DEFAULT '' COMMENT '��ע',
  PRIMARY KEY (`Inner_Id`),
  KEY `fk_car_id` (`Car_Id`),
  CONSTRAINT `fk_car_id` FOREIGN KEY (`Car_Id`) REFERENCES `tb_car` (`Car_Id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `tb_cust_zl` (
  `Inner_Id` varchar(8) NOT NULL COMMENT '�ڲ����',
  `Customer_Id` varchar(8) DEFAULT '' COMMENT '�ͻ���',
  `Customer_Name` varchar(10) DEFAULT '' COMMENT '����',
  `Car_Id` varchar(10) DEFAULT '' COMMENT '���ƺ�',
  `Pre_Zujin` int(4) DEFAULT NULL COMMENT 'Ԥ�����',
  `Zulin_Price` int(4) DEFAULT NULL COMMENT '���޵���',
  `Yanjin` int(4) DEFAULT NULL COMMENT 'Ѻ��',
  `Licheng_Meitian` int(4) DEFAULT NULL COMMENT 'ÿ����ʻ���',
  `Zulin_Qixian` int(4) DEFAULT NULL COMMENT '��������',
  `Chaoshi_Fee` int(4) DEFAULT NULL COMMENT '��ʻ�շ�',
  `Start_Licheng` int(4) DEFAULT NULL COMMENT '�������',
  `OutTime_Fee` int(4) DEFAULT NULL COMMENT '��ʱ�շ�',
  `Jinbanren` varchar(8) DEFAULT '' COMMENT '������',
  `Fache_Date` timestamp NULL DEFAULT NULL COMMENT '��������',
  `Driver` varchar(10) DEFAULT '' COMMENT '��ʻԱ',
  `Fache_Id` varchar(4) DEFAULT '' COMMENT '��������',
  `Yingshou_Zujin` int(4) DEFAULT NULL COMMENT 'Ӧ�����',
  `Demo` varchar(100) DEFAULT '' COMMENT '��ע',
  PRIMARY KEY (`Inner_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `tb_customer` (
  `cId` varchar(8) NOT NULL COMMENT '�ͻ���',
  `startTime` timestamp(6) NULL DEFAULT NULL COMMENT '��ʼ����',
  `endTime` timestamp(6) NULL DEFAULT NULL COMMENT '��ֹ����',
  `customerName` varchar(10) DEFAULT '' COMMENT '����',
  `customerSex` varchar(2) DEFAULT '' COMMENT '�Ա�',
  `customerType` varchar(8) DEFAULT '' COMMENT '�ͻ�����',
  `customerPsd` varchar(8) DEFAULT '' COMMENT '����',
  `lingZhengTime` timestamp(6) NULL DEFAULT NULL COMMENT '������֤����',
  `zhunJiaType` varchar(8) DEFAULT '' COMMENT '׼������',
  `creditId` varchar(18) DEFAULT '' COMMENT '���֤��',
  `officeTel` varchar(13) DEFAULT '' COMMENT '��ϵ�绰',
  `mobileTel` varchar(11) DEFAULT '' COMMENT '�ƶ��绰',
  `homeAddress` varchar(50) DEFAULT '' COMMENT '��ͥ��ַ',
  `gongSiName` varchar(50) DEFAULT '' COMMENT '������λ',
  `gongSiAddress` varchar(50) DEFAULT '' COMMENT '��λ��ַ',
  `yingShouFee` decimal(8,0) DEFAULT NULL COMMENT 'Ӧ�ջ��',
  `shiShouFee` decimal(8,0) DEFAULT NULL COMMENT 'ʵ�ջ��',
  `isBlockUp` int(1) DEFAULT NULL COMMENT '�Ƿ�ͣ��',
  PRIMARY KEY (`cId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `tb_driver` (
  `driverName` varchar(10) DEFAULT '' COMMENT '��ʻԱ����',
  `driverSex` varchar(2) DEFAULT '' COMMENT '��ʻԱ�Ա�',
  `driverAge` int(4) DEFAULT NULL COMMENT '����',
  `driverType` varchar(8) DEFAULT '' COMMENT '��ʻԱ����',
  `driverId` varchar(18) NOT NULL COMMENT '���֤��',
  `driverPhone` varchar(11) DEFAULT '' COMMENT '�ƶ��绰',
  `cId` varchar(8) NOT NULL DEFAULT '' COMMENT '�ͻ���',
  PRIMARY KEY (`driverId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `tb_service` (
  `Service_Id` varchar(10) NOT NULL COMMENT 'ά�޵���',
  `Car_Id` varchar(10) DEFAULT NULL COMMENT '���ƺ���',
  `Service_Location` varchar(50) DEFAULT NULL COMMENT 'ά�޵ص�',
  `Service_Status` varchar(50) DEFAULT NULL COMMENT 'ά��״̬',
  `WX_Starttime` datetime DEFAULT NULL COMMENT 'ά�޿�ʼʱ��',
  `WX_Endtime` datetime DEFAULT NULL COMMENT 'ά�޽���ʱ��',
  PRIMARY KEY (`Service_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `user_customer` (
  `user_id` varchar(10) NOT NULL COMMENT '��¼��',
  `password` varchar(255) NOT NULL COMMENT '�û�����',
  `identify` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


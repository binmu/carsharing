CREATE TABLE `tb_bondsman` (
  `bondsmanName` varchar(10) DEFAULT '' COMMENT '担保人姓名',
  `bondsmanSex` varchar(2) DEFAULT '' COMMENT '担保人性别',
  `bondsmanAge` int(4) DEFAULT NULL COMMENT '年龄',
  `bondsmanId` varchar(18) NOT NULL COMMENT '身份证号',
  `bondsmanPhone` varchar(11) DEFAULT '' COMMENT '移动电话',
  `cId` varchar(8) NOT NULL,
  PRIMARY KEY (`bondsmanId`),
  KEY `Customer_Id` (`cId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `tb_car` (
  `Car_Id` varchar(10) NOT NULL COMMENT '车牌号',
  `Buy_Time` timestamp NULL DEFAULT NULL COMMENT '购买时间',
  `Car_Type` varchar(50) DEFAULT NULL COMMENT '车型',
  `Car_Color` varchar(20) DEFAULT NULL COMMENT '颜色',
  `Chuchang_Id` varchar(10) DEFAULT NULL COMMENT '出厂编号',
  `Motor_Id` varchar(10) DEFAULT NULL COMMENT '发动机号',
  `Dipan_Id` varchar(10) DEFAULT NULL COMMENT '底盘编号',
  `Chair_Num` varchar(5) DEFAULT NULL COMMENT '座位数',
  `Buy_Price` decimal(8,2) DEFAULT NULL COMMENT '购买价格',
  `Buy_tax` decimal(8,2) DEFAULT NULL COMMENT '购置税',
  `Shangpai_fee` decimal(8,2) DEFAULT NULL COMMENT '上牌费',
  `Zhuangshi` decimal(8,0) DEFAULT NULL COMMENT '汽车装饰',
  `Chezhu_Name` varchar(10) DEFAULT NULL COMMENT '车主姓名',
  `Tel` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `Start_Gongli` decimal(8,1) DEFAULT NULL COMMENT '起始公里数',
  `Current_Gongli` decimal(8,1) DEFAULT NULL COMMENT '当前公里数',
  `YLF_Starttime` timestamp NULL DEFAULT NULL COMMENT '养路费购买时间',
  `YLF_Endtime` timestamp NULL DEFAULT NULL COMMENT '养路费截止时间',
  `NS_Starttime` timestamp NULL DEFAULT NULL COMMENT '年审时间',
  `NS_Endtime` timestamp NULL DEFAULT NULL COMMENT '年审截止时间',
  `BX_Starttime` timestamp NULL DEFAULT NULL COMMENT '保险购买时间',
  `BX_Endtime` timestamp NULL DEFAULT NULL COMMENT '保险截止时间',
  `CCS_Starttime` timestamp NULL DEFAULT NULL COMMENT '车船税购买时间',
  `CCS_Endtime` timestamp NULL DEFAULT NULL COMMENT '车船税截止时间',
  `LQP_Starttime` timestamp NULL DEFAULT NULL COMMENT '路桥票购买时间',
  `LQP_Endtime` timestamp NULL DEFAULT NULL COMMENT '路桥票截止时间',
  `YYZ_Starttime` timestamp NULL DEFAULT NULL COMMENT '营运证办理时间',
  `YYZ_Endtime` timestamp NULL DEFAULT NULL COMMENT '营运证截止时间',
  `YGF_Starttime` timestamp NULL DEFAULT NULL COMMENT '运营证购买时间',
  `YGF_Endtime` timestamp NULL DEFAULT NULL COMMENT '运营证截止时间',
  `Erbaolicheng` decimal(8,0) DEFAULT NULL COMMENT '二保里程',
  `NextErbao` decimal(8,0) DEFAULT NULL COMMENT '下次二保',
  `isBlockUp` int(1) DEFAULT NULL COMMENT '是否停用',
  PRIMARY KEY (`Car_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `tb_car_zl` (
  `Customer_Name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `Car_Id` varchar(10) DEFAULT NULL COMMENT '车牌号',
  `Pre_Zujin` int(4) DEFAULT NULL COMMENT '预收租金',
  `OutTime_Fee1` int(4) DEFAULT NULL COMMENT '超时收费',
  `Yanjin` int(4) DEFAULT NULL COMMENT '押金',
  `Xianshi_Licheng` int(4) DEFAULT NULL COMMENT '限驶里程',
  `Zulin_Price` int(4) DEFAULT NULL COMMENT '租赁单价',
  `Chaoshi_Fee1` int(4) DEFAULT NULL COMMENT '超驶收费',
  `Fache_Date` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp() COMMENT '发车日期',
  `Driver` varchar(10) DEFAULT NULL COMMENT '驾驶员',
  `Start_Licheng` int(4) DEFAULT NULL COMMENT '发车里程',
  `Inner_Id` varchar(8) NOT NULL COMMENT '内部编号',
  `Shouche_Date` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp() COMMENT '收车日期',
  `Shouche_Time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp() COMMENT '收车时间',
  `Zulin_Qixian` int(4) DEFAULT NULL COMMENT '租赁期限',
  `Yingshou_Zujin` int(4) DEFAULT NULL COMMENT '应收租金',
  `End_Licheng` int(4) DEFAULT NULL COMMENT '收车里程',
  `Chaoshi_Licheng` int(4) DEFAULT NULL COMMENT '超驶里程',
  `Chaoshi_Fee` int(4) DEFAULT NULL COMMENT '超驶收费',
  `Baogangjia` int(4) DEFAULT NULL COMMENT '包干价',
  `Chaoshi_Hour` int(4) DEFAULT NULL COMMENT '超时小时',
  `OutTime_Fee` int(4) DEFAULT NULL COMMENT '超时收费',
  `Xiaoji_Fee` int(4) DEFAULT NULL COMMENT '收费小计',
  `Gas_Fee` int(4) DEFAULT NULL COMMENT '汽油费',
  `Daijia_Fee` int(4) DEFAULT NULL COMMENT '代驾费',
  `Chaobaoyang_Fee` int(4) DEFAULT NULL COMMENT '超保养费',
  `Weiyuejin` int(4) DEFAULT NULL COMMENT '违约金',
  `Repair_Fee` int(4) DEFAULT NULL COMMENT '修理费',
  `Baoxian_Fee` int(4) DEFAULT NULL COMMENT '保险费',
  `Chesun_Fee` int(4) DEFAULT NULL COMMENT '车损费',
  `Clean_Fee` int(4) DEFAULT NULL COMMENT '清洁费',
  `Yunche_Fee` int(4) DEFAULT NULL COMMENT '运车费',
  `Chaizhuang_Fee` int(4) DEFAULT NULL COMMENT '拆装赔偿费',
  `Yidihuanche_Fee` int(4) DEFAULT NULL COMMENT '异地还车',
  `Other_Fee` int(4) DEFAULT NULL COMMENT '其他收费',
  `Peilian_Fee` int(4) DEFAULT NULL COMMENT '陪练费',
  `Fujia_Fee` int(4) DEFAULT NULL COMMENT '附加费小计',
  `Yingshou_Jine` decimal(8,0) DEFAULT NULL COMMENT '应收金额',
  `Shishou_Jine` decimal(8,0) DEFAULT NULL COMMENT '实收金额',
  `Yingshou_Zhangkuan` decimal(8,0) DEFAULT NULL COMMENT '应收账款',
  `Yingtui_Zhangkuan` decimal(8,0) DEFAULT NULL COMMENT '应退账款',
  `Jiesuanren` varchar(8) DEFAULT NULL COMMENT '结算人',
  `jiaokuanren` varchar(8) DEFAULT NULL COMMENT '缴款人',
  `Shoukuan_Date` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp() COMMENT '收款日期',
  `Zhipiao_Id` varchar(8) DEFAULT NULL COMMENT '支票号',
  `Demo` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`Inner_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `tb_company` (
  `companyName` varchar(20) DEFAULT '' COMMENT '企业名称',
  `companyType` varchar(10) DEFAULT '' COMMENT '企业类型',
  `companyAddr` varchar(30) DEFAULT '' COMMENT '企业地址',
  `cId` varchar(8) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `tb_cust_yd` (
  `Inner_Id` varchar(10) NOT NULL,
  `Customer_Id` varchar(8) DEFAULT '' COMMENT '客户号',
  `Customer_Name` varchar(10) DEFAULT '' COMMENT '姓名',
  `Car_Id` varchar(10) DEFAULT '' COMMENT '车牌号',
  `Zhixing` varchar(2) NOT NULL DEFAULT '' COMMENT '执行完毕',
  `Zulin_Price` decimal(4,0) unsigned DEFAULT NULL COMMENT '租赁单价',
  `Yanjin` decimal(4,0) DEFAULT NULL COMMENT '押金',
  `Pre_Zujin` decimal(4,0) DEFAULT NULL COMMENT '预收租金',
  `Zulin_Qixian` decimal(4,0) DEFAULT NULL COMMENT '租赁期限',
  `Chaoshi_Fee` decimal(4,0) DEFAULT NULL COMMENT '超驶收费',
  `Licheng_Meitian` decimal(4,0) DEFAULT NULL COMMENT '每天限驶里程',
  `OutTime_Fee` decimal(4,0) DEFAULT NULL COMMENT '超时收费',
  `Jinbanren` varchar(8) DEFAULT '' COMMENT '经办人',
  `Yuding_Date` timestamp NULL DEFAULT NULL COMMENT '预订日期',
  `Yuding_Time` timestamp NULL DEFAULT NULL COMMENT '预订时间',
  `Demo` varchar(100) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`Inner_Id`),
  KEY `fk_car_id` (`Car_Id`),
  CONSTRAINT `fk_car_id` FOREIGN KEY (`Car_Id`) REFERENCES `tb_car` (`Car_Id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `tb_cust_zl` (
  `Inner_Id` varchar(8) NOT NULL COMMENT '内部编号',
  `Customer_Id` varchar(8) DEFAULT '' COMMENT '客户号',
  `Customer_Name` varchar(10) DEFAULT '' COMMENT '姓名',
  `Car_Id` varchar(10) DEFAULT '' COMMENT '车牌号',
  `Pre_Zujin` int(4) DEFAULT NULL COMMENT '预收租金',
  `Zulin_Price` int(4) DEFAULT NULL COMMENT '租赁单价',
  `Yanjin` int(4) DEFAULT NULL COMMENT '押金',
  `Licheng_Meitian` int(4) DEFAULT NULL COMMENT '每天限驶里程',
  `Zulin_Qixian` int(4) DEFAULT NULL COMMENT '租赁期限',
  `Chaoshi_Fee` int(4) DEFAULT NULL COMMENT '超驶收费',
  `Start_Licheng` int(4) DEFAULT NULL COMMENT '发车里程',
  `OutTime_Fee` int(4) DEFAULT NULL COMMENT '超时收费',
  `Jinbanren` varchar(8) DEFAULT '' COMMENT '经办人',
  `Fache_Date` timestamp NULL DEFAULT NULL COMMENT '发车日期',
  `Driver` varchar(10) DEFAULT '' COMMENT '驾驶员',
  `Fache_Id` varchar(4) DEFAULT '' COMMENT '发车单号',
  `Yingshou_Zujin` int(4) DEFAULT NULL COMMENT '应收租金',
  `Demo` varchar(100) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`Inner_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `tb_customer` (
  `cId` varchar(8) NOT NULL COMMENT '客户号',
  `startTime` timestamp(6) NULL DEFAULT NULL COMMENT '起始日期',
  `endTime` timestamp(6) NULL DEFAULT NULL COMMENT '终止日期',
  `customerName` varchar(10) DEFAULT '' COMMENT '姓名',
  `customerSex` varchar(2) DEFAULT '' COMMENT '性别',
  `customerType` varchar(8) DEFAULT '' COMMENT '客户类型',
  `customerPsd` varchar(8) DEFAULT '' COMMENT '密码',
  `lingZhengTime` timestamp(6) NULL DEFAULT NULL COMMENT '初次领证日期',
  `zhunJiaType` varchar(8) DEFAULT '' COMMENT '准驾类型',
  `creditId` varchar(18) DEFAULT '' COMMENT '身份证号',
  `officeTel` varchar(13) DEFAULT '' COMMENT '联系电话',
  `mobileTel` varchar(11) DEFAULT '' COMMENT '移动电话',
  `homeAddress` varchar(50) DEFAULT '' COMMENT '家庭地址',
  `gongSiName` varchar(50) DEFAULT '' COMMENT '工作单位',
  `gongSiAddress` varchar(50) DEFAULT '' COMMENT '单位地址',
  `yingShouFee` decimal(8,0) DEFAULT NULL COMMENT '应收会费',
  `shiShouFee` decimal(8,0) DEFAULT NULL COMMENT '实收会费',
  `isBlockUp` int(1) DEFAULT NULL COMMENT '是否停用',
  PRIMARY KEY (`cId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `tb_driver` (
  `driverName` varchar(10) DEFAULT '' COMMENT '驾驶员姓名',
  `driverSex` varchar(2) DEFAULT '' COMMENT '驾驶员性别',
  `driverAge` int(4) DEFAULT NULL COMMENT '驾龄',
  `driverType` varchar(8) DEFAULT '' COMMENT '驾驶员类型',
  `driverId` varchar(18) NOT NULL COMMENT '身份证号',
  `driverPhone` varchar(11) DEFAULT '' COMMENT '移动电话',
  `cId` varchar(8) NOT NULL DEFAULT '' COMMENT '客户号',
  PRIMARY KEY (`driverId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `tb_service` (
  `Service_Id` varchar(10) NOT NULL COMMENT '维修单号',
  `Car_Id` varchar(10) DEFAULT NULL COMMENT '车牌号码',
  `Service_Location` varchar(50) DEFAULT NULL COMMENT '维修地点',
  `Service_Status` varchar(50) DEFAULT NULL COMMENT '维修状态',
  `WX_Starttime` datetime DEFAULT NULL COMMENT '维修开始时间',
  `WX_Endtime` datetime DEFAULT NULL COMMENT '维修结束时间',
  PRIMARY KEY (`Service_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `user_customer` (
  `user_id` varchar(10) NOT NULL COMMENT '登录名',
  `password` varchar(255) NOT NULL COMMENT '用户密码',
  `identify` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


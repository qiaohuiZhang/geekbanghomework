CREATE TABLE HW_MEMBER_ACCOUNTS
(
  user_id             VARCHAR(30) NOT NULL PRIMARY KEY COMMENT '会员编号',
  wallet_acct         VARCHAR(30) NOT NULL COMMENT '会员钱包账号',
  user_mobile         VARCHAR(20) COMMENT '会员手机号',
  user_email          VARCHAR(20) COMMENT '会员电子邮箱',
  gender              CHAR(1) COMMENT '会员性别：1-男，2-女',
  create_time         TIMESTAMP(6) COMMENT '注册时间',
  id_number           VARCHAR(18) COMMENT '身份证号码',
  user_name           VARCHAR(100) COMMENT '姓名',
  card_no             VARCHAR(30) COMMENT '绑定银行卡号',
  card_mobile         VARCHAR(20) COMMENT '绑定银行卡手机号',
  bank_code           VARCHAR(21) COMMENT '绑定卡行号',
  bank_name           VARCHAR(128) COMMENT '绑定卡行名',
  trade_pwd           VARCHAR(128) COMMENT '交易密码',
  create_device_type      CHAR(2) COMMENT '注册设备类型: 1-IOS,2-Android',
  freeze_flag         CHAR(1) DEFAULT 0 NOT NULL COMMENT '冻结标识 0：正常 1：冻结',
  acct_status         VARCHAR(2) DEFAULT '00' COMMENT '账户状态 00:正常 01:注销',
  recmd_mobile     VARCHAR(20) COMMENT '推荐人姓名',
  recmd_name       VARCHAR(100) COMMENT '推荐人手机号' 
) COMMENT='会员账户表';




CREATE TABLE HW_PRODUCT
(
  prod_id                VARCHAR(20) NOT NULL PRIMARY KEY COMMENT '产品编号',
  prod_name              VARCHAR(200) COMMENT '产品名称',
  prod_price             DECIMAL(15,2) COMMENT '产品价格',
  merchant_id              VARCHAR(10) COMMENT '供应商编号',
  merchant_name             VARCHAR(10) COMMENT '供应商名称',
  merchant_prod_id       VARCHAR(50) COMMENT '供应商产品代码',
  prod_cat_id            VARCHAR(9) COMMENT '分类编号',
  prod_subtitle          VARCHAR(80) COMMENT '产品副标题',
  prod_nick_name         VARCHAR(40) COMMENT '产品简称',
  prod_create_time       TIMESTAMP COMMENT '产品创建时间',
  prod_status            CHAR(2) COMMENT '产品状态 01-已上架,02-已下架,03-已废除',
  prod_stock             VARCHAR(10) COMMENT '产品库存',
  remain_stock             VARCHAR(10) COMMENT '产品剩余库存',
  prod_update_time       TIMESTAMP COMMENT '产品最后更新时间',
  on_show_time            TIMESTAMP  COMMENT '产品上架时间',
  off_shell_time           TIMESTAMP  COMMENT '产品下架时间',
  prod_show_way            CHAR(2) COMMENT '产品上架类型 0：立即上架,1：手动上架,2：设定时间上架',
  prod_brief             VARCHAR(2000) COMMENT '产品简介'

) COMMENT='产品表';



CREATE TABLE HW_ORDER 
(
  order_id         VARCHAR(50) NOT NULL PRIMARY KEY COMMENT '订单编号',
  user_id           VARCHAR(50) COMMENT '会员编号',
  order_time       TIMESTAMP COMMENT '下单时间',
  order_price      DECIMAL(15,2) COMMENT '订单总金额',
  order_pay_amount DECIMAL(15,2) COMMENT '订单应付金额',
  order_status     CHAR(2) COMMENT '订单状态 00：待支付 01：已支付 02:已撤消 98:订单关闭 99：交易超时',
  order_prod_id    VARCHAR(30) COMMENT '订单关联产品号',
  pay_card_no          VARCHAR(30) COMMENT '支付卡号',
  bank_name        VARCHAR(128) COMMENT '银行名称',
  order_pay_time   TIMESTAMP COMMENT '订单支付完成时间',
  req_ip           VARCHAR(50) COMMENT '请求IP',
  device_id        VARCHAR(64) COMMENT '设备编号',
  err_msg          VARCHAR(300) COMMENT '错误信息',
  device_type     CHAR(2) COMMENT '设备类型: 1-IOS,2-Android',
  req_mac          VARCHAR(100) COMMENT '请求设备MAC地址',
  pay_channel         VARCHAR(2) COMMENT '支付类型 1-钱包,2-微信,3-支付平台,4-银联,0-其他',
  pay_flow_id      VARCHAR(50) COMMENT '支付流水号',
  recmd_mobile     VARCHAR(20) COMMENT '推荐人姓名',
  recmd_name       VARCHAR(100) COMMENT '推荐人手机号' 
) COMMENT='订单表';
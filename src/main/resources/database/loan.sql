drop database if exists loan;

create database loan charset utf8;

use loan;

-- 借款订单表
-- 筹标完成后，生成借款订单

drop table if exists loan_order;

create table loan_order(
	id integer unsigned auto_increment primary key,
	user_id integer unsigned,

	-- use bigint to store card info
	credit_card bigint unsigned not null default 0,
	deposit_card bigint unsigned not null default 0,

	amount bigint,

	-- 状态标识
	-- 1 正常还款
	-- 2 正常还清
	-- 3 已提前还清
	-- 4 因严重逾期已停罚息
	-- 5 进入协商还款状态
	-- 6 已外包	
	status tinyint unsigned not null default 1,

	overdue smallint unsigned not null default 0,

	created_at timestamp default current_timestamp not null,
	due_at timestamp default current_timestamp not null
);


-- 还款计划表
-- 每一个借款订单都会对应一组还款计划

drop table if exists repayment_schedule;

create table repayment_schedule(
	id integer unsigned auto_increment primary key,
	loan_order_id integer unsigned not null,

	period tinyint unsigned not null, -- 还款计划所属期数
	start_at timestamp default current_timestamp not null,	-- 还款计划起始日期
	due_at	timestamp default 0 not null, 	-- 还款计划结束日期
	repay_at timestamp default 0 not null,	-- 扣款日期，默认应为结束日期前一工作日

	capital bigint unsigned not null,  -- 应还本金
	interest bigint unsigned not null default 0, -- 应还利息
	gratuity bigint unsigned not null default 0, -- 应还服务费
	penalty bigint unsigned not null default 0, -- 应还罚息

	repaid_capital bigint unsigned not null default 0,
	repaid_interest bigint unsigned not null default 0,
	repaid_gratuity bigint unsigned not null default 0,
	repaid_penalty bigint unsigned not null default 0,

	exemption bigint unsigned not null default 0, -- 协商后豁免的金额

	-- 是否还清，非零表示已还清
	is_clear tinyint unsigned not null default 0,
	overdue smallint unsigned not null default 0,

	-- 这个状态由多种情况组成，既要反应订单被处理后的实际状态，也要兼顾代扣程序识别。
	-- 参与一下 loan_order 表中的 status 字段，同时需要澄清这两个字段之间的关联。
	status tinyint unsigned not null default 1,

	-- 操作状态：用于代扣程序识别
	-- 催款人员可能会根据实际情况改变这个状态
	-- 0 无操作
	-- 1 暂停计算罚息
	-- 2 协商豁免部分本金罚息
	operation tinyint unsigned not null default 0
);


-- 与第三方支付平台产生的代扣订单表

drop table if exists withhold_order;

create table withhold_order (
	id integer unsigned auto_increment primary key,
	loan_order_id integer unsigned not null, -- 关联到具体的借款协议上

	-- 目前还清楚订单ID的组成
	order_id varchar(100) not null,

	-- 用户的还款账号
	deposit_card bigint unsigned not null,

	-- 临时收款账号
	temp_card bigint unsigned not null,

	created_at timestamp default current_timestamp not null
);


-- 代扣记录表

drop table if exists withhold_log;

create table withhold_log (
	id integer unsigned auto_increment primary key,
	loan_order_id integer unsigned not null,
	repayment_schedule_id integer unsigned not null,

	-- 这个ID是应该放在哪里呢？
	withhold_order_id integer unsigned not null,

	amount bigint unsigned not null,
	result varchar(70),	
	description varchar(70),

	created_at timestamp default current_timestamp
);

-- 还款记录表

drop table if exists repayment_log;

create table repayment_log (
	id integer unsigned auto_increment primary key,
	repayment_schedule_id integer unsigned not null,
	withhold_log_id integer unsigned not null,

	repaid_amount bigint unsigned not null default 0,

	-- 这个类型有问题，一次还款可以是多种类型啊？？
	-- 1 本金
	-- 2 利息
	-- 3 罚金
	withhold_type tinyint unsigned not null default 0,

	-- 1 正常还款
	-- 2 提前还款
	-- 3 其它的延期等怎么算呢？
	repaid_type tinyint unsigned not null default 1,

	create_at timestamp default current_timestamp not null

);

-- 罚息变更记录表

drop table if exists interest_penalty_log;

create table interest_penalty_log (
	id integer unsigned auto_increment primary key,
	user_id integer unsigned not null,
	loan_order_id integer unsigned not null,
	repayment_schedule_id integer unsigned not null,

	penalty_amount bigint unsigned not null default 0,

	-- 罚息变更类型
	-- 1 系统自动生成
	-- 2 手工生成
	penalty_type tinyint unsigned not null default 1,
	create_at timestamp default current_timestamp not null
);
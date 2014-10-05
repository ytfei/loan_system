drop database if exists loan;

create database loan charset utf8;

use loan;


-- 借款标的
-- 标的 是通过了信审之后，需要由第三方P2P平台完成的合同对象。当标的满标之后，
-- 会有新的借款订单生成

drop table if exists loan_object;

create table loan_object (
	id integer unsigned auto_increment primary key,
	user_id integer unsigned not null,

	-- 借款总金额
	amount double(30, 7) unsigned not null,

	-- 借款总期数
	total_period tinyint unsigned not null,

	-- 总利息（总利息指的是什么，和其它的利息有什么关联？）
	interest double(30, 7) unsigned not null,

	-- 出借人适用利率
	interest_lender double(30, 7) unsigned not null,

	-- 51 平台适用利率
	interest_enniu double(30, 7) unsigned not null,

	-- p2p 平台适用利率
	interest_p2p double(30, 7) unsigned not null,

	-- 借款人卡号
	-- 在目前的版本中，暂时只支付信用卡，但后续可能会增加储蓄卡（当支持现金借款时）
	-- 这个字段中，数据是以逗号分隔的。在其它表中，卡号都是以长整型保存，
	-- 但是这里由于要支持多张卡，且我不想使用子表来保存，所以就用字符窜保存了。
	debit_cards varchar(255) not null,

	-- 卡的类型
	-- 1 信用卡；2 借记卡
	card_type tinyint unsigned not null,

	-- 批贷证据（这里是放什么内容的？是否要用 text 类型？
	content varchar(800) not null,

	-- 标的 状态
	-- 1 51端初生成
	-- 2 理财平台已收标
	-- 3 理财平台已发标
	-- 4 理财平台已满标
	-- 5 理财平台已转款项 （应该在这个状态时生成借款订单）
	status tinyint unsigned not null default 1,

	enniu_created_at timestamp default current_timestamp not null, -- 51端 标的 生成的时间
	p2p_received_at timestamp default 0 not null, -- 理财平台接收标的的时间
	p2p_published_at timestamp default 0 not null, -- 理财平台发布标的的时间
	p2p_fulfilled_at timestamp default 0 not null, -- 理财平台满标的时间
	p2p_transfered_at timestamp default 0 not null -- 理财平台款项划转成功的时间
);

-- 借款订单表
-- 筹标完成后，生成借款订单

drop table if exists loan_order;

create table loan_order(
	id integer unsigned auto_increment primary key,
	user_id integer unsigned,

	-- use bigint to store card info
	credit_card bigint unsigned not null default 0,
	deposit_card bigint unsigned not null default 0,

	amount double(30, 7),

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

	capital double(30, 7) not null,  -- 应还本金
	interest double(30, 7) not null default 0, -- 应还利息
	gratuity double(30, 7) not null default 0, -- 应还服务费
	penalty double(30, 7) not null default 0, -- 应还罚息

	repaid_capital double(30, 7) not null default 0,
	repaid_interest double(30, 7) not null default 0,
	repaid_gratuity double(30, 7) not null default 0,
	repaid_penalty double(30, 7) not null default 0,

	exemption double(30, 7) not null default 0, -- 协商后豁免的金额

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

	amount double(30, 7) not null,
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

	repaid_amount double(30, 7) not null default 0,

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

	penalty_amount double(30, 7) not null default 0,

	-- 罚息变更类型
	-- 1 系统自动生成
	-- 2 手工生成
	penalty_type tinyint unsigned not null default 1,
	create_at timestamp default current_timestamp not null
);


-- 定时任务记录表
-- 该表用于记录定时任务的执行情况，任务开始时会写入一条记录，结束时会更新记录，并保存任务的执行结果
-- 通过该表，程序可以判断定时任务是否执行过（用于升级重启的场景）。

drop table if exists task_list;

create table task_list (
	id integer unsigned auto_increment primary key,
	name varchar(100) not null unique,

	-- 任务状态
	-- 0 初始状态
	-- 100 执行成功
	-- 200 执行失败
	status tinyint unsigned not null default 0,
	message varchar(100),
	started_at timestamp not null default current_timestamp,
	ended_at timestamp not null default 0
);

-- 系统账户表

drop table if exists system_account;

create table system_account (
	id integer unsigned auto_increment primary key,
	bank varchar(100) not null, -- 开户行
	name varchar(100) not null, -- 开户主
	account bigint unsigned not null, -- 账户号
	balance double(30, 7) not null default 0, -- 余额

	-- 账户类型
	-- 0 未知
	-- 1 51 临时代扣账户
	-- 2 51 风险保证金账户
	-- 3 51 自有账户
	-- 4 第三方P2P平台账户
	account_type tinyint unsigned not null default 0,
	message varchar(100) -- 备注
);
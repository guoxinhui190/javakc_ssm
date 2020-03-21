DROP TABLE temporary_chapters;/*SkipError*/
DROP TABLE chapters;/*SkipError*/
DROP TABLE book;/*SkipError*/
DROP TABLE category;/*SkipError*/
DROP TABLE interface_management;/*SkipError*/
DROP TABLE statement;/*SkipError*/
DROP TABLE customer;/*SkipError*/
DROP TABLE booklist;/*SkipError*/
DROP TABLE batch;/*SkipError*/
DROP TABLE copyright;/*SkipError*/
/*SQL@Run*/
CREATE TABLE copyright(
    copyrightid NVARCHAR2(32) NOT NULL,
    copyright_name NVARCHAR2(32),
    company_name NVARCHAR2(32),
    remarksname NVARCHAR2(32),
    falg INT,
    Partners_class INT,
    PRIMARY KEY (copyrightid)
);

COMMENT ON TABLE copyright IS '合作方表';
COMMENT ON COLUMN copyright.copyrightid IS '合作方ID';
COMMENT ON COLUMN copyright.copyright_name IS '版权方名称';
COMMENT ON COLUMN copyright.company_name IS '公司名';
COMMENT ON COLUMN copyright.remarksname IS '备注名';
COMMENT ON COLUMN copyright.falg IS '0：未删除 1：删除';
COMMENT ON COLUMN copyright.Partners_class IS '0:输出1:引进2:双向';
/*SQL@Run*/
COMMENT ON TABLE copyright IS '合作方表';
/*SQL@Run*/

/*SQL@Run*/
CREATE TABLE batch(
    batch_id NVARCHAR2(32) NOT NULL,
    bath_name NVARCHAR2(32),
    bath_booknum INT,
    default_platform NVARCHAR2(32),
    authorization_starttime DATE,
    authorization_endtime DATE,
    proportion NVARCHAR2(32),
    flag INT,
    copyrightid NVARCHAR2(32),
    contract_number NVARCHAR2(32),
    partners_category INT,
    PRIMARY KEY (batch_id)
);

COMMENT ON TABLE batch IS '批次管理表';
COMMENT ON COLUMN batch.batch_id IS '批次id';
COMMENT ON COLUMN batch.bath_name IS '批次名称';
COMMENT ON COLUMN batch.bath_booknum IS '批次书籍数量';
COMMENT ON COLUMN batch.default_platform IS '默认运营平台';
COMMENT ON COLUMN batch.authorization_starttime IS '授权开始时间';
COMMENT ON COLUMN batch.authorization_endtime IS '授权结束时间';
COMMENT ON COLUMN batch.proportion IS '分成比例';
COMMENT ON COLUMN batch.flag IS '逻辑删除';
COMMENT ON COLUMN batch.copyrightid IS '合作方id';
COMMENT ON COLUMN batch.contract_number IS '合同编号';
COMMENT ON COLUMN batch.partners_category IS '类别';
/*SQL@Run*/
COMMENT ON TABLE batch IS '批次管理表';
/*SQL@Run*/

/*SQL@Run*/
CREATE TABLE booklist(
    booklist_id NVARCHAR2(32) NOT NULL,
    booklist_name NVARCHAR2(32),
    booknum INT,
    falg INT,
    batch_id NVARCHAR2(32),
    PRIMARY KEY (booklist_id)
);

COMMENT ON TABLE booklist IS '书单表';
COMMENT ON COLUMN booklist.booklist_id IS '书单ID';
COMMENT ON COLUMN booklist.booklist_name IS '书单名';
COMMENT ON COLUMN booklist.booknum IS '书单书籍数量';
COMMENT ON COLUMN booklist.falg IS '1删0未删';
COMMENT ON COLUMN booklist.batch_id IS '批次id';
/*SQL@Run*/
COMMENT ON TABLE booklist IS '书单表';
/*SQL@Run*/

/*SQL@Run*/
CREATE TABLE customer(
    customer_id NVARCHAR2(32) NOT NULL,
    customer_name NVARCHAR2(32),
    company_name NVARCHAR2(32),
    sex INT,
    birthday DATE,
    post NVARCHAR2(32),
    phone_number NVARCHAR2(32),
    landline_number NVARCHAR2(32),
    mailbox NVARCHAR2(32),
    qq NVARCHAR2(32),
    company_address NVARCHAR2(32),
    remarks NVARCHAR2(32),
    flag INT,
    copyrightid NVARCHAR2(32),
    PRIMARY KEY (customer_id)
);

COMMENT ON TABLE customer IS '客户表';
COMMENT ON COLUMN customer.customer_id IS '客户id';
COMMENT ON COLUMN customer.customer_name IS '姓名';
COMMENT ON COLUMN customer.company_name IS '公司名';
COMMENT ON COLUMN customer.sex IS '性别';
COMMENT ON COLUMN customer.birthday IS '出生日期';
COMMENT ON COLUMN customer.post IS '职务';
COMMENT ON COLUMN customer.phone_number IS '手机号';
COMMENT ON COLUMN customer.landline_number IS '座机号';
COMMENT ON COLUMN customer.mailbox IS '邮箱';
COMMENT ON COLUMN customer.qq IS 'qq';
COMMENT ON COLUMN customer.company_address IS '公司地址';
COMMENT ON COLUMN customer.remarks IS '备注';
COMMENT ON COLUMN customer.flag IS 'Flag';
COMMENT ON COLUMN customer.copyrightid IS '合作方id';
/*SQL@Run*/
COMMENT ON TABLE customer IS '客户表';
/*SQL@Run*/

/*SQL@Run*/
CREATE TABLE statement(
    settlement_id NVARCHAR2(32) NOT NULL,
    month DATE,
    proportion NVARCHAR2(32),
    settlement_money_front NVARCHAR2(32),
    settlement_money_after NVARCHAR2(32),
    remit_date DATE,
    settlement_state INT,
    remark NVARCHAR2(1024),
    operator NVARCHAR2(32),
    falg INT,
    batch_id NVARCHAR2(32),
    PRIMARY KEY (settlement_id)
);

COMMENT ON TABLE statement IS '结算管理表';
COMMENT ON COLUMN statement.settlement_id IS '结算管理id';
COMMENT ON COLUMN statement.month IS '月份';
COMMENT ON COLUMN statement.proportion IS '分成比例';
COMMENT ON COLUMN statement.settlement_money_front IS '结算金额（分成前）';
COMMENT ON COLUMN statement.settlement_money_after IS '结算金额（分成后）';
COMMENT ON COLUMN statement.remit_date IS '打款时间';
COMMENT ON COLUMN statement.settlement_state IS '结算状态';
COMMENT ON COLUMN statement.remark IS '备注';
COMMENT ON COLUMN statement.operator IS '操作人';
COMMENT ON COLUMN statement.falg IS '0:删除，1：存在';
COMMENT ON COLUMN statement.batch_id IS '批次id（外键）';
/*SQL@Run*/
COMMENT ON TABLE statement IS '结算管理表';
/*SQL@Run*/

/*SQL@Run*/
CREATE TABLE interface_management(
    interface_id NVARCHAR2(32) NOT NULL,
    interface_booknum INT,
    interface_onlinenum INT,
    book_listnum INT,
    batch_num INT,
    cooperation_state INT,
    Partner_ip NVARCHAR2(32),
    authorization_key NVARCHAR2(32),
    resource_id NVARCHAR2(32),
    copyright_brief NVARCHAR2(32),
    copyrightid NVARCHAR2(32),
    PRIMARY KEY (interface_id)
);

COMMENT ON TABLE interface_management IS '接口管理';
COMMENT ON COLUMN interface_management.interface_id IS '接口id';
COMMENT ON COLUMN interface_management.interface_booknum IS '接口书籍数量';
COMMENT ON COLUMN interface_management.interface_onlinenum IS '接口上线数量';
COMMENT ON COLUMN interface_management.book_listnum IS '书单数量';
COMMENT ON COLUMN interface_management.batch_num IS '批次数量';
COMMENT ON COLUMN interface_management.cooperation_state IS '合作状态';
COMMENT ON COLUMN interface_management.Partner_ip IS '合作方ip';
COMMENT ON COLUMN interface_management.authorization_key IS '授权秘钥';
COMMENT ON COLUMN interface_management.resource_id IS '资源id';
COMMENT ON COLUMN interface_management.copyright_brief IS '版权简介';
COMMENT ON COLUMN interface_management.copyrightid IS '版权id';
/*SQL@Run*/
COMMENT ON TABLE interface_management IS '接口管理';
/*SQL@Run*/

/*SQL@Run*/
CREATE TABLE category(
    category_id NVARCHAR2(32) NOT NULL,
    two_id NVARCHAR2(32),
    two_name NVARCHAR2(32),
    one_id NVARCHAR2(32),
    one_name NVARCHAR2(32),
    PRIMARY KEY (category_id)
);

COMMENT ON TABLE category IS '分类表';
COMMENT ON COLUMN category.category_id IS '分离id';
COMMENT ON COLUMN category.two_id IS '二级分类id';
COMMENT ON COLUMN category.two_name IS '二级分类名称';
COMMENT ON COLUMN category.one_id IS '一级分类';
COMMENT ON COLUMN category.one_name IS '一级分类名称';
/*SQL@Run*/
COMMENT ON TABLE category IS '分类表';
/*SQL@Run*/

/*SQL@Run*/
CREATE TABLE book(
    book_id NVARCHAR2(32) NOT NULL,
    cp_id NVARCHAR2(32),
    tarot_id NVARCHAR2(32),
    bookname NVARCHAR2(32),
    author NVARCHAR2(32),
    serialization INT,
    word_number INT,
    state INT,
    if_charge INT,
    Price NUMBER(32,8),
    if_original INT,
    Press NVARCHAR2(32),
    Publishing_time DATE,
    Right_start_time DATE,
    error_end_time DATE,
    author_Right_start_time DATE,
    author_error_end_time DATE,
    Receiving_time DATE,
    one_Successful_time DATE,
    one_delete_time DATE,
    in_successful_time DATE,
    in_delete_time DATE,
    one_Reject DATE,
    in_reject_time DATE,
    Go_online_time DATE,
    Offline_time DATE,
    to_update_time DATE,
    Authorization_status INT,
    Remarks NVARCHAR2(32),
    falg INT,
    copyrightId NVARCHAR2(32),
    booklist_id NVARCHAR2(32),
    chapters_number INT,
    category_id NVARCHAR2(32),
    Toll_section_start NVARCHAR2(32),
    PRIMARY KEY (book_id)
);

COMMENT ON TABLE book IS '书籍表';
COMMENT ON COLUMN book.book_id IS '书籍主键';
COMMENT ON COLUMN book.cp_id IS 'cp书籍id';
COMMENT ON COLUMN book.tarot_id IS '塔读书籍id';
COMMENT ON COLUMN book.bookname IS '书名';
COMMENT ON COLUMN book.author IS '作者';
COMMENT ON COLUMN book.serialization IS '连载';
COMMENT ON COLUMN book.word_number IS '字数';
COMMENT ON COLUMN book.state IS '状态';
COMMENT ON COLUMN book.if_charge IS '是否收费';
COMMENT ON COLUMN book.Price IS '全本价格';
COMMENT ON COLUMN book.if_original IS '是否原创';
COMMENT ON COLUMN book.Press IS '出版社';
COMMENT ON COLUMN book.Publishing_time IS '出版时间';
COMMENT ON COLUMN book.Right_start_time IS '授权开始时间';
COMMENT ON COLUMN book.error_end_time IS '授权结束时间';
COMMENT ON COLUMN book.author_Right_start_time IS '作者授权开始时间';
COMMENT ON COLUMN book.author_error_end_time IS '作者授权结束时间';
COMMENT ON COLUMN book.Receiving_time IS '接收时间';
COMMENT ON COLUMN book.one_Successful_time IS '初审成功时间';
COMMENT ON COLUMN book.one_delete_time IS '初审删除时间';
COMMENT ON COLUMN book.in_successful_time IS '入库审核成功时间';
COMMENT ON COLUMN book.in_delete_time IS '入库审核删除时间';
COMMENT ON COLUMN book.one_Reject IS '初审驳回时间';
COMMENT ON COLUMN book.in_reject_time IS '入库审驳回时间';
COMMENT ON COLUMN book.Go_online_time IS '上线时间';
COMMENT ON COLUMN book.Offline_time IS '下线时间';
COMMENT ON COLUMN book.to_update_time IS '连载更新提醒时间';
COMMENT ON COLUMN book.Authorization_status IS '授权状态';
COMMENT ON COLUMN book.Remarks IS '备注';
COMMENT ON COLUMN book.falg IS '逻辑删除';
COMMENT ON COLUMN book.copyrightId IS '合作方id';
COMMENT ON COLUMN book.booklist_id IS '书单id';
COMMENT ON COLUMN book.chapters_number IS '章节数';
COMMENT ON COLUMN book.category_id IS '分类id(外键)';
COMMENT ON COLUMN book.Toll_section_start IS '开始收费章节';
/*SQL@Run*/
COMMENT ON TABLE book IS '书籍表';
/*SQL@Run*/

/*SQL@Run*/
CREATE TABLE chapters(
    chapters_id NVARCHAR2(32) NOT NULL,
    chapters_name NVARCHAR2(32),
    word_number INT,
    state NVARCHAR2(32),
    book_id NVARCHAR2(32),
    one_Successful_time DATE,
    one_delete_time DATE,
    in_successful_time DATE,
    in_delete_time DATE,
    one_Reject DATE,
    in_reject_time DATE,
    chapters_number NVARCHAR2(32),
    Go_online_time DATE,
    Offline_time DATE,
    old_number INT,
    filter_words NVARCHAR2(1024),
    PRIMARY KEY (chapters_id)
);

COMMENT ON TABLE chapters IS '章节表';
COMMENT ON COLUMN chapters.chapters_id IS '章节id';
COMMENT ON COLUMN chapters.chapters_name IS '章节名称';
COMMENT ON COLUMN chapters.word_number IS '章节字数';
COMMENT ON COLUMN chapters.state IS '章节状态';
COMMENT ON COLUMN chapters.book_id IS '书籍id(外键)';
COMMENT ON COLUMN chapters.one_Successful_time IS '初审成功时间';
COMMENT ON COLUMN chapters.one_delete_time IS '初审删除时间';
COMMENT ON COLUMN chapters.in_successful_time IS '入库审核成功时间';
COMMENT ON COLUMN chapters.in_delete_time IS '入库审核删除时间';
COMMENT ON COLUMN chapters.one_Reject IS '初审驳回时间';
COMMENT ON COLUMN chapters.in_reject_time IS '入库审驳回时间';
COMMENT ON COLUMN chapters.chapters_number IS '章节序号';
COMMENT ON COLUMN chapters.Go_online_time IS '上线时间';
COMMENT ON COLUMN chapters.Offline_time IS '下线时间';
COMMENT ON COLUMN chapters.old_number IS '原字数';
COMMENT ON COLUMN chapters.filter_words IS '过滤词';
/*SQL@Run*/
COMMENT ON TABLE chapters IS '章节表';
/*SQL@Run*/

/*SQL@Run*/
CREATE TABLE temporary_chapters(
    temporary_id NVARCHAR2(32) NOT NULL,
    chapters_name NVARCHAR2(32),
    state NVARCHAR2(32),
    book_id NVARCHAR2(32),
    one_Successful_time DATE,
    one_delete_time DATE,
    in_successful_time DATE,
    in_delete_time DATE,
    one_Reject DATE,
    in_reject_time DATE,
    chapters_number NVARCHAR2(32),
    old_number INT,
    filter_words NVARCHAR2(1024),
    PRIMARY KEY (temporary_id)
);

COMMENT ON TABLE temporary_chapters IS '临时章节表';
COMMENT ON COLUMN temporary_chapters.temporary_id IS '临时章节id';
COMMENT ON COLUMN temporary_chapters.chapters_name IS '章节名称';
COMMENT ON COLUMN temporary_chapters.state IS '章节状态';
COMMENT ON COLUMN temporary_chapters.book_id IS '书籍id(外键)';
COMMENT ON COLUMN temporary_chapters.one_Successful_time IS '初审成功时间';
COMMENT ON COLUMN temporary_chapters.one_delete_time IS '初审删除时间';
COMMENT ON COLUMN temporary_chapters.in_successful_time IS '入库审核成功时间';
COMMENT ON COLUMN temporary_chapters.in_delete_time IS '入库审核删除时间';
COMMENT ON COLUMN temporary_chapters.one_Reject IS '初审驳回时间';
COMMENT ON COLUMN temporary_chapters.in_reject_time IS '入库审驳回时间';
COMMENT ON COLUMN temporary_chapters.chapters_number IS '章节序号';
COMMENT ON COLUMN temporary_chapters.old_number IS '原字数';
COMMENT ON COLUMN temporary_chapters.filter_words IS '过滤词';
/*SQL@Run*/
COMMENT ON TABLE temporary_chapters IS '临时章节表';
/*SQL@Run*/

CREATE TABLE booty_book
(
    id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '主键ID',
    name VARCHAR(150) COMMENT '书籍名字',
    author VARCHAR(150) COMMENT '书籍作者',
    book_no VARCHAR(150) COMMENT '书籍编号',
    is_damage SMALLINT(1) COMMENT '是否损坏',
    is_lend SMALLINT(1) COMMENT '是否借出',
    introduction VARCHAR(1500) COMMENT '简介'
);
CREATE TABLE booty_school
(
    id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '主键ID',
    name VARCHAR(150) COMMENT '学校名字',
    star SMALLINT(1) COMMENT '学校星级',
    address VARCHAR(150) COMMENT '学校地址',
    teacher_number INT(11) COMMENT '教师数量',
    student_number INT(11) COMMENT '学生数量',
    introduction VARCHAR(1500) COMMENT '简介'
);
CREATE TABLE perm_account
(
    id BIGINT(20) PRIMARY KEY NOT NULL COMMENT 'ID',
    account VARCHAR(32) COMMENT '帐号',
    password VARCHAR(32) COMMENT '密码',
    name VARCHAR(64) COMMENT '真实姓名',
    nick_name VARCHAR(64) COMMENT '昵称',
    last_login_time DATETIME COMMENT '最后一次登录时间',
    delete_flag SMALLINT(6) COMMENT '删除标记（0=未删除，1=已删除）',
    create_time DATETIME COMMENT '创建时间',
    create_id BIGINT(20) COMMENT '创建人',
    update_time DATETIME COMMENT '最后修改时间',
    update_id BIGINT(20) COMMENT '最后修改人'
);
CREATE TABLE perm_menu
(
    id BIGINT(20) PRIMARY KEY NOT NULL COMMENT 'ID',
    perm_type SMALLINT(6) COMMENT '类型（1=前台、中台；2=后台）',
    name VARCHAR(64) COMMENT '资源名称',
    url VARCHAR(256) COMMENT '资源地址',
    parent_id BIGINT(20) COMMENT '父资源',
    sort_no SMALLINT(6) COMMENT '排序',
    deepth SMALLINT(6) COMMENT '节点深度',
    is_leaf SMALLINT(6) COMMENT '是否叶子节点',
    status SMALLINT(6) COMMENT '状态',
    description VARCHAR(256) COMMENT '资源描述',
    code VARCHAR(32) COMMENT '资源编码',
    delete_flag SMALLINT(6) COMMENT '删除标记（0=未删除，1=已删除）',
    create_time DATETIME COMMENT '创建时间',
    create_id BIGINT(20) COMMENT '创建人',
    update_time DATETIME COMMENT '最后修改时间',
    update_id BIGINT(20) COMMENT '最后修改人',
    language_code VARCHAR(32) COMMENT '语言'
);
CREATE TABLE perm_role
(
    id BIGINT(20) PRIMARY KEY NOT NULL COMMENT 'ID',
    perm_type SMALLINT(6) COMMENT '类型（1=前台、中台；2=后台）',
    name VARCHAR(64) COMMENT '角色名称',
    code VARCHAR(32) COMMENT '角色编码',
    description VARCHAR(128) COMMENT '角色描述',
    delete_flag SMALLINT(6) COMMENT '删除标记（0=未删除，1=已删除）',
    create_time DATETIME COMMENT '创建时间',
    create_id BIGINT(20) COMMENT '创建人',
    update_time DATETIME COMMENT '最后修改时间',
    update_id BIGINT(20) COMMENT '最后修改人',
    language_code VARCHAR(32) COMMENT '语言'
);
CREATE TABLE perm_role_menu
(
    id BIGINT(20) PRIMARY KEY NOT NULL COMMENT 'ID',
    role_id BIGINT(20) COMMENT '角色id',
    menu_id BIGINT(20) COMMENT '资源id',
    perm_type SMALLINT(6) COMMENT '类型（1=前台、中台；2=后台）'
);
CREATE TABLE perm_user_role
(
    id BIGINT(20) PRIMARY KEY NOT NULL COMMENT 'ID',
    perm_type SMALLINT(6) COMMENT '类型（1=前台、中台；2=后台）',
    user_id BIGINT(20) COMMENT '用户id',
    role_id BIGINT(20) COMMENT '角色id'
);
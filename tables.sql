-- 用户表
DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id int(20) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL COMMENT '用户名',
  full_name varchar(100) DEFAULT NULL COMMENT '用户名',
  sex varchar(10) DEFAULT NULL COMMENT '性别',
  birthday varchar(100) DEFAULT NULL COMMENT '生日',
  password varchar(100) NOT NULL COMMENT '密码',
  level int(10) DEFAULT NULL COMMENT '等级',
  state int(10) DEFAULT NULL COMMENT '用户状态',
  des varchar(200) DEFAULT NULL COMMENT '简介',
  tel varchar(200) DEFAULT NULL COMMENT '电话',
  email varchar(200) DEFAULT NULL COMMENT '邮箱地址',
  creat_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  last_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (id),
  UNIQUE KEY name (name)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户表';

insert users(name,password) values('a','a');
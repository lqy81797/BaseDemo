/*  
Navicat MySQL Data Transfer  
   
Source Server         : 10.0.0.12  
Source Server Version : 50619  
Source Host           : 10.0.0.12:3305  
Source Database       : favsecurity  
   
Target Server Type    : MYSQL  
Target Server Version : 50619  
File Encoding         : 65001  
   
Date: 2015-01-23 10:28:39  
*/  
   
SET FOREIGN_KEY_CHECKS=0;  
   
-- ----------------------------  
-- Table structure for role  
-- ----------------------------  
DROP TABLE IF EXISTS `role`;  
CREATE TABLE `role` (  
  `id` int(11) NOT NULL DEFAULT '0' COMMENT 'id',  
  `name` varchar(50) DEFAULT NULL COMMENT 'name',  
  `descn` varchar(50) DEFAULT NULL COMMENT 'descn',  
  PRIMARY KEY (`id`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';  
   
-- ----------------------------  
-- Records of role  
-- ----------------------------  
INSERT INTO `role` VALUES ('1', 'ROLE_ADMIN', '管理员角色');  
INSERT INTO `role` VALUES ('2', 'ROLE_USER', '用户角色');  
   
-- ----------------------------  
-- Table structure for user  
-- ----------------------------  
DROP TABLE IF EXISTS `user`;  
CREATE TABLE `user` (  
  `id` int(11) NOT NULL DEFAULT '0' COMMENT 'id',  
  `username` varchar(50) DEFAULT NULL COMMENT 'username',  
  `password` varchar(50) DEFAULT NULL COMMENT 'password',  
  `status` varchar(1024) DEFAULT NULL COMMENT 'status',  
  `descn` varchar(1024) DEFAULT NULL COMMENT 'descd',  
  PRIMARY KEY (`id`),  
  KEY `AK_Key_1` (`id`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';  
   
-- ----------------------------  
-- Records of user  
-- ----------------------------  
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '1', '管理\r\n员');  
INSERT INTO `user` VALUES ('2', 'user', 'user', '1', '用户\r\n');  
INSERT INTO `user` VALUES ('3', 'favccxx', 'favboy', '1', '帅锅');  
   
-- ----------------------------  
-- Table structure for user_role  
-- ----------------------------  
DROP TABLE IF EXISTS `user_role`;  
CREATE TABLE `user_role` (  
  `user_id` int(11) DEFAULT NULL COMMENT '用户表_id',  
  `role_id` int(11) DEFAULT NULL COMMENT '角色表_id',  
  KEY `FK_FK_USER_ROLE_ROLE` (`role_id`),  
  KEY `FK_FK_USER_ROLE_USER` (`user_id`),  
  CONSTRAINT `FK_FK_USER_ROLE_USER` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),  
  CONSTRAINT `FK_FK_USER_ROLE_ROLE` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';  
   
-- ----------------------------  
-- Records of user_role  
-- ----------------------------  
INSERT INTO `user_role` VALUES ('1', '1');  
INSERT INTO `user_role` VALUES ('1', '2');  
INSERT INTO `user_role` VALUES ('2', '2');  
INSERT INTO `user_role` VALUES ('3', '1');  
INSERT INTO `user_role` VALUES ('3', '2');  
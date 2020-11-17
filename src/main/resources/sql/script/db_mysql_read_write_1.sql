/*
Navicat MySQL Data Transfer

Source Server         : LocalMysql
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : db_mysql_read_write_1

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2020-11-17 16:28:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'aaa', '11');
INSERT INTO `user` VALUES ('2', 'bbb', '12');
INSERT INTO `user` VALUES ('3', 'ccc', '13');

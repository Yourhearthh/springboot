/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2020-07-01 11:58:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_humiture
-- ----------------------------
DROP TABLE IF EXISTS `tb_humiture`;
CREATE TABLE `tb_humiture` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据组编号',
  `temp` varchar(255) DEFAULT NULL COMMENT '温度',
  `humidity` varchar(255) DEFAULT NULL COMMENT '湿度',
  `ip` varchar(255) DEFAULT NULL COMMENT 'ip地址',
  `time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '采集时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tb_humiture
-- ----------------------------
INSERT INTO `tb_humiture` VALUES ('1', '26', '56', '192.168.1.105', '2020-06-29 10:25:16');
INSERT INTO `tb_humiture` VALUES ('2', '24', '54', '192.168.1.105', '2020-06-29 10:25:21');
INSERT INTO `tb_humiture` VALUES ('3', '25', '55', '192.168.1.105', '2020-06-29 10:25:26');
INSERT INTO `tb_humiture` VALUES ('4', '28', '59', '192.168.1.105', '2020-06-29 10:25:31');
INSERT INTO `tb_humiture` VALUES ('5', '30', '56', '192.168.1.105', '2020-06-29 10:25:36');
INSERT INTO `tb_humiture` VALUES ('6', '28', '46', '192.168.1.105', '2020-06-29 10:25:41');
INSERT INTO `tb_humiture` VALUES ('7', '31', '58', '192.168.1.105', '2020-06-29 10:25:46');
INSERT INTO `tb_humiture` VALUES ('8', '31', '76', '127.0.0.1', '2020-06-30 16:04:19');
INSERT INTO `tb_humiture` VALUES ('18', '31', '78', '127.0.0.1', '2020-06-30 17:08:39');
INSERT INTO `tb_humiture` VALUES ('19', '26', '67', '127.0.0.1', '2020-06-30 22:09:55');

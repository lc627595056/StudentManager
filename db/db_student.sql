/*
Navicat MySQL Data Transfer

Source Server         : 39.97.230.224_3306
Source Server Version : 50730
Source Host           : 39.97.230.224:3306
Source Database       : db_student

Target Server Type    : MYSQL
Target Server Version : 50730
File Encoding         : 65001

Date: 2020-07-11 13:15:37
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `absence`
-- ----------------------------
DROP TABLE IF EXISTS `absence`;
CREATE TABLE `absence` (
  `ab_id` int(20) NOT NULL AUTO_INCREMENT,
  `st_sno` varchar(255) DEFAULT NULL,
  `st_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `st_sex` int(20) DEFAULT NULL,
  `st_class` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `house_num` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `ab_time` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `wr_person` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`ab_id`),
  KEY `sno` (`st_sno`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of absence
-- ----------------------------
INSERT INTO `absence` VALUES ('27', '174804002', 'BBB', '1', '17级Java4班11', '南苑405', '2019-01-01', 'zyh');
INSERT INTO `absence` VALUES ('28', '174804003', 'CCC', '1', '17级Java4班', '南苑401', '2019-01-01', 'zyh');
INSERT INTO `absence` VALUES ('29', '174804004', 'DDD', '1', '17级Java4班', '南苑405', '2019-01-01', '111');
INSERT INTO `absence` VALUES ('31', '174804005', 'EEE', '1', '17级Java4班', '南苑407', '2019-01-01', '111');
INSERT INTO `absence` VALUES ('32', '174804006', 'FFF', '0', '17级Java4班', '南苑408', '2019-01-01', '111');
INSERT INTO `absence` VALUES ('33', '174804007', 'GGG', '1', '17级Java4班', '南苑409', '2019-01-01', '111');
INSERT INTO `absence` VALUES ('35', '174804001', 'AAA', '0', '17级Java3班', '南苑405', '2020-06-27', 'zyh');

-- ----------------------------
-- Table structure for `announce`
-- ----------------------------
DROP TABLE IF EXISTS `announce`;
CREATE TABLE `announce` (
  `anno_id` int(11) NOT NULL AUTO_INCREMENT,
  `anno_name` varchar(255) DEFAULT NULL,
  `anno_content` text,
  `anno_data` date DEFAULT NULL,
  PRIMARY KEY (`anno_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of announce
-- ----------------------------
INSERT INTO `announce` VALUES ('2', '中秋节放假的通知', '中秋节放假的通知222', '2019-12-24');
INSERT INTO `announce` VALUES ('3', '415宿舍卫生太差的通知', '415宿舍卫生太差的通知', '2019-12-24');
INSERT INTO `announce` VALUES ('19', '414宿舍卫生太好的通知', '414宿舍卫生太好的通知', '2018-08-08');
INSERT INTO `announce` VALUES ('35', '放假时间', '1月8号放假', '2019-12-31');
INSERT INTO `announce` VALUES ('36', '过年通知', '祝大家过年好', '2019-12-30');
INSERT INTO `announce` VALUES ('38', '一起来跨年', '跨年快乐', '2019-12-31');
INSERT INTO `announce` VALUES ('39', '快放假了', '啦啦啦啦', '2019-12-31');
INSERT INTO `announce` VALUES ('43', 'dfbrfgb', 'dgbdgrtn,rtgnrtn', '2020-06-11');
INSERT INTO `announce` VALUES ('45', '速度非常V', '东方测完', '2020-06-11');
INSERT INTO `announce` VALUES ('46', '你好啊', 'sdrgvwergreh暗色凤鳚', '2020-07-05');

-- ----------------------------
-- Table structure for `repair`
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair` (
  `rid` int(20) NOT NULL AUTO_INCREMENT,
  `st_sno` varchar(20) NOT NULL,
  `st_sname` varchar(20) DEFAULT NULL,
  `r_name` varchar(255) DEFAULT NULL,
  `r_case` varchar(255) DEFAULT NULL,
  `r_time` date DEFAULT NULL,
  `house_num` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of repair
-- ----------------------------
INSERT INTO `repair` VALUES ('25', '174804001', 'AAA', '门窗门框112', '门窗门框损坏', '2019-11-27', '南苑401');
INSERT INTO `repair` VALUES ('26', '174804002', 'BBB', '窗户111', '窗户破损111', '2019-12-01', '南苑402111');
INSERT INTO `repair` VALUES ('27', '174804003', 'CCC', '门窗', '门窗损坏', '2019-12-01', '南苑406');
INSERT INTO `repair` VALUES ('28', '174804004', 'DDD', '床铺', '床破损坏', '2019-12-01', '南苑404');
INSERT INTO `repair` VALUES ('29', '174804005', 'EEE', '天花板', '天花板损坏', '2019-12-01', '南苑405');
INSERT INTO `repair` VALUES ('30', '174804006', 'FFF', '门把手', '门把手损坏', '2019-12-01', '南苑406');
INSERT INTO `repair` VALUES ('31', '174804007', 'GGG', '凳子', '凳子损坏', '2019-12-01', '南苑407');
INSERT INTO `repair` VALUES ('32', '174804008', 'HHH', '桌子', '桌子损坏', '2019-12-01', '南苑408');
INSERT INTO `repair` VALUES ('33', '174804009', 'III', '开关', '开关损坏', '2019-12-01', '南苑409');
INSERT INTO `repair` VALUES ('34', '174804010', 'JJJ', '窗户', '窗户损坏', '2019-12-01', '南苑410');
INSERT INTO `repair` VALUES ('47', '174804002', 'wefer', 'erghte', 'etfh', '2020-06-05', '南苑402');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `st_id` int(20) NOT NULL AUTO_INCREMENT,
  `st_sno` varchar(20) NOT NULL,
  `st_name` varchar(20) DEFAULT NULL,
  `st_password` varchar(255) DEFAULT NULL,
  `st_sex` int(20) DEFAULT NULL,
  `st_col` varchar(255) DEFAULT NULL,
  `st_class` varchar(255) DEFAULT NULL,
  `st_phone` varchar(255) DEFAULT NULL,
  `house_num` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`st_id`),
  KEY `st_name` (`st_name`),
  KEY `house` (`house_num`(191)) USING BTREE,
  KEY `sno` (`st_sno`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('25', '174804001', 'AAA', '123', '1', '软件学院', '17级Java4班', '123456789', '南苑401');
INSERT INTO `student` VALUES ('26', '174804002', 'BBB', '123', '0', '软件学院', '17级Java4班', '123456789', '南苑402');
INSERT INTO `student` VALUES ('27', '174804003', 'CCC', '123', '0', '软件学院', '17级Java4班', '123456789', '南苑403');
INSERT INTO `student` VALUES ('28', '174804004', 'DDD', '123', '0', '软件学院', '17级Java4班', '123456789', '南苑404');
INSERT INTO `student` VALUES ('29', '174804005', 'EEE', '123', '1', '软件学院', '17级java4班', '15237228271', '南苑405');
INSERT INTO `student` VALUES ('30', '174804006', 'FFF', '123', '0', '软件学院', '17级Java4班', '123456789', '南苑406');
INSERT INTO `student` VALUES ('31', '174804007', 'GGG', '123', '1', '软件学院', '17级Java4班', '15237228271', '南苑407');
INSERT INTO `student` VALUES ('40', '174804666', 'afa', 'asdasf', '1', 'asfasf', 'asfasf', '15237228271', 'dwefgwg');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zyh', '123');
INSERT INTO `user` VALUES ('14', '111', '111');
INSERT INTO `user` VALUES ('15', '222', '222');
INSERT INTO `user` VALUES ('16', '333', '333');
INSERT INTO `user` VALUES ('17', 'zy', '123');
INSERT INTO `user` VALUES ('18', '444', '444');
INSERT INTO `user` VALUES ('19', '555', '555');

-- ----------------------------
-- Table structure for `words`
-- ----------------------------
DROP TABLE IF EXISTS `words`;
CREATE TABLE `words` (
  `wo_id` int(11) NOT NULL AUTO_INCREMENT,
  `wo_sno` int(11) DEFAULT NULL,
  `wo_name` varchar(255) DEFAULT NULL,
  `wo_address` varchar(255) DEFAULT NULL,
  `wo_content` varchar(255) DEFAULT NULL,
  `wo_date` date DEFAULT NULL,
  PRIMARY KEY (`wo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of words
-- ----------------------------
INSERT INTO `words` VALUES ('1', '174804312', '刘青闯', '403', '啦啦啦', '2019-12-27');
INSERT INTO `words` VALUES ('2', '123', '123', '312', '321', '2020-01-15');
INSERT INTO `words` VALUES ('3', '3', '312', '312', '231', '2019-12-02');
INSERT INTO `words` VALUES ('4', '2341', '123', '123', '32', '2019-12-27');
INSERT INTO `words` VALUES ('6', '1423', '1243', '1234', '1234', '2019-12-01');
INSERT INTO `words` VALUES ('8', '132', '123`', '132`q', 'rqwe', '2019-12-11');
INSERT INTO `words` VALUES ('9', '312', '13', '132', '312', '2019-12-27');
INSERT INTO `words` VALUES ('10', '4', '123', '123', '132', '2019-12-03');
INSERT INTO `words` VALUES ('11', '1234', '2341', '1234', '1234', '2019-12-09');
INSERT INTO `words` VALUES ('12', '3213213', '321321', '3321321', '321321321', '2019-12-28');
INSERT INTO `words` VALUES ('13', '321321311', '321321111', '321312', '33213', '2019-12-28');
INSERT INTO `words` VALUES ('14', '32132131', '123', '321312', '33213', '2019-12-28');
INSERT INTO `words` VALUES ('15', '213', '321321', '321312', '33213', '2019-12-28');
INSERT INTO `words` VALUES ('16', '213', '123', '321312', '33213', '2019-12-28');
INSERT INTO `words` VALUES ('17', '444', '444', '444', '4444', '2019-12-03');
INSERT INTO `words` VALUES ('18', '777', '77', '7', '7', '2019-12-02');

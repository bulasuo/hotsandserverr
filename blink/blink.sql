/*
Navicat MySQL Data Transfer

Source Server         : abu
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : blink

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-08-29 15:12:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `blinker`
-- ----------------------------
DROP TABLE IF EXISTS `blinker`;
CREATE TABLE `blinker` (
  `bk_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '系统id',
  `bk_blinkerId` int(10) unsigned NOT NULL COMMENT '眨眼者id',
  `bk_blinkeredId` int(10) unsigned NOT NULL COMMENT '被眨眼者id',
  `bk_createDate` datetime NOT NULL,
  PRIMARY KEY (`bk_id`),
  UNIQUE KEY `unique_blinkerId_blinkeredId` (`bk_blinkerId`,`bk_blinkeredId`),
  KEY `bk_blinkeredId` (`bk_blinkeredId`) USING BTREE,
  KEY `bk_blinkerId` (`bk_blinkerId`) USING BTREE,
  CONSTRAINT `bk_blinkerId` FOREIGN KEY (`bk_blinkerId`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `bk_blinkeredId` FOREIGN KEY (`bk_blinkeredId`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blinker
-- ----------------------------
INSERT INTO `blinker` VALUES ('32', '26', '30', '2016-09-15 20:20:03');
INSERT INTO `blinker` VALUES ('36', '31', '32', '2016-09-15 20:20:03');
INSERT INTO `blinker` VALUES ('39', '26', '31', '2016-09-15 20:20:03');
INSERT INTO `blinker` VALUES ('40', '26', '32', '2016-09-15 20:20:03');
INSERT INTO `blinker` VALUES ('41', '31', '26', '2016-09-15 20:20:03');
INSERT INTO `blinker` VALUES ('42', '31', '30', '2016-09-15 20:20:03');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bk_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '系统id',
  `u_id` int(10) unsigned NOT NULL COMMENT '外键 user：u_id',
  `bk_name` varchar(100) NOT NULL COMMENT '书名',
  `bk_img` varchar(300) DEFAULT NULL COMMENT '图片路径',
  `bk_share` varchar(300) DEFAULT NULL COMMENT '分享链接',
  `bk_understanding` varchar(300) DEFAULT NULL COMMENT '你的理解',
  PRIMARY KEY (`bk_id`),
  KEY `book_user` (`u_id`),
  CONSTRAINT `book_user` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '30', 'loveless', 'https://www.baidu.com', 'httpjlnkll', '最终幻想-沙菲罗斯');
INSERT INTO `book` VALUES ('3', '30', 'loveless', 'https://www.baidu.com', 'httpjlnkll', '最终幻想-克劳德');
INSERT INTO `book` VALUES ('4', '30', 'loveless', 'https://www.baidu.com', 'httpjlnkll', '最终幻想-沙菲罗斯');

-- ----------------------------
-- Table structure for `dynamic`
-- ----------------------------
DROP TABLE IF EXISTS `dynamic`;
CREATE TABLE `dynamic` (
  `dnc_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '系统id',
  `u_id` int(10) unsigned NOT NULL COMMENT '外键 user：u_id',
  `dnc_describe` varchar(300) NOT NULL COMMENT '动态描述',
  `dnc_date` datetime NOT NULL COMMENT '动态日期',
  PRIMARY KEY (`dnc_id`),
  KEY `dynamic_user` (`u_id`),
  CONSTRAINT `dynamic_user` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dynamic
-- ----------------------------
INSERT INTO `dynamic` VALUES ('3', '26', '', '2016-09-15 20:20:03');
INSERT INTO `dynamic` VALUES ('6', '26', '呵呵哒bulasuo', '2016-09-15 20:20:03');

-- ----------------------------
-- Table structure for `dynamicimg`
-- ----------------------------
DROP TABLE IF EXISTS `dynamicimg`;
CREATE TABLE `dynamicimg` (
  `dImg_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '系统id',
  `dnc_id` int(10) unsigned NOT NULL COMMENT '外键 dynamic：dnc_id',
  `dImg_img` varchar(300) NOT NULL COMMENT '图片路径',
  PRIMARY KEY (`dImg_id`),
  KEY `dynamicImg_dynamic` (`dnc_id`),
  CONSTRAINT `dynamicImg_dynamic` FOREIGN KEY (`dnc_id`) REFERENCES `dynamic` (`dnc_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dynamicimg
-- ----------------------------

-- ----------------------------
-- Table structure for `movie`
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie` (
  `mo_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '系统id',
  `u_id` int(10) unsigned NOT NULL COMMENT '外键 user：u_id',
  `mo_name` varchar(100) NOT NULL COMMENT '电影名	',
  `mo_img` varchar(300) DEFAULT NULL COMMENT '图片路径',
  `mo_share` varchar(300) DEFAULT NULL COMMENT '分享链接',
  `mo_understanding` varchar(300) DEFAULT NULL COMMENT '你的理解',
  PRIMARY KEY (`mo_id`),
  KEY `movie_user` (`u_id`),
  CONSTRAINT `movie_user` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movie
-- ----------------------------

-- ----------------------------
-- Table structure for `music`
-- ----------------------------
DROP TABLE IF EXISTS `music`;
CREATE TABLE `music` (
  `ms_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '系统id',
  `u_id` int(10) unsigned NOT NULL COMMENT '外键 user：u_id',
  `ms_name` varchar(100) NOT NULL COMMENT '音乐名',
  `ms_img` varchar(300) DEFAULT NULL COMMENT '图片路径',
  `ms_share` varchar(300) DEFAULT NULL COMMENT '分享链接',
  `ms_understanding` varchar(300) DEFAULT NULL COMMENT '你的理解',
  PRIMARY KEY (`ms_id`),
  KEY `music_user` (`u_id`),
  CONSTRAINT `music_user` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of music
-- ----------------------------

-- ----------------------------
-- Table structure for `mv`
-- ----------------------------
DROP TABLE IF EXISTS `mv`;
CREATE TABLE `mv` (
  `mv_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '系统id',
  `u_id` int(10) unsigned NOT NULL COMMENT '外键 user：u_id',
  `mv_name` varchar(100) NOT NULL COMMENT 'mv名',
  `mv_img` varchar(300) DEFAULT NULL COMMENT '图片路径',
  `mv_share` varchar(300) DEFAULT NULL COMMENT '分享链接',
  `mv_understanding` varchar(300) DEFAULT NULL COMMENT '你的理解',
  PRIMARY KEY (`mv_id`),
  KEY `mv_user` (`u_id`),
  CONSTRAINT `mv_user` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mv
-- ----------------------------

-- ----------------------------
-- Table structure for `topic`
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `tc_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '系统id',
  `u_id` int(10) unsigned NOT NULL COMMENT '外键 user：u_id',
  `tc_type` varchar(20) NOT NULL COMMENT '话题类型	【影评】【旅游】【音乐】【搞笑视频链接】【小咖秀链接】【音悦台链接】【哔哩哔哩链接】【斗鱼链接】【YY链接】',
  `tc_name` varchar(100) NOT NULL COMMENT '话题名',
  `tc_date` datetime NOT NULL COMMENT '话题创建时间',
  `tc_describe` varchar(10000) NOT NULL COMMENT '话题正文',
  PRIMARY KEY (`tc_id`),
  KEY `topic_user` (`u_id`),
  CONSTRAINT `topic_user` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic
-- ----------------------------

-- ----------------------------
-- Table structure for `topicimg`
-- ----------------------------
DROP TABLE IF EXISTS `topicimg`;
CREATE TABLE `topicimg` (
  `tImg_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '系统id',
  `tc_id` int(10) unsigned NOT NULL COMMENT '外键 topic：tc_id',
  `tImg_img` varchar(300) NOT NULL COMMENT '图片路径',
  PRIMARY KEY (`tImg_id`),
  KEY `topicImg_topic` (`tc_id`),
  CONSTRAINT `topicImg_topic` FOREIGN KEY (`tc_id`) REFERENCES `topic` (`tc_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topicimg
-- ----------------------------

-- ----------------------------
-- Table structure for `topicreply`
-- ----------------------------
DROP TABLE IF EXISTS `topicreply`;
CREATE TABLE `topicreply` (
  `tcR_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '系统id',
  `tc_id` int(10) unsigned NOT NULL COMMENT '外键 topic：tc_id',
  `u_id` int(10) unsigned NOT NULL COMMENT '外键 user：u_id',
  `tcR_content` varchar(1000) NOT NULL COMMENT '回复正文',
  `tcR_date` datetime NOT NULL COMMENT '回复时间',
  PRIMARY KEY (`tcR_id`),
  KEY `topicReply_topic` (`tc_id`),
  KEY `topicReply_user` (`u_id`),
  CONSTRAINT `topicReply_topic` FOREIGN KEY (`tc_id`) REFERENCES `topic` (`tc_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `topicReply_user` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topicreply
-- ----------------------------

-- ----------------------------
-- Table structure for `topicreply2`
-- ----------------------------
DROP TABLE IF EXISTS `topicreply2`;
CREATE TABLE `topicreply2` (
  `tcR2_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '系统id',
  `tcR_id` int(10) unsigned NOT NULL COMMENT '一级回复id',
  `tcR2_u_id` int(10) unsigned NOT NULL COMMENT '二级回复者id',
  `tcR_u_id` int(10) unsigned NOT NULL COMMENT '被回复者id即一级恢复者id',
  `tcR2_content` varchar(1000) NOT NULL,
  `tcR2_date` datetime NOT NULL,
  PRIMARY KEY (`tcR2_id`),
  KEY `topicReply2_topicReply` (`tcR_id`),
  KEY `topicReply2_replyId` (`tcR2_u_id`),
  KEY `topicReply2_replyedId` (`tcR_u_id`),
  CONSTRAINT `topicReply2_replyId` FOREIGN KEY (`tcR2_u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `topicReply2_replyedId` FOREIGN KEY (`tcR_u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `topicReply2_topicReply` FOREIGN KEY (`tcR_id`) REFERENCES `topicreply` (`tcR_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topicreply2
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '系统id',
  `u_phone` varchar(20) NOT NULL COMMENT '手机号',
  `u_password` varchar(20) NOT NULL COMMENT '密码',
  `u_nickName` varchar(20) NOT NULL COMMENT '昵称',
  `u_sex` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '性别 0:女 1:男 2:女同 3:男同',
  `u_birth` datetime NOT NULL COMMENT '出生日期 时间戳',
  `u_affective` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '情感状态（0:单身，1:恋爱中，2:已婚，3:单身妈妈，4:单身爸爸）',
  `u_headImg` varchar(300) DEFAULT NULL COMMENT '头像路径',
  `u_sign` varchar(100) DEFAULT NULL COMMENT '个性签名',
  `u_occupation` varchar(100) DEFAULT NULL COMMENT '公司及职业',
  `u_sealUp` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '封号否',
  `u_sealUpReason` varchar(300) DEFAULT NULL COMMENT '封号原因',
  `u_createDate` datetime NOT NULL COMMENT '注册日期',
  `u_blinkerId` int(10) unsigned DEFAULT NULL COMMENT '一见钟情id',
  `u_lat` double(10,6) DEFAULT NULL COMMENT '经度',
  `u_lng` double(10,6) DEFAULT NULL COMMENT '纬度',
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `u_phone` (`u_phone`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('26', '15062239788', '111111', '苏拉底', '1', '2016-09-15 20:20:03', '31', 'https://www.baidu.com', '腰包满是银子,米加德遍地鲜花', '南京艺厘米文化科技有限公司', '0', '出轨啦,要死啦!', '2016-09-15 20:20:03', '111', '0.000000', '0.000000');
INSERT INTO `user` VALUES ('30', '15062239789', '111111', '苏拉底', '1', '2016-09-15 20:20:03', '31', 'https://www.baidu.com', '腰包满是银子,米加德遍地鲜花', '南京艺厘米文化科技有限公司', '0', '出轨啦,要死啦!', '2016-09-15 20:20:03', '111', '0.000000', '0.000000');
INSERT INTO `user` VALUES ('31', '15062239777', '111111', '鑻忔媺搴�', '1', '2016-09-15 20:20:03', '31', 'https://www.baidu.com', '鑵板寘婊℃槸閾跺瓙,绫冲姞寰烽亶鍦伴矞鑺�', '鍗椾含鑹哄帢绫虫枃鍖栫鎶�鏈夐檺鍏徃', '0', '鍑鸿建鍟�,瑕佹鍟�!', '2016-09-15 20:20:03', '111', '0.000000', '0.000000');
INSERT INTO `user` VALUES ('32', '15062239666', '111111', '苏拉底', '1', '2016-09-15 20:20:03', '31', 'https://www.baidu.com', '腰包满是银子,米加德遍地鲜花', '南京艺厘米文化科技有限公司', '0', '出轨啦,要死啦!', '2016-09-15 20:20:03', '111', '0.000000', '0.000000');

-- ----------------------------
-- Table structure for `userimg`
-- ----------------------------
DROP TABLE IF EXISTS `userimg`;
CREATE TABLE `userimg` (
  `uImg_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '系统id',
  `u_id` int(10) unsigned NOT NULL COMMENT '副键 user：u_id',
  `uImg_img` varchar(300) NOT NULL COMMENT '图片路径',
  PRIMARY KEY (`uImg_id`),
  KEY `userImg_user` (`u_id`),
  CONSTRAINT `userImg_user` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userimg
-- ----------------------------

-- ----------------------------
-- Table structure for `user_detail`
-- ----------------------------
DROP TABLE IF EXISTS `user_detail`;
CREATE TABLE `user_detail` (
  `ud_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '系统id',
  `u_id` int(10) unsigned NOT NULL COMMENT '用户表主键',
  `ud_height` int(10) unsigned DEFAULT NULL COMMENT '身高(cm)',
  `ud_weight` int(10) unsigned DEFAULT NULL COMMENT '体重(kg)',
  `ud_salary` int(10) unsigned DEFAULT NULL COMMENT '月薪(元)',
  `ud_settlement` varchar(100) DEFAULT NULL COMMENT '未来定居地',
  `ud_liveparents` tinyint(1) unsigned DEFAULT NULL COMMENT '婚后是父母同住  0:否 1:是',
  `ud_education` varchar(50) DEFAULT NULL COMMENT '学历	',
  `ud_hometown` varchar(100) DEFAULT NULL COMMENT '家乡',
  `ud_location` varchar(100) DEFAULT NULL COMMENT '所在地',
  `ud_virgin` tinyint(1) unsigned DEFAULT '0' COMMENT '处男/女否	  0:否 1:是 默认 是',
  `ud_snore` tinyint(1) unsigned DEFAULT '1' COMMENT '打呼噜否	 0:否 1:是 默认 是',
  `ud_driving` varchar(100) DEFAULT '' COMMENT '驾照类别',
  `ud_bodyOdor` tinyint(1) unsigned DEFAULT '1' COMMENT '狐臭否  0:否 1:是 默认 是',
  `ud_ownHouse` tinyint(1) unsigned DEFAULT '0' COMMENT '房子类别	  0:无 1:乡村 2:城镇  默认 无',
  `ud_ownCar` varchar(100) DEFAULT NULL COMMENT '车子类别',
  `ud_states` int(10) unsigned DEFAULT '0' COMMENT '动态数',
  `ud_topics` int(10) unsigned DEFAULT '0' COMMENT '发起话题数',
  `ud_replyTopics` int(10) unsigned DEFAULT '0' COMMENT '回复话题数',
  `ud_blinks` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '眨眼数',
  `ud_blinkeds` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '被眨眼数',
  `ud_breaks` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '分手数',
  PRIMARY KEY (`ud_id`,`u_id`),
  UNIQUE KEY `detail_user` (`u_id`) USING BTREE,
  CONSTRAINT `detail_user` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_detail
-- ----------------------------

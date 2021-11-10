/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : springboot

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 10/11/2021 23:33:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_area
-- ----------------------------
DROP TABLE IF EXISTS `tb_area`;
CREATE TABLE `tb_area`  (
  `area_id` int(2) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `area_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `priority` int(2) NOT NULL DEFAULT 0 COMMENT '权重（优先级排序）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_edit_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`area_id`) USING BTREE,
  UNIQUE INDEX `UK_area`(`area_name`) USING BTREE COMMENT 'name 唯一标识'
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_area
-- ----------------------------
INSERT INTO `tb_area` VALUES (1, '东苑', 1, NULL, NULL);
INSERT INTO `tb_area` VALUES (2, '西苑', 2, NULL, NULL);

-- ----------------------------
-- Table structure for tb_form_action
-- ----------------------------
DROP TABLE IF EXISTS `tb_form_action`;
CREATE TABLE `tb_form_action`  (
  `form_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pass_word` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`form_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_form_action
-- ----------------------------
INSERT INTO `tb_form_action` VALUES (1, '111', NULL);
INSERT INTO `tb_form_action` VALUES (2, '111', NULL);
INSERT INTO `tb_form_action` VALUES (3, 'admin', '123456');
INSERT INTO `tb_form_action` VALUES (4, '111', NULL);
INSERT INTO `tb_form_action` VALUES (5, 'qiao', NULL);
INSERT INTO `tb_form_action` VALUES (6, 'admin', '123456');
INSERT INTO `tb_form_action` VALUES (7, 'jxa', '123456');
INSERT INTO `tb_form_action` VALUES (8, 'cyq', '123456');
INSERT INTO `tb_form_action` VALUES (9, 'cyq', '123456');
INSERT INTO `tb_form_action` VALUES (10, 'jxa23', '123456123');
INSERT INTO `tb_form_action` VALUES (11, 'jxa', '123456');
INSERT INTO `tb_form_action` VALUES (12, 'jxaaaaaa', '123456');
INSERT INTO `tb_form_action` VALUES (13, 'jxaaaaaa', '123456');
INSERT INTO `tb_form_action` VALUES (14, 'jxa', '123456');
INSERT INTO `tb_form_action` VALUES (15, 'jxa', '123456');
INSERT INTO `tb_form_action` VALUES (16, 'jxa', '123456');
INSERT INTO `tb_form_action` VALUES (17, 'jxa', '123456');
INSERT INTO `tb_form_action` VALUES (18, 'jxa', '123456');
INSERT INTO `tb_form_action` VALUES (19, 'jxa', '123456');
INSERT INTO `tb_form_action` VALUES (20, 'jxa', '123456');
INSERT INTO `tb_form_action` VALUES (21, 'jxa', '123456');
INSERT INTO `tb_form_action` VALUES (22, 'jxa', '123456');
INSERT INTO `tb_form_action` VALUES (23, 'jxa', '123456');
INSERT INTO `tb_form_action` VALUES (24, '', '123456');
INSERT INTO `tb_form_action` VALUES (25, '', '123456');
INSERT INTO `tb_form_action` VALUES (26, '', '123456');
INSERT INTO `tb_form_action` VALUES (27, '', '123456');
INSERT INTO `tb_form_action` VALUES (28, '', '123456');
INSERT INTO `tb_form_action` VALUES (29, 'jxa', '123456');
INSERT INTO `tb_form_action` VALUES (30, 'jxa111111', '123456');
INSERT INTO `tb_form_action` VALUES (31, 'jxa', '123456');
INSERT INTO `tb_form_action` VALUES (32, 'jxa', '123456');
INSERT INTO `tb_form_action` VALUES (33, '', '123456');
INSERT INTO `tb_form_action` VALUES (34, '', '123456');
INSERT INTO `tb_form_action` VALUES (35, '', '123456');
INSERT INTO `tb_form_action` VALUES (36, 'jxa', '123456');
INSERT INTO `tb_form_action` VALUES (37, 'jxa', '123456');
INSERT INTO `tb_form_action` VALUES (38, 'jxa', '123456');
INSERT INTO `tb_form_action` VALUES (39, 'jxa', '123456');
INSERT INTO `tb_form_action` VALUES (40, 'jxa', '123456');
INSERT INTO `tb_form_action` VALUES (41, 'jxa', '123456');
INSERT INTO `tb_form_action` VALUES (42, 'jxa', '123456');
INSERT INTO `tb_form_action` VALUES (43, 'jxa', '123456');
INSERT INTO `tb_form_action` VALUES (44, 'jxa', '123456');

-- ----------------------------
-- Table structure for tb_head_line
-- ----------------------------
DROP TABLE IF EXISTS `tb_head_line`;
CREATE TABLE `tb_head_line`  (
  `line_id` int(100) NOT NULL AUTO_INCREMENT,
  `line_name` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `line_link` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `line_img` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `priority` int(2) NULL DEFAULT NULL,
  `enable_status` int(2) NOT NULL DEFAULT 0 COMMENT '0.不可用 1.可用',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `last_edit_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`line_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_local_auth
-- ----------------------------
DROP TABLE IF EXISTS `tb_local_auth`;
CREATE TABLE `tb_local_auth`  (
  `local_auth_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `username` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `last_edit_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`local_auth_id`) USING BTREE,
  UNIQUE INDEX `uk_local_profiile`(`username`) USING BTREE,
  INDEX `fk_localauth_profile`(`user_id`) USING BTREE,
  CONSTRAINT `fk_localauth_profile` FOREIGN KEY (`user_id`) REFERENCES `tb_person_info` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_person_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_person_info`;
CREATE TABLE `tb_person_info`  (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `profile_img` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `enable_status` int(2) NOT NULL DEFAULT 0 COMMENT '0:禁止使用本商城；1：允许使用',
  `user_type` int(2) NOT NULL DEFAULT 1 COMMENT '1：顾客；2：店家；3：超级管理员',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `last_edit_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_person_info
-- ----------------------------
INSERT INTO `tb_person_info` VALUES (1, 'anan', 'tset', 'tset', '1', 1, 2, '2021-11-06 23:33:34', NULL);
INSERT INTO `tb_person_info` VALUES (2, 'qiao', 'testone', '1314@qq.com', '2', 0, 1, '2021-11-07 23:33:42', NULL);
INSERT INTO `tb_person_info` VALUES (3, 'guozi', NULL, NULL, NULL, 0, 1, NULL, NULL);
INSERT INTO `tb_person_info` VALUES (4, 'jiazi', NULL, NULL, NULL, 0, 1, NULL, NULL);
INSERT INTO `tb_person_info` VALUES (5, 'qiaozi', NULL, NULL, NULL, 0, 1, NULL, NULL);
INSERT INTO `tb_person_info` VALUES (6, 'beizi', NULL, NULL, NULL, 0, 1, NULL, NULL);
INSERT INTO `tb_person_info` VALUES (7, '12', NULL, NULL, NULL, 0, 1, NULL, NULL);
INSERT INTO `tb_person_info` VALUES (8, '14', NULL, NULL, NULL, 0, 1, NULL, NULL);
INSERT INTO `tb_person_info` VALUES (9, '17', NULL, NULL, NULL, 0, 1, NULL, NULL);
INSERT INTO `tb_person_info` VALUES (10, '姓名', NULL, NULL, NULL, 0, 1, NULL, NULL);
INSERT INTO `tb_person_info` VALUES (11, '年龄', NULL, NULL, NULL, 0, 1, NULL, NULL);

-- ----------------------------
-- Table structure for tb_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product`  (
  `product_id` int(100) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_desc` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img_addr` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `normal_price` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `promotion_price` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `priority` int(2) NOT NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `last_edit_time` datetime(0) NULL DEFAULT NULL,
  `enable_status` int(2) NULL DEFAULT 0,
  `product_category_id` int(11) NULL DEFAULT NULL,
  `shop_id` int(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`product_id`) USING BTREE,
  INDEX `product_category_id`(`product_category_id`) USING BTREE,
  INDEX `shop_id`(`shop_id`) USING BTREE,
  CONSTRAINT `tb_product_ibfk_1` FOREIGN KEY (`product_category_id`) REFERENCES `tb_product_category` (`product_category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_product_ibfk_2` FOREIGN KEY (`shop_id`) REFERENCES `tb_shop` (`shop_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_product_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_category`;
CREATE TABLE `tb_product_category`  (
  `product_category_id` int(11) NOT NULL,
  `product_category_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `priority` int(2) NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `shop_id` int(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`product_category_id`) USING BTREE,
  INDEX `shop_id`(`shop_id`) USING BTREE,
  CONSTRAINT `tb_product_category_ibfk_1` FOREIGN KEY (`shop_id`) REFERENCES `tb_shop` (`shop_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_product_img
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_img`;
CREATE TABLE `tb_product_img`  (
  `product_img_id` int(20) NOT NULL AUTO_INCREMENT,
  `img_addr` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `img_desc` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `priority` int(2) NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `product_id` int(20) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  PRIMARY KEY (`product_img_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_shop
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop`;
CREATE TABLE `tb_shop`  (
  `shop_id` int(10) NOT NULL AUTO_INCREMENT,
  `owner_id` int(10) NOT NULL COMMENT '店铺创建人',
  `area_id` int(5) NULL DEFAULT NULL,
  `shop_category_id` int(11) NULL DEFAULT NULL,
  `shop_name` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shop_desc` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shop_addr` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shop_img` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `priority` int(3) NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `last_edit_time` datetime(0) NULL DEFAULT NULL,
  `enable_status` int(2) UNSIGNED ZEROFILL NOT NULL DEFAULT 00 COMMENT '-1.不可用0.审核1.可用',
  `advice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`shop_id`) USING BTREE,
  INDEX `area_id`(`area_id`) USING BTREE,
  INDEX `owner_id`(`owner_id`) USING BTREE,
  INDEX `shop_category_id`(`shop_category_id`) USING BTREE,
  CONSTRAINT `tb_shop_ibfk_1` FOREIGN KEY (`area_id`) REFERENCES `tb_area` (`area_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_shop_ibfk_2` FOREIGN KEY (`owner_id`) REFERENCES `tb_person_info` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_shop_ibfk_3` FOREIGN KEY (`shop_category_id`) REFERENCES `tb_shop_category` (`shop_category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_shop
-- ----------------------------
INSERT INTO `tb_shop` VALUES (1, 1, 1, 1, 'test', '测试', '测试', 'test', '测试', NULL, '2021-10-19 17:04:50', '2021-11-09 23:11:22', 01, '测试');
INSERT INTO `tb_shop` VALUES (2, 1, 1, 1, 'QIAOIQ', 'eeeeeeeeeeee', 'qiaoqiaojia', '17732871778', '\\2\\2021102816080921095.jpg', NULL, '2021-10-20 21:49:30', '2021-10-28 16:08:10', 00, 'shenhe1');
INSERT INTO `tb_shop` VALUES (3, 1, 2, 1, 'test', 'test1', 'TEST1', 'test1', 'F:\\upload\\images\\item\\shop\\3\\2021102021551595300.jpg', NULL, '2021-10-20 21:55:15', '2021-10-20 21:55:15', 00, 'shenhe1');
INSERT INTO `tb_shop` VALUES (4, 1, 2, 1, 'test', 'test1', 'TEST1', 'test1', 'F:\\upload\\images\\item\\shop\\6\\2021102021581038368.jpg', NULL, '2021-10-20 21:58:10', '2021-10-20 21:58:10', 00, 'shenhe1');
INSERT INTO `tb_shop` VALUES (5, 1, 2, 1, 'test2', 'test2', 'TEST2', 'test2', '\\5\\2021102111031519309.jpg', NULL, '2021-10-21 11:03:15', '2021-10-21 11:03:15', 00, 'shenhe2');
INSERT INTO `tb_shop` VALUES (6, 1, 2, 1, 'test2', 'test2', 'TEST2', 'test2', '\\6\\2021102111091191729.jpg', NULL, '2021-10-21 11:09:12', '2021-10-21 11:09:12', 00, 'shenhe2');
INSERT INTO `tb_shop` VALUES (7, 1, 2, 2, 'test2', 'test2', 'TEST2', 'test2', '\\7\\2021102111111339922.jpg', NULL, '2021-10-21 11:11:14', '2021-10-21 11:11:14', 00, 'shenhe2');
INSERT INTO `tb_shop` VALUES (8, 1, 2, 2, 'test2', 'test2', 'TEST2', 'test2', '\\8\\2021102111130392370.jpg', NULL, '2021-10-21 11:13:04', '2021-10-21 11:13:04', 00, 'shenhe2');
INSERT INTO `tb_shop` VALUES (9, 1, 2, 1, 'test2', 'test2', 'TEST2', 'test2', '\\9\\2021102111182688321.jpg', NULL, '2021-10-21 11:18:26', '2021-10-21 11:18:26', 00, 'shenhe2');
INSERT INTO `tb_shop` VALUES (10, 1, 2, 1, 'test2', 'test2', 'TEST2', 'test2', '\\10\\2021102111260980173.jpg', NULL, '2021-10-21 11:25:50', '2021-10-21 11:25:50', 00, 'shenhe2');
INSERT INTO `tb_shop` VALUES (11, 1, 2, 3, 'test2', 'test2', 'TEST2', 'test2', '\\11\\2021102111283873806.jpg', NULL, '2021-10-21 11:28:38', '2021-10-21 11:28:38', 00, 'shenhe2');
INSERT INTO `tb_shop` VALUES (12, 1, 2, 3, 'test2', 'test2', 'TEST2', 'test2', '\\12\\2021102111374242049.jpg', NULL, '2021-10-21 11:37:42', '2021-10-21 11:37:42', 00, 'shenhe2');
INSERT INTO `tb_shop` VALUES (13, 1, 2, 3, 'test3', 'test3', 'TEST3', 'test3', '\\13\\2021102514590562715.jpg', NULL, '2021-10-25 14:59:05', '2021-10-25 14:59:05', 00, 'shenhe3');

-- ----------------------------
-- Table structure for tb_shop_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop_category`;
CREATE TABLE `tb_shop_category`  (
  `shop_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_category_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `shop_category_desc` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `shop_category_img` varchar(1200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `priority` int(2) NOT NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `last_edit_time` datetime(0) NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`shop_category_id`) USING BTREE,
  INDEX `parent_id`(`parent_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_shop_category
-- ----------------------------
INSERT INTO `tb_shop_category` VALUES (1, '糕点', '卤肉', 'test', 1, NULL, NULL, NULL);
INSERT INTO `tb_shop_category` VALUES (2, '奶油', '奶油', '1111', 0, NULL, NULL, 1);
INSERT INTO `tb_shop_category` VALUES (3, '泡芙', '泡芙', 'test', 0, NULL, NULL, 1);
INSERT INTO `tb_shop_category` VALUES (4, '蛋糕', '蛋糕', NULL, 0, NULL, NULL, 1);

-- ----------------------------
-- Table structure for tb_wechat_auth
-- ----------------------------
DROP TABLE IF EXISTS `tb_wechat_auth`;
CREATE TABLE `tb_wechat_auth`  (
  `wechat_auth_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `open_id` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`wechat_auth_id`) USING BTREE,
  UNIQUE INDEX `open_id`(`open_id`) USING BTREE,
  INDEX `fk_wechatauth_profile`(`user_id`) USING BTREE,
  CONSTRAINT `fk_wechatauth_profile` FOREIGN KEY (`user_id`) REFERENCES `tb_person_info` (`user_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

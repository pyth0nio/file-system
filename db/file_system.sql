/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50740
 Source Host           : 127.0.0.1:3306
 Source Schema         : file_system

 Target Server Type    : MySQL
 Target Server Version : 50740
 File Encoding         : 65001

 Date: 18/04/2023 20:39:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
                           `cg_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类别ID',
                           `cg_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类别名称',
                           `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
                           `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
                           PRIMARY KEY (`cg_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '类别表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '毕业33', '2023-04-18 09:49:35', '2023-04-18 09:55:28');

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes`  (
                          `cl_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级ID',
                          `cl_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '班级名称',
                          `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
                          `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
                          PRIMARY KEY (`cl_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '班级表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES (1, '高三(1)班级', '2023-04-13 12:50:31', '2023-04-13 12:50:31');

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
                       `file_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件ID',
                       `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件名称',
                       `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'url',
                       `pre_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '预览url',
                       `ext_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '扩展名称',
                       `size` int(11) NOT NULL COMMENT '大小',
                       `keywords` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '关键字',
                       `md5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'md5字符串',
                       `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
                       `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
                       `st_id` int(11) NULL DEFAULT NULL COMMENT '学生ID',
                       `cl_id` int(11) NULL DEFAULT NULL COMMENT '班级ID',
                       `cg_id` int(11) NULL DEFAULT NULL COMMENT '类别ID',
                       PRIMARY KEY (`file_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES (2, '新建 XLS 工作表.xls', 'rtax5f9do.bkt.clouddn.com/新建 XLS 工作表.xls', 'rtax5f9do.bkt.clouddn.com/新建 XLS 工作表.xls', 'xls', 6656, '111', 'FhqRfkSIUXiUweRNPaFcY7W415mI', '2023-04-18 20:27:57', '2023-04-18 20:27:57', 1, 1, 1);
INSERT INTO `file` VALUES (3, '1111.doc', 'rtax5f9do.bkt.clouddn.com/1111.doc', 'rtax5f9do.bkt.clouddn.com/1111.doc', 'doc', 9216, '222', 'FmHAVKcjjoEUgfci1PORxQt_OUBr', '2023-04-18 20:28:25', '2023-04-18 20:28:25', 1, 1, 1);
INSERT INTO `file` VALUES (4, '新建 XLS 工作表.xls', 'rtax5f9do.bkt.clouddn.com/新建 XLS 工作表.xls', 'rtax5f9do.bkt.clouddn.com/新建 XLS 工作表.xls', 'xls', 6656, '1111', 'FhqRfkSIUXiUweRNPaFcY7W415mI', '2023-04-18 20:38:15', '2023-04-18 20:38:15', 1, 1, 1);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
                          `st_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生id',
                          `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生账号',
                          `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生密码',
                          `realname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生姓名',
                          `sex` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生性别',
                          `birth` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生生日',
                          `cl_id` int(11) NOT NULL COMMENT '班级ID',
                          `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
                          `update_time` datetime(0) NOT NULL COMMENT '修改时间',
                          PRIMARY KEY (`st_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学生表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'admin', '123456', '韩梅梅', '女', '2023-04-12', 1, '2023-04-12 22:22:50', '2023-04-12 22:22:48');

SET FOREIGN_KEY_CHECKS = 1;

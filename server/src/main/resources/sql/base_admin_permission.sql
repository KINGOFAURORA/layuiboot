
-- ----------------------------
-- Table structure for base_admin_permission
-- ----------------------------
DROP TABLE IF EXISTS `base_admin_permission`;
CREATE TABLE `base_admin_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单名称',
  `pid` int(11) DEFAULT NULL COMMENT '父菜单id',
  `descpt` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单url',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` int(1) DEFAULT NULL COMMENT '删除标志（0:删除 1：存在）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 0 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of base_admin_permission
-- ----------------------------
INSERT INTO `base_admin_permission` VALUES (1, '系统管理', 0, '系统管理', '', now(), now(), 1);
INSERT INTO `base_admin_permission` VALUES (2, '账号管理', 1, '账号管理', '/user/userManage', now(), now(), 1);
INSERT INTO `base_admin_permission` VALUES (3, '角色管理', 1, '角色管理', '/role/roleManage', now(), now(), 1);
INSERT INTO `base_admin_permission` VALUES (7, '权限管理', 1, '权限管理', '/permission/permissionManage', now(), now(), 1);
INSERT INTO `base_admin_permission` VALUES (9, '基本设置', 0, '基本设置', '', now(), now(), 1);
INSERT INTO `base_admin_permission` VALUES (10, '服务类目管理', 9, '服务类目管理', '/goodsCategory/goodsCategoryManage', now(), now(), 1);
INSERT INTO `base_admin_permission` VALUES (11, '服务类型管理', 9, '服务类型管理', '/serviceType/serviceTypeManage', now(), now(), 1);
INSERT INTO `base_admin_permission` VALUES (12, '支付方式', 9, '支付方式', '/payplatform/payplatManage', now(), now(), 1);
INSERT INTO `base_admin_permission` VALUES (13, '银行管理', 9, '银行管理', '/bank/bankManage', now(), now(), 1);
INSERT INTO `base_admin_permission` VALUES (14, '省市区管理', 9, '省市区管理', '/position/positionManage', now(), now(), 1);


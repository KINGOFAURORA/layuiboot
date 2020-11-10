
-- ----------------------------
-- Table structure for base_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `base_admin_role`;
CREATE TABLE `base_admin_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限角色ID',
  `role_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_desc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色描述',
  `permissions` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `role_status` int(1) NOT NULL DEFAULT 1 COMMENT '1：有效 0：无效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 0 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户角色表';

-- ----------------------------
-- Records of base_admin_role
-- ----------------------------
INSERT INTO `base_admin_role` VALUES (1, '系统管理员', '系统管理员', '1,9', now(), now(), 1);
INSERT INTO `base_admin_role` VALUES (2, '普通管理员', '普通管理员', '9', now(), now(), 1);

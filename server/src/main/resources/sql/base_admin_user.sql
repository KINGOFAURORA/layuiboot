
-- ----------------------------
-- Table structure for base_admin_user
-- ----------------------------
DROP TABLE IF EXISTS `base_admin_user`;
CREATE TABLE `base_admin_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `sys_user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统用户名称',
  `sys_user_pwd` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '系统用户密码',
  `role_id` int(255) DEFAULT NULL COMMENT '角色id',
  `user_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `reg_time` datetime NOT NULL COMMENT '登记时间',
  `user_status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '状态（0：无效；1：有效）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 0 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统管理员帐号表';

-- ----------------------------
-- Records of base_admin_user
-- ----------------------------
INSERT INTO `base_admin_user` VALUES (1, 'admin', '3ef7164d1f6167cb9f2658c07d3c2f0a', 1, '13411182215', now(), 1);
INSERT INTO `base_admin_user` VALUES (2, 'jackson', '6565673a6caee66a6acbd51415bddbda', 2, '19563648695', now(), 1);
INSERT INTO `base_admin_user` VALUES (3, 'alice', '5e1030d25f5ca46aac4c0369b908d762', 2, '11111111111', now(), 1);

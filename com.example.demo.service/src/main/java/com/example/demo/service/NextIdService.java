package com.example.demo.service;

public interface NextIdService {

	/**
	 * 根据传入的4个字段查询next_id表，得到id_prefix
	 * @param system 主系统名
	 * @param subSys 子系统名
	 * @param module 模块名
	 * @param tableName 表名
	 * @return
	 */
	long findIdPrefix(String system, String subSys, String module, String tableName);
}

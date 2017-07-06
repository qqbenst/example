package com.example.demo.service;

public interface IdCreatService {

	/**
	 * 获取最新id
	 * @param system 主系统名
	 * @param subSys 子系统名
	 * @param module 模块名
	 * @param tableName 表名
	 * @return
	 */
	long nextId(String system, String subSys, String module, String tableName);
}

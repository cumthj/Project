package com.hj.dao;

import com.hj.entity.Dept;

public interface DeptDao {
	/**
	 * 新增部门
	 * @param dept
	 */
	public void addDept(Dept dept);
	
	public void queryOne(String deptName);
	
	
}

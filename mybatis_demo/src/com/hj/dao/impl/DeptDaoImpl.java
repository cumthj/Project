package com.hj.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.hj.dao.DeptDao;
import com.hj.entity.Dept;

public class DeptDaoImpl implements DeptDao {
	private Logger log = Logger.getLogger(DeptDaoImpl.class);
	private SqlSessionFactory sqlSessionFac;
	
	//初始化的时候，直接创建SqlSessionFactory对象
	public DeptDaoImpl(SqlSessionFactory sqlSessionFac) {
		super();
		this.sqlSessionFac = sqlSessionFac;
	}

	@Override
	public void addDept(Dept dept) {
		log.info("DeptDaoImpl.addDept()--"+dept);
		//调用数据库，执行insert
		SqlSession sqlSession = sqlSessionFac.openSession();
		sqlSession.insert("com.hj.entity.Dept.addDept", dept);
		sqlSession.commit();

	}

	@Override
	public void queryOne(String deptName) {
		log.info("DeptDaoImpl.queryOne--"+deptName);
		SqlSession sqlSession = sqlSessionFac.openSession();
		Dept dept = sqlSession.selectOne("com.hj.entity.Dept.queryOne", deptName);
		
		dept.toString();
		//return dept;
	}
	
	

}

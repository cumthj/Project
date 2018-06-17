package com.hj.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.hj.entity.Dept;

public class TestDept {
	private static SqlSession sqlSession;
	
	//必须要有
	static {
		//加载xml文件
		try {
			//注意倒的包 import org.apache.ibatis.io.Resources;    ibatis
			Reader reader = Resources.getResourceAsReader("sqlMapConfig.xml");
			//创建一个builder，用这个builder去构建sqlSessionFactory对象
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory sqlSessionFac = builder.build(reader);
			// 通过sqlSessionFactory获取数据库的会话对象
			sqlSession = sqlSessionFac.openSession();
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testConnect(){

		String deptName = "财务部";
		Dept dept = sqlSession.selectOne("com.hj.entity.Dept.queryOne", deptName);
		
		System.out.println(dept);
		System.out.println(dept.getDeptName());
				
	}
	
	
	
}

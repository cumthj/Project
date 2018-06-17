package com.hj.test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.hj.entity.Emp;

public class TestEmp {
	private static SqlSession sqlSession;
	
	//一定要有
	static{
		try {
			//加载xml文件
			Reader reader = Resources.getResourceAsReader("sqlMapConfig.xml");
			//创建一个builder,用这个builder去构建一个SqlSessionFactory对象
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory sqlSessionFac= builder.build(reader);
			//通过sqlSessionFac获取数据库的回话对象
			sqlSession = sqlSessionFac.openSession();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test
	public void queryAll(){
		List<Emp> empList = new ArrayList<Emp>();
		empList = sqlSession.selectList("com.hj.entity.Emp.queryAll");
		
		int n = 0;
		for(int i=0;i<empList.size();i++){
			System.out.println(empList.get(i).toString());
			n++;
		}
		System.out.println("次数："+n);
		Emp emp = empList.get(0);
		System.out.println(emp.getEmpName()+":"+emp.getEmpNo());
	}
}

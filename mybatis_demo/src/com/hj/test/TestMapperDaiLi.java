package com.hj.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.hj.entity.Dept;
import com.hj.entity.Emp;
import com.hj.mapper.DeptMapper;
import com.hj.mapper.EmpMapper;

public class TestMapperDaiLi {
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
		public void queryByDeptNo(){
			//注意  调用的是 nameSpace+id组合里面的值
			List<Dept> deptList = sqlSession.selectList("com.hj.mapper.DeptMapper.queryByDeptNo","A0001");
			System.out.println(deptList);
			
		}
		
		//mapper代理，和方式一的区别就是省去了接口/实现类--dao/impl,selectList("com.hj.entity+id",)这种方式也没了
		//需要注意的是empMapper.java接口里的方法名要和empMapper_mapperDaili.xml里的select
		//标签的id一致
		@Test
		public void queryEmpByEmpNo(){
			EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
			Emp emp = empMapper.queryEmpByEmpNo("7369");
			System.out.println(emp.toString());
		}
	
}

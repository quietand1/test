package test;

import bean.Employee;
import dao.MybatisEmployee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author quiet
 * @create 2021-01-13  20:21
 */
public class MyBatisTest {

    public SqlSessionFactory getsqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession实例，能执行已经映射的？sql语句
        SqlSession openSession = sqlSessionFactory.openSession();
        Employee employee;
        try {
            employee = openSession.selectOne("mynamespace.selectEmp", 1);
            System.out.println(employee);
        } finally {
            openSession.close();
        }
    }



    @Test
    public void test1() throws IOException {
        //1、获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getsqlSessionFactory();

        //2、获取sqlsession对象
        SqlSession openSession = sqlSessionFactory.openSession();
        SqlSession openSession1 = sqlSessionFactory.openSession();

        try {
            MybatisEmployee mapper = openSession.getMapper(MybatisEmployee.class);
            MybatisEmployee mapper1 = openSession1.getMapper(MybatisEmployee.class);

            Employee empById = mapper.getEmpById(1);
            System.out.println(empById);
            openSession.close();
            Employee empById1 = mapper1.getEmpById(1);
            System.out.println(empById1);
        }finally {
            openSession.close();
        }
    }

    @Test
    public void crud() throws IOException {
        SqlSessionFactory sqlSessionFactory = getsqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession(true);

        try {
            MybatisEmployee mapper = openSession.getMapper(MybatisEmployee.class);
            mapper.addEmp(new Employee(null, "xiaogao1122d放大送", "1", "qqq11@qq.com",1));
            openSession.commit();
        }finally {
            openSession.close();
        }


    }
}

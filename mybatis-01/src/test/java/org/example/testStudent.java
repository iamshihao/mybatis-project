package org.example;



import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entity.Student;
import org.example.untils.mybatisUntil;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class testStudent {
    public static void main(String[] args) throws IOException {
/*        String config = "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();*/

        SqlSession sqlSession = mybatisUntil.getSqlSession();
        String sqlId = "org.example.dao.StudentDao" + "." + "selectStudent";

        List<Student> studentList = sqlSession.selectList(sqlId);
        studentList.forEach(student -> System.out.println(student));
        /*for (Student stu:studentList) {
            System.out.println("查询的学生: " + stu);
        }*/
        sqlSession.close();

    }


    @Test
    public void insertStudent(){
        SqlSession sqlSession = mybatisUntil.getSqlSession();
        Student student = new Student();
        student.setId(1002);
        student.setName("关羽");
        student.setEmail("关羽@sanguo.com");
        student.setAge(47);
        String sqlId = "org.example.dao.StudentDao.insertStudent";
        int insertNums = sqlSession.insert(sqlId,student);
        System.out.println("新增" + insertNums + "名学生");
        sqlSession.close();
    }
}

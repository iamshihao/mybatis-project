package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.studentDao;
import org.example.entity.Student;
import org.example.untils.mybatisUntil;
import org.junit.Test;
import java.util.List;

public class testMybatis {
    @Test
    public void selectStudent(){
        SqlSession sqlSession = mybatisUntil.getSqlsession();
        studentDao dao = sqlSession.getMapper(studentDao.class);
        List<Student> students = dao.selectStudent();
        students.forEach(student -> System.out.println(student));
        sqlSession.close();
    }
    @Test
    public void insertStudent(){
        SqlSession sqlSession = mybatisUntil.getSqlsession();
        studentDao dao = sqlSession.getMapper(studentDao.class);
        Student student = new Student();
        student.setId(1004);
        student.setName("赵云");
        student.setEmail("zhaoyun@sanguo.com");
        student.setAge(46);
        int num = dao.insertStudent(student);
        System.out.println("新增" + num + "名同学");
        sqlSession.close();
    }
}

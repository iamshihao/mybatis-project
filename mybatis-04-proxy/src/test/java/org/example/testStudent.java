package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.studentDao;
import org.example.entity.Student;
import org.example.untils.mybatisUntil;
import org.junit.Test;

import java.util.List;

public class testStudent {

    @Test
    public void selectStudent(){
        SqlSession session = mybatisUntil.getSqlSession();
        studentDao dao = session.getMapper(studentDao.class);
        List<Student> student = dao.selectStudent();
        student.forEach(stu -> System.out.println(stu));
        session.close();
    }

    @Test
    public void insertStudent(){
        SqlSession session = mybatisUntil.getSqlSession();
        studentDao dao = session.getMapper(studentDao.class);
        Student student = new Student();
        student.setId(1005);
        student.setName("黄忠");
        student.setEmail("huangzhong@sangu.com");
        student.setAge(60);
        int in = dao.insertStudent(student);
        System.out.println("新增同学：" + in + "名");
        session.close();
    }
}

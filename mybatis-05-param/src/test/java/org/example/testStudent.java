package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.studentDao;
import org.example.entity.Student;
import org.example.entity.queryObjectParam;
import org.example.untils.mybatisUntil;
import org.junit.Test;

import java.util.List;

public class testStudent {

    @Test
    public void selectStudent (){
        SqlSession session = mybatisUntil.getSqlSession();
        studentDao dao = session.getMapper(studentDao.class);
        Student student = dao.selectStudentById(1004);
        System.out.println("查询到的同学为: " + student);
        session.close();
    }

    @Test
    public void selectMultiById (){
        SqlSession session = mybatisUntil.getSqlSession();
        studentDao dao = session.getMapper(studentDao.class);
        List<Student> student = dao.selectMultiParam("刘备", 1002);
        System.out.println("查询到的同学为: " + student);
        session.close();
    }

    @Test
    public void selectMultiObjectParam (){
        SqlSession session = mybatisUntil.getSqlSession();
        studentDao dao = session.getMapper(studentDao.class);
        queryObjectParam object = new queryObjectParam();
        object.setParamId(1005);
        object.setParamName("刘备");
        List<Student> student = dao.selectMultiObjectParam(object);
        System.out.println("查询到的同学为: " + student);
    }

    @Test
    public void selectObjectParam (){
        SqlSession session = mybatisUntil.getSqlSession();
        studentDao dao = session.getMapper(studentDao.class);
        Student student = new Student();
        student.setId(1002);
        student.setName("刘备");
        List<Student> stu = dao.selectObjectParam(student);
        System.out.println("查询到的同学为: " + stu);
    }

}

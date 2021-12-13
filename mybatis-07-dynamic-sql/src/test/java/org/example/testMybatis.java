package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.studentDao;
import org.example.entity.Student;
import org.example.untils.mybatisUntil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class testMybatis {
    @Test
    public void selectStudentIf(){
        SqlSession sqlSession = mybatisUntil.getSqlsession();
        studentDao dao = sqlSession.getMapper(studentDao.class);
        Student student = new Student();
        student.setName("刘备");
        student.setAge(45);
        List<Student> students = dao.selectStudentIf(student);
        students.forEach(student1 -> System.out.println("if==学生："  + student1));
        sqlSession.close();
    }
    @Test
    public void selectStudentWhere(){
        SqlSession sqlSession = mybatisUntil.getSqlsession();
        studentDao dao = sqlSession.getMapper(studentDao.class);
        Student student = new Student();
        student.setName("刘备");
        student.setAge(45);
        List<Student> students = dao.selectStudentWhere(student);
        students.forEach(student1 -> System.out.println("if==学生："  + student1));
        sqlSession.close();
    }
    @Test
    public void selectForeachOne(){
        SqlSession sqlSession = mybatisUntil.getSqlsession();
        studentDao dao = sqlSession.getMapper(studentDao.class);
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        list.add(1004);
        list.add(1005);
        List<Student> students = dao.selectForeachOne(list);
        students.forEach(student -> System.out.println("foreachOne==" + student));
        sqlSession.close();
    }
    @Test
    public void selectForeachStudent(){
        SqlSession sqlSession = mybatisUntil.getSqlsession();
        studentDao dao = sqlSession.getMapper(studentDao.class);
        List<Student> stuList = new ArrayList<>();
        Student stu1 = new Student();
        stu1.setId(1001);
        stuList.add(stu1);
        Student stu5 = new Student();
        stu5.setId(1005);
        stuList.add(stu5);
        List<Student> students = dao.selectForeachStudent(stuList);
        students.forEach(student -> System.out.println("foreachOne==" + student));
        sqlSession.close();
    }
}

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
    @Test
    public void selectStudentByParam(){
        SqlSession sqlSession = mybatisUntil.getSqlsession();
        studentDao dao = sqlSession.getMapper(studentDao.class);
        List<Student> students = dao.selectStudentByParam("刘备", 1002);
        students.forEach(student -> System.out.println("查询到符合条件的同学有： " + " " + student));
        sqlSession.close();
    }
    @Test
    public void selectStudentByObject(){
        SqlSession sqlSession = mybatisUntil.getSqlsession();
        studentDao dao = sqlSession.getMapper(studentDao.class);
        Student student = new Student();
        student.setName("关羽");
        student.setId(1003);
        List<Student> students = dao.selectStudentByObject(student);
        students.forEach(everyStudent -> System.out.println("查询到符合条件的同学有： " + " " + everyStudent));
    }
    @Test
    public void updateStudent(){
        SqlSession sqlSession = mybatisUntil.getSqlsession();
        studentDao dao = sqlSession.getMapper(studentDao.class);
        int num = dao.updateStudent("张飞",1003);
        System.out.println("已更新" + num + "条数据");
        sqlSession.close();
    }
    @Test
    public void deleteStudent(){
        SqlSession sqlSession = mybatisUntil.getSqlsession();
        studentDao dao = sqlSession.getMapper(studentDao.class);
        int num = dao.deleteStudent(1005);
        System.out.println("已删除" + num + "条数据");
        sqlSession.close();
    }
}

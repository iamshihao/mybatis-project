package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.StudentDao;
import org.example.entity.Student;
import org.example.pojo.MyStudent;
import org.example.untils.mybatisUntil;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentTest {
    @Test
    public void selectStudents() throws IOException {
        String config = "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String sqlId = "org.example.dao.StudentDao.selectStudents";
        List<Student> students = sqlSession.selectList(sqlId);
        students.forEach(student -> System.out.println("查询到的学生是：" + student));
        sqlSession.close();
    }
    @Test
    public void insertStudent(){
        SqlSession sqlSession = mybatisUntil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(1006);
        student.setName("黄忠");
        student.setEmail("machao@sanguo.com");
        student.setAge(60);
        int num = dao.insertStudent(student);
        System.out.println("新增了" + num + "条数据");
        sqlSession.close();
    }
    @Test
    public void selectStudentByParm(){
        SqlSession sqlSession = mybatisUntil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectStudentByParam(1001, "马超");
        students.forEach(student -> System.out.println("查询出来的同学有：" + student));
        sqlSession.close();
    }
    @Test
    public void selectStudentByParam(){
        SqlSession sqlSession = mybatisUntil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(1001);
        student.setName("马超");
        List<Student> students = dao.selectStudentByObject(student);
        students.forEach(student1 -> System.out.println("查询出来的同学有：" + student1));
        sqlSession.close();
    }
    @Test
    public  void updateStudent(){
        SqlSession sqlSession = mybatisUntil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(1006);
        student.setEmail("huangzhong@sanguo.com");
        int num = dao.updateStudent(student);
        System.out.println("更新了" + num + "条数据");
        sqlSession.close();
    }
    @Test
    public void selectStudentIf(){
        SqlSession sqlSession = mybatisUntil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectStudentIf(1002);
        students.forEach(student -> System.out.println("查询出来的同学有：" + student));
        sqlSession.close();
    }
    @Test
    public void selectStudentForeach(){
        SqlSession sqlSession = mybatisUntil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Integer> studentIds = new ArrayList<>();
        studentIds.add(1001);
        studentIds.add(1002);
        studentIds.add(1003);
        studentIds.add(1004);
        List<Student> students = dao.selectStudentForeach(studentIds);
        students.forEach(student -> System.out.println("查询出来的同学有：" + student));
        sqlSession.close();
    }
    @Test
    public void selectStudentForeachStudents(){
        SqlSession sqlSession = mybatisUntil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setId(1002);
        students.add(student);
        Student student1 = new Student();
        student1.setId(1003);
        students.add(student1);
        Student student2 = new Student();
        student2.setId(1004);
        students.add(student2);
        Student student3 = new Student();
        student3.setId(1005);
        students.add(student3);
        List<Student> stus = dao.selectStudentForeachStudents(students);
        stus.forEach(student4 -> System.out.println("查询出来的同学有：" + student4));
    }
    @Test
    public void selectStudentResultMap(){
        SqlSession sqlSession = mybatisUntil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> students = dao.selectStudentResultMap();
        students.forEach(student -> System.out.println("查询到的同学有:" + student));
    }
}

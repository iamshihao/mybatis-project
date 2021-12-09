package org.example;

import org.example.dao.impl.studentDaoImpl;
import org.example.dao.studentDao;
import org.example.entity.Student;
import org.junit.Test;
import java.util.List;

public class testMybatis {
    @Test
    public void selectStudents(){
       studentDao dao = new studentDaoImpl();
       List<Student> studentList = dao.selectStudents();
       studentList.forEach(student -> System.out.println("学生：" + student));
    }

    @Test
    public void insertStudent(){
        studentDao dao = new studentDaoImpl();
        Student stu = new Student();
        stu.setId(3032);
        stu.setName("张飞");
        stu.setEmail("zhangfei@sanguo.com");
        stu.setAge(45);
        int nums = dao.insertStudent(stu);
        System.out.println("新增" + nums + "名同学");

    }
}

package org.example.dao;


import org.example.entity.Student;
import java.util.List;

public interface StudentDao {

    //查询student表所有数据
    public List<Student> selectStudent();

    //新增一条数据
    public int insertStudent(Student student);



}

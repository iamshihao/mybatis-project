package org.example.dao;

import org.example.entity.Student;
import java.util.List;

public interface studentDao {

    List<Student> selectStudent();

    int insertStudent(Student student);


}

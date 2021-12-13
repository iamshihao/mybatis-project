package org.example.dao;

import org.example.entity.Student;
import java.util.List;

public interface studentDao {
    List<Student> selectStudentIf(Student student);

    List<Student> selectStudentWhere(Student student);

    List<Student> selectForeachOne(List<Integer> idList);

    List<Student> selectForeachStudent(List<Student> studentList);
}

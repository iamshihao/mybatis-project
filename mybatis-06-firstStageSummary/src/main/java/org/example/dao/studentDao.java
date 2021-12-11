package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Student;
import java.util.List;

public interface studentDao {

    List<Student> selectStudent();

    int insertStudent(Student student);

    List<Student> selectStudentByParam(@Param("studentName") String name, @Param("studentId") Integer id);

    List<Student> selectStudentByObject(Student student);

}

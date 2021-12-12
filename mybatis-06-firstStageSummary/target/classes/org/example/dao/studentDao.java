package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Student;
import java.util.List;
import java.util.Map;

public interface studentDao {

    List<Student> selectStudent();

    int insertStudent(Student student);

    List<Student> selectStudentByParam(@Param("studentName") String name, @Param("studentId") Integer id);

    List<Student> selectStudentByObject(Student student);

    int updateStudent(@Param("studentName") String name, @Param("studentId") int id);

    int deleteStudent(@Param("studentId") int id);

    Map<Object,Object> selectMapById(int id);

}

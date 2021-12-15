package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Student;
import org.example.pojo.MyStudent;

import java.util.List;

public interface StudentDao {
    List<Student> selectStudents();

    int insertStudent(Student student);

    List<Student> selectStudentByParam(@Param("studentId") int id, @Param("studentName") String name);

    List<Student> selectStudentByObject(Student student);

    int updateStudent(Student student);

    List<Student> selectStudentIf(@Param("studentId") int id);

    List<Student> selectStudentForeach(List<Integer> idList);

    List<Student> selectStudentForeachStudents(List<Student> students);

    List<MyStudent> selectStudentResultMap();
}

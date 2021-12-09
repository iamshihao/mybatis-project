package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Student;
import org.example.entity.queryObjectParam;

import java.util.List;

public interface studentDao {
    Student selectStudentById(Integer id);

    List<Student> selectMultiParam (@Param("myName") String name,
                                   @Param("myId") Integer id);

    List<Student> selectMultiObjectParam (queryObjectParam objectParam);

    List<Student> selectObjectParam(Student student);
}

package org.example.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.studentDao;
import org.example.entity.Student;
import org.example.untils.mybatisUntil;
import java.util.List;

public class studentDaoImpl implements studentDao {

    @Override
    public List<Student> selectStudents() {
        SqlSession sqlSession = mybatisUntil.getSqlSession();
        String sqlId = "org.example.dao.studentDao.selectStudents";
        List<Student> studentList = sqlSession.selectList(sqlId);
        sqlSession.close();
        return studentList;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession sqlSession = mybatisUntil.getSqlSession();
        String sqlId = "org.example.dao.studentDao.insertStudent";
        int in = sqlSession.insert(sqlId,student);
        sqlSession.close();
        return in;
    }
}

package org.example.untils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;


public class mybatisUntil {
    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        String config = "mybatis-Config.xml";
        try {
            InputStream in = Resources.getResourceAsStream(config);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
                e.printStackTrace();
        }
    }

        public static SqlSession getSqlSession(){
            SqlSession sqlSession = null;
            if (sqlSessionFactory != null){
                sqlSession = sqlSessionFactory.openSession(true);
            }
            return sqlSession;
        }

}

package org.example.untils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

public class mybatisUntil {
    static SqlSessionFactory factory = null;
    static{
        String config= "mybatisConfig.xml";
        try {
            InputStream in = Resources.getResourceAsStream(config);
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static SqlSession getSqlSession(){
        SqlSession session = null;
        if (factory != null){
            session = factory.openSession(true);
        }
        return session;
    }
}

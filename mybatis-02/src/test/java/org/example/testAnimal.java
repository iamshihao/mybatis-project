package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entity.Animal;
import org.example.untils.mybatisUntil;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class testAnimal {
/*    public static void main(String[] args) throws IOException {

        String config = "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();

        String sqlId = "org.example.dao.AnimalDao" + "." + "selectAnimals";
        List<Animal> animalsList = sqlSession.selectList(sqlId);
        animalsList.forEach(Animal -> System.out.println(Animal));
        sqlSession.close();

    }*/

    @Test
    public void testSelect() throws IOException {
/*        String config = "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();*/

        SqlSession sqlSession = mybatisUntil.getSqlSession();
        String sqlId = "org.example.dao.AnimalDao" + "." + "selectAnimals";
        List<Animal> animalsList = sqlSession.selectList(sqlId);
        animalsList.forEach(Animal -> System.out.println(Animal));
        sqlSession.close();
    }

    @Test
    public void testInsert() throws IOException {
/*        String config = "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession(true);*/

        SqlSession sqlSession = mybatisUntil.getSqlSession();
        String sqlId = "org.example.dao.AnimalDao.insertAnimal";
        Animal animal = new Animal();
        animal.setId(3025);
        animal.setColor("灰色");
        animal.setName("哈士奇");
        animal.setHair("长发");
        int insertNums = sqlSession.insert(sqlId,animal);
        //sqlSession.commit();
        System.out.println("新增数据：" + insertNums + "条");
        sqlSession.close();
    }

}

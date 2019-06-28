package com.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class SqlSessionFactoryUtils {
    private static SqlSessionFactory factory;
    //得到一个SqlSessionFactory
    static{
        String url= "mybatis/mybatis-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
        factory=sfb.build(reader);
       }
     public static SqlSession getSqlSession(){
           return factory.openSession();
     }

}

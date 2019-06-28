package com.test;

import com.dao.UserMapper;
import com.entity.User;
import com.entity.UserExample;
import com.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class UseDemo {
    public static void main(String[] args) throws Exception {
        //get session
        SqlSession session= SqlSessionFactoryUtils.getSqlSession();
        //get User map
        UserMapper userMapper=session.getMapper(UserMapper.class);
        //use userMap get resultset
        UserExample example=new UserExample();
        List<User> users = userMapper.selectByExample(example);
        for (User user:users){
            System.out.print(user.getId()+",");
            System.out.print(user.getName()+",");
            System.out.print(user.getPassword()+",");
            System.out.println();
        }

    }
}

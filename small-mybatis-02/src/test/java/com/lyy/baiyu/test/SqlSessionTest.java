package com.lyy.baiyu.test;

import com.lyy.baiyu.mybatis02.binding.MapperRegistry;
import com.lyy.baiyu.mybatis02.session.SqlSession;
import com.lyy.baiyu.mybatis02.session.SqlSessionFactory;
import com.lyy.baiyu.mybatis02.session.defaults.DefaultSqlSessionFactory;
import com.lyy.baiyu.test.dao.IUserDao;
import org.junit.Test;

/**
 * @authoer: liuYY
 * @createDate: 2022/7/5 20:27
 */
public class SqlSessionTest {

    @Test
    public void sqlSessionTest() throws Exception {
        MapperRegistry mapperRegistry = new MapperRegistry();
        mapperRegistry.addMapper("com.lyy.baiyu.test.dao");
        SqlSessionFactory sessionFactory = new DefaultSqlSessionFactory(mapperRegistry);

        SqlSession sqlSession = sessionFactory.openSession();
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        String s = userDao.queryUserName("1111");
        System.out.println(s);
    }
}

package com.lyy.baiyu.mybatis02.session;

/**
 * @authoer: liuYY
 * @createDate: 2022/7/5 20:19
 */
public interface SqlSessionFactory {


    /**
     * 打开一个session
     *
     * @return 返回sqlSession
     */
    SqlSession openSession();
}

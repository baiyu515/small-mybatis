package com.lyy.baiyu.mybatis02.session.defaults;

import com.lyy.baiyu.mybatis02.binding.MapperRegistry;
import com.lyy.baiyu.mybatis02.session.SqlSession;
import com.lyy.baiyu.mybatis02.session.SqlSessionFactory;

/**
 * @authoer: liuYY
 * @createDate: 2022/7/5 20:20
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}

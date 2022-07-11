package com.lyy.baiyu.mybatis02.session.defaults;

import com.lyy.baiyu.mybatis02.binding.MapperRegistry;
import com.lyy.baiyu.mybatis02.session.SqlSession;

/**
 * @authoer: liuYY
 * @createDate: 2022/7/5 17:40
 */
public class DefaultSqlSession implements SqlSession {


    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + "方法：" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) throws Exception {
        return mapperRegistry.getMapper(type, this);
    }
}

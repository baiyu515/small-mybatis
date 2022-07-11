package com.lyy.baiyu.mybatis02.binding;

import com.lyy.baiyu.mybatis02.session.SqlSession;

import java.lang.reflect.Proxy;

/**
 * @authoer: liuYY
 * @createDate: 2022/7/5 17:41
 */
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(SqlSession sqlSession) {
        MapperProxy<T> mapperProxy = new MapperProxy<>(mapperInterface, sqlSession);
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }
}

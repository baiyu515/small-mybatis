package com.lyy.baiyu.mybatis01.binding;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @authoer: liuYY
 * @createDate: 2022/7/5 16:05
 */
public class MapperProxyFactory<T> {

    private Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(Map<String, String> sqlSession) {
        MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }
}

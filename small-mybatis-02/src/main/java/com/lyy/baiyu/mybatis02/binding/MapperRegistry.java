package com.lyy.baiyu.mybatis02.binding;

import cn.hutool.core.lang.ClassScanner;
import com.lyy.baiyu.mybatis02.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @authoer: liuYY
 * @createDate: 2022/7/5 17:40
 */
public class MapperRegistry {


    private Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) throws Exception {
        MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if (mapperProxyFactory == null) {
            throw new Exception("type " + type + " is not known to the Registry");
        }
        return mapperProxyFactory.newInstance(sqlSession);
    }

    public <T> void addMapper(Class<T> type) throws Exception {
        //接口才可以添加
        if (type.isInterface()) {
            if (knownMappers.containsKey(type)) {
                throw new Exception("type " + type + " is known to the Registry");
            }
            knownMappers.put(type, new MapperProxyFactory<>(type));
        }
    }

    public void addMapper(String packageName) throws Exception {
        Set<Class<?>> classes = ClassScanner.scanPackage(packageName);
        for (Class<?> aClass : classes) {
            addMapper(aClass);
        }
    }
}

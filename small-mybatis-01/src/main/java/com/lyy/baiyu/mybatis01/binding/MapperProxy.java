package com.lyy.baiyu.mybatis01.binding;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @authoer: liuYY
 * @createDate: 2022/7/5 15:54
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {
    private static final long serialVersionUID = 943874762671029409L;

    private Map<String, String> sqlSession;

    private Class<T> mapperInterface;

    public MapperProxy(Map<String, String> sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        }

        return "你的被代理了！" + sqlSession.get(mapperInterface.getName() + "." + method.getName());
    }
}

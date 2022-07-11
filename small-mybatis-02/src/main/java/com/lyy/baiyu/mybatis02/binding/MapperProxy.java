package com.lyy.baiyu.mybatis02.binding;

import com.lyy.baiyu.mybatis02.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @authoer: liuYY
 * @createDate: 2022/7/5 16:35
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {

    private static final long serialVersionUID = 491037580122536169L;

    private final Class<T> mapperInterface;

    private final SqlSession sqlSession;

    public MapperProxy(Class<T> mapperInterface, SqlSession sqlSession) {
        this.mapperInterface = mapperInterface;
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        }
        return sqlSession.selectOne(method.getName(), args);
    }
}

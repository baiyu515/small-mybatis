package com.lyy.baiyu.mybatis02.session;

/**
 * @authoer: liuYY
 * @createDate: 2022/7/5 16:38
 */
public interface SqlSession {

    /**
     * 根据指定的SqlID获取一条记录的封装对象
     *
     * @param statement statement SqlId
     * @param <T>       return 封装后的对象
     * @return Mapped object 封装之后的对象
     */
    <T> T selectOne(String statement);

    /**
     * 根据指定的SqlID获取一条记录的封装对象，只不过这个方法容许我们可以给sql传递一些参数
     * 一般在实际使用中，这个参数传递的是pojo，或者Map或者ImmutableMap
     *
     * @param statement statement SqlId
     * @param parameter 参数
     * @param <T>       return 封装后的对象
     * @return 结果
     */
    <T> T selectOne(String statement, Object parameter);

    /**
     * 得到映射器，这个巧妙的使用了泛型，使得类型安全
     *
     * @param type Mapper interface class
     * @param <T>  the mapper type
     * @return a mapper bound to this SqlSession
     */
    <T> T getMapper(Class<T> type) throws Exception;
}

import com.lyy.baiyu.mybatis01.binding.MapperProxyFactory;
import org.junit.Test;
import test.IUserDao;

import java.util.HashMap;
import java.util.Map;

/**
 * @authoer: liuYY
 * @createDate: 2022/7/5 16:08
 */
public class MapperProxyTest {


    @Test
    public void mapperProxyTest() {

        MapperProxyFactory<IUserDao> mapperProxyFactory = new MapperProxyFactory<>(IUserDao.class);

        Map<String,String> sqlSession=new HashMap<>();
        sqlSession.put("test.IUserDao.queryUserById","模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户姓名");

        IUserDao iUserDao = mapperProxyFactory.newInstance(sqlSession);
        String result = iUserDao.queryUserById("1");
        System.out.println(result);
    }
}

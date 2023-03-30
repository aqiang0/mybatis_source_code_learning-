package my;

import my.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author aqian
 * @description
 * @date 2023/3/27 12:26:00
 */
public class SimpleTest {
  public static void main(String[] args) throws IOException {
    String resource = "my/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    //创建SqlSessionFacory  .build构建配置文件入口
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    //获取Mapper
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    System.out.println(mapper.queryById(1L));
    sqlSession.commit();
    sqlSession.close();
  }
}

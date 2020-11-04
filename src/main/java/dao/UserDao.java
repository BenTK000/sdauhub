package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import annotation.UserAnnotation;
import entities.User;


public class UserDao {
	public User select(Map<String,String> map) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		try (SqlSession session = sqlSessionFactory.openSession()) {
			  UserAnnotation anno = session.getMapper(UserAnnotation.class);
			  User user = anno.selectOne(map);
			  return user;
		}
	}

	public int delete(int user_id) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		try (SqlSession session = sqlSessionFactory.openSession()) {
			  UserAnnotation anno = session.getMapper(UserAnnotation.class);
			  int i = anno.deleteByUser_id(user_id);
			  session.commit();
			  return i;
		}
	}

	public int update(String user_name,String user_pwd) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		try (SqlSession session = sqlSessionFactory.openSession()) {
			  UserAnnotation anno = session.getMapper(UserAnnotation.class);
			  int i = anno.updateByUser_id(user_name,user_pwd);
			  session.commit();
			  return i;
		}
	}

	public int insert(User user) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		try (SqlSession session = sqlSessionFactory.openSession()) {
			  UserAnnotation anno = session.getMapper(UserAnnotation.class);
			  int i = anno.insertOne(user);
			  session.commit();
			  return i;
		}
		
	}
	
	
	
}

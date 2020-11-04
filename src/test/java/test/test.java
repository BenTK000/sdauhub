package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import dao.UserDao;
import entities.User;



public class test {
	@Test
	public void testSelect() throws IOException {
		UserDao userDao = new UserDao();
		Map<String,String> map = new HashMap<String,String>();
		map.put("user_name","Caa");
		map.put("user_pwd","aaa");
		User user = userDao.select(map);
		System.out.println(user);
	}
	@Test
	public void testDelete() throws IOException {
		UserDao userDao = new UserDao();
		int i = userDao.delete(20);
		System.out.println(i);
	}
	@Test
	public void testUpdate() throws IOException {
		UserDao userDao = new UserDao();
		int i = userDao.update("ssss","ss");
		System.out.println(i);
	}
	@Test
	public void testInsert() throws IOException {
		UserDao userDao = new UserDao();
		User user = new User(21,"123","123","123","aaa");
		userDao.insert(user);
	}
	@Test
	public void test(){
		System.out.println("right..");
	}
}

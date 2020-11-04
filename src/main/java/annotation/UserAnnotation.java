package annotation;


import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import entities.User;

public interface UserAnnotation {
	@Select("select * from Users where user_name = #{user_name} and user_pwd = #{user_pwd}")
	public User selectOne(Map<String,String> map);
	@Insert("insert into users(user_id,user_name,user_email,user_pwd,user_type) values(#{user_id},#{user_name},#{user_email},#{user_pwd},#{user_type})")
	public int insertOne(User user);
	@Update("update users set user_pwd=#{user_pwd} where user_name=#{user_name}")
	public int updateByUser_id(@Param("user_name")String user_name,@Param("user_pwd")String user_pwd);
	@Delete("delete from Users where user_id=#{user_id}")
	public int deleteByUser_id(int user_id);
}

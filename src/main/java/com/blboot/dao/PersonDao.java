package com.blboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.blboot.pojo.person;

public interface PersonDao {
	//根据id查询用户
	@Select("select * from person where id=#{id}")//mybatis的注解
	public person findUser(@Param("id") int id);
	
	//新增用户
	@Insert("insert into person(password,username) value(#{password},#{username})")
	public void insertPerson(person person);
	
	//修改用户
	@Update("update person set username=#{username} where id=#{id}")
	public void updatePerson(person person);
	
	//删除用户
	@Delete("delete from person where id=#{id}")
	public void deletePerson(int id);
	
	//查询所有
	@Select("select * from person")
	public List<person> getAllPerson();
}

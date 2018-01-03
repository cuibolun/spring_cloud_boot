package com.blboot.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.blboot.pojo.person;

public interface PersonDao {
	@Select("select * from person where id=#{id}")//mybatis的注解
	public person findUser(@Param("id") int id);
}

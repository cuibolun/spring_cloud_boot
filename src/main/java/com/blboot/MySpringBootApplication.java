package com.blboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blboot.dao.PersonDao;
import com.blboot.pojo.person;

@SpringBootApplication
@Controller
@MapperScan("com.blboot.dao")
public class MySpringBootApplication {
	@Autowired
	private PersonDao personDao;
	
	@RequestMapping("/hello/{id}")
	@ResponseBody
	public person hello(@PathVariable("id") int id){
		person p=personDao.findUser(id);
		return p;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MySpringBootApplication.class, args);
	}
}

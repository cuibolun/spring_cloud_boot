package com.blboot;

import java.nio.charset.Charset;
import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.blboot.dao.PersonDao;
import com.blboot.pojo.person;



@SpringBootApplication
@Controller
@MapperScan("com.blboot.dao")
public class MySpringBootApplication extends WebMvcConfigurerAdapter{
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

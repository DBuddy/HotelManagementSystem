package indi.zzw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@org.mybatis.spring.annotation.MapperScan("indi.zzw.api")
public class HmsApplication extends SpringBootServletInitializer{
	private Logger logger = LoggerFactory.getLogger(HmsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HmsApplication.class, args);
	}



}

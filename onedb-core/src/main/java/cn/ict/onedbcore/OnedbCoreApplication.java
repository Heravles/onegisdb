package cn.ict.onedbcore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.ict.onedbcore.mapper")
@SpringBootApplication
public class OnedbCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnedbCoreApplication.class, args);
	}
}

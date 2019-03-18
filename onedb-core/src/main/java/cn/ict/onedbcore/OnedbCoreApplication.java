package cn.ict.onedbcore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import cn.ict.onedbcore.filetransfer.FileStorageProperties;

@MapperScan("cn.ict.onedbcore.mapper")
@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class OnedbCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnedbCoreApplication.class, args);
	}
}

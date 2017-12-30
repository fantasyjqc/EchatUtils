package application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("application.controller.Dto.Mapper")
public class main extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(main.class,args);
    }
}

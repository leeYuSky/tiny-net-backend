package edu.tju.scs.tinynetbackend;

import edu.tju.scs.tinynetbackend.po.User;
import edu.tju.scs.tinynetbackend.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
@MapperScan("edu.tju.scs.tinynetbackend.mapper")
public class TinyNetBackendApplication {

    public static void main(String[] args) {

        SpringApplication.run(TinyNetBackendApplication.class, args);
        //UserMapper userMapper=null
        //User user=new User();
        //user.setUsername("test");
        //user.setPassword("testpassword");

        //userMapper.insert(user);
        //AuthController authController = new AuthController();
        //authController.doReg("test","testpassword");
    }

    @Bean
    public CommandLineRunner demo(UserMapper userMapper)
    {
        return (args) -> {
            User user=new User();
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            user.setUsername("test");
            user.setPassword(passwordEncoder.encode("testpassword"));

            userMapper.updateByPrimaryKey(user);
        };
    }
}

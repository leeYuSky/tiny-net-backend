package edu.tju.scs.tinynetbackend;

import edu.tju.scs.tinynetbackend.common.FileHelper;
import edu.tju.scs.tinynetbackend.common.RecordList;
import edu.tju.scs.tinynetbackend.mapper.RecordMapper;
import edu.tju.scs.tinynetbackend.model.po.Record;
import edu.tju.scs.tinynetbackend.model.po.RecordWithBLOBs;
import edu.tju.scs.tinynetbackend.model.po.User;
import edu.tju.scs.tinynetbackend.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;


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
    public CommandLineRunner demo(UserMapper userMapper, RecordMapper recordMapper)
    {
        return (args) -> {
            User user = new User();
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            user.setUsername("test");
            user.setPassword(passwordEncoder.encode("testpassword"));

            userMapper.updateByPrimaryKey(user);
            String output=FileHelper.getOurput("test","test7");
            File newfile = new File("output.json");

            FileOutputStream out = new FileOutputStream(newfile);

            out.write(output.getBytes());
            out.close();
            /*
            String path = "D:/PowerNet20180830nocode/PowerNet20180522nocode/bin/IO/IN0";
            String ret = "";
            try {

                File file = new File(path);
                String[] filePath = file.list();
                for (int i = 0; i < filePath.length; i++) {
                    System.out.println(i);
                    File tempfile = new File(path + "/" + filePath[i]);
                    FileInputStream in = new FileInputStream(tempfile);
                    ret = ret + filePath[i] + ";";
                    Scanner scanner = new Scanner(in);
                    while (scanner.hasNext()) {
                        ret = ret + scanner.nextLine() + '\n';
                    }

                    in.close();
                    if (i != filePath.length - 1)
                        ret = ret + '|';

                }


            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(ret);

            String path1 = "D:/1.json";
            ret="";
            try {
                File tempfile = new File(path1);
                FileInputStream in = new FileInputStream(tempfile);
                Scanner scanner = new Scanner(in);
                while (scanner.hasNext()) {
                    ret = ret + scanner.nextLine() + '\n';
                }
                in.close();


            } catch (Exception e)
            {
                System.out.println(e);
            }

            System.out.println(ret);



            RecordWithBLOBs record = new RecordWithBLOBs();
            record.setName("test7");
            record.setOwner("test");
            record.setInput(FileHelper.getInput(ret));
            record.setState(0);
            //recordMapper.insert(record);
            recordMapper.updateByPrimaryKeyWithBLOBs(record);

            if(RecordList.check(record))
            {
                if(RecordList.checkNum())
                {
                    RecordList.add(record);
                    record.setState(1);
                    recordMapper.updateByPrimaryKey(record);
                }
            }
            */




        };
    }
}

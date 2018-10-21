package edu.tju.scs.tinynetbackend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: liyuze
 * @Description:
 * @Date: Created in 22:01 18/10/21.
 */

@RestController
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(path="/hello",method = RequestMethod.GET)
    public String hello(){
        log.info("!!!!!!!!!!!!! {}" , "lee");
        return "hello world";
    }
}

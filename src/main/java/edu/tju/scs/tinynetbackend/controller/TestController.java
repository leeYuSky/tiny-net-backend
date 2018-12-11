package edu.tju.scs.tinynetbackend.controller;


import edu.tju.scs.tinynetbackend.common.Annotaion.JWTAuth;
import edu.tju.scs.tinynetbackend.service.JWTService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: liyuze
 * @Description:
 * @Date: Created in 22:01 18/10/21.
 */

@RestController
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @JWTAuth(value = JWTService.USER_ROLE)
    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String hello() {
        log.info("!!!!!!!!!!!!! {}", "lee");
        return "hello world";
    }

    @JWTAuth(value = JWTService.ADMIN_ROLE)
    @RequestMapping(path = "/hello1", method = RequestMethod.GET)
    public String hello1() {
        log.info("!!!!!!!!!!!!! {}", "lee");
        return "hello world11111";
    }
}


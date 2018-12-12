package edu.tju.scs.tinynetbackend.controller;

import edu.tju.scs.tinynetbackend.model.dto.ErrorReport;
import edu.tju.scs.tinynetbackend.service.JWTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: liyuze
 * @Description:
 * @Date: Created in 21:35 18/12/10.
 */

@Slf4j
@RestController
public class JWTController {

    @Autowired
    JWTService jwtService;


    @RequestMapping(value = "/jwt/login", method = RequestMethod.POST)
    public ErrorReport tokenLogin(String username, String password){
        ErrorReport result = jwtService.login(username,password);

        return result;
    }

    @RequestMapping(value = "/jwt/logout", method = RequestMethod.POST)
    public ErrorReport tokenLogout(HttpServletRequest request){
        ErrorReport result = jwtService.logout(request);
        return result;
    }

    @RequestMapping(value = "/log")
    public void log(){
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
    }
}

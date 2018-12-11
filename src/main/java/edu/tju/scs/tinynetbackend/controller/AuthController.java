package edu.tju.scs.tinynetbackend.controller;

import edu.tju.scs.tinynetbackend.po.User;
import edu.tju.scs.tinynetbackend.dto.ErrorReport;
import edu.tju.scs.tinynetbackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {
    @Autowired
    protected LoginService loginService;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ErrorReport index(String username, String password){

        String msg;
        if(loginService.isLogin()) {
            msg = "hello " + ((User)loginService.getHttpSession().getAttribute("user")).getUsername();
        } else {
            msg = "not log in";
        }

        return new ErrorReport(100, "index page: " + msg);
    }

    @RequestMapping(value = "/tinyNet/auth/login",method = RequestMethod.POST)
    public ErrorReport doLogin(String username, String password){
        return loginService.login(username, password);
    }

    @RequestMapping(value = "/tinyNet/auth/register",method = RequestMethod.POST)
    public ErrorReport doReg(String username, String password){
        return loginService.reg(username, password);
    }

    @RequestMapping(value = "/tinyNet/auth/modify",method = RequestMethod.POST)
    public ErrorReport Update(String username, String oldpassword, String newpassword){
        return loginService.update(username, oldpassword, newpassword);
    }

    @RequestMapping(value = "/tinyNet/auth/logout",method = RequestMethod.POST)
    public ErrorReport doLogout(String username){
        return loginService.logout();
    }

    @RequestMapping(value = "/tinyNet/auth/adminmodify",method = RequestMethod.POST)
    public ErrorReport adminmodify(String username,String password){
        return loginService.adminmodify(username,password);
    }
}

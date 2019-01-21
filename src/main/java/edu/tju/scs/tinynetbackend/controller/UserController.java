package edu.tju.scs.tinynetbackend.controller;

import edu.tju.scs.tinynetbackend.model.dto.ErrorReport;
import edu.tju.scs.tinynetbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    protected UserService userService;

    @RequestMapping(value = "/user/reg", method = RequestMethod.POST)
    public ErrorReport reg(String username, String password){
        ErrorReport result = userService.reg(username,password);

        return result;
    }

    @RequestMapping(value = "/user/modify", method = RequestMethod.POST)
    public ErrorReport modify(HttpServletRequest request,String username, String oldpassword,String newpassword){
        ErrorReport result = userService.update(request,username,oldpassword,newpassword);

        return result;
    }

    @RequestMapping(value = "/user/admin", method = RequestMethod.POST)
    public ErrorReport adminmodify(HttpServletRequest request,String username,String newpassword){
        ErrorReport result = userService.adminmodify(request,username,newpassword);

        return result;
    }
}

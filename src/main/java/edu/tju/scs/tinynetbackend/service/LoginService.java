package edu.tju.scs.tinynetbackend.service;

import edu.tju.scs.tinynetbackend.common.FileHelper;
import edu.tju.scs.tinynetbackend.model.po.User;
import edu.tju.scs.tinynetbackend.model.dto.ErrorReport;
import edu.tju.scs.tinynetbackend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginService  {

    @Autowired
    protected UserMapper userMapper;

    @Autowired
    protected HttpSession httpSession;

    public ErrorReport login(String username, String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(userMapper.exist(username)>0)
        {
            User user = userMapper.selectByPrimaryKey(username);
            if(passwordEncoder.matches(password, user.getPassword()))
            {
                if(isLogin())
                    logout();
                httpSession.setAttribute("user", user);
                return new ErrorReport(0, "success");
            }
        }
        return new ErrorReport(1, "no such username or password error");

    }

    public ErrorReport reg(String username, String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        password = passwordEncoder.encode(password);
        if ( userMapper.exist(username) ==0) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userMapper.insert(user);
            FileHelper.createUser(username);
            return new ErrorReport(0, "success");
        } else {
            return new ErrorReport(3, "duplication error");
        }
    }

    public ErrorReport update(String username, String olepassword, String newpassword){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        olepassword = passwordEncoder.encode(olepassword);
        if ( userMapper.exist(username) >0 && checkUser(username)) {

            User user = userMapper.selectByPrimaryKey(username);
            if(passwordEncoder.matches(olepassword, user.getPassword()))
            {
                newpassword = passwordEncoder.encode(newpassword);
                user.setPassword(newpassword);
                userMapper.updateByPrimaryKey(user);
                return new ErrorReport(0, "success");
            }
            else {
                return new ErrorReport(2, "password error");
            }

        }
        else {
            return new ErrorReport(5, "no such user");
        }
    }

    public boolean isLogin(){
        if (httpSession.getAttribute("user")!=null){
            return true;
        }else {
            return false;
        }
    }

    public String loginUser(){
        return (String)httpSession.getAttribute("user");
    }

    public boolean checkUser(String username)
    {
        if(isLogin()==false)
            return false;
        String name = loginUser();
        if(username.equals(name))
            return  true;
        else
            return false;
    }

    public boolean checkAdmin()
    {
        if(isLogin()==false)
            return false;
        String name = loginUser();
        User user = userMapper.selectByPrimaryKey(name);
        if(user.getType()==1)
            return  true;
        else
            return false;
    }

    public ErrorReport logout() {
        if (httpSession.getAttribute("user") == null){
            return  new ErrorReport(4, "not login");
        }
        httpSession.setAttribute("user", null);
        return new ErrorReport(0, "success");
    }

    public ErrorReport adminmodify(String username, String passowrd)
    {
        if(checkAdmin())
        {
            if(userMapper.exist(username) >0)
            {
                User user = new User();
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                passowrd = passwordEncoder.encode(passowrd);
                user.setPassword(passowrd);
                user.setUsername(username);
                return new ErrorReport(0, "success");
            }
            else
                return new ErrorReport(5, "no such user");


        }
        else
            return new ErrorReport(6, "not admin");
    }

    public HttpSession getHttpSession() {
        return httpSession;
    }

    public void setHttpSession(HttpSession httpSession) {
        this.httpSession = httpSession;
    }
}

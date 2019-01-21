package edu.tju.scs.tinynetbackend.controller;


import edu.tju.scs.tinynetbackend.common.Annotaion.JWTAuth;
import edu.tju.scs.tinynetbackend.model.po.Wind_Turbines;
import edu.tju.scs.tinynetbackend.model.dto.ErrorReport;
import edu.tju.scs.tinynetbackend.model.dto.ResponseObjectData;
import edu.tju.scs.tinynetbackend.mapper.Wind_TurbinesMapper;
import edu.tju.scs.tinynetbackend.service.JWTService;
import edu.tju.scs.tinynetbackend.service.LoginService;
import edu.tju.scs.tinynetbackend.service.Wind_TurbinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class Wind_TurbinesController {

    @Autowired
    protected Wind_TurbinesService wind_turbinesService;

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/wind_turbines/add",method = RequestMethod.POST)
    public ErrorReport add(@RequestBody Wind_Turbines wind_turbines,HttpServletRequest request)
    {
        ErrorReport result = wind_turbinesService.add(request,wind_turbines);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/wind_turbines/update",method = RequestMethod.POST)
    public ErrorReport update(@RequestBody Wind_Turbines wind_turbines,HttpServletRequest request)
    {
        ErrorReport result = wind_turbinesService.update(request,wind_turbines);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/wind_turbines/select",method = RequestMethod.POST)
    public ErrorReport select(int id,HttpServletRequest request)
    {
        ErrorReport result = wind_turbinesService.select(request,id);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/wind_turbines/delete",method = RequestMethod.POST)
    public ErrorReport delete(int id,HttpServletRequest request)
    {
        ErrorReport result = wind_turbinesService.delete(request,id);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/wind_turbines/list",method = RequestMethod.POST)
    public ErrorReport list(HttpServletRequest request){


        ErrorReport result =  wind_turbinesService.list(request);

        return result;

    }
}

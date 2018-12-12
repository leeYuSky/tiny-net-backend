package edu.tju.scs.tinynetbackend.controller;


import edu.tju.scs.tinynetbackend.common.Annotaion.JWTAuth;
import edu.tju.scs.tinynetbackend.common.utils.TokenUtil;
import edu.tju.scs.tinynetbackend.model.po.Battery;
import edu.tju.scs.tinynetbackend.model.dto.ErrorReport;
import edu.tju.scs.tinynetbackend.model.dto.ResponseObjectData;
import edu.tju.scs.tinynetbackend.mapper.BatteryMapper;
import edu.tju.scs.tinynetbackend.service.BatteryService;
import edu.tju.scs.tinynetbackend.service.JWTService;
import edu.tju.scs.tinynetbackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BatteryController {

    @Autowired
    protected BatteryService batteryService;


    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/battery/add",method = RequestMethod.POST)
    public ErrorReport add(@RequestBody Battery battery,HttpServletRequest request)
    {
        ErrorReport result = batteryService.add(request,battery);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/battery/update",method = RequestMethod.POST)
    public ErrorReport update(@RequestBody Battery battery,HttpServletRequest request)
    {
        ErrorReport result = batteryService.update(request,battery);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/battery/select",method = RequestMethod.POST)
    public ErrorReport select(int id,HttpServletRequest request)
    {
        ErrorReport result = batteryService.select(request,id);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/battery/delete",method = RequestMethod.POST)
    public ErrorReport delete(int id,HttpServletRequest request)
    {
        ErrorReport result = batteryService.delete(request,id);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/battery/list",method = RequestMethod.POST)
    public ErrorReport list(HttpServletRequest request){


        ErrorReport result =  batteryService.list(request);

        return result;

    }


}

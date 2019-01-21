package edu.tju.scs.tinynetbackend.controller;


import edu.tju.scs.tinynetbackend.common.Annotaion.JWTAuth;
import edu.tju.scs.tinynetbackend.model.po.Photovoltaic;
import edu.tju.scs.tinynetbackend.model.dto.ErrorReport;
import edu.tju.scs.tinynetbackend.model.dto.ResponseObjectData;
import edu.tju.scs.tinynetbackend.mapper.PhotovoltaicMapper;
import edu.tju.scs.tinynetbackend.service.GeneratorService;
import edu.tju.scs.tinynetbackend.service.JWTService;
import edu.tju.scs.tinynetbackend.service.LoginService;
import edu.tju.scs.tinynetbackend.service.PhotovoltaicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PhotovoltaicController {

    @Autowired
    protected PhotovoltaicService photovoltaicService;

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/photovoltaic/add",method = RequestMethod.POST)
    public ErrorReport add(@RequestBody Photovoltaic photovoltaic,HttpServletRequest request)
    {
        ErrorReport result = photovoltaicService.add(request,photovoltaic);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/photovoltaic/update",method = RequestMethod.POST)
    public ErrorReport update(@RequestBody Photovoltaic photovoltaic,HttpServletRequest request)
    {
        ErrorReport result = photovoltaicService.update(request,photovoltaic);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/photovoltaic/select",method = RequestMethod.POST)
    public ErrorReport select(int id,HttpServletRequest request)
    {
        ErrorReport result = photovoltaicService.select(request,id);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/photovoltaic/delete",method = RequestMethod.POST)
    public ErrorReport delete(int id,HttpServletRequest request)
    {
        ErrorReport result = photovoltaicService.delete(request,id);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/photovoltaic/list",method = RequestMethod.POST)
    public ErrorReport list(HttpServletRequest request){


        ErrorReport result =  photovoltaicService.list(request);

        return result;

    }
}

package edu.tju.scs.tinynetbackend.controller;


import edu.tju.scs.tinynetbackend.common.Annotaion.JWTAuth;
import edu.tju.scs.tinynetbackend.common.RecordList;
import edu.tju.scs.tinynetbackend.model.po.RecordWithBLOBs;
import edu.tju.scs.tinynetbackend.model.dto.ErrorReport;
import edu.tju.scs.tinynetbackend.model.dto.ResponseObjectData;
import edu.tju.scs.tinynetbackend.mapper.RecordMapper;
import edu.tju.scs.tinynetbackend.service.JWTService;
import edu.tju.scs.tinynetbackend.service.LoginService;
import edu.tju.scs.tinynetbackend.service.RecordService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Mapper
public class RecordController {

    @Autowired
    protected RecordService recordService;

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/record/add",method = RequestMethod.POST)
    public ErrorReport add(String recordname,String input,HttpServletRequest request)
    {
        return recordService.add(request,recordname,input);
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/record/update",method = RequestMethod.POST)
    public ErrorReport update(String recordname,String input,HttpServletRequest request)
    {
        return recordService.update(request,recordname,input);
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/record/delete",method = RequestMethod.POST)
    public ErrorReport delete(String recordname,HttpServletRequest request)
    {
        return recordService.delete(request,recordname);
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/record/select",method = RequestMethod.POST)
    public ErrorReport select(String recordname,HttpServletRequest request)
    {
        return recordService.select(request,recordname);
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/record/list",method = RequestMethod.POST)
    public ErrorReport list(HttpServletRequest request)
    {
        return recordService.list(request);
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/record/action",method = RequestMethod.POST)
    public ErrorReport action(String recordname,HttpServletRequest request)
    {
        return recordService.action(request,recordname);

    }



}

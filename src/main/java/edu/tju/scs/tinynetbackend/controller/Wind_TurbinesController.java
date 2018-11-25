package edu.tju.scs.tinynetbackend.controller;


import edu.tju.scs.tinynetbackend.domain.Wind_Turbines;
import edu.tju.scs.tinynetbackend.dto.ErrorReport;
import edu.tju.scs.tinynetbackend.dto.ResponseObjectData;
import edu.tju.scs.tinynetbackend.mapper.Wind_TurbinesMapper;
import edu.tju.scs.tinynetbackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class Wind_TurbinesController {

    @Autowired
    protected LoginService loginService;

    @Autowired
    protected Wind_TurbinesMapper wind_turbinesMapper;

    @RequestMapping(value = "/tinyNet/device/wind_turbines/add",method = RequestMethod.POST)
    public ErrorReport add(@RequestBody Wind_Turbines wind_turbines)
    {
        wind_turbinesMapper.insert(wind_turbines);
        return new ErrorReport(0,"success");
    }

    @RequestMapping(value = "/tinyNet/device/wind_turbines/update",method = RequestMethod.POST)
    public ErrorReport update(@RequestBody Wind_Turbines wind_turbines)
    {
        wind_turbinesMapper.updateByPrimaryKey(wind_turbines);
        return new ErrorReport(0,"success");
    }

    @RequestMapping(value = "/tinyNet/device/wind_turbines/select",method = RequestMethod.POST)
    public ErrorReport select(int id)
    {
        Wind_Turbines wind_turbines =wind_turbinesMapper.selectByPrimaryKey(id);
        if(wind_turbines!=null)
            return new ErrorReport(0,"success",new ResponseObjectData(wind_turbines));
        else
            return new ErrorReport(11,"id not found");
    }

    @RequestMapping(value = "/tinyNet/device/wind_turbines/delete",method = RequestMethod.POST)
    public ErrorReport delete(int id)
    {
        wind_turbinesMapper.deleteByPrimaryKey(id);
        return new ErrorReport(0,"success");
    }

    @RequestMapping(value = "/tinyNet/device/wind_turbines/list",method = RequestMethod.POST)
    public ErrorReport list(String username)
    {
        List<Wind_Turbines> wind_turbineslist =wind_turbinesMapper.selectByOwner(username);

        return new ErrorReport(0,"success",new ResponseObjectData(wind_turbineslist));

    }
}

package edu.tju.scs.tinynetbackend.controller;


import edu.tju.scs.tinynetbackend.model.po.Turbine;
import edu.tju.scs.tinynetbackend.model.dto.ErrorReport;
import edu.tju.scs.tinynetbackend.model.dto.ResponseObjectData;
import edu.tju.scs.tinynetbackend.mapper.TurbineMapper;
import edu.tju.scs.tinynetbackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TurbineContorller {

    @Autowired
    protected LoginService loginService;

    @Autowired
    protected TurbineMapper turbineMapper;

    @RequestMapping(value = "/tinyNet/device/turbine/add",method = RequestMethod.POST)
    public ErrorReport add(@RequestBody Turbine turbine)
    {
        turbineMapper.insert(turbine);
        return new ErrorReport(0,"success");
    }

    @RequestMapping(value = "/tinyNet/device/turbine/update",method = RequestMethod.POST)
    public ErrorReport update(@RequestBody Turbine turbine)
    {
        turbineMapper.updateByPrimaryKey(turbine);
        return new ErrorReport(0,"success");
    }

    @RequestMapping(value = "/tinyNet/device/turbine/select",method = RequestMethod.POST)
    public ErrorReport select(int id)
    {
        Turbine turbine=turbineMapper.selectByPrimaryKey(id);
        if(turbine!=null)
            return new ErrorReport(0,"success",new ResponseObjectData(turbine));
        else
            return new ErrorReport(11,"id not found");
    }

    @RequestMapping(value = "/tinyNet/device/turbine/delete",method = RequestMethod.POST)
    public ErrorReport delete(int id)
    {
        turbineMapper.deleteByPrimaryKey(id);
        return new ErrorReport(0,"success");
    }

    @RequestMapping(value = "/tinyNet/device/turbine/list",method = RequestMethod.POST)
    public ErrorReport list(String username)
    {
        List<Turbine> turbinelist =turbineMapper.selectByOwner(username);

        return new ErrorReport(0,"success",new ResponseObjectData(turbinelist));

    }

}

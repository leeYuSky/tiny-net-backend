package edu.tju.scs.tinynetbackend.controller;


import edu.tju.scs.tinynetbackend.model.po.Battery;
import edu.tju.scs.tinynetbackend.model.dto.ErrorReport;
import edu.tju.scs.tinynetbackend.model.dto.ResponseObjectData;
import edu.tju.scs.tinynetbackend.mapper.BatteryMapper;
import edu.tju.scs.tinynetbackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BatteryController {
    @Autowired
    protected LoginService loginService;

    @Autowired
    protected BatteryMapper batteryMapper;

    @RequestMapping(value = "/tinyNet/device/battery/add",method = RequestMethod.POST)
    public ErrorReport add(@RequestBody Battery battery)
    {
        batteryMapper.insert(battery);
        return new ErrorReport(0,"success");
    }

    @RequestMapping(value = "/tinyNet/device/battery/update",method = RequestMethod.POST)
    public ErrorReport update(@RequestBody Battery battery)
    {
        batteryMapper.updateByPrimaryKey(battery);
        return new ErrorReport(0,"success");
    }

    @RequestMapping(value = "/tinyNet/device/battery/select",method = RequestMethod.POST)
    public ErrorReport select(int id)
    {
        Battery battery =batteryMapper.selectByPrimaryKey(id);
        if(battery!=null)
            return new ErrorReport(0,"success",new ResponseObjectData(battery));
        else
            return new ErrorReport(11,"id not found");
    }

    @RequestMapping(value = "/tinyNet/device/battery/delete",method = RequestMethod.POST)
    public ErrorReport delete(int id)
    {
        batteryMapper.deleteByPrimaryKey(id);
        return new ErrorReport(0,"success");
    }

    @RequestMapping(value = "/tinyNet/device/battery/list",method = RequestMethod.POST)
    public ErrorReport list(String username)
    {
        List<Battery> batterylist =batteryMapper.selectByOwner(username);

        return new ErrorReport(0,"success",new ResponseObjectData(batterylist));

    }


}

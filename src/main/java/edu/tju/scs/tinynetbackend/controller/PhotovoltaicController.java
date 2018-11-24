package edu.tju.scs.tinynetbackend.controller;


import edu.tju.scs.tinynetbackend.domain.Photovoltaic;
import edu.tju.scs.tinynetbackend.dto.ErrorReport;
import edu.tju.scs.tinynetbackend.dto.ResponseObjectData;
import edu.tju.scs.tinynetbackend.mapper.PhotovoltaicMapper;
import edu.tju.scs.tinynetbackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PhotovoltaicController {

    @Autowired
    protected LoginService loginService;

    @Autowired
    protected PhotovoltaicMapper PhotovoltaicMapper;

    @RequestMapping(value = "/tinyNet/device/photovoltaic/add",method = RequestMethod.POST)
    public ErrorReport add(@RequestBody Photovoltaic photovoltaic)
    {
        PhotovoltaicMapper.insert(photovoltaic);
        return new ErrorReport(0,"success");
    }

    @RequestMapping(value = "/tinyNet/device/photovoltaic/update",method = RequestMethod.POST)
    public ErrorReport update(@RequestBody Photovoltaic photovoltaic)
    {
        PhotovoltaicMapper.updateByPrimaryKey(photovoltaic);
        return new ErrorReport(0,"success");
    }

    @RequestMapping(value = "/tinyNet/device/photovoltaic/select",method = RequestMethod.POST)
    public ErrorReport select(int id)
    {
        Photovoltaic photovoltaiclist =PhotovoltaicMapper.selectByPrimaryKey(id);
        if(photovoltaiclist!=null)
            return new ErrorReport(0,"success",new ResponseObjectData(photovoltaiclist));
        else
            return new ErrorReport(11,"id not found");
    }

    @RequestMapping(value = "/tinyNet/device/photovoltaic/delete",method = RequestMethod.POST)
    public ErrorReport delete(int id)
    {
        PhotovoltaicMapper.deleteByPrimaryKey(id);
        return new ErrorReport(0,"success");
    }

    @RequestMapping(value = "/tinyNet/device/photovoltaic/list",method = RequestMethod.POST)
    public ErrorReport list(String username)
    {
        List<Photovoltaic> photovoltaiclist =PhotovoltaicMapper.selectByOwner(username);

        return new ErrorReport(0,"success",new ResponseObjectData(photovoltaiclist));

    }
}

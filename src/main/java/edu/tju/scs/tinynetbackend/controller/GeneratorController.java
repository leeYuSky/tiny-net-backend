package edu.tju.scs.tinynetbackend.controller;


import edu.tju.scs.tinynetbackend.po.Generator;
import edu.tju.scs.tinynetbackend.dto.ErrorReport;
import edu.tju.scs.tinynetbackend.dto.ResponseObjectData;
import edu.tju.scs.tinynetbackend.mapper.GeneratorMapper;
import edu.tju.scs.tinynetbackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class GeneratorController {

    @Autowired
    protected LoginService loginService;

    @Autowired
    protected GeneratorMapper generatorMapper;

    @RequestMapping(value = "/tinyNet/device/generator/add",method = RequestMethod.POST)
    public ErrorReport add(@RequestBody Generator generator)
    {
        generatorMapper.insert(generator);
        return new ErrorReport(0,"success");
    }

    @RequestMapping(value = "/tinyNet/device/generator/update",method = RequestMethod.POST)
    public ErrorReport update(@RequestBody Generator generator)
    {
        generatorMapper.updateByPrimaryKey(generator);
        return new ErrorReport(0,"success");
    }

    @RequestMapping(value = "/tinyNet/device/generator/select",method = RequestMethod.POST)
    public ErrorReport select(int id)
    {
        Generator generator =generatorMapper.selectByPrimaryKey(id);
        if(generator!=null)
            return new ErrorReport(0,"success",new ResponseObjectData(generator));
        else
            return new ErrorReport(11,"id not found");
    }

    @RequestMapping(value = "/tinyNet/device/generator/delete",method = RequestMethod.POST)
    public ErrorReport delete(int id)
    {
        generatorMapper.deleteByPrimaryKey(id);
        return new ErrorReport(0,"success");
    }

    @RequestMapping(value = "/tinyNet/device/generator/list",method = RequestMethod.POST)
    public ErrorReport list(String username)
    {
        List<Generator> generatorlist =generatorMapper.selectByOwner(username);

        return new ErrorReport(0,"success",new ResponseObjectData(generatorlist));

    }

}

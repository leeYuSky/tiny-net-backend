package edu.tju.scs.tinynetbackend.controller;


import edu.tju.scs.tinynetbackend.common.RecordList;
import edu.tju.scs.tinynetbackend.po.RecordWithBLOBs;
import edu.tju.scs.tinynetbackend.dto.ErrorReport;
import edu.tju.scs.tinynetbackend.dto.ResponseObjectData;
import edu.tju.scs.tinynetbackend.mapper.RecordMapper;
import edu.tju.scs.tinynetbackend.service.LoginService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Mapper
public class RecordController {

    @Autowired
    protected LoginService loginService;

    @Autowired
    protected static RecordMapper recordMapper;

    @RequestMapping(value = "/tinyNet/record/add",method = RequestMethod.POST)
    public ErrorReport add(String recordname,String input)
    {
        if(!loginService.isLogin())
            return  new ErrorReport(4, "not login");
        RecordWithBLOBs record = new RecordWithBLOBs();
        record.setName(recordname);
        record.setState(0);
        record.setInput(input);
        record.setOwner(loginService.loginUser());
        record.setOutput(null);
        recordMapper.insert(record);
        return new ErrorReport(0,"success");
    }

    @RequestMapping(value = "/tinyNet/record/update",method = RequestMethod.POST)
    public ErrorReport update(String recordname,String input)
    {
        if(!loginService.isLogin())
            return  new ErrorReport(4, "not login");
        RecordWithBLOBs record = new RecordWithBLOBs();
        record.setName(recordname);
        record.setState(0);
        record.setInput(input);
        record.setOwner(loginService.loginUser());
        record.setOutput(null);
        recordMapper.updateByPrimaryKey(record);
        return new ErrorReport(0,"success");
    }

    @RequestMapping(value = "/tinyNet/record/delete",method = RequestMethod.POST)
    public ErrorReport delete(String recordname)
    {
        recordMapper.deleteByPrimaryKey(recordname);
        return new ErrorReport(0,"success");
    }

    @RequestMapping(value = "/tinyNet/record/select",method = RequestMethod.POST)
    public ErrorReport select(String recordname)
    {
        RecordWithBLOBs record=recordMapper.selectByPrimaryKey(recordname);
        return new ErrorReport(0,"success",new ResponseObjectData(record));
    }

    @RequestMapping(value = "/tinyNet/record/list",method = RequestMethod.POST)
    public ErrorReport list(String owner)
    {
        List<RecordWithBLOBs> recordlist=recordMapper.selectByOwner(owner);
        return new ErrorReport(0,"success",new ResponseObjectData(recordlist));
    }

    @RequestMapping(value = "/tinyNet/record/action",method = RequestMethod.POST)
    public ErrorReport action(String recordname)
    {
        RecordWithBLOBs record=recordMapper.selectByPrimaryKey(recordname);
        if(RecordList.check(record))
        {
            if(RecordList.checkNum())
            {
                RecordList.add(record);
                record.setState(1);
                recordMapper.updateByPrimaryKey(record);
                return new ErrorReport(0,"success");
            }

            else
                return new ErrorReport(22,"Quantitative restriction");
        }
        else
            return new ErrorReport(21,"another record for this user already running");

    }

    public static void addOutput(String recordname,String output)
    {
        RecordWithBLOBs record=recordMapper.selectByPrimaryKey(recordname);
        record.setState(2);
        record.setOutput(output);
        recordMapper.updateByPrimaryKey(record);

    }


}

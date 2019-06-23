package edu.tju.scs.tinynetbackend.service;


import edu.tju.scs.tinynetbackend.common.FileHelper;
import edu.tju.scs.tinynetbackend.common.RecordList;
import edu.tju.scs.tinynetbackend.common.utils.TokenUtil;
import edu.tju.scs.tinynetbackend.mapper.RecordMapper;
import edu.tju.scs.tinynetbackend.model.dto.ErrorReport;
import edu.tju.scs.tinynetbackend.model.dto.ResponseObjectData;
import edu.tju.scs.tinynetbackend.model.po.Record;
import edu.tju.scs.tinynetbackend.model.po.RecordWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Service
public class RecordService {

    @Autowired
    private static RecordMapper recordMapper;

    private boolean check(String name,String owner)
    {
        Record record = recordMapper.selectByPrimaryKey(name);
        if(record==null||!owner.equals(record.getOwner()))
            return false;
        return true;
    }

    public ErrorReport add(HttpServletRequest request, String recordname, String input)
    {
        input = FileHelper.getInput(input);
        RecordWithBLOBs record = new RecordWithBLOBs();
        record.setName(recordname);
        record.setState(0);
        record.setInput(input);
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        record.setOwner(username);
        record.setOutput(null);
        recordMapper.insert(record);
        return new ErrorReport(0,"success");
    }

    public ErrorReport update(HttpServletRequest request,String recordname,String input)
    {

        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        RecordWithBLOBs record = new RecordWithBLOBs();
        record.setName(recordname);
        record.setState(0);
        record.setInput(input);
        record.setOutput(null);
        if(!username.equals(record.getOwner()))
            return new ErrorReport(31,"id no exist");
        if(!check(record.getName(),record.getOwner()))
            return new ErrorReport(31,"id no exist");
        recordMapper.updateByPrimaryKey(record);
        return new ErrorReport(0,"success");
    }

    public ErrorReport delete(HttpServletRequest request,String recordname)
    {

        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        if(!check(recordname,username))
            return new ErrorReport(31,"id no exist");
        recordMapper.deleteByPrimaryKey(recordname);
        return new ErrorReport(0,"success");
    }


    public ErrorReport select(HttpServletRequest request,String recordname)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        if(!check(recordname,username))
            return new ErrorReport(31,"id no exist");
        RecordList.update();
        RecordWithBLOBs record=recordMapper.selectByPrimaryKey(recordname);
        if(record!=null)
            return new ErrorReport(0,"success",new ResponseObjectData(record));
        else
            return new ErrorReport(11,"id not found");

    }

    public ErrorReport list(HttpServletRequest request)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);

        List<RecordWithBLOBs> recordlist=recordMapper.selectByOwner(username);
        return new ErrorReport(0,"success",new ResponseObjectData(recordlist));
    }

    public ErrorReport action(HttpServletRequest request,String recordname)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        RecordWithBLOBs record=recordMapper.selectByPrimaryKey(recordname);
        if(!username.equals(record.getOwner()))
            return  new ErrorReport(31,"id no exist");
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

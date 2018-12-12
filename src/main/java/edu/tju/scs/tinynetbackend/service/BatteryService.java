package edu.tju.scs.tinynetbackend.service;

import edu.tju.scs.tinynetbackend.common.utils.TokenUtil;
import edu.tju.scs.tinynetbackend.mapper.BatteryMapper;
import edu.tju.scs.tinynetbackend.model.dto.ErrorReport;
import edu.tju.scs.tinynetbackend.model.dto.ResponseData;
import edu.tju.scs.tinynetbackend.model.dto.ResponseObjectData;
import edu.tju.scs.tinynetbackend.model.po.Battery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: liyuze
 * @Description:
 * @Date: Created in 22:36 18/12/12.
 */
@Slf4j
@Service
public class BatteryService {

    @Autowired
    protected BatteryMapper batteryMapper;

    private boolean check(int id,String owner)
    {
        Battery battery = batteryMapper.selectByPrimaryKey(id);
        if(battery==null||!owner.equals(battery.getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(HttpServletRequest request,Battery battery)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        battery.setOwner(username);

        batteryMapper.insert(battery);

        return new ErrorReport(0,"success");
    }

    public ErrorReport update(HttpServletRequest request,Battery battery)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        if(!username.equals(battery.getOwner()))
            return new ErrorReport(31,"id no exist");
        if(!check(battery.getId(),battery.getOwner()))
            return new ErrorReport(31,"id no exist");
        batteryMapper.updateByPrimaryKey(battery);
        return new ErrorReport(0,"success");
    }

    public ErrorReport select(HttpServletRequest request,int id)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        if(!check(id,username))
            return new ErrorReport(31,"id no exist");
        Battery battery =batteryMapper.selectByPrimaryKey(id);
        if(battery!=null)
            return new ErrorReport(0,"success",new ResponseObjectData(battery));
        else
            return new ErrorReport(11,"id not found");
    }

    public ErrorReport delete(HttpServletRequest request,int id)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        if(!check(id,username))
            return new ErrorReport(31,"id no exist");
        batteryMapper.deleteByPrimaryKey(id);
        return new ErrorReport(0,"success");
    }

    public ErrorReport list(HttpServletRequest request)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);

        List<Battery> batterylist =batteryMapper.selectByOwner(username);

        return new ErrorReport(0,"success",new ResponseData().addData("batterylist",batterylist));

    }
}

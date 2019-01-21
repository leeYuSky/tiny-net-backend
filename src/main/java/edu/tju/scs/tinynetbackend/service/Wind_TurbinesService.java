package edu.tju.scs.tinynetbackend.service;


import edu.tju.scs.tinynetbackend.common.utils.TokenUtil;
import edu.tju.scs.tinynetbackend.mapper.Wind_TurbinesMapper;
import edu.tju.scs.tinynetbackend.model.dto.ErrorReport;
import edu.tju.scs.tinynetbackend.model.dto.ResponseData;
import edu.tju.scs.tinynetbackend.model.dto.ResponseObjectData;
import edu.tju.scs.tinynetbackend.model.po.Wind_Turbines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class Wind_TurbinesService {

    @Autowired
    protected Wind_TurbinesMapper wind_turbinesMapper;

    private boolean check(int id,String owner)
    {
        Wind_Turbines wind_turbines = wind_turbinesMapper.selectByPrimaryKey(id);
        if(wind_turbines==null||!owner.equals(wind_turbines.getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(HttpServletRequest request, Wind_Turbines wind_turbines)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        wind_turbines.setOwner(username);

        wind_turbinesMapper.insert(wind_turbines);

        return new ErrorReport(0,"success");
    }

    public ErrorReport update(HttpServletRequest request,Wind_Turbines wind_turbines)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        if(!username.equals(wind_turbines.getOwner()))
            return new ErrorReport(31,"id no exist");
        if(!check(wind_turbines.getId(),wind_turbines.getOwner()))
            return new ErrorReport(31,"id no exist");
        wind_turbinesMapper.updateByPrimaryKey(wind_turbines);
        return new ErrorReport(0,"success");
    }

    public ErrorReport select(HttpServletRequest request,int id)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        if(!check(id,username))
            return new ErrorReport(31,"id no exist");
        Wind_Turbines wind_turbines =wind_turbinesMapper.selectByPrimaryKey(id);
        if(wind_turbines!=null)
            return new ErrorReport(0,"success",new ResponseObjectData(wind_turbines));
        else
            return new ErrorReport(11,"id not found");
    }

    public ErrorReport delete(HttpServletRequest request,int id)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        if(!check(id,username))
            return new ErrorReport(31,"id no exist");
        wind_turbinesMapper.deleteByPrimaryKey(id);
        return new ErrorReport(0,"success");
    }

    public ErrorReport list(HttpServletRequest request)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);

        List<Wind_Turbines> wind_turbineslist =wind_turbinesMapper.selectByOwner(username);

        return new ErrorReport(0,"success",new ResponseData().addData("wind_turbineslist",wind_turbineslist));

    }
}

package edu.tju.scs.tinynetbackend.service;


import edu.tju.scs.tinynetbackend.common.utils.TokenUtil;
import edu.tju.scs.tinynetbackend.mapper.TurbineMapper;
import edu.tju.scs.tinynetbackend.model.dto.ErrorReport;
import edu.tju.scs.tinynetbackend.model.dto.ResponseData;
import edu.tju.scs.tinynetbackend.model.dto.ResponseObjectData;
import edu.tju.scs.tinynetbackend.model.po.Turbine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class TurbineService {

    @Autowired
    protected TurbineMapper turbineMapper;

    private boolean check(int id,String owner)
    {
        Turbine turbine = turbineMapper.selectByPrimaryKey(id);
        if(turbine==null||!owner.equals(turbine.getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(HttpServletRequest request,Turbine turbine)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        turbine.setOwner(username);

        turbineMapper.insert(turbine);

        return new ErrorReport(0,"success");
    }

    public ErrorReport update(HttpServletRequest request,Turbine turbine)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        if(!username.equals(turbine.getOwner()))
            return new ErrorReport(31,"id no exist");
        if(!check(turbine.getId(),turbine.getOwner()))
            return new ErrorReport(31,"id no exist");
        turbineMapper.updateByPrimaryKey(turbine);
        return new ErrorReport(0,"success");
    }

    public ErrorReport select(HttpServletRequest request,int id)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        if(!check(id,username))
            return new ErrorReport(31,"id no exist");
        Turbine turbine =turbineMapper.selectByPrimaryKey(id);
        if(turbine!=null)
            return new ErrorReport(0,"success",new ResponseObjectData(turbine));
        else
            return new ErrorReport(11,"id not found");
    }

    public ErrorReport delete(HttpServletRequest request,int id)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        if(!check(id,username))
            return new ErrorReport(31,"id no exist");
        turbineMapper.deleteByPrimaryKey(id);
        return new ErrorReport(0,"success");
    }

    public ErrorReport list(HttpServletRequest request)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);

        List<Turbine> turbinelist =turbineMapper.selectByOwner(username);

        return new ErrorReport(0,"success",new ResponseData().addData("turbinelist",turbinelist));

    }
}

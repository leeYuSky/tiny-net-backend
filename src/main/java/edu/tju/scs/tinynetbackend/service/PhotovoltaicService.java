package edu.tju.scs.tinynetbackend.service;

import edu.tju.scs.tinynetbackend.common.utils.TokenUtil;
import edu.tju.scs.tinynetbackend.mapper.PhotovoltaicMapper;
import edu.tju.scs.tinynetbackend.model.dto.ErrorReport;
import edu.tju.scs.tinynetbackend.model.dto.ResponseData;
import edu.tju.scs.tinynetbackend.model.dto.ResponseObjectData;
import edu.tju.scs.tinynetbackend.model.po.Photovoltaic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PhotovoltaicService {

    @Autowired
    protected PhotovoltaicMapper photovoltaicMapper;

    private boolean check(int id,String owner)
    {
        Photovoltaic photovoltaic = photovoltaicMapper.selectByPrimaryKey(id);
        if(photovoltaic==null||!owner.equals(photovoltaic.getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(HttpServletRequest request, Photovoltaic photovoltaic)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        photovoltaic.setOwner(username);

        photovoltaicMapper.insert(photovoltaic);

        return new ErrorReport(0,"success");
    }

    public ErrorReport update(HttpServletRequest request,Photovoltaic photovoltaic)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        if(!username.equals(photovoltaic.getOwner()))
            return new ErrorReport(31,"id no exist");
        if(!check(photovoltaic.getId(),photovoltaic.getOwner()))
            return new ErrorReport(31,"id no exist");
        photovoltaicMapper.updateByPrimaryKey(photovoltaic);
        return new ErrorReport(0,"success");
    }

    public ErrorReport select(HttpServletRequest request,int id)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        if(!check(id,username))
            return new ErrorReport(31,"id no exist");
        Photovoltaic photovoltaic =photovoltaicMapper.selectByPrimaryKey(id);
        if(photovoltaic!=null)
            return new ErrorReport(0,"success",new ResponseObjectData(photovoltaic));
        else
            return new ErrorReport(11,"id not found");
    }

    public ErrorReport delete(HttpServletRequest request,int id)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        if(!check(id,username))
            return new ErrorReport(31,"id no exist");
        photovoltaicMapper.deleteByPrimaryKey(id);
        return new ErrorReport(0,"success");
    }

    public ErrorReport list(HttpServletRequest request)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);

        List<Photovoltaic> photovoltaiclist =photovoltaicMapper.selectByOwner(username);

        return new ErrorReport(0,"success",new ResponseData().addData("photovoltaiclist",photovoltaiclist));

    }
}

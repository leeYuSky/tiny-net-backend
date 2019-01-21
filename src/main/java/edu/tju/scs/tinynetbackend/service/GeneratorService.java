package edu.tju.scs.tinynetbackend.service;


import edu.tju.scs.tinynetbackend.common.utils.TokenUtil;
import edu.tju.scs.tinynetbackend.mapper.GeneratorMapper;
import edu.tju.scs.tinynetbackend.model.dto.ErrorReport;
import edu.tju.scs.tinynetbackend.model.dto.ResponseData;
import edu.tju.scs.tinynetbackend.model.dto.ResponseObjectData;
import edu.tju.scs.tinynetbackend.model.po.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class GeneratorService {

    @Autowired
    protected GeneratorMapper generatorMapper;


    private boolean check(int id,String owner)
    {
        Generator generator = generatorMapper.selectByPrimaryKey(id);
        if(generator==null||!owner.equals(generator.getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(HttpServletRequest request, Generator generator)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        generator.setOwner(username);

        generatorMapper.insert(generator);

        return new ErrorReport(0,"success");
    }

    public ErrorReport update(HttpServletRequest request,Generator generator)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        if(!username.equals(generator.getOwner()))
            return new ErrorReport(31,"id no exist");
        if(!check(generator.getId(),generator.getOwner()))
            return new ErrorReport(31,"id no exist");
        generatorMapper.updateByPrimaryKey(generator);
        return new ErrorReport(0,"success");
    }

    public ErrorReport select(HttpServletRequest request,int id)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        if(!check(id,username))
            return new ErrorReport(31,"id no exist");
        Generator generator =generatorMapper.selectByPrimaryKey(id);
        if(generator!=null)
            return new ErrorReport(0,"success",new ResponseObjectData(generator));
        else
            return new ErrorReport(11,"id not found");
    }

    public ErrorReport delete(HttpServletRequest request,int id)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        if(!check(id,username))
            return new ErrorReport(31,"id no exist");
        generatorMapper.deleteByPrimaryKey(id);
        return new ErrorReport(0,"success");
    }

    public ErrorReport list(HttpServletRequest request)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);

        List<Generator> generatorlist =generatorMapper.selectByOwner(username);

        return new ErrorReport(0,"success",new ResponseData().addData("generatorlist",generatorlist));

    }

}

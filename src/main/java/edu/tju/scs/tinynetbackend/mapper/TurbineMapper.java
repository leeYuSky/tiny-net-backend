package edu.tju.scs.tinynetbackend.mapper;

import edu.tju.scs.tinynetbackend.model.po.Turbine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TurbineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Turbine record);

    int insertSelective(Turbine record);

    Turbine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Turbine record);

    int updateByPrimaryKey(Turbine record);

    List<Turbine> selectByOwner(String username);
}
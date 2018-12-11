package edu.tju.scs.tinynetbackend.mapper;

import edu.tju.scs.tinynetbackend.model.po.Wind_Turbines;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface Wind_TurbinesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Wind_Turbines record);

    int insertSelective(Wind_Turbines record);

    Wind_Turbines selectByPrimaryKey(Integer id);

    List<Wind_Turbines> selectByOwner(String username);

    int updateByPrimaryKeySelective(Wind_Turbines record);

    int updateByPrimaryKey(Wind_Turbines record);
}
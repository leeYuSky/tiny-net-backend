package edu.tju.scs.tinynetbackend.mapper;

import edu.tju.scs.tinynetbackend.domain.Battery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BatteryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Battery record);

    int insertSelective(Battery record);

    Battery selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Battery record);

    int updateByPrimaryKey(Battery record);

    List<Battery> selectByOwner(String username);
}
package edu.tju.scs.tinynetbackend.mapper;


import edu.tju.scs.tinynetbackend.model.po.Photovoltaic;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


@Mapper
public interface PhotovoltaicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Photovoltaic record);

    int insertSelective(Photovoltaic record);

    Photovoltaic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Photovoltaic record);

    int updateByPrimaryKey(Photovoltaic record);

    List<Photovoltaic> selectByOwner(String username);
}
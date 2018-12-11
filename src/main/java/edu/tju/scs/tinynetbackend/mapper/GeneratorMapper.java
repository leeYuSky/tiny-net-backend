package edu.tju.scs.tinynetbackend.mapper;

import edu.tju.scs.tinynetbackend.po.Generator;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface GeneratorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Generator record);

    int insertSelective(Generator record);

    Generator selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Generator record);

    int updateByPrimaryKey(Generator record);

    List<Generator> selectByOwner(String username);
}
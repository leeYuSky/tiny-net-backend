package edu.tju.scs.tinynetbackend.mapper;

import edu.tju.scs.tinynetbackend.po.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(String username);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String username);

    long exist(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


}
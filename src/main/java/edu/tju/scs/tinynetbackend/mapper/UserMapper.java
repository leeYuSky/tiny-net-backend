package edu.tju.scs.tinynetbackend.mapper;

import edu.tju.scs.tinynetbackend.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(String username);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
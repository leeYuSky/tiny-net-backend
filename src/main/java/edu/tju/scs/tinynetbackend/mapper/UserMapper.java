package edu.tju.scs.tinynetbackend.mapper;

import edu.tju.scs.tinynetbackend.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(String username);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String username);

    long exsit(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


}
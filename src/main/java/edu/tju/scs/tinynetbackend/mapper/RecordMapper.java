package edu.tju.scs.tinynetbackend.mapper;

import edu.tju.scs.tinynetbackend.po.Record;
import edu.tju.scs.tinynetbackend.po.RecordWithBLOBs;

import java.util.List;

public interface RecordMapper {
    int deleteByPrimaryKey(String name);

    int insert(RecordWithBLOBs record);

    int insertSelective(RecordWithBLOBs record);

    RecordWithBLOBs selectByPrimaryKey(String name);

    List<RecordWithBLOBs> selectByOwner(String owner);

    int updateByPrimaryKeySelective(RecordWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RecordWithBLOBs record);

    int updateByPrimaryKey(Record record);
}
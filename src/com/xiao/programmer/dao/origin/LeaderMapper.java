package com.xiao.programmer.dao.origin;

import com.xiao.programmer.entity.origin.Leader;
import com.xiao.programmer.entity.origin.LeaderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LeaderMapper {
    long countByExample(LeaderExample example);

    int deleteByExample(LeaderExample example);

    int deleteByPrimaryKey(String lid);

    int insert(Leader record);

    int insertSelective(Leader record);

    List<Leader> selectByExample(LeaderExample example);

    Leader selectByPrimaryKey(String lid);

    int updateByExampleSelective(@Param("record") Leader record, @Param("example") LeaderExample example);

    int updateByExample(@Param("record") Leader record, @Param("example") LeaderExample example);

    int updateByPrimaryKeySelective(Leader record);

    int updateByPrimaryKey(Leader record);
}
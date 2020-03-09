package com.xiao.programmer.dao.origin;

import com.xiao.programmer.entity.origin.CourseLeader;
import com.xiao.programmer.entity.origin.CourseLeaderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseLeaderMapper {
    long countByExample(CourseLeaderExample example);

    int deleteByExample(CourseLeaderExample example);

    int deleteByPrimaryKey(String cid);

    int insert(CourseLeader record);

    int insertSelective(CourseLeader record);

    List<CourseLeader> selectByExample(CourseLeaderExample example);

    CourseLeader selectByPrimaryKey(String cid);

    int updateByExampleSelective(@Param("record") CourseLeader record, @Param("example") CourseLeaderExample example);

    int updateByExample(@Param("record") CourseLeader record, @Param("example") CourseLeaderExample example);

    int updateByPrimaryKeySelective(CourseLeader record);

    int updateByPrimaryKey(CourseLeader record);
}
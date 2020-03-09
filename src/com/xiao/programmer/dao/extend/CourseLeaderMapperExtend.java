package com.xiao.programmer.dao.extend;

import com.xiao.programmer.entity.origin.CourseLeader;
import com.xiao.programmer.entity.origin.Leader;

import java.util.List;
import java.util.Map;

public interface CourseLeaderMapperExtend extends com.xiao.programmer.dao.origin.CourseLeaderMapper{
    //查询各方向课程信息附上老师信息
    List<CourseLeader> selectCourseListWithCourseAndTeacher();

    // 查询操作返回的用户列表（带模糊查询）
    List<CourseLeader> findList(Map queryMap);
}
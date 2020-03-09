package com.xiao.programmer.dao.extend;

import com.xiao.programmer.entity.origin.Course;

public interface CourseMapperExtend extends com.xiao.programmer.dao.origin.CourseMapper{
    //根据名称查询
    Course selectByName(String name);

    //根据老师id查询老师所授课程
    Course findCourseByTid(String tid);
}
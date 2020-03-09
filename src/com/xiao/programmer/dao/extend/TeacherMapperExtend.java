package com.xiao.programmer.dao.extend;

import com.xiao.programmer.entity.origin.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherMapperExtend extends com.xiao.programmer.dao.origin.TeacherMapper{
    // 老师查询操作返回的老师列表
    List<Teacher> findList(Map queryMap);
}
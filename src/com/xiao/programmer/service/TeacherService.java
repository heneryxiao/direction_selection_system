package com.xiao.programmer.service;

import com.xiao.programmer.dao.extend.TeacherMapperExtend;
import com.xiao.programmer.entity.origin.CourseLeader;
import com.xiao.programmer.entity.origin.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Henery
 * @date 2019/11/29 - 21:44
 */
@Repository
public class TeacherService {
    @Autowired
    private TeacherMapperExtend teacherMapper;

    public Teacher findById(String tid){
        return teacherMapper.selectByPrimaryKey(tid);
    }

    //编辑修改
    public int edit(Teacher teacher) {
        return teacherMapper.updateByPrimaryKeySelective(teacher);
    }

    //查询列表（带模糊、分页）
    public List<Teacher> findList(Map queryMap){
        return teacherMapper.findList(queryMap);
    }

    //获取老师个数
    public long getTotal() {
        return teacherMapper.countByExample(null);
    }

    //添加用户的操作
    public int add(Teacher teacher) {
        return teacherMapper.insertSelective(teacher);
    }

    //编辑修改(带空值的编辑)
    public int editWithNull(Teacher teacher) {
        return teacherMapper.updateByPrimaryKey(teacher);
    }

    //删除
    public int delete(String tid){
        return teacherMapper.deleteByPrimaryKey(tid);
    }
}

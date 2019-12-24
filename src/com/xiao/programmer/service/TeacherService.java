package com.xiao.programmer.service;

import com.xiao.programmer.dao.TeacherMapper;
import com.xiao.programmer.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Henery
 * @date 2019/11/29 - 21:44
 */
@Repository
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    public Teacher findById(String tid){
        return teacherMapper.selectByPrimaryKey(tid);
    }

    //编辑修改
    public int edit(Teacher teacher) {
        return teacherMapper.updateByPrimaryKeySelective(teacher);
    }
}

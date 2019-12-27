package com.xiao.programmer.service;

import com.xiao.programmer.dao.CourseMapper;
import com.xiao.programmer.entity.Branch;
import com.xiao.programmer.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Henery
 * @date 2019/12/6 - 0:03
 */
@Repository
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;
    public Course findById(String cid){
        return courseMapper.selectByPrimaryKey(cid);
    }

    public List<Course> getList() {
        return courseMapper.selectByExample(null);
    }

    //添加课程
    public int add(Course course) {
        return courseMapper.insertSelective(course);
    }

    //根据方向名称查询
    public Course selectByName(String name) {
        return courseMapper.selectByName(name);
    }

    //修改方向
    public int edit(Course course) {
        return courseMapper.updateByPrimaryKeySelective(course);
    }

    //删除
    public int delete(String cid){
        return courseMapper.deleteByPrimaryKey(cid);
    }
}

package com.xiao.programmer.service;

import com.xiao.programmer.dao.extend.CourseLeaderMapperExtend;
import com.xiao.programmer.dao.origin.CourseLeaderMapper;
import com.xiao.programmer.entity.origin.CourseLeader;
import com.xiao.programmer.entity.origin.Leader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Henery
 * @date 2019/12/1 - 20:15
 */
@Repository
public class CourseLeaderService {

    @Autowired
    private CourseLeaderMapperExtend courseLeaderMapper;

    public CourseLeader findById(String cid){
        return courseLeaderMapper.selectByPrimaryKey(cid);
    }

    //编辑修改
    public int edit(CourseLeader courseLeader) {
        return courseLeaderMapper.updateByPrimaryKeySelective(courseLeader);
    }

    //查询各方向课程信息附上老师信息
    public List<CourseLeader> selectCourseListWithCourseAndTeacher(){
        return courseLeaderMapper.selectCourseListWithCourseAndTeacher();
    }

    //查询列表（带模糊、分页）
    public List<CourseLeader> findList(Map queryMap){
        return courseLeaderMapper.findList(queryMap);
    }

    //获取负责人个数
    public long getTotal() {
        return courseLeaderMapper.countByExample(null);
    }
}

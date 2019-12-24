package com.xiao.programmer.service;

import com.xiao.programmer.dao.CourseLeaderMapper;
import com.xiao.programmer.entity.CourseLeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Henery
 * @date 2019/12/1 - 20:15
 */
@Repository
public class CourseLeaderService {

    @Autowired
    private CourseLeaderMapper courseLeaderMapper;

    public CourseLeader findById(String cid){
        return courseLeaderMapper.selectByPrimaryKey(cid);
    }

    //编辑修改
    public int edit(CourseLeader courseLeader) {
        return courseLeaderMapper.updateByPrimaryKeySelective(courseLeader);
    }
}

package com.xiao.programmer.service;

import com.xiao.programmer.dao.LeaderMapper;
import com.xiao.programmer.entity.Leader;
import com.xiao.programmer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Henery
 * @date 2019/12/1 - 20:13
 */
@Repository
public class LeaderService {
    @Autowired
    private LeaderMapper leaderMapper;

    public Leader findById(String lid){
        return leaderMapper.selectByPrimaryKey(lid);
    }

    //编辑修改
    public int edit(Leader leader) {
        return leaderMapper.updateByPrimaryKeySelective(leader);
    }
}

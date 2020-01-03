package com.xiao.programmer.service;

import com.xiao.programmer.dao.extend.LeaderMapperExtend;
import com.xiao.programmer.entity.origin.Branch;
import com.xiao.programmer.entity.origin.Leader;
import com.xiao.programmer.entity.origin.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Henery
 * @date 2019/12/1 - 20:13
 */
@Repository
public class LeaderService {
    @Autowired
    private LeaderMapperExtend leaderMapper;

    public Leader findById(String lid){
        return leaderMapper.selectByPrimaryKey(lid);
    }

    //编辑修改（空值是不修改的）
    public int edit(Leader leader) {
        return leaderMapper.updateByPrimaryKeySelective(leader);
    }

    //查询列表（带模糊、分页）
    public List<Leader> findList(Map queryMap){
        return leaderMapper.findList(queryMap);
    }

    //获取负责人个数
    public long getTotal() {
        return leaderMapper.countByExample(null);
    }

    //添加用户的操作
    public int add(Leader leader) {
        return leaderMapper.insertSelective(leader);
    }

    //编辑修改(带空值的编辑)
    public int editWithNull(Leader leader) {
        return leaderMapper.updateByPrimaryKey(leader);
    }

    //删除
    public int delete(String lid){
        return leaderMapper.deleteByPrimaryKey(lid);
    }
}

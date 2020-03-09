package com.xiao.programmer.dao.extend;

import com.xiao.programmer.entity.origin.Leader;

import java.util.List;
import java.util.Map;

public interface LeaderMapperExtend extends com.xiao.programmer.dao.origin.LeaderMapper{
    // 查询操作返回的用户列表（带模糊查询）
    List<Leader> findList(Map queryMap);
}
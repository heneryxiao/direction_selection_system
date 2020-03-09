package com.xiao.programmer.dao.extend;

import com.xiao.programmer.entity.origin.Branch;

import java.util.List;

public interface BranchMapperExtend extends com.xiao.programmer.dao.origin.BranchMapper {
    //更新
    void updateByBranchId(String branchId);

    //获取限制人数
    Integer getLimitedByBranchId(String branchId);

    //获取已选人数
    Integer getSelectedByBranchId(String branchId);

    //已选人数-1
    void quitByBranchId(String branchId);

    //根据名称查询
    Branch selectByName(String name);

}
package com.xiao.programmer.service;

import com.xiao.programmer.dao.extend.BranchMapperExtend;
import com.xiao.programmer.entity.origin.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Henery
 * @date 2019/12/2 - 23:52
 */
@Repository
public class BranchService {
    @Autowired
    private BranchMapperExtend branchMapper;

    public List<Branch> getList() {
        return branchMapper.selectByExample(null);
    }

    public void updateByBranchId(String branchid) {
        branchMapper.updateByBranchId(branchid);
    }

    public Integer getLimitedByBranchId(String branchid) {
        return branchMapper.getLimitedByBranchId(branchid);
    }

    public Integer getSelectedByBranchId(String branchid) {
        return branchMapper.getSelectedByBranchId(branchid);
    }

    public void quitByBranchId(String branchId) {
        branchMapper.quitByBranchId(branchId);
    }

    //添加方向
    public int add(Branch branch) {
        return branchMapper.insertSelective(branch);
    }

    public Branch findById(String bid) {
        return branchMapper.selectByPrimaryKey(bid);
    }

    //修改方向
    public int edit(Branch branch) {
        return branchMapper.updateByPrimaryKeySelective(branch);
    }

    //根据方向名称查询
    public Branch selectByName(String name) {
        return branchMapper.selectByName(name);
    }
    //删除
    public int delete(String bid){
        return branchMapper.deleteByPrimaryKey(bid);
    }
}

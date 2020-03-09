package com.xiao.programmer.dao.origin;

import com.xiao.programmer.entity.origin.Branch;
import com.xiao.programmer.entity.origin.BranchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BranchMapper {
    long countByExample(BranchExample example);

    int deleteByExample(BranchExample example);

    int deleteByPrimaryKey(String branchid);

    int insert(Branch record);

    int insertSelective(Branch record);

    List<Branch> selectByExample(BranchExample example);

    Branch selectByPrimaryKey(String branchid);

    int updateByExampleSelective(@Param("record") Branch record, @Param("example") BranchExample example);

    int updateByExample(@Param("record") Branch record, @Param("example") BranchExample example);

    int updateByPrimaryKeySelective(Branch record);

    int updateByPrimaryKey(Branch record);
}
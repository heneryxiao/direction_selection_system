package com.xiao.programmer.dao;

import com.xiao.programmer.entity.Branch;
import com.xiao.programmer.entity.BranchExample;
import java.util.List;

import com.xiao.programmer.entity.Student;
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

    void updateByBranchId(String branchId);
    //获取限制人数
    Integer getLimitedByBranchId(String branchId);
    //获取已选人数
    Integer getSelectedByBranchId(String branchId);
    //已选人数-1
    void quitByBranchId(String branchId);
    //
    Branch selectByName(String name);
    //获取专业信息附上课程信息（供学生查看）
    List<Branch> getListBySIdWithCourse();
}
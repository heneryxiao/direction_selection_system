package com.xiao.programmer.dao.extend;

import com.xiao.programmer.entity.origin.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentMapperExtend extends com.xiao.programmer.dao.origin.StudentMapper{
    // 选择专业后修改学生专业信息
    void updateBranchIdBySid(@Param("sId") String Sid, @Param("branchId") String branchid);

    //获取个人学生信息（联合查询带方向名称）
    List<Student> getListBySIdWithBranch(String sId);

    //置空已选方向ID（退选）
    void quitBySid(String Sid);

    // 老师查询操作返回的老师列表
    List<Student> findList(Map queryMap);

    // 老师查询操作返回的老师列表 (附上方向信息)
    List<Student> findListWithBranch(Map queryMap);

    //根据老师id查询所教的学生列表(附上方向信息)
    List<Student> selectStudentListWithBranchByTid(String tid);
}
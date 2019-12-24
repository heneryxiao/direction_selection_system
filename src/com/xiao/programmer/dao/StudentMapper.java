package com.xiao.programmer.dao;

import com.xiao.programmer.entity.Student;
import com.xiao.programmer.entity.StudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(String sid);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    // 选择专业后修改学生专业信息
    void updateBranchIdBySid(@Param("sId") String Sid, @Param("branchId") String branchid);
    //获取个人学生信息（联合查询带方向名称）
    List<Student> getListBySIdWithBranch(String sId);
    //置空已选方向ID（退选）
    void quitBySid(String Sid);
}
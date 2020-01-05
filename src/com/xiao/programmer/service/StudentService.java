package com.xiao.programmer.service;

import com.xiao.programmer.dao.extend.StudentMapperExtend;
import com.xiao.programmer.entity.origin.CourseLeader;
import com.xiao.programmer.entity.origin.Leader;
import com.xiao.programmer.entity.origin.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Henery
 * @date 2019/11/29 - 21:45
 */
@Repository
public class StudentService {
    @Autowired
    private StudentMapperExtend studentMapper;

    public Student findById(String sid) {
        return studentMapper.selectByPrimaryKey(sid);
    }

    public void updateBranchIdBySid(String Sid, String branchid) {
        studentMapper.updateBranchIdBySid(Sid, branchid);
    }

    public List<Student> getListBySIdWithBranch(String sid) {
        return studentMapper.getListBySIdWithBranch(sid);
    }

    public void quitBySid(String Sid) {
        studentMapper.quitBySid(Sid);
    }

    //编辑修改
    public int edit(Student student) {
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    //查询列表（带模糊、分页）
    public List<Student> findList(Map queryMap){
        return studentMapper.findList(queryMap);
    }

    //获取学生个数
    public long getTotal() {
        return studentMapper.countByExample(null);
    }

    //带上方向信息的查询列表（带模糊、分页）
    public List<Student> findListWithBranch(Map queryMap) {
        return studentMapper.findListWithBranch(queryMap);
    }
    //根据老师id查询所教的学生列表(附上方向信息)
    public List<Student> selectStudentListWithBranchByTid(String tid) {
        return studentMapper.selectStudentListWithBranchByTid(tid);
    }

    //添加用户的操作studentMapper
    public int add(Student student) {
        return studentMapper.insertSelective(student);
    }

    //编辑修改(带空值的编辑)
    public int editWithNull(Student student) {
        return studentMapper.updateByPrimaryKey(student);
    }

    //删除
    public int delete(String sid){
        return studentMapper.deleteByPrimaryKey(sid);
    }

}

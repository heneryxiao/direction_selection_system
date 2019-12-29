package com.xiao.programmer.service;

import com.xiao.programmer.dao.StudentMapper;
import com.xiao.programmer.entity.Student;
import com.xiao.programmer.entity.Teacher;
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
    private StudentMapper studentMapper;

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

}

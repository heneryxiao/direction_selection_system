package com.xiao.programmer.service;

import com.xiao.programmer.dao.StudentMapper;
import com.xiao.programmer.entity.Branch;
import com.xiao.programmer.entity.Leader;
import com.xiao.programmer.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

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

}

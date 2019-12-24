package com.xiao.programmer.service;

import com.xiao.programmer.dao.UserMapper;
import com.xiao.programmer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Henery
 * @date 2019/11/28 - 22:56
 */
@Repository
public class UserService {

    @Autowired
    private UserMapper userMapper;

    //根据id查找
    public User findById(String uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    public List<User> findList(Map queryMap){
        return userMapper.findList(queryMap);
    }

    /**
     * 获取用户列表
     * @return
     */
    public List<User> getList() {
        return userMapper.selectByExample(null);
    }

    /**
     * 获取用户个数
     * @return
     */
    public long getTotal() {
        return userMapper.countByExample(null);
    }

    /**
     * 添加用户的操作
     *
     * @param user
     * @return
     */
    public int add(User user) {
        return userMapper.insertSelective(user);
    }

    /**
     * 删除用户操作
     *
     * @param uid
     * @return
     */
    public int delete(String uid) {
        return userMapper.deleteByPrimaryKey(uid);
    }

    /**
     * 修改用户操作
     *
     * @param user
     * @return
     */
    public int edit(User user) {
//		 return userMapper.updateByExample(user, null);
        return userMapper.updateByPrimaryKeySelective(user);
    }

}

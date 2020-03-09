package com.xiao.programmer.dao.extend;

import com.xiao.programmer.entity.origin.User;

import java.util.List;
import java.util.Map;

public interface UserMapperExtend extends com.xiao.programmer.dao.origin.UserMapper{
    // 用户查询操作返回的用户列表
    List<User> findList(Map queryMap);
}
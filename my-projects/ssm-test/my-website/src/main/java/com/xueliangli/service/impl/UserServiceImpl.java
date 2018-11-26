package com.xueliangli.service.impl;



import com.xueliangli.dao.IUserDao;

import com.xueliangli.model.User;
import com.xueliangli.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

}

package com.xueliangli.dao;

import com.xueliangli.model.User;

public interface IUserDao {

    User selectUser(long id);

}
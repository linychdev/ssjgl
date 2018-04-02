package com.ustb.ssjgl.service;

import java.util.Set;

import com.ustb.ssjgl.bean.User;

public interface IUserService {
    public User getUser(String userName);

    public Set<String> findRoles(String username);

    public Set<String> findPermissions(String username);

    public User findByUsername(String username);
}

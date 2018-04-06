package com.ustb.ssjgl.login.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ustb.ssjgl.login.dao.IPermissionDao;
import com.ustb.ssjgl.login.dao.IRoleDao;
import com.ustb.ssjgl.login.dao.IUserDao;
import com.ustb.ssjgl.login.dao.bean.TPermission;
import com.ustb.ssjgl.login.dao.bean.TRole;
import com.ustb.ssjgl.login.dao.bean.TUser;
import com.ustb.ssjgl.login.service.IUserService;

public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserDao userDao;
    
    @Autowired
    private IRoleDao roleDao;
    
    @Autowired
    private IPermissionDao permissionDao;
    
    @Override
    public TUser getUserByName(String loginName) {
        return userDao.getUserByLoginName(loginName);
    }

    @Override
    public List<TRole> getRoleByUserId(String userId) {
        return roleDao.getRolesByUserId(userId);
    }

    @Override
    public List<TPermission> getPermissionByUserId(String roleId) {
        return permissionDao.getPermissionsByRoleId(roleId);
    }
}

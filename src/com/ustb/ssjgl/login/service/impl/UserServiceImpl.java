package com.ustb.ssjgl.login.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ustb.ssjgl.common.utils.LogUtils;
import com.ustb.ssjgl.login.dao.IPermissionDao;
import com.ustb.ssjgl.login.dao.IRoleDao;
import com.ustb.ssjgl.login.dao.IUserDao;
import com.ustb.ssjgl.login.dao.bean.TPermission;
import com.ustb.ssjgl.login.dao.bean.TRole;
import com.ustb.ssjgl.login.dao.bean.TUser;
import com.ustb.ssjgl.login.service.IUserService;

public class UserServiceImpl implements IUserService{

    private static final Logger LOG = LogUtils.getLogger();
    
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

    @Override
    public boolean addUser(TUser user) {
        try {
            userDao.insertSelective(user);
            return true;
            
        } catch (Exception e) {
            LOG.error("保存用户数据出错！", e);
            return false;
        }
    }

    @Override
    public TUser getUserByEmail(String emailAddress) {
        return userDao.getUserByEmail(emailAddress);
    }
}

package com.ustb.ssjgl.login.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ustb.ssjgl.common.paging.Page;
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

    @Override
    public void deleteUser(String userId) {
        userDao.deleteByPrimaryKey(TUser.class, userId);
    }


    @Override
    public Page<?> getUserListByPaging(Map<String, Object> filter, int pageSize, int pageIndex) {
        try {
            Page<TUser> page = new Page<TUser>();
            page.setPageSize(pageSize);
            page.setPageIndex(pageIndex);
            int count = userDao.getCount(filter);
            page.setRecord(count);
            
            filter.put("stratRow", page.getSartRow());
            filter.put("endRow", page.getEndRow());
            List<TUser> userList = userDao.getUserByFilter(filter);
            page.setDataList(userList);
            return page;
            
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }  
}

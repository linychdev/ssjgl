package com.ustb.ssjgl.login.service;

import java.util.List;
import java.util.Set;

import com.ustb.ssjgl.login.bean.PermissionModel;
import com.ustb.ssjgl.login.bean.RoleModel;
import com.ustb.ssjgl.login.bean.UserModel;

public class UserServiceImpl implements IUserService{

    @Override
    public UserModel getUser(String userName) {
        // TODO Auto-generated method stub
        return null;
    }

    public UserModel findByUsername(String username) {
        // TODO Auto-generated method stub
        return null;
    }

    public Set<String> findRoles(String username) {
        // TODO Auto-generated method stub
        return null;
    }

    public Set<String> findPermissions(String username) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserModel getUserByName(String currentUsername) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<RoleModel> selectRoleByMemberId(Object id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PermissionModel> selectPermissionByMemberId(Object id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserModel getMemberByName(String username) {
        // TODO Auto-generated method stub
        return null;
    }

}

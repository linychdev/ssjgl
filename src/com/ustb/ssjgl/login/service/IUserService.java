package com.ustb.ssjgl.login.service;

import java.util.List;
import java.util.Set;

import com.ustb.ssjgl.login.bean.PermissionModel;
import com.ustb.ssjgl.login.bean.RoleModel;
import com.ustb.ssjgl.login.bean.UserModel;

public interface IUserService {
    public UserModel getUser(String userName);

    public Set<String> findRoles(String username);

    public Set<String> findPermissions(String username);

    public UserModel findByUsername(String username);

    public UserModel getUserByName(String currentUsername);

    public List<RoleModel> selectRoleByMemberId(Object id);

    public List<PermissionModel> selectPermissionByMemberId(Object id);

    public UserModel getMemberByName(String username);
}

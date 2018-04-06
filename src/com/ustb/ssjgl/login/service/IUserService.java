package com.ustb.ssjgl.login.service;

import java.util.List;

import com.ustb.ssjgl.login.dao.bean.TPermission;
import com.ustb.ssjgl.login.dao.bean.TRole;
import com.ustb.ssjgl.login.dao.bean.TUser;

/**
 * 用户管理service
 * IUserService
 * @author linych
 * @version 1.0
 *
 */
public interface IUserService {


    /**
     * 根据用户名获取用户对象
     * @param currentUsername
     * @return
     */
    public TUser getUserByName(String currentUsername);

    /**
     * 根据用户id获取权限
     * @param userId 用户id
     * @return
     */
    public List<TRole> getRoleByUserId(String userId);

    /**
     * 根据用户id获取角色
     * @param String roleId 角色id
     * @return
     */
    public List<TPermission> getPermissionByUserId(String roleId);

}

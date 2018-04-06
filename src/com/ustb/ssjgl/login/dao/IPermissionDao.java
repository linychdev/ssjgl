package com.ustb.ssjgl.login.dao;

import java.util.List;

import com.ustb.ssjgl.login.dao.bean.TPermission;

/**
 * 权限dao层接口
 * IPermissionDao
 * @author linych
 * @version 1.0
 *
 */
public interface IPermissionDao {
    /**
     * 根据角色id获取权限
     * @param roleId
     * @return
     */
    public List<TPermission> getPermissionsByRoleId(String roleId);
    
    /**
     * 获取全部权限
     * @return
     */
    public List<TPermission> getAllPermissions();
}

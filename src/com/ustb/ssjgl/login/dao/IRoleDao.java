package com.ustb.ssjgl.login.dao;

import java.util.List;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.login.dao.bean.TRole;

/**
 * 角色dao层接口
 * IRoleDao
 * @author linych
 * @version 1.0
 *
 */
public interface IRoleDao extends IAbstractDao{
    /**
     * 根据用户id获取角色
     * @param userId
     * @return
     */
    public List<TRole> getRolesByUserId(String userId);
    
    /**
     * 获取全部角色信息
     * @return
     */
    public List<TRole> getAllRoles();
}

package com.ustb.ssjgl.login.dao;

import java.util.List;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.login.dao.bean.TUser;

/**
 * 用户dao层接口
 * IUserDao
 * @author linych
 * @version 1.0
 *
 */
public interface IUserDao extends IAbstractDao{
    /**
     * 根据登录名获取用户信息
     * @param loginName
     * @return
     */
    public TUser getUserByLoginName(String loginName);
    
    /**
     * 获取所有用户
     * @return
     */
    public List<TUser> getAllUser();
    
    
    public List<TUser> getUserListByRole(String role);
    
    
    public void saveUser(TUser user);

    public TUser getUserByEmail(String emailAddress);
}

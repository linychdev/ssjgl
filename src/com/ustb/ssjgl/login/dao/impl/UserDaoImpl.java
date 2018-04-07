package com.ustb.ssjgl.login.dao.impl;

import java.util.List;

import com.ustb.ssjgl.common.dao.AbstractDao;
import com.ustb.ssjgl.login.dao.IUserDao;
import com.ustb.ssjgl.login.dao.bean.TUser;

public class UserDaoImpl extends AbstractDao implements IUserDao{

    private String mapperNamespace = "com.ustb.ssjgl.login.dao.mappings.TUserMapper";
    {
        super.mapperNamespace = "com.ustb.ssjgl.login.dao.mappings.";
    }
    @Override
    public TUser getUserByLoginName(String loginName) {
        String statement = mapperNamespace + ".selectUserByLoginName";
        return this.getSqlSession().selectOne(statement, loginName);
    }

    @Override
    public List<TUser> getAllUser() {
        String statement = mapperNamespace + ".selectAllUser";
        return this.getSqlSession().selectList(statement);
    }

    @Override
    public List<TUser> getUserListByRole(String role) {
        String statement = mapperNamespace + ".selectUserByRole";
        return this.getSqlSession().selectList(statement, role);
    }

    @Override
    public void saveUser(TUser user) {
        insertSelective(user);
    }
}

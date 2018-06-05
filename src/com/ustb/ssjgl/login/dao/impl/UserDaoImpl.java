package com.ustb.ssjgl.login.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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

    @Override
    public TUser getUserByEmail(String emailAddress) {
        String statement = mapperNamespace + ".selectUserByEmail";
        return this.getSqlSession().selectOne(statement, emailAddress);
    }

    @Override
    public int getCount(@Param("filter") Map<String, Object> filter) {
        String statement = mapperNamespace + ".selectCountByFilter";
        return this.getSqlSession().selectOne(statement, filter);
    }

    @Override
    public List<TUser> getUserByFilter(@Param("filter") Map<String, Object> filter) {
        String statement = mapperNamespace + ".selectByFilter";
        return this.getSqlSession().selectList(statement, filter);
    }
}

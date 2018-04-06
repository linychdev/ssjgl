package com.ustb.ssjgl.login.dao.impl;

import java.util.List;

import com.ustb.ssjgl.common.dao.AbstractDao;
import com.ustb.ssjgl.login.dao.IRoleDao;
import com.ustb.ssjgl.login.dao.bean.TRole;

public class RoleDaoImpl extends AbstractDao implements IRoleDao{

    private String mapperNamespace = "com.ustb.ssjgl.login.dao.mappings.TRoleMapper";
    
    @Override
    public List<TRole> getRolesByUserId(String userId) {
        String statement = mapperNamespace + ".selectRolesByUserId";
        return this.getSqlSession().selectList(statement, userId);
    }

    @Override
    public List<TRole> getAllRoles() {
        String statement = mapperNamespace + ".selectAllRoles";
        return this.getSqlSession().selectList(statement);
    }

}

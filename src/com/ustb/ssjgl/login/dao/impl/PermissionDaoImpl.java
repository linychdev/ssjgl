package com.ustb.ssjgl.login.dao.impl;

import java.util.List;

import com.ustb.ssjgl.common.dao.AbstractDao;
import com.ustb.ssjgl.login.dao.IPermissionDao;
import com.ustb.ssjgl.login.dao.bean.TPermission;

public class PermissionDaoImpl extends AbstractDao implements IPermissionDao{
    
    private String mapperNamespace = "com.ustb.ssjgl.login.dao.mappings.TPermissionMapper";
    
    @Override
    public List<TPermission> getPermissionsByRoleId(String roleId) {
        String statement = mapperNamespace + ".selectPermissionsByRoleId";
        return this.getSqlSession().selectList(statement, roleId);
    }

    @Override
    public List<TPermission> getAllPermissions() {
        String statement = mapperNamespace + ".selectAllPermissions";
        return this.getSqlSession().selectList(statement);
    }

}

package com.ustb.ssjgl.dao;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * dao基类
 * AbstractDao
 * @author linych
 * @version 1.0
 *
 */
@Repository("abstractDao")
public class AbstractDao extends SqlSessionDaoSupport {

    private static final String mapperNamespace = "com.ustb.ssjgl.dao.mappings.";

    private String getStatementByClass(String method, Class<?> entityClass) {
        return mapperNamespace + entityClass.getSimpleName() + "Mapper." + method;
    }

    private static String getStatement(String method, Object entity) {
        return mapperNamespace + entity.getClass().getSimpleName() + "Mapper." + method;
    }

    private JdbcTemplate jdbcTemplate;
    
    private TransactionTemplate transactionTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    /**
     * @return the transactionTemplate
     */
    public TransactionTemplate getTransactionTemplate() {
        return transactionTemplate;
    }

    /**
     * @param transactionTemplate the transactionTemplate to set
     */
    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void insertSelective(Object entity) {
        getSqlSession().insert(getStatement("insertSelective", entity), entity);
    }

    public void updateSelective(Object entity) {
        getSqlSession().update(getStatement("updateByPrimaryKeySelective", entity), entity);
    }

    public void update(Object entity) {
        getSqlSession().update(getStatement("updateByPrimaryKey", entity), entity);
    }

    public void deleteByPrimaryKey(Class<?> entityClass, String primaryKey) {
        getSqlSession().delete(getStatementByClass("deleteByPrimaryKey", entityClass), primaryKey);
    }

    public <E> E selectByPrimaryKey(Class<E> entityClass, String primaryKey) {
        return getSqlSession().selectOne(getStatementByClass("selectByPrimaryKey", entityClass), primaryKey);
    }

    public <E> E uniqueResult(String statement, Object entity) {
        RowBounds pageBounds = new RowBounds(0, 1);
        List<E> list = getSqlSession().selectList(statement, entity, pageBounds);
        return list.isEmpty() ? null : list.get(0);
    }
    
    public <E> List<E> topResult(String statement, Object entity, int pageSize) {
        RowBounds pageBounds = new RowBounds(0, pageSize);
        return getSqlSession().selectList(statement, entity, pageBounds);
    }
}

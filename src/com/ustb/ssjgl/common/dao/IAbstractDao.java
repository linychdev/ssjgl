package com.ustb.ssjgl.common.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;

public interface IAbstractDao {
    public JdbcTemplate getJdbcTemplate();

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate);
    
    /**
     * @return the transactionTemplate
     */
    public TransactionTemplate getTransactionTemplate();

    /**
     * @param transactionTemplate the transactionTemplate to set
     */
    public void setTransactionTemplate(TransactionTemplate transactionTemplate);

    public void insertSelective(Object entity);

    public void updateSelective(Object entity);

    public void update(Object entity);

    public void deleteByPrimaryKey(Class<?> entityClass, String primaryKey);

    public <E> E selectByPrimaryKey(Class<E> entityClass, String primaryKey);

    public <E> E uniqueResult(String statement, Object entity);
    
    public <E> List<E> topResult(String statement, Object entity, int pageSize);
}

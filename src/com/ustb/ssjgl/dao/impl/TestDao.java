package com.ustb.ssjgl.dao.impl;

import com.ustb.ssjgl.dao.AbstractDao;
import com.ustb.ssjgl.dao.IVisitLogDao;
import com.ustb.ssjgl.dao.pojo.TTestLin;

public class TestDao extends AbstractDao implements IVisitLogDao{
    
   public TTestLin getTestByBh(){
      TTestLin test = selectByPrimaryKey(TTestLin.class, "aaa");
      System.out.println(test.getcName()+":"+test.getcPassword());
      return test;
   }
}

/*
 * @(#)ElementCombShowInfo.java 2018年4月28日下午4:23:20
 * ssjgl
 * Copyright 2018 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ustb.ssjgl.main.dao.bean;

import java.util.List;

/**
 * ElementCombShowInfo
 * @author linych
 * @version 1.0
 *
 */
public class ElementCombShowInfo {
    private TElementCombination elementComb;
    private List<TElement> elementList;
    
    /**
     * @return the elementComb
     */
    public TElementCombination getElementComb() {
        return elementComb;
    }
    /**
     * @param elementComb the elementComb to set
     */
    public void setElementComb(TElementCombination elementComb) {
        this.elementComb = elementComb;
    }
    /**
     * @return the elementList
     */
    public List<TElement> getElementList() {
        return elementList;
    }
    /**
     * @param elementList the elementList to set
     */
    public void setElementList(List<TElement> elementList) {
        this.elementList = elementList;
    }
}

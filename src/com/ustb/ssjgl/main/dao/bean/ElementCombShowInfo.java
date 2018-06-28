package com.ustb.ssjgl.main.dao.bean;

import java.util.List;

/**
 * ElementCombShowInfo
 * @author linych
 * @version 1.0
 *
 */
public class ElementCombShowInfo implements Comparable<ElementCombShowInfo>{
    private TElementCombination elementComb;
    private List<TElement> elementList;
    private Double searchTimes;
    private TPotentialsScope scope;
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
    
    public Double getSearchTimes() {
        return searchTimes;
    }
    
    public void setSearchTimes(Double searchTimes) {
        this.searchTimes = searchTimes;
    }
    public TPotentialsScope getScope() {
        return scope;
    }
    public void setScope(TPotentialsScope scope) {
        this.scope = scope;
    }
    @Override
    public int compareTo(ElementCombShowInfo o) {
        return o.searchTimes.compareTo(this.searchTimes);
    }
}

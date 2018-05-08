package com.ustb.ssjgl.main.bean;

import java.util.List;

import com.ustb.ssjgl.main.dao.bean.TPotentialsFile;
import com.ustb.ssjgl.main.dao.bean.TReference;

public class TReferenceInfo {
    
    /**
     * 参考文献
     */
    private TReference reference;
    
    /**
     * 相关文件
     */
    private List<TPotentialsFile> potentialsFiles;

    public TReference getReference() {
        return reference;
    }

    public void setReference(TReference reference) {
        this.reference = reference;
    }

    public List<TPotentialsFile> getPotentialsFiles() {
        return potentialsFiles;
    }

    public void setPotentialsFiles(List<TPotentialsFile> potentialsFiles) {
        this.potentialsFiles = potentialsFiles;
    }
}

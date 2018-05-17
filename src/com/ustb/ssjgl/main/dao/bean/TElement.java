package com.ustb.ssjgl.main.dao.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class TElement {
    /** 主键 */
    private String cId;

    /** 元素名称 */
    private String cElementName;

    /** 符号 */
    private String cSymbol;

    /** 电子排布 */
    private String cElectronConfiguration;

    /** 电负性 */
    private BigDecimal nElectronegativity;

    /** 原子序数 */
    private Integer nAtomicNumber;

    /** 相对原子质量 */
    private BigDecimal nRelativeAtomicMass;

    /** 熔点 */
    private Integer nMeltingPoint;

    /** 沸点 */
    private Integer nBoilingPoint;

    /** 晶体结构 */
    private String cCrystalStructure;

    /** 电离能 */
    private BigDecimal nInizationEnergy;

    /** 半径 */
    private Integer nRadius;

    /** 元素周期 */
    private Integer nCycle;

    /** 元素族 */
    private Integer nRace;

    /** 时间戳 */
    private Timestamp dTime;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcElementName() {
        return cElementName;
    }

    public void setcElementName(String cElementName) {
        this.cElementName = cElementName == null ? null : cElementName.trim();
    }

    public String getcSymbol() {
        return cSymbol;
    }

    public void setcSymbol(String cSymbol) {
        this.cSymbol = cSymbol == null ? null : cSymbol.trim();
    }

    public String getcElectronConfiguration() {
        return cElectronConfiguration;
    }

    public void setcElectronConfiguration(String cElectronConfiguration) {
        this.cElectronConfiguration = cElectronConfiguration == null ? null : cElectronConfiguration.trim();
    }

    public BigDecimal getnElectronegativity() {
        return nElectronegativity;
    }

    public void setnElectronegativity(BigDecimal nElectronegativity) {
        this.nElectronegativity = nElectronegativity;
    }

    public Integer getnAtomicNumber() {
        return nAtomicNumber;
    }

    public void setnAtomicNumber(Integer nAtomicNumber) {
        this.nAtomicNumber = nAtomicNumber;
    }

    public BigDecimal getnRelativeAtomicMass() {
        return nRelativeAtomicMass;
    }

    public void setnRelativeAtomicMass(BigDecimal nRelativeAtomicMass) {
        this.nRelativeAtomicMass = nRelativeAtomicMass;
    }

    public Integer getnMeltingPoint() {
        return nMeltingPoint;
    }

    public void setnMeltingPoint(Integer nMeltingPoint) {
        this.nMeltingPoint = nMeltingPoint;
    }

    public Integer getnBoilingPoint() {
        return nBoilingPoint;
    }

    public void setnBoilingPoint(Integer nBoilingPoint) {
        this.nBoilingPoint = nBoilingPoint;
    }

    public String getcCrystalStructure() {
        return cCrystalStructure;
    }

    public void setcCrystalStructure(String cCrystalStructure) {
        this.cCrystalStructure = cCrystalStructure == null ? null : cCrystalStructure.trim();
    }

    public BigDecimal getnInizationEnergy() {
        return nInizationEnergy;
    }

    public void setnInizationEnergy(BigDecimal nInizationEnergy) {
        this.nInizationEnergy = nInizationEnergy;
    }

    public Integer getnRadius() {
        return nRadius;
    }

    public void setnRadius(Integer nRadius) {
        this.nRadius = nRadius;
    }

    public Integer getnCycle() {
        return nCycle;
    }

    public void setnCycle(Integer nCycle) {
        this.nCycle = nCycle;
    }

    public Integer getnRace() {
        return nRace;
    }

    public void setnRace(Integer nRace) {
        this.nRace = nRace;
    }

    public Timestamp getdTime() {
        return dTime;
    }

    public void setdTime(Timestamp dTime) {
        this.dTime = dTime;
    }
}
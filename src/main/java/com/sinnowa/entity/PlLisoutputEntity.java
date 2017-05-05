package com.sinnowa.entity;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/5/3.
 */
@Entity
@Table(name = "pl_lisoutput", schema = "middleware", catalog = "")
@IdClass(PlLisoutputEntityPK.class)
public class PlLisoutputEntity {
    private String sampleId;
    private String barCode;
    private Timestamp testTime;
    private String device;
    private String aap;
    private String sampleKind;
    private String item;
    private String fullName;
    private String result;
    private String unit;
    private Double normalLOw;
    private Double normalHigh;
    private String indicate;
    private Boolean issend;

    @Id
    @Column(name = "SAMPLE_ID")
    public String getSampleId() {
        return sampleId;
    }

    public void setSampleId(String sampleId) {
        this.sampleId = sampleId;
    }

    @Id
    @Column(name = "BarCode")
    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    @Id
    @Column(name = "TEST_TIME")
    public Timestamp getTestTime() {
        return testTime;
    }

    public void setTestTime(Timestamp testTime) {
        this.testTime = testTime;
    }

    @Id
    @Column(name = "DEVICE")
    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    @Basic
    @Column(name = "AAP")
    public String getAap() {
        return aap;
    }

    public void setAap(String aap) {
        this.aap = aap;
    }

    @Basic
    @Column(name = "SAMPLE_KIND")
    public String getSampleKind() {
        return sampleKind;
    }

    public void setSampleKind(String sampleKind) {
        this.sampleKind = sampleKind;
    }

    @Id
    @Column(name = "ITEM")
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Basic
    @Column(name = "FULL_NAME")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "RESULT")
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Basic
    @Column(name = "UNIT")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "NORMAL_lOW")
    public Double getNormalLOw() {
        return normalLOw;
    }

    public void setNormalLOw(Double normalLOw) {
        this.normalLOw = normalLOw;
    }

    @Basic
    @Column(name = "NORMAL_HIGH")
    public Double getNormalHigh() {
        return normalHigh;
    }

    public void setNormalHigh(Double normalHigh) {
        this.normalHigh = normalHigh;
    }

    @Basic
    @Column(name = "INDICATE")
    public String getIndicate() {
        return indicate;
    }

    public void setIndicate(String indicate) {
        this.indicate = indicate;
    }

    @Basic
    @Column(name = "ISSEND")
    public Boolean getIssend() {
        return issend;
    }

    public void setIssend(Boolean issend) {
        this.issend = issend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlLisoutputEntity that = (PlLisoutputEntity) o;

        if (sampleId != null ? !sampleId.equals(that.sampleId) : that.sampleId != null) return false;
        if (barCode != null ? !barCode.equals(that.barCode) : that.barCode != null) return false;
        if (testTime != null ? !testTime.equals(that.testTime) : that.testTime != null) return false;
        if (device != null ? !device.equals(that.device) : that.device != null) return false;
        if (aap != null ? !aap.equals(that.aap) : that.aap != null) return false;
        if (sampleKind != null ? !sampleKind.equals(that.sampleKind) : that.sampleKind != null) return false;
        if (item != null ? !item.equals(that.item) : that.item != null) return false;
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null) return false;
        if (result != null ? !result.equals(that.result) : that.result != null) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;
        if (normalLOw != null ? !normalLOw.equals(that.normalLOw) : that.normalLOw != null) return false;
        if (normalHigh != null ? !normalHigh.equals(that.normalHigh) : that.normalHigh != null) return false;
        if (indicate != null ? !indicate.equals(that.indicate) : that.indicate != null) return false;
        if (issend != null ? !issend.equals(that.issend) : that.issend != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = sampleId != null ? sampleId.hashCode() : 0;
        result1 = 31 * result1 + (barCode != null ? barCode.hashCode() : 0);
        result1 = 31 * result1 + (testTime != null ? testTime.hashCode() : 0);
        result1 = 31 * result1 + (device != null ? device.hashCode() : 0);
        result1 = 31 * result1 + (aap != null ? aap.hashCode() : 0);
        result1 = 31 * result1 + (sampleKind != null ? sampleKind.hashCode() : 0);
        result1 = 31 * result1 + (item != null ? item.hashCode() : 0);
        result1 = 31 * result1 + (fullName != null ? fullName.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (unit != null ? unit.hashCode() : 0);
        result1 = 31 * result1 + (normalLOw != null ? normalLOw.hashCode() : 0);
        result1 = 31 * result1 + (normalHigh != null ? normalHigh.hashCode() : 0);
        result1 = 31 * result1 + (indicate != null ? indicate.hashCode() : 0);
        result1 = 31 * result1 + (issend != null ? issend.hashCode() : 0);
        return result1;
    }
}

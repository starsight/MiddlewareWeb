package com.sinnowa.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017/5/3.
 */
public class PlLisoutputEntityPK implements Serializable {
    private String sampleId;
    private String barCode;
    private Timestamp testTime;
    private String device;
    private String item;

    @Column(name = "SAMPLE_ID")
    @Id
    public String getSampleId() {
        return sampleId;
    }

    public void setSampleId(String sampleId) {
        this.sampleId = sampleId;
    }

    @Column(name = "BarCode")
    @Id
    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    @Column(name = "TEST_TIME")
    @Id
    public Timestamp getTestTime() {
        return testTime;
    }

    public void setTestTime(Timestamp testTime) {
        this.testTime = testTime;
    }

    @Column(name = "DEVICE")
    @Id
    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    @Column(name = "ITEM")
    @Id
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlLisoutputEntityPK that = (PlLisoutputEntityPK) o;

        if (sampleId != null ? !sampleId.equals(that.sampleId) : that.sampleId != null) return false;
        if (barCode != null ? !barCode.equals(that.barCode) : that.barCode != null) return false;
        if (testTime != null ? !testTime.equals(that.testTime) : that.testTime != null) return false;
        if (device != null ? !device.equals(that.device) : that.device != null) return false;
        if (item != null ? !item.equals(that.item) : that.item != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sampleId != null ? sampleId.hashCode() : 0;
        result = 31 * result + (barCode != null ? barCode.hashCode() : 0);
        result = 31 * result + (testTime != null ? testTime.hashCode() : 0);
        result = 31 * result + (device != null ? device.hashCode() : 0);
        result = 31 * result + (item != null ? item.hashCode() : 0);
        return result;
    }
}

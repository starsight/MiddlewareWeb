package com.sinnowa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017/5/3.
 */
public class DsLisoutputEntityPK implements Serializable {
    private String sampleId;
    private String item;
    private String type;
    private String device;

    @Column(name = "SAMPLE_ID")
    @Id
    public String getSampleId() {
        return sampleId;
    }

    public void setSampleId(String sampleId) {
        this.sampleId = sampleId;
    }

    @Column(name = "ITEM")
    @Id
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Column(name = "Type")
    @Id
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "Device")
    @Id
    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DsLisoutputEntityPK that = (DsLisoutputEntityPK) o;

        if (sampleId != null ? !sampleId.equals(that.sampleId) : that.sampleId != null) return false;
        if (item != null ? !item.equals(that.item) : that.item != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (device != null ? !device.equals(that.device) : that.device != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sampleId != null ? sampleId.hashCode() : 0;
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (device != null ? device.hashCode() : 0);
        return result;
    }
}

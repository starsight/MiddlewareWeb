package com.sinnowa.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/5/24.
 */
@Entity
@Table(name = "deviceinfo", schema = "middleware", catalog = "")
public class DeviceinfoEntity {
    private String deviceName;
    private String state;
    private Timestamp lastQueryTime;
    private Integer sampleSum;
    private Integer sampleCount0;
    private Integer sampleCount2;
    private Integer sampleCount4;
    private Integer sampleCount6;
    private Integer sampleCount8;
    private Integer sampleCount10;
    private Integer sampleCount12;
    private Integer sampleCount14;
    private Integer sampleCount16;
    private Integer sampleCount18;
    private Integer sampleCount20;
    private Integer sampleCount22;
    private Integer averageDetectionTime;
    private String sampleDetectionQuality;
    private Timestamp lastActiveTime;

    @Id
    @Column(name = "DeviceName")
    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @Basic
    @Column(name = "State")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "LastQueryTime")
    public Timestamp getLastQueryTime() {
        return lastQueryTime;
    }

    public void setLastQueryTime(Timestamp lastQueryTime) {
        this.lastQueryTime = lastQueryTime;
    }

    @Basic
    @Column(name = "SampleSum")
    public Integer getSampleSum() {
        return sampleSum;
    }

    public void setSampleSum(Integer sampleSum) {
        this.sampleSum = sampleSum;
    }

    @Basic
    @Column(name = "SampleCount0")
    public Integer getSampleCount0() {
        return sampleCount0;
    }

    public void setSampleCount0(Integer sampleCount0) {
        this.sampleCount0 = sampleCount0;
    }

    @Basic
    @Column(name = "SampleCount2")
    public Integer getSampleCount2() {
        return sampleCount2;
    }

    public void setSampleCount2(Integer sampleCount2) {
        this.sampleCount2 = sampleCount2;
    }

    @Basic
    @Column(name = "SampleCount4")
    public Integer getSampleCount4() {
        return sampleCount4;
    }

    public void setSampleCount4(Integer sampleCount4) {
        this.sampleCount4 = sampleCount4;
    }

    @Basic
    @Column(name = "SampleCount6")
    public Integer getSampleCount6() {
        return sampleCount6;
    }

    public void setSampleCount6(Integer sampleCount6) {
        this.sampleCount6 = sampleCount6;
    }

    @Basic
    @Column(name = "SampleCount8")
    public Integer getSampleCount8() {
        return sampleCount8;
    }

    public void setSampleCount8(Integer sampleCount8) {
        this.sampleCount8 = sampleCount8;
    }

    @Basic
    @Column(name = "SampleCount10")
    public Integer getSampleCount10() {
        return sampleCount10;
    }

    public void setSampleCount10(Integer sampleCount10) {
        this.sampleCount10 = sampleCount10;
    }

    @Basic
    @Column(name = "SampleCount12")
    public Integer getSampleCount12() {
        return sampleCount12;
    }

    public void setSampleCount12(Integer sampleCount12) {
        this.sampleCount12 = sampleCount12;
    }

    @Basic
    @Column(name = "SampleCount14")
    public Integer getSampleCount14() {
        return sampleCount14;
    }

    public void setSampleCount14(Integer sampleCount14) {
        this.sampleCount14 = sampleCount14;
    }

    @Basic
    @Column(name = "SampleCount16")
    public Integer getSampleCount16() {
        return sampleCount16;
    }

    public void setSampleCount16(Integer sampleCount16) {
        this.sampleCount16 = sampleCount16;
    }

    @Basic
    @Column(name = "SampleCount18")
    public Integer getSampleCount18() {
        return sampleCount18;
    }

    public void setSampleCount18(Integer sampleCount18) {
        this.sampleCount18 = sampleCount18;
    }

    @Basic
    @Column(name = "SampleCount20")
    public Integer getSampleCount20() {
        return sampleCount20;
    }

    public void setSampleCount20(Integer sampleCount20) {
        this.sampleCount20 = sampleCount20;
    }

    @Basic
    @Column(name = "SampleCount22")
    public Integer getSampleCount22() {
        return sampleCount22;
    }

    public void setSampleCount22(Integer sampleCount22) {
        this.sampleCount22 = sampleCount22;
    }

    @Basic
    @Column(name = "AverageDetectionTime")
    public Integer getAverageDetectionTime() {
        return averageDetectionTime;
    }

    public void setAverageDetectionTime(Integer averageDetectionTime) {
        this.averageDetectionTime = averageDetectionTime;
    }

    @Basic
    @Column(name = "SampleDetectionQuality")
    public String getSampleDetectionQuality() {
        return sampleDetectionQuality;
    }

    public void setSampleDetectionQuality(String sampleDetectionQuality) {
        this.sampleDetectionQuality = sampleDetectionQuality;
    }

    @Basic
    @Column(name = "LastActiveTime")
    public Timestamp getLastActiveTime() {
        return lastActiveTime;
    }

    public void setLastActiveTime(Timestamp lastActiveTime) {
        this.lastActiveTime = lastActiveTime;
    }



    public List<Integer> change2SampleCountList(){
        List<Integer> sampleCountBy2Hours =new ArrayList<>();
        sampleCountBy2Hours.add(getSampleCount0());
        sampleCountBy2Hours.add(getSampleCount2());
        sampleCountBy2Hours.add(getSampleCount4());
        sampleCountBy2Hours.add(getSampleCount6());
        sampleCountBy2Hours.add(getSampleCount8());
        sampleCountBy2Hours.add(getSampleCount10());
        sampleCountBy2Hours.add(getSampleCount12());
        sampleCountBy2Hours.add(getSampleCount14());
        sampleCountBy2Hours.add(getSampleCount16());
        sampleCountBy2Hours.add(getSampleCount18());
        sampleCountBy2Hours.add(getSampleCount20());
        sampleCountBy2Hours.add(getSampleCount22());
        return  sampleCountBy2Hours;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceinfoEntity that = (DeviceinfoEntity) o;

        if (deviceName != null ? !deviceName.equals(that.deviceName) : that.deviceName != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (lastQueryTime != null ? !lastQueryTime.equals(that.lastQueryTime) : that.lastQueryTime != null) return false;
        if (sampleSum != null ? !sampleSum.equals(that.sampleSum) : that.sampleSum != null) return false;
        if (sampleCount0 != null ? !sampleCount0.equals(that.sampleCount0) : that.sampleCount0 != null) return false;
        if (sampleCount2 != null ? !sampleCount2.equals(that.sampleCount2) : that.sampleCount2 != null) return false;
        if (sampleCount4 != null ? !sampleCount4.equals(that.sampleCount4) : that.sampleCount4 != null) return false;
        if (sampleCount6 != null ? !sampleCount6.equals(that.sampleCount6) : that.sampleCount6 != null) return false;
        if (sampleCount8 != null ? !sampleCount8.equals(that.sampleCount8) : that.sampleCount8 != null) return false;
        if (sampleCount10 != null ? !sampleCount10.equals(that.sampleCount10) : that.sampleCount10 != null) return false;
        if (sampleCount12 != null ? !sampleCount12.equals(that.sampleCount12) : that.sampleCount12 != null) return false;
        if (sampleCount14 != null ? !sampleCount14.equals(that.sampleCount14) : that.sampleCount14 != null) return false;
        if (sampleCount16 != null ? !sampleCount16.equals(that.sampleCount16) : that.sampleCount16 != null) return false;
        if (sampleCount18 != null ? !sampleCount18.equals(that.sampleCount18) : that.sampleCount18 != null) return false;
        if (sampleCount20 != null ? !sampleCount20.equals(that.sampleCount20) : that.sampleCount20 != null) return false;
        if (sampleCount22 != null ? !sampleCount22.equals(that.sampleCount22) : that.sampleCount22 != null) return false;
        if (averageDetectionTime != null ? !averageDetectionTime.equals(that.averageDetectionTime) : that.averageDetectionTime != null) return false;
        if (sampleDetectionQuality != null ? !sampleDetectionQuality.equals(that.sampleDetectionQuality) : that.sampleDetectionQuality != null) return false;
        if (lastActiveTime != null ? !lastActiveTime.equals(that.lastActiveTime) : that.lastActiveTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deviceName != null ? deviceName.hashCode() : 0;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (lastQueryTime != null ? lastQueryTime.hashCode() : 0);
        result = 31 * result + (sampleSum != null ? sampleSum.hashCode() : 0);
        result = 31 * result + (sampleCount0 != null ? sampleCount0.hashCode() : 0);
        result = 31 * result + (sampleCount2 != null ? sampleCount2.hashCode() : 0);
        result = 31 * result + (sampleCount4 != null ? sampleCount4.hashCode() : 0);
        result = 31 * result + (sampleCount6 != null ? sampleCount6.hashCode() : 0);
        result = 31 * result + (sampleCount8 != null ? sampleCount8.hashCode() : 0);
        result = 31 * result + (sampleCount10 != null ? sampleCount10.hashCode() : 0);
        result = 31 * result + (sampleCount12 != null ? sampleCount12.hashCode() : 0);
        result = 31 * result + (sampleCount14 != null ? sampleCount14.hashCode() : 0);
        result = 31 * result + (sampleCount16 != null ? sampleCount16.hashCode() : 0);
        result = 31 * result + (sampleCount18 != null ? sampleCount18.hashCode() : 0);
        result = 31 * result + (sampleCount20 != null ? sampleCount20.hashCode() : 0);
        result = 31 * result + (sampleCount22 != null ? sampleCount22.hashCode() : 0);
        result = 31 * result + (averageDetectionTime != null ? averageDetectionTime.hashCode() : 0);
        result = 31 * result + (sampleDetectionQuality != null ? sampleDetectionQuality.hashCode() : 0);
        result = 31 * result + (lastActiveTime != null ? lastActiveTime.hashCode() : 0);
        return result;
    }
}

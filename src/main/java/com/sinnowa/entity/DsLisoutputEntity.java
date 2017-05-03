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
@Table(name = "ds_lisoutput", schema = "middleware", catalog = "")
@IdClass(DsLisoutputEntityPK.class)
public class DsLisoutputEntity {
    private String sampleId;
    private String patientId;
    private String item;
    private String type;
    private Timestamp sendTime;
    private String device;
    private String fullName;
    private Double result;
    private String unit;
    private Double normalLow;
    private Double normalHigh;
    private Timestamp time;
    private String indicate;
    private Byte isGet;
    private String firstName;
    private String sex;
    private String age;
    private String sampleKind;
    private String doctor;
    private String area;
    private String bed;
    private String department;
    private Byte issend;

    @Id
    @Column(name = "SAMPLE_ID")
    public String getSampleId() {
        return sampleId;
    }

    public void setSampleId(String sampleId) {
        this.sampleId = sampleId;
    }

    @Basic
    @Column(name = "PATIENT_ID")
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    @Id
    @Column(name = "ITEM")
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Id
    @Column(name = "Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "SEND_TIME")
    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    @Id
    @Column(name = "Device")
    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
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
    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
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
    @Column(name = "NORMAL_LOW")
    public Double getNormalLow() {
        return normalLow;
    }

    public void setNormalLow(Double normalLow) {
        this.normalLow = normalLow;
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
    @Column(name = "TIME")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
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
    @Column(name = "IsGet")
    public Byte getIsGet() {
        return isGet;
    }

    public void setIsGet(Byte isGet) {
        this.isGet = isGet;
    }

    @Basic
    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "SEX")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "AGE")
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Basic
    @Column(name = "SAMPLE_KIND")
    public String getSampleKind() {
        return sampleKind;
    }

    public void setSampleKind(String sampleKind) {
        this.sampleKind = sampleKind;
    }

    @Basic
    @Column(name = "DOCTOR")
    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    @Basic
    @Column(name = "AREA")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Basic
    @Column(name = "BED")
    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    @Basic
    @Column(name = "DEPARTMENT")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Basic
    @Column(name = "ISSEND")
    public Byte getIssend() {
        return issend;
    }

    public void setIssend(Byte issend) {
        this.issend = issend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DsLisoutputEntity that = (DsLisoutputEntity) o;

        if (sampleId != null ? !sampleId.equals(that.sampleId) : that.sampleId != null) return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (item != null ? !item.equals(that.item) : that.item != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (sendTime != null ? !sendTime.equals(that.sendTime) : that.sendTime != null) return false;
        if (device != null ? !device.equals(that.device) : that.device != null) return false;
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null) return false;
        if (result != null ? !result.equals(that.result) : that.result != null) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;
        if (normalLow != null ? !normalLow.equals(that.normalLow) : that.normalLow != null) return false;
        if (normalHigh != null ? !normalHigh.equals(that.normalHigh) : that.normalHigh != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (indicate != null ? !indicate.equals(that.indicate) : that.indicate != null) return false;
        if (isGet != null ? !isGet.equals(that.isGet) : that.isGet != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (sampleKind != null ? !sampleKind.equals(that.sampleKind) : that.sampleKind != null) return false;
        if (doctor != null ? !doctor.equals(that.doctor) : that.doctor != null) return false;
        if (area != null ? !area.equals(that.area) : that.area != null) return false;
        if (bed != null ? !bed.equals(that.bed) : that.bed != null) return false;
        if (department != null ? !department.equals(that.department) : that.department != null) return false;
        if (issend != null ? !issend.equals(that.issend) : that.issend != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = sampleId != null ? sampleId.hashCode() : 0;
        result1 = 31 * result1 + (patientId != null ? patientId.hashCode() : 0);
        result1 = 31 * result1 + (item != null ? item.hashCode() : 0);
        result1 = 31 * result1 + (type != null ? type.hashCode() : 0);
        result1 = 31 * result1 + (sendTime != null ? sendTime.hashCode() : 0);
        result1 = 31 * result1 + (device != null ? device.hashCode() : 0);
        result1 = 31 * result1 + (fullName != null ? fullName.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (unit != null ? unit.hashCode() : 0);
        result1 = 31 * result1 + (normalLow != null ? normalLow.hashCode() : 0);
        result1 = 31 * result1 + (normalHigh != null ? normalHigh.hashCode() : 0);
        result1 = 31 * result1 + (time != null ? time.hashCode() : 0);
        result1 = 31 * result1 + (indicate != null ? indicate.hashCode() : 0);
        result1 = 31 * result1 + (isGet != null ? isGet.hashCode() : 0);
        result1 = 31 * result1 + (firstName != null ? firstName.hashCode() : 0);
        result1 = 31 * result1 + (sex != null ? sex.hashCode() : 0);
        result1 = 31 * result1 + (age != null ? age.hashCode() : 0);
        result1 = 31 * result1 + (sampleKind != null ? sampleKind.hashCode() : 0);
        result1 = 31 * result1 + (doctor != null ? doctor.hashCode() : 0);
        result1 = 31 * result1 + (area != null ? area.hashCode() : 0);
        result1 = 31 * result1 + (bed != null ? bed.hashCode() : 0);
        result1 = 31 * result1 + (department != null ? department.hashCode() : 0);
        result1 = 31 * result1 + (issend != null ? issend.hashCode() : 0);
        return result1;
    }
}

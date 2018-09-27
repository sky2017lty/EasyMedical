package com.study.litianyi.easymedical2;

import org.litepal.crud.LitePalSupport;

import java.util.UUID;

public class AttentionList extends LitePalSupport{
    private UUID mAttentionUUID;
    private String mHospitalName;
    private String mDepartmentName;
    private String mDoctorName;

    public AttentionList(){
        mAttentionUUID = UUID.randomUUID();
    }

    public UUID getAttentionUUID() {
        return mAttentionUUID;
    }

    public String getHospitalName() {
        return mHospitalName;
    }

    public void setHospitalName(String hospitalName) {
        mHospitalName = hospitalName;
    }

    public String getDepartmentName() {
        return mDepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        mDepartmentName = departmentName;
    }

    public String getDoctorName() {
        return mDoctorName;
    }

    public void setDoctorName(String doctorName) {
        mDoctorName = doctorName;
    }
}

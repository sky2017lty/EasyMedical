package com.study.litianyi.easymedical2;

import org.litepal.crud.DataSupport;
import org.litepal.crud.LitePalSupport;

import java.util.UUID;

public class Doctor extends LitePalSupport {
    private UUID mDoctorUUID;
    private String mDoctorName;
    private String mDoctorAbstract;

    public Doctor(){
        mDoctorUUID = UUID.randomUUID();
    }

    public UUID getDoctorUUID() {
        return mDoctorUUID;
    }

    public String getDoctorName() {
        return mDoctorName;
    }

    public void setDoctorName(String doctorName) {
        mDoctorName = doctorName;
    }

    public String getDoctorAbstract() {
        return mDoctorAbstract;
    }

    public void setDoctorAbstract(String doctorAbstract) {
        mDoctorAbstract = doctorAbstract;
    }
}

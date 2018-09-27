package com.study.litianyi.easymedical2;

import org.litepal.crud.DataSupport;
import org.litepal.crud.LitePalSupport;

import java.util.UUID;

public class Hospital extends LitePalSupport {
    private UUID mHospitalUUID;                 //医院ID
    private String mHospitalName;               //医院名称
    private String mHospitalAbstract;           //医院简介
    private String mHospitalAnnouncement;       //医院公告
    private String mHospitalPhone;              //医院联系方式
    private String mHospitalWorkTime;           //医院营业时间

    public Hospital(){
        mHospitalUUID = UUID.randomUUID();
    } //创建随机id

    public UUID getHospitalUUID() {
        return mHospitalUUID;
    }

    public String getHospitalName() {
        return mHospitalName;
    }  //取出医院名

    public void setHospitalName(String hospitalName) {
        mHospitalName = hospitalName;
    }  //向对象存储医院名

    public String getHospitalAbstract() {
        return mHospitalAbstract;
    }

    public void setHospitalAbstract(String hospitalAbstract) {
        mHospitalAbstract = hospitalAbstract;
    }

    public String getHospitalAnnouncement() {
        return mHospitalAnnouncement;
    }

    public void setHospitalAnnouncement(String hospitalAnnouncement) {
        mHospitalAnnouncement = hospitalAnnouncement;
    }

    public String getHospitalPhone() {
        return mHospitalPhone;
    }

    public void setHospitalPhone(String hospitalPhone) {
        mHospitalPhone = hospitalPhone;
    }

    public String getHospitalWorkTime() {
        return mHospitalWorkTime;
    }

    public void setHospitalWorkTime(String hospitalWorkTime) {
        mHospitalWorkTime = hospitalWorkTime;
    }
}

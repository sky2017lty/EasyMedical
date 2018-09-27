package com.study.litianyi.easymedical2;

import org.litepal.crud.DataSupport;
import org.litepal.crud.LitePalSupport;

import java.util.UUID;

public class Department extends LitePalSupport {

    private UUID mDepartmentUUID;
    private String mDepartmentName;
    private String mDepartmentAbstract;
    private String mDepartmentAnnouncement;

    public Department(){
        mDepartmentUUID = UUID.randomUUID();
    }

    public UUID getDepartmentUUID() {
        return mDepartmentUUID;
    }

    public String getDepartmentName() {
        return mDepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        mDepartmentName = departmentName;
    }

    public String getDepartmentAbstract() {
        return mDepartmentAbstract;
    }

    public void setDepartmentAbstract(String departmentAbstract) {
        mDepartmentAbstract = departmentAbstract;
    }

    public String getDepartmentAnnouncement() {
        return mDepartmentAnnouncement;
    }

    public void setDepartmentAnnouncement(String departmentAnnouncement) {
        mDepartmentAnnouncement = departmentAnnouncement;
    }
}

package com.study.litianyi.easymedical2;

import org.litepal.crud.DataSupport;
import org.litepal.crud.LitePalSupport;

import java.util.UUID;

public class Ill extends LitePalSupport {
    private UUID mIllUUID;
    private String mIllName;
    private String mIllType;
    private String mIllTrait;   //症状

    public void Ill(){
        mIllUUID = UUID.randomUUID();
    }

    public UUID getIllUUID() {
        return mIllUUID;
    }

    public String getIllName() {
        return mIllName;
    }

    public void setIllName(String illName) {
        mIllName = illName;
    }

    public String getIllType() {
        return mIllType;
    }

    public void setIllType(String illType) {
        mIllType = illType;
    }

    public String getIllTrait() {
        return mIllTrait;
    }

    public void setIllTrait(String illTrait) {
        mIllTrait = illTrait;
    }
}

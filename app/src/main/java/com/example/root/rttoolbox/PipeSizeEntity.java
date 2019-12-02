package com.example.root.rttoolbox;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

@Entity(tableName = "pipe_table")
public class PipeSizeEntity {

    //NPS pipe size
    @PrimaryKey
    @NonNull
    private String mNPSPipeSize;

    //DN pipe size
    private String mDNPipeSize;

    //Outside Diameter Imperial
    private String mOutsideDiameterImp;

    //Outside Diameter Metric
    private String mOutsideDiameterMet;

    //Size category for schedule table selection
    private int mSizeCategory;

    //Various Pipe Schedules, Imperial and Metric
    private String msched5i;
    private String msched5m;
    private String msched10i;
    private String msched10m;
    private String msched20i;
    private String msched20m;
    private String msched30i;
    private String msched30m;
    private String msched40i;
    private String msched40m;
    private String msched60i;
    private String msched60m;
    private String msched80i;
    private String msched80m;
    private String msched100i;
    private String msched100m;
    private String msched120i;
    private String msched120m;
    private String msched140i;
    private String msched140m;
    private String msched160i;
    private String msched160m;
    private String mschedSTDi;
    private String mschedSTDm;
    private String mschedXSi;
    private String mschedXSm;
    private String mschedXXSi;
    private String mschedXXSm;

    public void setmNPSPipeSize(@NonNull String mNPSPipeSize) {
        this.mNPSPipeSize = mNPSPipeSize;
    }

    public void setmDNPipeSize(String mDNPipeSize) {
        this.mDNPipeSize = mDNPipeSize;
    }

    public void setmOutsideDiameterImp(String mOutsideDiameterImp) {
        this.mOutsideDiameterImp = mOutsideDiameterImp;
    }

    public void setmOutsideDiameterMet(String mOutsideDiameterMet) {
        this.mOutsideDiameterMet = mOutsideDiameterMet;
    }

    public void setmSizeCategory(int mSizeCategory) {
        this.mSizeCategory = mSizeCategory;
    }

    public void setMsched5i(String msched5i) {
        this.msched5i = msched5i;
    }

    public void setMsched5m(String msched5m) {
        this.msched5m = msched5m;
    }

    public void setMsched10i(String msched10i) {
        this.msched10i = msched10i;
    }

    public void setMsched10m(String msched10m) {
        this.msched10m = msched10m;
    }

    public void setMsched20i(String msched20i) {
        this.msched20i = msched20i;
    }

    public void setMsched20m(String msched20m) {
        this.msched20m = msched20m;
    }

    public void setMsched30i(String msched30i) {
        this.msched30i = msched30i;
    }

    public void setMsched30m(String msched30m) {
        this.msched30m = msched30m;
    }

    public void setMsched40i(String msched40i) {
        this.msched40i = msched40i;
    }

    public void setMsched40m(String msched40m) {
        this.msched40m = msched40m;
    }

    public void setMsched60i(String msched60i) {
        this.msched60i = msched60i;
    }

    public void setMsched60m(String msched60m) {
        this.msched60m = msched60m;
    }

    public void setMsched80i(String msched80i) {
        this.msched80i = msched80i;
    }

    public void setMsched80m(String msched80m) {
        this.msched80m = msched80m;
    }

    public void setMsched100i(String msched100i) {
        this.msched100i = msched100i;
    }

    public void setMsched100m(String msched100m) {
        this.msched100m = msched100m;
    }

    public void setMsched120i(String msched120i) {
        this.msched120i = msched120i;
    }

    public void setMsched120m(String msched120m) {
        this.msched120m = msched120m;
    }

    public void setMsched140i(String msched140i) {
        this.msched140i = msched140i;
    }

    public void setMsched140m(String msched140m) {
        this.msched140m = msched140m;
    }

    public void setMsched160i(String msched160i) {
        this.msched160i = msched160i;
    }

    public void setMsched160m(String msched160m) {
        this.msched160m = msched160m;
    }

    public void setMschedSTDi(String mschedSTDi) {
        this.mschedSTDi = mschedSTDi;
    }

    public void setMschedSTDm(String mschedSTDm) {
        this.mschedSTDm = mschedSTDm;
    }

    public void setMschedXSi(String mschedXSi) {
        this.mschedXSi = mschedXSi;
    }

    public void setMschedXSm(String mschedXSm) {
        this.mschedXSm = mschedXSm;
    }

    public void setMschedXXSi(String mschedXXSi) {
        this.mschedXXSi = mschedXXSi;
    }

    public void setMschedXXSm(String mschedXXSm) {
        this.mschedXXSm = mschedXXSm;
    }

    @NonNull
    public String getMNPSPipeSize() { return this.mNPSPipeSize;}

    public String getMDNPipeSize() { return this.mDNPipeSize;}

    public String getMOutsideDiameterImp() {return this.mOutsideDiameterImp;}

    public String getMOutsideDiameterMet() {return this.mOutsideDiameterMet;}

    public int getMSizeCategory() {
        return this.mSizeCategory;
    }

    public String getMsched5i() {
        return this.msched5i;
    }

    public String getMsched5m() {
        return this.msched5m;
    }

    public String getMsched10i() {
        return this.msched10i;
    }

    public String getMsched10m() {
        return this.msched10m;
    }

    public String getMsched20i() {
        return this.msched20i;
    }

    public String getMsched20m() {
        return this.msched20m;
    }

    public String getMsched30i() {
        return this.msched30i;
    }

    public String getMsched30m() {
        return this.msched30m;
    }

    public String getMsched40i() {
        return this.msched40i;
    }

    public String getMsched40m() {
        return this.msched40m;
    }

    public String getMsched60i() {
        return this.msched60i;
    }

    public String getMsched60m() {
        return this.msched60m;
    }

    public String getMsched80i() {
        return this.msched80i;
    }

    public String getMsched80m() {
        return this.msched80m;
    }

    public String getMsched100i() {
        return this.msched100i;
    }

    public String getMsched100m() {
        return this.msched100m;
    }

    public String getMsched120i() {
        return this.msched120i;
    }

    public String getMsched120m() {
        return this.msched120m;
    }

    public String getMsched140i() {
        return this.msched140i;
    }

    public String getMsched140m() {
        return this.msched140m;
    }

    public String getMsched160i() {
        return this.msched160i;
    }

    public String getMsched160m() {
        return this.msched160m;
    }

    public String getMschedSTDi() {
        return this.mschedSTDi;
    }

    public String getMschedSTDm() {
        return this.mschedSTDm;
    }

    public String getMschedXSi() {
        return this.mschedXSi;
    }

    public String getMschedXSm() {
        return this.mschedXSm;
    }

    public String getMschedXXSi() {
        return this.mschedXXSi;
    }

    public String getMschedXXSm() {
        return this.mschedXXSm;
    }

    public PipeSizeEntity(@NonNull String mNPSPipeSize, String mDNPipeSize, String mOutsideDiameterImp, String mOutsideDiameterMet, int mSizeCategory, String msched5i, String msched5m, String msched10i, String msched10m, String msched20i, String msched20m, String msched30i, String msched30m, String msched40i, String msched40m, String msched60i, String msched60m, String msched80i, String msched80m, String msched100i, String msched100m, String msched120i, String msched120m, String msched140i, String msched140m, String msched160i, String msched160m, String mschedSTDi, String mschedSTDm, String mschedXSi, String mschedXSm, String mschedXXSi, String mschedXXSm) {
        this.mNPSPipeSize = mNPSPipeSize;
        this.mDNPipeSize = mDNPipeSize;
        this.mOutsideDiameterImp = mOutsideDiameterImp;
        this.mOutsideDiameterMet = mOutsideDiameterMet;
        //this.mSizeCategory = mSizeCategory;
        this.msched5i = msched5i;
        this.msched5m = msched5m;
        this.msched10i = msched10i;
        this.msched10m = msched10m;
        this.msched20i = msched20i;
        this.msched20m = msched20m;
        this.msched30i = msched30i;
        this.msched30m = msched30m;
        this.msched40i = msched40i;
        this.msched40m = msched40m;
        this.msched60i = msched60i;
        this.msched60m = msched60m;
        this.msched80i = msched80i;
        this.msched80m = msched80m;
        this.msched100i = msched100i;
        this.msched100m = msched100m;
        this.msched120i = msched120i;
        this.msched120m = msched120m;
        this.msched140i = msched140i;
        this.msched140m = msched140m;
        this.msched160i = msched160i;
        this.msched160m = msched160m;
        this.mschedSTDi = mschedSTDi;
        this.mschedSTDm = mschedSTDm;
        this.mschedXSi = mschedXSi;
        this.mschedXSm = mschedXSm;
        this.mschedXXSi = mschedXXSi;
        this.mschedXXSm = mschedXXSm;
    }
}



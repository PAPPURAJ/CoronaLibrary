package com.blogspot.prajbtc.coronalibrary;

import java.util.ArrayList;

public class Report {
    private boolean isSuccess;
    private ArrayList<ReportList> arrayList;

    public Report(boolean isSuccess, ArrayList<ReportList> arrayList) {
        this.isSuccess = isSuccess;
        this.arrayList = arrayList;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public ArrayList<ReportList> getArrayList() {
        return arrayList;
    }


}

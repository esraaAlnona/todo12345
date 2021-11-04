package com.example.myapp.model.models;

import com.google.gson.annotations.SerializedName;

public class ToDoModel {

    @SerializedName("tagPortalUserId")
    private int mUserId;
    @SerializedName("taskName")
    private String mTaskName;
    @SerializedName("desc")
    private String mDesc;
    @SerializedName("status")
    private int mStatus;


    public ToDoModel(){

    }

    public ToDoModel(String taskName, String desc, int status, int userId){

        mTaskName = taskName;
        mDesc =desc;
        mStatus = status;
        mUserId = userId;

    }

    public int getmUserId() {
        return mUserId;
    }

    public void setmUserId(int mUserId) {
        this.mUserId = mUserId;
    }

    public String getmTaskName() {
        return mTaskName;
    }

    public void setmTaskName(String mTaskName) {
        this.mTaskName = mTaskName;
    }

    public String getmDesc() {
        return mDesc;
    }

    public void setmDesc(String mDesc) {
        this.mDesc = mDesc;
    }

    public int getmStatus() {
        return mStatus;
    }

    public void setmStatus(int mStatus) {
        this.mStatus = mStatus;
    }
}

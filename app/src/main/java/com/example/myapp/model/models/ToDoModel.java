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


    public ToDoModel(String taskName, String desc, int status, int userId){

        mTaskName = taskName;
        mDesc =desc;
        mStatus = status;
        mUserId = userId;

    }


    public String getmTaskName() {
        return mTaskName;
    }

    public String getmDesc() {
        return mDesc;
    }

    public int getmStatus() {
        return mStatus;
    }

    public int getmUserId() {
        return mUserId;
    }
}

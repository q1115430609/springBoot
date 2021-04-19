package com.example.springboot.entity;

import java.util.Date;

public class ConsumingRecords {
    public String id;
    public String userId;
    public Date date;
    public String speOrIncType;
    public Double amount;
    public String note;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSpeOrIncType() {
        return speOrIncType;
    }

    public void setSpeOrIncType(String speOrIncType) {
        this.speOrIncType = speOrIncType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

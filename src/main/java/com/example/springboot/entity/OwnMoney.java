package com.example.springboot.entity;

public class OwnMoney {
    public String id;
    public String userId;
    public int spendOrIncome;
    public int amount;
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

    public int getSpendOrIncome() {
        return spendOrIncome;
    }

    public void setSpendOrIncome(int spendOrIncome) {
        this.spendOrIncome = spendOrIncome;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

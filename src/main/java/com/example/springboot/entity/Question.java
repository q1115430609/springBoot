package com.example.springboot.entity;

public class Question {
    public String questionId;
    public String questionNo;
    public String questionName;
    public String questionCorrectAnswer;
    public String questionAnswerDescribe;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(String questionNo) {
        this.questionNo = questionNo;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionCorrectAnswer() {
        return questionCorrectAnswer;
    }

    public void setQuestionCorrectAnswer(String questionCorrectAnswer) {
        this.questionCorrectAnswer = questionCorrectAnswer;
    }

    public String getQuestionAnswerDescribe() {
        return questionAnswerDescribe;
    }

    public void setQuestionAnswerDescribe(String questionAnswerDescribe) {
        this.questionAnswerDescribe = questionAnswerDescribe;
    }
}

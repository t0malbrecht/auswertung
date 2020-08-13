package com.company.services;

public class QuestionObject {
    public int number;
    public String name;
    public int code;
    public boolean inverted;

    public QuestionObject(int number, String name, int code, boolean inverted) {
        this.number = number;
        this.name = name;
        this.code = code;
        this.inverted = inverted;
    }
}

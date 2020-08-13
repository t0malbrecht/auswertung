package com.company.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnswerObject {
    HashMap<Integer, Integer> answers;
    ArrayList<String> otherAnswers;

    public AnswerObject(HashMap<Integer, Integer> answers, ArrayList<String> otherAnswers){
        this.answers = answers;
        this.otherAnswers = otherAnswers;
    }
}

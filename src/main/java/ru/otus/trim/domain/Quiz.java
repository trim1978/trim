package ru.otus.trim.domain;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private List<Question> questions = new ArrayList<Question>();

    public Quiz (List<Question> questions){
        this.questions.addAll (questions);
    }

    public List<Question> getQuestions() {
        return new ArrayList<Question> (questions);
    }
}

package ru.otus.trim.dao;

import ru.otus.trim.domain.Quiz;
import ru.otus.trim.domain.QuizAction;

public class QuizActionDaoSimple implements QuizActionDao{
    @Override
    public QuizAction getQuizAction(Quiz quiz) {
        return new QuizAction (quiz);
    }
}

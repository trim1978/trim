package ru.otus.trim.service;

import ru.otus.trim.domain.QuizAction;

public class QuizCheckServiceFromConfig implements QuizCheckService{
    public final int checkCriterion;

    public QuizCheckServiceFromConfig(int checkCriterion) {
        this.checkCriterion = checkCriterion;
    }

    @Override
    public boolean checkQuizAction(QuizAction quizAction) {
        return quizAction.isComplete() && quizAction.getRightAnsweredQuestionsCount() >= checkCriterion;  }
}

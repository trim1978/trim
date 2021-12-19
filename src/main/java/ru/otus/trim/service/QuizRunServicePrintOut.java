package ru.otus.trim.service;

import ru.otus.trim.dao.QuizDao;

public class QuizRunServicePrintOut implements QuizRunService{

    final QuizDao quizDao;

    public QuizRunServicePrintOut (QuizDao dao){
        this.quizDao = dao;
    }

    @Override
    public void runQuiz() {
        quizDao.getQuiz().getQuestions().stream().forEach(t -> System.out.println(t.question));
    }
}

package ru.otus.trim.service;

import ru.otus.trim.dao.QuizDao;

public class QuizOutServiceToConsole implements QuizOutService {

    final QuizDao quizDao;

    public QuizOutServiceToConsole(QuizDao dao){
        this.quizDao = dao;
    }

    @Override
    public void outQuiz() {
        quizDao.getQuiz().getQuestions().stream().forEach(t -> System.out.println(t.question));
    }
}

package ru.otus.trim.dao;

import ru.otus.trim.domain.Quiz;
import ru.otus.trim.domain.QuizAction;

public interface QuizActionDao {
    QuizAction getQuizAction (Quiz quiz);
}

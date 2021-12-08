package ru.otus.trim.domain;

public class Answer {
    public final Question question;
    public final int answer;
    public final String answerText;

    public Answer(Question question, int answer, String answerText) {
        this.question = question;
        this.answer = answer;
        this.answerText = answerText;
    }
}

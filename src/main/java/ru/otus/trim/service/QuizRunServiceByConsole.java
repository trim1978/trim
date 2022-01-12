package ru.otus.trim.service;

import ru.otus.trim.dao.QuizDao;
import ru.otus.trim.domain.Answer;
import ru.otus.trim.domain.Question;
import ru.otus.trim.domain.QuizAction;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class QuizRunServiceByConsole implements QuizRunService {
    final QuizDao quizDao;
    //final QuizActionDao quizActionDao;
    public QuizRunServiceByConsole(QuizDao dao){
        this.quizDao = dao;
        //this.quizActionDao = quizActionDao;
    }
    @Override
    public QuizAction runQuiz() {
        QuizAction quizAction = quizDao.getQuiz().createQuizAction();
        runQuiz(quizAction);
        System.out.println(quizAction.isComplete() + " " + quizAction.getRightAnsweredQuestionsCount());
        return quizAction;
    }

    private void runQuiz (QuizAction quizAction){
        quizAction.quiz.getQuestions().stream().forEach(t -> quizAction.setAnswers(t, runQuestion(t)));
    }

    private List<Answer> outQuestion (Question question){
        System.out.println(question.question + " ?");
        int count = 0;
        List<Answer> answers = question.getAnswers();
        for (Answer a : answers){
            System.out.println((++count)+ ". " + a.answerText);
        }
        return answers;
    }

    private String [] readAnswers (){
        System.out.print("Your answer is: ");
        Scanner scaner = new Scanner(System.in);
        String answer = scaner.nextLine();
        String [] tokens = answer.split(" ");
        return tokens;
    }

    private HashSet<Answer> getAnswers (List<Answer> answers, String [] tokens){
        HashSet<Answer> result = new HashSet<Answer>(tokens.length);
        for (String a : tokens){
            int num = Integer.valueOf(a);
            if (num >= 1 && num <= answers.size()) result.add(answers.get(num - 1));
        }
        return result;

    }

    private Set<Answer> runQuestion (Question question){
        List<Answer> answers = outQuestion (question);
        String [] tokens = readAnswers();
        return getAnswers (answers, tokens);
    }
}

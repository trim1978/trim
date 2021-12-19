package ru.otus.trim;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.trim.service.QuestionsService;
import ru.otus.trim.service.QuizRunService;
import ru.otus.trim.service.QuizService;

public class Homework01Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        QuizRunService service = context.getBean(QuizRunService.class);
        service.runQuiz();
    }
}

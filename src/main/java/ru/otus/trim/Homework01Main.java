package ru.otus.trim;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.trim.service.QuizOutService;

public class Homework01Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        QuizOutService service = context.getBean(QuizOutService.class);
        service.outQuiz();
    }
}

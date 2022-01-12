package ru.otus.trim;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.trim.domain.QuizAction;
import ru.otus.trim.domain.Student;
import ru.otus.trim.service.QuizCheckService;
import ru.otus.trim.service.QuizOutService;
import ru.otus.trim.service.QuizRunService;
import ru.otus.trim.service.StudentRequestService;

public class Homework02Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        StudentRequestService studentRequest = context.getBean(StudentRequestService.class);
        Student student = studentRequest.requestStudent();

        QuizRunService runService = context.getBean(QuizRunService.class);
        QuizAction quizAction = runService.runQuiz();

        QuizCheckService checkService = context.getBean(QuizCheckService.class);
        boolean result = checkService.checkQuizAction (quizAction);

        System.out.println("Quiz is " + (result ? "OK" : "fault"));

    }
}

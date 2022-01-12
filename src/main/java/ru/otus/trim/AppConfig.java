package ru.otus.trim;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.trim.dao.QuizDao;
import ru.otus.trim.dao.QuizDaoSimple;
import ru.otus.trim.service.*;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    QuizService createQuestionsService (@Value("${quiz.file}") String fileName){
        return new QuizServiceFromCSV(fileName);
    }

    @Bean
    QuizDao createQuizDao (QuizService quizService){
        return new QuizDaoSimple(quizService);
    }

    //@Bean
    //QuizActionDao createQuizActionDao (){
        //return new QuizActionDaoSimple();
    //}

    @Bean
    QuizOutService createRunService (QuizDao quizDao){
        return new QuizOutServiceToConsole(quizDao);
    }

    @Bean
    StudentRequestService createRequestService (){
        return new StudentRequestServiceByInput();
    }

    @Bean
    QuizRunService createQuizActionService (QuizDao quizDao){ return new QuizRunServiceByConsole(quizDao); }

    @Bean
    QuizCheckService createQuizCheckService (@Value("${quiz.enough}") int checkCriterion){return new QuizCheckServiceFromConfig(checkCriterion);}
}

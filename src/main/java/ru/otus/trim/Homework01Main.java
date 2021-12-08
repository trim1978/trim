package ru.otus.trim;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.trim.service.QuestionsService;

public class Homework01Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        QuestionsService service = context.getBean(QuestionsService.class);
        service.printQuestions();
        /*
        //ResourceLoader resourceLoader = new DefaultResourceLoader();
        //Resource resource = resourceLoader.getResource("classpath:questions.csv");
        Resource resource = context.getResource("questions.csv");

        try (BufferedReader is = new BufferedReader(new InputStreamReader (resource.getInputStream())))
        {
            String q = "";
            while ((q = is.readLine()) != null){
                Question question = new Question(q);
                System.out.println("----------------------------");
                question.out(System.out);
            }

            //String [] ret = "".split(",");
        } catch (IOException e) {
            e.printStackTrace();
        }
        *
         */
    }
}

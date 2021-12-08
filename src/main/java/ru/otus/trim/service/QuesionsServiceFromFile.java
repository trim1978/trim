package ru.otus.trim.service;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import ru.otus.trim.dao.QuestionDao;
import ru.otus.trim.domain.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class QuesionsServiceFromFile implements QuestionsService {
    private final ArrayList<QuestionDao> questions = new ArrayList<QuestionDao> ();
    private String fileName;
    public QuesionsServiceFromFile(){

    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
// TODO
        System.out.println("FILENAME " + fileName);
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:"+fileName);

        try (BufferedReader is = new BufferedReader(new InputStreamReader(resource.getInputStream())))
        {
            String q = "";
            while ((q = is.readLine()) != null){
                Question question = new Question(q);
                //System.out.println("----------------------------");
                questions.add(question);
            }

            //String [] ret = "".split(",");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void printQuestions() {
        questions.stream().forEach(t -> t.out (System.out));
    }
}

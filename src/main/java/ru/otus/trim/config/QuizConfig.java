package ru.otus.trim.config;

//import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@ConfigurationProperties(prefix = "quiz")
@Component
public class QuizConfig {

    private String file;

    private int enough;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getEnough() {
        return enough;
    }

    public void setEnough(int enough) {
        this.enough = enough;
    }
}

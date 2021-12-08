package ru.otus.trim.domain;

import ru.otus.trim.dao.QuestionDao;

import java.io.PrintStream;

public class Question implements QuestionDao {
    public final String question;

    private final String [] answers;

    public final boolean neewFreeAnswer;

    public Question(String question, String [] answers, boolean neewFreeAnswer) {
        this.question = question;
        this.answers = answers;
        this.neewFreeAnswer = neewFreeAnswer;
    }

    public Question (String line){
        String [] tokens = line.split(",");
        String [] ans = new String [tokens.length-1];
        System.arraycopy(tokens,1, ans, 0, ans.length);

        this.question = tokens [0];
        this.answers = ans;
        this.neewFreeAnswer = line.endsWith(",");
    }

    @Override
    public String toString() {
        return question +" ?";
    }

    @Override
    public void out (PrintStream ps){
        ps.println(toString());
        for (int i=0;i<answers.length;i++){
            ps.println((i+1) + ". " + answers [i]);

        }
        if (neewFreeAnswer && answers.length > 0) {
            ps.println(answers.length + ". " + "Your answer:");
        }
    }

}

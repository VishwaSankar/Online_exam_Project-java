package onlineexam;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
class Question {
    private String text;
    private List<String> options;
    private int correctOption;

    public Question(String text, List<String> options, int correctOption) {
        this.text = text;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getText() {
        return text;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}


package onlineexam;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
class Exam {
    private List<Question> questions;
    private int score;

    public Exam(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void takeExam() {
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getText());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println(i + 1 + ". " + options.get(i));
            }

            System.out.print("Enter your choice: ");
            int userChoice = scanner.nextInt();

            if (userChoice == question.getCorrectOption()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + (question.getCorrectOption() + 1) + "\n");
            }
        }

        System.out.println("Exam completed! Your score: " + score + " out of " + questions.size());
    }
}

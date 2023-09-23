package onlineexam;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class OnlineExaminationSystem {
    private static User currentUser;
    private static List<User> users = new ArrayList<>();
    private static List<Question> questions = new ArrayList<>();
    private static Timer timer;

    public static void main(String[] args) {
        initializeData();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Online Examination System!");

        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    currentUser = login();
                    if (currentUser != null) {
                        startExam();
                    }
                    break;
                case 2:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeData() {
        // Initialize users (in-memory)
        users.add(new User("user1", "password1", "John Doe"));
        users.add(new User("user2", "password2", "Jane Smith"));

        // Initialize questions (in-memory)
        List<String> options1 = new ArrayList<>();
        options1.add("Option A");
        options1.add("Option B");
        options1.add("Option C");
        options1.add("Option D");
        questions.add(new Question("What is 2 + 2?", options1, 3));

        List<String> options2 = new ArrayList<>();
        options2.add("Option A");
        options2.add("Option B");
        options2.add("Option C");
        options2.add("Option D");
        questions.add(new Question("What is 5 - 3?", options2, 0));

        // Initialize the timer (60 minutes for the entire exam)
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up! The exam has been auto-submitted.");
                System.exit(0);
            }
        }, 60 * 60 * 1000); // 60 minutes in milliseconds
    }

    private static User login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successful. Welcome, " + user.getName() + "!");
                return user;
            }
        }

        System.out.println("Login failed. Invalid username or password.");
        return null;
    }

    private static void startExam() {
        System.out.println("You may now begin the exam.");
        Exam exam = new Exam(questions);
        exam.takeExam();
        timer.cancel(); // Cancel the timer as the exam is completed
    }
}
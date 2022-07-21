package Main;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String question;
        String answer;
        int score;

        System.out.println("111");
        System.out.println("Введите вопрос");
        question = scanner.nextLine();
        System.out.println("Введите правильный вариант ответа");
        answer = scanner.next();
        System.out.println("Введите баллы за вопрос");
        score = scanner.nextInt();
        System.out.println("Вопрос успешно добавлен");


        System.out.println(question);
        System.out.println(answer);
        System.out.println(score);
    }
}

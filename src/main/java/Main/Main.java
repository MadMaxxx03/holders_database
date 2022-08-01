package Main;

import BL.HibernateUtil;
import BL.TransactionHelper;
import Classes.Holder;
import Classes.PassedTest;
import Classes.Question;
import Classes.Test;
import DAO.HolderDAO;
import DAO.PassedTestDAO;
import DAO.QuestionDAO;
import DAO.TestDAO;
import Service.HolderService;
import Service.PassedTestService;
import Service.QuestionService;
import Service.TestService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.imageio.spi.ServiceRegistry;
import java.security.Provider;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.*;


public class Main {

    public static void main(String[] args) throws SQLException {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        HolderService holderService = new HolderService(sessionFactory, new HolderDAO(sessionFactory));
        PassedTestService passedTestService = new PassedTestService(sessionFactory, new PassedTestDAO(sessionFactory));
        QuestionService questionService = new QuestionService(sessionFactory, new QuestionDAO(sessionFactory));
        TestService testService = new TestService(sessionFactory, new TestDAO(sessionFactory));


        Holder holder = new Holder();
        PassedTest passedTest = new PassedTest();
        Question question = new Question();
        Test test = new Test();

        Set<PassedTest> passedTests = new HashSet<>();
        holder.setPassedTests(passedTests);

        Set<Test> tests = new HashSet<>();
        holder.setTests(tests);

        Set<Question> questions = new HashSet<>();
        test.setQuestions(questions);

        test.setPassedTests(passedTests);

        /*
        holder.sethId(1);
        holder.setRole(true);
        holder.setName("max");
        holder.setPassword("2003");

        test.setHolder(holder);
        test.settId(2);

        question.setTest(test);
        question.setQuestion("1");
        question.setScore(1);
        question.setAnswer("b");

        testService.add(test);
        questionService.add(question);
        */


        int[] option = new int[]{0,0,0};
        Scanner scanner = new Scanner(System.in);
        String name = "";
        String password = "";
        int id = 0;
        while (option[0] != 3){
            System.out.println("Выберите опцию:");
            System.out.println("1 - Создать аккаунт");
            System.out.println("2 - Войти в аккаунт");
            System.out.println("3 - Выйти из прграммы");
            option[0] = scanner.nextInt();

            //Создание аккаунта
            if (option[0] == 1){
                List<Holder> holderList = holderService.getAll();
                boolean[] isFreeUser = new boolean[]{false,false,false,false};

                //Проверка id на повтор
                while (!isFreeUser[0]){
                    System.out.println("Придумайте ID пользователя:");
                    id = scanner.nextInt();

                    for (Holder value : holderList) {
                        if (value.gethId() == id) {
                            isFreeUser[2] = true;
                            System.out.println("ID уже занят");
                            break;
                        }
                    }
                    if (isFreeUser[2]){
                        isFreeUser[2] = false;
                    }
                    else {
                        isFreeUser[0] = true;
                    }
                }

                //Проверка имени пользователя на повтор
                while (!isFreeUser[1]){
                    System.out.println("Придумайте имя пользователя:");
                    name = scanner.next();

                    for (Holder value : holderList) {
                        if (name.equals(value.getName())) {
                            isFreeUser[3] = true;
                            System.out.println("Имя пользователя уже занято");
                            break;
                        }
                    }
                    if (isFreeUser[3]){
                        isFreeUser[3] = false;
                    }
                    else {
                        isFreeUser[1] = true;
                    }
                }

                System.out.println("Придумайте пароль пользователя:");
                password = scanner.next();

                holder.sethId(id);
                holder.setName(name);
                holder.setPassword(password);
                holder.setRole(false);

                holderService.add(holder);

                System.out.println("Вы успешно создали аккаунт");
            }

            //Вход в аккуунт
            else if (option[0] == 2){
                List<Holder> holderList = holderService.getAll();
                boolean isLogin = false;

                while (!isLogin){
                    System.out.println("Ведите имя пользователя:");
                    name = scanner.next();
                    System.out.println("Ведите пароль пользователя:");
                    password = scanner.next();

                    for (Holder value : holderList) {
                        if (name.equals(value.getName())){
                            if (password.equals(value.getPassword())){
                                holder = value;
                                isLogin = true;
                                System.out.println("Вы успешно вошли в аккаунт");
                                break;
                            }
                        }
                    }
                    if (!isLogin){
                        System.out.println("Неверное имя пользователся или пароль");
                    }
                }

                //Проверка на права пользователя
                if (holder.isRole()){
                    System.out.println("Вы имеете права администратора");

                    //Меню с выбором действий для админа
                    while (option[1] != 3){
                        System.out.println("Выберите опцию:");
                        System.out.println("1 - Создать тест");
                        System.out.println("2 - Повысить права пользователя");
                        System.out.println("3 - Вернуться назад");
                        option[1] = scanner.nextInt();
                        if (option[1] == 1){
                            List<Test> testList = testService.getAll();
                            int tId = 0;
                            boolean isTestId = false;
                            while (!isTestId) {
                                System.out.println("Введите ID теста");
                                tId = scanner.nextInt();
                                isTestId = true;
                                for (Test value : testList) {
                                    if (tId == value.gettId()) {
                                        isTestId = false;
                                        System.out.println("Данный ID уже занят");
                                        break;
                                    }
                                }
                            }
                            test.settId(tId);
                            test.setHolder(holder);
                            testService.add(test);

                            System.out.println("Водите 3 корректных вопроса, с 4 выриантами ответа и правильный вариант ответа, а так же баллы за вопрос");
                            //Создание вопросов
                            for (int i = 0; i < 3; i++){
                                scanner.nextLine();
                                System.out.println("Введите вопрос");
                                question.setQuestion(scanner.nextLine());

                                System.out.println("Введите правильный вариант ответа");
                                question.setAnswer(scanner.next());

                                System.out.println("Введите баллы за вопрос");
                                question.setScore(scanner.nextInt());

                                question.setTest(test);
                                questionService.add(question);
                                System.out.println("Вопрос успешно добавлен");
                            }
                            System.out.println("Тест успешно создан");
                        }
                        else if (option[1] == 2){
                            boolean[] isStatusUp = new boolean[]{false,false};

                            while (!isStatusUp[1]){
                                System.out.println("Введите ID пользователя");
                                id = scanner.nextInt();
                                isStatusUp[0] = false;
                                for (Holder value : holderList) {
                                    if (id == value.gethId()){
                                        isStatusUp[0] = true;
                                        if (value.isRole()){
                                            System.out.println("Данный пользователь уже имеет сататус администратора");
                                            break;
                                        }
                                        else {
                                            value.setRole(true);
                                            holderService.update(value);
                                            System.out.println("Права пользователя успешно повышены");
                                            isStatusUp[1] = true;
                                        }
                                    }
                                }
                                if (!isStatusUp[1]){
                                    System.out.println("Пользователя с даным ID не существует");
                                }

                            }

                        }
                        else if (option[1] == 3){
                            option[1] = 0;
                            break;
                        }
                    }
                }

                else{
                    System.out.println("Вы имеете права пользователя");

                    //Меню с выбором действий для пользователя
                    while (option[2] != 2){
                        System.out.println("1 - Пройти тест");
                        System.out.println("2 - Вернуться назад");
                        option[2] = scanner.nextInt();

                        if (option[2] == 1){
                            //Прохождение теста
                            List<Test> testList = testService.getAll();
                            Set<PassedTest> passedTestList;
                            int tId = 0;
                            boolean[] isTestId = new boolean[]{false,true};
                            while (!isTestId[0]){
                                System.out.println("Введите ID теста");
                                tId = scanner.nextInt();
                                isTestId[1] = true;
                                for (Test value: testList){
                                    if (tId == value.gettId()){
                                        passedTestList = holderService.getPassedTestsById(holder.gethId());
                                        for (PassedTest value2: passedTestList){
                                            if (tId == value2.getTest().gettId()){
                                                System.out.println("Вы уже проходили этот тест ранее");
                                                isTestId[1] = false;
                                                break;
                                            }
                                        }
                                        if (isTestId[1]){
                                            test = value;
                                            isTestId[0] = true;
                                            break;
                                        }
                                        //holderService.closeTransactionSession();
                                    }
                                }
                            }

                            //Ответы на вопросы
                            System.out.println("Отвечайте на вопросы только одной бувой варианта ответа");

                            /*
                            List<Question> questionList = new ArrayList<Question>();
                            questionList.addAll(test.getQuestions());

                            for (Question value: questionList){
                                System.out.println(value.getQuestion());
                            }
                            */
                            float score = 0;
                            float allScore = 0;
                            Set<Question> setQuestions = testService.getQuestionsById(tId);
                            for (Question value : setQuestions) {
                                allScore += value.getScore();
                                System.out.println(value.getQuestion());
                                System.out.println("Введите ответ");
                                if (scanner.next().equals(value.getAnswer())){
                                    System.out.println("Верно");
                                    score += value.getScore();
                                }
                                else{
                                    System.out.println("Неврено");
                                }
                            }
                            //testService.closeTransactionSession();
                            System.out.println("Тест пройден");
                            System.out.println("Вы набрали " + score/allScore*100 + "%");

                            passedTest.setTest(test);
                            passedTest.setProgress(score/allScore*100);
                            passedTest.setHolder(holder);
                            passedTestService.add(passedTest);
                        }
                        else if (option[2] == 2){
                            option[2] = 0;
                            break;
                        }
                    }
                }
            }
        }
        HibernateUtil.shutdown();
    }
}

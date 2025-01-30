import java.io.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        RegistrationSystem Users = new RegistrationSystem("users.txt");
        System.out.println(Users.getUsers());
        start(Users);
        Users.saveData();
        System.out.println("Работа программы завершена.");



    }
    /*
    Затем, в точке входа main реализуйте следующий функционал:
•	Должно быть 3 пункта меню. Авторизация, регистрация, выход из программы.
•	При успешной авторизации пользователя выведите на экран «Вы успешно авторизованы». Иначе «Неверный логин или пароль»
•	При успешной регистрации выведите на экран «Вы успешно зарегистрировались!». Иначе «Такой пользователь уже существует».

В самом конце метода main обязательно вызывайте метод saveData, чтобы сохранялось состояние системы в файл!
Для сохранения объектов в файл используйте ObjectOutputStream, для считывания – ObjectInputStream.

    */

    public static void start(RegistrationSystem Users) {
        Scanner S = new Scanner(System.in);
        int enter;
        String nickname1 = "";
        String password1 = "";
        System.out.println("Выберете действие");
        System.out.println("1  - Авторизация");
        System.out.println("2  -Регистрация");
        System.out.println("3  - Выход");

        enter = S.nextInt();

        switch (enter) {
            case 1:
                System.out.println("Введите имя");
                nickname1 = S.next();
                System.out.println("Введите пароль");
                password1 = S.next();
                if(Users.login(nickname1,password1)!=null ) {
                    System.out.println("Вы авторизованы.");
                }
                else{
                    System.out.println("Некорректные данные");
                }
                start(Users);
                break;
            case 2:
                System.out.println("Для регистрации введите имя:");
                nickname1 = S.next();
                System.out.println("Придумайте пароль: ");
                password1 = S.next();
                if(Users.register(nickname1,password1)){
                    System.out.println("Вы зарегистрированы ");
                }
                start(Users);
                break;
            case 3:
                Users.saveData();
                System.out.println("Выход");
                break;
        }
    }


}
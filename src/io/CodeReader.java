package io;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Класс, который отвечает за считыавение с консоли
 */

public class CodeReader {


    /**
     * Метод считвает с консоли код, который необходимо вставить в метод doWork() класса SomeClass
     * @return возвращает ArrayList со строками для вставки в метод.
     */
    public static ArrayList<String> readCode(){

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> result = new ArrayList<>();
        String line;
        System.out.println("Ввведите, что хотите добавить в код метода doWork:");

        //считываем код, пока не будет пустой строки

        while (true) {
            line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            result.add(line);
        }
        scanner.close();
        return result;

    }

}

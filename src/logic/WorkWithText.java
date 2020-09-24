package logic;

import java.util.ArrayList;
import java.util.List;


/**
 * Класс для обработки списков со строками
 */


public class WorkWithText {


    /**
     * Метод предназначен для вставки в код класса SomeClass, кода, который вводят в консоль.
     * Принимает:
     * @param code - List строк с кодом, который есть в SomeClass
     * @param method - ArrayList с кодом, который необходимо вставить в метод
     * @return - возвращает List со всеми строками кода
     */

    public static List<String> mergeCode(List<String> code, ArrayList<String> method) {

        //проходим лист с кодом класса, ищем метод doWork() и вставляем туда код, считанный с консоли
        for (int i = 0; i < code.size(); i ++) {
            if (code.get(i).contains("public void doWork() {")) {
                code.addAll(i+1, method);
                break;
            }

        }
        return code;
    }

    /**
     * Метод принимает List со строками кода и создает один объект, типа String со всем кодом класса.
     * @param code - List, из которого надо создать строку
     * @return - возвращаемая строка
     */

    public static String toString(List<String> code) {
        StringBuilder sb = new StringBuilder();

        for (String line : code) {
            sb.append(line).append("\n");
        }

        return sb.toString();
    }



}

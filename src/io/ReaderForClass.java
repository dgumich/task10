package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


/**
 * Класс для считывания кода, который находится в SomeClass.java
 */
public class ReaderForClass {


    /**
     * Метод принимает путь к классу, считывает все строки в файле и возвращает List со строками.
     * @param path - путь к файлу
     * @return - List со строками кода
     */

    public static List<String> getClassContent (String path){

        List<String> result = null;
        try {
            result =  Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }

}

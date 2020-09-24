package io;

import logic.WorkWithText;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 * Класс, который записыавет изменения в файл SomeClass.java
 */


public class WriterForClass {


    /**
     * Метод получает финальную строку с кодом, который должен быть в классе SomeClass, путь,
     * где лежит java фаил и записывает строку в файл.
     * @param result - строка с финальным кодом
     * @param path - путь к файлу
     */

    public static void writeCode(String result, String path)  {

        try {
            Files.write(Paths.get(path), result.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}

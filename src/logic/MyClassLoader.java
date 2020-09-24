package logic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Класс, кастомный загрузчик класса.
 * Подгружает в райнтайме класс SomeClass
 */

public class MyClassLoader extends ClassLoader {

    @Override
    public Class<?> findClass(String name) {

        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get("src\\worker\\SomeClass.class"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name, bytes, 0, bytes.length);

    }
}

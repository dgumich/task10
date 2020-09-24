package logic;

import io.CodeReader;
import io.ReaderForClass;
import io.WriterForClass;
import worker.Worker;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс, который отвечает за логику программы
 */

public class ProgramLogic {

    //путь к классу SomeClass

    String path = "src\\worker\\SomeClass.java";



    public void start(){

        //создаем ArrayList со строчками, которые нужно добавить в метод doWork
        ArrayList<String> methodCode = CodeReader.readCode();

        //Считывает содержание класса SomeClass на данный момент
        List<String> classContent = ReaderForClass.getClassContent(path);


        //Создаем финальную строку с кодом, которую нужно записать в файл
        String result = WorkWithText.toString(WorkWithText.mergeCode(classContent, methodCode));


        // и записываем ее в файл
        WriterForClass.writeCode(result, path);

        //Создаем объект JavaCompiler и компилируем модифицированный класс в рантайме
        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        javac.run(null, System.out, System.err, path);

        //Создаем объект-кастомный загружчик класса
        MyClassLoader myClassLoader = new MyClassLoader();

        //Загружаем класс
        Class SomeClass = myClassLoader.findClass("worker.SomeClass");


        //Создаем экземпляр загруженного класса
        Object someObject = null;

        try {
            someObject = SomeClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        //кастим экземпляер к интерфейсу Worker
        Worker worker = (Worker) someObject;

        //запускаем метод
        worker.doWork();

    }


}

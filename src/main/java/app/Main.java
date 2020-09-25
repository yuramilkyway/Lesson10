package app;

import api.Worker;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        ReadClass reader = new ReadClass();
        reader.readClass();

        Compiler compiler = new Compiler();
        compiler.runCompiler();

        CreateClass createClass = new CreateClass();
        try {
            Class<?> someClass = createClass.loadClass("SomeClass");
            //Запускаем конструктор и создаем экземпляр класса.
            Worker worker = (Worker) someClass.getConstructors()[0].newInstance();
            worker.doWork();
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

package app;

import java.io.*;

public class ReadClass {

    private final String fileName = "SomeClass.java";

    /**
     * Создаем объекты классов для считывания с консоли и записи в файл;
     * Записивыем дефелтное начала класса;
     * Считываем код метода doWork с консоли.
     */
    public void readClass() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){

            writer.write("package app;\n" +
                            "\n" +
                            "import api.Worker;\n" +
                            "public class SomeClass implements Worker {\n" +
                            "\n" +
                            "   @Override\n" +
                            "   public void doWork() {");

            String str;
            while (!(str = reader.readLine()).equals("")) {
                writer.write(str);
                writer.newLine();
            }

            writer.write(" }\n" +
                    "}");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return fileName;
    }
}

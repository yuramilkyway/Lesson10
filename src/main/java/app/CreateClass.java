package app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Пользовательский загрузчик
 */
public class CreateClass extends ClassLoader{

    /**
     * Преобразовываем файл с кодом нашего класса
     * @param name Название файла, в котором описание класса.
     * @return С помощью defineClass помещаем байт код класса в недра виртуальной машины,
     *      * где он приобретает вид, пригодный для непосредственного исполнения на конкретной
     *      * аппаратной платформе, в частности, компилируется в машинный код процессора для более
     *      * быстрого исполнения (так называемая технология Just-In-Time, сокращенно JIT-компиляция).
     * @throws ClassNotFoundException e
     */
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        try {
            byte[] buff = Files.readAllBytes(new File(name + ".class").toPath());
            return defineClass(null, buff, 0, buff.length);
        } catch (IOException e) {
            e.getStackTrace();
            return super.loadClass(name);
        }
    }
}

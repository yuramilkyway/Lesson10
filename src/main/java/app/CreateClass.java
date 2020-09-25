package app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CreateClass extends ClassLoader{

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

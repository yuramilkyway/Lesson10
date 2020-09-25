package app;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;

public class Compiler {
    public void runCompiler() {
        File file = new File(new ReadClass().getName());
        /*
         * Класс JavaCompiler создает объекты JavaCompiler.CompilationTask,
         * которые компилируют исходный код из объектов JavaFileObjectSOURCE
         * в объекте JavaFileManager, создавая новые выходные JavaFileObject CLASS
         * файлы и объекты типа Diagnostic (предупреждения и ошибки).
         * Статический метод ToolProvider.getSystemJavaCompiler()
         * возвращает экземпляр компилятора.
         */
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        /*
         * Запускаем компилятор с Parameters:
         *     in - "standard" input; use System.in if null
         *     out - "standard" output; use System.out if null
         *     err - "standard" error; use System.err if null
         *     arguments - arguments to pass to the tool
         * Returns:
         *     0 for success; nonzero otherwise
         */
        compiler.run(null, System.out, System.err, file.getPath());
    }
}

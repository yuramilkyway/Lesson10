package app;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;

public class Compiler {
    public void runCompiler() {
        File file = new File(new ReadClass().getName());
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, System.out, System.err, file.getPath());
    }
}

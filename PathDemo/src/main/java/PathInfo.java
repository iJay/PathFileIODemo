import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author hblx2
 */
public class PathInfo {

    static void show(String id, Object p) {
        System.out.println(id + ": " + p);
    }

    static void info(Path p) {
        show("toString", p);
        // 判断该路径是否存在
        show("isReadable", Files.isReadable(p));
        show("Exists", Files.exists(p));
        show("RegularFile", Files.isRegularFile(p));
        show("Directory", Files.isDirectory(p));
        show("Absolute", p.isAbsolute());
        show("FileName", p.getFileName());
        show("Parent", p.getParent());
        show("Root", p.getRoot());
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        // 输出当前系统的名称
        System.out.println(System.getProperty("os.name"));
        info(Paths.get("C:", "Users", "hblx2", "Desktop", "myDoc", "book", "Head First 设计模式.pdf"));
        Path path = Paths.get("PathDemo", "note.md");
        info(path);
        Path absolutePath = path.toAbsolutePath();
        info(absolutePath);
        info(absolutePath.getParent());
        try {
            info(path.toRealPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

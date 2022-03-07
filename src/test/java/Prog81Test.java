import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.*;

public class Prog81Test {

    @Test
    public void testHelloWorld()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        StandardInputStream in = new StandardInputStream();
        System.setIn(in);

        // action
        // Hello.main(new String[]{"1", "2", "3"}); // 実行時引数をテストする場合
        Prog81.main(new String[]{"190"});

        // assertion
        String[] prints = bos.toString().split("\n");
        assertEquals("勇者のHP: 170", prints[prints.length - 3]);
        assertEquals("お化けキノコAのHP: 170", prints[prints.length - 2]);
        assertEquals("お化けキノコBのHP: 170", prints[prints.length - 1]);

        //action
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        Prog81.main(new String[]{"200"});

        // assertion
        prints = bos.toString().split("\n");
        assertEquals("勇者のHP: 180", prints[prints.length - 3]);
        assertEquals("お化けキノコAのHP: 180", prints[prints.length - 2]);
        assertEquals("お化けキノコBのHP: 180", prints[prints.length - 1]);

        // undo the binding in System
        System.setOut(originalOut);
    }
}

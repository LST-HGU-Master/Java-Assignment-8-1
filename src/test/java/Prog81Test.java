import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import java.io.*;
/**
 * @version (20220606)
 **/
public class Prog81Test {

    @Test
    public void testHelloWorld()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos;
        StandardInputStream in = new StandardInputStream();
        System.setIn(in);

        // action
        // Hello.main(new String[]{"1", "2", "3"}); // 実行時引数をテストする場合
        int[] hpData = {190,200};

        for(int hp: hpData){
            bos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(bos));
            Prog81.main(new String[]{String.valueOf(hp)});
            // undo the binding in System
            System.setOut(originalOut);
            // assertion
            String[] prints = bos.toString().split("\r\n|\n", -1);
            try {
                assertEquals("勇者のHP: " + (hp-20), prints[prints.length - 4],"main()での処理による勇者のHPの変化が予定通りでありません!");
                assertEquals("お化けキノコAのHP: " + (hp-20), prints[prints.length - 3],"main()での処理によるおばけキノコAのHPの変化が予定通りでありません!");
                assertEquals("お化けキノコBのHP: " + (hp-20), prints[prints.length - 2],"main()での処理によるおばけキノコBのHPの変化が予定通りでありません!");
            } catch (ArrayIndexOutOfBoundsException excpt) {
                fail("Prog81.main()のprint出力に改行が３つ分ありません!");
            }
            assertEquals(7, prints.length,"print命令の改行が７つ以上あります!");
        }
    }
}
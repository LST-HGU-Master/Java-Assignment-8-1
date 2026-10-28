import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.*;
/**
 * @version (20220606)
 * @version (20261028) revised for lifecycle management, method renaming, full line validation, and index safety
 **/
public class Prog81Test {
    InputStream originalIn;
    PrintStream originalOut;
    ByteArrayOutputStream bos;
    StandardInputStream in;

    @BeforeEach
    void before() {
        // back up binding
        originalIn  = System.in;
        originalOut = System.out;
        // modify binding
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        in = new StandardInputStream();
        System.setIn(in);
    }

    @AfterEach
    void after() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testMain()
    {
        int[] hpData = {190,200};

        for(int hp: hpData){
            bos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(bos));
            
            Prog81.main(new String[]{String.valueOf(hp)});
 
            System.setOut(originalOut);
            
            Prog81.main(new String[]{ String.valueOf(hp) });

            String rawOutput = bos.toString().replace("\r\n", "\n");

            assertTrue(rawOutput.endsWith("\n"), 
                "Prog81.main() の出力末尾に改行がありません! 各行の出力直後に改行（println）を入れているか確認してください。"
            );

            // 2. 行数・余分な改行のチェック 
            String[] prints = rawOutput.split("\n", -1);
            assertEquals(7, prints.length, 
                "Prog81.main() の出力行数が不正です! （全6行の出力になっているか、不要な改行が入っていないか確認してください）"
            );

            // 3. 各行のメッセージ検証
            assertEquals("勇者ミナトはお化けキノコAを攻撃した！", prints[0], "1行目（勇者 -> キノコAへの攻撃）のメッセージが正しくありません!");
            assertEquals("勇者ミナトはお化けキノコBを攻撃した！", prints[1], "2行目（勇者 -> キノコBへの攻撃）のメッセージが正しくありません!");
            assertEquals("お化けキノコAは勇者ミナトを攻撃した！", prints[2], "3行目（キノコA -> 勇者への攻撃）のメッセージが正しくありません!");

            assertEquals("勇者のHP: " + (hp - 20), prints[3], "4行目（勇者のHP）の表示が正しくありません!");
            assertEquals("お化けキノコAのHP: " + (hp - 20), prints[4], "5行目（お化けキノコAのHP）の表示が正しくありません!");
            assertEquals("お化けキノコBのHP: " + (hp - 20), prints[5], "6行目（お化けキノコBのHP）の表示が正しくありません!");
        }
    }
}

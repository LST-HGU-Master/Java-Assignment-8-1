import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.*;
/**
 * @version (20220606)
 * @version (20261028) revised for lifecycle management, explicit trailing newline validation, and index safety
 * 
 * (注意) Heroクラス内に attack(Matango m) が
 * 　　　　宣言されるまで、このテストクラスはエラーが表示される
 **/
public class HeroTest {
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
    public void testDamage20()
    {
        Hero h = new Hero();
        h.hp = 150;
        h.name = "コータロー";

        Matango m = new Matango();
        m.hp = 150;
        m.suffix = 'X';

        h.attack(m);
        assertEquals(130, m.hp, "Hero.attack(Matango) 実行後の Matango の hp 処理（20減算）が不正です!");
    }

    @Test
    public void testPrint()
    {
        Hero h = new Hero();
        h.hp = 150;
        h.name = "コータロー";

        Matango m = new Matango();
        m.hp = 150;
        m.suffix = 'X';

        h.attack(m);
  
        String rawOutput = bos.toString().replace("\r\n", "\n");

        // 1. 末尾改行のチェック (print ではなく println の使用を強制)
        assertTrue(rawOutput.endsWith("\n"), 
            "Hero.attack(Matango) の出力末尾に改行がありません! print ではなく println を使用しているか確認してください。"
        );

        // 2. 行数・余分な改行のチェック (1行出力 + 末尾改行1個 = 要素数2)
        String[] prints = rawOutput.split("\n", -1);
        assertEquals(2, prints.length, 
            "Hero.attack(Matango) の出力行数が不正です! 不要な改行（\\n）が入っていないか確認してください。"
        );

        // 3. 出力メッセージの検証
        assertEquals("勇者コータローはお化けキノコXを攻撃した！", prints[0], 
            "Hero.attack(Matango) の出力メッセージが指定と異なります!"
        );
    }
}

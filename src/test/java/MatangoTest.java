import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.*;
/**
 * @version (20220606)
 * @version (20261028) revised for lifecycle management, explicit trailing newline validation, and standard JDK only
 * 
 * (注意) Matangoクラス内に attack(Hero hr) が
 * 　　　　宣言されるまで、このテストクラスはエラーが表示される
 **/
public class MatangoTest {
    private PrintStream originalOut;
    private ByteArrayOutputStream bos;

    @BeforeEach
    void before() {
        // 標準出力（System.out）のバックアップとリダイレクト
        originalOut = System.out;
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
    }

    @AfterEach
    void after() {
        // 標準出力の復元
        System.setOut(originalOut);
    }

    @Test
    public void testDamage20()
    {
        Hero h = new Hero();
        h.hp = 50;
        h.name = "コータロー";

        Matango m = new Matango();
        m.hp = 50;
        m.suffix = 'X';

        m.attack(h);

        assertEquals(30, h.hp, "Matango.attack(Hero) 実行後の Hero の hp 処理（20減算）が不正です!");
    }

    @Test
    public void testPrint()
    {
        Hero h = new Hero();
        h.hp = 50;
        h.name = "コータロー";
        
        Matango m = new Matango();
        m.hp = 50;
        m.suffix = 'Z';

        m.attack(h);

        String rawOutput = bos.toString().replace("\r\n", "\n");

        // 1. 末尾改行のチェック (print ではなく println の使用を強制)
        assertTrue(rawOutput.endsWith("\n"), 
            "Matango.attack(Hero) の出力末尾に改行がありません! print ではなく println を使用しているか確認してください。"
        );

        // 2. 行数・余分な改行のチェック (1行出力 + 末尾改行1個 = 要素数2)
        String[] prints = rawOutput.split("\n", -1);
        assertEquals(2, prints.length, 
            "Matango.attack(Hero) の出力行数が不正です! 不要な改行（\\n）が入っていないか確認してください。"
        );

        // 3. 出力メッセージの検証
        assertEquals("お化けキノコZは勇者コータローを攻撃した！", prints[0], 
            "Matango.attack(Hero) の出力メッセージが指定と異なります!"
        );
    }
}

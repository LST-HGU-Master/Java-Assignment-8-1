import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.*;
/**
 * @version (20220606)
 * 
 * (注意) Heroクラス内に attack(Matango m) が
 * 　　　　宣言されるまで、このテストクラスはエラーが表示される
 **/
public class HeroTest {

    @Test
    public void testDamage20()
    {
        // PrintStream originalOut = System.out;
        // ByteArrayOutputStream bos = new ByteArrayOutputStream();
        // System.setOut(new PrintStream(bos));

        // action
        Hero h = new Hero();
        h.hp = 150;
        h.name = "コータロー";
        Matango m = new Matango();
        m.hp = 150;
        m.suffix = 'X';

        h.attack(m);
        // undo the binding in System
        // System.setOut(originalOut);
        // assertion
        assertEquals(130, m.hp, "Hero.attack(Matango )中のhpの処理が不正です!");
    }

    @Test
    public void testPrint()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Hero h = new Hero();
        h.hp = 150;
        h.name = "コータロー";
        Matango m = new Matango();
        m.hp = 150;
        m.suffix = 'X';

        h.attack(m);
         // undo the binding in System
        System.setOut(originalOut);
        // assertion
        String[] prints = bos.toString().split("\r\n|\n", -1);
        assertEquals("勇者コータローはお化けキノコXを攻撃した！", prints[0],"Hero.attack(Matango )のprint出力が実行例と異なります!");
        assertEquals(2, prints.length, "Hero.attack(Matango )のprint出力で改行が２つ以上あります!");

    }
}

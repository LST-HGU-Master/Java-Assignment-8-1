import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.*;
/**
 * @version (20220527)
 * 
 * (注意) Heroクラス内に attack(Matango m) が
 * 　　　　宣言されるまで、このテストクラスはエラーが表示される
 **/
public class HeroTest {

    @Test
    public void testDamage20()
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

        // assertion
        try {
            assertEquals(130, m.hp,
                "Hero.attack(Matango )後のmatangoインスタンスのhpが不正です!");
        } catch (AssertionError err) {
            System.setOut(originalOut);
            throw err;
        }
        // undo the binding in System
        System.setOut(originalOut);
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

        // assertion
        String[] prints = bos.toString().split("\r\n|\n");
        try {
            assertEquals("勇者コータローはお化けキノコXを攻撃した!", prints[0],"Hero.attack(Matango )のprint出力が実行例と異なります!");
        } catch (AssertionError err) {
            System.setOut(originalOut);
            throw err;
        }
         // undo the binding in System
        System.setOut(originalOut);
    }
}
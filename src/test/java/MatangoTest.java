import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.*;
/**
 * @version (20220527)
 * 
 * (注意) Matangoクラス内に attack(Hero hr) が
 * 　　　　宣言されるまで、このテストクラスはエラーが表示される
 **/
public class MatangoTest {

    @Test
    public void testDamage20()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Hero h = new Hero();
        h.hp = 50;
        h.name = "コータロー";
        Matango m = new Matango();
        m.hp = 50;
        m.suffix = 'X';

        m.attack(h);

        // assertion
        try {
            assertEquals(30, h.hp,"Matango.attack(Hero )後のHeroインスタンスのhpが不正です!");
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
        h.hp = 50;
        h.name = "コータロー";
        Matango m = new Matango();
        m.hp = 50;
        m.suffix = 'Z';

        m.attack(h);

        // assertion
        String[] prints = bos.toString().split("\r\n|\n");
        try {
            assertEquals("お化けキノコZは勇者コータローを攻撃した!", prints[0],"Matango.attack(Hero )のprint出力が実行例と異なります!");
        } catch (AssertionError err) {
            System.setOut(originalOut);
            throw err;
        }
 
        // undo the binding in System
        System.setOut(originalOut);
    }
}
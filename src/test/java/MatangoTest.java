import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.*;
/**
 * @version (20220606)
 * 
 * (注意) Matangoクラス内に attack(Hero hr) が
 * 　　　　宣言されるまで、このテストクラスはエラーが表示される
 **/
public class MatangoTest {

    @Test
    public void testDamage20()
    {
        // PrintStream originalOut = System.out;
        // ByteArrayOutputStream bos = new ByteArrayOutputStream();
        // System.setOut(new PrintStream(bos));

        // action
        Hero h = new Hero();
        h.hp = 50;
        h.name = "コータロー";
        Matango m = new Matango();
        m.hp = 50;
        m.suffix = 'X';

        m.attack(h);
        // // undo the binding in System
        // System.setOut(originalOut);
        // assertion
        assertEquals(30, h.hp,"Matango.attack(Hero )中のhpの処理が不正です!");
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
        // undo the binding in System
        System.setOut(originalOut);
        // assertion
        String[] prints = bos.toString().split("\r\n|\n",-1);
        assertEquals("お化けキノコZは勇者コータローを攻撃した!", prints[0],"Matango.attack(Hero )のprint出力が実行例と異なります!");
        assertEquals(2, prints.length, "Hero.attack(Matango )のprint出力で改行が２つ以上あります!");
    }
}
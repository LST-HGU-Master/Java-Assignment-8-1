import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.*;

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
        assertEquals(130, m.hp);

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
        assertEquals("勇者コータローはお化けキノコXを攻撃した!\n", bos.toString());

        // undo the binding in System
        System.setOut(originalOut);
    }
}

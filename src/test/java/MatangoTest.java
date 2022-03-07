import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.*;

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
        assertEquals(30, h.hp);

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
        assertEquals("お化けキノコZは勇者コータローを攻撃した!\n", bos.toString());

        // undo the binding in System
        System.setOut(originalOut);
    }
}

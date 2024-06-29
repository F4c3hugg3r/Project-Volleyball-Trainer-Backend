package htwberlin.webtech.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StatTest {

    //eigentlich keine Tests benötigt, da equals, hash und toString mit Lombok geregelt ist
    @Test
    void testStatToString() {
        final StatId statId = new StatId(1, 1);
        final Stat stat = new Stat(statId, 3);
        final String expectation = "Stat(id=StatId(id=1, rating=1), anzahl=3)";
        final String result = stat.toString();
        assertEquals(expectation, result);
    }
}

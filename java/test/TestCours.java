import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCours {

    @Test
    public void testCreation() {
        Cours c = new Cours("Mathématiques", "M. Dupont");
        assertEquals("Mathématiques", c.getNom());
        assertEquals("M. Dupont", c.getProfesseur());
    }

    @Test
    public void testStr() {
        Cours c = new Cours("Mathématiques", "M. Dupont");
        assertTrue(c.toString().contains("Mathématiques"));
        assertTrue(c.toString().contains("M. Dupont"));
    }
}

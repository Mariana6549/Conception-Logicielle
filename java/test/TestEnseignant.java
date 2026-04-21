import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestEnseignant {

    @Test
    public void testCreation() {
        Enseignant en = new Enseignant("M. Dupont", 45, 3500.0);
        assertEquals("M. Dupont", en.getNom());
        assertEquals(45, en.getAge());
        assertEquals(3500.0, en.getSalaire());
    }

    @Test
    public void testHeritage() {
        Enseignant en = new Enseignant("M. Dupont", 45, 3500.0);
        assertTrue(en instanceof Personne);
    }

    @Test
    public void testSalaireNegatif() {
        assertThrows(IllegalArgumentException.class, () -> new Enseignant("M. Dupont", 45, -100));
    }

    @Test
    public void testSetterSalaireInvalide() {
        Enseignant en = new Enseignant("M. Dupont", 45, 3500.0);
        assertThrows(IllegalArgumentException.class, () -> en.setSalaire(-500));
    }

    @Test
    public void testStr() {
        Enseignant en = new Enseignant("M. Dupont", 45, 3500.0);
        assertTrue(en.toString().contains("M. Dupont"));
        assertTrue(en.toString().contains("3500"));
    }
}

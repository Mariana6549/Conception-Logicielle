import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPersonne {

    @Test
    public void testCreation() {
        Personne p = new Personne("Alice", 20);
        assertEquals("Alice", p.getNom());
        assertEquals(20, p.getAge());
    }

    @Test
    public void testStr() {
        Personne p = new Personne("Alice", 20);
        assertTrue(p.toString().contains("Alice"));
        assertTrue(p.toString().contains("20"));
    }

    @Test
    public void testAgeInvalide() {
        assertThrows(IllegalArgumentException.class, () -> new Personne("Alice", -1));
        assertThrows(IllegalArgumentException.class, () -> new Personne("Alice", 101));
    }

    @Test
    public void testNomVide() {
        assertThrows(IllegalArgumentException.class, () -> new Personne("", 20));
    }

    @Test
    public void testSetterAgeValide() {
        Personne p = new Personne("Alice", 20);
        p.setAge(25);
        assertEquals(25, p.getAge());
    }

    @Test
    public void testSetterAgeInvalide() {
        Personne p = new Personne("Alice", 20);
        assertThrows(IllegalArgumentException.class, () -> p.setAge(-5));
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPersonne {

    // Personne est abstraite : on utilise une sous-classe anonyme pour les tests
    private Personne creerPersonne(String nom, int age) {
        return new Personne(nom, age) {
            @Override
            public void afficherDetails() {
                System.out.println(this);
            }
        };
    }

    @Test
    public void testCreation() {
        Personne p = creerPersonne("Alice", 20);
        assertEquals("Alice", p.getNom());
        assertEquals(20, p.getAge());
    }

    @Test
    public void testStr() {
        Personne p = creerPersonne("Alice", 20);
        assertTrue(p.toString().contains("Alice"));
        assertTrue(p.toString().contains("20"));
    }

    @Test
    public void testAgeInvalide() {
        assertThrows(IllegalArgumentException.class, () -> creerPersonne("Alice", -1));
        assertThrows(IllegalArgumentException.class, () -> creerPersonne("Alice", 101));
    }

    @Test
    public void testNomVide() {
        assertThrows(IllegalArgumentException.class, () -> creerPersonne("", 20));
    }

    @Test
    public void testSetterAgeValide() {
        Personne p = creerPersonne("Alice", 20);
        p.setAge(25);
        assertEquals(25, p.getAge());
    }

    @Test
    public void testSetterAgeInvalide() {
        Personne p = creerPersonne("Alice", 20);
        assertThrows(IllegalArgumentException.class, () -> p.setAge(-5));
    }
}

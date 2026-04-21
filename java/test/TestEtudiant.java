import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestEtudiant {

    @Test
    public void testCreation() {
        Etudiant e = new Etudiant("Alice Martin", 20, "E001", 15.5);
        assertEquals("Alice Martin", e.getNom());
        assertEquals(20, e.getAge());
        assertEquals("E001", e.getNumero());
        assertEquals(15.5, e.getMoyenne());
    }

    @Test
    public void testHeritage() {
        Etudiant e = new Etudiant("Alice Martin", 20, "E001", 15.5);
        assertTrue(e instanceof Personne);
    }

    @Test
    public void testAjouterCours() {
        Etudiant e = new Etudiant("Alice Martin", 20, "E001", 15.5);
        e.ajouterCours(new Cours("Mathématiques", "M. Dupont"));
        assertTrue(e.toString().contains("Mathématiques"));
    }

    @Test
    public void testStr() {
        Etudiant e = new Etudiant("Alice Martin", 20, "E001", 15.5);
        e.ajouterCours(new Cours("Mathématiques", "M. Dupont"));
        assertTrue(e.toString().contains("Alice Martin"));
        assertTrue(e.toString().contains("E001"));
        assertTrue(e.toString().contains("Mathématiques"));
    }

    @Test
    public void testMoyenneInvalideConstruction() {
        assertThrows(IllegalArgumentException.class, () -> new Etudiant("Alice", 20, "E001", -1));
        assertThrows(IllegalArgumentException.class, () -> new Etudiant("Alice", 20, "E001", 25));
    }

    @Test
    public void testSetterMoyenneInvalide() {
        Etudiant e = new Etudiant("Alice Martin", 20, "E001", 15.5);
        assertThrows(IllegalArgumentException.class, () -> e.setMoyenne(25));
    }

    @Test
    public void testSetterMoyenneValide() {
        Etudiant e = new Etudiant("Alice Martin", 20, "E001", 15.5);
        e.setMoyenne(18.0);
        assertEquals(18.0, e.getMoyenne());
    }
}

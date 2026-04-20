import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestSingleton {

    @Test
    void testMemeInstance() {
        ScolariteManager m1 = ScolariteManager.getInstance();
        ScolariteManager m2 = ScolariteManager.getInstance();
        assertSame(m1, m2);
    }

    @Test
    void testAjoutEtudiant() {
        ScolariteManager manager = ScolariteManager.getInstance();
        int avant = manager.getEtudiants().size();
        manager.ajouterEtudiant(new Etudiant("Test", 20, "T001"));
        assertEquals(avant + 1, manager.getEtudiants().size());
    }
}

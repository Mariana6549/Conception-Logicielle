import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestFactory {

    @Test
    void testCreerEtudiant() {
        Personne p = PersonneFactory.getFactory("etudiant").creer("Alice", 20, "E001");
        assertInstanceOf(Etudiant.class, p);
        assertEquals("Alice", p.getNom());
    }

    @Test
    void testCreerProfesseur() {
        Personne p = PersonneFactory.getFactory("professeur").creer("Prof. Martin", 45, "Info");
        assertInstanceOf(Professeur.class, p);
    }

    @Test
    void testTypeInconnu() {
        assertThrows(IllegalArgumentException.class, () -> PersonneFactory.getFactory("robot"));
    }

    @Test
    void testEnregistrerNouveauType() {
        // OCP : on etend sans modifier PersonneFactory
        PersonneFactory.enregistrer("superviseur", new ProfesseurFactory());
        Personne p = PersonneFactory.getFactory("superviseur").creer("Alice", 35, "Gestion");
        assertInstanceOf(Professeur.class, p);
    }
}

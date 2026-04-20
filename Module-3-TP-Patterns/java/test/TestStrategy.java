import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TestStrategy {

    private List<Etudiant> creerEtudiants() {
        Etudiant a = new Etudiant("Alice",   20, "E001"); a.ajouterNote(15.5);
        Etudiant b = new Etudiant("Bob",     22, "E002"); b.ajouterNote(12.0);
        Etudiant c = new Etudiant("Charlie", 21, "E003"); c.ajouterNote(18.0);
        return Arrays.asList(a, b, c);
    }

    @Test
    void testTriParMoyenne() {
        List<Etudiant> tries = new TriParMoyenne().trier(creerEtudiants());
        assertEquals("Charlie", tries.get(0).getNom());
        assertEquals("Bob",     tries.get(2).getNom());
    }

    @Test
    void testTriParNom() {
        List<Etudiant> tries = new TriParNom().trier(creerEtudiants());
        assertEquals("Alice",   tries.get(0).getNom());
        assertEquals("Charlie", tries.get(2).getNom());
    }
}

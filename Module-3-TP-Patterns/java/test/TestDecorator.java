import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class TestDecorator {

    private String capturer(Personne p) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        p.afficher();
        System.setOut(System.out);
        return out.toString();
    }

    @Test
    void testBoursierAffichage() {
        Etudiant e = new Etudiant("Alice", 20, "E001");
        String output = capturer(new EtudiantBoursier(e, 500.0));
        assertTrue(output.contains("BOURSIER"));
        assertTrue(output.contains("500.0"));
    }

    @Test
    void testDelegueAffichage() {
        Etudiant e = new Etudiant("Bob", 22, "E002");
        String output = capturer(new EtudiantDelegue(e, "L3 INFO"));
        assertTrue(output.contains("L3 INFO"));
    }

    @Test
    void testEtudiantOriginalInchange() {
        Etudiant e = new Etudiant("Alice", 20, "E001");
        new EtudiantBoursier(e, 500.0);
        assertEquals("Alice", e.getNom());
    }
}

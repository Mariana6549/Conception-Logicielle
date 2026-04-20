import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TestObserver {

    static class FakeObservateur implements Observateur {
        List<String> messages = new ArrayList<>();
        public void mettreAJour(String msg, Etudiant e) { messages.add(msg); }
    }

    @Test
    void testNotificationNote() {
        Etudiant e = new Etudiant("Alice", 20, "E001");
        FakeObservateur obs = new FakeObservateur();
        e.ajouterObservateur(obs);
        e.ajouterNote(15.5);
        assertEquals(1, obs.messages.size());
        assertTrue(obs.messages.get(0).contains("15.5"));
    }

    @Test
    void testPlusieursObservateurs() {
        Etudiant e = new Etudiant("Bob", 22, "E002");
        FakeObservateur obs1 = new FakeObservateur(), obs2 = new FakeObservateur();
        e.ajouterObservateur(obs1);
        e.ajouterObservateur(obs2);
        e.ajouterNote(12.0);
        assertEquals(1, obs1.messages.size());
        assertEquals(1, obs2.messages.size());
    }

    @Test
    void testDesabonnement() {
        Etudiant e = new Etudiant("Charlie", 21, "E003");
        FakeObservateur obs = new FakeObservateur();
        e.ajouterObservateur(obs);
        e.supprimerObservateur(obs);
        e.ajouterNote(18.0);
        assertEquals(0, obs.messages.size());
    }
}

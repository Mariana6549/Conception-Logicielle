import java.util.ArrayList;
import java.util.List;

// Singleton + Observateur
// SRP : centralise la gestion des etudiants et les notifications
public class ScolariteManager implements Observateur {

    private static ScolariteManager instance;

    private List<Etudiant> etudiants;
    private TriStrategy triStrategy;

    private ScolariteManager() {
        etudiants   = new ArrayList<>();
        triStrategy = new TriParNom();
    }

    public static ScolariteManager getInstance() {
        if (instance == null) {
            instance = new ScolariteManager();
        }
        return instance;
    }

    public void ajouterEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
        etudiant.ajouterObservateur(this);
    }

    @Override
    public void mettreAJour(String message, Etudiant etudiant) {
        System.out.println("[ScolariteManager] Notification : " + message);
        afficherStatistiques();
    }

    // OCP : la strategie est injectable, pas codee en dur
    public void setTriStrategy(TriStrategy strategy) {
        this.triStrategy = strategy;
    }

    public List<Etudiant> getEtudiantsTries() {
        return triStrategy.trier(etudiants);
    }

    public void afficherStatistiques() {
        if (etudiants.isEmpty()) return;
        double moyenne = etudiants.stream()
                .mapToDouble(Etudiant::getMoyenne)
                .average().orElse(0.0);
        System.out.printf("[Stats] %d etudiant(s) | Moyenne generale : %.2f%n",
                etudiants.size(), moyenne);
    }

    public List<Etudiant> getEtudiants() { return etudiants; }
}

import java.util.ArrayList;
import java.util.List;

// SRP : Etudiant gère ses propres données et notifie ses observateurs
public class Etudiant extends Personne implements Sujet {
    private String numeroEtudiant;
    private double moyenne;
    private List<Cours> listeCours;
    private List<Observateur> observateurs;

    public Etudiant(String nom, int age, String numeroEtudiant) {
        super(nom, age);
        this.numeroEtudiant = numeroEtudiant;
        this.moyenne        = 0.0;
        this.listeCours     = new ArrayList<>();
        this.observateurs   = new ArrayList<>();
    }

    public void ajouterNote(double note) {
        this.moyenne = note;
        notifierObservateurs("Note mise a jour : " + note + " pour " + nom);
    }

    public void ajouterCours(Cours cours) {
        listeCours.add(cours);
    }

    @Override
    public void afficher() {
        System.out.println("Etudiant : " + nom
                + " | Age : " + age
                + " | N : " + numeroEtudiant
                + " | Moyenne : " + moyenne);
        listeCours.forEach(c -> System.out.println("    -> " + c));
    }

    @Override public void ajouterObservateur(Observateur o)    { observateurs.add(o); }
    @Override public void supprimerObservateur(Observateur o)  { observateurs.remove(o); }
    @Override public void notifierObservateurs(String message) { observateurs.forEach(o -> o.mettreAJour(message, this)); }

    public String getNumeroEtudiant() { return numeroEtudiant; }
    public double getMoyenne()        { return moyenne; }
    public List<Cours> getListeCours(){ return listeCours; }
}

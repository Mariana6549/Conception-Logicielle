import java.util.ArrayList;
import java.util.List;

public class Etudiant extends Personne {
    private String numero;
    private double moyenne;
    private List<ICours> cours;  // DIP : dépend de l'interface ICours, pas de Cours

    public Etudiant(String nom, int age, String numero, double moyenne) {
        super(nom, age);
        this.numero = numero;
        setMoyenne(moyenne);
        this.cours = new ArrayList<>();
    }

    public String getNumero() { return numero; }
    public double getMoyenne() { return moyenne; }

    public void setMoyenne(double moyenne) {
        if (moyenne < 0 || moyenne > 20)
            throw new IllegalArgumentException("La moyenne doit être entre 0 et 20");
        this.moyenne = moyenne;
    }

    public void ajouterCours(ICours c) {  // DIP : accepte n'importe quelle implémentation de ICours
        this.cours.add(c);
    }

    @Override
    public void afficherDetails() {
        System.out.println("Étudiant: " + getNom() + " | N°" + numero + " | Moyenne: " + moyenne);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Étudiant: ").append(getNom())
          .append(" | N°").append(numero)
          .append(" | Âge: ").append(getAge())
          .append(" | Moyenne: ").append(moyenne).append("\n");
        sb.append("  Cours inscrits:\n");
        for (ICours c : cours) {
            sb.append("    - ").append(c).append("\n");
        }
        return sb.toString();
    }
}

public class Cours implements ICours {
    private String nom;
    private String professeur;

    public Cours(String nom, String professeur) {
        this.nom = nom;
        this.professeur = professeur;
    }

    @Override
    public String getNom() { return nom; }

    @Override
    public String getProfesseur() { return professeur; }

    @Override
    public String toString() {
        return "Cours: " + nom + " | Professeur: " + professeur;
    }
}

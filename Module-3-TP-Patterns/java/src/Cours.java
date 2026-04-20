public class Cours {
    private String nomCours;
    private String professeur;

    public Cours(String nomCours, String professeur) {
        this.nomCours   = nomCours;
        this.professeur = professeur;
    }

    public String getNomCours()   { return nomCours; }
    public String getProfesseur() { return professeur; }

    @Override
    public String toString() {
        return nomCours + " (Prof: " + professeur + ")";
    }
}

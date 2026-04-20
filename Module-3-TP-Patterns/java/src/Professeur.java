public class Professeur extends Personne {
    private String specialite;

    public Professeur(String nom, int age, String specialite) {
        super(nom, age);
        this.specialite = specialite;
    }

    @Override
    public void afficher() {
        System.out.println("Professeur : " + nom
                + " | Age : " + age
                + " | Specialite : " + specialite);
    }

    public String getSpecialite() { return specialite; }
}

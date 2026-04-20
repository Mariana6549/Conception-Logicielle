public class ProfesseurFactory extends PersonneFactory {
    @Override
    public Personne creer(String nom, int age, String specialite) {
        return new Professeur(nom, age, specialite);
    }
}

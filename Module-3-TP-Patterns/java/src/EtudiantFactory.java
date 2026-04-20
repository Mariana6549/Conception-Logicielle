public class EtudiantFactory extends PersonneFactory {
    @Override
    public Personne creer(String nom, int age, String numeroEtudiant) {
        return new Etudiant(nom, age, numeroEtudiant);
    }
}

public class Enseignant extends Personne {
    private double salaire;

    public Enseignant(String nom, int age, double salaire) {
        super(nom, age);
        setSalaire(salaire);
    }

    public double getSalaire() { return salaire; }

    public void setSalaire(double salaire) {
        if (salaire < 0)
            throw new IllegalArgumentException("Le salaire ne peut pas être négatif");
        this.salaire = salaire;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Enseignant: " + getNom() + " | Salaire: " + salaire + " €");
    }

    @Override
    public String toString() {
        return "Enseignant: " + getNom() + ", " + getAge() + " ans | Salaire: " + salaire + " €";
    }
}

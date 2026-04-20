// LSP : EtudiantDecorator est substituable partout ou Personne est attendue
public abstract class EtudiantDecorator extends Personne {
    protected Etudiant etudiant;

    public EtudiantDecorator(Etudiant etudiant) {
        super(etudiant.getNom(), etudiant.getAge());
        this.etudiant = etudiant;
    }

    @Override
    public void afficher() {
        etudiant.afficher();
    }
}

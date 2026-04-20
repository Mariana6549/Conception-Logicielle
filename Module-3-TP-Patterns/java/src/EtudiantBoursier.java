public class EtudiantBoursier extends EtudiantDecorator {
    private double montantBourse;

    public EtudiantBoursier(Etudiant etudiant, double montantBourse) {
        super(etudiant);
        this.montantBourse = montantBourse;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("    [BOURSIER] Montant de la bourse : " + montantBourse + " euros");
    }
}

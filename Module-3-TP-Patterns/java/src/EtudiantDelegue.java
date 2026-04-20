public class EtudiantDelegue extends EtudiantDecorator {
    private String classe;

    public EtudiantDelegue(Etudiant etudiant, String classe) {
        super(etudiant);
        this.classe = classe;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("    [DELEGUE] Delegue de la classe : " + classe);
    }
}

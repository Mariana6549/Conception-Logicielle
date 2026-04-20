// Pattern Observer - interface sujet (ISP : interface ciblée)
public interface Sujet {
    void ajouterObservateur(Observateur o);
    void supprimerObservateur(Observateur o);
    void notifierObservateurs(String message);
}

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));

        // TP 1 : Héritage
        System.out.println("TP 1 : Héritage");
        Etudiant e1 = new Etudiant("Alice Martin", 20, "E001", 15.5);
        e1.ajouterCours(new Cours("Mathématiques", "M. Dupont"));
        e1.ajouterCours(new Cours("Informatique", "Mme Leroy"));

        Etudiant e2 = new Etudiant("Bob Durand", 22, "E002", 12.0);
        e2.ajouterCours(new Cours("Physique", "M. Moreau"));

        System.out.println(e1);
        System.out.println(e2);

        // TP 2 : Encapsulation
        System.out.println("TP 2 : Encapsulation");
        try {
            e1.setMoyenne(25); // valeur invalide : doit lever une exception
        } catch (IllegalArgumentException ex) {
            System.out.println("Erreur attendue : " + ex.getMessage());
        }

        try {
            e2.setAge(-5); // âge invalide
        } catch (IllegalArgumentException ex) {
            System.out.println("Erreur attendue : " + ex.getMessage());
        }

        System.out.println();

        // TP 3 : Polymorphisme
        System.out.println("TP 3 : Polymorphisme");
        Enseignant prof1 = new Enseignant("M. Dupont", 45, 3500.0);
        Enseignant prof2 = new Enseignant("Mme Leroy", 38, 3200.0);

        List<Personne> membres = new ArrayList<>();
        membres.add(e1);
        membres.add(e2);
        membres.add(prof1);
        membres.add(prof2);

        for (Personne p : membres) {
            p.afficherDetails();
        }
    }
}

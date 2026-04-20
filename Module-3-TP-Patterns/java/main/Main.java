public class Main {
    public static void main(String[] args) {

        System.out.println("=== SYSTEME DE GESTION ACADEMIQUE ===\n");

        // 1. SINGLETON
        System.out.println("1. SINGLETON");
        ScolariteManager manager = ScolariteManager.getInstance();
        System.out.println("   Meme instance ? " + (manager == ScolariteManager.getInstance()));

        // 2. FACTORY METHOD
        System.out.println("\n2. FACTORY METHOD");
        Etudiant alice   = (Etudiant)   PersonneFactory.getFactory("etudiant").creer("Alice",   20, "E001");
        Etudiant bob     = (Etudiant)   PersonneFactory.getFactory("etudiant").creer("Bob",     22, "E002");
        Etudiant charlie = (Etudiant)   PersonneFactory.getFactory("etudiant").creer("Charlie", 21, "E003");
        Professeur prof  = (Professeur) PersonneFactory.getFactory("professeur").creer("Prof. Martin", 45, "Informatique");
        alice.afficher();
        prof.afficher();

        // 4. ADAPTER
        System.out.println("\n4. ADAPTER");
        Cours[] cours = new CoursAdapter(new LegacyCoursSystem()).getAllCours();
        for (Cours c : cours) System.out.println("   Importe : " + c);

        alice.ajouterCours(cours[0]); alice.ajouterCours(cours[1]);
        bob.ajouterCours(cours[0]);   charlie.ajouterCours(cours[2]);

        manager.ajouterEtudiant(alice);
        manager.ajouterEtudiant(bob);
        manager.ajouterEtudiant(charlie);

        // 6. OBSERVER
        System.out.println("\n6. OBSERVER");
        alice.ajouterNote(15.5);
        bob.ajouterNote(12.0);
        charlie.ajouterNote(18.0);

        // 3. DECORATOR
        System.out.println("\n3. DECORATOR");
        new EtudiantBoursier(alice, 500.0).afficher();
        System.out.println();
        new EtudiantDelegue(bob, "L3 INFO").afficher();

        // 5. STRATEGY
        System.out.println("\n5. STRATEGY - tri par moyenne :");
        manager.setTriStrategy(new TriParMoyenne());
        manager.getEtudiantsTries().forEach(e ->
            System.out.printf("   %-10s -> %.1f%n", e.getNom(), e.getMoyenne()));

        System.out.println("   Changement -> tri par nom :");
        manager.setTriStrategy(new TriParNom());
        manager.getEtudiantsTries().forEach(e ->
            System.out.printf("   %-10s -> %.1f%n", e.getNom(), e.getMoyenne()));
    }
}

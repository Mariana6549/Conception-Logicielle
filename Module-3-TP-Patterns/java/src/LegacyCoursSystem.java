// Ancien systeme legacy - implementer l'interface pour respecter DIP
public class LegacyCoursSystem implements ILegacyCoursSystem {

    @Override
    public String getCours() {
        return "Algorithmique;Prof. Martin";
    }

    @Override
    public String[] getAllCours() {
        return new String[]{
            "Algorithmique;Prof. Martin",
            "Base de Donnees;Prof. Dubois",
            "Reseaux;Prof. Bernard"
        };
    }
}

import java.util.HashMap;
import java.util.Map;

// OCP : registre extensible sans modifier cette classe
// DIP : le client depend de PersonneFactory (abstraction), pas des sous-classes
public abstract class PersonneFactory {

    private static final Map<String, PersonneFactory> REGISTRY = new HashMap<>();

    static {
        REGISTRY.put("etudiant",   new EtudiantFactory());
        REGISTRY.put("professeur", new ProfesseurFactory());
    }

    public abstract Personne creer(String nom, int age, String extra);

    public static PersonneFactory getFactory(String type) {
        PersonneFactory factory = REGISTRY.get(type.toLowerCase());
        if (factory == null) throw new IllegalArgumentException("Type inconnu : " + type);
        return factory;
    }

    // OCP : permet d'enregistrer un nouveau type sans toucher cette classe
    public static void enregistrer(String type, PersonneFactory factory) {
        REGISTRY.put(type.toLowerCase(), factory);
    }
}

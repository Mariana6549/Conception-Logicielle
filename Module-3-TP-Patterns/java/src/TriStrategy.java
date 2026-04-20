import java.util.List;

// Pattern Strategy - interface commune (OCP : ouvert à l'extension)
public interface TriStrategy {
    List<Etudiant> trier(List<Etudiant> etudiants);
}

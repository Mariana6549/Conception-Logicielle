import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TriParNom implements TriStrategy {
    @Override
    public List<Etudiant> trier(List<Etudiant> etudiants) {
        return etudiants.stream()
                .sorted(Comparator.comparing(Etudiant::getNom))
                .collect(Collectors.toList());
    }
}

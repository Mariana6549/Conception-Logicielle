import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TriParMoyenne implements TriStrategy {
    @Override
    public List<Etudiant> trier(List<Etudiant> etudiants) {
        return etudiants.stream()
                .sorted(Comparator.comparingDouble(Etudiant::getMoyenne).reversed())
                .collect(Collectors.toList());
    }
}

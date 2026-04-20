// DIP : depend de ILegacyCoursSystem (abstraction), pas de LegacyCoursSystem (concret)
public class CoursAdapter {
    private ILegacyCoursSystem legacy;

    public CoursAdapter(ILegacyCoursSystem legacy) {
        this.legacy = legacy;
    }

    public Cours getCours() {
        return parse(legacy.getCours());
    }

    public Cours[] getAllCours() {
        String[] raw = legacy.getAllCours();
        Cours[] cours = new Cours[raw.length];
        for (int i = 0; i < raw.length; i++) {
            cours[i] = parse(raw[i]);
        }
        return cours;
    }

    private Cours parse(String data) {
        String[] parts = data.split(";");
        return new Cours(parts[0].trim(), parts[1].trim());
    }
}

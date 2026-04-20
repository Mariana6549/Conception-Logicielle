import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestAdapter {

    @Test
    void testParseUnCours() {
        CoursAdapter adapter = new CoursAdapter(new LegacyCoursSystem());
        Cours c = adapter.getCours();
        assertEquals("Algorithmique", c.getNomCours());
        assertEquals("Prof. Martin", c.getProfesseur());
    }

    @Test
    void testParseAllCours() {
        CoursAdapter adapter = new CoursAdapter(new LegacyCoursSystem());
        assertEquals(3, adapter.getAllCours().length);
    }

    @Test
    void testDIPAvecFakeLegacy() {
        // DIP : on peut injecter n'importe quelle implementation de ILegacyCoursSystem
        ILegacyCoursSystem fake = new ILegacyCoursSystem() {
            public String getCours() { return "Physique;Prof. Curie"; }
            public String[] getAllCours() { return new String[]{ "Physique;Prof. Curie" }; }
        };
        Cours c = new CoursAdapter(fake).getCours();
        assertEquals("Physique", c.getNomCours());
    }
}

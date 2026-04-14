from src.cours import Cours

class TestCours:
    def test_creation(self):
        c = Cours("Mathématiques", "M. Dupont")
        assert c.nom == "Mathématiques"
        assert c.professeur == "M. Dupont"

    def test_str(self):
        c = Cours("Mathématiques", "M. Dupont")
        assert "Mathématiques" in str(c)
        assert "M. Dupont" in str(c)

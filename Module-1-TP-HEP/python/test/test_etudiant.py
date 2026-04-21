import pytest
from src.personne import Personne
from src.cours import Cours
from src.etudiant import Etudiant

class TestEtudiant:
    def test_creation(self):
        e = Etudiant("Alice Martin", 20, "E001", 15.5)
        assert e.nom == "Alice Martin"
        assert e.age == 20
        assert e.numero == "E001"
        assert e.moyenne == 15.5

    def test_heritage(self):
        e = Etudiant("Alice Martin", 20, "E001", 15.5)
        assert isinstance(e, Personne)

    def test_ajouter_cours(self):
        e = Etudiant("Alice Martin", 20, "E001", 15.5)
        e.ajouter_cours(Cours("Mathématiques", "M. Dupont"))
        assert len(e.cours) == 1

    def test_plusieurs_cours(self):
        e = Etudiant("Alice Martin", 20, "E001", 15.5)
        e.ajouter_cours(Cours("Mathématiques", "M. Dupont"))
        e.ajouter_cours(Cours("Informatique", "Mme Leroy"))
        assert len(e.cours) == 2

    def test_str(self):
        e = Etudiant("Alice Martin", 20, "E001", 15.5)
        e.ajouter_cours(Cours("Mathématiques", "M. Dupont"))
        assert "Alice Martin" in str(e)
        assert "E001" in str(e)
        assert "Mathématiques" in str(e)

    def test_moyenne_invalide_construction(self):
        with pytest.raises(ValueError):
            Etudiant("Alice", 20, "E001", -1)
        with pytest.raises(ValueError):
            Etudiant("Alice", 20, "E001", 25)

    def test_setter_moyenne_invalide(self):
        e = Etudiant("Alice Martin", 20, "E001", 15.5)
        with pytest.raises(ValueError):
            e.moyenne = 25

    def test_setter_moyenne_valide(self):
        e = Etudiant("Alice Martin", 20, "E001", 15.5)
        e.moyenne = 18.0
        assert e.moyenne == 18.0

import pytest
from src.personne import Personne
from src.enseignant import Enseignant

class TestEnseignant:
    def test_creation(self):
        en = Enseignant("M. Dupont", 45, 3500.0)
        assert en.nom == "M. Dupont"
        assert en.age == 45
        assert en.salaire == 3500.0

    def test_heritage(self):
        en = Enseignant("M. Dupont", 45, 3500.0)
        assert isinstance(en, Personne)

    def test_salaire_negatif(self):
        with pytest.raises(ValueError):
            Enseignant("M. Dupont", 45, -100)

    def test_setter_salaire_invalide(self):
        en = Enseignant("M. Dupont", 45, 3500.0)
        with pytest.raises(ValueError):
            en.salaire = -500

    def test_str(self):
        en = Enseignant("M. Dupont", 45, 3500.0)
        assert "M. Dupont" in str(en)
        assert "3500" in str(en)

    def test_afficher_details(self, capsys):
        en = Enseignant("M. Dupont", 45, 3500.0)
        en.afficher_details()
        captured = capsys.readouterr()
        assert "M. Dupont" in captured.out
        assert "3500" in captured.out

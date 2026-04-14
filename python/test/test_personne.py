import pytest
from src.personne import Personne

class TestPersonne:
    def test_creation(self):
        p = Personne("Alice", 20)
        assert p.nom == "Alice"
        assert p.age == 20

    def test_str(self):
        p = Personne("Alice", 20)
        assert "Alice" in str(p)
        assert "20" in str(p)

    def test_age_invalide(self):
        with pytest.raises(ValueError):
            Personne("Alice", -1)
        with pytest.raises(ValueError):
            Personne("Alice", 101)

    def test_nom_vide(self):
        with pytest.raises(ValueError):
            Personne("", 20)

    def test_setter_age_valide(self):
        p = Personne("Alice", 20)
        p.age = 25
        assert p.age == 25

    def test_setter_age_invalide(self):
        p = Personne("Alice", 20)
        with pytest.raises(ValueError):
            p.age = -5

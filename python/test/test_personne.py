import pytest
from src.personne import Personne

# Personne est abstraite : on crée une sous-classe concrète pour les tests
class PersonneTest(Personne):
    def afficher_details(self) -> None:
        print(str(self))

class TestPersonne:
    def test_creation(self):
        p = PersonneTest("Alice", 20)
        assert p.nom == "Alice"
        assert p.age == 20

    def test_str(self):
        p = PersonneTest("Alice", 20)
        assert "Alice" in str(p)
        assert "20" in str(p)

    def test_age_invalide(self):
        with pytest.raises(ValueError):
            PersonneTest("Alice", -1)
        with pytest.raises(ValueError):
            PersonneTest("Alice", 101)

    def test_nom_vide(self):
        with pytest.raises(ValueError):
            PersonneTest("", 20)

    def test_setter_age_valide(self):
        p = PersonneTest("Alice", 20)
        p.age = 25
        assert p.age == 25

    def test_setter_age_invalide(self):
        p = PersonneTest("Alice", 20)
        with pytest.raises(ValueError):
            p.age = -5

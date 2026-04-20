import sys, os
sys.path.insert(0, os.path.join(os.path.dirname(__file__), '..', 'src'))

import pytest
from models import Etudiant, Professeur, Cours
from singleton import ScolariteManager
from factory import PersonneFactory, EtudiantFactory, ProfesseurFactory
from adapter import LegacyCoursSystem, CoursAdapter
from decorator import EtudiantBoursier, EtudiantDelegue
from strategy import TriParMoyenne, TriParNom
from interfaces import Observateur, ILegacyCoursSystem


# ── SINGLETON ─────────────────────────────────────────────────────────────────

def test_singleton_meme_instance():
    assert ScolariteManager() is ScolariteManager()

def test_singleton_ajout_etudiant():
    manager = ScolariteManager()
    avant = len(manager.etudiants)
    manager.ajouter_etudiant(Etudiant("Test", 20, "T001"))
    assert len(manager.etudiants) == avant + 1


# ── FACTORY METHOD ────────────────────────────────────────────────────────────

def test_factory_creer_etudiant():
    p = PersonneFactory.get_factory("etudiant").creer("Alice", 20, "E001")
    assert isinstance(p, Etudiant)
    assert p.nom == "Alice"

def test_factory_creer_professeur():
    p = PersonneFactory.get_factory("professeur").creer("Prof. Martin", 45, "Info")
    assert isinstance(p, Professeur)

def test_factory_type_inconnu():
    with pytest.raises(ValueError):
        PersonneFactory.get_factory("robot")

def test_factory_ocp_enregistrer():
    # OCP : extension sans modification
    PersonneFactory.enregistrer("superviseur", ProfesseurFactory())
    p = PersonneFactory.get_factory("superviseur").creer("Alice", 35, "Gestion")
    assert isinstance(p, Professeur)


# ── ADAPTER ───────────────────────────────────────────────────────────────────

def test_adapter_parse_un_cours():
    c = CoursAdapter(LegacyCoursSystem()).get_cours()
    assert c.nom_cours == "Algorithmique"
    assert c.professeur == "Prof. Martin"

def test_adapter_parse_all_cours():
    assert len(CoursAdapter(LegacyCoursSystem()).get_all_cours()) == 3

def test_adapter_dip_fake_legacy():
    # DIP : on injecte une fausse implementation
    class FakeLegacy(ILegacyCoursSystem):
        def get_cours(self): return "Physique;Prof. Curie"
        def get_all_cours(self): return ["Physique;Prof. Curie"]

    c = CoursAdapter(FakeLegacy()).get_cours()
    assert c.nom_cours == "Physique"


# ── DECORATOR ─────────────────────────────────────────────────────────────────

def test_boursier_affichage(capsys):
    EtudiantBoursier(Etudiant("Alice", 20, "E001"), 500.0).afficher()
    assert "BOURSIER" in capsys.readouterr().out

def test_delegue_affichage(capsys):
    EtudiantDelegue(Etudiant("Bob", 22, "E002"), "L3 INFO").afficher()
    assert "L3 INFO" in capsys.readouterr().out

def test_etudiant_original_inchange():
    e = Etudiant("Alice", 20, "E001")
    EtudiantBoursier(e, 500.0)
    assert e.nom == "Alice"


# ── STRATEGY ──────────────────────────────────────────────────────────────────

@pytest.fixture
def etudiants():
    a = Etudiant("Alice",   20, "E001"); a.ajouter_note(15.5)
    b = Etudiant("Bob",     22, "E002"); b.ajouter_note(12.0)
    c = Etudiant("Charlie", 21, "E003"); c.ajouter_note(18.0)
    return [a, b, c]

def test_tri_par_moyenne(etudiants):
    tries = TriParMoyenne().trier(etudiants)
    assert tries[0].nom == "Charlie"
    assert tries[2].nom == "Bob"

def test_tri_par_nom(etudiants):
    tries = TriParNom().trier(etudiants)
    assert tries[0].nom == "Alice"
    assert tries[2].nom == "Charlie"


# ── OBSERVER ──────────────────────────────────────────────────────────────────

class FakeObservateur(Observateur):
    def __init__(self): self.messages = []
    def mettre_a_jour(self, msg, e): self.messages.append(msg)

def test_notification_note():
    e = Etudiant("Alice", 20, "E001")
    obs = FakeObservateur()
    e.ajouter_observateur(obs)
    e.ajouter_note(15.5)
    assert len(obs.messages) == 1
    assert "15.5" in obs.messages[0]

def test_plusieurs_observateurs():
    e = Etudiant("Bob", 22, "E002")
    obs1, obs2 = FakeObservateur(), FakeObservateur()
    e.ajouter_observateur(obs1)
    e.ajouter_observateur(obs2)
    e.ajouter_note(12.0)
    assert len(obs1.messages) == 1
    assert len(obs2.messages) == 1

def test_desabonnement():
    e = Etudiant("Charlie", 21, "E003")
    obs = FakeObservateur()
    e.ajouter_observateur(obs)
    e.supprimer_observateur(obs)
    e.ajouter_note(18.0)
    assert len(obs.messages) == 0

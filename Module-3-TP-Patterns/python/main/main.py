import sys, os
sys.path.insert(0, os.path.join(os.path.dirname(__file__), '..', 'src'))

from models import Etudiant
from singleton import ScolariteManager
from factory import PersonneFactory
from adapter import LegacyCoursSystem, CoursAdapter
from decorator import EtudiantBoursier, EtudiantDelegue
from strategy import TriParMoyenne, TriParNom

print("=== SYSTEME DE GESTION ACADEMIQUE ===\n")

# 1. SINGLETON
print("1. SINGLETON")
manager = ScolariteManager()
print(f"   Meme instance ? {manager is ScolariteManager()}")

# 2. FACTORY METHOD
print("\n2. FACTORY METHOD")
alice   = PersonneFactory.get_factory("etudiant").creer("Alice",   20, "E001")
bob     = PersonneFactory.get_factory("etudiant").creer("Bob",     22, "E002")
charlie = PersonneFactory.get_factory("etudiant").creer("Charlie", 21, "E003")
prof    = PersonneFactory.get_factory("professeur").creer("Prof. Martin", 45, "Informatique")
alice.afficher()
prof.afficher()

# 4. ADAPTER
print("\n4. ADAPTER")
cours = CoursAdapter(LegacyCoursSystem()).get_all_cours()
for c in cours:
    print(f"   Importe : {c}")

alice.ajouter_cours(cours[0]); alice.ajouter_cours(cours[1])
bob.ajouter_cours(cours[0]);   charlie.ajouter_cours(cours[2])

manager.ajouter_etudiant(alice)
manager.ajouter_etudiant(bob)
manager.ajouter_etudiant(charlie)

# 6. OBSERVER
print("\n6. OBSERVER")
alice.ajouter_note(15.5)
bob.ajouter_note(12.0)
charlie.ajouter_note(18.0)

# 3. DECORATOR
print("\n3. DECORATOR")
EtudiantBoursier(alice, 500.0).afficher()
print()
EtudiantDelegue(bob, "L3 INFO").afficher()

# 5. STRATEGY
print("\n5. STRATEGY - tri par moyenne :")
manager.set_tri_strategy(TriParMoyenne())
for e in manager.get_etudiants_tries():
    print(f"   {e.nom:<10} -> {e.moyenne}")

print("   Changement -> tri par nom :")
manager.set_tri_strategy(TriParNom())
for e in manager.get_etudiants_tries():
    print(f"   {e.nom:<10} -> {e.moyenne}")

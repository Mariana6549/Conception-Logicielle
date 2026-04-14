from src.etudiant import Etudiant
from src.enseignant import Enseignant
from src.cours import Cours

# TP 1 : Héritage
print("TP 1 : Héritage")
e1 = Etudiant("Alice Martin", 20, "E001", 15.5)
e1.ajouter_cours(Cours("Mathématiques", "M. Dupont"))
e1.ajouter_cours(Cours("Informatique", "Mme Leroy"))

e2 = Etudiant("Bob Durand", 22, "E002", 12.0)
e2.ajouter_cours(Cours("Physique", "M. Moreau"))

print(e1)
print(e2)

# TP 2 : Encapsulation
print("TP 2 : Encapsulation")
try:
    e1.moyenne = 25  # valeur invalide : doit lever une exception
except ValueError as ex:
    print(f"Erreur attendue : {ex}")

try:
    e2.age = -5  # âge invalide
except ValueError as ex:
    print(f"Erreur attendue : {ex}")

print()

# TP 3 : Polymorphisme
print("TP 3 : Polymorphisme")
prof1 = Enseignant("M. Dupont", 45, 3500.0)
prof2 = Enseignant("Mme Leroy", 38, 3200.0)

membres = [e1, e2, prof1, prof2]
for p in membres:
    p.afficher_details()

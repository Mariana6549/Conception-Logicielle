from abc import ABC, abstractmethod
from interfaces import Sujet


class Personne(ABC):
    def __init__(self, nom: str, age: int):
        self.nom = nom
        self.age = age

    @abstractmethod
    def afficher(self) -> None:
        pass


class Cours:
    def __init__(self, nom_cours: str, professeur: str):
        self.nom_cours  = nom_cours
        self.professeur = professeur

    def __str__(self):
        return f"{self.nom_cours} (Prof: {self.professeur})"


class Etudiant(Personne, Sujet):
    def __init__(self, nom: str, age: int, numero_etudiant: str):
        super().__init__(nom, age)
        self.numero_etudiant = numero_etudiant
        self.moyenne         = 0.0
        self.liste_cours     = []
        self._observateurs   = []

    def ajouter_note(self, note: float) -> None:
        self.moyenne = note
        self.notifier_observateurs(f"Note mise a jour : {note} pour {self.nom}")

    def ajouter_cours(self, cours: Cours) -> None:
        self.liste_cours.append(cours)

    def afficher(self) -> None:
        print(f"Etudiant : {self.nom} | Age : {self.age} "
              f"| N : {self.numero_etudiant} | Moyenne : {self.moyenne}")
        for c in self.liste_cours:
            print(f"    -> {c}")

    def ajouter_observateur(self, o) -> None:    self._observateurs.append(o)
    def supprimer_observateur(self, o) -> None:  self._observateurs.remove(o)
    def notifier_observateurs(self, message: str) -> None:
        for o in self._observateurs:
            o.mettre_a_jour(message, self)


class Professeur(Personne):
    def __init__(self, nom: str, age: int, specialite: str):
        super().__init__(nom, age)
        self.specialite = specialite

    def afficher(self) -> None:
        print(f"Professeur : {self.nom} | Age : {self.age} | Specialite : {self.specialite}")

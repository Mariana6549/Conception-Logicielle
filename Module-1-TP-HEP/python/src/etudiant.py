from typing import List
from .personne import Personne
from .interfaces import ICours

class Etudiant(Personne):
    def __init__(self, nom: str, age: int, numero: str, moyenne: float):
        super().__init__(nom, age)
        self.numero = numero
        self.moyenne = moyenne
        self._cours: List[ICours] = []  # DIP : dépend de l'interface ICours, pas de Cours

    @property
    def cours(self) -> List[ICours]:
        return self._cours

    @property
    def moyenne(self) -> float:
        return self._moyenne

    @moyenne.setter
    def moyenne(self, valeur: float):
        if valeur < 0 or valeur > 20:
            raise ValueError("La moyenne doit être entre 0 et 20")
        self._moyenne = valeur

    def ajouter_cours(self, cours: ICours) -> None:  # DIP : accepte n'importe quelle implémentation de ICours
        self._cours.append(cours)

    def afficher_details(self) -> None:
        print(f"Étudiant: {self.nom} | N°{self.numero} | Moyenne: {self.moyenne}")

    def __str__(self):
        details = f"Étudiant: {self.nom} | N°{self.numero} | Âge: {self.age} | Moyenne: {self.moyenne}\n"
        details += "  Cours inscrits:\n"
        for c in self._cours:
            details += f"    - {c}\n"
        return details

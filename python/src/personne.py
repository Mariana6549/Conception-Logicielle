from abc import abstractmethod
from .interfaces import Affichable

class Personne(Affichable):
    def __init__(self, nom: str, age: int):
        self.nom = nom
        self.age = age

    @property
    def nom(self) -> str:
        return self._nom

    @nom.setter
    def nom(self, valeur: str):
        if not valeur or not valeur.strip():
            raise ValueError("Le nom ne peut pas être vide")
        self._nom = valeur

    @property
    def age(self) -> int:
        return self._age

    @age.setter
    def age(self, valeur: int):
        if valeur < 0 or valeur > 100:
            raise ValueError("L'âge doit être entre 0 et 100")
        self._age = valeur

    # Chaque sous-classe DOIT implémenter afficher_details() (OCP + ISP)
    @abstractmethod
    def afficher_details(self) -> None:
        pass

    def __str__(self):
        return f"Personne: {self.nom}, {self.age} ans"

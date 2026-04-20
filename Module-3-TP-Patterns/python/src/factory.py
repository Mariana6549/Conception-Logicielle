from abc import ABC, abstractmethod
from models import Personne, Etudiant, Professeur


# OCP : registre extensible — ajout d'un type sans modifier PersonneFactory
class PersonneFactory(ABC):
    _registry: dict = {}

    @abstractmethod
    def creer(self, nom: str, age: int, extra: str) -> Personne:
        pass

    @classmethod
    def get_factory(cls, type_: str) -> "PersonneFactory":
        factory = cls._registry.get(type_.lower())
        if factory is None:
            raise ValueError(f"Type inconnu : {type_}")
        return factory

    @classmethod
    def enregistrer(cls, type_: str, factory: "PersonneFactory") -> None:
        cls._registry[type_.lower()] = factory


class EtudiantFactory(PersonneFactory):
    def creer(self, nom: str, age: int, extra: str) -> Etudiant:
        return Etudiant(nom, age, extra)


class ProfesseurFactory(PersonneFactory):
    def creer(self, nom: str, age: int, extra: str) -> Professeur:
        return Professeur(nom, age, extra)


# Enregistrement initial
PersonneFactory.enregistrer("etudiant",   EtudiantFactory())
PersonneFactory.enregistrer("professeur", ProfesseurFactory())

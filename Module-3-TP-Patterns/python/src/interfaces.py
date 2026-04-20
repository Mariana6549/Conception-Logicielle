from abc import ABC, abstractmethod


class Observateur(ABC):
    @abstractmethod
    def mettre_a_jour(self, message: str, etudiant) -> None:
        pass


class Sujet(ABC):
    @abstractmethod
    def ajouter_observateur(self, o: "Observateur") -> None: pass
    @abstractmethod
    def supprimer_observateur(self, o: "Observateur") -> None: pass
    @abstractmethod
    def notifier_observateurs(self, message: str) -> None: pass


class TriStrategy(ABC):
    @abstractmethod
    def trier(self, etudiants: list) -> list:
        pass


# DIP : CoursAdapter depend de cette interface, pas de LegacyCoursSystem
class ILegacyCoursSystem(ABC):
    @abstractmethod
    def get_cours(self) -> str: pass
    @abstractmethod
    def get_all_cours(self) -> list[str]: pass

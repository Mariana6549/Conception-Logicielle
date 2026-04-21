from abc import ABC, abstractmethod

class Affichable(ABC):
    @abstractmethod
    def afficher_details(self) -> None:
        pass

class ICours(ABC):
    @property
    @abstractmethod
    def nom(self) -> str:
        pass

    @property
    @abstractmethod
    def professeur(self) -> str:
        pass

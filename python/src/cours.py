from .interfaces import ICours

class Cours(ICours):
    def __init__(self, nom: str, professeur: str):
        self._nom = nom
        self._professeur = professeur

    @property
    def nom(self) -> str:
        return self._nom

    @property
    def professeur(self) -> str:
        return self._professeur

    def __str__(self):
        return f"Cours: {self.nom} | Professeur: {self.professeur}"

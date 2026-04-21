from .personne import Personne

class Enseignant(Personne):
    def __init__(self, nom: str, age: int, salaire: float):
        super().__init__(nom, age)
        self.salaire = salaire

    @property
    def salaire(self) -> float:
        return self._salaire

    @salaire.setter
    def salaire(self, valeur: float):
        if valeur < 0:
            raise ValueError("Le salaire ne peut pas être négatif")
        self._salaire = valeur

    def afficher_details(self):
        print(f"Enseignant: {self.nom} | Salaire: {self.salaire} €")

    def __str__(self):
        return f"Enseignant: {self.nom}, {self.age} ans | Salaire: {self.salaire} €"

class Cours:
    def __init__(self, nom: str, professeur: str):
        self.nom = nom
        self.professeur = professeur

    def __str__(self):
        return f"Cours: {self.nom} | Professeur: {self.professeur}"

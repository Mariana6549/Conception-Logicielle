from interfaces import TriStrategy


class TriParMoyenne(TriStrategy):
    def trier(self, etudiants: list) -> list:
        return sorted(etudiants, key=lambda e: e.moyenne, reverse=True)


class TriParNom(TriStrategy):
    def trier(self, etudiants: list) -> list:
        return sorted(etudiants, key=lambda e: e.nom)

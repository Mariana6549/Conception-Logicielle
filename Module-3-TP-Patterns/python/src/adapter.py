from interfaces import ILegacyCoursSystem
from models import Cours


# DIP : LegacyCoursSystem implementee l'interface
class LegacyCoursSystem(ILegacyCoursSystem):
    def get_cours(self) -> str:
        return "Algorithmique;Prof. Martin"

    def get_all_cours(self) -> list[str]:
        return [
            "Algorithmique;Prof. Martin",
            "Base de Donnees;Prof. Dubois",
            "Reseaux;Prof. Bernard",
        ]


# DIP : depend de ILegacyCoursSystem, pas de LegacyCoursSystem
class CoursAdapter:
    def __init__(self, legacy: ILegacyCoursSystem):
        self._legacy = legacy

    def get_cours(self) -> Cours:
        return self._parse(self._legacy.get_cours())

    def get_all_cours(self) -> list[Cours]:
        return [self._parse(raw) for raw in self._legacy.get_all_cours()]

    @staticmethod
    def _parse(data: str) -> Cours:
        parts = data.split(";")
        return Cours(parts[0].strip(), parts[1].strip())

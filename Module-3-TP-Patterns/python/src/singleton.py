from interfaces import Observateur
from strategy import TriParNom


class ScolariteManager(Observateur):
    """Singleton + Observateur."""
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super().__new__(cls)
            cls._instance._etudiants    = []
            cls._instance._tri_strategy = TriParNom()
        return cls._instance

    def mettre_a_jour(self, message: str, etudiant) -> None:
        print(f"[ScolariteManager] Notification : {message}")
        self.afficher_statistiques()

    def ajouter_etudiant(self, etudiant) -> None:
        self._etudiants.append(etudiant)
        etudiant.ajouter_observateur(self)

    # OCP : strategie injectable
    def set_tri_strategy(self, strategy) -> None:
        self._tri_strategy = strategy

    def get_etudiants_tries(self) -> list:
        return self._tri_strategy.trier(self._etudiants)

    def afficher_statistiques(self) -> None:
        if not self._etudiants:
            return
        moyenne = sum(e.moyenne for e in self._etudiants) / len(self._etudiants)
        print(f"[Stats] {len(self._etudiants)} etudiant(s) | Moyenne generale : {moyenne:.2f}")

    @property
    def etudiants(self):
        return self._etudiants

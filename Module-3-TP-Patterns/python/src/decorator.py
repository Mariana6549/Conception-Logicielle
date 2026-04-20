from models import Personne, Etudiant


# LSP : EtudiantDecorator est substituable partout ou Personne est attendue
class EtudiantDecorator(Personne):
    def __init__(self, etudiant: Etudiant):
        super().__init__(etudiant.nom, etudiant.age)
        self._etudiant = etudiant

    def afficher(self) -> None:
        self._etudiant.afficher()


class EtudiantBoursier(EtudiantDecorator):
    def __init__(self, etudiant: Etudiant, montant_bourse: float):
        super().__init__(etudiant)
        self._montant_bourse = montant_bourse

    def afficher(self) -> None:
        super().afficher()
        print(f"    [BOURSIER] Montant de la bourse : {self._montant_bourse} euros")


class EtudiantDelegue(EtudiantDecorator):
    def __init__(self, etudiant: Etudiant, classe: str):
        super().__init__(etudiant)
        self._classe = classe

    def afficher(self) -> None:
        super().afficher()
        print(f"    [DELEGUE] Delegue de la classe : {self._classe}")

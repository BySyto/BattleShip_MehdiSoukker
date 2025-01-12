import java.util.ArrayList;
import java.util.List;

public class Plateau {

	private Case[][] tableau;
	private int taille=10;
	private List<Bateau> bateaux;

	public Plateau() {
		this.initialisationPlateau();
		this.bateaux = new ArrayList<>();
	}

    public void getTableau(Case[][] tableau) {
        this.tableau = tableau;
    }
	public void initialisationPlateau() {
		this.tableau = new Case[this.taille][this.taille];
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau[i].length; j++) {
				tableau[i][j] = new Case(i,j);
			}
		}
	}
	public Case getCase(int ligne, int colonne) {
		return this.tableau[ligne][colonne];
	}
    public void ajoutezBateau(Bateau bateau, int ligne, int colonne,String sens) {
        Case[][] casesBateau = bateau.getTableau();
        
        // Vérifiez si le bateau peut être placé sans collision
        if (verifierCollision(casesBateau, ligne, colonne) || verifierDepassement(casesBateau, ligne, colonne)) {
            System.out.println("Collision ou dépassement détecté. Le bateau ne peut pas être placé.");
            return;
        }

        if ("V".equals(sens)) {
            for (int i = 0; i < casesBateau.length; i++) {
            for (int j = 0; j < casesBateau[i].length; j++) {
                int x = ligne + i;
                int y = colonne + j;
                tableau[x][y] = casesBateau[i][j];
                tableau[x][y].setBateauId(bateau.getId());
            }
        }
        }else if ("H".equals(sens)) {
            for (int i = 0; i < casesBateau.length; i++) {
                for (int j = 0; j < casesBateau[i].length; j++) {
                    int x = ligne + j;
                    int y = colonne + i;
                    tableau[x][y] = casesBateau[i][j];
                    tableau[x][y].setBateauId(bateau.getId());

        }
    }
}
        // Ajoutez le bateau au plateau et définissez le bateau pour chaque case
        

        // Ajoutez le bateau à la liste des bateaux
        bateaux.add(bateau);
    }
	public boolean verifierCollision(Case[][] casesBateau, int startX, int startY) {
        for (int i = 0; i < casesBateau.length; i++) {
            for (int j = 0; j < casesBateau[i].length; j++) {
                int x = startX + i;
                int y = startY + j;
                if (x >= taille || y >= taille || tableau[x][y].getBateauId() != 0) {
                    return true;
                }
            }
        }
        return false;
    }
	public boolean verifierDepassement(Case[][] casesBateau, int startX, int startY) {
        for (int i = 0; i < casesBateau.length; i++) {
            for (int j = 0; j < casesBateau[i].length; j++) {
                int x = startX + i;
                int y = startY + j;
                if (x >= taille || y >= taille) {
                    return true;
                }
            }
        }
        return false;
    }

    public void afficherPlateau() {
        System.out.print("  ");
        for (int i = 0; i < taille; i++) {
            System.out.print((char) ('A' + i) + " ");
        }
        System.out.println();
        for (int i = 0; i < tableau.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < tableau[i].length; j++) {
                if (tableau[i][j] != null && tableau[i][j].getBateauId() != 0) {
                    System.out.print(tableau[i][j].getBateauId() + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
    public void afficherPlateauxTirs(Joueur joueur, Joueur adversaire) {
        System.out.println("Plateau de " + joueur.getNom() + ":");
        joueur.getPlateau().afficherPlateau();
    
        System.out.println("Plateau de " + adversaire.getNom() + ":");
        adversaire.getPlateau().afficherPlateau();
    }
    public Bateau getBateau(int id) {
        for (Bateau bateau : bateaux) {
            if (bateau.getId() == id) {
                return bateau;
            }
        }
        return null;

    }

 }

	
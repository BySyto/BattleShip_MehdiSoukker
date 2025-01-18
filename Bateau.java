public class Bateau {

	private int id;
	private String nom;
	private Case[][] tableau;

	public Bateau(int id, String nom, Case[][] tableau) {
		this.id = id;
		this.nom = nom;
		this.tableau = tableau;
	}
	// Méthode pour vérifier si le bateau est coulé
	public boolean estCoulee() {
		// Parcourt chaque ligne de cases du tableau
		for (Case[] casesLigne : tableau) {
			// Parcourt chaque case de la ligne
			for (Case c : casesLigne) {
				// Si une case pas touchée, le bateau pas coulé
				if (!c.getTouched()) {
					return false;
				}
			}
		}
		return true;
	}
	

	
	public Case getCase(int ligne , int colonne) {
		return this.tableau[ligne][colonne];
	}

	public int getTailleBateau() {
		
		return this.tableau.length;
	}

	public int getId() {
		return this.id;
	}

	public String getNom() {
		return this.nom;
	}

	public Case[][] getTableau() {
		return this.tableau;
	}

}
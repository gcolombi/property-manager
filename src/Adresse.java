public class Adresse {

	// Creation des variables pour une adresse

	private int nbreAdresse;
	private String rueAdresse;
	private String ville;

	// Creation du constructeur

	public Adresse(int nbreAdresse, String rueAdresse, String ville) {
		this.nbreAdresse = nbreAdresse;
		this.rueAdresse = rueAdresse;
		this.ville = ville;
	}

	// Creation des accesseurs et mutateurs

	public int getNbreAdresse() {
		return nbreAdresse;
	}

	public void setNbreAdresse(int nbreAdresse) {
		this.nbreAdresse = nbreAdresse;
	}

	public String getRueAdresse() {
		return rueAdresse;
	}

	public void setRueAdresse(String rueAdresse) {
		this.rueAdresse = rueAdresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	// Creation de la methode toString pour l'adresse

	public String toString() {

		String resultat;

		resultat = nbreAdresse + " " + rueAdresse + "\n";
		resultat += "Ville: " + ville;

		return resultat;
	}
}

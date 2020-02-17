//-------------------------------------------------------------------------------------------------------------------------//
//************************************************Devoir 4*****************************************************************//
//												  Auteurs															       //
//			par:  Kim Hardy (HARK12118400)      Gerard Colombi (COLG16058800)       Karyn Gagne (GAGK04549408)             //
//-------------------------------------------------------------------------------------------------------------------------//

public class Chalet {

	// Creation des variables d'un chalet

	private String nom;
	private int id;
	private Adresse adresseChalet;
	private int nbreChambres;
	private String Loue;
	private String entretien;			

	// Creation du constructeur

	public Chalet(String nom, int id, Adresse adresseChalet, int nbreChambres, String loue, String entretien) {

		this.nom = nom;
		this.id = id;
		this.adresseChalet = adresseChalet;
		this.nbreChambres = nbreChambres;
		this.Loue = loue;
		this.entretien = entretien;
	}

	// Creation des accesseurs et mutateurs

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Adresse getAdresseChalet() {
		return adresseChalet;
	}

	public void setAdresseChalet(Adresse adresseChalet) {
		this.adresseChalet = adresseChalet;
	}

	public int getNbreChambres() {
		return nbreChambres;
	}

	public void setNbreChambres(int nbreChambres) {
		this.nbreChambres = nbreChambres;
	}

	public String getLoue() {
		return Loue;
	}

	public void setLoue(String loue) {
		this.Loue = loue;
	}

	public String getEntretien() {
		return entretien;
	}

	public void setEntretien(String entretien) {
		this.entretien = entretien;
	}


	// Creation de la methode toString pour un chalet

	public String toString() {
		return "\nChalet: " + "\nNom: " + nom + "\n# d'identification: " + id +"\n"
				+ "Adresse du chalet: " + adresseChalet +"\n"
				+ "Nombre de chambres: " + nbreChambres +"\n"
				+ "Loue?: " + Loue + "\nEntretenu?: " + entretien +
				"\n______________________________________________________________________";
	}
}
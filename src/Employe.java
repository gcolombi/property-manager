//-------------------------------------------------------------------------------------------------------------------------//
//************************************************Devoir 4*****************************************************************//
//												  Auteurs															       //
//			par:  Kim Hardy (HARK12118400)      Gerard Colombi (COLG16058800)       Karyn Gagne (GAGK04549408)             //
//-------------------------------------------------------------------------------------------------------------------------//

import java.util.Arrays;

public class Employe implements Comparable <Employe> {

	// Creation des variables d'un chalet

	private String nom;
	private String prenom;
	private Double salaire;
	private String ville;
	private int id;
	private  boolean[] disponibilite;
	private Chalet [] chaletEntretien;   
	private int nbreChaletE;

	// Creation du constructeur

	public Employe(String nom, String prenom, Double salaire, String ville,int id, boolean[] disponibilite, Chalet [] chaletEntretien, int nbreChaletE) {

		this.nom = nom;
		this.prenom = prenom;
		this.salaire = salaire;
		this.ville = ville;
		this.id = id;
		this.disponibilite = disponibilite;
		this.chaletEntretien = chaletEntretien;
		this.nbreChaletE = nbreChaletE;
	}

	// Creation des accesseurs et mutateurs

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean[] getDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(boolean[] disponibilite) {
		this.disponibilite = disponibilite;															
	}

	public Chalet[] getChaletEntretien() {
		return chaletEntretien;
	}

	public void setChaletEntretien(Chalet[] chaletEntretien) {
		this.chaletEntretien = chaletEntretien;
	}

	public int getNbreChaletE() {
		return nbreChaletE;
	}

	public void setNbreChaletL(int nbreChaletE) {
		this.nbreChaletE = nbreChaletE;
	}

	// Creation de la methode toString pour un chalet

	public String toString() {
		return 	"___________________________________________________________________"+
				"\nInformation sur l'employe: " + "\nNom: " + nom + "\nPrenom:  " + prenom + "\n"
				+ "Salaire: " + salaire + "$ de l'heure" + "\nVille:  " + ville + "\n"
				+"Numero d'identification:  " + id + "\n"
				+"Journee de la semaine:  " + Arrays.toString(ListeEmployes.getJournee()) + "\n" 
				+ "Disponibilites: " + "\t" +  Arrays.toString(disponibilite) + "\nChalets Entretenu: " +
				"\t" + Arrays.toString(chaletEntretien) +
				"\n______________________________________________________________________";
	}

	// Creation de la methode compareTo pour comparer le salaire des employes.

	@Override
	public int compareTo(Employe comparesalaire) {

		if (getSalaire().compareTo(comparesalaire.getSalaire()) < 0)

			return 1;

		else if (getSalaire().compareTo(comparesalaire.getSalaire()) > 0)

			return -1;

		else

			return 0;

	}
}
//-------------------------------------------------------------------------------------------------------------------------//
//************************************************Devoir 4*****************************************************************//
//												  Auteurs															       //
//			par:  Kim Hardy (HARK12118400)      Gerard Colombi (COLG16058800)       Karyn Gagne (GAGK04549408)             //
//-------------------------------------------------------------------------------------------------------------------------//

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ListeEmployes {

	// Creation des variables pour la liste d'employes

	private static Scanner scan = new Scanner(System.in); 
	private static Employe[] liste;
	private static String[] journee = new String[]{"Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"};
	private static boolean[] disponibilite; 
	private static int nbreEmploye;
	private static Chalet[] chaletEntretien;



	// Creation d'un constructeur sans parametres

	public ListeEmployes() {

		liste = new Employe[5];	
		nbreEmploye = 0;
	}

	// Creation des accesseurs / mutateurs

	public static Employe[] getListe() {   
		return liste;
	}

	public void setListe(Employe[] liste) {
		ListeEmployes.liste = liste;
	}

	public static int getNbreEmploye() {
		return nbreEmploye;
	}

	public void setNbreEmploye(int nbreEmploye) {
		ListeEmployes.nbreEmploye = nbreEmploye;
	}

	public boolean[] getDisponibilite() {
		return disponibilite;
	}

	public static void setDisponibilite(boolean[] disponibilite) {
		ListeEmployes.disponibilite = disponibilite;
	}

	public static String[] getJournee() {
		return journee;
	}

	public static void setJournee(String[] journee) {
		ListeEmployes.journee = journee;
	}

	// Creation de la methode pour afficher les chalets etant associé a un employe

	public static void chaletsAssocies() {																											

		int index;
		try {
			System.out.println("S'il vous plait saisissez votre identifiant: ");																		
			index = scan.nextInt();
			for(int i =0; i<liste.length; i++) {

				if ( liste[i] == null) {																											
					continue;              
				}
				else if(liste[i].getId() == index) {
					System.out.println("Les chalets vous etant associes sont: " + Arrays.toString(liste[i].getChaletEntretien()));
				}
			}

		} catch (InputMismatchException e) {
			scan.next();
			System.out.println("======================================================================");
			System.out.println("Entree invalide.");
		}
	}

	// Creation de la methode pour afficher le salaire d'un employe (menu employe)

	public static void getEmployeSalaire() {

		int index;
		try {
			System.out.println("S'il vous plait choissisez votre identifiant: ");
			index = scan.nextInt();
			for(int i =0; i<liste.length; i++) {

				if ( liste[i] == null) {
					continue;
				}
				else if(liste[i].getId() == index) {
					System.out.println("Votre salaire est: " + liste[i].getSalaire());
				}
			}

		} catch (InputMismatchException e) {
			scan.next();
			System.out.println("======================================================================");
			System.out.println("Entree invalide.");
		}
	}

	// Creation de la methode pour afficher les disponibilites employe (menu employe)

	public static void getEmployeDispo() {

		int index;

		try {
			System.out.println("S'il vous plait choissisez votre identifiant: ");
			index = scan.nextInt();
			for(int i =0; i<liste.length; i++) {

				if ( liste[i] == null) {
					continue;
				}
				else if(liste[i].getId() == index) {
					System.out.println("Journee: " + Arrays.toString(ListeEmployes.getJournee()) + "\n"
							+ "Vos disponibilite sont : " + Arrays.toString(liste[i].getDisponibilite()));     
				}
			}

		} catch (InputMismatchException e) {
			scan.next();
			System.out.println("======================================================================");
			System.out.println("Entree invalide.");
		}
	}

	// Creation de la methode pour changer la disponibilite d'un employe (menu employe)

	public static void setEmployeDispo() {

		int choix;
		boolean exit = false;

		try {
			System.out.println("S'il vous plait saisissez votre identifiant: ");
			choix = scan.nextInt();

			for(int i =0; i<liste.length; i++) {																													

				if ( liste[i] == null) {
					continue; 

				}
				if(liste[i].getId() == choix) {
					System.out.println("Veuillez choisir la disponibilite a modifier: ");
					System.out.println("Journee: " + Arrays.toString(ListeEmployes.getJournee()) + "\n"
							+ "Vos disponibilite sont : " + Arrays.toString(liste[i].getDisponibilite()));

					int z;
					while(!exit){
						System.out.println("Veuillez choisir le jour par son numero correspondant: ");
						z = scan.nextInt();
						while (z < 1 || z > 7) {																									
							System.out.println("Veuillez choisir entre 1 et 7.");
							z = scan.nextInt();
						}

						System.out.println("Quel est votre disponibilite pour la journee choisie ? Oui ou Non.)");         
						String reponse = scan.next();

						if (reponse.equalsIgnoreCase("oui")) {

							Array.setBoolean(liste[i].getDisponibilite(), z-1, true);
							System.out.println("La disponibilite a ete sauvegarde.");
							break;
						}
						else if (reponse.equalsIgnoreCase("non")){

							Array.setBoolean(liste[i].getDisponibilite(), z-1, false);
							System.out.println("La disponibilite a ete sauvegarde.");
							break;
						}
						else
							System.out.println("Veuillez choisir par Oui ou Non.");				
						System.out.println("______________________________________________________________________");
					}
				}
			}

		} catch (InputMismatchException e) {
			scan.next();
			System.out.println("======================================================================");
			System.out.println("Entree invalide.");

		} 

	}

	// Creation de la methode affichage liste d'employes

	public static void affichageListeE() {									
		int index = 1;
		if (nbreEmploye == 0) {
			System.out.println("La liste est vide.");
			return;
		}

		for (Employe m : liste) {
			System.out.println((index++) + ": " + m);
		}
	}

	// Creation de la methode pour verifier si le numero d'identification est deja utilise

	public static boolean checkIdEmploye(Employe[] liste, int checkValue) {

		boolean test = true;

		for (int i = 0; i < liste.length; i++) {

			if (liste[i] == null) {
				return true;
			}
			else if(liste[i].getId() == checkValue){
				return false;
			}
		}
		return test;
	}

	// Creation de la methode pour ajouter un employe en entrant ses donnees

	public void addEmploye() {

		String prenom;
		String nom;
		double salaire;
		String  ville;
		int id;
		boolean success = false;
		int x;
		int index = 1;
		disponibilite = new boolean [7]; 
		String reponse;
		boolean exit = false;
		chaletEntretien = new Chalet[3];
		int nbreChaletE = 0;

		try{

			while(!success) {

				System.out.println("======================================================================");
				System.out.println("=                  Creation et ajout d'un employe.                   =");
				System.out.println("======================================================================");
				System.out.println("Entrez le prenom: ");
				prenom = scan.next();
				System.out.println("Entrez le nom: ");
				nom = scan.next();
				System.out.println("Entrez son salaire horaire: ");
				salaire= scan.nextDouble();
				scan.nextLine();
				System.out.println("Entrez sa ville: ");
				ville = scan.nextLine();
				System.out.println("Veuillez choisir un numero d'identification: ");

				while(true) {

					id = scan.nextInt();
					if(((3 == String.valueOf(id).length()) && (checkIdEmploye(liste, id))) ) {				
						break;
					}
					else 
						System.out.println("Veuillez choisir un numero a 3 chiffres ou qui n'est pas deja utilise: ");		
				}
				System.out.println ("Choisir les disponibilites de l'employe: ");

				for (String j : journee) {
					System.out.println((index++) + ": " + j);	
				}
				while(!exit){
					System.out.println("Veuillez choisir un ou plusieurs jours en entrant le numero correspondant: ");
					x = scan.nextInt();
					while(x < 1 || x > 7){
						System.out.println("Veuillez choisir un chiffre entre 1 et 7.");	
						x = scan.nextInt();
					}
					for (int i = x-1; i < disponibilite.length; i++) {
						Array.setBoolean(disponibilite, x-1, true);
					}

					System.out.println("Avez-vous termine de saisir vos disponibilites ? Oui ou Non.)");
					reponse = scan.next();
					while(!reponse.equalsIgnoreCase("oui") && !reponse.equalsIgnoreCase("non")) {
						System.out.println("Entrez Oui ou Non:");
						reponse = scan.next();
					}
					if (reponse.equalsIgnoreCase("oui")) {
						exit = true;
					}

				}

				success = true;

				if (nbreEmploye == liste.length)
					augmenterTailleE();

				liste [nbreEmploye] = new Employe(nom, prenom, salaire, ville,id, disponibilite, chaletEntretien, nbreChaletE); 								
				nbreEmploye++;	
			}

		} catch (InputMismatchException e) {
			scan.next();
			System.out.println("======================================================================");
			System.out.println("Entree invalide.");
		}
	}

	// Creation de la methode pour doubler le array initial au cas ou il n'y aurait plus de place dans le tableau

	public void augmenterTailleE() {

		Employe[] more = new Employe[liste.length * 2];


		for (int employe = 0; employe < liste.length; employe++)

			more[employe] = liste [employe];

		liste = more;
	}

	// Creation de la methode pour supprimer un employe dans la liste (menu proprietaire)

	public void supprEmploye() {

		if (nbreEmploye == 0) {
			System.out.println("La liste est vide.");
			return;
		}
		int choix;
		try {
			System.out.println("Veuillez choisir un employe par son numero correspondant: ");
			affichageListeE();
			choix = scan.nextInt();
			if (choix >= 1 && choix <= liste.length && liste[choix-1] != null) {

				for (int i = 0; i < liste.length; i++) {
					if (liste[i] != null && liste[i] == liste[choix-1]){												
						liste[i] = null;
						nbreEmploye--;
						moveNull();
						System.out.println("L'employe a ete supprime.");          
					}
				}
			}else System.out.println("L'employe n'existe pas.");
			System.out.println("======================================================================");

		} catch (InputMismatchException e) {
			scan.next();
			System.out.println("======================================================================");
			System.out.println("Cela n'est pas un nombre.");
		}
	}

	// Creation  de la methode pour corriger le Array apres suppresion

	public void moveNull() {

		for (int j = 0; j < liste.length; j++) {
			if (liste[j] == null) {
				for (int k = j + 1; k < liste.length; k++) {

				}
				liste[liste.length-1] = null;
			}
		}
	}

	// Creation de la methode pour modifier le salaire d'un employe (menu proprietaire)	 

	public static void modifierSalaire() {

		if (nbreEmploye == 0) {
			System.out.println("La liste est vide.");
			return;
		}
		int choix;
		try {
			double newSalaire;
			System.out.println("Veuillez choisir un employe par son numero: ");
			System.out.println();
			affichageListeE();
			choix = scan.nextInt();
			if (choix >= 1 && choix <= liste.length && liste[choix-1] != null) {                                           
				System.out.println("Voici le salaire de l'employe selectionne: " + liste[choix-1].getSalaire());
				scan.nextLine();
				System.out.println("Veuillez choisir le nouveau salaire horaire de l'employe selectionne: ");
				newSalaire = scan.nextDouble();
				liste[choix-1].setSalaire(newSalaire);
				System.out.println("Le nouveau salaire horaire a ete enregistre.");
			}else
				System.out.println("Lemploye n'existe pas.");
			System.out.println("======================================================================");

		} catch (InputMismatchException e) {
			scan.next();
			System.out.println("======================================================================");
			System.out.println("Cela n'est pas un nombre.");
		} 

	}

	// Creation de la methode pour afficher les disponibilite d'un employe (menu proprietaire)

	public static void afficherDispoEmp() {																							

		if (nbreEmploye == 0) {
			System.out.println("La liste est vide");
			return;
		}
		int choix;
		try {
			System.out.println("Veuillez choisir un employe par son numero: ");
			System.out.println();
			affichageListeE();
			choix = scan.nextInt();

			if (choix >= 1 && choix <= liste.length && liste[choix-1] != null) {
				System.out.println("Journee de la semaine:" + "\t\t\t" + Arrays.toString(ListeEmployes.getJournee()) + "\n"																
						+ "Voici les disponibilite de " + liste[choix-1].getPrenom() + " " + liste[choix-1].getNom() + ": " 
						+ Arrays.toString(liste[choix-1].getDisponibilite()));              
			}else
				System.out.println("Lemploye n'existe pas.");
			System.out.println("======================================================================");

		}catch (InputMismatchException e) {
			scan.next();
			System.out.println("======================================================================");
			System.out.println("Cela n'est pas un nombre.");
		}

	}

	// Creation de la methode pour comparer les salaire en utilisant le compareTo

	public static void comparerSalaire(){  																							

		int choix1, choix2;

		if (nbreEmploye == 0) {
			System.out.println("La liste est vide.");
			return;
		}
		if (nbreEmploye < 2) {
			System.out.println("Il n'y a pas assez d'employe dans la liste pour une comparaison de salaire.");

		} else {
			affichageListeE();

			try {
				System.out.println("Choisir le premier employe dont vous voulez comparer le salaire:");
				while (true) {
					choix1 = scan.nextInt();
					if (choix1 >= 1 && choix1 <= liste.length && liste[choix1-1] != null)
						break;
					System.out.println("Choix invalide, rechoisissez un employe.");
					System.out.println("======================================================================");
				}

				System.out.println("Choisir le deuxieme employe dont vous voulez comparer le salaire:");
				while(true) {
					choix2 = scan.nextInt();
					if (choix2 >= 1 && choix2 <= liste.length && liste[choix2-1] != null)
						break;
					System.out.println("Choix invalide, rechoisissez un employe.");
					System.out.println("======================================================================");
				}

				Employe employe1 = liste[choix1-1];
				Employe employe2 = liste[choix2-1];  

				if (employe1.compareTo(employe2) > 0) {

					System.out.println(employe2.getPrenom() + " " + employe2.getNom() + " a le meilleur salaire.");
				}
				else if (employe1.compareTo(employe2) < 0) {

					System.out.println(employe1.getPrenom() + " " + employe1.getNom() +" a le meilleur salaire.");
				}
				else {

					System.out.println(employe1.getPrenom() + " " + employe1.getNom() + " et " + employe2.getPrenom() + " " + employe2.getNom() + " ont le meme salaire.");
				}
			}catch (InputMismatchException e) {
				scan.next();
				System.out.println("======================================================================");
				System.out.println("Cela n'est pas un nombre.");
			}
		}

	}

	// Creation de la methode pour afficher les chalets associes a un employe (menu proprietaire)

	public void afficherChaletEmp() {

		if (nbreEmploye == 0) {
			System.out.println("La liste d'employes est vide");							
			return;
		}																						
		int choix;
		try {																		
			System.out.println("Veuillez choisir un employe par son numero: ");
			System.out.println();
			affichageListeE();
			choix = scan.nextInt();

			if (choix >= 1 && choix <= liste.length && liste[choix-1] != null) {															
				System.out.println("Les chalets associes a cet employe sont: " + Arrays.toString(liste[choix-1].getChaletEntretien()));

			}else
				System.out.println("Lemploye n'existe pas.");
			System.out.println("======================================================================");

		}catch (InputMismatchException e) {
			scan.next();
			System.out.println("======================================================================");
			System.out.println("Cela n'est pas un nombre.");
		}

	}

	// Creation de la methode pour ajouter un chalet a entretenir a un employe (menu proprietaire)

	public void chaletsEmployeAjout() {

		if (nbreEmploye == 0) {																	
			System.out.println("La liste est vide.");
			return;
		}
		int choix;
		int choixChalet;
		String entretien = "oui";

		try {

			System.out.println("Veuillez choisir un employe par son numero: ");
			System.out.println();						
			affichageListeE();
			choix = scan.nextInt();
			if (ListeChalets.getNbreChalet() == 0) {																	
				System.out.println("La liste est vide.");
				return;
			}
			if (choix >= 1 && choix <= liste.length && liste[choix-1] != null) {


				System.out.println("Veuillez choisir un chalet par son numero: ");
				ListeChalets.affichageListeC();	
				choixChalet = scan.nextInt();	
				if (choixChalet >= 1 && choixChalet <= ListeChalets.getListe().length && Array.get(ListeChalets.getListe(), choixChalet -1) != null) {				


					if (liste[choix-1].getNbreChaletE() < liste[choix-1].getChaletEntretien().length) {								

						Chalet chalet = (Chalet)Array.get(ListeChalets.getListe(), choixChalet -1);

						if (chalet.getEntretien() != "oui") {
							Array.set(liste[choix-1].getChaletEntretien(),liste[choix-1].getNbreChaletE(), chalet);
							liste[choix-1].setNbreChaletL(liste[choix-1].getNbreChaletE()+1);
							chalet.setEntretien(entretien);
							System.out.println("Le chalet a bien ete ajoute a la liste d'entretien de l'employe.");
						}else
							System.out.println("Le chalet est deja entretenu.");
					}
					else
						System.out.println("Le maximum de chalet a entretenir par employe est 3.");	
				}else 
					System.out.println("Le chalet n'existe pas.");	
				System.out.println("======================================================================");
			}else
				System.out.println("Lemploye n'existe pas.");
			System.out.println("======================================================================");

		} catch (InputMismatchException e) {
			scan.next();
			System.out.println("======================================================================");
			System.out.println("Cela n'est pas un nombre.");
		}	
	}

	// Creation de la methode pour supprimer un chalet entretenu par un employe

	public void chaletsEmployeSuppr() {																					

		if (nbreEmploye == 0) {
			System.out.println("La liste est vide.");
			return;
		}
		int choix;
		int index =1;
		int choixChalet;
		String entretien = "non";
		try {
			System.out.println("Veuillez choisir un employe par son numero: ");
			System.out.println();						
			affichageListeE();
			choix = scan.nextInt();
			if (ListeChalets.getNbreChalet() == 0) {
				System.out.println("La liste est vide.");
				return;
			}
			if (choix >= 1 && choix <= liste.length && liste[choix-1] != null) {
				System.out.println("Les chalets associes a cet employe sont: ");
				for(Chalet c : liste[choix-1].getChaletEntretien()) {										
					System.out.println();

					System.out.println((index++) + ": " + c);
				}
				System.out.println();
				System.out.println("Veuillez choisir un chalet a supprimer par son numero correspondant: ");
				choixChalet = scan.nextInt();
				if (choixChalet >= 1 && choixChalet <= liste[choix-1].getChaletEntretien().length && Array.get(liste[choix-1].getChaletEntretien(), choixChalet -1) != null) {

					Chalet chalet = (Chalet)Array.get(liste[choix-1].getChaletEntretien(), choixChalet -1);			
					chalet.setEntretien(entretien);

					for (int i = 0; i < liste[choix-1].getChaletEntretien().length; i++) {
						chaletEntretien = liste[choix-1].getChaletEntretien();
						if (chaletEntretien[i] != null && chaletEntretien[i] == chaletEntretien[choixChalet-1]){												
							chaletEntretien[i] = null;   
							liste[choix-1].setNbreChaletL(liste[choix-1].getNbreChaletE()-1);
							moveNullChaletE();																													

							System.out.println("Le chalet a ete supprime de la liste d'entretien de cet employe.");          								
						}
					}	

				}else
					System.out.println("Le chalet n'existe pas.");	
				System.out.println("======================================================================");

			}else
				System.out.println("Lemploye n'existe pas.");
			System.out.println("======================================================================");

		} catch (InputMismatchException e) {
			scan.next();
			System.out.println("======================================================================");
			System.out.println("Cela n'est pas un nombre.");
		}
	}

	// Creation  de la methode pour corriger le Array apres suppresion

	public void moveNullChaletE() {

		for (int j=0; j<chaletEntretien.length; j++){
			if (chaletEntretien[j]==null){
				for (int k=j+1; k<chaletEntretien.length; k++){
					chaletEntretien[k-1] = chaletEntretien[k];
				}
				chaletEntretien[chaletEntretien.length-1] = null;
				break;
			}
		}
	}
} 
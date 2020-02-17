//-------------------------------------------------------------------------------------------------------------------------//
//************************************************Devoir 4*****************************************************************//
//												  Auteurs															       //
//			par:  Kim Hardy (HARK12118400)      Gerard Colombi (COLG16058800)       Karyn Gagne (GAGK04549408)             //
//-------------------------------------------------------------------------------------------------------------------------//

import java.util.InputMismatchException;
import java.util.Scanner;

public class ListeChalets {

	// Creation des variables pour la liste de chalet et du scanner

	private static Scanner scan = new Scanner(System.in); 
	private static Chalet[] liste;
	private static int nbreChalet;

	// Creation du constructeur sans parametres

	public ListeChalets() {

		liste = new Chalet[5];
		nbreChalet = 0;

	}

	// Creation des accesseurs et mutateurs

	public static Chalet[] getListe() {
		return liste;
	}

	public void setListe(Chalet[] liste) {
		ListeChalets.liste = liste;
	}

	public static int getNbreChalet() {
		return nbreChalet;
	}

	public void setNbreChalet(int nbreChalet) {						
		ListeChalets.nbreChalet = nbreChalet;
	}

	// Creation de la methode pour afficher la liste de chalets

	public static void affichageListeC() {

		int index = 1;
		if (nbreChalet == 0) {
			System.out.println("La liste est vide.");
			return;
		}

		for (Chalet m : liste) {
			System.out.println((index++) + ": " + m);
		}
	}

	// Creation de la methode pour creer une adresse pour un nouveau chalet

	public static Adresse createChalet(Scanner scan) {

		System.out.println("Entrez le numero civique: ");
		int nbreAdresse = scan.nextInt();
		scan.nextLine();
		System.out.println("Entrez la rue: ");
		String rueAdresse = scan.nextLine();
		System.out.println("Entrez la ville: ");
		String ville = scan.nextLine();

		return new Adresse(nbreAdresse, rueAdresse, ville);
	}

	// Creation de la methode pour verifier si le numero d'identification est deja utilise

	public static boolean checkIdChalet(Chalet[] liste, int checkValue) {

		boolean test = true;

		for(int i =0; i < liste.length; i++) {

			if (liste[i] == null) {
				return true;
			}
			else if(liste[i].getId() == checkValue){
				return false;
			}
		}
		return test;
	}

	// Creation de la methode pour ajouter un chalet en entrant ses donnees

	public void addChalet() {

		String name;
		int idc;
		int numChambres;
		String reponse;
		String reponse1 = null;
		boolean success = false;

		try{
			while(!success) {

				System.out.println("======================================================================");
				System.out.println("=                   Creation et ajout d'un chalet.                   =");
				System.out.println("======================================================================");
				System.out.println("Entrez le nom du chalet: ");
				name = scan.nextLine();
				System.out.println("Veuillez choisir un numero d'identification a 5 chiffres pour le chalet.");

				while(true) {

					idc = scan.nextInt();
					if(((5 == String.valueOf(idc).length()) && (checkIdChalet(liste, idc))) ) {										
						break;
					}
					else 
						System.out.println("Veuillez choisir un numero a 5 chiffres  ou qui n'est pas deja utilise.");		
				}

				System.out.println("Entrez l'adresse du chalet. ");
				Adresse adrChalet = ListeChalets.createChalet(scan);
				System.out.println("Entrez le nombre de chambres du chalet: ");
				numChambres = scan.nextInt();
				System.out.println("Le chalet est-il loue? (Oui/Non)");
				reponse = scan.nextLine();			//
				while(!reponse.equalsIgnoreCase("oui") && !reponse.equalsIgnoreCase("non")) {		
					System.out.println("Entrez Oui ou Non.");
					reponse = scan.nextLine(); //
				}
				success = true;

				if (nbreChalet == liste.length)
					augmenterTailleC();

				liste [nbreChalet] = new Chalet(name, idc, adrChalet, numChambres, reponse, reponse1);
				nbreChalet++;	
			}
		} catch (InputMismatchException e) {
			scan.nextLine();				//
			System.out.println("======================================================================");
			System.out.println("Entree invalide.");
		}
	}

	// Creation de la methode pour doubler le array initial au cas ou il n'y aurait plus de place dans le tableau

	public void augmenterTailleC() {

		Chalet[] more = new Chalet[liste.length * 2];

		for(int chalet = 0; chalet < liste.length; chalet++)
			more[chalet] = liste [chalet];
		liste = more;
	}

	// Creation de la methode pour supprimer un chalet dans la liste

	public void supprChalet() {

		if (nbreChalet == 0) {
			System.out.println("La liste est vide.");
			return;
		}
		int choix;
		try {
			System.out.println("Veuillez choisir un chalet a supprimer par son numero respectif: ");
			System.out.println(); 										
			affichageListeC();
			choix = scan.nextInt();
			if (choix >= 1 && choix <= liste.length && liste[choix-1] != null) {
				for (int i = 0; i < liste.length; i++) {
					if (liste[i] != null && liste[i] == liste[choix-1]){
						liste[i] = null;
						nbreChalet--;
						moveNull();
						System.out.println("Le chalet a ete supprime.");  
					}
				}
			}
			else System.out.println("Le chalet n'existe pas.");
			System.out.println("======================================================================");
		}catch (InputMismatchException e) {
			scan.next();
			System.out.println("======================================================================");
			System.out.println("Cela n'est pas un nombre.");
		}
	}

	// Creation de la methode pour savoir si un chalet est loue ou non

	public static void locationYN() {

		if (nbreChalet == 0) {
			System.out.println("La liste est vide.");
			return;
		}

		int choix;
		String reponse;
		try {
			System.out.println("Veuillez choisir un chalet par son numero correspondant:");
			System.out.println();

			affichageListeC();
			choix = scan.nextInt();

			if (choix >= 1 && choix <= liste.length && liste[choix-1] != null) {
				for (int i = 0; i < liste.length; i++) {
					if (liste[i] != null && liste[i] == liste[choix-1]) {

						System.out.println("Le chalet est actuellement loue: " + liste[choix-1].getLoue());
						scan.nextLine();
						System.out.println("Est-ce que ce chalet est loue maintenant?:  (Oui/Non)");
						reponse = scan.next();
						while(!reponse.equalsIgnoreCase("oui") && !reponse.equalsIgnoreCase("non")) {
							System.out.println("Entrez oui ou non.");
							reponse = scan.next();
						}
						if (reponse.equalsIgnoreCase("oui")) {
							liste[choix-1].setLoue(reponse);
						}
						else
							liste[choix-1].setLoue(reponse);
						System.out.println("Le statut de location a ete change.");
					}
				}
			}	else 
				System.out.println("Le chalet n'existe pas.");
			System.out.println("======================================================================");

		}catch (InputMismatchException e) {
			scan.next();
			System.out.println("======================================================================");
			System.out.println("Cela n'est pas un nombre.");
		}
	} 

	// Creation de la methode pour corriger le Array apres suppresion

	public void moveNull() {

		for (int j = 0; j < liste.length; j++) {
			if (liste[j] == null) {
				for (int k = j + 1; k < liste.length; k++) {

				}
				liste[liste.length-1] = null;
			}
		}
	}
}

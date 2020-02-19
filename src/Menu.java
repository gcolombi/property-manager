import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	// Creation du Scanner

	private static Scanner scan = new Scanner(System.in); 
	private static ListeEmployes newE = new ListeEmployes();
	private static ListeChalets cottage = new ListeChalets();

	public static void main(String[] args) {

		// Creation du menu principale 


		boolean arret = false;
		int choix = 0;

		while (!arret) {
			try {
				System.out.println("______________________________________________________________________");
				System.out.println("---------------------------Menu Principal-----------------------------");
				System.out.println("------------ Choisissez parmis une des options suivantes -------------");
				System.out.println("1- Menu Employe");
				System.out.println("2- Menu Proprietaire");
				System.out.println("0- Quitter");
				System.out.println("______________________________________________________________________");

				choix = scan.nextInt();


				// Creation switch-case pour le menu principale

				switch (choix) {

				case 1:
					System.out.println("Menu Employe");
					if (ListeEmployes.getNbreEmploye() == 0) {
						System.out.println("La liste est vide.");
						break;
					}
					menuEmploye();
					System.out.println("----------------------------------------------------------------------");
					break;
				case 2:
					//Mot de passe pour acceder au menu proprietaire	
						if (choix == 2) {

						while (true) {
							String entree;
							final String password = "proprioChalets17";
							System.out.println("Veuillez taper votre mot de passe: ");
							System.out.println("Mot de passe: ");
							entree = scan.next();																		
							if(password.equals(entree)) {
								System.out.println("Vous etez connecte.");
								break;
							}
							else
								System.out.println("Mauvais mot de passe, veuillez recommencer");  
						}
					} 
					System.out.println("Menu Proprietaire");
					menuProprietaire();
					System.out.println("----------------------------------------------------------------------");
					break;
				case 0:
					arret = true;
					break;
				default:
					System.out.println("Entree invalide, veuillez reessayer.");
					System.out.println("----------------------------------------------------------------------");
					break;
				} // end du switch case

			} catch (InputMismatchException e) {
				scan.next();
				System.out.println("======================================================================");
				System.out.println("Entree invalide.");

			}

		} // end du while

	} // end de la Mainmethod

	// Creation du menu employe

	private static void menuEmploye() {																			

		boolean arret1 = false;
		int choix1 = 0;

		while (!arret1) {

			try {
				System.out.println("____________________________________________________________________");
				System.out.println("---------------------------Menu Employe-----------------------------");
				System.out.println("------------Choisissez parmis une des options suivantes-------------");
				System.out.println("1- Voir ses disponibilites");
				System.out.println("2- Modifier sa disponibilite pour une journee");
				System.out.println("3- Consulter les chalets lui etant associes");
				System.out.println("4- Voir son salaire");
				System.out.println("0- Quitter");
				System.out.println("_____________________________________________________________________");

				choix1 = scan.nextInt();


				// Creation switch-case pour le menu employe

				switch (choix1) {

				case 1:
					System.out.println("Voir ses disponibilites");
					ListeEmployes.getEmployeDispo();
					System.out.println("----------------------------------------------------------------------");
					break;
				case 2:
					System.out.println("Modifier sa disponibilites pour une journee");
					ListeEmployes.setEmployeDispo();
					System.out.println("----------------------------------------------------------------------");
					break;
				case 3:
					System.out.println("Consulter les chalets lui etant associes");
					ListeEmployes.chaletsAssocies();
					System.out.println("----------------------------------------------------------------------");
					break;
				case 4:
					System.out.println("Voir son salaire");
					ListeEmployes.getEmployeSalaire();
					System.out.println("----------------------------------------------------------------------");
					break;
				case 0:
					arret1 = true;
					break;
				default:
					System.out.println("Entree invalide, veuillez reessayer.");
					System.out.println("----------------------------------------------------------------------");
					break;

				} // fin switch

			} catch (InputMismatchException e) {
				scan.next();
				System.out.println("======================================================================");
				System.out.println("Entree invalide.");
			}

		}// fin while	

	} // fin menuEmploye

	private static void menuProprietaire() {

		boolean arret2 = false;
		int choix2 = 0;

		while (!arret2) {
			try {
				System.out.println("______________________________________________________________________");
				System.out.println("--------------------------Menu Proprietaire---------------------------");
				System.out.println("------------ Choisissez parmis une des options suivantes -------------");
				System.out.println("1- Afficher la liste des employes"); 
				System.out.println("2- Afficher la liste des chalets"); 
				System.out.println("3- Afficher le nombre d'employes");
				System.out.println("4- Afficher le nombre de chalets");
				System.out.println("5- Gerer les employes"); 
				System.out.println("6- Gerer les chalets"); 
				System.out.println("7- Modifier le salaire d'un employe");
				System.out.println("8- Comparer 2 employes selon leur salaire"); 
				System.out.println("9- Afficher les disponibilites d'un employes");
				System.out.println("10- Afficher les chalets associés a un employes");
				System.out.println("11- Gerer les chalets associés aux employes"); 
				System.out.println("12- Mettre un chalet en location ou libre pour la location"); 
				System.out.println("0- Quitter");
				System.out.println("______________________________________________________________________");

				choix2 = scan.nextInt();

				// Creation switch-case pour le menu proprietaire

				switch (choix2) { 

				case 1:
					System.out.println("Afficher la liste des employes.");
					int index = 1;
					if (ListeEmployes.getNbreEmploye() == 0) {
						System.out.println("La liste est vide.");
						return;
					}

					for (Employe m : ListeEmployes.getListe()) {
						System.out.println((index++) + ": " + m);
					}
					System.out.println("----------------------------------------------------------------------");
					break;
				case 2:
					System.out.println("Afficher la liste des chalets.");
					int index2 = 1;
					if (ListeChalets.getNbreChalet() == 0) {
						System.out.println("La liste est vide.");
						return;
					}

					for (Chalet m : ListeChalets.getListe()) {
						System.out.println((index2++) + ": " + m);
					}
					System.out.println("----------------------------------------------------------------------");
					break;
				case 3:
					System.out.println("Afficher le nombre d'employes");
					System.out.println("Le nombre d'employes est : " + ListeEmployes.getNbreEmploye());
					System.out.println("----------------------------------------------------------------------");
					break;
				case 4:
					System.out.println("Afficher le nombre de chalets");
					System.out.println("Le nombre de de chalets est : " + ListeChalets.getNbreChalet());
					System.out.println("----------------------------------------------------------------------");
					break;
				case 5:
					System.out.println("Gerer les employes");
					System.out.println("Appuyez sur 1 pour ajouter ou 2 pour supprimer un employe.");
					int choice1 = scan.nextInt();
					if(choice1 == 1){
						newE.addEmploye();
					}
					else if(choice1 == 2){
						newE.supprEmploye();	
					}
					else
						System.out.println("======================================================================");
					break;
				case 6:
					System.out.println("Gerer les chalets");
					System.out.println("Appuyez sur 1 pour ajouter ou 2 pour supprimer un chalet.");
					int choice2 = scan.nextInt();
					if(choice2 == 1){
						cottage.addChalet();
					}
					else if(choice2 == 2) {
						cottage.supprChalet();
					}
					else
						System.out.println("======================================================================");
					break;
				case 7:
					System.out.println("Modifier le salaire d'un employe");
					ListeEmployes.modifierSalaire();
					System.out.println("----------------------------------------------------------------------");
					break;
				case 8:
					System.out.println("Comparer 2 employes selon leur salaire");
					ListeEmployes.comparerSalaire();
					System.out.println("----------------------------------------------------------------------");
					break;
				case 9:
					System.out.println("Afficher les disponibilites d'un employe");
					ListeEmployes.afficherDispoEmp();
					System.out.println("----------------------------------------------------------------------");
					break;
				case 10:
					System.out.println("Afficher les chalets associés a un employe");
					newE.afficherChaletEmp();
					System.out.println("----------------------------------------------------------------------");
					break;
				case 11:
					System.out.println("Gerer les chalets associés aux employes.");
					System.out.println("Appuyez sur 1 pour ajouter ou 2 pour supprimer un chalet entretenu par un employe.");
					int choice3 = scan.nextInt();
					if(choice3 == 1){

						newE.chaletsEmployeAjout();	
					}
					else if(choice3 == 2) {

						newE.chaletsEmployeSuppr();	
					}
					else
						System.out.println("======================================================================");
					break;
				case 12:
					System.out.println("Mettre un chalet en location ou libre pour la location.");
					ListeChalets.locationYN();
					System.out.println("----------------------------------------------------------------------");
					break;
				case 0:
					arret2 = true;
					break;
				default:
					System.out.println("Entree invalide, veuillez reessayer.");
					System.out.println("----------------------------------------------------------------------");
					break;

				} // fin switch

			} catch (InputMismatchException e) {
				scan.next();
				System.out.println("======================================================================");


			}

		} // fin while	

	} // fin menu proprietaire

} // fin de la class

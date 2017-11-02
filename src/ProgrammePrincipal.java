import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 * Le programme principal tente d'ouvrir le fichier "clinique.bin" grâce au 
 * module UtilitaireFichier.java. Si la fonction retourne une clinique, on 
 * l'utilise sinon s'il n'y aucune clinique de retournée (null), on crée 
 * alors une nouvelle instance de la clinique. Le programme principal 
 * enregistre la clinique après chaque utilisation.
 * 
 * La boucle principale exécute le programme tant que l'usager n'as pas 
 * fermer le programme avec l'option de quitter. 
 * 
 * @author Niko Girardelli
 * @since (copyright) Niko Girardelli - A2017
 * @version Niko Girardelli - A2017
 */
public class ProgrammePrincipal {
	
	/***************************
     * * Le programme principal.
     * **************************/
	
	public static void main(String [] args) {
		
		try {
			
			/***************************
		     * * Les variables.
		     * **************************/

			// Déclaration du clavier.
			Scanner clavier = new Scanner(System.in);
			
			// Booléen pour vérifier si nous quittons.
			boolean quitter = false;
			
			// Les entrées du clavier de l'utilisateur.
			int choix = 0;
			int entier = 0;
			String nom = "";
			String prenom = "";
			
			// Création d'une classe Clinique avec une nouvelle
			// ou l'ancienne sauvergarde.
			Clinique clinique = verificationAncienneSauvegarde();
			
			// Classes utilisées temporairement.
			Docteur docTemp;
			Patient patTemp;
			Infirmier infTemp;
			Date dateTemp;
			RendezVous rdvTemp;
			Calendrier calTemp = clinique.getCalendrier();
			
			
			
			/**********************************
		     * * Début de la boucle principale.
		     * *********************************/
			
			// Tant que nous ne quittons pas l'application, 
			// on exécute le programme.
			while(!quitter) {
				
				// Selon le choix entré, on affiche les bonnes interfaces.
				switch (choix) {
				
				case 0 :  // Affiche l'interface du menu.
				  	  	  System.out.println(Constantes.MSG_BIENVENUE);
				  	  	  System.out.print(Constantes.MSG_OPTION_01);
					  	  System.out.print(Constantes.MSG_OPTION_02);
					  	  System.out.print(Constantes.MSG_OPTION_03);
					  	  System.out.print(Constantes.MSG_OPTION_04);
					  	  System.out.print(Constantes.MSG_OPTION_05);
					  	  System.out.print(Constantes.MSG_OPTION_06);
						  System.out.print(Constantes.MSG_OPTION_07);
						  System.out.print(Constantes.MSG_OPTION_08);
						  System.out.print(Constantes.MSG_OPTION_09);
						  System.out.print(Constantes.MSG_OPTION_10);
						  System.out.print(Constantes.MSG_OPTION_11);
						  System.out.print(Constantes.MSG_OPTION_12);
						  System.out.print(Constantes.MSG_OPTION_13);
						  System.out.print(Constantes.MSG_OPTION_14);
						  System.out.print(Constantes.SAUTE_LIGNE);
						  System.out.print(Constantes.LIGNE_ENTETE);
						  System.out.print(Constantes.SAUTE_LIGNE);
						  System.out.print(Constantes.MSG_CHOIX_OPTION);
						  System.out.print(Constantes.SAUTE_LIGNE);
						  
						  // On change la valeur de l'option.
						  choix = clavier.nextInt();
						  
						  break;
						  
				case 1 :  // Affiche l'interface d'ajout d'un docteur.
						  // Solicite et enrgistre un nom.
						  System.out.println(Constantes.MSG_SOL_NOM_DOC);
					  	  nom = clavier.next();
					  	  
					  	  // Solicite un prénom et l'enregistre.
					  	  System.out.println(Constantes.MSG_SOL_PRENOM_DOC);
					  	  prenom = clavier.next();
					  	  
					  	  // Solicite un département et l'enregistre.
					  	  System.out.println(Constantes.MSG_SOL_DEP_DOC);
					  	  entier = clavier.nextInt();
					  	
					  	  // On enregistre le docteur dans la 
					  	  // liste des docteurs.
					      System.out.print(clinique.ajouterDocteur(
					    		  new Docteur(new Identification(nom, prenom), 
					    				  		entier)));

					  	  // On remet le menu après l'opération
					      choix = 0;
					      break;
					      
				case 2 :  // Affiche l'interface d'ajout d'un infirmier.
						  // Solicite et enrgistre un nom.
					      System.out.println(Constantes.MSG_SOL_NOM_INF);
					      nom = clavier.next();
					      
					      // Solicite et enrgistre un prénom.
					      System.out.println(Constantes.MSG_SOL_PRENOM_INF);
					      prenom = clavier.next();
					      
					      // On enregistre l'infirmier dans la liste 
					      // des infirmiers en étant disponible.
					  	  System.out.println(clinique.ajouterInfirmier(
					  			new Infirmier(new Identification(nom, prenom), 
					      		Constantes.DISPONIBLE)));
					      
					      // On remet le menu après l'opération
					      choix = 0;
					  	  break;
					  	  
				case 3 :  // Affiche l'interface d'ajout d'un patient.
						  // Solicite et enrgistre un nom.
				      	  System.out.println(Constantes.MSG_SOL_NOM_PAT);
				      	  nom = clavier.next();

				      	  // Solicite et enrgistre un prénom.
				      	  System.out.println(Constantes.MSG_SOL_PRENOM_PAT);
				      	  prenom = clavier.next();
				      	  
				      	  // Solicite et enrgistre un numéro
				      	  // d'assurance maladie.
				      	  System.out.println(Constantes.MSG_SOL_NAM_PAT);
					  	  entier = clavier.nextInt();
					  	  
				      	  // On enregistre le patient à la liste des patients.
				      	  System.out.println(clinique.ajouterPatient(new Patient( 
				      			  new Identification(nom, prenom), entier)));

					  	  // On remet le menu après l'opération
					      choix = 0;
				      	  break;
				      	  
				
				case 4 :  // Affiche l'interface d'ajout d'un rendez-vous.
						  // Affiche la liste des docteurs, des infirmiers,
						  // et des patients, et retourne ceux choisis
						  docTemp = docChoisi(clinique, clavier);
						  infTemp = infChoisi(clinique, clavier);
						  patTemp = patChoisi(clinique, clavier);
						  
						  // Demande une date par l'utilisateur.
						  dateTemp = dateChoisie(clinique, clavier);
						  
						  // Fait référence au calendrier de la clinique et
						  // crée un nouveau rendez-vous avec
						  // nos informations reçues.
						  System.out.println(clinique.getCalendrier().
								  ajouterRendezVous(new RendezVous(patTemp,
										  docTemp, infTemp), dateTemp));

					  	  // On remet le menu après l'opération
					      choix = 0;
				      	  break;
				      	  
				case 5 :  // Affiche l'interface trouver un rendez-vous
					      // pour un patient.
						  // Demande de choisir un patient de la liste
						  // à l'utilisateur.
						  patTemp = patChoisi(clinique, clavier);
						  
						  // On trouve un rendez-vous disponible pour
						  // le patient reçu.
						  System.out.print(clinique.rendezVousPatient(
								  					patTemp).toString());
						  
						  // On remet le menu après l'opération
					      choix = 0;
						  break;
						  
				case 6 :  // Afficher prochain rendez-vous d'un docteur. 
						  docTemp = docChoisi(clinique, clavier);
						  rdvTemp = calTemp.obtenirProchainRendezVousDocteur(
								  			docTemp);
						  
						  // Test le rendez-vous et affiche le message.
						  verifierRDV(rdvTemp);
						  
						  // Retourne au menu principal.
						  choix = 0;
						  break;
						  
				case 7 :  // Afficher prochain rendez-vous d'un infirmier. 
						  infTemp = infChoisi(clinique, clavier);
						  rdvTemp = calTemp.obtenirProchainRendezVousInfirmier(
								  			infTemp);
						  
						  // Test le rendez-vous et affiche le message.
						  verifierRDV(rdvTemp);
						  
						  choix = 0;
						  break;
						  
				case 8 :  // Afficher prochain rendez-vous d'un patient. 
						  patTemp = patChoisi(clinique, clavier);
						  rdvTemp = calTemp.obtenirProchainRendezVousPatient(
								  			patTemp);
						  
						  // Test le rendez-vous et affiche le message.
					  	  verifierRDV(rdvTemp);
					  	  
					  	  choix = 0;
					  	  break;
					  	  
				case 9 :  // Passer à la prochaine plage horaire. 
						  System.out.println(
						  calTemp.obtenirProchainePlageHoraire().toString());
						  
						  choix = 0;
						  break;
						  
				case 10 : // Afficher calendrier au complet. 
						  System.out.println(calTemp.toString());
						  choix = 0;
						  break;
						  
				case 11 : // Afficher calendrier au complet d'un docteur.
						  docTemp = docChoisi(clinique, clavier);
						  System.out.println(calTemp.obtenirCalendrierDocteur(
								  docTemp).toString());
						  
						  choix = 0;
						  break;
						  
				case 12 : // Afficher calendrier au complet d'un infirmier.
						  infTemp = infChoisi(clinique, clavier);
						  System.out.println(calTemp.
							  obtenirCalendrierInfirmier(infTemp).toString());
						  choix = 0;
						  break;
						  
				case 13 : // Annuler un rendez-vous.
						  docTemp = docChoisi(clinique, clavier);
						  infTemp = infChoisi(clinique, clavier);
						  patTemp = patChoisi(clinique, clavier);
						  dateTemp = dateChoisie(clinique, clavier);
						  rdvTemp = new RendezVous(patTemp, docTemp, infTemp);
						  System.out.println(
								  calTemp.annulerRendezVous(rdvTemp));
						  choix = 0;
						  break;
						  
				case 14 : // Demande pour quitter l'application,
						  // et quitte ou non selon la réponse de 
						  // l'utilisateur.
						  System.out.println(Constantes.MSG_AVANT_FIN);
						  String reponse = clavier.next();
						  
						  // Vérifie la réponse donnée, on quitte 
						  // si c'est oui.
						  if(reponse.equals(Constantes.PEUT_QUITTER)) {
							  
							  quitter = true;
							  
						  }
						  
						  else {
							  
							choix = 0;
							
						  }
						  
						  break;
						  
				default : break;
				
				}
			
				UtilitaireFichier.sauvegarderClinique(clinique,
						Constantes.CHEMIN_FICHIER);
				
			}
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
	
	}
	
	/**********************************
     * * Les sous-programmes.
     * *********************************/
	
	/**
	 * Prend un rendez-vous et le vérifie. 
	 * l'année, l'heure et les minutes pour un rendez-vous.
	 * 
	 * @return void.
	 */
	private static void verifierRDV(RendezVous rdv) {
		
		//Test s'il y a un rendez-vous
		if(rdv != null) {
	  
			System.out.println(rdv.toString());
	  
		}
  
		else {
		  
			System.out.print(Constantes.MSG_AUCUN_RDV);
		  
		}
	
	}
	
	/**
	 * Demande une date contenant, le jour, le mois, 
	 * l'année, l'heure et les minutes pour un rendez-vous.
	 *
	 * On retourne par la suite une classe Date.
	 * 
	 * @return Date date.
	 */
	private static Date dateChoisie(Clinique clinique, Scanner clavier) {
		
		// Solicite une date et la retourne.
		System.out.print(Constantes.MSG_SOL_ANNEE);
		int annee = clavier.nextInt();
		System.out.print(Constantes.MSG_SOL_MOIS);
		int mois = clavier.nextInt();
		System.out.print(Constantes.MSG_SOL_JOUR);
		int jour = clavier.nextInt();
		System.out.print(Constantes.MSG_SOL_HEURE);
		int heure = clavier.nextInt(); 
		System.out.print(Constantes.MSG_SOL_MINUTE);
		int minute = clavier.nextInt();
		Date date = new Date(annee, mois, jour, heure, minute);
		
		return date;
	
	}
	
	/**
	 * Affiche la liste des docteurs de la Clinique, et demande
	 * à l'utilisateur d'écrire le chiffre du docteur qui veut.
	 *
	 * On utilise le sous-programme retournerListe() pour afficher
	 * notre liste de docteur.
	 * 
	 * @return Docteur doc.
	 */
	private static Docteur docChoisi(Clinique clinique, Scanner clavier) {
		
		// Solicite le numéro du docteur voulu et retourne le docteur voulu.
		System.out.print(retournerListe(Constantes.RECHERCHE_DOC, clinique));
		System.out.print(Constantes.MSG_CHOIX_DOC);
		Docteur doc = clinique.getDocteur(clavier.nextInt());
		
		return doc;
		
	}
	
	/**
	 * Affiche la liste des infirmiers de la Clinique, et demande
	 * à l'utilisateur d'écrire le chiffre de l'infirmier voulu.
	 *
	 * On utilise le sous-programme retournerListe() pour afficher
	 * notre liste des infirmiers.
	 * 
	 * @return Infirmier inf.
	 */
	private static Infirmier infChoisi(Clinique clinique, Scanner clavier) {
		
		// Solicite le numéro de l'infirmier voulu et le retourne.
		System.out.print(retournerListe(Constantes.RECHERCHE_INF, clinique));
		System.out.print(Constantes.MSG_CHOIX_INF);
		Infirmier inf = clinique.getInfirmier(clavier.nextInt());
		
		return inf;
		
	}
	
	/**
	 * Affiche la liste des patients de la Clinique, et demande
	 * à l'utilisateur d'écrire le chiffre du patient voulu.
	 *
	 * On utilise le sous-programme retournerListe() pour afficher
	 * notre liste des patients.
	 * 
	 * @return Patient pat.
	 */
	private static Patient patChoisi(Clinique clinique, Scanner clavier) {
		
		// Solicite le numéro du patient voulu et le retourne.
		System.out.print(retournerListe(Constantes.RECHERCHE_PAT, clinique));
		System.out.print(Constantes.MSG_CHOIX_PAT);
		Patient pat = clinique.getPatient(clavier.nextInt());
		  
		return pat;
		
	}
	
	/**
	 * Tente d'ouvrir la dernière sauvegarde de "clinique.bin" avec l'aide
	 * du module UtilitaireFichier. Si c'est un impossible de trouver le 
	 * fichier, alors, on appel le constructeur par défaut de la classe
	 * Clinique.
	 * 
	 * @return Clinique nouvelleVersionClinique.
	 */
	private static Clinique verificationAncienneSauvegarde() throws Exception {
		
		// Variable contenant notre sauvegarde de la classe Clinique.
		Clinique nouvelleVersionClinique;
		
		// On crée une variable contenant le chemin d'accès 
		// au fichier "clinique.bin".
		File fichier = new File(Constantes.CHEMIN_FICHIER);
		
		// Si aucune sauvegarde pour une clinique est trouvée...
		if(!fichier.exists()) {
			
			// On crée une nouvelle instance de la classe Clinique.
			nouvelleVersionClinique = new Clinique();
			nouvelleVersionClinique.setCalendrier(new Calendrier());
			
		}
		
		// Sinon, on va chercher notre ancienne sauvegarde.
		else {
			
			// On affecte le fichier à une variable qui va 
			// lire le fichier en flux d'octets.
			FileInputStream FichierEnOctet = new FileInputStream(fichier);
			
			// On affecte les valeurs de la dernière sauvegarde 
			// de la classe Clinique à notre nouvelle version 
			// de la classe Clinique.
			nouvelleVersionClinique = 
					UtilitaireFichier.obtenirClinique(FichierEnOctet);
			
		}
		
		return nouvelleVersionClinique;
			
	}

	/**
	 * Retourne une chaîne contenant les informations d'une liste selon.
	 * le paramètre recherche passé, qui est soit une liste de docteurs, 
	 * une liste d'infirmiers ou bien celle des patients de la clinique.
	 * 
	 * On parcourt la liste jusqu'à ce qu'on trouve un élément qui vaut
	 * null, alors on retourne notre liste sous forme de string.
	 * 
	 * @return String phrase.
	 */
	private static String retournerListe(String recherche, Clinique clinique) {
		
		// Les variables.
		String phrase = recherche + Constantes.SAUTE_LIGNE;
		int i = 0;

		// Boucle qui parcourt toute la liste des docteurs de la clinique.
		if(recherche == Constantes.RECHERCHE_DOC) {

		    do {
				
		    	phrase += i + " - " + clinique.getDocteur(i).toString() +
		    				Constantes.SAUTE_LIGNE; 
		    	i++;
		    	
		    }
		    
		    // Tant que le docteur n'est pas null on exécute la boucle.
		    while (clinique.getDocteur(i) != null);
		    
		}
		
		// Boucle qui parcourt toute la liste des infirmiers de la clinique.
		if(recherche == Constantes.RECHERCHE_INF) {
			
		    do {
				
		    	phrase += i + " - " + clinique.getInfirmier(i).toString() + 
		    				Constantes.SAUTE_LIGNE; 
		    	i++;
		    	
		    }
		    
		    // Tant que l'infirmier n'est pas null on exécute la boucle.
		    while (clinique.getInfirmier(i) != null);
		    
		}
		
		// Boucle qui parcourt toute la liste des patients de la clinique.
		if(recherche == Constantes.RECHERCHE_PAT) {
			
		    do {
				
		    	phrase += i + " - " + clinique.getPatient(i).toString() + 
		    				Constantes.SAUTE_LIGNE; 
		    	i++;
		    	
		    }
		    
		    // Tant que le patient n'est pas null on exécute la boucle.
		    while (clinique.getPatient(i) != null);
		    
		}
	
	    return phrase;
	}
	
}

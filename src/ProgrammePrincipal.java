import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 * Le programme principal tente d'ouvrir le fichier "clinique.bin" gr�ce au 
 * module UtilitaireFichier.java. Si la fonction retourne une clinique, on 
 * l'utilise sinon s'il n'y aucune clinique de retourn�e (null), on cr�e 
 * alors une nouvelle instance de la clinique. Le programme principal 
 * enregistre la clinique apr�s chaque utilisation.
 * 
 * La boucle principale ex�cute le programme tant que l'usager n'as pas 
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
	
	public void main(String [] args) {
		
		try {
			
			/***************************
		     * * Les variables.
		     * **************************/

			// D�claration du clavier.
			Scanner clavier = new Scanner(System.in);
			
			// Bool�en pour v�rifier si nous quittons.
			boolean quitter = false;
			
			// Les entr�es du clavier de l'utilisateur.
			int choix = 0;
			int entier = 0;
			String nom = "";
			String prenom = "";
			
			// Cr�ation d'une classe Clinique avec une nouvelle
			// ou l'ancienne sauvergarde.
			Clinique clinique = verificationAncienneSauvegarde();
			
			
			
			/**********************************
		     * * D�but de la boucle principale.
		     * *********************************/
			
			// Tant que nous ne quittons pas l'application, 
			// on ex�cute le programme.
			while(!quitter) {
				
				// Selon le choix entr�, on affiche les bonnes interfaces.
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
					  	  
					  	  // Solicite un pr�nom et l'enregistre.
					  	  System.out.println(Constantes.MSG_SOL_PRENOM_DOC);
					  	  prenom = clavier.next();
					  	  
					  	  // Solicite un d�partement et l'enregistre.
					  	  System.out.println(Constantes.MSG_SOL_DEP_DOC);
					  	  entier = clavier.nextInt();
					  
					  	  // On enregistre le docteur dans la 
					  	  // liste des docteurs.
					      //clinique.ajouterDocteur(new Docteur(
					    		// new Identification(nom, prenom), entier));
					  	  
					  	  // On remet le menu apr�s l'op�ration
					      choix = 0;
					      break;
					      
				case 2 :  // Affiche l'interface d'ajout d'un infirmier.
						  // Solicite et enrgistre un nom.
					      System.out.println(Constantes.MSG_SOL_NOM_INF);
					      nom = clavier.next();
					      
					      // Solicite et enrgistre un pr�nom.
					      System.out.println(Constantes.MSG_SOL_PRENOM_INF);
					      prenom = clavier.next();
					      
					      // On enregistre l'infirmier dans la liste 
					      // des infirmiers en �tant disponible.
					  	  //clinique.ajouterInfirmier(new Infirmier(
					      //		new Identification(nom, prenom),
							  		//Constantes.DISPONIBLE));
					      
					      // On remet le menu apr�s l'op�ration
					      choix = 0;
					  	  break;
					  	  
				case 3 :  // Affiche l'interface d'ajout d'un patient.
						  // Solicite et enrgistre un nom.
				      	  System.out.println(Constantes.MSG_SOL_NOM_PAT);
				      	  nom = clavier.next();

				      	  // Solicite et enrgistre un pr�nom.
				      	  System.out.println(Constantes.MSG_SOL_PRENOM_PAT);
				      	  prenom = clavier.next();
				      	  
				      	  // Solicite et enrgistre un num�ro
				      	  // d'assurance maladie.
				      	  System.out.println(Constantes.MSG_SOL_NAM_PAT);
					  	  entier = clavier.nextInt();
					  	  
				      	  // On enregistre le patient � la liste des patients.
				      	  //clinique.ajouterPatient(new Patient(
					  	  //	new Identification(nom, prenom), entier);
					  	  
					  	  // On remet le menu apr�s l'op�ration
					      choix = 0;
				      	  break;
				
				case 4 :  // Affiche la liste des docteurs, 
						  // des infirmiers et des patients.
						  // Solicite num�ro du docteur voulu.
						  retournerListe(Constantes.RECHERCHE_DOC, clinique);
						  System.out.print(Constantes.MSG_CHOIX_DOC);
						  Docteur doc = clinique.getDocteur(
								  			clavier.nextInt());
						  
						  // Solicite num�ro de l'infirmier voulu.
						  retournerListe(Constantes.RECHERCHE_INF, clinique);
						  System.out.print(Constantes.MSG_CHOIX_INF);
						  Infirmier inf = clinique.getInfirmier(
								  			clavier.nextInt());
						  
						  // Solicite num�ro du patient voulu.
						  retournerListe(Constantes.RECHERCHE_PAT, clinique);
						  System.out.print(Constantes.MSG_CHOIX_PAT);
						  Patient pat = clinique.getPatient(
								  			clavier.nextInt());
						  
						  // Solicite une date.
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
						  Date date = new Date(annee, mois, jour, 
								  		  		heure, minute);
						  
						  // Fait r�f�rence au calendrier de la clinique.
						  clinique.getCalendrier().ajouterRendezVous(
								  		new RendezVous(pat, doc, inf), date);
						  
					  	  // On remet le menu apr�s l'op�ration
					      choix = 0;
				      	  break;
				      	  
				case 5 :  // Solicite num�ro du patient voulu.
					  	  retournerListe(Constantes.RECHERCHE_PAT, clinique);
					  	  System.out.print(Constantes.MSG_CHOIX_PAT);
					  	  Patient pat = clinique.getPatient(
							  			clavier.nextInt());
					  	  
					  	  // Solicite une date.
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
						  Date date = new Date(annee, mois, jour, 
								  		  		heure, minute);
						  
						  // Fait r�f�rence au calendrier de la clinique.
						  clinique.rendezVousPatient(
								  		new RendezVous(pat, doc, inf), date);
				      	  /************************************************************/
						  										/** AJOUTER PATIENT **/
						  break;
				
				default : break;
				
				}
			
				// Sauvegarderrrrrrrrrrr clinique !!!!
			}
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
	
	}
	
	/**
	 * Tente d'ouvrir la derni�re sauvegarde de "clinique.bin" avec l'aide
	 * du module UtilitaireFichier. Si c'est un impossible de trouver le 
	 * fichier, alors, on appel le constructeur par d�faut de la classe
	 * Clinique.
	 * 
	 * @return Clinique nouvelleVersionClinique.
	 */
	private static Clinique verificationAncienneSauvegarde() throws Exception {
		
		// Variable contenant notre sauvegarde de la classe Clinique.
		Clinique nouvelleVersionClinique;
		
		// On cr�e une variable contenant le chemin d'acc�s 
		// au fichier "clinique.bin".
		File fichier = new File(Constantes.CHEMIN_FICHIER);
		
		// Si aucune sauvegarde pour une clinique est trouv�e...
		if(!fichier.exists()) {
			
			// On cr�e une nouvelle instance de la classe Clinique.
			nouvelleVersionClinique = new Clinique();
			
		}
		
		// Sinon, on va chercher notre ancienne sauvegarde.
		else {
			
			// On affecte le fichier � une variable qui va 
			// lire le fichier en flux d'octets.
			FileInputStream FichierEnOctet = new FileInputStream(fichier);
			
			// On affecte les valeurs de la derni�re sauvegarde 
			// de la classe Clinique � notre nouvelle version 
			// de la classe Clinique.
			nouvelleVersionClinique = 
					UtilitaireFichier.obtenirClinique(FichierEnOctet);
			
		}
		
		return nouvelleVersionClinique;
			
	}

	/**
	 * Retourne une cha�ne contenant les informations d'une liste selon.
	 * le param�tre pass�, qui est soit une liste de docteurs, une liste
	 * d'infirmiers ou bien celle des patients de la clinique.
	 * 
	 * On parcourt la liste jusqu'� ce qu'on trouve un �l�ment qui vaut
	 * null, alors on retourne notre liste.
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
		    
		    // Tant que le docteur n'est pas null on ex�cute la boucle.
		    while (clinique.getDocteur(i) == null);
		    
		}
		
		// Boucle qui parcourt toute la liste des infirmiers de la clinique.
		if(recherche == Constantes.RECHERCHE_INF) {
			
		    do {
				
		    	phrase += i + " - " + clinique.getInfirmier(i).toString() + 
		    				Constantes.SAUTE_LIGNE; 
		    	i++;
		    	
		    }
		    
		    // Tant que l'infirmier n'est pas null on ex�cute la boucle.
		    while (clinique.getInfirmier(i) == null);
		    
		}
		
		// Boucle qui parcourt toute la liste des patients de la clinique.
		if(recherche == Constantes.RECHERCHE_PAT) {
			
		    do {
				
		    	phrase += i + " - " + clinique.getPatient(i).toString() + 
		    				Constantes.SAUTE_LIGNE; 
		    	i++;
		    	
		    }
		    
		    // Tant que le patient n'est pas null on ex�cute la boucle.
		    while (clinique.getPatient(i) == null);
		    
		}
	
	    return phrase;
	}
	
}

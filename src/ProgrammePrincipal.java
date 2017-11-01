import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Le programme principal tente d'ouvrir le fichier "clinique.bin" grâce au module UtilitaireFichier.java.
 * Si la fonction retourne une clinique, on l'utilise sinon s'il n'y aucune clinique de retournée (null), 
 * on crée alors une nouvelle instance de la clinique. Le programme principal enregistre la clinique après chaque
 * utilisation.
 * 
 * La boucle principale exécute le programme tant que l'usager n'as pas fermer le programme avec l'option de quitter. 
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
			String nom = "";
			String prenom = "";
			int entier = 0;
			
			// On crée une variable contenant le chemin d'accès au fichier "clinique.bin".
			File fichier = new File(Constantes.CHEMIN_FICHIER);
			
			/**********************************
		     * * Vérification d'une sauvegarde.
		     * *********************************/
			
			// Si aucune sauvegarde pour une clinique est trouvée...
			if(!fichier.exists()) {
				
				// On crée une nouvelle instance de la classe Clinique.
				Clinique nouvelleVersionClinique = new Clinique();
				
			}
			
			// Sinon, on va chercher notre ancienne sauvegarde.
			else {
				
				// On affecte le fichier à une variable qui va lire le fichier en flux d'octets.
				FileInputStream FichierEnOctet = new FileInputStream(fichier);
				
				// On affecte les valeurs de la dernière sauvegarde de la classe Clinique 
				// à notre nouvelle version de la classe Clinique.
				Clinique nouvelleVersionClinique = UtilitaireFichier.obtenirClinique(FichierEnOctet);
				
			}
			
			/**********************************
		     * * Début de la boucle principale.
		     * *********************************/
			
			// Tant que nous ne quittons pas l'application, on exécute le programme.
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
						  
						  // On change la valeur de l'option entrée par l'utilisateur.
						  choix = clavier.nextInt();
						  break;
						  
				case 1 :  // Affiche l'interface d'ajout d'un docteur.
						  // Solicite un nom et l'enrgistre dans la variable nom.
						  System.out.println(Constantes.MSG_SOL_NOM_DOC);
					  	  nom = clavier.next();
					  	  
					  	  // Solicite un prénom et l'enregistre dans la variable prenom
					  	  System.out.println(Constantes.MSG_SOL_PRENOM_DOC);
					  	  prenom = clavier.next();
					  	  
					  	  // Solicite un département et l'enregistre dans la variable entier.
					  	  System.out.println(Constantes.MSG_SOL_DEP_DOC);
					  	  entier = clavier.nextInt();
					  
					  	  // On enregistre le docteur dans la liste des docteurs.
					   // nouvelleVersionClinique.ajouterDocteur(new Docteur(new Identification(nom, prenom), entier));
					      break;
					      
				case 2 :  // Affiche l'interface d'ajout d'un infirmier.
						  // Solicite un nom et l'enrgistre dans la variable nom.
					      System.out.println(Constantes.MSG_SOL_NOM_INF);
					      nom = clavier.next();
					      
					      // Solicite un nom et l'enrgistre dans la variable nom.
					      System.out.println(Constantes.MSG_SOL_PRENOM_INF);
					  
					      // Enrgistre notre prénom donné.
					      prenom = clavier.next();
					      
					      // On enregistre l'infirmier dans la liste des infirmiers en étant disponible.
					  	  //nouvelleVersionClinique.ajouterInfirmier(new Infirmier(new Identification(nom, prenom),
							  								   //Constantes.DISPONIBLE));
					  	  break;
					  	  
				case 3 :  // Affiche l'interface d'ajout d'un patient.
				      	  System.out.println(Constantes.MSG_SOL_NOM_PAT);
				  
				      	  // Enrgistre notre nom donné.
				      	  nom = clavier.next();

				      	  System.out.println(Constantes.MSG_SOL_PRENOM_PAT);
				  
				      	  // Enrgistre notre prénom donné.
				      	  prenom = clavier.next();
				      	  
				      	  System.out.println(Constantes.MSG_SOL_NAM_PAT);
						  
					  	  // Enrgistre notre numéro d'assurance maladie donné.
					  	  entier = clavier.nextInt();
					  	  
					  	  //System.out.print(nom + " " + prenom + " " + entier);
					  	  //System.out.println("LE CHOIX A À LA FIN " + choix);
				      	  // On enregistre le patient à la liste des patients.
				      	  //nouvelleVersionClinique.ajouterPatient(new Patient(new Identification(nom, prenom),
						  								   //entier);
					  	  
					  	  // On remet le menu après l'opération
					      choix = 0;
				      	  break;
				
				default : break;
				
				}
			
			
			}
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
	
	}
	
}

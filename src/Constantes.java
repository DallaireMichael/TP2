
/**
 * Classe contenant toutes les constantes n�cessaires au programme.
 * 
 * @author Niko Girardelli et Micha�l Dallaire
 * @version (Copyright A2017)
 */
public class Constantes {
	
	/***************************
     * * Les constantes.
     * **************************/
	
	// R�f�rence au fichier de sauvegarde de la clinique.
	public static final String CHEMIN_FICHIER = "src/clinique.bin";
	
	// Heure d'ouverture de la Clinique.
	public static final int HEURE_OUVERTURE = 8;
	
	// Heure de fermeture de la Clinique.
	public static final int HEURE_FERMETURE = 20;
	
	// Tableau d'intervalle de 15 minutes pour un rendez-vous.
	public static final int[] MINUTES_INTERVALLE = {0,15,30,45};
	
	// Le raccourci pour effacer l'�cran et sauter de ligne.
    public static final String EFFACE_ECRAN = "\f";
    
    // Le raccourci pour sauter de ligne.
    public static final String SAUTE_LIGNE = "\n";
    
    // Disponibilit� d'un infirmier par d�faut
    public static final boolean DISPONIBLE = true;
    
    // Les d�partements d'un docteur.
    public static final int CHIRURGIE = 1;
    public static final int URGENCE = 2;
    public static final int UROLOGIE = 3;
    
    // Les type de personnes qu'on veut afficher une liste.
    public static final String RECHERCHE_DOC = 
    "******* La liste des Docteurs *******"; 
    
    public static final String RECHERCHE_INF = 
    "****** La liste des Infirmiers ******";
    
    public static final String RECHERCHE_PAT = 
    "******* La liste des Patients *******";
    
    // Pour v�rifier la r�ponse donn� pour quitter.
    public static final String PEUT_QUITTER = "Oui";
    
    // Les messages � afficher sur l'�cran.
    public static final String LIGNE_ENTETE =
    "\n**********************************************************************";
    
    public static final String TITRE =
    "*                         GESTION D'UNE CLINIQUE                     *";
    
    public static final String MSG_CHOIX_OPTION =
    "\nEntrez le chiffre de l'option que vous d�sirez utilliser";
    
    public static final String MSG_BIENVENUE =
    "\nBienvenue � la clinique \nQue voulez-vous faire ?";
    
    public static final String MSG_OPTION_01 =
    "\n1 - Ajouter un docteur";
    
    public static final String MSG_OPTION_02 =
    "\n2 - Ajouter un infirmier";
    
    public static final String MSG_OPTION_03 =
    "\n3 - Ajouter un patient";
    
    public static final String MSG_OPTION_04 =
    "\n4 - Ajouter un rendez-vous";
    
    public static final String MSG_OPTION_05 =
    "\n5 - Trouver un rendez-vous pour un patient";
    
    public static final String MSG_OPTION_06 =
    "\n6 - Afficher le prochain rendez-vous d'un docteur";
    
    public static final String MSG_OPTION_07 =
    "\n7 - Afficher le prochain rendez-vous d'un infirmier";
    
    public static final String MSG_OPTION_08 =
    "\n8 - Afficher le prochain rendez-vous d'un patient";
    
    public static final String MSG_OPTION_09 =
    "\n9 - Passer � la prochaine plage horaire";
    
    public static final String MSG_OPTION_10 =
    "\n10 - Afficher le calendrier complet";
    
    public static final String MSG_OPTION_11 =
    "\n11 - Afficher le calendrier complet d'un docteur";
    
    public static final String MSG_OPTION_12 =
    "\n12 - Afficher le calendrier complet d'un infirmier";
    
    public static final String MSG_OPTION_13 =
    "\n13 - Annuler un rendez-vous";

    public static final String MSG_OPTION_14 =
    "\n14 - Quitter";
    
    public static final String MSG_CHOIX_DOC =
    "\nEntrez le chiffre du docteur.";
    
    public static final String MSG_CHOIX_INF =
    "\nEntrez le chiffre de l'infirmier.";
    
    public static final String MSG_CHOIX_PAT =
    "\nEntrez le chiffre du patient.";
    
    public static final String MSG_SOL_NOM_DOC =
    "\nEntrez le nom d'un docteur";
    
    public static final String MSG_SOL_PRENOM_DOC =
    "\nEntrez le pr�nom d'un docteur";
    
    public static final String MSG_SOL_DEP_DOC =
    "\nEntrez le numr�o du d�partement d'un docteur"
    + "\n1 = CHIRURGIE, 2 = URGENCE et 3 = UROLOGIE.";
    
    public static final String MSG_SOL_NOM_INF =
    "\nEntrez le nom d'un infirmier";
    
    public static final String MSG_SOL_PRENOM_INF =
    "\nEntrez le pr�nom d'un infirmier";
    
    public static final String MSG_SOL_NOM_PAT =
    "\nEntrez le nom d'un patient";
    
    public static final String MSG_SOL_PRENOM_PAT =
    "\nEntrez le pr�nom d'un patient";
    
    public static final String MSG_SOL_JOUR =
	"\nEntrez le jour du rendez-vous.";
    
    public static final String MSG_SOL_MOIS =
    "\nEntrez le mois du rendez-vous.";
    
    public static final String MSG_SOL_ANNEE =
    "\nEntrez l'ann�e du rendez-vous.";
    
    public static final String MSG_SOL_HEURE =
    "\nEntrez l'heure du rendez-vous.";
    
    public static final String MSG_SOL_MINUTE =
    "\nEntrez les minutes du rendez-vous.";
    
    public static final String MSG_SOL_NAM_PAT =
    "\nEntrez le num�ro d'assurance maladie d'un patient";
    
    public static final String MSG_AVANT_FIN =
    "\nTapez 'Oui' si vous voulez vraiment quitter, " +
    "\nsinon tapez 'Non' pour retourner au menu";
    
    public static final String MSG_AUCUN_RDV = 
    "\nIl n'y a aucun rendez-vous.";

}
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Vector;

/**
 * Permet de conserver toutes les informations sur son personnel
 * et tous les rendez-vous
 * @author Michaël Dallaire
 *
 */
public class Clinique implements Serializable {
	
	//ATTRIBUTS
	
	//Calendrier de la clinique au complet
	private Calendrier calendrier;
	
	//Liste docteur de la clinique par liste doublement chaîné
	private LinkedList<Docteur> listeDocteurs = new LinkedList<Docteur>();
	
	//Liste infirmiers de la clinique par liste doublement chaîné
	private LinkedList<Infirmier> listeInfirmiers = new LinkedList<Infirmier>();
	
	//Liste de patients de la clinique par liste Vecteur
	private Vector<Patient> listePatients = new Vector<Patient>();
	
	/*
	 * ACCESSEURS
	 */
	
	/**
	 * Retourne un docteur à un indice indiqué
	 * Retourne Null si l'indice est hors des limites de la liste
	 * @param i
	 * @return Docteur
	 */
	public Docteur getDocteur(int i) {
		
		//Vérifie que l'indice ne vas pas plus loin que la grosseur de la liste
		if(i < 0 || i >= listeDocteurs.size()) {
			
			return null;
			
		}
		
		else {
			
			return listeDocteurs.get(i);
			
		}
		
	}
	
	/**
	 * Retourne un infirmier à un indice indiqué
	 * Retourne Null si l'indice est hors des limites de la liste
	 * @param i
	 * @return Infirmier
	 */
	public Infirmier getInfirmier(int i) {
		
		//Vérifie que l'indice ne vas pas plus loin que la grosseur de la liste
		if(i < 0 || i >= listeInfirmiers.size()) {
			
			return null;
			
		}
		
		else {
			
			return listeInfirmiers.get(i);
			
		}
		
	}
	
	/**
	 * Retourne un patient à un indice indiqué
	 * Retourne NUll si l'indice est hors des limites de la lsite
	 * @param i
	 * @return Patient
	 */
	public Patient getPatient(int i) {
		
		//Vérifie que l'indice ne vas pas plus loin que la grosseur de la liste
		if(i < 0 || i >= listePatients.size()) {
			
			return null;
			
		}
		
		else {
			
			return listePatients.get(i);
			
		}
				
	}
	
	/**
	 * Retourne le calendrier de cette clinique
	 * @return
	 */
	public Calendrier getCalendrier() {
		
		return calendrier;
		
	}
	
	/*
	 * MÉTHODES
	 */
	
	/**
	 * Ajoute un docteur dans la liste de la clinique
	 * Ne l'ajoute pas s'il en existe déjà un pareil
	 * @param doc
	 * @return boolean
	 */
	public boolean ajouterDocteur(Docteur doc) {
		
		/*
		 * STRATÉGIE: Utiliser l'API de Java de LinkedList
		 * utiliser LinkedList.contains() pour savoir si le Docteur en question
		 * s'y trouve déjà, si non, le docteur y est ajouté après le dernier
		 * indice
		 */
		
		//Si contains retourne false la condition est exécuté et 
		// un Docteur est ajouté et true est retourné pour confirmer
		if(!listeDocteurs.contains(doc)) {
			
			listeDocteurs.add(doc);
			return true;
			
		}
		
		return false;
		
	}
	
	/**
	 * Ajoute un infirmier dans la liste de la clinique
	 * Ne l'ajoute pas s'il en existe déjà un pareil
	 * @param doc
	 * @return boolean
	 */
	public boolean ajouterInfirmier(Infirmier infirmier) {
		
		//Si contains retourne false la condition est exécuté et 
		// un Infirmier est ajouté et true est retourné pour confirmer
		if(!listeInfirmiers.contains(infirmier)) {
			
			listeInfirmiers.add(infirmier);
			return true;
			
		}
		
		return false;
		
	}
	
	/**
	 * Ajoute un patient dans la liste de la clinique
	 * Ne l'ajoute pas s'il en existe déjà un pareil
	 * @param doc
	 * @return boolean
	 */
	public boolean ajouterPatient(Patient patient) {
		
		//Si contains retourne false la condition est exécuté et 
		// un Patient est ajouté et true est retourné pour confirmer
		if(!listePatients.contains(patient)) {
			
			listePatients.add(patient);
			return true;
			
		}
		
		return false;
		
	}
	
	/*
	 * MUTATEURS
	 */
	
	/**
	 * Assigne un calendrier à la clinique
	 * @param calendrier
	 */
	public void setCalendrier(Calendrier calendrier) {
		
		this.calendrier = calendrier;
		
	}
	
	/**
	 * Trouve le premier rendez-vous qui peut être cédulé pour le patient
	 * @param patient
	 * @return
	 * @throws Exception 
	 */
	public RendezVous rendezVousPatient(Patient patient) throws Exception {
		
		/*
		 * STRATÉGIE : créer une Date qui prend celle du jour même
		 * On fait une boucle qui change l'heure et les minutes pour verifier
		 * quelle heure de départ est disponible dans le calendrier
		 * 
		 * Une heure est disponible s'il reste un Docteur et un infirmier
		 */
		
		//Servira à vérifier toutes les heures de départ d'une journée
		Date date = new Date();
		
		//Liste de toutes les heures possible pour un rendez-vous
		ArrayList<Date> listeHeuresDepart = this.genereHeuresDepart(date);
		
		//Parcours les heures de départ
		for(int i = 0; i < listeHeuresDepart.size(); i++) {
			
			//Parcours les docteurs
			for(int j = 0; j < listeDocteurs.size(); j++) {
				
				//Parcours les infirmiers
				for(int k = 0; k < listeInfirmiers.size(); k++) {
					
					//Rendez-vous à ajouter pour le patient
					RendezVous ren = 
							new RendezVous(patient, 
							this.getDocteur(j), 
							this.getInfirmier(k));
					
					//Ajoute un rendez-vous, s'il a bien été entré,
					//On retourne le rendez-vous créer
					if(calendrier.ajouterRendezVous(ren,
							listeHeuresDepart.get(i))) {
						
						return ren;
						
					}
					
				}
				
			}
			
		}
		
		return null;
		
	}
	
	/**
	 * Génère une liste des heures de départ possible pour des
	 * rendez-vous sur un intervalle quelconque
	 * @param date
	 * @return ArrayList<Date>
	 */
	private ArrayList<Date> genereHeuresDepart(Date date) {
		
		//Servira à vérifier toutes les heures de départ d'une journée
		//Les heures de départ commence à 8h
		date.setHours(Constantes.HEURE_OUVERTURE);
		date.setMinutes(0);
		
		ArrayList<Date> listeHeures = new ArrayList<Date>();

		while(date.getHours() <= Constantes.HEURE_FERMETURE ||
				(date.getHours() == Constantes.HEURE_FERMETURE &&
				date.getMinutes() == 0)) {
					
				//temporaire pour ajouté une date à une liste
				Date heureDepart = new Date();
				
				heureDepart = (Date) date.clone();
				
				listeHeures.add(heureDepart);
				
				date.setMinutes(date.getMinutes() + 
						Constantes.MINUTES_INTERVALLE[1]);
				
		}	
		
		return listeHeures;
		
	}
	
}
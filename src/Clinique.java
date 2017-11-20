import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Vector;

/**
 * Permet de conserver toutes les informations sur son personnel
 * et tous les rendez-vous
 * @author Micha�l Dallaire
 *
 */
public class Clinique implements Serializable {
	
	//ATTRIBUTS
	
	//Calendrier de la clinique au complet
	private Calendrier calendrier;
	
	//Liste docteur de la clinique par liste doublement cha�n�
	private LinkedList<Docteur> listeDocteurs = new LinkedList<Docteur>();
	
	//Liste infirmiers de la clinique par liste doublement cha�n�
	private LinkedList<Infirmier> listeInfirmiers = new LinkedList<Infirmier>();
	
	//Liste de patients de la clinique par liste Vecteur
	private Vector<Patient> listePatients = new Vector<Patient>();
	
	/*
	 * ACCESSEURS
	 */
	
	/**
	 * Retourne un docteur � un indice indiqu�
	 * Retourne Null si l'indice est hors des limites de la liste
	 * @param i
	 * @return Docteur
	 */
	public Docteur getDocteur(int i) {
		
		//V�rifie que l'indice ne vas pas plus loin que la grosseur de la liste
		if(i < 0 || i >= listeDocteurs.size()) {
			
			return null;
			
		}
		
		else {
			
			return listeDocteurs.get(i);
			
		}
		
	}
	
	/**
	 * Retourne un infirmier � un indice indiqu�
	 * Retourne Null si l'indice est hors des limites de la liste
	 * @param i
	 * @return Infirmier
	 */
	public Infirmier getInfirmier(int i) {
		
		//V�rifie que l'indice ne vas pas plus loin que la grosseur de la liste
		if(i < 0 || i >= listeInfirmiers.size()) {
			
			return null;
			
		}
		
		else {
			
			return listeInfirmiers.get(i);
			
		}
		
	}
	
	/**
	 * Retourne un patient � un indice indiqu�
	 * Retourne NUll si l'indice est hors des limites de la lsite
	 * @param i
	 * @return Patient
	 */
	public Patient getPatient(int i) {
		
		//V�rifie que l'indice ne vas pas plus loin que la grosseur de la liste
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
	 * M�THODES
	 */
	
	/**
	 * Ajoute un docteur dans la liste de la clinique
	 * Ne l'ajoute pas s'il en existe d�j� un pareil
	 * @param doc
	 * @return boolean
	 */
	public boolean ajouterDocteur(Docteur doc) {
		
		/*
		 * STRAT�GIE: Utiliser l'API de Java de LinkedList
		 * utiliser LinkedList.contains() pour savoir si le Docteur en question
		 * s'y trouve d�j�, si non, le docteur y est ajout� apr�s le dernier
		 * indice
		 */
		
		//Si contains retourne false la condition est ex�cut� et 
		// un Docteur est ajout� et true est retourn� pour confirmer
		if(!listeDocteurs.contains(doc)) {
			
			listeDocteurs.add(doc);
			return true;
			
		}
		
		return false;
		
	}
	
	/**
	 * Ajoute un infirmier dans la liste de la clinique
	 * Ne l'ajoute pas s'il en existe d�j� un pareil
	 * @param doc
	 * @return boolean
	 */
	public boolean ajouterInfirmier(Infirmier infirmier) {
		
		//Si contains retourne false la condition est ex�cut� et 
		// un Infirmier est ajout� et true est retourn� pour confirmer
		if(!listeInfirmiers.contains(infirmier)) {
			
			listeInfirmiers.add(infirmier);
			return true;
			
		}
		
		return false;
		
	}
	
	/**
	 * Ajoute un patient dans la liste de la clinique
	 * Ne l'ajoute pas s'il en existe d�j� un pareil
	 * @param doc
	 * @return boolean
	 */
	public boolean ajouterPatient(Patient patient) {
		
		//Si contains retourne false la condition est ex�cut� et 
		// un Patient est ajout� et true est retourn� pour confirmer
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
	 * Assigne un calendrier � la clinique
	 * @param calendrier
	 */
	public void setCalendrier(Calendrier calendrier) {
		
		this.calendrier = calendrier;
		
	}
	
	/**
	 * Trouve le premier rendez-vous qui peut �tre c�dul� pour le patient
	 * @param patient
	 * @return
	 * @throws Exception 
	 */
	public RendezVous rendezVousPatient(Patient patient) throws Exception {
		
		/*
		 * STRAT�GIE : cr�er une Date qui prend celle du jour m�me
		 * On fait une boucle qui change l'heure et les minutes pour verifier
		 * quelle heure de d�part est disponible dans le calendrier
		 * 
		 * Une heure est disponible s'il reste un Docteur et un infirmier
		 */
		
		//Servira � v�rifier toutes les heures de d�part d'une journ�e
		Date date = new Date();
		
		//Liste de toutes les heures possible pour un rendez-vous
		ArrayList<Date> listeHeuresDepart = this.genereHeuresDepart(date);
		
		//Parcours les heures de d�part
		for(int i = 0; i < listeHeuresDepart.size(); i++) {
			
			//Parcours les docteurs
			for(int j = 0; j < listeDocteurs.size(); j++) {
				
				//Parcours les infirmiers
				for(int k = 0; k < listeInfirmiers.size(); k++) {
					
					//Rendez-vous � ajouter pour le patient
					RendezVous ren = 
							new RendezVous(patient, 
							this.getDocteur(j), 
							this.getInfirmier(k));
					
					//Ajoute un rendez-vous, s'il a bien �t� entr�,
					//On retourne le rendez-vous cr�er
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
	 * G�n�re une liste des heures de d�part possible pour des
	 * rendez-vous sur un intervalle quelconque
	 * @param date
	 * @return ArrayList<Date>
	 */
	private ArrayList<Date> genereHeuresDepart(Date date) {
		
		//Servira � v�rifier toutes les heures de d�part d'une journ�e
		//Les heures de d�part commence � 8h
		date.setHours(Constantes.HEURE_OUVERTURE);
		date.setMinutes(0);
		
		ArrayList<Date> listeHeures = new ArrayList<Date>();

		while(date.getHours() <= Constantes.HEURE_FERMETURE ||
				(date.getHours() == Constantes.HEURE_FERMETURE &&
				date.getMinutes() == 0)) {
					
				//temporaire pour ajout� une date � une liste
				Date heureDepart = new Date();
				
				heureDepart = (Date) date.clone();
				
				listeHeures.add(heureDepart);
				
				date.setMinutes(date.getMinutes() + 
						Constantes.MINUTES_INTERVALLE[1]);
				
		}	
		
		return listeHeures;
		
	}
	
}
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Classe représentant l'horaire d'une journée de la clinique. Elle 
 * contient deux attributs la date et l'heure de la plage horaire 
 * et une liste des rendez-vous placé durant la plage horaire.
 * 
 * @author Niko Girardelli
 * @since (copyright) Niko Girardelli - A2017
 * @version Niko Girardelli - A2017
 */

public class PlageHoraire implements Serializable {
	
	// Attributs pour la classe Patient
	private Date date = new Date();
	private ArrayList<RendezVous> listeRendezVous;
	
	/***************************
     * * Les constructeurs
     * **************************/
	
	/**
	 * Le constructeur reçoit une date et l'assigne à la plage horaire,
	 * et la liste des rendez-vous est instanciée, mais est vide.
	 * 
	 * @param annee
	 * 		  Un entier qui représente l'année, on doit enlever 1900 pour 
	 * 		  avoir la bonne anéee. 
	 * @param mois
	 * 		  Un entier qui représente le mois, on doit soustraire 1, car 
	 * 		  les mois sont entre 0 et 11.
	 * @param jour
	 * 		  Un entier qui représente le jour pour la nouvelle date. 
	 * @param heure
	 * 		  Un entier qui représente heure de la nouvelle date.
	 * @param minute
	 * 		  Un entier qui représente les minutes d'une nouvelle date.
	 */
	public PlageHoraire(int annee, int mois, int jour, int heure, int minute) {
		
		this.setDate(annee, mois, jour, heure, minute);
		this.listeRendezVous = new ArrayList<RendezVous>();
		
	}
	
	/***************************
     * * Les accesseurs.
     * **************************/
	
	/**
	 * Retourne la date de cette plage horaire.
	 * 
	 * @return Date date.
	 */
	public Date getDate() {
		
		return date;
		
	}
	
	/**
	 * Retourne une copie de la liste des rendez-vous de cette 
	 * plage horaire (la référence).
	 * 
	 * @return ArrayList<RendezVous> listeRendezVous.
	 */
	public ArrayList<RendezVous> getRendezVous() {
		
		return listeRendezVous;
		
	}
	
	/***************************
     * * Les mutateurs.
     * **************************/
	
	/**
	 * Change les valeurs de la date avec celles qui sont 
	 * passées en paramètres.
	 * 
	 * @param annee
	 * 		  Un entier qui représente l'année, on doit enlever 1900 
	 * 	      pour avoir la bonne anéee. 
	 * @param mois
	 * 		  Un entier qui représente le mois, on doit soustraire 1, 
	 * 		  car les mois sont entre 0 et 11.
	 * @param jour
	 * 		  Un entier qui représente le jour pour la nouvelle date. 
	 * @param heure
	 * 		  Un entier qui représente heure de la nouvelle date.
	 * @param minute
	 * 		  Un entier qui représente les minutes d'une nouvelle date.
	 * 
	 * @return void.
	 */
	public void setDate(int annee, int mois, int jour, int heure, int minute) {
		
		// On modifie les valeurs de l'année, le mois, le jour,
		// l'heure et les minutes d'une plage horaire.
		this.date.setYear(annee - 1900);
		this.date.setMonth(mois - 1);
		this.date.setDate(jour);
		this.date.setHours(heure);
		this.date.setMinutes(minute);
		
	}
	
	/**
	 * Reçoit un rendez-vous et l'ajoute à la plage horaire,
	 * retourne vrai si l'ajout a fonctionné, sinon false.
	 * 
	 * @param rendezVous
	 * 		  La classe RendezVous.
	 * 
	 * @return void.
	 */
	public boolean addRendezVous(RendezVous rendezVous) {
		
		// Vérifie si rendezVous n'est pas dans la liste et l'ajoute 
		// s'il n'est pas présent.
		if(!listeRendezVous.contains(rendezVous)) {
			
			listeRendezVous.add(rendezVous);
			return true;
			
		}
		
		return false;
		
	}
	
	/***************************
     * * Les comportements.
     * **************************/
	
    /**
	 * Retourne une chaîne contenant les informations d'un rendez-vous.
	 * 
	 * @return patient.toString(), docteur.toString() et infirmier.toString().
	 */
	public String toString() {
		
		String phrase = "";
		
		// Boucle qui parcourt toute la liste des rendez-vous.
		for(int i = 0; i < listeRendezVous.size(); i++) {
			
			phrase += listeRendezVous.get(i).toString() + ", "; 
			
		}
    	
    	return "\nDate de la plage horaire : " + date.toString() +
    		   "\nLes rendez-vous : " + phrase;
    
    }
	
}
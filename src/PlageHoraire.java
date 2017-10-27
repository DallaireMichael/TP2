import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Classe représentant l'horaire d'une journée de la clinique. Elle contient deux attributs
 * la date et l'heure de la plage horaire et une liste des rendez-vous placé durant la plage horaire.
 * 
 * @author Niko Girardelli
 * @since (copyright) Niko Girardelli - A2017
 * @version Niko Girardelli - A2017
 */

public class PlageHoraire implements Serializable {
	
	// Attributs pour la classe Patient
	private Date date;
	private ArrayList<RendezVous> listeRendezVous;
	
	/***************************
     * * Les constructeurs
     * **************************/
	
	/**
	 * Le constructeur reçoit une date et l'assigne à la plage horaire,
	 * et la liste des rendez-vous est instanciée, mais est vide.
	 * 
	 * @param date
	 * 		  Reçoit une Date.
	 */
	public PlageHoraire(Date date) {
		
		this.setDate(date);
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
	 * Retourne une copie de la liste des rendez-vous de cette plage horaire (la référence).
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
	 * Change la valeur de la date avec celle qui est passé en paramètre.
	 * 
	 * @param date
	 * 		  La nouvelle date pour la plage horaire.
	 * 
	 * @return void.
	 */
	public void setDate(Date date) {
		
		this.date = date;
		
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
		
		// Vérifie si rendezVous n'est pas dans la liste et l'ajoute s'il n'est pas présent.
		if(!listeRendezVous.contains(rendezVous)) {
			
			listeRendezVous.add(rendezVous);
			return true;
			
		}
		
		else {
		
			return false;

		}
		
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
			
			phrase = listeRendezVous.get(i) + ", "; 
			
		}
    	
    	return "\nDate de la plage horaire : " + date.toString() +
    		   "\nLes rendez-vous : " + phrase;
    
    }
	
}
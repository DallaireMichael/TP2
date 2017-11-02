import java.io.Serializable;

/**
 * Classe représentant un rendez-vous par ses trois attributs qui sont
 * une instance de la classe Infirmier, une instance de la classe Docteur 
 * et une instance de la classe Patient qui sont affectées au rendez-vous.
 * 
 * @author Niko Girardelli
 * @since (copyright) Niko Girardelli - A2017
 * @version Niko Girardelli - A2017
 */

public class RendezVous implements Serializable {
	
	// Attributs pour la classe Patient
	private Patient patient;
	private Docteur docteur;
	private Infirmier infirmier;
	
	/***************************
     * * Les constructeurs
     * **************************/
	
	/**
	 * Le constructeur par copie d'attributs.
	 * 
	 * @param patient
	 * 		  La classe Patient.
	 * @param docteur
	 * 		  La classe Docteur.
	 * @param infirmier
	 * 		  La classe Infirmier.
	 */
	public RendezVous(Patient patient, 
			Docteur docteur, 
			Infirmier infirmier) throws Exception {
		
		// Si un attribut est null, une exception est levée.
		if(patient == null || docteur == null || infirmier == null) {
			
			throw new Exception("Attribut nul pour un " + 
								"rendez-vous est interdit.");
			
		}
		
		this.patient = patient.clone();
		this.docteur = docteur.clone();
		this.infirmier = infirmier.clone();
		
	}
	
	/***************************
     * * Les accesseurs.
     * **************************/
	
	/**
	 * Retourne la référence de la classe Patient d'un rendez-vous.
	 * 
	 * @return Patient patient.
	 */
	public Patient getPatient() {
		
		return patient;
		
	}
	
	/**
	 * Retourne la référence de la classe Docteur d'un rendez-vous.
	 * 
	 * @return Docteur docteur.
	 */
	public Docteur getDocteur() {
		
		return docteur;
		
	}
	
	/**
	 * Retourne la référence de la classe Infirmier d'un rendez-vous.
	 * 
	 * @return Infirmier infirmier.
	 */
	public Infirmier getInfirmier() {
		
		return infirmier;
		
	}
	
	/***************************
     * * Les mutateurs.
     * **************************/
	
	/**
	 * Change la valeur de la référence de la classe Patient d'un rendez-vous.
	 * 
	 * @param patient
	 * 		  La classe Patient.
	 * 
	 * @return void.
	 */
	public void setPatient(Patient patient) {
		
		this.patient = patient;
		
	}
	
	/**
	 * Change la valeur de la référence de la classe Docteur d'un rendez-vous.
	 * 
	 * @param docteur
	 * 		  La classe Docteur.
	 * 
	 * @return void.
	 */
	public void setDocteur(Docteur docteur) {
		
		this.docteur = docteur;
		
	}
	
	/**
	 * Change la valeur de la référence de la classe Infirmier d'un rendez-vous.
	 * 
	 * @param infirmier
	 * 		  La classe Infirmier.
	 * 
	 * @return void.
	 */
	public void setInfirmier(Infirmier infirmier) {
		
		this.infirmier = infirmier;
		
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
    	
    	return "\nRendez-vous Patient : " + patient.toString() +
    		   "\nRendez-vous Docteur : " + docteur.toString() +
    		   "\nRendez-vous Infirmier : " + infirmier.toString();
    
    }
	
	/**
	 * Retourne le résultat de la comparaison de deux rendez-vous.
	 * 
	 * @param rendezVous
	 * 		  La classe RendezVous que veut comparer les valeurs des attributs.
	 * 
	 * @return boolean.
	 */
	public boolean equals(RendezVous rendezVousComparaison) {
    	
    	return this.patient.equals(rendezVousComparaison.getPatient()) &&
    		   this.docteur.equals(rendezVousComparaison.getDocteur()) &&
    		   this.infirmier.equals(rendezVousComparaison.getInfirmier()); 
    
    }
	
}
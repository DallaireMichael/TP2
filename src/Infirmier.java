import java.io.Serializable;

/**
 * Classe représentant un infirmier par ses deux attributs qui sont
 * une instance de la classe Identification et sa disponibilité, qui est
 * un booléen.
 * 
 * @author Niko Girardelli
 * @since (copyright) Niko Girardelli - A2017
 * @version Niko Girardelli - A2017
 */

public class Infirmier extends Participant implements Serializable {
	
	private boolean disponible;
	
	/***************************
     * * Les constructeurs
     * **************************/
	
	/**
	 * Le constructeur par défaut.
	 */
	public Infirmier() {
		
		this.disponible = false;
		
	}
	
	/**
	 * Le constructeur par copie d'attributs.
	 * 
	 * @param id
	 * 		  La classe Identification.
	 * @param disponible
	 * 		  Un booléen pour connaître la disponibilité de l'infirmier.
	 */
	public Infirmier(Identification id, boolean disponible) {
		
		super(id.clone());
		this.setDisponibilite(disponible);
		
	}
	
	/**
	 * Le constructeur par copie d'objet.
	 * 
	 * @param infirmierCopie
	 * 		  La classe Infirmier qu'on veut copie les attributs.
	 */
	public Infirmier(Infirmier infirmierCopie) {
		
		super(infirmierCopie.getIdentification());
		
		this.disponible = infirmierCopie.getDisponibilite();
		
	}
	
	/***************************
     * * Les accesseurs.
     * **************************/
	
	/**
	 * Retourne le booléen de la disponibilité d'un infirmier.
	 * 
	 * @return boolean.
	 */
	public boolean getDisponibilite() {
		
		return disponible;
		
	}
	
	
	/***************************
     * * Les mutateurs.
     * **************************/
	
	/**
	 * Change la valeur du booléen de la disponibilité d'un infirmier.
	 * 
	 * @param disponible
	 * 		  Un booléen pour connaître la disponibilité de l'infirmier.
	 * 
	 * @return void.
	 */
	public void setDisponibilite(boolean disponible) {
		
		this.disponible = disponible;
		
	}
	
	
	/***************************
     * * Les comportements.
     * **************************/
	
    /**
	 * Retourne une chaîne contenant les informations de l'infirmier.
	 * 
	 * @return id.toString() et disponible.
	 */
	public String toString() {
    	
    	return "\nNom de l'infirmier : " + super.toString() + "\nDisponible : " +
    			this.getDisponibilite();
    	
    }
	
	/**
	 * Retourne le résultat de la comparaison de deux infirmiers.
	 * 
	 * @param infirmierCopie
	 * 		  La classe Infirmier qu'on veut comparer les valeurs des attributs.
	 * 
	 * @return boolean.
	 */
	public boolean equals(Infirmier infirmerComparaison) {
    	
    	return super.equals(infirmerComparaison.getIdentification()) &&
    		   this.getDisponibilite() == 
    		   infirmerComparaison.getDisponibilite(); 
    
    }
	
	/**
	 * Retourne une copie de notre infirmier avec une nouvelle référence.
	 * 
	 * @return Infirmier.
	 */
	public Infirmier clone() {
    	
    	return new Infirmier(super.getIdentification(),this.getDisponibilite());
    
    }
	
	/**
	 * Retourne une chaîne de caractères qui définie
	 * qu'est-ce que l'objet
	 */
	public String getCategorieParticipant() {
		
		return "Infirmier";
		
	}
	
}
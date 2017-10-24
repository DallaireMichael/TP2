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

public class Infirmier implements Serializable {
	
	// Attributs pour la classe Infirmier
	private Identification id;
	private boolean disponible;
	
	/***************************
     * * Les constructeurs
     * **************************/
	
	/**
	 * Le constructeur par défaut.
	 */
	public Infirmier() {
		
		this.id = new Identification();
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
		
		this.id.setNom(id.getNom());
		this.id.setPrenom(id.getPrenom());
		this.setDisponibilite(disponible);
		
	}
	
	/**
	 * Le constructeur par copie d'objet.
	 * 
	 * @param infirmierCopie
	 * 		  La classe Infirmier qu'on veut copie les attributs.
	 */
	public Infirmier(Infirmier infirmierCopie) {
		
		this(infirmierCopie.id.clone(), infirmierCopie.getDisponibilite());
		
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
	
	/**
	 * Retourne la référence de l'indentifiant d'un infirmier.
	 * 
	 * @return Identifitcation id.
	 */
	public Identification getIdentification() {
		
		return id;
		
	}
	
	/***************************
     * * Les mutateurs.
     * **************************/
	
	/**
	 * Change la valeur du booléen de la disponibilité d'un infirmier.
	 * 
	 * @return void.
	 */
	public void setDisponibilite(boolean disponible) {
		
		this.disponible = disponible;
		
	}
	
	/**
	 * Change la valeur de la référence de l'identifiant d'un l'infirmier.
	 * 
	 * @return void.
	 */
	public void setIdentification(Identification id) {
		
		this.id = id;
		
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
    	
    	return "\nNom de l'infirmier: " + id.toString()+ "\nDisponible : " + this.getDisponibilite();
    
    }
	
	/**
	 * Retourne le résultat de la comparaison de deux infirmiers.
	 * 
	 * @return boolean.
	 */
	public boolean equals(Infirmier infirmerComparaison) {
    	
    	return this.id.equals(infirmerComparaison.getIdentification()) &&
    		   this.getDisponibilite() == infirmerComparaison.getDisponibilite(); 
    
    }
	
	/**
	 * Retourne une copie de notre infirmier avec une nouvelle référence.
	 * 
	 * @return Infirmier.
	 */
	public Infirmier clone() {
    	
    	return new Infirmier(this.getIdentification(),this.getDisponibilite());
    
    }
	
}
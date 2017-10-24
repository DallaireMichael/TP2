import java.io.Serializable;

/**
 * Classe repr�sentant un infirmier par ses deux attributs qui sont
 * une instance de la classe Identification et sa disponibilit�, qui est
 * un bool�en.
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
	 * Le constructeur par d�faut.
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
	 * 		  Un bool�en pour conna�tre la disponibilit� de l'infirmier.
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
	 * Retourne le bool�en de la disponibilit� d'un infirmier.
	 * 
	 * @return boolean.
	 */
	public boolean getDisponibilite() {
		
		return disponible;
		
	}
	
	/**
	 * Retourne la r�f�rence de l'indentifiant d'un infirmier.
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
	 * Change la valeur du bool�en de la disponibilit� d'un infirmier.
	 * 
	 * @return void.
	 */
	public void setDisponibilite(boolean disponible) {
		
		this.disponible = disponible;
		
	}
	
	/**
	 * Change la valeur de la r�f�rence de l'identifiant d'un l'infirmier.
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
	 * Retourne une cha�ne contenant les informations de l'infirmier.
	 * 
	 * @return id.toString() et disponible.
	 */
	public String toString() {
    	
    	return "\nNom de l'infirmier: " + id.toString()+ "\nDisponible : " + this.getDisponibilite();
    
    }
	
	/**
	 * Retourne le r�sultat de la comparaison de deux infirmiers.
	 * 
	 * @return boolean.
	 */
	public boolean equals(Infirmier infirmerComparaison) {
    	
    	return this.id.equals(infirmerComparaison.getIdentification()) &&
    		   this.getDisponibilite() == infirmerComparaison.getDisponibilite(); 
    
    }
	
	/**
	 * Retourne une copie de notre infirmier avec une nouvelle r�f�rence.
	 * 
	 * @return Infirmier.
	 */
	public Infirmier clone() {
    	
    	return new Infirmier(this.getIdentification(),this.getDisponibilite());
    
    }
	
}
import java.io.Serializable;

/**
 * Classe représentant un patient par ses deux attributs qui sont
 * une instance de la classe Identification et son numéro d'assurance social, qui est un entier.
 * 
 * @author Niko Girardelli
 * @since (copyright) Niko Girardelli - A2017
 * @version Niko Girardelli - A2017
 */

public class Patient implements Serializable {
	
	// Attributs pour la classe Patient
	private Identification id;
	private int numeroAssuranceSocial;
	
	/***************************
     * * Les constructeurs
     * **************************/
	
	/**
	 * Le constructeur par défaut.
	 */
	public Patient() {
		
		id = new Identification();
		numeroAssuranceSocial = 0;
		
	}
	
	/**
	 * Le constructeur par copie d'attributs.
	 * 
	 * @param id
	 * 		  La classe Identification.
	 * @param numeroAssuranceSocial
	 * 		  Un entier qui représente le numéro d'assurance social d'un patient.
	 */
	public Patient(Identification id, int numeroAssuranceSocial) {
		
<<<<<<< HEAD
<<<<<<< HEAD
		id = id.clone();
=======
		this.id = id.clone();
>>>>>>> afdf5b8ce88d527374013ac3b240009b0a8f07f1
=======
		this.id = id.clone();
>>>>>>> 28a3b7f19a808fadd5314ec9f1575ec3ac595fd9
		this.setNumeroAssuranceSocial(numeroAssuranceSocial);
		
	}
	
	/**
	 * Le constructeur par copie d'objet.
	 * 
	 * @param patientCopie
	 * 		  La classe patient qu'on veut copie les attributs.
	 */
	public Patient(Patient patientCopie) {
		
		this(patientCopie.id.clone(), patientCopie.getNumeroAssuranceSocial());
		
	}
	
	/***************************
     * * Les accesseurs.
     * **************************/
	
	/**
	 * Retourne l'entier qui est le numéro d'assurance social d'un patient.
	 * 
	 * @return int numeroAssuranceSocial.
	 */
	public int getNumeroAssuranceSocial() {
		
		return numeroAssuranceSocial;
		
	}
	
	/**
	 * Retourne la référence de l'indentifiant d'un patient.
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
	 * Change la valeur du numéro d'assurance social d'un patient.
	 * 
	 * @param numeroAssuranceSocial
	 * 		  Un entier qui représente le numéro d'assurance social d'un patient.
	 * 
	 * @return void.
	 */
	public void setNumeroAssuranceSocial(int numeroAssuranceSocial) {
		
		this.numeroAssuranceSocial = numeroAssuranceSocial;
		
	}
	
	/**
	 * Change la valeur de la référence de l'identifiant d'un patient.
	 * 
	 * @param id
	 * 		  La classe Identification.
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
	 * Retourne une chaîne contenant les informations du patient.
	 * 
	 * @return id.toString() et numeroAssuranceSocial.
	 */
	public String toString() {
    	
    	return "\nNom du patient : " + id.toString() +
    		   "\nNuméro d'assurance social : " + this.getNumeroAssuranceSocial();
    
    }
	
	/**
	 * Retourne le résultat de la comparaison de deux patients.
	 * 
     * @param patientCopie
	 * 		  La classe patient qu'on veut comparer les valeurs des attributs.
	 * 
	 * @return boolean.
	 */
	public boolean equals(Patient patientComparaison) {
    	
    	return this.id.equals(patientComparaison.getIdentification()) &&
    		   this.getNumeroAssuranceSocial() == patientComparaison.getNumeroAssuranceSocial(); 
    
    }
	
	/**
	 * Retourne une copie de notre patient avec une nouvelle référence.
	 * 
	 * @return patient.
	 */
	public Patient clone() {
    	
    	return new Patient(this.getIdentification(),this.getNumeroAssuranceSocial());
    
    }
	
}
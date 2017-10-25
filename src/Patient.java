import java.io.Serializable;

/**
 * Classe repr�sentant un patient par ses deux attributs qui sont
 * une instance de la classe Identification et son num�ro d'assurance social, qui est un entier.
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
	 * Le constructeur par d�faut.
	 */
	public Patient() {
		
		this.id = new Identification();
		this.numeroAssuranceSocial = 0;
		
	}
	
	/**
	 * Le constructeur par copie d'attributs.
	 * 
	 * @param id
	 * 		  La classe Identification.
	 * @param numeroAssuranceSocial
	 * 		  Un entier qui repr�sente le num�ro d'assurance social d'un patient.
	 */
	public Patient(Identification id, int numeroAssuranceSocial) {
		
		this.id.setNom(id.getNom());
		this.id.setPrenom(id.getPrenom());
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
	 * Retourne l'entier qui est le num�ro d'assurance social d'un patient.
	 * 
	 * @return int numeroAssuranceSocial.
	 */
	public int getNumeroAssuranceSocial() {
		
		return numeroAssuranceSocial;
		
	}
	
	/**
	 * Retourne la r�f�rence de l'indentifiant d'un patient.
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
	 * Change la valeur du num�ro d'assurance social d'un patient.
	 * 
	 * @return void.
	 */
	public void setNumeroAssuranceSocial(int numeroAssuranceSocial) {
		
		this.numeroAssuranceSocial = numeroAssuranceSocial;
		
	}
	
	/**
	 * Change la valeur de la r�f�rence de l'identifiant d'un patient.
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
	 * Retourne une cha�ne contenant les informations du patient.
	 * 
	 * @return id.toString() et numeroAssuranceSocial.
	 */
	public String toString() {
    	
    	return "\nNom du patient: " + id.toString()+ "\nNum�ro d'assurance social : " + this.getNumeroAssuranceSocial();
    
    }
	
	/**
	 * Retourne le r�sultat de la comparaison de deux patients.
	 * 
	 * @return boolean.
	 */
	public boolean equals(Patient patientComparaison) {
    	
    	return this.id.equals(patientComparaison.getIdentification()) &&
    		   this.getNumeroAssuranceSocial() == patientComparaison.getNumeroAssuranceSocial(); 
    
    }
	
	/**
	 * Retourne une copie de notre patient avec une nouvelle r�f�rence.
	 * 
	 * @return patient.
	 */
	public Patient clone() {
    	
    	return new Patient(this.getIdentification(),this.getNumeroAssuranceSocial());
    
    }
	
}
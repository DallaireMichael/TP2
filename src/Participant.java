import java.io.Serializable;

/**
 * Contient un attribut de type Identification et sera parent dans
 * diverses classes enfants dont Infirmier, Patient et Docteur.
 * @author Niko Girardelli
 * @version 1.0
 */
public class Participant implements Serializable {
	
	//Contient un attribut de type Identifiant 
	private Identification id;
	
	/**
	 * Constructeur par défaut
	 */
	public Participant() {
		
		id = new Identification();
		
	}
	
	/**
	 * Constructeur par copie d'attributs
	 * @param Identification id
	 */
	public Participant(Identification id) {
		
		id = id.clone();

	}
	
	/**
	 * Constructeur par copie d'Identification.
	 * @param id
	 */
	public Participant(Participant participant) {
		
		this.id = participant.getIdentification().clone();
		
	}
	
	/*
	 * MUTATEURS
	 */
	
	/**
	 * Mute id avec les informations données.
	 * @param id
	 */
	public void setIdentification(String nom, String prenom) {
		
		this.id.setNom(nom);
		this.id.setPrenom(prenom);
		
	}
	
	/*
	 * ACCESSEUR
	 */
	
	/**
	 * Retourne l'identificant.
	 * @return id
	 */
	public Identification getIdentification() {
		
		return this.id;
		
	}
	
	/**
	 * Retourne le résultat.
	 * @return id
	 */
	public boolean equals(Participant participant){
		
		return this.id.equals(participant.getIdentification());
		
	}
	
	/**
	 * Clone Identification du participant
	 * @return Participant
	 */
	public Participant clone() {
		
		return new Participant(id.clone());
		
	}
	
	/**
	 * Retourne les attributs en chaîne pour tester
	 * @return String
	 */
	public String toString() {
		
		return this.id.toString();
		
	}
	
	public String getCategorieParticipant() {
		
		return Constantes.MSG_GET_CATEGORIE_PARTICIPANT;
		
	}
	
}

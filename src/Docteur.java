import java.io.Serializable;

/**
 * Décrit une personne ayant comme titre de Docteur
 * Elle permet d'accéder à son identification et son 
 * départememnt
 * @author Michaël Dallaire
 * @version 1.0
 */
public class Docteur extends Participant implements Serializable{
	
	/*
	 * ATTRIBUTS
	 */
	
	//Le numéro du département
	private int departement;
	
	/*
	 * CONSTRUCTEURS
	 */
	
	/**
	 * Constructeur par défaut
	 */
	public Docteur(){
		
		departement = 0;
		
	}
	
	
	/**
	 * Constructeur par copie d'attributs
	 * @param id
	 * @param departement
	 */
	public Docteur(Identification id, int departement){
		
		super(id);
		this.departement = departement;
		
	}
	
	/**
	 * Constructeur par copie d'objet
	 * @param doc
	 */
	public Docteur(Docteur doc){
		
		super(doc.getIdentification());
		departement = doc.departement;
	}
	
	/*
	 * MUTATEURS
	 */
	
	/**
	 * Mute departement
	 * @param departement
	 */
	public void setDepartement(int departement){
		this.departement = departement;
	}
	
	/*
	 * ACCESSEURS 
	 */
	
	/**
	 * Retourne son departement
	 * @return departement
	 */
	public int getDepartement(){
		return departement;
	}
	
	/**
	 * Vérifie si les deux docteurs sont exactement pareil
	 * @param doc
	 * @return boolean
	 */
	public boolean equals(Docteur doc){
		return super.equals(doc.getIdentification()) && 
				departement == doc.departement;
	}
	
	/**
	 * Retourne une nouvelle référence de Docteur
	 * avec les même valeurs que le Docteur présent
	 * @param doc
	 * @return Docteur
	 */
	public Docteur clone(){
		return new Docteur(super.getIdentification().clone(),departement);
	}
	
	/**
	 * Retourne tous les attributs en chaîne
	 * @return String
	 */
	public String toString(){
		return super.toString()+" "+departement ;
	}
	
	/**
	 * Retourne une chaîne de caractères qui définie
	 * qu'est-ce que l'objet
	 */
	public String getCategorieParticipant() {
		
		return Constantes.MSG_GET_CATEGORIE_DOCTEUR;
		
	}
}
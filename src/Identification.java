import java.io.Serializable;

/*
 * Tous les utilisateurs devront passé par 
 * Identification. Plusieurs classes hériteront 
 * de cette classe
 * @author Michaël Dallaire
 * @version 1.0
 */
public class Identification implements Serializable{
	
	//Contient le nom d'une personne
	private String nom;
	
	//Contient le prenom d'une personne
	private String prenom;
	
	/**
	 * Constructeur par défaut
	 */
	public Identification(){
		nom = "";
		prenom = "";
	}
	
	/**
	 * Constructeur par copie d'attributs
	 * @param nom
	 * @param prenom
	 */
	public Identification(String nom, String prenom){
		this.nom = nom;
		this.prenom = prenom;
	}
	
	/**
	 * Constructeur par copie d'Identification
	 * @param id
	 */
	public Identification(Identification id){
		nom = id.nom;
		prenom = id.prenom;
	}
	
	/*
	 * MUTATEURS
	 */
	
	/**
	 * Mute nom
	 * @param nom
	 */
	public void setNom(String nom){
		this.nom = nom;
	}
	
	/**
	 * Mute prenom
	 * @param prenom
	 */
	public void setPrenom(String prenom){
		this.prenom = prenom;
	}
	
	/*
	 * ACCESSEUR
	 */
	
	/**
	 * Retourne le nom
	 * @return nom
	 */
	public String getNom(){
		return this.nom;
	}
	
	/**
	 * Retourne le prenom
	 * @return prenom
	 */
	public String getPrenom(){
		return this.prenom;
	}
	
	public boolean equals(Identification id){
		
		//Arrête la comparaison si l'objet passé est null
		if(id == null) return false;
		
		//Arrête la comparaison si this est la même référence que id
		if(this == id) return true;
		
		//retourne false dans tous les autres cas
		return false;
		
	}
	
	/**
	 * Clone Identification actuelle
	 * @return Identification
	 */
	public Object clone(){
		return new Identification(this.nom, this.prenom);
	}
	
	/**
	 * Retourne les attributs en chaîne pour tester
	 * @return String
	 */
	public String toString(){
		return nom+", "+prenom;
	}
	
}
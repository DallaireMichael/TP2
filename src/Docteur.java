import java.io.Serializable;

/**
 * D�crit une personne ayant comme titre de Docteur
 * Elle permet d'acc�der � son identification et son 
 * d�partememnt
 * @author Micha�l Dallaire
 * @version 1.0
 */
public class Docteur implements Serializable{
	
	/*
	 * ATTRIBUTS
	 */
	
	//L'instance d'identification
	private Identification id;
	
	//Le num�ro du d�partement
	private int departement;
	
	/*
	 * CONSTRUCTEURS
	 */
	
	/**
	 * Constructeur par d�faut
	 */
	public Docteur(){
		
		id = new Identification();
		departement = 0;
		
	}
	
	
	/**
	 * Constructeur par copie d'attributs
	 * @param id
	 * @param departement
	 */
	public Docteur(Identification id, int departement){
		
		this.id = id.clone();
		this.departement = departement;
		
	}
	
	/**
	 * Constructeur par copie d'objet
	 * @param doc
	 */
	public Docteur(Docteur doc){
		
		id = doc.id.clone();
		departement = doc.departement;
	}
	
	/*
	 * MUTATEURS
	 */
	
	/**
	 * Mute l'identification du docteur 
	 * @param id
	 */
	public void setId(Identification id){
		this.id = id.clone();
	}
	
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
	 * Retourne son identification
	 * @return id
	 */
	public Identification getId(){
		return id;
	}
	
	/**
	 * Retourne son departement
	 * @return departement
	 */
	public int getDepartement(){
		return departement;
	}
	
	/**
	 * V�rifie si les deux docteurs sont exactement pareil
	 * @param doc
	 * @return boolean
	 */
	public boolean equals(Docteur doc){
		return this.id.equals(doc.id) && 
				departement == doc.departement;
	}
	
	/**
	 * Retourne une nouvelle r�f�rence de Docteur
	 * avec les m�me valeurs que le Docteur pr�sent
	 * @param doc
	 * @return Docteur
	 */
	public Docteur clone(){
		return new Docteur(id.clone(),departement);
	}
	
	/**
	 * Retourne tous les attributs en cha�ne
	 * @return String
	 */
	public String toString(){
		return id.toString()+" "+departement ;
	}
}
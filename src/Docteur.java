import java.io.Serializable;

/**
 * D�crit une personne ayant comme titre de Docteur
 * Elle permet d'acc�der � son identification et son 
 * d�partememnt
 * @author Micha�l Dallaire
 * @version 1.0
 */
public class Docteur extends Participant implements Serializable{
	
	/*
	 * ATTRIBUTS
	 */
	
	//Le num�ro du d�partement
	private int departement;
	
	/*
	 * CONSTRUCTEURS
	 */
	
	/**
	 * Constructeur par d�faut
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
	 * V�rifie si les deux docteurs sont exactement pareil
	 * @param doc
	 * @return boolean
	 */
	public boolean equals(Docteur doc){
		return super.equals(doc.getIdentification()) && 
				departement == doc.departement;
	}
	
	/**
	 * Retourne une nouvelle r�f�rence de Docteur
	 * avec les m�me valeurs que le Docteur pr�sent
	 * @param doc
	 * @return Docteur
	 */
	public Docteur clone(){
		return new Docteur(super.getIdentification().clone(),departement);
	}
	
	/**
	 * Retourne tous les attributs en cha�ne
	 * @return String
	 */
	public String toString(){
		return super.toString()+" "+departement ;
	}
	
	/**
	 * Retourne une cha�ne de caract�res qui d�finie
	 * qu'est-ce que l'objet
	 */
	public String getCategorieParticipant() {
		
		return Constantes.MSG_GET_CATEGORIE_DOCTEUR;
		
	}
}
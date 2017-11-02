import java.io.Serializable;

/**
 * Liste simplement chaîné
 * Liste dynamique
 * @author Michaël Dallaire
 *
 */
public class Liste implements Serializable {
	
	/**
	 * Noeud permet de faire une liste
	 * dynamique
	 * @author Michaël Dallaire
	 *
	 */
	private class Noeud implements Serializable {
		
		//sauvegarde d'un element du type au choix
		private Object element;
		
		//sauvegarde de la référence du Noeud qui suit
		private Noeud suivant;
		
		/**
		 * Constructeur par défaut d'un Noeud
		 * @param element
		 * @param suivant
		 */
		public Noeud(Object element, Noeud suivant) {
			this.element = element;
			this.suivant = suivant;
		}
	}
	
	//Attributs de la Liste
	
	//Noeud de debut de la Liste
	private Noeud debut;
	
	//Noeud de fin de la Liste
	private Noeud fin;
	
	//Noeud de position courante de la liste
	private Noeud pc;
	
	//Nombre d'éléments dans la Liste
	private int nbElements;
	
	
	/*
	 * CONSTRUCTEUR Liste
	 */
	public Liste () {
		debut = null;
		fin = null;
		pc = null;
		nbElements = 0;
	}
	
	
	/*
	 * MÉTHODES
	 */
	
	/**
	 * insere un element dans la liste dynamique
	 * @param element
	 */
	public void inserer(Object element) {
		
		//Liste est vide
		if(nbElements == 0) {
			
			initListe(element);
			
		}
		//Si Position courante se trouve au début
		else if(pc == debut) {
			
			debut = new Noeud(element, debut);
			pc = debut;
			
		}
		//Tous les autres cas
		else {
			
			pc.suivant = new Noeud(pc.element, pc.suivant);
			pc.element = element;
			
		}
		
		nbElements++;
	}
	
	/**
	 * Trouve le noeud qui précéde le présent Noeud
	 * @return Noeud
	 */
	private Noeud noeudPrecedent(){
		
		Noeud tmp = debut;
		
		//Tant que tmp n'est pas = à pc
		while(tmp.suivant != pc) {
			tmp = tmp.suivant;
		}
		
		return tmp;
	}
	
	/**
	 * Initialise la Liste lorsque vide
	 * @param element
	 */
	private void initListe(Object element) {
		
		debut = new Noeud(element, null);
		fin = debut;
		pc = debut;
		
	}
	
	/**
	 * insère un element après le dernier noeud (fin)
	 * @param element
	 */
	public void insererApresFin(Object element) {
		
		if(nbElements == 0) {
			
			initListe(element);
			
		}else {
			
			pc = fin;
			fin.suivant = new Noeud(element, null);
			fin = fin.suivant;
			pc = fin;
			
		}
		
		nbElements++;
		
	}
	
	/*
	 * MUTATEURs
	 */
	
	/**
	 * Remet Position courante a debut
	 */
	public void setPcDebut() {
		pc = debut;
	}
	
	/**
	 * Place position courante au Noeud suivant
	 */
	public void setPcSuivant() {
		
		//Déplace position courante seulement si le prochain
		// Noeud est existant
		if(pc != null && pc.suivant != null) {
			
			pc = pc.suivant;
			
		}
		
	}
	
	/**
	 * Position courante devient le Noeud précédent
	 */
	public void setPcPrecedent() {
		
		pc = noeudPrecedent();
		
	}
	
	/*
	 * ACCESSEURS
	 */
	
	/**
	 * Retourne le Noeud à la position courante
	 * @return
	 */
	public Object getElement() {
		return pc.element;
	}
	
	public int getNbElements() {
		return nbElements;
	}
	
	public Object getDebut() {
		return debut;
	}
	
	public Object getFin() {
		return fin;
	}
	
	/**
	 * Supprime le Noeud se trouvant à la position courante
	 * @throws Exception
	 */
	public void supprimerPc() throws Exception{
		
		//liste vide
		if(nbElements == 0) {
			throw new Exception("La liste est vide");
		}
		//Un seul element
		else if (nbElements == 1) {
			
			initListe(null);
			
		}
		else if(pc == debut) {
			
			debut = debut.suivant;
			pc = debut;
		}
		else if(pc == fin) {
			
			setPcPrecedent();
			pc.suivant = null;
			fin = pc;
			
		}
		else {
		
			pc.element = pc.suivant.element;
			pc.suivant = pc.suivant.suivant;
			
			//si on détruit l'avant dernier
			if(pc == null) {
				
				fin = pc;
				
			}
		}
		
		nbElements--;
	}
	
	
	
}
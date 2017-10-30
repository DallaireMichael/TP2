import java.io.Serializable;
import java.util.Date;

/**
 * Contient une liste de plage Horaire
 * @author Michaël Dallaire
 *
 */
public class Calendrier implements Serializable{
	
	//ATTRIBUTS
	
	//Instance d'une plage horaire
	private Liste listeHoraire = new Liste();
	
	//MÉTHODES
	
	/**
	 * Ajoute un rendez vous 
	 * @param rendezVous
	 * @param date
	 */
	public boolean ajouterRendezVous(RendezVous rendezVous, Date date) {
		
		/*
		 * STRATÉGIE : commencer par le cas ou 
		 * il y a 0 plages horaires. Initialiser la liste
		 * avec une plage horaire à une date et un premier rendez vous
		 * 
		 * Ensuite vérifier le cas si la plage horaire demandé existe déjà
		 * donc faire une boucle qui vérifie tout un à un en While()
		 * 
		 * Ajouté le rendez vous à la PLage horaire à la date demandé
		 */
		
		if(date.getHours() < Constantes.HEURE_OUVERTURE ||
				date.getHours() > Constantes.HEURE_FERMETURE
				|| (date.getMinutes() != Constantes.MINUTES_INTERVALLE[0] && 
					date.getMinutes() != Constantes.MINUTES_INTERVALLE[1] &&
					date.getMinutes() != Constantes.MINUTES_INTERVALLE[2] &&
					date.getMinutes() != Constantes.MINUTES_INTERVALLE[3])) {
			
			return false;
			
		}
		
		listeHoraire.getNbElements();
		
		//On s'assure que la position courante est au début
		//pour boucler à travers
		if(listeHoraire.getNbElements() != 0) {
			listeHoraire.setPcDebut();	
		}

		//Si la liste est vide on instancie une premiere PlageHoraire
		if(listeHoraire.getNbElements() == 0 ) {
			
			insereNouvellePlageHoraire(rendezVous, date);
			return true;
			
		}
		
		Object plage = trouvePlageHoraireExistante(date);
		
		//Lorsque la différence des deux dates est = à 0
		//On ajoute un rendez-vous dans la liste à la même date
		
		System.out.println(plage);
		
		if(plage != null) {
			
			((PlageHoraire) listeHoraire.getElement()).addRendezVous(rendezVous);
			
		}
		//executé lorsque on est rendu à la fin de la liste et que 
		//ce n'est toujours pas la même date
		else {
			
			insereNouvellePlageHoraire(rendezVous, date);
	
		}
		
		return true;
	}
	
	/**
	 * Trouve une plage Horaire existante
	 * @param plage
	 * @param rendezVous
	 */
	private Object trouvePlageHoraireExistante(Date date) {
		
		//Compteur d'éléments passé
		int i = 1;
				
		//Vérifie que l'element present a la même date sinon on passe à un autre élément
		//Jusqu'à qu'on aie passé tous les éléments
		while(	i < listeHoraire.getNbElements() &&
			((PlageHoraire) listeHoraire.getElement()).getDate().compareTo(date) != 0) {
					
			//Élément suivant
			listeHoraire.setPcSuivant();
			
			i++;
					
		}
		
		//la boucle s'est arrêté au dernier element,
		//Donc on s'assure que le dernier element est la même date ou non
		if(((PlageHoraire) listeHoraire.getElement()).getDate().compareTo(date) == 0) {
			
			return listeHoraire.getElement();
			
		}
		
		return null;
	}
	
	/**
	 * Insere une nouvelle plage horaire lorsqu'il n'y
	 * pas une plage horaire avec la même date.
	 * @param rendezVous
	 * @param date
	 */
	private void insereNouvellePlageHoraire(RendezVous rendezVous, Date date) {
		
		PlageHoraire plage = new PlageHoraire(date.getYear(),date.getMonth(),date.getDay(),
				date.getHours(),date.getMinutes());
		
		plage.addRendezVous(rendezVous);
		listeHoraire.inserer(plage);
		
	}
	
	
	public String toString() {
		
		listeHoraire.setPcDebut();
		
		String information = "";
		
		//Indice d'un element
		int i = 1;
		
		//passe en revue tous les éléments de la liste
		while(i <= listeHoraire.getNbElements()) {
			
			information += listeHoraire.getElement().toString() + " \n";
			
			//On change la position courante jusqu'au dernier
			if(i != listeHoraire.getNbElements()) {
				
				listeHoraire.setPcSuivant();
				
			}
			
		}
		
		return information;
		
	}
}
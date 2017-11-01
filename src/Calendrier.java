import java.io.Serializable;
import java.util.Date;

/**
 * Contient une liste de plage Horaire
 * @author Micha�l Dallaire
 *
 */
public class Calendrier implements Serializable{
	
	//ATTRIBUTS
	
	//Instance d'une plage horaire
	private Liste listeHoraire = new Liste();
	
	//M�THODES
	
	/**
	 * Ajoute un rendez vous 
	 * @param rendezVous
	 * @param date
	 */
	public boolean ajouterRendezVous(RendezVous rendezVous, Date date) {
		
		/*
		 * STRAT�GIE : commencer par le cas ou 
		 * il y a 0 plages horaires. Initialiser la liste
		 * avec une plage horaire � une date et un premier rendez vous
		 * 
		 * Ensuite v�rifier le cas si la plage horaire demand� existe d�j�
		 * donc faire une boucle qui v�rifie tout un � un en While()
		 * 
		 * Ajout� le rendez vous � la PLage horaire � la date demand�
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
		
		//On s'assure que la position courante est au d�but
		//pour boucler � travers
		if(listeHoraire.getNbElements() != 0) {
			listeHoraire.setPcDebut();	
		}

		//Si la liste est vide on instancie une premiere PlageHoraire
		if(listeHoraire.getNbElements() == 0 ) {
			
			insereNouvellePlageHoraire(rendezVous, date);
			return true;
			
		}
		
		Object plage = trouvePlageHoraireExistante(date);
		
		//Lorsque la diff�rence des deux dates est = � 0
		//On ajoute un rendez-vous dans la liste � la m�me date
		
		System.out.println(plage);
		
		if(plage != null) {
			
			((PlageHoraire) listeHoraire.getElement()).addRendezVous(rendezVous);
			
		}
		//execut� lorsque on est rendu � la fin de la liste et que 
		//ce n'est toujours pas la m�me date
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
		
		//Compteur d'�l�ments pass�
		int i = 1;
				
		//V�rifie que l'element present a la m�me date sinon on passe � un autre �l�ment
		//Jusqu'� qu'on aie pass� tous les �l�ments
		while(	i < listeHoraire.getNbElements() &&
			((PlageHoraire) listeHoraire.getElement()).getDate().compareTo(date) != 0) {
					
			//�l�ment suivant
			listeHoraire.setPcSuivant();
			
			i++;
					
		}
		
		//la boucle s'est arr�t� au dernier element,
		//Donc on s'assure que le dernier element est la m�me date ou non
		if(((PlageHoraire) listeHoraire.getElement()).getDate().compareTo(date) == 0) {
			
			return listeHoraire.getElement();
			
		}
		
		return null;
	}
	
	/**
	 * Insere une nouvelle plage horaire lorsqu'il n'y
	 * pas une plage horaire avec la m�me date.
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
		
		//passe en revue tous les �l�ments de la liste
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
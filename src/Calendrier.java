import java.io.Serializable;
import java.util.ArrayList;
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
				
		//Vérifie que l'element present a la même date sinon on 
		//passe à un autre élément jusqu'à qu'on aie passé tous les éléments
		while(i < listeHoraire.getNbElements() &&
			((PlageHoraire) 
					listeHoraire.getElement()).getDate().compareTo(date) != 0) {
					
			//Élément suivant
			listeHoraire.setPcSuivant();
			
			i++;
					
		}
		
		//la boucle s'est arrêté au dernier element,
		//Donc on s'assure que le dernier element est la même date ou non
		if(((PlageHoraire) 
				listeHoraire.getElement()).getDate().compareTo(date) == 0) {
			
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
		
		PlageHoraire plage = new PlageHoraire(date.getYear(),date.getMonth()
				,date.getDay(),date.getHours(),date.getMinutes());
		
		plage.addRendezVous(rendezVous);
		listeHoraire.inserer(plage);
		
	}
	
	/**
	 * Retourne un chaine de caractère pour 
	 * tester tous les attributs
	 */
	public String toString() {
		
		listeHoraire.setPcDebut();
		
		String information = "";
		
		//Indice d'un element
		int i = 1;
		
		//passe en revue tous les éléments de la liste
		while(i <= listeHoraire.getNbElements()) {
			
			System.out.print(information);
			
			information += listeHoraire.getElement().toString() + " \n";
			
			//On change la position courante jusqu'au dernier
			if(i != listeHoraire.getNbElements()) {
				
				listeHoraire.setPcSuivant();
				
			}
			
			i++;
			
			listeHoraire.setPcSuivant();
		}
		
		return information;
		
	}
	
	/**
	 * Obtient un patient et regarde à  travers toutes les plages horaire
	 * quel est le prochain rendez-vous de de patient
	 * @param patient
	 * @return
	 */
	public RendezVous obtenirProchainRendezVousPatient(Patient patient){
		
		/*
		 * STRATÉGIE : placer la position courante au debut de la liste
		 * Parcourir la liste de plage horaire à l'aide du nombre d'éléments
		 * parcourir les rendez-vous d'une plage horaire et comparer 
		 * le patient de chaque rendez-vous au patient reçu en paramètre
		 *  
		 */
		
		listeHoraire.setPcDebut();
		
		int i = 1;
		
		//Parcours toutes les plages horaire
		while(i <= listeHoraire.getNbElements()){
			
			//Liste de rendez-vous d'une plage horaire
			ArrayList<RendezVous> listeRendezVous = 
					((PlageHoraire) listeHoraire.getElement()).getRendezVous();
			
			//Parcours tous les rendez-vous d'une plage horaire
			for(int j = 0; j < listeRendezVous.size(); j++ ){
				
				//Compare le patient d'un rendez vous au patient en paramètre
				if(patient.equals(listeRendezVous.get(j).getPatient())){
					
					return listeRendezVous.get(j);
					
				}
			}
			
			i++;
			listeHoraire.setPcSuivant();
			
		}
		
		return null;
	}
	
	/**
	 * Obtient un infirmier et regarde à  travers toutes les plages horaire
	 * quel est le prochain rendez-vous de de infirmier
	 * @param infirmier
	 * @return
	 */
	public RendezVous obtenirProchainRendezVousInfirmier(Infirmier infirmier){
		
		/*
		 * STRATÉGIE : placer la position courante au debut de la liste
		 * Parcourir la liste de plage horaire à l'aide du nombre d'éléments
		 * parcourir les rendez-vous d'une plage horaire et comparer 
		 * l'infirmier de chaque rendez-vous au infirmier reçu en paramètre
		 *  
		 */
		
		listeHoraire.setPcDebut();
		
		int i = 1;
		
		//Parcours toutes les plages horaire
		while(i <= listeHoraire.getNbElements()){
			
			//Liste de rendez-vous d'une plage horaire
			ArrayList<RendezVous> listeRendezVous = 
					((PlageHoraire) listeHoraire.getElement()).getRendezVous();
			
			//Parcours tous les rendez-vous d'une plage horaire
			for(int j = 0; j < listeRendezVous.size(); j++ ){
				
				//Compare l'infirmier d'un rendez vous au infirmier en paramètre
				if(infirmier.equals(listeRendezVous.get(j).getInfirmier())){
					
					return listeRendezVous.get(j);
					
				}
			}
			
			i++;
			listeHoraire.setPcSuivant();
			
		}
		
		return null;
	}
	
	/**
	 * Obtient un infirmier et regarde à  travers toutes les plages horaire
	 * quel est le prochain rendez-vous de de infirmier
	 * @param infirmier
	 * @return
	 */
	public RendezVous obtenirProchainRendezVousDocteur(Docteur docteur){
		
		/*
		 * STRATÉGIE : placer la position courante au debut de la liste
		 * Parcourir la liste de plage horaire à l'aide du nombre d'éléments
		 * parcourir les rendez-vous d'une plage horaire et comparer 
		 * le docteur de chaque rendez-vous au docteur reçu en paramètre
		 *  
		 */
		
		listeHoraire.setPcDebut();
		
		int i = 1;
		
		//Parcours toutes les plages horaire
		while(i <= listeHoraire.getNbElements()){
			
			//Liste de rendez-vous d'une plage horaire
			ArrayList<RendezVous> listeRendezVous = 
					((PlageHoraire) listeHoraire.getElement()).getRendezVous();
			
			//Parcours tous les rendez-vous d'une plage horaire
			for(int j = 0; j < listeRendezVous.size(); j++ ){
				
				//Compare le docteur d'un rendez vous au docteur en paramètre
				if(docteur.equals(listeRendezVous.get(j).getDocteur())){
					
					return listeRendezVous.get(j);
					
				}
			}
			
			i++;
			listeHoraire.setPcSuivant();
			
		}
		
		return null;
	}
	
	/**
	 * Retourne la première PlageHoraire de la liste et la supprime de la liste
	 * @return
	 */
	public PlageHoraire obtenirProchainePlageHoraire(){
		
		/*
		 * STRATÉGIE : On place la position courante au début
		 * On prend le premier élément et appel supprimerPc, pour 
		 * suprrimer la PlageHoraire cherchée
		 */
		
		//on s'assure que la position courante est au début
		listeHoraire.setPcDebut();
		
		//sauvegarde de la plage qui sera supprimé de la liste
		PlageHoraire plage = (PlageHoraire) listeHoraire.getElement();
		

		try {
			
			listeHoraire.supprimerPc();
			
		} catch (Exception e) {
			
			e.getMessage();
		}
		
		return plage;
		
	}
	
	
	public boolean annulerRendezVous(RendezVous ren){
		
		/*
		 * STRATÉGIE : Placer position courante au début pour passer
		 * à travers toutes les plages horaire de la liste
		 * On parcours donc la liste de plages horaire pour parcourir
		 * tous les rendez vous
		 */
		
		//on s'assure que la position courante se trouve au début
		listeHoraire.setPcDebut();
		
		//compteur d'élément de liste
		int i = 1;
		
		//parcours toutes les PlagesHoraire
		while(i <= listeHoraire.getNbElements()){
			
			//Liste de rendez-vous d'une plage horaire
			ArrayList<RendezVous> listeRendezVous = 
					((PlageHoraire) listeHoraire.getElement()).getRendezVous();
			
			//parcours les rendez-vous d'une plage Horaire
			for(int j = 0; j < listeRendezVous.size(); j++){
				
				//Compare le rendez-vous en paramètre à chacun des rendez-vous
				// de toute les plages horaire
				if(ren.equals(listeRendezVous.get(j))){
					
					listeRendezVous.remove(j);
					
					//Vérifie s'il reste aucun rendez-vous dans une plage horaire
					//éfface la Plage horaire dans ce cas
					if(listeRendezVous.size() == 0){
						
						try {
							
							listeHoraire.supprimerPc();
							
						} catch (Exception e) {
							e.getMessage();
						}	
					}
					
					return true;
					
				}	
			}
			
			i++;
			listeHoraire.setPcSuivant();
			
		}
		
		return false;
		
	}
	
}
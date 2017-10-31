import java.io.Serializable;
import java.util.ArrayList;
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
				
		//V�rifie que l'element present a la m�me date sinon on 
		//passe � un autre �l�ment jusqu'� qu'on aie pass� tous les �l�ments
		while(i < listeHoraire.getNbElements() &&
			((PlageHoraire) 
					listeHoraire.getElement()).getDate().compareTo(date) != 0) {
					
			//�l�ment suivant
			listeHoraire.setPcSuivant();
			
			i++;
					
		}
		
		//la boucle s'est arr�t� au dernier element,
		//Donc on s'assure que le dernier element est la m�me date ou non
		if(((PlageHoraire) 
				listeHoraire.getElement()).getDate().compareTo(date) == 0) {
			
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
		
		PlageHoraire plage = new PlageHoraire(date.getYear(),date.getMonth()
				,date.getDay(),date.getHours(),date.getMinutes());
		
		plage.addRendezVous(rendezVous);
		listeHoraire.inserer(plage);
		
	}
	
	/**
	 * Retourne un chaine de caract�re pour 
	 * tester tous les attributs
	 */
	public String toString() {
		
		listeHoraire.setPcDebut();
		
		String information = "";
		
		//Indice d'un element
		int i = 1;
		
		//passe en revue tous les �l�ments de la liste
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
	 * Obtient un patient et regarde �  travers toutes les plages horaire
	 * quel est le prochain rendez-vous de de patient
	 * @param patient
	 * @return
	 */
	public RendezVous obtenirProchainRendezVousPatient(Patient patient){
		
		/*
		 * STRAT�GIE : placer la position courante au debut de la liste
		 * Parcourir la liste de plage horaire � l'aide du nombre d'�l�ments
		 * parcourir les rendez-vous d'une plage horaire et comparer 
		 * le patient de chaque rendez-vous au patient re�u en param�tre
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
				
				//Compare le patient d'un rendez vous au patient en param�tre
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
	 * Obtient un infirmier et regarde �  travers toutes les plages horaire
	 * quel est le prochain rendez-vous de de infirmier
	 * @param infirmier
	 * @return
	 */
	public RendezVous obtenirProchainRendezVousInfirmier(Infirmier infirmier){
		
		/*
		 * STRAT�GIE : placer la position courante au debut de la liste
		 * Parcourir la liste de plage horaire � l'aide du nombre d'�l�ments
		 * parcourir les rendez-vous d'une plage horaire et comparer 
		 * l'infirmier de chaque rendez-vous au infirmier re�u en param�tre
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
				
				//Compare l'infirmier d'un rendez vous au infirmier en param�tre
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
	 * Obtient un infirmier et regarde �  travers toutes les plages horaire
	 * quel est le prochain rendez-vous de de infirmier
	 * @param infirmier
	 * @return
	 */
	public RendezVous obtenirProchainRendezVousDocteur(Docteur docteur){
		
		/*
		 * STRAT�GIE : placer la position courante au debut de la liste
		 * Parcourir la liste de plage horaire � l'aide du nombre d'�l�ments
		 * parcourir les rendez-vous d'une plage horaire et comparer 
		 * le docteur de chaque rendez-vous au docteur re�u en param�tre
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
				
				//Compare le docteur d'un rendez vous au docteur en param�tre
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
	 * Retourne la premi�re PlageHoraire de la liste et la supprime de la liste
	 * @return
	 */
	public PlageHoraire obtenirProchainePlageHoraire(){
		
		/*
		 * STRAT�GIE : On place la position courante au d�but
		 * On prend le premier �l�ment et appel supprimerPc, pour 
		 * suprrimer la PlageHoraire cherch�e
		 */
		
		//on s'assure que la position courante est au d�but
		listeHoraire.setPcDebut();
		
		//sauvegarde de la plage qui sera supprim� de la liste
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
		 * STRAT�GIE : Placer position courante au d�but pour passer
		 * � travers toutes les plages horaire de la liste
		 * On parcours donc la liste de plages horaire pour parcourir
		 * tous les rendez vous
		 */
		
		//on s'assure que la position courante se trouve au d�but
		listeHoraire.setPcDebut();
		
		//compteur d'�l�ment de liste
		int i = 1;
		
		//parcours toutes les PlagesHoraire
		while(i <= listeHoraire.getNbElements()){
			
			//Liste de rendez-vous d'une plage horaire
			ArrayList<RendezVous> listeRendezVous = 
					((PlageHoraire) listeHoraire.getElement()).getRendezVous();
			
			//parcours les rendez-vous d'une plage Horaire
			for(int j = 0; j < listeRendezVous.size(); j++){
				
				//Compare le rendez-vous en param�tre � chacun des rendez-vous
				// de toute les plages horaire
				if(ren.equals(listeRendezVous.get(j))){
					
					listeRendezVous.remove(j);
					
					//V�rifie s'il reste aucun rendez-vous dans une plage horaire
					//�fface la Plage horaire dans ce cas
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
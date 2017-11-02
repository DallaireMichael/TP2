import java.awt.Color;
import java.io.IOException;

public class Test{
	
	
	public static void main(String[] args) throws Exception {
		
		Calendrier cal = new Calendrier();
		
		Identification id = new Identification("Dallaire", "Michael");
		
		RendezVous ren = new RendezVous(new Patient(id,0), new Docteur(id,0), new Infirmier(id,false));
		
		PlageHoraire plage = new PlageHoraire(2017, 5, 2, 14, 15);
		
		plage.addRendezVous(ren);
		
		cal.ajouterRendezVous(ren, plage.getDate());
		
		id = new Identification("Dallaire", "Pouchon");
		
		 ren = new RendezVous(new Patient(id,0), new Docteur(id,0), new Infirmier(id,false));
		
		plage.addRendezVous(ren);
		
		cal.ajouterRendezVous(ren, plage.getDate());
		
		Patient patient = new Patient(id,0);
		
		System.out.print("\n\nCalendrier: " + cal.toString());
		
		
		Clinique clinique = new Clinique();
		
		clinique.rendezVousPatient(patient);
	
	}
	
	
}
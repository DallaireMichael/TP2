import java.awt.Color;
import java.io.IOException;

public class Test{
	
	
	public static void main(String[] args) throws Exception {
		
		Calendrier cal = new Calendrier();
		
<<<<<<< HEAD
		RendezVous ren = new RendezVous(new Patient(), new Docteur(), new Infirmier());
		
		PlageHoraire plage = new PlageHoraire(2017, 5, 2, 14, 15);
		
		cal.ajouterRendezVous(ren, plage.getDate());
		
		cal.toString();
=======
		Identification id = new Identification("Dallaire", "Michael");
		
		RendezVous ren = new RendezVous(new Patient(id,0), new Docteur(id,0), new Infirmier(id,false));
		
		PlageHoraire plage = new PlageHoraire(2017, 5, 2, 14, 15);
		
		plage.addRendezVous(ren);
		
		cal.ajouterRendezVous(ren, plage.getDate());
		
 id = new Identification("Dallaire", "Pouchon");
		
 		Docteur doc = new Docteur(id,0);
 
		 ren = new RendezVous(new Patient(id,0), doc, new Infirmier(id,false));
		
		plage.addRendezVous(ren);
		
		cal.ajouterRendezVous(ren, plage.getDate());
		
		
	
>>>>>>> afdf5b8ce88d527374013ac3b240009b0a8f07f1
	}
	
	
}
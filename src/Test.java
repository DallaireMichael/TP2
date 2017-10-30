import java.awt.Color;
import java.io.IOException;

public class Test{
	
	
	public static void main(String[] args) throws Exception {
		
		Calendrier cal = new Calendrier();
		
		RendezVous ren = new RendezVous(new Patient(), new Docteur(), new Infirmier());
		
		PlageHoraire plage = new PlageHoraire(2017, 5, 2, 14, 15);
		
		cal.ajouterRendezVous(ren, plage.getDate());
		
		cal.toString();
	}
	
	
}
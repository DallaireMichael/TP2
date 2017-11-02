import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 * Classe utilitaire pour la recuperation et la sauvegarde de la bd
 * dans le travail sur le calendrier de clinique medicale. (voir enonce tp2 A17 INF111).
 * 
 * @author Pierre Belisle
 * @version (Copyright 2017)
 * 
 * Tout le code a ete ecrit par l'auteur pour l'École de technologie superieure
 * de montreal (Éts).  Toute utilisation ou reproduction, en tout ou en partie,
 * doit mentionner l'ecole et l'auteur.
 *
 */
public class UtilitaireFichier {

	/**
	 * Tente d'ouvrir le fichier contenu dans le stream reçu.  S'il n'existe pas,
	 * la clinque est vide.
	 */
	public static Clinique obtenirClinique(FileInputStream fic){

		/*
		 * Strategie : On utilise  un FileInputStream qui permet de lire
		 * la bd d'un coup, (comme elle a ete sauvegardee).
		 */
		Clinique clinique = new Clinique();

		try {
			
			// Ouverture du tampon logique.
			ObjectInputStream tampon = null;			
			tampon = new ObjectInputStream(fic);

			clinique =  (Clinique)tampon.readObject();

			tampon.close();

		}

		// Si le fichier n'existe pas, on s'assure que tout est initialise.
		catch(FileNotFoundException e){
			e.printStackTrace();
		}

		// Problème lors de la lecture.  On arrête.
		catch (ClassNotFoundException e) {			
			JOptionPane.showMessageDialog(null, "Format de fichier invalide");
			e.printStackTrace();
		}
		

		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Format de fichier invalide");
			e.printStackTrace();
		}

		return clinique;
	}

	/**
	 * Sauvegarde la bd dans le fichier nomme par NOM_FICHIER_BD.
	 *
	 */
	public static void sauvegarderClinique(Clinique clinique, String nomFic){

		/*
		 * Strategie : On utilise  un FileOutputStream qui permet de lire
		 * la bd d'un coup.
		 */
		FileOutputStream fic;
		ObjectOutputStream tampon = null;

		try {

			//Cree le fichier 
			fic = new FileOutputStream(nomFic);

			//Ouverture du tampon d'ecriture
			tampon = new ObjectOutputStream(fic);
			tampon.writeObject(clinique);
			tampon.close();		

		} catch (FileNotFoundException e1) {

			e1.printStackTrace();

			// Une erreur de lecture, on detruit le fichier.
		} catch (IOException e) {

			// On obtient le chemin du fichier pour le detruire.
			Path path = 
					FileSystems.getDefault().getPath(nomFic);

			try {

				tampon.close();
				Files.delete(path);

			} catch (IOException e1) {

				e1.printStackTrace();
			}

			e.printStackTrace();
		}

	}
}

import java.awt.Graphics;
import javax.swing.JPanel;
import java.io.*;
import java.util.ArrayList;

/*
 * Classe Affichage héritant de JPanel, un conteneur permettant l'affichage du programme.   
 */

public class Affichage extends JPanel{
	
	/*
	 * Généré par Eclipse
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g){
		BufferedReader br = null;
		try{
			//Lecture des données du fichier stocké dans la variable br.
			br = new BufferedReader(new FileReader("DescriptionFigureGold"));
			String line;
			//Lecture ligne par ligne des données du fichier, les lignes sont stockées dans la variable 'line'
			while ((line = br.readLine()) != null){		
			// TODO extraire les entiers des lignes pour créer les points, puis les triangles et pour finir les polygones.
			}
			br.close();
		}catch(FileNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}    
}

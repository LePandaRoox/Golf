import javax.swing.JFrame;

/*
 * Classe Windows héritant de JFrame, permettant le réglage de la fenêtre et l'ajout de contenu comme des classes héritant de JPanel.
 */

public class Windows extends JFrame{

	public Windows(){
		this.setTitle("Jeux de Golf");
		this.setSize(400, 100);
		//Gère la fermeture de la fenêtre.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Ajoute le JPanel permettant l'affichage
		this.setContentPane(new Affichage());
		//Affiche la fenêtre : IMPORTANT
		this.setVisible(true);
	}
}

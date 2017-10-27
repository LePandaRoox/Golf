import java.util.Enumeration;
import java.util.Vector;


public class Polygone {
	private Vector<Point> listePoint = new Vector<Point>();
	private Vector<Triangle> listeTriangle = new Vector<Triangle>();
	private int nbSommet;
	
	public Polygone(Vector<Point> li_Point){
		//parcours de tout les points des triangles et recherche le point le plus à gauche
		Enumeration<Point> browse = li_Point.elements();
		Point pMin = li_Point.firstElement();
		Point p = null;
		while(browse.hasMoreElements()){
			p = browse.nextElement();
			if(pMin.getX() > p.getX()){
				pMin = p;			
			}
			nbSommet++;
		}
		listePoint.add(pMin);
		System.out.println(pMin);
		li_Point.remove(pMin);
		//pMin possède le point le plus à gauche, cherchons ces voisins.
		p = this.point_Proche(li_Point, pMin);
		listePoint.add(p);
		System.out.println(p);
		li_Point.remove(p);
		p = this.point_Proche(li_Point, pMin);
		listePoint.add(p);
		System.out.println(p);
		li_Point.remove(p);
		//listeTriangle.add(new Triangle())
	}
	
	
	public Point point_Proche(Vector<Point> li_Point, Point p){
		Enumeration<Point> pBrowser = li_Point.elements();
		Point pRec = null;
		Point pRes = null;
		double inter = 0.0;
		double inter2 = 0.0;
		while(pBrowser.hasMoreElements()){
			pRec = (Point) pBrowser.nextElement();
			inter = Math.abs(p.getX() - pRec.getX()) + Math.abs(( p.getY() - pRec.getY() ));
			if(inter <= inter2){
				pRes = pRec;
			}
			inter2 = inter;
		}
		return pRes;
	}
}

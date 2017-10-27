import java.lang.Math;
import java.util.Enumeration;
import java.util.Vector;

public class Point {
	
	public static final double eps = 1e-10;
	
	private double x,y;
	
	// Constructeurs
	public Point(){
		x = 0.0;
		y = 0.0;
	}
	
	public Point(double px, double py) {
		x = px;
		y = py;
	}
	
	// Accesseurs
	public double getX()
	{ return x; }
	
	public double getY()
	{ return y;}
	
	/**
	 * Déplacement d'un point.
	 * @param ax Double, valeur du déplacement sur l'axe des abcisses.
	 * @param ay Double, valeur du déplacement sur l'axe des ordonnées.
	 */
	public void deplacement(double ax, double ay) { 
		x += ax;
		y += ay;
	}
	
	/**
	 * Redéfinition de la méthode "equals"
	 * @param point Point à comparer avec l'objet utilisé
	 * @return  vrai si les coordonnées x et y sont identiques, 
	 * 			faux sinon
	 */
	public boolean equals(Point point) {
		return (x == point.getX() && y == point.getY());
	}
	
	/**
	 * Redéfinition de la méthode toString()
	 */
	public String toString() {
		return "(" + x + ";" + y + ") ";
	}
	
	/**
	 * Méthode donnant le demi-plan du point par rapport à la droite d.
	 * <p>
	 * @param d Droite avec laquelle on compare la position du point.
	 * @return  0 si le point appartient à la droite
	 * 			<br/>1 si le point est dans le demi-plan supérieur
	 * 			<br/>-1 si le point est dans le demi-plan inférieur
	 */

	public int demiPlan(Droite d) {
		if (Math.abs(d.getA()*x + d.getB()*y + d.getC()) <= eps)		
			return 0;
		else
		{
			double res = d.getA()*getX() + d.getB()*getY() + d.getC();
			if (res < 0)
				return 1;
			else
				return -1;
		}
	}
	

	/**
	 * Méthode testant l'intersection de deux segments créée 
	 * par deux points chacun. 
	 * <p>Complexité : 0(1).
	 * @param a Premier point du segment 1
	 * @param b Second point du segment 1
	 * @param c Premier point du segment 2
	 * @param d Second point du segment 2
	 * @return  Vrai si les deux segments s'intersectent, faux sinon
	 */

	public static boolean intersectionSegment(Point a, Point b, Point c, Point d) {
		//Comparaison des boites de dimensionnement des segment [AB] et [CD]
		if (!(Math.max(a.getX(), b.getX()) >= Math.min(c.getX(), d.getX()) &&
			Math.max(c.getX(), d.getX()) >= Math.min(a.getX(), b.getX()) &&
			Math.max(a.getY(), b.getY()) >= Math.min(c.getY(), d.getY()) &&
			Math.max(c.getY(), d.getY()) >= Math.min(a.getY(), b.getY())))
			return false;
		
		double z1,z2,z3,z4;
		int s1,s2,s3,s4;
		
		// Test si les segments se chevauchent
		//Direction du point c par rapport � b relativement � a
		z1 = (c.getX() - a.getX()) * (b.getY() - a.getY()) -
			 (c.getY() - a.getY()) * (b.getX() - a.getX());
		
		//Direction du point d par rapport � b relativement � a
		z2 = (d.getX() - a.getX()) * (b.getY() - a.getY()) -
			 (d.getY() - a.getY()) * (b.getX() - a.getX());
		
		//Direction du point a par rapport � d relativement � c
		z3 = (a.getX() - c.getX()) * (d.getY() - c.getY()) -
			 (a.getY() - c.getY()) * (d.getX() - c.getX());
		
		//Direction du point b par rapport � d relativement � c
		z4 = (b.getX() - c.getX()) * (d.getY() - c.getY()) -
			 (b.getY() - c.getY()) * (d.getX() - c.getX());
		
		//Valeur lié au sens horaire
		if (z1 < 0)
			s1 = -1;
		else if (z1 > 0)
			s1 = 1;
		else
			s1 = 0;
		
		if (z2 < 0)
			s2 = -1;
		else if (z2 > 0)
			s2 = 1;
		else
			s2 = 0;
		
		if (z3 < 0)
			s3 = -1;
		else if (z3 > 0)
			s3 = 1;
		else
			s3 = 0;
		
		if (z4 < 0)
			s4 = -1;
		else if (z4 > 0)
			s4 = 1;
		else 
			s4 = 0;
		
		//Vrai si les segments se croisent
		return ((s1 * s2 <= 0) && (s3 * s4 <= 0));
	}

	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof Point))
			return false;
		Point p = (Point) o;
		return this.getX() == p.getX() && this.getY() == p.getY();
	}

}

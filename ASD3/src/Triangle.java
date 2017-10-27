import java.util.Enumeration;
import java.util.Vector;

public class Triangle 
{
	Point a,b,c;
	
	/**
	 * Crée un triangle en donnant ses trois sommets
	 * @param p1 Point, premier sommet du triangle
	 * @param p2 Point, deuxième sommet du triangle
	 * @param p3 Point, troisième sommet du triangle
	 */
	public Triangle(Point p1, Point p2, Point p3)
	{
		a = p1;
		b = p2;
		c = p3;
	}
	
	public Triangle(Vector<Point> lsPoint)
	{
	}
	
	/**
	 * <p>Complexité : O(1)
	 * @param p Le point dont on test l'appartenance au triangle
	 * @return Vrai si le point est dans le triangle ou appartient à 
	 * un de ses côté, faux sinon
	 */
	public boolean contient(Point p)
	{
		Droite d1 = new Droite(a,b);
		Droite d2 = new Droite(a,c);
		Droite d3 = new Droite(b,c);
		
		if ((p.demiPlan(d3) == a.demiPlan(d3) || p.demiPlan(d3) == 0) &&
			(p.demiPlan(d2) == b.demiPlan(d3) || p.demiPlan(d3) == 0) &&
			(p.demiPlan(d1) == c.demiPlan(d3) || p.demiPlan(d3) == 0))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}

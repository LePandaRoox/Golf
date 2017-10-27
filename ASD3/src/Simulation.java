import java.util.Vector;


public class Simulation {
	public static void main(String args[]) {
		
		//Creation de point
		Point a = new Point(1.0,2.0);
		Point b = new Point(4.0,4.0);
		Point c = new Point(2.0,3.0);
		
		//Creation de droite
		Droite d = new Droite(a,b);
		Droite d1 = new Droite(new Point(0,1),new Point(3,3));
		Droite d2 = new Droite(c, b);
		
		/*
		//Test affichage droites
		System.out.println("D   : " +d.toString());
		System.out.println("D1  : " +d1.toString());
		System.out.println("D2  : " +d2.toString());
		*/
		//Test intersection
		//System.out.println("D intersection d1 ? " + d.intersection(d1));
		//System.out.println("D intersection d2 ? " + d.intersection(d2));
		
		//Test point intersection
		//System.out.println(d.pointIntersection(d2));
		
		//Test d'appartenance à un triangle
		Point p1 = new Point(1,0);
		Point p2 = new Point(3,3);
		Point p3 = new Point(6,0);
		
		Point pt0 = new Point(Double.MAX_VALUE,0);
		//System.out.println(pt0);
		Point pt1 = new Point(0.9999999999,0);
		Point pt2 = new Point(8,0);
		Point pt3 = new Point(3,1);
		Triangle t = new Triangle(p1,p2,p3);
		/*System.out.println("t contient le point : " + p1 + " = " + t.contient(p1));
		System.out.println("t contient le point : " + pt1 + " = " + t.contient(pt1));
		System.out.println("t contient le point : " + pt2 + " = " + t.contient(pt2));
		System.out.println("t contient le point : " + pt3 + " = " + t.contient(pt3));
		System.out.println("t contient le point : " +  pt0 + " = " + t.contient(pt0));*/
		
		Vector<Point> lo = new Vector();
		lo.add(new Point(5,60));
		lo.add(new Point(3,3));
		lo.add(new Point(2,2));
		lo.add(new Point(12,3));
		lo.add(new Point(2,12));
		Polygone p = new Polygone(lo);
		Windows test = new Windows();
		
	}
}

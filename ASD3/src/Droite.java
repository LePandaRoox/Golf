
public class Droite {

	private double a,b,c;
	
	//Constructeurs
	public Droite() {
		a = 0;
		b = 0;
		c = 0;
	}
	
	//O(1)
	public Droite(double na, double nb, double nc) {
		a = na;
		b = nb;
		c = nc;
	}
	
	//O(1)
	public Droite (Point p1, Point p2) {		
		a = -(p2.getY() - p1.getY());
		b = p2.getX() - p1.getX();
		c = -((a*p1.getX()+b*p1.getY()));
	}
	
	//Constructeur de copie
	public Droite (Droite d) {
		a = d.getA();
		b = d.getB();
		c = d.getC();
	}
	
	//Accesseurs
	
	public double getA()
	{ return a; }
	
	public double getB()
	{ return b; }
	
	public double getC()
	{ return c; }
	
	//M�thodes
	//O(1)
	public String toString() {
		return a +"x + " + b + "y + " + c + " = 0 ";
	}
	
	//O(1)
	public boolean confondu(Droite d) {
		return d.getA()/getA() == d.getB()/getB() &&
			   d.getA()/getA() == d.getC()/getC();
	}
	
	//O(1)
	public boolean intersection(Droite d) {	
		if (confondu(d))
			return false;
		if (getA()/d.getA() == getB()/d.getB() && getA()/d.getA() != getC()/d.getC())
			return false;
		return true;
	} 
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof Droite))
			return false;
		Droite d = (Droite) o;
		return getA() == d.getA() &&
			   getB() == d.getB() &&
			   getC() == d.getC();
	}
	
	/**
	 * Calcule le point d'intersection entre deux droites
	 * @pre La droite d doit être en intersection avec l'objet
	 * @param d Droite avec laquelle on cherche un point d'intersection
	 * @return Le point d'intersection
	 */
	public Point pointIntersection(Droite d) {
		if (!intersection(d)){
			throw new IllegalArgumentException("Les droites " + this + " et " + d + 
					"doivent s'intersecter");
		} 
		double l1 = getA();
		double l2 = d.getA();

		//Système d'équations
		double d1[] = {l2*getA(), l2*getB(), l2*getC()};
		double d2[] = {l1*d.getA(),l1*d.getB(),l1*d.getC()};
		
		//L2 <- L2 - L1
		d2[0] -= d1[0];
		d2[1] -= d1[1];
		d2[2] -= d1[2];

		d2[1] = -d2[2]/d2[1];
		d1[0] = (-d1[1]*d2[1] - d1[2])/d1[0];
		
		return new Point(d1[0],d2[1]);
	}
	
}

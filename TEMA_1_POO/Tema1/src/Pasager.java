/** @author Chirila Albert */
public class Pasager {
	/** Valoare int ce reprezinta prioritatea unui pasager */
	private int total_points;
	/** Pasagerul(familie/grup/singur) este reprezentat printr-un vector de persoane */
	private Persoana[] v;
	/** Valoare int ce reprezinta capacitatea vectorului */
	private int capacity;
	
	/** Constructor default */
	public Pasager() {
		
	}
	
	/** Seteaza vectorul de persoane 
	 * @param v vector de persoane */
	public void setVector(Persoana[] v) {
		this.v = v;
	}
	
	/** Returneaza vectorul de persoane
	 * @return vectorul de persoane */
	public Persoana[] getVector() {
		return this.v;
	}
	
	/** Seteaza prioritatea unui pasager 
	 * @param x prioritatea unui pasager */
	public void setTotal_Points(int x) {
		this.total_points = x;
	}
	
	/** Returneaza prioritatea pasagerului
	 * @return prioritatea pasagerului */
	public int getTotal_Points() {
		return this.total_points;
	}
	
	/** Seteaza capacitatea vectorului 
	 * @param value capacitatea vectorului */
	public void setCapacity(int value) {
		this.capacity = value;
	}
	
	/** Returneaza capacitatea vectorului
	 * @return capacitatea vectorului */
	public int getCapacity() {
		return this.capacity;
	}
	
}

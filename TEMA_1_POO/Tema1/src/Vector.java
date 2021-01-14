/** @author Chirila Albert */
public class Vector {
	private Persoana[] v;
	private int capacity;
	
	/** Constructor de intializeaza campurile clasei 
	 * @param value dimensiunea maxima a vectorului */
	public Vector(int value) {
		this.capacity = value + 1;
		this.v = new Persoana[this.capacity];
	}
	
	/**
	 * Insereaza o persoana in vectorul v
	 * @param p o persoana
	 */
	public void inserare(Persoana p) {
		int i=0;
		if(this.v[0] == null) {
			this.v[i] = p;
			return;
		}
		for(i=0; i<this.capacity; i++) {
			if(this.v[i] == null) {
				this.v[i] = p;
				return;
			}
		}
	}
	
	/** Seteaza vectorul de persoane
	 * @param v vectorul de persoane */
	public void setVector(Persoana[] v) {
		this.v = v;
	}
	
	/** Returneaza vectorul de persoane */
	public Persoana[] getVector(){
		return this.v;
	}
	
	/** Seteaza capacitatea vectorului
	 * @param value noua capacitate a vectorului */
	public void setCapacity(int value) {
		this.capacity = value;
	}
	
	/** Returneaza capacitatea vectorului */
	public int getCapacity() {
		return this.capacity;
	}
	
}

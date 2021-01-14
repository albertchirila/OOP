/** @author Chirila Albert */
public class Singur extends Pasager {
	private Persoana[] s;
	private int points;
	private int capacity;
	
	/** Constructor ce initializeaza campurile clasei
	 * @param value dimensiunea maxima a vectorului */
	public Singur(int value) {
		this.capacity = value + 1;
		this.s = new Persoana[this.capacity];
	}
	
	/**
	 * Calculeaza prioritatea unei persoane singure
	 * @param id ID-ul unei persoane
	 * @return punctele unei persoane
	 */
	public int suma(String id) {
		int i, suma = 0;
		for(i=0; i<this.capacity; i++) {
			if(this.s[i].getID().equals(id)) {
				suma += s[i].sum();
			}
		}
		this.points = suma;
		super.setTotal_Points(this.points);
		return this.points;
	}
	
	/**
	 * Construieste vectorul de persoane(vectorul va avea un singur element)
	 * @param v vectorul de persoane
	 * @param id ID-ul unei persoane
	 */
	public void contruieste(Persoana[] v , String id) {
		int i=0, j=0;
		for(i=0; i<this.capacity-1; i++) {
			if(v[i].getID().equals(id)) {
				this.s[j] = v[i];
				j++;
			}
		}
		sterge();
		super.setVector(this.s);
	}
	
	/** Metoda sterge elementele ramase nule in vectorul de persoane */
	public void sterge() {
		int i;
		for(i=0; i<this.capacity; i++) {
			if(this.s[i] == null) {
				this.capacity = i;
				super.setCapacity(this.capacity);
				return;
			}
		}
	}
	
}

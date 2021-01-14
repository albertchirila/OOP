/** @author Chirila Albert */
public class Grup extends Pasager {
	private Persoana[] grup;
	private int points;
	private int capacity;
	
	/** Constructor ce initializeaza campurile clasei
	 * @param value dimensiunea maxima a vectorului */
	public Grup(int value) {
		this.capacity = value + 1;
		this.grup = new Persoana[this.capacity];
	}
	
	/**
	 * Calculeaza prioritatea unui grup
	 * @param id ID-ul unei persoane
	 * @return punctele unui grup
	 */
	public int suma(String id) {
		int i, suma = 5;
		for(i=0; i<this.capacity; i++) {
			if(this.grup[i].getID().equals(id)) {
				suma += grup[i].sum();
			}
		}
		this.points = suma;
		super.setTotal_Points(this.points);
		return this.points;
	}
	
	/**
	 * Construieste vectorul de persoane care apartin aceluias grup
	 * @param v vectorul de persoane
	 * @param id ID-ul unei persoane
	 */
	public void contruieste(Persoana[] v , String id) {
		int i=0, j=0;
		for(i=0; i<this.capacity-1; i++) {
			if(v[i].getID().equals(id)) {
				this.grup[j] = v[i];
				j++;
			}
		}
		sterge();
		super.setVector(this.grup);
	}
	
	/** Metoda sterge elementele ramase nule in vectorul de persoane */
	public void sterge() {
		int i;
		for(i=0; i<this.capacity; i++) {
			if(this.grup[i] == null) {
				this.capacity = i;
				super.setCapacity(this.capacity);
				return;
			}
		}
	}
	
}

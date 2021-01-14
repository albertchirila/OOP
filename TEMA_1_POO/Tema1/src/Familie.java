/** @author Chirila Albert */
public class Familie extends Pasager{
	private Persoana[] fam;
	private int points;
	private int capacity;
	
	/** Constructor ce initializeaza campurile clasei
	 * @param value dimensiunea maxima a vectorului */
	public Familie(int value) {
		this.capacity = value + 1;
		this.fam = new Persoana[this.capacity]; 
	}
	
	/**
	 * Calculeaza prioritatea unei familii
	 * @param id ID-ul unei persoane
	 * @return punctele unei familii
	 */
	public int suma(String id) {
		int i, suma = 10;
		for(i=0; i<this.capacity; i++) {
			if(this.fam[i].getID().equals(id)) {
				suma += fam[i].sum();
			}
		}
		this.points = suma;
		super.setTotal_Points(this.points);
		return this.points;
	}
	
	/**
	 * Construieste vectorul de persoane care apartin aceleasi familii
	 * @param v vectorul de persoane
	 * @param id ID-ul unei persoane
	 */
	public void contruieste(Persoana[] v , String id) {
		int i=0, j=0;
		for(i=0; i<this.capacity-1; i++) {
			if(v[i].getID().equals(id)) {
				this.fam[j] = v[i];
				j++;
			}
		}
		sterge();
		super.setVector(this.fam);
	}
	
	/** Metoda sterge elementele ramase nule in vectorul de persoane */
	public void sterge() {
		int i;
		for(i=0; i<this.capacity; i++) {
			if(this.fam[i] == null) {
				this.capacity = i;
				super.setCapacity(this.capacity);
				return;
			}
		}
	}
	
}

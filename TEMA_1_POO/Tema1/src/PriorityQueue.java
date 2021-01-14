/** @author Chirila Albert */
import java.io.*;

public class PriorityQueue extends WriteFile{
	private Pasager[] theQueue;
	private int capacity;
	private int pos;
	private int idx;
	private int contor;
	private String name; //setez numele pt delete
	
	/** Constructor default */
	public PriorityQueue() {
		
	}
	
	/**
	 * Initializeaza campurile clasei
	 * @param value reprezinta numarul de pasageri
	 */
	public PriorityQueue(int value) {
		this.pos=1;
		this.capacity = value + 1;
		theQueue = new Pasager[capacity];
		this.idx = 1;
		this.contor = 1; 
	}
	
	/** Metoda sterge elementele nule */
	public void sterge() {
		int i;
		for(i=1; i<this.capacity; i++) {
			if(this.theQueue[i] == null) {
				this.capacity = i;
				return;
			}
		}
	}
	
	/**
	 * Metoda reordoneaza elementele in coada in functie de prioritate
	 * @param theQueue coada de prioritate
	 * @param idx index
	 */
	public void max_heapify(Pasager[] theQueue, int idx) {
		
		int left = 2*idx;
		int right = 2*idx + 1;
		int largest;
		
		if(left < this.capacity && (theQueue[left].getTotal_Points() > theQueue[idx].getTotal_Points()))
			largest = left;
		else
			largest = idx;
		
		if(right < this.capacity && theQueue[right].getTotal_Points() > theQueue[largest].getTotal_Points())
			largest = right;
		if(largest != idx) {
			Pasager tmp = theQueue[idx];
			theQueue[idx] = theQueue[largest];
			theQueue[largest] = tmp;
			max_heapify(theQueue, largest);
		}
	}
	
	/**
	 * Metoda insereaza pasagerul p in coada de prioritate
	 * @param p familie/grup/singur
	 * @param value prioritatea
	 */
	public void insert(Pasager p, int value) {
		if(pos == capacity) {
			this.capacity++;
		}
			theQueue[pos++] = p;
			int child = pos - 1;
			int parent = child / 2;
				while(theQueue[parent] != null && (theQueue[parent].getTotal_Points() < theQueue[child].getTotal_Points()) && parent > 0) {
				Pasager tmp = theQueue[parent];
				theQueue[parent] = theQueue[child];
				theQueue[child] = tmp;
				
				child = parent;
				parent = child / 2;
	}
}
	
	/**
	 * Metoda imbarca root-ul heap-ului
	 * @return root-ul heap-ului
	 */
	public int embark() {
		if(this.capacity == 0) {
			return -1;
		}
		int max = theQueue[1].getTotal_Points();
		theQueue[1] = theQueue[this.capacity-1];
		theQueue[this.capacity - 1] = null;
		this.capacity--;
		this.pos--;
		max_heapify(this.theQueue, 1);
		
		return max;
	}
	
	/** Metoda afiseaza ID-ul fiecarui pasager din heap in preordine - RSD */
	public void list(){
			if(this.contor < this.capacity - 1) {
				try {
					super.write(this.theQueue[idx].getVector()[0].getID() + " ");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else
			{
				try {
					super.write(this.theQueue[idx].getVector()[0].getID()+ "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		this.contor++;
		if(2*idx < this.capacity) {
			this.idx = 2*this.idx;
			list();
			this.idx = this.idx/2;
		}
		if(2*idx+1 < this.capacity) {	
			this.idx = 2*this.idx + 1;
			list();
			this.idx = (this.idx -1)/2;
		}
	}
	
	// Functiile pentru bonus
	
	/**
	 * Metoda cauta in heap pasagerul cu ID-ul dat ca parametru
	 * @param id ID-ul unui pasager
	 * @return pasagerul cu ID-ul dat ca parametru
	 */
	public Pasager cauta(String id) {
		int i;
		for(i=1; i<this.capacity; i++) {
			if(this.theQueue[i].getVector()[0].getID().equals(id)) {
				return this.theQueue[i];
			}				
		}
		return null;
	}
	
	/**
	 * Metoda sterge din coada pasagerul(familie/grup/singur) sau o singura persoana
	 * @param p pasager
	 */
	public void delete(Pasager p) {
		int i, j=0;
		sterge();
		for(i=1; i<this.capacity; i++) {
			if(this.theQueue[i] == p) {
				if(this.name == null) {
					this.theQueue[i] = this.theQueue[this.capacity - 1];
					theQueue[this.capacity - 1] = null;
					this.capacity--;
					this.pos--;
					max_heapify(this.theQueue, 2);
				}
				else {
					Vector v = new Vector(this.theQueue[i].getCapacity() - 1);
					v.setVector(this.theQueue[i].getVector());
					while(v.getVector()[j] != null) {
						if(v.getVector()[j].getName().equals(this.name)) {
							int value = v.getVector()[j].getTotal_Points();
							elimina(v.getVector()[j], i);
							this.theQueue[i].setTotal_Points(this.theQueue[i].getTotal_Points() - value);
							max_heapify(this.theQueue, i);
						}
						j++;
					}
				}
			}
		}
	}
	
	/**
	 * Metoda elimina din vectorul v persoana care are acelasi nume cu campul "name"
	 * @param v vector
	 * @param p persoana
	 */
	public void elimina(Persoana p, int i) {
		int j, k=0;
		for(j=0; j<this.theQueue[i].getCapacity(); j++) {
			if(this.theQueue[i].getVector()[j].getName().equals(p.getName())){
				this.theQueue[i].setCapacity(this.theQueue[i].getCapacity() - 1);
				for(j=k;j<this.theQueue[i].getCapacity();j++) {
					this.theQueue[i].getVector()[j] = this.theQueue[i].getVector()[j+1];
				}
				this.theQueue[i].getVector()[j] = null;
				sterge();
			}
			k++;
		}
	}
	
	
	/** Seteaza campul "name" 
	 * @param name noul nume */
	public void setName(String name) {
		this.name = name;
	}
	
	/** Returneaza numele */
	public String getName() {
		return this.name;
	}
	
	/** Seteaza contorul care ajuta la afisare
	 * @param value valoarea noului contor */
	public void setContor(int value) {
		this.contor = value;
	}

}

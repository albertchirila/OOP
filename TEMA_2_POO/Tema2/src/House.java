import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/** @author Chirila Albert */
public class House {
	private List<Room> list;
	private double temp;
	WriteFile write = new WriteFile();
	private double humidity;
	
	/** Constructor ce initializeaza lista de camere */
	public House() {
		this.list = new ArrayList<Room>();
	}
	
	/**
	 * Metoda va insera temperatura corespunzatoare senzorului in functie de timpul dat ca parametru
	 * @param device_id id-ul senzorului
	 * @param time timpul 
	 * @param temp temperatura ce va fi inserata
	 */
	public void observe(String device_id, int time, double temp) {
		for(int i=0; i<this.list.size(); i++) {
			Device d = this.list.get(i).getDevice();
			if(d.getDevice_id().equals(device_id)) {
				for(int j=0; j<d.getList().size(); j++) {
					Interval interval = d.getList().get(j);
					if((time >= interval.getStart()) && (time <= interval.getStop())) {
						if(search(interval.getList(), temp) == 0)
							interval.getList().add(temp);
						interval.getList().sort(null);
						break;
					}
				}
			}
		}
	}
	
	/**
	 * Metoda va insera umiditatea corespunzatoare senzorului in functie de timpul dat ca parametru
	 * @param device_id id-ul senzorului
	 * @param time timpul 
	 * @param humidity umiditatea ce va fi inserata
	 */
	public void observeh(String device_id, int time, double humidity) {
		for(int i=0; i<this.list.size(); i++) {
			Device d = this.list.get(i).getDevice();
			if(d.getDevice_id().equals(device_id)) {
				for(int j=0; j<d.getList().size(); j++) {
					Interval interval = d.getList().get(j);
					if((time >= interval.getStart()) && (time <= interval.getStop())) {
						if(search(interval.getListH(), humidity) == 0)
							interval.getListH().add(humidity);
						interval.getListH().sort(null);
						break;
					}
				}
			}
		}
	}
	
	/**
	 * Metoda calculeaza temperatura/umiditatea medie a casei si decide daca centrala trebuie pornita
	 */
	public void trigger_heat(int bonus) {
		
		if(bonus == 0) {
			Vector<Double> tp = new Vector<Double>(); //vector de temperaturi
			Vector<Integer> area = new Vector<Integer>(); //vector de suprafete
			
			for(int i=0; i<this.list.size(); i++) {
				Device d = this.list.get(i).getDevice();
				area.add(this.list.get(i).getArea());
				for(int j=d.getList().size()-1 ; j>=0; j--) {
					Interval interval = d.getList().get(j);
					if(interval.getList().size() != 0) {
						tp.add(interval.getList().get(0));
						break;
					}
				}
			}
			
			double average = average(tp, area);
			if(average < this.temp) {
				try {
					write.write("YES\n");
				} catch (IOException e) {
					System.out.println("COULD NOT WRITE");
				}
			}
			else {
				try {
					write.write("NO\n");
				} catch (IOException e) {
					System.out.println("COULD NOT WRITE");
				}
			}
		}
		else {
			Vector<Double> h = new Vector<Double>(); //vector de umiditati
			Vector<Integer> area = new Vector<Integer>(); //vector de suprafete
			
			for(int i=0; i<this.list.size(); i++) {
				Device d = this.list.get(i).getDevice();
				area.add(this.list.get(i).getArea());
				for(int j=d.getList().size()-1 ; j>=0; j--) {
					Interval interval = d.getList().get(j);
					if(interval.getListH().size() != 0) {
						h.add(interval.getListH().get(interval.getListH().size() - 1));
						break;
					}
				}
			}
			
			double average = average(h, area);
			if(average < this.humidity) {
				try {
					write.write("YES\n");
				} catch (IOException e) {
					System.out.println("COULD NOT WRITE");
				}
			}
			else {
				try {
					write.write("NO\n");
				} catch (IOException e) {
					System.out.println("COULD NOT WRITE");
				}
			}
		}
		
	}
	
	/**
	 * Metoda calculeaza temperatura media a casei
	 * @param v1 vector ce contine temperaturile minime din ultima ora a fiecarei camere
	 * @param v2 vector ce contine suprafetele fiecarei camere
	 * @return temperatura medie
	 */
	public double average(Vector<Double> v1, Vector<Integer> v2) {
		double up=0;
		int down=0;
		for(int i=0; i<v1.size(); i++) {
			up += v1.get(i) * v2.get(i);
			down += v2.get(i);
		}
		return up/down;
	}
	
	/**
	 * Metoda listeaza temperaturile inregistrate intre cele doua momente de timp
	 * @param name camera
	 * @param start momentul pornirii
	 * @param stop momentul opririi
	 * @throws IOException exceptie-daca nu se poate scrie in fisier
	 */
	public void list(String name, int start, int stop) throws IOException {
		write.write(name);
		int i1=0, i2=0;
		for(int i=0; i<this.list.size(); i++) {
			if(this.list.get(i).getName().equals(name)) {
				Device d = this.list.get(i).getDevice();
				for(int j=0; j<d.getList().size(); j++) {
					Interval interval = d.getList().get(j);
					if((start >= interval.getStart()) && (start <= interval.getStop()))
							i1 = j;
					if((stop >= interval.getStart()) && (stop <= interval.getStop()))
							i2=j;
				}
			}
		}
		list_aux(i1, i2, start, stop, name);	
	}
	
	/**
	 * Metoda ajutatoare ce listeaza temperaturile cautate
	 * @param a interalul de start
	 * @param b intervalul de oprire
	 * @param start momentul pornirii
	 * @param stop momentul opririi
	 * @param name camera
	 * @throws IOException exceptie-daca nu se poate scrie in fisier
	 */
	public void list_aux(int a, int b, int start, int stop, String name) throws IOException {
		for(int i=0; i<this.list.size(); i++) {
			if(this.list.get(i).getName().equals(name)) {
				Interval begin = this.list.get(i).getDevice().getList().get(a);
				Interval finish = this.list.get(i).getDevice().getList().get(b);
				
				if(begin == finish) {
					if((start == begin.getStart()) && (stop == finish.getStop())) {
						list(finish);
						return;
					}
					return;
				}
				if(stop == finish.getStop()) {
					while(finish.getStart() != begin.getStart()) {
						if(finish.getStart()-1 == begin.getStop()) { //alaturate
							if(begin.getStart() == start) {
								list(finish);
								list(begin);
								break;
							}
							list(finish);
							break;
						}
						list(finish);
						b=b-1;
						finish = this.list.get(i).getDevice().getList().get(b);
					}
				}
			}
		}
		write.write("\n");
	}
	
	/**
	 * Metoda ce listeaza temperaturile dintr-un interval
	 * @param x intervalul de timp
	 * @throws IOException exceptie-daca nu se poate scrie in fisier
	 */
	public void list(Interval x) throws IOException {
		for(int i=0; i<x.getList().size(); i++) {
			write.write(" " + String.format("%.2f", x.getList().get(i)));
		}
	}	
	
	/**
	 * Metoda verifica daca o valoare a temperaturii se repeta
	 * @param l lista de temeraturi dintr-un interval
	 * @param value valoare ce va fi cautata
	 * @return 1 - s-a gasit valoarea / 0 - nu s-a gasit valoarea
	 */
	public int search(List<Double> l, double value) {
		for(int i=0; i<l.size(); i++) {
			if(l.get(i) == value) 
				return 1;
		}	
		return 0;
	}
	
	/**
	 * Getter ce returneaza lista de camere
	 * @return lista de camere
	 */
	public List<Room> getList() {
		return this.list;
	}
	
	/**
	 * Setter ce seteaza noua valoare a temperaturii globale
	 * @param value valoarea noii temperaturi globale
	 */
	public void setTemp(double value) {
		this.temp = value;
	}
	
	/**
	 * Getter ce returneaza temperatura globala
	 * @return temperatura globala
	 */
	public double getTemp() {
		return this.temp;
	}
	
	/**
	 * Setter ce seteaza noua valoare a umiditatii globale
	 * @param value valoarea noii umiditati globale
	 */
	public void setH(double value) {
		this.humidity = value;
	}
	
	/**
	 * Getter ce returneaza umididatea globala
	 * @return umiditatea globala
	 */
	public double getH() {
		return this.humidity;
	}
	
}

import java.util.ArrayList;
import java.util.List;

/** @author Chirila Albert */
public class Interval{
	private int start_interval;
	private int stop_interval;
	private List<Double> list;
	private List<Double> listh;
	
	
	/** Constructor ce initializeaza lista de temperaturi
	 * si lista de umiditati */
	public Interval() {
		this.list = new ArrayList<Double>();
		this.listh = new ArrayList<Double>();
	}
	
	/**
	 * Setter ce seteaza valoarea momentului de start
	 * @param value valoare momentului de start
	 */
	public void setStart(int value) {
		this.start_interval = value;
	}
	
	/**
	 * Setter ce seteaza valoarea momentului de stop
	 * @param value valoare momentului de stop
	 */
	public void setStop(int value) {
		this.stop_interval = value;
	}
	
	/**
	 * Getter ce returneaza valoarea momentului de start
	 * @return valoarea momentului de start
	 */
	public int getStart() {
		return this.start_interval;
	}
	
	/**
	 * Getter ce returneaza valoarea momentului de stop
	 * @return valoarea momentului de stop
	 */
	public int getStop() {
		return this.stop_interval;
	}
	
	/**
	 * Getter ce returneaza lista de temperaturi dintr-un interval
	 * @return lista de temperaturi
	 */
	public List<Double> getList() {
		return this.list;
	}
	
	/**
	 * Getter ce returneaza lista de umiditati dintr-un interval
	 * @return lista de umiditati
	 */
	public List<Double> getListH() {
		return this.listh;
	}
}

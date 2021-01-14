import java.util.ArrayList;
import java.util.List;

/** @author Chirila Albert */
public class Device {
	private List<Interval> list;
	private String device_id;
	
	/**
	 * Constructorul initializeaza lista de intervale si id-ul senzorului
	 * @param value id-ul senzorului
	 * @param reference timpul de referinta
	 */
	public Device(String value, int reference) {
		this.list = new ArrayList<Interval>();
		this.device_id = value;
		make_list(reference);
	}
	
	
	/**
	 * Metoda construieste o lista de 24 de intervale de cate o ora,
	 * in functie de timpul de referinta
	 * @param reference timpul de referinta
	 */
	public void make_list(int reference) {
		for(int i = 24; i>=1; i--) {
			Interval interval = new Interval();
			interval.setStart((reference - i*3600)+1);
			interval.setStop((reference -(i-1)*3600));
			this.list.add(interval);
		}
	}
	
	/**
	 * Getter ce returneaza lista de intervale
	 * @return lista de intervale
	 */
	public List<Interval> getList(){
		return this.list;
	}
	
	/**
	 * Getter ce returneaza id-ul senzorului
	 * @return id-ul senzorului
	 */
	public String getDevice_id() {
		return this.device_id;
	}
}
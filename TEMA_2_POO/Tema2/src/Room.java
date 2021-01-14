
/** @author Chirila Albert */
public class Room {
	private String name;
	private Device device;
	private int area;
	
	/**
	 * Constructor ce intializeaza campurile clasei
	 * @param name camera
	 * @param device_id id-ul senzorului
	 * @param area suprafata camerei
	 * @param value timpul de referinta
	 */
	public Room(String name, String device_id, int area, int value) {
		this.name = name;
		this.area = area;
		Device device = new Device(device_id, value);
		this.device = device;
	}
	
	/**
	 * Getter ce returneaza camera
	 * @return camera
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Getter ce returneaza senzorul
	 * @return senzorul
	 */
	public Device getDevice() {
		return this.device;
	}
	
	/**
	 * Getter ce returneaza suprafata camerei
	 * @return suprafata camerei
	 */
	public int getArea() {
		return this.area;
	}
}
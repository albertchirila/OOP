
/** @author Chirila Albert */
public class Persoana {
	private String id;
	private String name;
	private int age;
	private int points;
	private String ticket;
	private boolean priority_embark;
	private boolean special;
	private int total_points;
	
	/** Constructor ce seteaza campurile clasei Persoana
	 * @param id ID-ul persoanei
	 * @param name numele persoanei
	 * @param age varsta persoanei
	 * @param ticket tipul de bilet
	 * @param priority_embark imbarcare prioritara
	 * @param special nevoi speciale
	 *  */
	public Persoana(String id, String name, int age, String ticket, boolean priority_embark, boolean special) {
		this.id = id;
		this.name = name;
		this.age = age;
		
		if(age < 2)
			this.points = 20;
		if(age >= 2 && age < 5)
			this.points = 10;
		if(age >= 5 && age < 10)
			this.points = 5;
		if(age >= 10 && age < 60)
			this.points = 0;
		if(age >= 60)
			this.points = 15;
		
		this.ticket = ticket;
		this.priority_embark = priority_embark;
		this.special = special;
	}
	
	/**
	 * Metoda calculeaza punctele acumulate de o persoana
	 * @return punctele unei persoane 
	 */
	public int sum() {
		int sum = 0;
		Bilet bilet = new Bilet(this.ticket);
		Beneficii benef = new Beneficii(this.priority_embark, this.special);
		sum = sum + this.points + bilet.getPoints() + benef.getPoints1() + benef.getPoints2();
		this.total_points = sum;
		
		return sum;
	}
	
	/** Returneaza ID-ul persoanei 
	 * @return ID-ul unei persoane */
	public String getID() {
		return this.id;
	}
	
	/** Returneaza numele persoanei 
	 * @return numele unei persoane */
	public String getName() {
		return this.name;
	}
	
	/** Returneaza varsta persoanei 
	 *  @return varsta unei persoane */
	public int getAge() {
		return this.age;
	}
	
	/** Returneaza punctele acumulate de o persoana  
	 * @return punctele unei persoane */
	public int getTotal_Points() {
		return this.total_points;
	}
}
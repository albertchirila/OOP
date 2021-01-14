
/** @author Chirila Albert */
public class Beneficii {
	/** Valoare int specifica imbarcarii prioritare */
	private int points1;
	/** Valoare int specifica nevoilor speciale */
	private int points2;
	
	/**
	 * Constructorul seteaza punctele corespunzatoare fiecarui tip de imbarcare
	 * @param priority_embark imbarcare prioritara
	 * @param special nevoi speciale
	 */
	public Beneficii(boolean priority_embark, boolean special) {
		if(priority_embark == true)
			this.points1 = 30;
		else
			this.points1 = 0;
		
		if(special == true)
			this.points2 = 100;
		else
			this.points2 = 0;
	}
	
	/** Returneaza punctele specifice imbarcarii prioritare
	 * @return punctele specifice imbarcarii prioritare */
	public int getPoints1() {
		return this.points1;
	}
	
	/** Returneaza punctele specifice nevoilor speciale
	 * @return punctele specifice nevoilor speciale */
	public int getPoints2() {
		return this.points2;
	}
}

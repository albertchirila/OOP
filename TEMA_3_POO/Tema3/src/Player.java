
/** @author  Chirila Albert */
public class Player {
	private String name;
	private int score;
	
	/**
	 * Constructor ce intializeaza campurile clasei
	 * @param name numele jucatorului
	 * @param score scorul jucatorului
	 */
	public Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getScore() {
		return this.score;
	}
	
}

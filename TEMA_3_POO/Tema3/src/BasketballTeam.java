
/** @author  Chirila Albert */
public class BasketballTeam extends Team {
	
	/**
	 * Constructor ce initializeaza campurile clasei parinte
	 * @param type tipul de echipa
	 * @param teamName numele echipei
	 * @param gender genul persoanelor dintr-o echipa
	 * @param numberOfPlayers numarul de jucatori
	 */
	public BasketballTeam(String type, String teamName, String gender, int numberOfPlayers) {
		super(type, teamName, gender, numberOfPlayers);
	}
}

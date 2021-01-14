
/** @author Chirila Albert */
public class TeamFactory {
	private static TeamFactory instance;
	
	private TeamFactory() {}
	
	/**
	 * Design pattern-ul Singleton
	 * @return instanta creata
	 */
	public static TeamFactory getInstance() {
		if(instance == null) {
			instance = new TeamFactory();
		}
		return instance;
	}
	
	/**
	 * Design pattern-ul Factory
	 * @param type tipul de echipa
	 * @param teamName numele echipei
	 * @param gender genul persoanelor din echipa
	 * @param numberOfPlayers numarul de jucatori din echipa
	 * @return echipa creata
	 */
	public Team create(TeamType type, String teamName, String gender, int numberOfPlayers) {
		Team team = null;
		if(type.equals(TeamType.football)) {
			team = new FootballTeam("football", teamName, gender, numberOfPlayers);
		}
		else if(type.equals(TeamType.basketball)) {
			team = new BasketballTeam("basketball", teamName, gender, numberOfPlayers);
		}
		else if(type.equals(TeamType.handball)) {
			team = new HandballTeam("handball", teamName, gender, numberOfPlayers);
		}
		
		return team;
	}
}

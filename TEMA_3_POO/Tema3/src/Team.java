import java.util.ArrayList;

/** @author  Chirila Albert */
public class Team implements Element, Observer {
	private String type;
	private String teamName;
	private String gender;
	private int numberOfPlayers;
	private ArrayList<Player> players;
	private int points;
	private int position;
	
	/** Constructor default */
	public Team() {}
	
	/**
	 * Constructor ce intializeaza campurile clasei
	 * @param type tipul de echipa
	 * @param teamName numele echipei
	 * @param gender genul persoanelor din echipa
	 * @param numberOfPlayers numarul de jucatori
	 */
	public Team(String type, String teamName, String gender, int numberOfPlayers) {
		this.type = type;
		this.players = new ArrayList<Player>();
		this.teamName = teamName;
		this.gender = gender;
		this.numberOfPlayers = numberOfPlayers;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getTeamName() {
		return this.teamName;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public int getNumberOfPlayers() {
		return this.numberOfPlayers;
	}
	
	public ArrayList<Player> getList(){
		return this.players;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public double accept(Visitor visitor) {
		return visitor.visit(this);
	}
	
	public void update(int points) {
		this.points += points;
	}
	
}

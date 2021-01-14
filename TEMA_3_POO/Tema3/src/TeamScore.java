import java.util.ArrayList;

/** @author  Chirila Albert */
public class TeamScore implements Visitor {
	
	/** Metoda calculeaza scorul echipei corespunzatoare */
	public double visit(Team team) {
		double total = 0;
		if(team.getType().equals("football") && team.getGender().equals("masculin")) {
			total = (2 * maxim(team.getList())) + sum(team.getList()) - maxim(team.getList());
		}
		else if(team.getType().equals("football") && team.getGender().equals("feminin")) {
			total = (2 * minim(team.getList())) + sum(team.getList()) - minim(team.getList());
		}
		else if(team.getType().equals("basketball")) {
			total = average(team.getList());
		}
		else if(team.getType().equals("handball") && team.getGender().equals("masculin")) {
			total = sum(team.getList());
		}
		else if(team.getType().equals("handball") && team.getGender().equals("feminin")) {
			total = multi(team.getList());
		}
		
		return total;
	}
	
	/**
	 * Metoda calculeaza scorul maxim dintr-o echipa
	 * @param players lista jucatorilor dintr-0 echipa
	 * @return scorul maxim
	 */
	public int maxim(ArrayList<Player> players) {
		int maxim = 0;
		for(Player player : players) {
			if(player.getScore() > maxim)
				maxim = player.getScore();
		}
		return maxim;
	}
	
	/**
	 * Metoda calculeaza scorul minim dintr-o echipa
	 * @param players lista jucatorilor dintr-0 echipa
	 * @return scorul minim
	 */
	public int minim(ArrayList<Player> players) {
		int minim = players.get(0).getScore();
		for(Player player : players) {
			if(player.getScore() < minim)
				minim = player.getScore();
		}
		return minim;
	}
	
	/**
	 * Metoda calculeaza media scorurilor jucatorilor
	 * @param players lista jucatorilor dintr-0 echipa
	 * @return media scorurilor
	 */
	public double average(ArrayList<Player> players) {
		double sum = sum(players);
		double score = sum / players.size();
		return score;
	}
	
	/**
	 * Metoda calculeaza suma scorurilor jucatorilor
	 * @param players lista jucatorilor dintr-0 echipa
	 * @return suma scorurilor
	 */
	public int sum(ArrayList<Player> players) {
		int sum = 0;
		for(Player player : players) {
			sum += player.getScore();
		}
		return sum;
	}
	
	/**
	 * Metoda calculeaza produsul scorurilor jucatorilor
	 * @param players lista jucatorilor dintr-0 echipa
	 * @return produsul scorurilor
	 */
	public int multi(ArrayList<Player> players) {
		int p = 1;
		for(Player player : players) {
			p *= player.getScore();
		}
		return p;
	}
}


/** @author  Chirila Albert */
public interface Visitor {
	/**
	 * Metoda visiteaza echipa si calculeaza scorul
	 * @param team echipa vizitata
	 * @return scrul unei echipe
	 */
	public double visit(Team team);
}

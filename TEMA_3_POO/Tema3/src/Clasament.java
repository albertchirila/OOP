
/** @author  Chirila Albert */
public interface Clasament {
	
	/** @param team echipa ce urmeaza a fi adaugata in clasament */
	public void registerObserver(Team team);
	public void notifyObserver();
}

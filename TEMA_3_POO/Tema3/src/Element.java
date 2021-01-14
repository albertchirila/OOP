
/** @author  Chirila Albert */
public interface Element {
	/**
	 * Metoda returneaza scorul unei echipe
	 * @param visitor vizitatorul unei echipe
	 * @return scorul unei echipe
	 */
	public double accept(Visitor visitor);
}

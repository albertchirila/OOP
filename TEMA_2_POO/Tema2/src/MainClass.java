import java.io.IOException;

/**	Programul simuleaza incalzirea unei locuinte, cu ajutorul senzorilor de temperatura si prelucrarea
 *  informatiilor date de acestia.
 *  @author Chirila Albert 
 * */
public class MainClass {

	/**
	 * Ruleaza programul
	 * @param args argumentele metodei main
	 */
	public static void main(String[] args) {
		
		ReadFile file = new ReadFile();
		try {
			file.read();
		} catch (IOException e) {
			System.out.println("Cannot read from file!");
		}
		
	}

}
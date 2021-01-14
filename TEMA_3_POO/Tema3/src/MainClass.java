import java.io.IOException;

/**
 * Programul simuleaza o competitie. Acesta poate inscrie echipele si poate gestiona meciurile si rezultatele, 
 * prezentand clasamentul final la incheierea competitiei. 
 * @author Chirila Albert
 * @version 1.0
 */
public class MainClass {

	/**
	 * Metoda apeleaza citirea din fisier si ruleaza programul
	 * @param args argumentele metodei main
	 */
	public static void main(String[] args) {
		ReadFile read = new ReadFile();
		try {
			read.read(args[0], args[1], args[2], args[3]);
		} catch (IOException e) {
			System.out.println("CAN NOT READ");
		}
	}

}

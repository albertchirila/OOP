import java.io.*;

/** @author Chirila Albert */
public class WriteFile {
	/**
	 * Metoda ce scrie in fisierul de output
	 * @param s String ce urmeaza a fi scrisa in fisierul "therm.out"
	 * @throws IOException eroare la scrierea in fisierul "therm.out"
	 */
	public void write(String s) throws IOException {
		String file = "src/therm.out";
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(s);
		bw.close();
	}
}
